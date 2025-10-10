package myau.ui.screen.code;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JavaSourceCompiler {

    public static JavaSourceCompiler instance;

    private final JavaCompiler compiler;

    private final File output = new File("./myau/classes");

    public JavaSourceCompiler() {
        this.compiler = ToolProvider.getSystemJavaCompiler();

        if (compiler == null) {
            throw new IllegalStateException("Java compiler not found");
        }

        if (!output.exists()) {
            output.mkdirs();
        }
    }

    public static JavaSourceCompiler getInstance() {
        if (instance == null) {
            instance = new JavaSourceCompiler();
        }
        return instance;
    }

    public Object compile(String className, String code) throws IOException, ClassNotFoundException {
        if (className == null) return null;

        Iterable<String> options = Arrays.asList("-d", output.getAbsolutePath());

        MyJavaFileObject object = new MyJavaFileObject(className, code);

        ArrayList<MyJavaFileObject> list = new ArrayList<>();
        list.add(object);

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, StandardCharsets.UTF_8);

        JavaCompiler.CompilationTask task = compiler.getTask(
                null,
                fileManager,
                diagnostics,
                options,
                null,
                list
        );

        boolean success = task.call();
        fileManager.close();

        if (success) {
            try (URLClassLoader classLoader = new URLClassLoader(
                    new URL[]{output.toURI().toURL()},
                    this.getClass().getClassLoader()
            )) {
                Class<?> loadClass = classLoader.loadClass(className);
                return loadClass.getDeclaredConstructor().newInstance();
            } catch (InvocationTargetException | IllegalAccessException | InstantiationException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }
}

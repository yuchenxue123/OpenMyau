package myau.ui.screen.code;

import javax.tools.SimpleJavaFileObject;
import java.net.URI;

public class MyJavaFileObject extends SimpleJavaFileObject {

    private final String code;

    protected MyJavaFileObject(String className, String code) {
        super(URI.create("string:///" + className + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}

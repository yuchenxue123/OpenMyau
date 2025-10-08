package myau.module;

import myau.Myau;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    COMBAT(0),
    MOVEMENT(1),
    PLAYER(2),
    RENDER(3),
    MISC(4)

    ;

    public final int id;

    Category(int id) {
        this.id = id;
    }

    public List<Module> getModules() {
        return Myau.moduleManager.modules.values().stream()
                .filter(m -> m.getCategory() == this)
                .sorted(Comparator.comparing(Module::getName))
                .collect(Collectors.toList());
    }
}

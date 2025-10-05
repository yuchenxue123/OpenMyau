package myau.ui.setting;

public interface Setting<T> {

    String name();

    T value();

    void set(T value);

}

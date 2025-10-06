package myau.ui.setting;

public interface ModeSetting extends Setting<Integer> {

    String getMode();

    String[] modes();

    void next();

    void prev();

}

package myau.ui.data;

public interface MutablePosition extends Position {

    void setX(int x);

    void setY(int y);

    void set(int x, int y);

    void set(Position position);

}

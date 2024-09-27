public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be a positive");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0) {
            throw new IllegalArgumentException("y must be a positive");
        }
        this.y = y;
    }
}

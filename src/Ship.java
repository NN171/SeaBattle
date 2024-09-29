public class Ship {

    private int length;
    private Coordinates initCoordinates;
    private Coordinates finalCoordinates;
    private int direction;

    public Ship(int length, Coordinates initCoordinates) {
        this.length = length;
        this.initCoordinates = initCoordinates;
    }

    public int getLength() {
        return length;
    }

    public Coordinates getInitCoordinates() {
        return initCoordinates;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setFinalCoordinates(Coordinates finalCoordinates) {
        this.finalCoordinates = finalCoordinates;
    }

    public Coordinates getFinalCoordinates() {
        return finalCoordinates;
    }
}

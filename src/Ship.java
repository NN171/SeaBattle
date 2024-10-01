public class Ship {

    private int length;
    private Coordinates initCoordinates;
    private Coordinates finalCoordinates;
    private int direction;
    private boolean[] deckHits;
    private int deckCounter = 0;

    public Ship(int length, Coordinates initCoordinates, int direction) {
        this.length = length;
        this.initCoordinates = initCoordinates;
        setDirection(direction);
        this.deckHits = new boolean[length];
    }
    public Ship(int length, Coordinates initCoordinates) {
        this.length = length;
        this.initCoordinates = initCoordinates;
        this.deckHits = new boolean[length];
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

    public boolean isDestroyed() {
        for (boolean hit : deckHits) {
            if (!hit) {
                return false;
            }
        }
        return true;
    }

    public void hit() {
        deckHits[deckCounter++] = true;
    }

    public int getDirection() {
        return direction;
    }
}

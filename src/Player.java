public class Player {

    private Field field;
    private int aliveShips = 10;

    public Player() {
        field = new Field();
    }

    public Field getField() {
        return field;
    }
}

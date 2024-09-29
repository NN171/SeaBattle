import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    private Field field;
    private int aliveShips;
    private List<Integer> shipsLength;

    public Player() {
        field = new Field();
        aliveShips = 10;
        shipsLength = Arrays.asList(4, 3, 3, 2, 2, 2, 1, 1, 1, 1);
    }

    public Field getField() {
        return field;
    }

    public int getAliveShips() {
        return aliveShips;
    }

    public void destroyShip() {
        aliveShips--;
    }

    public int getShipsLength(int index) {
        return shipsLength.get(index);
    }
}

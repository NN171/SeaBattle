import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {

    private List<Ship> ships;
    private Random rand;
    private FieldGenerator generator;

    Field() {
        generator = new FieldGenerator();
        generator.generateField();
        ships = new ArrayList<Ship>();
    }

    public void setShip(Ship ship) {
        int direction = ship.getDirection();
        int x = ship.getInitCoordinates().getX();
        int y = ship.getInitCoordinates().getY();
        int shipLength = ship.getLength();

        if (direction == 1) ship.setFinalCoordinates(new Coordinates(x + shipLength, y));
        else if (direction == 2) ship.setFinalCoordinates(new Coordinates(x, y + shipLength));


        generator.updateField(ship);
        ships.add(ship);
    }

    public void printOpponentField() {
        generator.printClearField();
    }

    public void printField() {
        generator.printField();
    }

    public boolean shoot(Coordinates coordinates) {
        for (Ship ship : ships) {
            if (isHit(ship, coordinates)) {
                ship.hit();
            }
        }
        return generator.shoot(coordinates);
    }

    public boolean isHit(Ship ship, Coordinates coordinates) {
        int xInit = ship.getInitCoordinates().getX();
        int yInit = ship.getInitCoordinates().getY();
        int xFinal = ship.getFinalCoordinates().getX();
        int yFinal = ship.getFinalCoordinates().getY();

        int x = coordinates.getX();
        int y = coordinates.getY();

        if (xInit == xFinal) {
            return xInit == x && y >= Math.min(yInit, yFinal) && y <= Math.max(yInit, yFinal);
        }
        else {
            return yInit == y && x >= Math.min(xInit, xFinal) && x <= Math.max(xInit, xFinal);
        }
    }

    public List<Ship> getShips() {
        return ships;
    }
}

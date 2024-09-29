import java.util.List;
import java.util.Random;

public class Field {

    private List<Ship> ships;
    private Random rand;
    private FieldGenerator generator = new FieldGenerator();

    Field() {
        generator.generateField();
    }

    public void setShip(Ship ship) {
        rand = new Random();
        int direction = rand.nextInt(0, 1);
        ship.setDirection(direction);
        int x = ship.getInitCoordinates().getX();
        int y = ship.getInitCoordinates().getY();
        int shipLength = ship.getLength();

        switch (direction) {
            case 0 -> {
                int sumX = x + shipLength;

                if (sumX > 10) {
                    ship.setFinalCoordinates(new Coordinates(x - shipLength, y));
                }
                else {
                    ship.setFinalCoordinates(new Coordinates(x + shipLength, y));
                }
            }

            case 1 -> {
                int sumY = y + shipLength;

                if (sumY > 10) {
                    ship.setFinalCoordinates(new Coordinates(x, y - shipLength));
                }
                else {
                    ship.setFinalCoordinates(new Coordinates(x, y + shipLength));
                }
            }
        }
        generator.updateField(ship);
    }

    public void printField() {
        generator.printField();
    }
}

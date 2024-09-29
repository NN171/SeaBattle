public class Main {
    public static void main(String[] args) {

//        Player firstPlayer = new Player();
//        Player secondPlayer = new Player();

        Field field = new Field();
        //fieldGenerator.generateField();
        Ship ship = new Ship(4, new Coordinates(3, 5));
        field.setShip(ship);
        field.printField();
        //firstPlayer.getField();
    }
}
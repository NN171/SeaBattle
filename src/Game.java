import java.util.Scanner;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player opponent;
    private Player currentPlayer;
    Scanner sc = new Scanner(System.in);

    public Game() {
        firstPlayer = new Player();
        secondPlayer = new Player();
    }

    public void startGame() {
        System.out.println("Установка кораблей для Игрока 1");
        System.out.println("Нажмите Enter, чтобы продолжить");
        sc.nextLine();
        setShips(firstPlayer);

        System.out.println("Установка кораблей для Игрока 2");
        System.out.println("Нажмите Enter, чтобы продолжить");
        sc.nextLine();
        setShips(secondPlayer);

        System.out.println("Бой!");

        boolean firstIsAlive = firstPlayer.getAliveShips() > 0;
        boolean secondIsAlive = secondPlayer.getAliveShips() > 0;

        while (firstIsAlive && secondIsAlive) {
            takeShoot();
            switchSides();
        }

        if (firstIsAlive) System.out.println("Игрок 1 выиграл!");
        else System.out.println("Игрок 2 выиграл!");
    }

    private void setShips(Player player) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Введите координату оси X: ");
            int x = Integer.parseInt(sc.nextLine());

            System.out.print("Введите координату оси Y: ");
            int y = Integer.parseInt(sc.nextLine());
            int length = firstPlayer.getShipsLength(i);

            Ship ship = new Ship(length, new Coordinates(x+1, y+1));
            player.getField().setShip(ship);
        }
    }

    private void takeShoot() {
        System.out.print("Введите координату оси X: ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("Введите координату оси Y: ");
        int y = Integer.parseInt(sc.nextLine());

        boolean isHit = opponent.getField().shoot(new Coordinates(x, y));

        if (isHit) {
            System.out.println("Попадание!");
            takeShoot();
        }
        else System.out.println("Промах!");
    }

    public void switchSides() {
        if (currentPlayer.equals(firstPlayer)) {
            currentPlayer = secondPlayer;
            opponent = firstPlayer;
        }
        else {
            currentPlayer = firstPlayer;
            opponent = secondPlayer;
        }
    }
}

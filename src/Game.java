import java.util.Scanner;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player opponent;
    private Player currentPlayer;
    Scanner sc = new Scanner(System.in);

    public void startGame() {
        System.out.println("Установка кораблей для Игрока 1");
        System.out.println("Нажмите Enter, чтобы продолжить");
        sc.nextLine();

        firstPlayer = new Player();
        currentPlayer = firstPlayer;
        System.out.println();
        setShips(firstPlayer);

        System.out.println("Установка кораблей для Игрока 2");
        System.out.println("Нажмите Enter, чтобы продолжить");
        sc.nextLine();

        secondPlayer = new Player();
        opponent = secondPlayer;
        System.out.println();
        setShips(secondPlayer);

        System.out.println("Бой!");

        while (firstPlayer.isAlive() && secondPlayer.isAlive()) {
            takeShoot();
            switchSides();
        }

        if (firstPlayer.isAlive()) System.out.println("Игрок 1 выиграл!");
        else System.out.println("Игрок 2 выиграл!");
    }

    private void setShips(Player player) {
        for (int i = 0; i < 10; i++) {
            int direction = 1;
            System.out.print("Введите начальную координату оси X: ");
            int xInit = Integer.parseInt(sc.nextLine());

            System.out.print("Введите начальную координату оси Y: ");
            int yInit = Integer.parseInt(sc.nextLine());

            if (i < 6) {
                System.out.print("""
                        Выберите направление корабля:
                        1 - Вертикальная
                        2 - Горизонтальная
                        """);
                direction = Integer.parseInt(sc.nextLine());
            }

            int length = firstPlayer.getShipsLength(i);

            Ship ship = new Ship(length, new Coordinates(yInit, xInit), direction);
            player.getField().setShip(ship);
            player.getField().printField();
            System.out.println();
        }
    }

    private void takeShoot() {
        if (currentPlayer.equals(firstPlayer)) System.out.println("Очередь Игрока 1");
        else System.out.println("Очередь Игрока 2");
        opponent.getField().printOpponentField();

        System.out.print("Введите координату оси X: ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("Введите координату оси Y: ");
        int y = Integer.parseInt(sc.nextLine());

        boolean isHit = opponent.getField().shoot(new Coordinates(y, x));

        if (isHit) {
            System.out.println("Попадание!");
            for (Ship ship : opponent.getField().getShips()) {
                if (ship.isDestroyed()) {
                    System.out.println("Корабль уничтожен!");
                    opponent.destroyShip();
                }
            }
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

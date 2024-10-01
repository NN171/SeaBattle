public class FieldGenerator {

    private final int height = 10;
    private final int width = 10;
    private String[][] field = new String[height+1][width+1];

    public void generateField() {
        generateHeader();
        generateLine();
        printField();
    }

    private void generateHeader() {
        field[0][0] = "";
        for (int i = 1; i <= width; i++) {;
            field[0][i] = "\t" + i;
        }
    }

    private void generateLine() {
        for (int i = 1; i < width+1; i++) {
            field[i][0] = Integer.toString(i);
            for (int j = 1; j < height+1; j++) {
                field[i][j] = "\t" + "O";
            }
        }
    }

    public void printField() {
        for (int i = 0; i < height+1; i++) {
            for (int j = 0; j < width+1; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public void updateField(Ship ship) {
        int xInit = ship.getInitCoordinates().getX();
        int yInit = ship.getInitCoordinates().getY();
        int xFinal = ship.getFinalCoordinates().getX();

        for (int i = 0; i < ship.getLength(); i++) {

            if (xInit == xFinal) {
                field[xInit][yInit] = field[xInit][yInit++].replace("O", "X");
            }
            else
                field[xInit][yInit] = field[xInit++][yInit].replace("O", "X");
        }
    }

    public void printClearField() {
        for (int i = 0; i < height+1; i++) {
            for (int j = 0; j < width+1; j++) {
                if (field[i][j].contains("X")) {
                    System.out.print("\tO");
                }
            }
        }
    }

    public boolean shoot(Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();

        if (field[x][y].contains("X")) {
            field[x][y] = field[x][y].replace("X", "H");
            return true;
        }
        else if (field[x][y].contains("O")) {
            field[x][y] = field[x][y].replace("O", "M");
        }

        return false;
    }
}

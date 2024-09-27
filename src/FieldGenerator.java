public class FieldGenerator {

    private final int height = 10;
    private final int width = 10;

    public void generateField() {
        StringBuilder sb = new StringBuilder();

        System.out.println(generateHeader(sb));
        sb.delete(0, sb.length());

        printField(generateLine(sb));
    }

    private String generateHeader(StringBuilder sb) {
        char header = 'А';
        for (int i = 0; i < width; i++) {
            if (i == width - 1) header++;
            sb.append("\t").append(header++);
        }

        return sb.toString();
    }

    private StringBuilder generateLine(StringBuilder sb) {
        sb.append("1");
        for (int i = 0; i < width; i++) {
            sb.append("\t").append("O");
        }

        return sb;
    }

    private void printField(StringBuilder sb) {
        for (int i = 1; i <= height; i++) {
            System.out.println(sb.replace(0, 1, Integer.toString(i)));
        }
    }
}

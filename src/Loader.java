
public class Loader {
    public static void main(String[] args) {
        String text = "    Вася заработал 504500 рублей, Петя - 7563 рубля, а Маша - 30000";
        char space = ' ';

        /*String numberOnly = text.replaceAll("[^0-9]", "");
        System.out.println(numberOnly);*/

        printWithIndexes(text);
        System.out.print("Сумма зароботка всех ребят составляет: " + sumNumbers(text, space) + " рублей");
    }

    private static int sumNumbers(String text, char part) {
        text = text.trim();
        int startIndex = 0;
        int endIndex = 0;
        String searchNumbers;
        int sumNumbers = 0;
        while (startIndex != -1) {
            startIndex = text.indexOf(part, endIndex);
            endIndex = text.indexOf(part, startIndex + 1);
            if (endIndex == -1) {
                endIndex = text.length();
            }
            searchNumbers = text.substring(startIndex + 1, endIndex);
            if (isNumber(text)) {
                sumNumbers += Integer.parseInt(searchNumbers);
            }
        }
        return sumNumbers;
    }

    private static boolean isNumber(String checkNumber) {
        try {
            Integer.parseInt(checkNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void printWithIndexes(String string) {
        StringBuilder letters = new StringBuilder("char: ");
        StringBuilder indexes = new StringBuilder("index:");
        for (int i = 0; i < string.trim().length(); i++) {
            letters.append(String.format("%3s", string.trim().charAt(i)));
            indexes.append(String.format("%3d", i));
        }
        System.out.println(letters);
        System.out.println(indexes.append(System.lineSeparator()));
    }
}
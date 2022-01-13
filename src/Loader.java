
public class Loader {
    public static void main(String[] args) {
        String text = "    Вася  заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей     ";
        char part = ' ';



        /*String numberOnly = text.replaceAll("[^0-9]", "");
        System.out.println(numberOnly);*/

        printWithIndexes(text);
        System.out.print("Сумма зароботка всех ребят составляет: ");
        System.out.println(sumNumbers(text, part));

    }

    private static int sumNumbers(String text, char part) {
        text = text.trim();
        int startIndex = 0;
        int endIndex = 0;
        String serchNumbers;
        int numbers = 0;
        while (!(startIndex == -1)) {
            startIndex = text.indexOf(part, endIndex);
            endIndex = text.indexOf(part, startIndex + 1);
            if (endIndex == -1) {
                endIndex = text.length();
            }
            serchNumbers = text.substring(startIndex + 1, endIndex);
            try {
                numbers += Integer.parseInt(serchNumbers);
            } catch (NumberFormatException nfe) {
                numbers += 0;
            }
        }
        return numbers;
    }


    private static void printWithIndexes(String string) {
        StringBuilder letters = new StringBuilder("char: ");
        StringBuilder indexes = new StringBuilder("index:");
        for (int i = 0; i < string.length(); i++) {
            letters.append(String.format("%3s", string.charAt(i)));
            indexes.append(String.format("%3d", i));
        }
        System.out.println(letters);
        System.out.println(indexes.append(System.lineSeparator()));
    }
}
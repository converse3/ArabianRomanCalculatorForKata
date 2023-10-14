import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int val1, val2;
    static char op;
    static int result;
    static String formattedResult;

    public static void main (String[] args) {
        System.out.println("Введите выражение в арабском формате(1-10) или в римском формате(I-X) без разделения знаков:");
        String userInput = scanner.nextLine();
        char[] sign = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            sign[i] = userInput.charAt(i);
            if (sign[i] == '-') {
                op = '-';
            } else if (sign[i] == '+') {
                op = '+';
            } else if (sign[i] == '/') {
                op = '/';
            } else if (sign[i] == '*') {
                op = '*';
            }
        }
        String signStr = String.valueOf(sign);
        String[] blacks = signStr.split("[+-/*]");
        String first = blacks[0];
        String second = blacks[1];
        String string3 = second.trim();
        val1 = romanToNum(first);
        val2 = romanToNum(string3);
        if (val1 < 0 && val2 < 0) {
            result = 0;
        } else {
            result = calculated(val1, val2, op);
            System.out.println("~Римский формат счета~");
            String resultRoman = convertNumToRoman(result);
            formattedResult = MessageFormat.format("{0} {1} {2} = {3}", first, op, string3, resultRoman);
            System.out.println(formattedResult);
        }
        try {
            val1 = Integer.parseInt(first);
            val2 = Integer.parseInt(string3);
            result = calculated(val1, val2, op);
            System.out.println("~Арабский формат счета~");
            formattedResult = MessageFormat.format("{0} {1} {2} = {3}", val1, op, val2, result);
            System.out.println(formattedResult);
        } catch (NumberFormatException e) {
            System.out.println();
        }
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII",
                "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
                "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        final String str = roman[numArabian];
        return str;
    }


    private static int romanToNum (String roman) {
        try {
            switch (roman) {
                case "I" -> {
                    return 1;
                }
                case "II" -> {
                    return 2;
                }
                case "III" -> {
                    return 3;
                }
                case "IV" -> {
                    return 4;
                }
                case "V" -> {
                    return 5;
                }
                case "VI" -> {
                    return 6;
                }
                case "VII" -> {
                    return 7;
                }
                case "VIII" -> {
                    return 8;
                }
                case "IX" -> {
                    return 9;
                }
                case "X" -> {
                    return 10;
                }
            }

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Некорректный формат значений");
        }
        return -1;
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Ошибка: " + e);
                    System.out.println("Разрешены параметры, не равные нулю");
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Неверное значение операции");
        }
        return result;
    }
}
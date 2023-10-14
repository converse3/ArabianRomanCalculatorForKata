import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int val1, val2;
    static char op;
    static int result;

    public static void main (String[] args) {
        System.out.println("Введите выражение в арабском формате(1-10) или в римском формате от I до X без разделения знаков:");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                op = '+';
            }
            if (under_char[i] == '-') {
                op = '-';
            }
            if (under_char[i] == '*') {
                op = '*';
            }
            if (under_char[i] == '/') {
                op = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        val1 = romanToNum(stable00);
        val2 = romanToNum(string03);
        if (val1 < 0 && val2 < 0) {
            result = 0;
        } else {
            result = calculated(val1, val2, op);
            System.out.println("-Римский формат счета-");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable00 + " " + op + " " + string03 + " = " + resultRoman);
        }
        try {
            val1 = Integer.parseInt(stable00);
            val2 = Integer.parseInt(string03);
            result = calculated(val1, val2, op);
            System.out.println("-Арабский формат счета-");
            System.out.println(val1 + " " + op + " " + val2 + " = " + result);
        } catch (NumberFormatException e) {
            System.out.println("");
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
        final String s = roman[numArabian];
        return s;
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
                throw new IllegalArgumentException("Неверный значение операции");
        }
        return result;
    }
}
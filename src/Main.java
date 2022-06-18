import java.util.Scanner;

public class Main {
    static private final String[] romanNumeralsList = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

    public static void main(String[] args) {
        System.out.println("Введите выражение:  (для выхода наберите exit)");
        Scanner console = new Scanner(System.in);
        String enter = console.nextLine();
        if (enter.equals("exit")) {
            return;
        }
        try {
            String result = calc(enter);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        main(args);
    }

    public static String calc(String input) throws Exception {
        char[] sim = input.toCharArray();
        boolean sum = false, minus = false, umn = false, del = false;
        for (char element : sim) {
            if (element == '+') {
                sum = true;
            } else if (element == '-') {
                minus = true;
            } else if (element == '*') {
                umn = true;
            } else if (element == '/') {
                del = true;
            }
        }
        if (sum && !minus && !umn && !del) {
            String[] peremen = input.split("[+]");
            if (peremen.length == 2) {
                String a = peremen[0].trim();
                String b = peremen[1].trim();
                if (isNumeric(a) && isNumeric(b)) {
                    int number1 = Integer.parseInt(a), number2 = Integer.parseInt(b);
                    if (number1 <= 10 && number1 > 0 && number2 <= 10 && number2 > 0) {
                        int result = number1 + number2;
                        return String.valueOf(result);
                    } else throw new Exception("Числа не удовлетворяют входным условиям");
                }
                int result = romanToNumber(a) + romanToNumber(b);
                return numToRoman(result);
            } else throw new Exception("Больше двух переменных");
        } else if (minus && !sum && !umn && !del) {
            String[] peremen = input.split("-");
            if (peremen.length == 2) {
                String a = peremen[0].trim();
                String b = peremen[1].trim();
                if (isNumeric(a) && isNumeric(b)) {
                    int number1 = Integer.parseInt(a), number2 = Integer.parseInt(b);
                    if (number1 <= 10 && number1 > 0 && number2 <= 10 && number2 > 0) {
                        int result = number1 - number2;
                        return String.valueOf(result);
                    } else throw new Exception("Числа не удовлетворяют входным условиям");
                }
                int result = romanToNumber(a) - romanToNumber(b);
                return numToRoman(result);
            } else throw new Exception("Больше двух переменных");
        } else if (umn && !minus && !sum && !del) {
            String[] peremen = input.split("[*]");
            int cper = peremen.length;
            if (cper == 2) {
                String a = peremen[0].trim();
                String b = peremen[1].trim();
                if (isNumeric(a) && isNumeric(b)) {
                    int number1 = Integer.parseInt(a), number2 = Integer.parseInt(b);
                    if (number1 <= 10 && number1 > 0 && number2 <= 10 && number2 > 0) {
                        int result = number1 * number2;
                        return String.valueOf(result);
                    } else throw new Exception("Числа не удовлетворяют входным условиям");
                }
                int result = romanToNumber(a) * romanToNumber(b);
                return numToRoman(result);
            } else throw new Exception("Больше двух переменных");
        } else if (del && !minus && !sum && !umn) {
            String[] peremen = input.split("/");
            int cper = peremen.length;
            if (cper == 2) {
                String a = peremen[0].trim();
                String b = peremen[1].trim();
                if (isNumeric(a) && isNumeric(b)) {
                    int number1 = Integer.parseInt(a), number2 = Integer.parseInt(b);
                    if (number1 <= 10 && number1 > 0 && number2 <= 10 && number2 > 0) {
                        int result = number1 / number2;
                        return String.valueOf(result);
                    } else throw new Exception("Числа не удовлетворяют входным условиям");
                }
                int result = romanToNumber(a) / romanToNumber(b);
                return numToRoman(result);
            } else throw new Exception("Больше двух переменных");
        } else throw new Exception("Больше двух знаков, либо нет вовсе");
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int romanToNumber(String roman) throws Exception {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception("Должны быть введены римские числа от I до X, либо арабские от 1 до 10");
        };
    }

    private static String numToRoman(int numArabian) throws Exception {

        if (numArabian == 0) {
            throw new Exception("Римские числа должны быть > 0");
        }
        return romanNumeralsList[numArabian];
    }
}
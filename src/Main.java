import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) throws Exception {
        Scanner input = new Scanner(System.in);
        String x;
        System.out.println("Введите ваше выражение. Учтите, что калькулятор" +
                "\nможет работать только с числами одной СС в диапазоне от 0 до 10");
        x = Calculate.calc(input.nextLine());
        System.out.println("Результат вычисления: " + x);
    }
}


class Calculate {
    public static String calc(String input) throws Exception {
        int a = 0, b = 0, sum;
        boolean t = false;

        String[] operand = input.split(" ");

        if (operand.length != 3) {
            throw new Exception("Введите корректное выражение (Пример 2 + 2 или II + II)");
        }


        if (Proverka.pr(operand[0]) && Proverka.pr(operand[2])) {
            for (Roman element : Roman.values()) {
                if (element.name().equals(operand[0])) {
                    a = Roman.valueOf(operand[0]).getRom();
                }
                if (element.name().equals(operand[2])) {
                    b = Roman.valueOf(operand[2]).getRom();
                }
            }
            t = true;
        } else if (Proverka.pr(operand[0]) || Proverka.pr(operand[2])) {
            throw new Exception("Калькулятор может работать ТОЛЬКО с числами одной СС и в диапазоне от 0 до 10");
        } else {
            a = Integer.parseInt(operand[0]);
            b = Integer.parseInt(operand[2]);
            if (a < 0 || b < 0 || a > 10 || b > 10) {
                throw new Exception("Калькулятор может работать с числами в диапазоне от 0 до 10");
            }
        }


        switch (operand[1]) {
            case "+" -> sum = a + b;
            case "-" -> sum = a - b;
            case "*" -> sum = a * b;
            case "/" -> sum = a / b;
            default -> throw new Exception("Введите корректую операцию");
        }

        String z;
        if (t) {
            if (sum < 0 || sum == 0) {
                throw new Exception("В римской СС нельзя получить ноль или отрицательный результат");
            }
            int k, m;
            k = (sum / 10) * 10;
            m = sum % 10;
            String o = "", p = "";
            for (Roman element : Roman.values()) {
                String y = element.name();
                if (Roman.valueOf(y).getRom() == k) {
                    o = element.name();
                }
                if (Roman.valueOf(y).getRom() == m) {
                    p = element.name();
                }
            }
            z = o + p;
            System.out.println(o + p);
        } else {
            z = String.valueOf(sum);
        }
        return z;
    }
}


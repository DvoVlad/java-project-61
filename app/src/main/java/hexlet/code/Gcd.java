package hexlet.code;

import java.util.Scanner;

public class Gcd {
    private static String correctResult = "";
    private static String answer = "";

    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello," + name);
        System.out.println("Find the greatest common divisor of given numbers.");
        int score = 0;
        while (score < 3) {
            if (gameStep()) {
                score++;
                System.out.println("Correct!");
            } else {
                break;
            }
        }
        if (score == 3) {
            System.out.println("Congratulations," + name);
        } else {
            System.out.println(
                    "'"
                            + Gcd.answer
                            + "' is wrong answer ;(. Correct answer was '"
                            + Gcd.correctResult
                            + "'.");
            System.out.println("Let's try again, " + name);
        }
    }

    public static boolean gameStep() {
        int number1 = (int) (Math.random() * 100);
        int number2 = (int) (Math.random() * 100);
        System.out.println("Question: " + number1 + " " + number2);

        Scanner scanner = new Scanner(System.in);
        Gcd.answer = scanner.nextLine();
        System.out.println("Your answer: " + Gcd.answer);
        Gcd.correctResult = String.valueOf(Gcd.getGCD(number1, number2));
        return Gcd.correctResult.equals(Gcd.answer);
    }

    public static int getGCD(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return Math.abs(a);
    }
}

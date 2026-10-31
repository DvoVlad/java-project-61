package hexlet.code.games;

import java.util.Scanner;

public class Prime {
    private static String correctResult = "";
    private static String answer = "";

    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        int score = 0;
        int countGamesScore = 3;
        while (score < countGamesScore) {
            if (gameStep()) {
                score++;
                System.out.println("Correct!");
            } else {
                break;
            }
        }
        if (score == countGamesScore) {
            System.out.println("Congratulations, " + name + "!");
        } else {
            System.out.println(
                    "'"
                            + Prime.answer
                            + "' is wrong answer ;(. Correct answer was '"
                            + Prime.correctResult
                            + "'.");
            System.out.println("Let's try again, " + name + "!");
        }
    }

    public static boolean gameStep() {
        int number = (int) (Math.random() * 100);
        System.out.println("Question: " + number);
        Scanner scanner = new Scanner(System.in);
        Prime.answer = scanner.nextLine();
        Prime.correctResult = isPrime(number) ? "yes" : "no";
        System.out.println("Your answer: " + answer);
        return Prime.correctResult.equals(Prime.answer);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }
        if (number < 2 || isEven(number)) {
            return false;
        }
        int limit = (int) Math.sqrt(number);
        for (int i = 3; i <= limit; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

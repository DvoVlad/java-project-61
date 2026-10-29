package hexlet.code;

import java.util.Scanner;

public class Even {
    private static String correctResult = "";
    private static String answer = "";

    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello," + name);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
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
                            + Even.answer
                            + "' is wrong answer ;(. Correct answer was '"
                            + Even.correctResult
                            + "'.");
            System.out.println("Let's try again, " + name);
        }
    }

    public static boolean gameStep() {
        int number = (int) (Math.random() * 100);
        System.out.println("Question: " + number);
        Scanner scanner = new Scanner(System.in);
        Even.answer = scanner.nextLine();
        Even.correctResult = isEven(number) ? "yes" : "no";
        System.out.println("Your answer: " + answer);
        return Even.correctResult.equals(Even.answer);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

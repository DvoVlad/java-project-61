package hexlet.code.games;

import java.util.Scanner;

public class Calc {
    private static String correctResult = "";
    private static String answer = "";

    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
        System.out.println("What is the result of the expression?");
        int countGamesScore = 3;
        int score = 0;
        while (score < countGamesScore) {
            if (gameStep()) {
                score++;
                System.out.println("Correct!");
            } else {
                break;
            }
        }
        if (score == countGamesScore) {
            System.out.println("Congratulations, " + name);
        } else {
            System.out.println(
                    "'"
                            + Calc.answer
                            + "' is wrong answer ;(. Correct answer was '"
                            + Calc.correctResult
                            + "'.");
            System.out.println("Let's try again, " + name);
        }
    }

    public static boolean gameStep() {
        int number1 = (int) (Math.random() * 100);
        int number2 = (int) (Math.random() * 100);
        String[] operations = {"+", "-", "*"};
        int randomIndex = (int) (Math.random() * operations.length);
        System.out.println("Question: " + number1 + " " + operations[randomIndex] + " " + number2);

        switch (operations[randomIndex]) {
            case "+":
                Calc.correctResult = Integer.toString(number1 + number2);
                break;
            case "-":
                Calc.correctResult = Integer.toString(number1 - number2);
                break;
            case "*":
                Calc.correctResult = Integer.toString(number1 * number2);
                break;
        }

        Scanner scanner = new Scanner(System.in);
        Calc.answer = scanner.nextLine();
        System.out.println("Your answer: " + Calc.answer);
        return Calc.correctResult.equals(Calc.answer);
    }
}

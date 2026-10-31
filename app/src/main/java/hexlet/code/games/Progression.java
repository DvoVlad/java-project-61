package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Progression {
    private static String correctResult = "";
    private static String answer = "";

    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello," + name);
        System.out.println("What number is missing in the progression?");
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
            System.out.println("Congratulations, " + name);
        } else {
            System.out.println(
                    "'"
                            + Progression.answer
                            + "' is wrong answer ;(. Correct answer was '"
                            + Progression.correctResult
                            + "'.");
            System.out.println("Let's try again, " + name);
        }
    }

    public static boolean gameStep() {
        int[] progression = getProgression();
        StringBuilder question = new StringBuilder();
        Random random = new Random();
        int hiddenIndex = random.nextInt(progression.length);
        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                question.append("..");
                Progression.correctResult = String.valueOf(progression[i]);
            } else {
                question.append(String.valueOf(progression[i]));
            }
            if (i != progression.length - 1) {
                question.append(" ");
            }
        }
        System.out.println("Question: " + question.toString());

        Scanner scanner = new Scanner(System.in);
        Progression.answer = scanner.nextLine();
        System.out.println("Your answer: " + Progression.answer);
        return Progression.correctResult.equals(Progression.answer);
    }

    public static int[] getProgression() {
        Random random = new Random();
        int step = random.nextInt(3, 5);
        int length = random.nextInt(5, 10);
        int start = random.nextInt(1, 10);
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = start + i * step;
        }
        return result;
    }
}

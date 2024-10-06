
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizSystem {
    private static final int TIME_LIMIT = 10; 
    private static Timer timer;
    private static boolean timeUp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[] {"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3));
        questions.add(new Question("What is 2 + 2?", new String[] {"1. 3", "2. 4", "3. 5", "4. 6"}, 2));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[] {"1. Earth", "2. Venus", "3. Mars", "4. Jupiter"}, 3));

        int score = 0;
        ArrayList<Boolean> correctAnswers = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + currentQuestion.getQuestionText());
            String[] options = currentQuestion.getOptions();
            for (String option : options) {
                System.out.println(option);
            }
            timeUp = false;
            timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's up!");
                }
            };
            int userAnswer = -1;
            while (!timeUp && userAnswer == -1) {
                System.out.print("Select your answer (1-4): ");
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    if (userAnswer < 1 || userAnswer > 4) {
                        System.out.println("Invalid option, please choose between 1-4.");
                        userAnswer = -1;
                    }
                } else {
                    scanner.next(); 
                    System.out.println("Please enter a number.");
                }
            }

            timer.cancel();
            if (!timeUp && userAnswer == currentQuestion.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
                correctAnswers.add(true);
            } else if (!timeUp) {
                System.out.println("Incorrect!");
                correctAnswers.add(false);
            } else {
                correctAnswers.add(false);
            }
        }
        System.out.println("\n===== Quiz Results =====");
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Final Score: " + score + "/" + questions.size());
        System.out.println("\nQuestion Summary:");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ": " + (correctAnswers.get(i) ? "Correct" : "Incorrect"));
        }
        scanner.close();
    }
}

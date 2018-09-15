import java.util.Scanner;

/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
List<Quiz> quiz = new List<Quiz>();
List<Scanner> s = new List<Scanner>();

    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount >= 1) {
            //for (int i = 0; i < questionCount; i++) {

                System.out.println(questionCount + " are added to the quiz");
        //}

        } else {
            System.out.println("Quiz does not have questions");
        }


    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        for (int i = 1; i <= answerCount; i++) {
                System.out.println("question text " + i + "(" + i + ")");
                System.out.println("choice 1    choice 2    choice 3    choice 4" + "\n");
            }
        }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        System.out.println(quiz);
    }
}
class Quiz {
    private int questionCount;
    private int answerCount;

    // Quiz(int qc, int ac) {
    //     this.questionCount = qc;
    //     this.answerCount = ac;
    // }

    public int getQuestionCount() {
        return this.questionCount;
    }
    public int getAnswerCount() {
        return this.answerCount;
    }
    public int setQuestionCount(int change) {
        return this.questionCount = change;
    }
    public int setAnswerCount(int change) {
        return this.answerCount = change;
    }
}

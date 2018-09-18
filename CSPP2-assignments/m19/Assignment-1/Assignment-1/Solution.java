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
    public static List<Quiz> quizob = new List<Quiz>();
    public static Quiz questionobj;
    public static Quiz responseobj;
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

    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s,
        final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        //Quiz questionobj = new Quiz();
        if (questionCount >= 1) {
            //for (int i = 0; i < questionCount; i++) {
                //quiz.add(questionCount);
                System.out.println(questionCount + " are added to the quiz");
        //}

        } else {
            System.out.println("Quiz does not have questions");
        }


    }

    /**
     * Starts a quiz.
     *
     * @param      sc            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s,
        final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        // for (int i = 1; i <= answerCount; i++) {
        //         System.out.println("question text " + i + "(" + i + ")");
        //         System.out.println("choice 1    choice 2    choice 3    choice 4" + "\n");
        //     }
        // }
        for (int i = 0; i < quizob.size(); i++) {
            String[] choices = quizob.get(i).getChoices();
            System.out.println(quizob.get(i).getquestion() + "(" + quizob.get(i).getMarks() + ")");
            System.out.println(choices[0] + "\t" + choices[1] + "\t"
                + choices[2] + "\t" + choices[3] + "\n");
        }
        String[] responses = new String[answerCount];
        for(int i = 0; i < answerCount; i++) {
            String line = s.nextLine();
            String[] dataList = line.split(" ");
            responses[i] = dataList[1];
        }
        responseobj = new Quiz(responses);
}
    /**
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
       if (quizob.size() > 0) {
        int totalScore = 0;
        for (int i = 0; i < quizob.size(); i++) {
            System.out.println(quizob.get(i).getquestion());
            if (quizob.get(i).getAnswer().equals(responseobj.getResponses())) {
                System.out.println(" Correct Answer! - Marks Awarded: " + quizob.get(i).getMarks());
                totalScore = totalScore + Integer.parseInt(quizob.get(i).getMarks());

            } else {
                System.out.println(" Wrong Answer! - Penalty: " + quizob.get(i).getPenalty());
                totalScore = totalScore + Integer.parseInt(quizob.get(i).getPenalty());
            }

        }
        System.out.println("Total Score: " + totalScore);
       }
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    private String question;
    private String answer;
    private String[] choices;
    private String[] responses;
    private String marks;
    private String penalty;
    Quiz() {

    }

    Quiz(String[] res) {
        this.responses = res;

    }

    Quiz(String qc, String ac, String[] ch, String m, String p) {
        this.question = qc;
        this.answer = ac;
        this.choices = ch;
        this.marks = m;
        this.penalty = p;
    }

    public String getquestion() {
        return this.question;
    }
    public String getAnswer() {
        return this.answer;
    }
    public String[] getChoices() {
        return this.choices;
    }
    public String[] getResponses() {
        return this.responses;
    }
    public String getMarks() {
        return this.marks;
    }
    public String getPenalty() {
        return this.penalty;
    }
    public String setResponses(int index, String set) {
        return this.responses[index] = set;
    }
/**
 * Sets the question count.
 *
 * @param      change  The change
 *
 * @return     { description_of_the_return_value }
 */
    public String setquestion(final String change) {
        return this.question = change;
    }
    /**
     * Sets the answer count.
     *
     * @param      change  The change
     *
     * @return     { description_of_the_return_value }
     */
    public String setAnswer(final String change) {
        return this.answer = change;
    }
}

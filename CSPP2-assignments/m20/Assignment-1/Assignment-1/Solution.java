import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
    	this.questiontext = question1;
    	this.choices = choices1;
    	this.correctAnswer = correctAnswer1;
    	this.maxMarks = maxMarks1;
    	this.penalty = penalty1;
    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {

        return getCorrectAnswer().equals(choice);
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
    	// String correctAnswer2 = correctAnswer + "";
    	//return correctAnswer2;
    	if (this.choices.length >= this.correctAnswer) {
    		return this.choices[this.correctAnswer - 1];
    	}
    	return null;

    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return this.questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return this.choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return this.maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return this.penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
    	this.response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return this.response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
    	questions = new Question[onehundred];
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
    	questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        int score = 0;
        for (int i = 0; i < this.size; i++) {
        	s += questions[i].getQuestionText() + "\n";
        	if (questions[i].evaluateResponse(questions[i].getResponse())) {
        		s += " Correct Answer! - Marks Awarded: " + questions[i].getMaxMarks() + "\n";
        		score += questions[i].getMaxMarks();
        	} else {
        		s += " Wrong Answer! - Penalty: " + questions[i].getPenalty() + "\n";
        		score += questions[i].getPenalty();
        	}
        }
        s += "Total Score: " + score;
        return s;
    }
    public int getSize() {
    	return this.size;
    }
    // public int size() {
    // 	return size;
    // }

}
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
    //public static Quiz quizob;
	public static Question questionob;
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
    // public static List <Quiz> quizob = new List<Quiz>();
    // public static List <Question> questionob = new List<Question>();

    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (q > 0) {
        	for (int i = 0; i < q; i++) {
        		String line = scan.nextLine();
        		String[] tokens = line.split(":");
	        	if (tokens.length == 5) {

	        		if (tokens[0] == null) {
	        			System.out.println("Error! Malformed question");
	        			return;
	        		}
	        		if (tokens[1].split(",").length < 0) {
	        			System.out.println(tokens[0] + "  does not have enough answer choices");
	        			return;
	        		}
	        		if (Integer.parseInt(tokens[2]) > 4) {
	        			System.out.println("Error! Correct answer choice number is out of range for " + tokens[0]);
	        			return;
	        		}
	        		if (Integer.parseInt(tokens[3]) < 0) {
	        			System.out.println("Invalid max marks for " + tokens[0]);
	        			return;
	        		}
	        		if (Integer.parseInt(tokens[4]) >= 0) {
	        			System.out.println("Invalid penalty for " +  tokens[0]);
	        			return;
	        		}
	        		questionob = new Question(tokens[0], tokens[1].split(","), Integer.parseInt(tokens[2]),
	        			Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
	        		quiz.addQuestion(questionob);
        		} else {
        			System.out.println("Error! Malformed question");
        		}

        	}
        	System.out.println(q + " are added to the quiz");
        } else {
        	System.out.println("Quiz does not have questions");
        }
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object

        //String[] response = new String[q];
        // for (int i = 0; i < q; i++) {
        // 	String line = scan.nextLine();
        // 	String[] data = line.split(" ");
        // 	//response[i] = data[1];
        // 	questionob.get(i).setResponse();
        // }
        //questionob.getResponse()
       	if (quiz.getSize() > 0) {
       	for (int i = 0; i < q; i++) {
        	System.out.println(quiz.getQuestion(i).getQuestionText() + "(" + quiz.getQuestion(i).getMaxMarks() + ")");
        	System.out.println(Arrays.toString(quiz.getQuestion(i).getChoice()).replace("[", "").replace("]","").replace(", ", "\t"));
      		System.out.println();
        }
       	}

    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
    	System.out.println(quiz.showReport());
    }
}

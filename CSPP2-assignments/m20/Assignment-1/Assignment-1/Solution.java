import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for question.
 */
class Question {
    /**
     * questiontext.
     */
    private String questiontext;
    /**
     * choices.
     */
    private String[] choices;
    /**
     * correctAnswer.
     */
    private int correctAnswer;
    /**
     * maximun marks.
     */
    private int maxMarks;
    /**
     * penalty marks.
     */
    private int penalty;
    /**
     * user responses.
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
     * checking for response is equals to choice.
     *
     * @param      choice  The choice
     *
     * @return boolean
     */
    public boolean evaluateResponse(final String choice) {

        return choices[correctAnswer - 1].equals(choice);
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public int getCorrectAnswer() {
    	//String correctAnswer2 = correctAnswer + "";
        return this.correctAnswer;
    }
    /**
     * Gets the question text.
     *uestionText() {
        return this.qu
     * @return     The question text.
     */
    public String getQuestionText(){
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
     * magic number case.
     */
    private final int onehundred = 100;
    /**
     * questions array.
     */
    private Question[] questions;
    /**
     * size.
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
    // /**
    //  * Shows the report.
    //  *
    //  * @return  String
    //  */
    // public String showReport() {
    //     String s = "";
    //     return s;
    // }
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
                try {
                	loadQuestions(s, q, Integer.parseInt(tokens[1]));
                } catch (Exception e) {
                	System.out.println(e.getMessage());
                }

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
     * @param      q          The quarter
     *
     * @throws     Exception  { exception_description }
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) throws Exception {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class

        if (q == 0) {
        	throw new Exception("Quiz does not have questions");
        }
        	for (int i = 0; i < q; i++) {
        		String line = scan.nextLine();
        		String[] tokens = line.split(":");
	        	if (tokens.length < 5 || tokens[0].length() <= 0 || tokens[1].length() <= 0 ||
	        	 tokens[2].length() <= 0 || tokens[3].length() <= 0 || tokens[4].length() <= 0) {
	        		throw new Exception("Error! Malformed question");
	        		}
	        		String[] choices = tokens[1].split(",");
	        		if (choices.length < 2) {
	        			throw new Exception(tokens[0]
	        				+"  does not have enough answer choices");

	        		}
	        		if (Integer.parseInt(tokens[2]) < 0 &&
	        			Integer.parseInt(tokens[2]) > choices.length) {
	        			throw new Exception(
	        				"Error! Correct answer choice number is out of range for " + tokens[0]);

	        		}
	        		if (Integer.parseInt(tokens[3]) <= 0) {
	        			throw new Exception("Invalid max marks for " + tokens[0]);

	        		}
	        		if (Integer.parseInt(tokens[4]) > 0) {
	        			throw new Exception("Invalid penalty for " +  tokens[0]);

	        		}

	        		questionob = new Question(tokens[0], tokens[1]
	        			.split(","), Integer.parseInt(tokens[2]),
	        			Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
	        		quiz.addQuestion(questionob);
        		}
        		System.out.println(q + " are added to the quiz");
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
       	if (quiz.getSize() <= 0) {
       		return;
       	}
       	for (int i = 0; i < q; i++) {
        	System.out.println(quiz.getQuestion(i).getQuestionText()
        		+ "(" + quiz.getQuestion(i).getMaxMarks() + ")");
        	System.out.println(Arrays.toString(quiz.getQuestion(i).
        		getChoice()).replace("[", "").replace("]","").replace(", ", "\t"));
      		System.out.println();
      		quiz.getQuestion(i).setResponse(scan.nextLine());

       	}

    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        if (quiz.getSize() == 0) {
        	return;
        }
        int score = 0;
        for (int i = 0; i < quiz.getSize(); i++) {
        	System.out.println(quiz.getQuestion(i).getQuestionText());
        	if(quiz.getQuestion(i).evaluateResponse(quiz.getQuestion(i).getResponse())) {

        		score += quiz.getQuestion(i).getMaxMarks();
        		System.out.println(" Correct Answer! - Marks Awarded: "
        			+ quiz.getQuestion(i).getMaxMarks());
        	} else {
        	score += quiz.getQuestion(i).getPenalty();
        	System.out.println(" Wrong Answer! - Penalty: "
        		+ quiz.getQuestion(i).getPenalty() );
        }
        }
    	System.out.println("Total Score: " + score);
    }
}

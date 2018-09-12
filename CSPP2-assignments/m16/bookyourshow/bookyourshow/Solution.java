import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for show.
 */
class Show {
	/**
	 * variable that can be accessed within the class.
	 */
	private String movieName;
	/**
	 *variable that can be accessed within the class.
	 */
	private String dateTime;
	/**
	 *string array that can be accessed within the class.
	 */
	private String[] seats;
	/**
	 * Constructs the object.
	 *
	 * @param name  The name
	 * @param t     date and time
	 * @param seat  The seat
	 */
	public Show(String name, String t, String[] seat) {
		this.movieName = name;
		this.dateTime = t;
		this.seats = seat;
	}
	/**
	 * Gets the movie name.
	 * @return The movie name.
	 */
	public String getMovieName() {
		return this.movieName;
	}
	/**
	 * Gets the date time.
	 * @return The date time.
	 */
	public String getDateTime() {
		return this.dateTime;
	}
	/**
	 * Gets the seats.
	 * @return The seats.
	 */
	public String[] getSeats() {
		return this.seats;
	}
	/**
	 * Sets the seat.
	 * @param index The index
	 * @param set The et
	 */
	public void setSeat(int index, String set) {
		seats[index] = set;
	}
	/**
	 * Returns a string representation of the object.
	 * @return String representation of the object.
	 */
	public String toString() {
		return this.movieName + "," + this.dateTime;
	}
}
/**
 * Class for patron.
 */
class Patron {
	/**
	 *variable that can be accessed within the class.
	 */
	private String userName;
	/**
	 *variable that can be accessed within the class.
	 */
	private String mobileNumber;
	/**
	 * Constructs the object.
	 *
	 * @param name    The name
	 * @param number  The number
	 */
	public Patron(String name, String number) {
		this.userName = name;
		this.mobileNumber = number;
	}
	/**
	 * Gets the user name.
	 *
	 * @return The user name.
	 */
	public String getUserName() {
		return this.userName;
	}
	/**
	 * Gets the mobile number.
	 *
	 * @return The mobile number.
	 */
	public String getMobileNumber() {
		return this.mobileNumber;
	}

}
/**
 * Class for book your show.
 */
class BookYourShow {
	/**
	 * creating variable type object.
	 */
	List<Show> showDetails;
	/**
	 * creating variable type object.
	 */
	List<String> bookedTickets;
	/**
	 * Constructs the object.
	 */
	public BookYourShow() {
		/**
		 *creating variable type object.
		 */
		showDetails = new List<Show>();
		/**
		 *creating variable type object.
		 */
		bookedTickets = new List<String>();
	}
	/**
	 * Adds a show.
	 *
	 * @param obj   The object
	 */
	public void addAShow(Show obj) {
		showDetails.add(obj);

	}
	/**
	 * Users should be able to ​getAShow() by
	 * specifying the movie name ​,date and time.
	 * This method should return all the
	 * shows that matches the given details.
	 * @param      movie  The movie
	 * @param      time   The time
	 * @return     A show.
	 */
	public Show getAShow(String movie, String time) {
		for (int i = 0; i < showDetails.size(); i++) {
			if (showDetails.get(i).getMovieName().equals(movie) &&
				showDetails.get(i).getDateTime().equals(time)) {
				return showDetails.get(i);
			}
		}
		return null;
	}
	/**
	 * Users should be able to bookAShow() by
	 * specifying his name,movie name, Mobile
	 * Number, Date-Time and Seat numbers. If the
	 * seats are not available then the booking
	 *  should not be possible.
	 * @param      movie  The movie
	 * @param      time   The time
	 * @param      obj    The object
	 * @param      seats  The seats
	 *
	 */
	public void bookAShow(String movie, String time, Patron obj, String[] seats) {
		Show movieData = getAShow(movie, time);
		if (movieData != null) {
			for (int i = 0; i < movieData.getSeats().length; i++) {
				for (int j = 0; j < seats.length; j++) {
					if (seats[j].equals(movieData.getSeats()[i])) {
						movieData.setSeat(i, "N/A");
						bookedTickets.add(obj.getMobileNumber() + " " + movie + " " + time);
					}
				}
			}
		}
		else {
			System.out.println("No Show");
		}
	}
	/**
	 *
	 * @param movie The movie
	 * @param time The time
	 * @param mobileNumber  The mobile number
	 */
	public void printTicket(String movie, String time, String mobileNumber) {
		for (int i = 0; i < bookedTickets.size(); i++) {
			if ((mobileNumber + " " + movie + " " + time).equals(bookedTickets.get(i))) {
				System.out.println(mobileNumber + " " + movie + " " + time);
				return;
			}
		}
		System.out.println("Invalid");
	}
	/**
	 * Shows all.
	 */
	public void showAll() {
		for (int i = 0; i < showDetails.size(); i++) {
			System.out.println(showDetails.get(i).toString()+ "," + Arrays.toString(showDetails.get(i).getSeats()).replace(" ",""));
		}
	}

}
/**
 * main method to read the input.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     * used to drive the program.
     * @param args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}

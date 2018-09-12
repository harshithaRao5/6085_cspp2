import java.util.Scanner;
import java.util.Arrays;

class Show {
	private String movieName;
	private String dateTime;
	private String[] seats;
	public Show(String name, String t, String[] seat) {
		this.movieName = name;
		this.dateTime = t;
		this.seats = seat;
	}
	public String getMovieName() {
		return this.movieName;
	}
	public String getDateTime() {
		return this.dateTime;
	}
	public String[] getSeats() {
		return this.seats;
	}
	public void setSeat(int index, String set) {
		seats[index] = set;
	}
	public String toString() {
		return this.movieName + "," + this.dateTime + "," + Arrays.toString(seats).replace(" ","");
	}
}
class Patron {
	private String userName;
	private String mobileNumber;
	public Patron(String name, String number) {
		this.userName = name;
		this.mobileNumber = number;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getMobileNumber() {
		return this.mobileNumber;
	}

}
class BookYourShow {
	List<Show> showDetails;
	List<String> bookedTickets;
	public BookYourShow() {
		showDetails = new List<Show>();
		bookedTickets = new List<String>();
	}
	public void addAShow(Show obj) {
		showDetails.add(obj);

	}
	public Show getAShow(String movie, String time) {
		for (int i = 0; i < showDetails.size(); i++) {
			if (showDetails.get(i).getMovieName().equals(movie) &&
				showDetails.get(i).getDateTime().equals(time)) {
				return showDetails.get(i);
			}
		}
		return null;
	}
	public String bookAShow(String movie, String time, Patron obj, String[] seats) {
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
		return "";
	}

	public void printTicket(String movie, String time, String mobileNumber) {
		for (int i = 0; i < bookedTickets.size(); i++) {
			if ((mobileNumber + " " + movie + " " + time).equals(bookedTickets.get(i))) {
				System.out.println(mobileNumber + " " + movie + " " + time);
				break;
			}
		}
	}

	public void showAll() {
		for (int i = 0; i < showDetails.size(); i++) {
			System.out.println(showDetails.get(i).toString());
		}
	}

}

public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
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

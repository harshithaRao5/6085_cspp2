import java.util.Scanner;
import java.util.Arrays;
class UserName {
	private String userName;
	List<String> followers;
	UserName(String usename) {
		this.userName = usename;
		followers = new List<String>();
	}
	public String getUserName() {
		return this.userName;
	}
	public List<String> getFollowers() {
		return this.followers;
	}
	public void addFollower(String fn) {
		followers.add(fn);
	}
	public String toString() {
		//System.out.println("hello");
		// String s = "[";
		// for (int i = 0; i < followers.size()-1; i++) {
		// 	s += "" + followers.get(i)+",";
		// }
		// s += "" + followers.get(followers.size() - 1) + "" + "]";
		// return s;
		String s = this.userName + ":" +followers.toString();
		return s;
	}

}

class SocialNetwork {
	List<UserName> userdetails;


	SocialNetwork() {
		userdetails = new List<UserName>();

	}
	public void addUsers(UserName name) {
		userdetails.add(name);
	}
	// public UserName getuser(int index) {
	// 	return userdetails[index];
	// }
	public String getConnections(String username) {

		for (int i = 0; i < userdetails.size(); i++) {

			if (username.equals(userdetails.get(i).getUserName())) {
				//System.out.println(username);
				return userdetails.get(i).toString();
			}
		}
		return "Not a user in Network";
	}
	public void addConnections(String username, String follower) {
		for (int i = 0; i < userdetails.size(); i++) {
			if (username.equals(userdetails.get(i).getUserName())) {
				if(!userdetails.get(i).getFollowers().contains(follower)) {
					userdetails.get(i).addFollower(follower);
				}
			}
		}
	}
	public void getCommonConnections(String username1, String username2) {
		List<String> clearList1 = new List<String>();
		List<String> clearList2 = new List<String>();
		List<String> resultList = new List<String>();
		for (int i = 0; i < userdetails.size(); i++) {
			if (username1.equals(userdetails.get(i).getUserName())) {
				clearList1 = userdetails.get(i).getFollowers();
				break;
			}
		}
		//System.out.println(clearList1);
		for (int i = 0; i < userdetails.size(); i++) {
			if (username2.equals(userdetails.get(i).getUserName())) {
				clearList2 = userdetails.get(i).getFollowers();
				break;
			}
		}
		//System.out.println(clearList2);
		for (int i = 0; i < clearList1.size(); i++) {
			//System.out.println(clearList1.get(i));
			if (clearList2.contains(clearList1.get(i))) {

				resultList.add(clearList1.get(i));
			}
		}
		System.out.println(resultList);
 	}
 	public void Network() {
 		String[] users = new String[userdetails.size()];
 		for (int i = 0; i < userdetails.size(); i++) {
 			users[i] = userdetails.get(i).toString();
 		}
 		Arrays.sort(users);
 		String s = Arrays.toString(users);
 		System.out.println(s.substring(1,s.length()-1));
 	}


}


class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SocialNetwork sN = new SocialNetwork();
		while(scan.hasNext()) {
			String line = scan.nextLine();
			if (line.contains(" is connected to ")) {
				String[] tokens = line.split(" is connected to ");
				String[] items = tokens[1].replace(".", "").split(", ");
				UserName uobj = new UserName(tokens[0]);
				for (int i = 0; i < items.length; i++) {
					uobj.addFollower(items[i]);
				}
				sN.addUsers(uobj);
			} else {
				}
				String[] tokens = line.split(" ", 2);
				switch (tokens[0]) {
				case "getConnections":
				System.out.println(sN.getConnections(tokens[1]));
				break;
				case "addConnections":
				String[] list = tokens[1].split(" ");
				sN.addConnections(list[0], list[1]);
				break;
				case "CommonConnections":
				list = tokens[1].split(" ");
				sN.getCommonConnections(list[0], list[1]);
				break;
				case "Network":
				sN.Network();
				default:
				}
			}
			}

		}


package coding.mentor;

import java.util.Scanner;
import java.util.Date;
import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.data.User;
import coding.mentor.db.Database;
import coding.mentor.service.CourseService;
import coding.mentor.service.UserService;

public class Main {


	public static void main(String[] args) {
		CourseService courseService = new CourseService();
		UserService userService = new UserService();
		Database.initDB();
		Scanner scanner = new Scanner(System.in);
		User currentUser = null;
		String id, password, name;
        
		final int DO_LOGIN = 1;
		final int DO_REGISTER = 2;
		final int SHOW_REGISTERED = 1;
		final int SHOW_NO_REGISTERED = 2;
		final int SHOW_CHOOSE_COURSE = 3;
		
		boolean isLoggedIn = false;
		do {

			System.out.println("Please choose an option:");
			System.out.println("1. Login");
			System.out.println("2. Register");
			
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
			case DO_LOGIN :

				System.out.println("Enter  your ID");
				 id = scanner.nextLine();
				System.out.println("Enter your password");
				 password = scanner.nextLine();

				
				if (userService.login(id, password)) {
					
					currentUser = userService.validateUser(id);
					if (currentUser != null) {
						currentUser.setloginAttempts(0);
						System.out.println("Wellcome your ID and Password is Correct!");
						isLoggedIn = true;
					} else {
						System.out.println("Error Id or Password");
						System.out.println("Try Again!");
						
					}
				} else {
					System.out.println("Error Id or Password");
					System.out.println("Try Again!");
				}
					break;

				
			case DO_REGISTER:
				System.out.println("Please input your id");
			     id = scanner.nextLine();
				System.out.println("Please input your password");
				 password = scanner.nextLine();
				System.out.println("Please input your name");
			     name = scanner.nextLine();
				
			    userService.registerNewUser(id, password, name);
				System.out.println("Registration successful");
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option");
			}
		} while (!isLoggedIn);

		// after login

		boolean continueCourseSelection = true;
		while (currentUser != null && continueCourseSelection) {
			
			System.out.println("0: Show my registered Courses");
			courseService.showAllCourse();
			System.out.println("Which course would you like to choose?");
			int courseOption = scanner.nextInt();
			if (courseOption == 0) {
				UserService.showRegisteredCoursesByUser(currentUser);
			} else if (courseOption >= 1 && courseOption <= Database.COURSES_DB.size()) {
				Course course = Database.COURSES_DB.get(courseOption - 1);
				CourseService.showCourseDetail(course);

				System.out.println(" Select an option:");
				System.out.println(" 1. Register for this course:");
				System.out.println(" 2. No");
				System.out.println(" 3. Show Mentor Details ");

				int choice = scanner.nextInt();
				switch (choice) {
				case  SHOW_REGISTERED :
					UserService.registernewCourse(currentUser, course);
					System.out.println(" You have successfully registered for this course ");
					break;
				case SHOW_NO_REGISTERED :
					System.out.println(" Don't have  registration for this course ");
					break;
				case SHOW_CHOOSE_COURSE :
					CourseService.showMentorByCourse(course);
					break;
				default:
					System.out.println("Invalid choice.Please enter again");
				}
			} else {
				System.out.println(" Invalid course choice.please select a valid option");

			}
 
		}
	}
}


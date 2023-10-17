package coding.mentor.service;

import coding.mentor.data.User;
import coding.mentor.db.Database;

import java.util.ArrayList;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;

public class UserService {
	
	public void registerNewUser(String id, String password, String name) {
		// TODO new Object User with user's input
		User user = new User(id, password, name);

		// validate id exist on DB or Not ?

		User currentUser = validateUser(id);
		if (currentUser != null) {
			System.out.println("Account already existed, please register another one");
			return;
		}
		// add the user we created above to USER_DB

		Database.USERS_DB.add(user);
		System.out.println("Register successfully");

	}

	public static boolean login( String id,String passoword) {
		// TODO
		User currentUser = validateUser(id);
		
		if (currentUser != null) {
			if (currentUser.getloginAttempts() < 3) {
				if(passoword.equals(currentUser.getPassword())) {
					currentUser.setloginAttempts(0);
				  return  true;
				} else {
					currentUser.setloginAttempts(currentUser.getloginAttempts() + 1);
				}
			}
		}
		return false;
	}
	
	public static User validateUser(String id) {

		for (User user : Database.USERS_DB) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	public static void showRegisteredCoursesByUser(User user) {

		ArrayList<Course> registeredCourses = user.getRegisteredCourses();
		if (registeredCourses.isEmpty()) {
			System.out.println("You have not registered for any course");
		} else {
			System.out.println("Registered Courses for " + user.getName() + ":");
			for (Course course : registeredCourses) {
				System.out.println(course.getName());
				for (Mentor mentor : course.getTeachingMentors()) {
					System.out.println("--mentor name: " + mentor.getName());
				}
				System.out.println();

			}
		}
	}

	public static void registernewCourse(User user, Course course) {

		ArrayList<Course> registeredCourses = user.getRegisteredCourses();

		registeredCourses.add(course);
		System.out.println("You have already registered this course");

	}

	
	
}

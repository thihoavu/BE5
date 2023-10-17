package coding.mentor.db;
import java.util.Date;
import java.util.ArrayList;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.data.User;


public class Database {
	public static ArrayList<Mentor> MENTORS_DB = new ArrayList<Mentor>();
	public static ArrayList<Course> COURSES_DB= new ArrayList<Course>();
	public static ArrayList<User> USERS_DB = new ArrayList<User>();
	
	public static void initDB() {
		// initialize Mentor DB
		
		MENTORS_DB.add(new Mentor(1,"Dung","dung@gmail.com","0909"));
		MENTORS_DB.add(new Mentor(2,"Jayden","jayden@gmail.com","0808"));
		MENTORS_DB.add(new Mentor(3,"Tony","tony@gmail.com","0707"));
		
		// initialize Course DB
		ArrayList<Mentor> teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(0));
		COURSES_DB.add(new Course(1,"BE 1", teachingMentors, new Date(), new Date(), 3000));
		
		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(0));
		teachingMentors.add(MENTORS_DB.get(1));
		COURSES_DB.add(new Course(2,"BE 2", teachingMentors, new Date(), new Date(), 3100));
		
		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(2));
		
		COURSES_DB.add(new Course(3,"DATA 1", teachingMentors, new Date(), new Date(), 2500));
		
		
	}	
	
	
  public static final String SYSTEM_NAME = "course-system";
	
	
	
	
	
	
	
	
	public static void thisIsUtilFunctionCanBeUsedAnyWhereWithoutCreatedNewObject() {
		System.out.println("Utility Function");
		
	}
		
		
	
}


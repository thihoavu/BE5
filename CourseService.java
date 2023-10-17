package coding.mentor.service;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.db.Database;

public class CourseService {
	
	private static Course mentor;

	public void showAllCourse() {
		// TODO
		
		for (int i=0;  i < Database.COURSES_DB.size(); i++) {
			System.out.print((i+1) + ":" + Database.COURSES_DB.get(i).getName());
			
		for(Mentor mentor : Database.COURSES_DB.get(i).getTeachingMentors()) {
			System.out.print("--mentor name: " + mentor.getName());
		}
		System.out.println();
		}
	}
		
		public static void showCourseDetail(Course course) {
		for (Course course1 : Database.COURSES_DB) {
			System.out.println("Course :" + course1.getName());
			for(Mentor mentor: course1.getTeachingMentors());
			System.out.println("--mentor name:" + mentor.getName());
			
		
		System.out.println("Begin Date: " + course1.getBegin());
		System.out.println("End Date: " + course1.getEnd());
		System.out.println("Fee: " + course1.getFee());
    }
		}
	
	public static void showMentorByCourse(Course course) {
		System.out.println("Mentor for Course : " + course.getName());
		
		for(Mentor mentor: course.getTeachingMentors()) {
			System.out.println("Mentor name: " + mentor.getName());
			System.out.println("Email: " + mentor.getEmail());
			System.out.println("Phone: " + mentor.getPhone());
			System.out.println("----------------------------");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
    }

	
	}
	
   
    


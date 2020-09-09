package service;
import java.util. List;
import entity . Course;
import dao.CourseDao;
import dao.Impl.CourseDaoImpl;

public class CourseService {
	private CourseDao courseDao;
public CourseService() {
	courseDao = new CourseDaoImpl();
}
public void addCourse(Course course) {
	courseDao.insert(course);
}
public void removeCourse(String courseName) {
	
}
public void modifyCourse(int id, Course course) {
}
public List<Course> findAll(){
	return courseDao.select();
}
public Course selectByName (String courseName) {
	return courseDao.selectByName(courseName);	
}
public Course selectByNum(String num) {
	return courseDao.selectByNum(num);
}
}
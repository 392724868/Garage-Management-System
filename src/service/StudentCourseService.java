package service;
import java.util. List;
import entity .StudentCourse;
import dao.StudentCourseDao;
import dao.Impl.StudentCourseDaoImpl;

public class StudentCourseService {
	private StudentCourseDao studentcourseDao;
public StudentCourseService() {
	studentcourseDao = new StudentCourseDaoImpl();
}
public void addStudentCourse(StudentCourse studentcourse) {
	studentcourseDao.insert(studentcourse);
}
public void removeStudentCourse(String StudentCourseName) {
	
}
public void modifyStudentCourse(int id, StudentCourse studentcourse) {
}
public List<StudentCourse> findAll(){
	return studentcourseDao.select();
}
public StudentCourse selectBySnum (String snum) {
	return studentcourseDao.selectBySnum(snum);	
}
public StudentCourse selectByCnum(String cnum) {
	return studentcourseDao.selectByCnum(cnum);
}
}

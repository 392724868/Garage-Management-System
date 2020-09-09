package service;
import java.util. List;
import entity . Student;
import dao.StudentDao;
import dao.Impl.StudentDaoImpl;

public class StudentService {
	private StudentDao studentDao;
public StudentService() {
	studentDao = new StudentDaoImpl();
}
public void addStudent(Student student) {
	studentDao.insert(student);
}
public void removeStudent(String studentName) {
	
}
public void modifyStudent(int id, Student student) {
}
public List<Student> findAll(){
	return studentDao.select();
}
public Student selectByName (String studentName) {
	return studentDao.selectByName(studentName);	
}
public Student selectByNum(String num) {
	return studentDao.selectByNum(num);
}
}
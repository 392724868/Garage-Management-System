package dao;
import java.util.List;
import entity.Student;

public interface StudentDao {
public void insert(Student student);
public void delete(String studentName);
public void update(int id, Student student);
public List<Student> select();
public Student selectByName (String studentName);
public Student selectByNum(String num);
}
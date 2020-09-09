package dao;
import java.util.List;
import entity.StudentCourse;

public interface StudentCourseDao {
public void insert(StudentCourse studentcourse);
public void delete(String snum);
public void update(int id, StudentCourse studentcourse);
public List<StudentCourse> select();
public StudentCourse selectBySnum (String snum);
public StudentCourse selectByCnum(String cnum);
}
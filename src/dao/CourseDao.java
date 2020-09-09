package dao;
import java.util.List;
import entity.Course;

public interface CourseDao {
public void insert(Course course);
public void delete(String courseName);
public void update(int id, Course course);
public List<Course> select();
public Course selectByName (String courseName);
public Course selectByNum(String num);
}
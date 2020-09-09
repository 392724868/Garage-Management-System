package entity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
private int id;
private String num;
private String studentName ;
private Date birthday;
private String department;
public Student() {
}
public Student(String num, String studentName, Date birthday,String department) {
this.num = num;
this.studentName = studentName ;
this.birthday =birthday;
this.department=department;
}
public String getNum() {
return num;
}
public void setNum(String num) {
this.num = num;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getStudentName() {
return studentName;
}
public void setStudentName(String StudentName) {
this.studentName = studentName;
}
public Date getBirthday() {
return birthday;
}
public void setBirthday(Date birthday) {
this.birthday = birthday;
}
public String getDepartment() {
return department;
}
public void setDepartment(String department) {
this . department = department;
}

public String toString( ){
StringBuilder sb = new StringBuilder();
sb . append(num) . append(" , "+studentName) . append(", "+birthday).append(", "+department);
return sb .toString();
}
}
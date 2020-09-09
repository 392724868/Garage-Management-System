package entity;
public class Course {
private int id;
private String num;
private String courseName ;
private int credit;

public Course() {
}
public Course(String num, String courseName, int credit) {
this.num = num;
this.courseName = courseName ;
this.credit = credit;
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
public String getCourseName() {
return courseName;
}
public void setCourseName(String courseName) {
this . courseName = courseName;
}
public int getCredit() {
return credit;
}
public void setCredit(int credit) {
this.credit = credit;
}
public String toString( ){
StringBuilder sb = new StringBuilder();
sb . append(num) . append(" , "+courseName) . append(", "+credit);
return sb .toString();
}
}
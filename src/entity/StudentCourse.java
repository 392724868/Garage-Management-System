package entity;
public class StudentCourse {
private int id;
private String snum;
private String cnum;
public StudentCourse() {
}
public StudentCourse(String snum, String cnum) {
this.snum = snum;
this.cnum = cnum;
}
public String getSnum() {
return snum;
}
public void setSnum(String snum) {
this.snum = snum;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getCnum() {
return cnum;
}
public void setCnum(String cnum) {
this . cnum = cnum;
}

public String toString( ){
StringBuilder sb = new StringBuilder();
sb . append(snum) . append(" , "+cnum);
return sb .toString();
}
}

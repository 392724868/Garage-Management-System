package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Course;
import entity.Student;
import entity.Student;
import dao.StudentDao;
import util.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void insert(Student student){
        Connection conn = null;
        PreparedStatement pst = null;
    
        try {
        	conn=ConnectionFactory.getConnection();
        	String sql=("insert into student(num,name,birthday,department) "
                    + "values(?,?,?,?)");
            pst= conn.prepareStatement(sql);
            pst.setString(1, student.getNum());
            pst.setString(2, student.getStudentName());
            pst.setDate(3, new java.sql.Date(student.getBirthday().getTime()));
            pst.setString(4, student.getDepartment());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	 ConnectionFactory.close(null, pst, conn);
        }
    }

    @Override
    public void delete(String studentName){
    }

    @Override
    public void update(int id, Student student){
   	 Connection conn = null;
     PreparedStatement pst = null;
            
                try {
                    pst=conn.prepareStatement("update student set num=?,name=?,birthday=?,department=?"+ "where id=?");
                    pst.setString(1, student.getNum());
                    pst.setString(2, student.getStudentName());
                    pst.setDate(3, new java.sql.Date(student.getBirthday().getTime()));
                    pst.setString(4, student.getDepartment());
                } 
catch (SQLException e) {
                    e.printStackTrace();
                }
finally{
	ConnectionFactory.close(null, pst, conn);
                }
    }

    @Override
public List<Student> select() {
    	  Connection conn = null;
          PreparedStatement st = null;
          ResultSet rs = null;
          List<Student> list = new ArrayList<Student>();
        try {
        	conn=ConnectionFactory.getConnection();
            String sql ="select * from student";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while(rs.next()){
            	Student student =new Student();
            	student.setId(rs.getInt("id"));
            	student.setNum(rs.getString("num"));
            	student.setStudentName(rs.getString("name"));
            	student.setBirthday(rs.getDate("birthday"));
            	student.setDepartment(rs.getString("department"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	ConnectionFactory.close(rs,st,conn);
        }
        return list;
    }
    @Override
    public Student selectByName (String studentName) {
    	  Connection conn =   null;                
          PreparedStatement pst = null;              
          ResultSet rs = null;
          Student student = null;
                try {
                	conn=ConnectionFactory.getConnection();
                    String sql="select * from student where name in" + studentName;
                    pst=conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if(rs.next()){
                    	student =new Student();
                    	student.setId(rs.getInt("id"));
                    	student.setNum(rs.getString("num"));
                    	student.setStudentName(rs.getString("name"));
                    	student.setBirthday(rs.getDate("birthday"));
                    	student.setDepartment(rs.getString("department"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                	ConnectionFactory.close(rs, pst, conn);
                }
                return student;
    }
    @Override
    public Student selectByNum (String num) {
    	 Connection conn =   null;                
         PreparedStatement pst = null;              
         ResultSet rs = null;
        Student student = null;
                try {
                	conn=ConnectionFactory.getConnection();
                	String sql="select * from student where num in" + num;
                	pst=conn.prepareStatement(sql);		
                    rs = pst.executeQuery();
                    if(rs.next()){
                    	student =new Student();
                    	student.setId(rs.getInt("id"));
                    	student.setNum(rs.getString("num"));
                    	student.setStudentName(rs.getString("name"));
                    	student.setBirthday(rs.getDate("birthday"));
                    	student.setDepartment(rs.getString("department"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                	ConnectionFactory.close(rs, pst, conn);
                }
                return student;
    }

}
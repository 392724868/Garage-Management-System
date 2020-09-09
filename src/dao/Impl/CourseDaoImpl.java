package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Course;
import dao.CourseDao;
import util.ConnectionFactory;

public class CourseDaoImpl implements CourseDao {
    @Override
    public void insert(Course course){
        Connection conn = null;
        PreparedStatement pst = null;
    
        try {
        	conn=ConnectionFactory.getConnection();
        	String sql=("insert into course(num,name,credit) "
                    + "values(?,?,?)");
        	pst= conn.prepareStatement(sql);
            pst.setString(1, course.getNum());
            pst.setString(2, course.getCourseName());
            pst.setInt(3, course.getCredit());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConnectionFactory.close(null, pst, conn);
        }
    }

    @Override
    public void delete(String courseName){
    }

    @Override
    public void update(int id, Course course){
    	 Connection conn = null;
         PreparedStatement pst = null;
                
                try {
                    pst=conn.prepareStatement("update course set num=?,name=?,credit=?"+ "where id=?");
                    pst.setString(1, course.getNum());
                    pst.setString(2, course.getCourseName());
                    pst.setInt(3, course.getCredit());
                    pst.executeUpdate();
                } 
catch (SQLException e) {
                    e.printStackTrace();
                }
finally{
	  ConnectionFactory.close(null, pst, conn);
                }
           
    }

    @Override
public List<Course> select() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Course> list = new ArrayList<Course>();
        try {
        	conn=ConnectionFactory.getConnection();
            String sql ="select * from course";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while(rs.next()){
            	Course course =new Course();
            	course.setId(rs.getInt("id"));
            	course.setNum(rs.getString("num"));
            	course.setCourseName(rs.getString("name"));
            	course.setCredit(rs.getInt("credit"));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	ConnectionFactory.close(rs,st,conn);
        }
        return list;
    }
    @Override
    public Course selectByName(String Name) {
                Connection conn =   null;                
                PreparedStatement pst = null;              
                ResultSet rs = null;
                Course course = null;
                try {
                	conn=ConnectionFactory.getConnection();
                	String sql="select * from course where name like" + Name +"%";
                	pst=conn.prepareStatement(sql);		
                    rs = pst.executeQuery();
                    if(rs.next()){
                    	course = new Course();
                    	course.setId(rs.getInt("id"));
                    	course.setNum(rs.getString("num"));
                    	course.setCourseName(rs.getString("name"));
                    	course.setCredit(rs.getInt("credit"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                	ConnectionFactory.close(rs, pst, conn);
                }
                return course;
    }
    @Override
    public Course selectByNum(String Num) {
                Connection conn =   null;                
                PreparedStatement pst = null;              
                ResultSet rs = null;
                Course course = null;
                try {
                	conn=ConnectionFactory.getConnection();
                	String sql="select * from course where num in" + Num;
                	pst=conn.prepareStatement(sql);		
                    rs = pst.executeQuery();
                    if(rs.next()){
                    	course =new Course();
                    	course.setId(rs.getInt("id"));
                    	course.setNum(rs.getString("num"));
                    	course.setCourseName(rs.getString("name"));
                    	course.setCredit(rs.getInt("credit"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                	ConnectionFactory.close(rs, pst, conn);
                }
                return course;
    }
}

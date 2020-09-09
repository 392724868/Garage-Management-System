package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.StudentCourse;
import entity.StudentCourse;
import dao.StudentCourseDao;
import util.ConnectionFactory;


public class StudentCourseDaoImpl implements StudentCourseDao {
    @Override
    public void insert(StudentCourse studentcourse){
        Connection conn = null;
        PreparedStatement pst = null;

        try {
        	conn=ConnectionFactory.getConnection();
            pst=conn.prepareStatement("insert into studentcourse(snum,cnum) "
                    + "values(?,?)");
            pst.setString(1, studentcourse.getSnum());
            pst.setString(2, studentcourse.getCnum());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	ConnectionFactory.close(null, pst, conn);
        }
    }
    @Override
    public void delete(String studentcourseCnum){
    }

    @Override
    public void update(int id, StudentCourse studentcourse){
   	 Connection conn = null;
     PreparedStatement pst = null;
     try {
         pst=conn.prepareStatement("update studentcourse set num=?,name=?,birthday=?,department=?"+ "where id=?");
         pst.setString(1, studentcourse.getSnum());
         pst.setString(2, studentcourse.getCnum());
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
public List<StudentCourse> select() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<StudentCourse> list = new ArrayList<StudentCourse>();
        try {
        	conn=ConnectionFactory.getConnection();
            String sql ="select * from studentcourse";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);       
            while(rs.next()){
            	StudentCourse studentcourse =new StudentCourse();
            	studentcourse.setId(rs.getInt("id"));
            	studentcourse.setSnum(rs.getString("snum"));
            	studentcourse.setCnum(rs.getString("cnum"));
                list.add(studentcourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	ConnectionFactory.close(rs,st,conn);
        }
        return list;
    }


    @Override
    public StudentCourse selectBySnum (String Snum) {
        Connection conn =  null;                
        PreparedStatement pst = null;              
        ResultSet rs = null;
        StudentCourse studentcourse = null;
                try {
                	conn=ConnectionFactory.getConnection();
                	String sql="select * from course studentcourse where snum in" + Snum;
                	pst=conn.prepareStatement(sql);		
                    rs = pst.executeQuery();
                    if(rs.next()){
                    	studentcourse = new StudentCourse();
                    	studentcourse.setId(rs.getInt("id"));
                    	studentcourse.setSnum(rs.getString("snum"));
                    	studentcourse.setCnum(rs.getString("cnum"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                	ConnectionFactory.close(rs, pst, conn);
                }
                return studentcourse;
    }

    @Override
    public StudentCourse selectByCnum (String Cnum) {
        Connection conn =  null;                
        PreparedStatement pst = null;              
        ResultSet rs = null;
        StudentCourse studentcourse = null;
                try {
                	conn=ConnectionFactory.getConnection();
                	String sql="select * from course studentcourse where cnum in" + Cnum;
                	pst=conn.prepareStatement(sql);		
                    rs = pst.executeQuery();
                    if(rs.next()){
                    	studentcourse = new StudentCourse();
                    	studentcourse.setId(rs.getInt("id"));
                    	studentcourse.setSnum(rs.getString("snum"));
                    	studentcourse.setCnum(rs.getString("cnum"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                	ConnectionFactory.close(rs, pst, conn);
                }
                return studentcourse;
    }

}

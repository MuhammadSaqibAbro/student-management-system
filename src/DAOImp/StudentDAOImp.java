package DAOImp;

import DAO.StudentDAO;

import dbConnection.DBConnection;
import java.beans.Statement;
//import java.awt.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Department;
import model.Student;







public class StudentDAOImp implements StudentDAO{


     private final String SELECT_QUERY = "SELECT * FROM student333";
	private final String INSERT_QUERY = "INSERT INTO student333( category_name,category_code,created_date,created_by,updated_by,bool_active) VALUES (?,?, ?,?,?,?)";
	private final String DELETE_QUERY = "DELETE FROM student333 WHERE s_ID=?";
        private final String CHANGE_QUERY = "UPDATE student333 SET bool_active=? WHERE category_name=?";
	private final String UPDATE_QUERY = "UPDATE student333 SET s_name=?, s_rollno=?, s_city=?, s_email=?, s_age=?, dep_ID=? WHERE s_ID=?";
	private final String SELECT_BY_ID_QUERY = "SELECT id,category_name,category_code FROM student333 WHERE id= ?";


//
//    public  updateStudent(){
//
//
//        Connection con = DBConnection.getConnection();
//        try {
//            Scanner Sc=new Scanner(System.in);
//
//
//            PreparedStatement ps = con.prepareStatement("update student33 set rollno=? where sname=?");
//            Student s=new Student();
////            ps.setString(1,s.setSname);
////            ps.setString(2,rollno);
//            int i= ps.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }








     @Override
    public boolean addStudent(Student s){

         boolean success=false;

        Connection con = DBConnection.getConnection();
        try {
      


            PreparedStatement ps = con.prepareStatement("insert into student333(s_name,s_rollno,s_city,s_email,s_age,dep_ID,crs_ID) values(?,?,?,?,?,?,?)");
            ps.setString(1,s.getSname());
            ps.setString(2,s.getRollno());
            ps.setString(3,s.getCity());
            ps.setString(4,s.getEmail());
            ps.setInt(5,s.getAge());
            int departmentID = s.getDepartment().getDep_ID();
            ps.setInt(6,departmentID);
            int courseID = s.getCourse().getCrs_ID();
            ps.setInt(6,departmentID);
            ps.setInt(7,courseID);
            ps.executeUpdate();
            success=true;

        } catch (SQLException e) {
            success=false;
            throw new RuntimeException(e);
            
        }
      return success;
    }



@Override
    public List<Student> getAllStudent(){
        Connection con = DBConnection.getConnection();
        
        List<Student> stdlist = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from student333 s inner join department33 d on s.dep_ID=d.dep_ID inner join course333 c on s.crs_ID=c.crs_ID;");
            ResultSet rst = ps.executeQuery();
            

            while (rst.next()){
                Student s=new Student();
                s.setId(rst.getInt("s_ID"));
                s.setSname(rst.getString("s_name"));
                s.setRollno(rst.getString("s_rollno"));
                s.setCity(rst.getString("s_city"));
                s.setEmail(rst.getString("s_email"));
                s.setAge(rst.getInt("s_age"));
                Department d=new Department();
                d.setDep_name(rst.getString("dep_name"));
                
                Course c = new Course();
                c.setCrs_name(rst.getString("crs_name"));
                s.setCourse(c);
                
                s.setDepartment(d);
               
                stdlist.add(s);
                
        
                
                
                
                
            }
            return stdlist;
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stdlist;
    }
    
    
    
     @Override
     public boolean updateStudent(Student student) {
        Connection con = DBConnection.getConnection();
        boolean success = true;
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, student.getSname());
             ps.setString(2, student.getRollno());

            ps.setString(3, student.getCity());
            ps.setString(4, student.getEmail());
            ps.setInt(5, student.getAge());
            ps.setInt(6, student.getDepartment().getDep_ID());
            ps.setInt(7, student.getId());
            ps.execute();
            success = true;
            System.out.println("Student Updated.");
        } catch (SQLException e) {
             success = false;
            e.printStackTrace();
        }

        return success;
    }
    
    
    
    
    
     @Override
        public Student getStudentById(Integer id) {
                Connection con = DBConnection.getConnection();

        Student s = new Student();
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student333 where s_ID=?");

            ps.setInt(1, id);
            ResultSet rst = ps.executeQuery();
            
        while(rst.next()){
                s.setId(rst.getInt("s_ID"));
                s.setSname(rst.getString("s_name"));  
                s.setRollno(rst.getString("s_rollno"));
                s.setCity(rst.getString("s_city"));
                s.setEmail(rst.getString("s_email"));
                s.setAge(rst.getInt("s_age"));
                Department d = new Department();
                d.setDep_ID(rst.getInt("dep_ID"));
//                d.setDep_name("dep_name");
//                d.setDep_code("dep_code");
                
                s.setDepartment(d);

            
            return s;
        }
        con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
        
        
        
     @Override
         public boolean deleteStudent(Student student) {
        Connection con = DBConnection.getConnection();
        boolean success = false;
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
            ps.setInt(1, student.getId());
            ps.execute();
            success = true;

        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        return success;
    }




}


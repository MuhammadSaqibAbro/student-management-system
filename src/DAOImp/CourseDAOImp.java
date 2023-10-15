/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImp;

import DAO.CourseDAO;





import java.sql.PreparedStatement;
import dbConnection.DBConnection;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import model.Student;



            

/**
 *
 * @author SAQIB
 */
public class CourseDAOImp implements CourseDAO{
    private final String DELETE_QUERY = "DELETE FROM course333 WHERE crs_ID=?";
    	private final String SELECT_BY_ID_QUERY = "SELECT crs_ID,crs_name,crs_code FROM course333 WHERE crs_ID= ?";
        	private final String UPDATE_QUERY = "UPDATE course333 SET crs_name=? ,crs_code=? WHERE crs_ID=?";
 List<Course> crslist = new ArrayList<>();

    

    @Override
    public List<Course> getAllCourse(){
         boolean success=false;
                

       Connection con = DBConnection.getConnection();



try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM course333");
            ResultSet rst = ps.executeQuery();
            
            Course c=new Course();
            while (rst.next()){
              
                c.setCrs_ID(rst.getInt("crs_ID"));
                c.setCrs_name(rst.getString("crs_name"));
                c.setCrs_code(rst.getString("crs_code"));
                
               
              //  s.setDepartement(rst.getString("dep_name"));
                
                crslist.add(c);
                
        
                
                
                
                
            }
            return crslist;
        } 
         catch(Exception e){
             
         }

        return crslist;
           }
    
    
    	@Override
	public boolean deleteCourse(Integer id) {
            boolean success= false;
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setInt(1, id);
			ps.execute();
			success=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return success;
	}

    @Override
    public boolean addCourse(Course c) {
        boolean success=false;

                Connection con = DBConnection.getConnection();

        try {
      


            PreparedStatement ps = con.prepareStatement("insert into course333(crs_name,crs_code) values(?,?)");
            
            ps.setString(1,c.getCrs_name());
            ps.setString(2,c.getCrs_code());
           
           // ps.setString(6,departement);
            int i=ps.executeUpdate();
            success=true;

        } catch (SQLException e) {
            success=false;
            throw new RuntimeException(e);
            
        }
      return success;
            }

    @Override
    public Course getCourseById(Integer id) {
       Connection con = DBConnection.getConnection();
		Student s=new Student();
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
                            Course c=new Course();
				c.setCrs_ID(rst.getInt("crs_ID"));
				c.setCrs_name(rst.getString("crs_name"));
                                c.setCrs_code(rst.getString("crs_code"));
                                return c;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public boolean updateCourse(Course course) {
            boolean success= false;
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, course.getCrs_name());
                        ps.setString(2, course.getCrs_code());
                        ps.setInt(3, course.getCrs_ID());
			ps.execute();
			success=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return success;
    }

    @Override
    public Course getCourseIDByName(String name) {
        Connection con = DBConnection.getConnection();
        Student s = new Student();
        try {
            PreparedStatement ps = con.prepareStatement("select * from course333 where crs_name=?");

            ps.setString(1, name);
            ResultSet rst = ps.executeQuery();
            while (rst.next()) {
                Course c=new Course();
                c.setCrs_ID(rst.getInt("crs_ID"));
                c.setCrs_name(rst.getString("crs_name"));
                c.setCrs_code(rst.getString("crs_code"));
                  return c;
            }
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    }



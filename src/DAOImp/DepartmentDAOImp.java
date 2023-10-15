/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImp;

import DAO.DepartmentDAO;

import dbConnection.DBConnection;
import java.util.List;
import model.Department;


import DAO.StudentDAO;
import dbConnection.DBConnection;
import java.sql.Connection;
//import java.awt.List;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Student;

/**
 *
 * @author SAQIB
 */
public class DepartmentDAOImp implements DepartmentDAO{
            List<Department> deplist = new ArrayList<>();
           private final String UPDATE_QUERY = "UPDATE department33 SET dep_name=?, dep_code= ? WHERE dep_ID=?";
           private final String DELETE_QUERY = "DELETE FROM department33 WHERE dep_ID=?";
         @Override
    public boolean addDepartment(Department d){

         boolean success=false;

                Connection con = DBConnection.getConnection();

        try {
      


            PreparedStatement ps = con.prepareStatement("insert into department33(dep_name,dep_code) values(?,?)");
           

            ps.setString(1,d.getDep_name());
            ps.setString(2,d.getDep_code());
           
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
    public List<Department> getAllDepartment(){
        Connection con = DBConnection.getConnection();
        
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM department33");
            ResultSet rst = ps.executeQuery();
            
Department d=new Department();
            while (rst.next()){
                
                d.setDep_ID(rst.getInt("dep_ID"));
                d.setDep_name(rst.getString("dep_name"));
                d.setDep_code(rst.getString("dep_code"));
                
               
              //  s.setDepartement(rst.getString("dep_name"));
                
                deplist.add(d);
                
        
                
                
                
                
            }
            return deplist;
        } catch (SQLException ex) {
            Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
        }

        return deplist;
    }
    
    
    
    
    
    
    
            @Override
    public Department getDepartmentByName(String name) {
                Connection con = DBConnection.getConnection();

        Student s = new Student();
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT distinct * FROM department33 where dep_name=?");

            ps.setString(1, name);
            ResultSet rst = ps.executeQuery();
            while (rst.next()) {
        Department d=new Department();
                d.setDep_ID(rst.getInt("dep_ID"));
                d.setDep_name(rst.getString("dep_name"));
                d.setDep_code(rst.getString("dep_code"));
               
             return d;
            }
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
    
    
    
            @Override
    public Department getDepartmentById(int dep_ID) {
                Connection con = DBConnection.getConnection();

        Student s = new Student();
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT distinct * FROM department33 where dep_ID=?");

            ps.setInt(1, dep_ID);
            ResultSet rst = ps.executeQuery();
            while (rst.next()) {
        Department d=new Department();
                d.setDep_ID(rst.getInt("dep_ID"));
                d.setDep_name(rst.getString("dep_name"));
                d.setDep_code(rst.getString("dep_code"));
               
             return d;
            }
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
            @Override
    public boolean updateDepartment(Department department) {
		Connection con = DBConnection.getConnection();
                boolean success;
		try {
			PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, department.getDep_name());
                        ps.setString(2, department.getDep_code());
			ps.setInt(3, department.getDep_ID());
			ps.execute();
			success=true;
		} catch (SQLException e) {
			success=false;
			e.printStackTrace();
		}
                return success;
	}
    
    @Override
	public boolean deleteDepartment(Integer id) {
		Connection con = DBConnection.getConnection();
                boolean success;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setInt(1, id);
			ps.execute();
			success=true;
		} catch (SQLException e) {
			success=false;
			e.printStackTrace();
		}
            return success;
	}


}




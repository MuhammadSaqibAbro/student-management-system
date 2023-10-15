/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import model.Course;

/**
 *
 * @author SAQIB
 */
public interface CourseDAO {
    public List<Course> getAllCourse();
    public boolean addCourse(Course c);
    
	
	public boolean deleteCourse(Integer id);
        
      
	public Course getCourseById(Integer id);
	public boolean updateCourse(Course course);

        public Course getCourseIDByName(String name);
	

       
	
}

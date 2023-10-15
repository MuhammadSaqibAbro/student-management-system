/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import model.Student;

/**
 *
 * @author SAQIB
 */
public interface StudentDAO {
    public List<Student> getAllStudent();
    public boolean addStudent(Student s);
    public Student getStudentById(Integer id);
     public boolean updateStudent(Student student);
     public boolean deleteStudent(Student student);
    
}

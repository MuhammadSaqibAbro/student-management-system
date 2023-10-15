/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import model.Department;


/**
 *
 * @author SAQIB
 */
public interface DepartmentDAO {
     public List<Department> getAllDepartment();
    public boolean addDepartment(Department d);
    public Department getDepartmentByName(String name);

    public Department getDepartmentById(int dep_ID);
    public boolean updateDepartment(Department department);
    public boolean deleteDepartment(Integer id);
}

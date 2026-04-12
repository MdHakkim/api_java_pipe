package com.example.learing_spring.Services;

import com.example.learing_spring.Model.Employee;
import com.example.learing_spring.Respository.EmployeeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmployeeRep employeeRep;
//    private List<Employee> employees = new ArrayList<>();
    public List<Employee> getAllEmployee(){
        return employeeRep.findAll();
    }
    public String insertEmp(Employee emp){
        employeeRep.save(emp);
        return "Employee inserted successfully";
    }
    public Employee getOneEmp(int id, String name){
        return employeeRep.findByIdAndName(id, name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    public String updateEmp(Employee employee){

        employeeRep.findById(employee.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employeeRep.save(employee);
        return "Employee updated";
    }

    public String deleteEmp(int id){
         employeeRep.deleteById(id);
        return "Employee deleted";
    }

    public List<Employee> customQuery(int id){
        return employeeRep.customQury(id);
    }

    public List<Employee> pagination(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage = employeeRep.paginations(pageable); // returns Page<Employee>
        return employeePage.getContent();
    }
}

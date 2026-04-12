package com.example.learing_spring.RestController;

import com.example.learing_spring.Model.Employee;
import com.example.learing_spring.Security.JwtUtility;
import com.example.learing_spring.Services.EmpService;
import com.example.learing_spring.Services.HomeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class HomeApi {
    @Autowired
    HomeService homeService;
    @Autowired
    EmpService empService;
    @GetMapping("/home")
    List<String> getHome(){
        return homeService.getHome();

    }
    @GetMapping
    public List<Employee> getAllEmp(){
        return empService.getAllEmployee();
    }
    @PostMapping
    public String insertEmployee(@Valid @RequestBody Employee employee){
        return empService.insertEmp(employee);
    }
    @PostMapping("/oneemp")
    public Employee getOneEmployee(@RequestBody Employee employee){
        Employee emp = empService.getOneEmp(employee.getId(), employee.getName());
        return ResponseEntity.ok(emp).getBody();
    }
    @PostMapping("/updateemp")
    public String updateEmployee(@RequestBody Employee employee){
        return empService.updateEmp(employee);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id){
        return empService.deleteEmp(id);
    }
    @PostMapping("/{id}")
    public List<Employee> customequery(@PathVariable int id){
        return empService.customQuery(id);
    }

    @GetMapping("/allData")
    public List<Employee> pagination(@RequestParam int page,@RequestParam int size){
        return empService.pagination(page,size);
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String name){

        JwtUtility jwt = new JwtUtility();
        return jwt.generateToken(name);
    }
}

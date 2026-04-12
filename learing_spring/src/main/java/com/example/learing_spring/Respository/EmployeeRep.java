package com.example.learing_spring.Respository;

import com.example.learing_spring.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

public interface EmployeeRep extends JpaRepository<Employee,Integer> {
        Optional<Employee> findByIdAndName(Integer id, String name);

        @Query("SELECT e FROM Employee e ")
        List<Employee> customQury(@Param("name") int id);

        @Query("SELECT e FROM Employee e ")
        Page<Employee> paginations(Pageable pageable);
}

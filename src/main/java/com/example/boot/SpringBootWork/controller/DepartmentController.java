package com.example.boot.SpringBootWork.controller;

import com.example.boot.SpringBootWork.entity.Department;
import com.example.boot.SpringBootWork.error.DepartmentNotFoundException;
import com.example.boot.SpringBootWork.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService departmentService;
    @PostMapping("/dept")
    public Department saveDepartment(@Valid @RequestBody Department department){

        LOGGER.info("Post request of Department Controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

        LOGGER.info("Get By Id request of Department Controller");
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping("/dept")
    public List<Department> getDepartment(){

        LOGGER.info("Get request of Department Controller");
        return departmentService.getDepartment();
    }

    @DeleteMapping("/dept/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department Data Deleted Sucessfully ";
    }

    @DeleteMapping("/dept")
    public String deleteDepartment(){
        departmentService.deleteDepartment();
        return "All Data deleted Sucessfully ";
    }

    @PutMapping("/dept/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }


    @GetMapping("/dept/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}

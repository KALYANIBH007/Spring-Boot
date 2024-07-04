package com.example.boot.SpringBootWork.service;

import com.example.boot.SpringBootWork.entity.Department;
import com.example.boot.SpringBootWork.error.DepartmentNotFoundException;
import com.example.boot.SpringBootWork.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException{

        Optional<Department> department= departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department wrt that ID not present");
        }


        return department.get();
    }

    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public void deleteDepartment() {
        departmentRepository.deleteAll();
    }

    public Department updateDepartment(Long departmentId, Department department) {
        Department deptDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {

            deptDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {

            deptDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {

            deptDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(deptDB);
    }
    public Department getDepartmentByName(String departmentName){
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}

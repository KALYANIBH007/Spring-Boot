package com.example.boot.SpringBootWork.repository;

import com.example.boot.SpringBootWork.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}

package com.example.boot.SpringBootWork.repository;

import com.example.boot.SpringBootWork.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentAddress("Chennai")
                .departmentCode("ME-7")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void validateDepartmentById(){

        Optional<Department> found = departmentRepository.findById(1L);

        assertEquals(found.get().getDepartmentName(), "Mechanical Engineering");
    }
}
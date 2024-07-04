package com.example.boot.SpringBootWork.service;

import com.example.boot.SpringBootWork.entity.Department;
import com.example.boot.SpringBootWork.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Mumbai")
                .departmentCode("I-7")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    public void validDepartmentName(){

        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());

    }

    @Test
    public void invalidDepartmentName(){
        String departmentName = "ITT";
        Department found = departmentService.getDepartmentByName("IT");

        assertNotEquals(departmentName,found.getDepartmentName());
    }
}
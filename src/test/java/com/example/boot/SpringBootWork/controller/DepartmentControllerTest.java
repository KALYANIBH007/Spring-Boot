package com.example.boot.SpringBootWork.controller;

import com.example.boot.SpringBootWork.entity.Department;
import com.example.boot.SpringBootWork.error.DepartmentNotFoundException;
import com.example.boot.SpringBootWork.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class DepartmentControllerTest {

    @MockBean
    DepartmentService departmentService;

    @Autowired
    MockMvc mockMvc;

    private Department department;

    @BeforeEach
    void setUp() {

        department = Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentAddress("Chennai")
                .departmentCode("ME-7")
                .depatmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {

        Department inputDepartment = Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentAddress("Chennai")
                .departmentCode("ME-7")
                .build();


        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);


        mockMvc.perform(post("/dept").contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "                \"departmentName\":\"Mechanical Engineering\",\n" +
                                "                \"departmentAddress\":\"Chennai\",\n" +
                                "                \"departmentCode\":\"ME-7\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getDepartmentById() throws Exception {

        Mockito.when(departmentService.getDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/dept/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
package com.example.Employee_Management_System.Controller;

import com.example.Employee_Management_System.Resources.model.Salary;
import com.example.Employee_Management_System.Resources.pojo.Response;
import com.example.Employee_Management_System.Resources.request.SalaryRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class SalaryControllerTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(SalaryControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Test
    void testInvalidGetById() throws Exception {

        int salaryId = 1;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/salaries/{id}", salaryId);

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        // Testing status code
        assertEquals(response.getStatus(), 404);

        String body = response.getContentAsString();

        //Converted Json string to Response.class
        ObjectMapper mapper = new ObjectMapper();
        Response res = mapper.readValue(body, Response.class);

        // Testing the error message
        assertEquals(res.getMessage(), String.format("Salary not found by id: %s", salaryId));
    }

    @Test
    void testGetById() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Date date = Date.valueOf("2020-4-10");
        Date date1 = Date.valueOf("2020-10-10");

        //TODO: No 2 or more than 2 employees can have same email or phone number
        SalaryRequest salaryRequest = new SalaryRequest(
                50000,
                date,
                date1,
                true
        );

        MockHttpServletRequestBuilder requestSalary = MockMvcRequestBuilders.post("/salaries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(salaryRequest));

        String salaryBody = mockMvc.perform(requestSalary)
                .andReturn()
                .getResponse()
                .getContentAsString();

        Salary actualSalary = mapper.readValue(salaryBody, Salary.class);

        int salaryId = actualSalary.getId();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/salaries/{id}", salaryId);

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        // Testing status code
        assertEquals(response.getStatus(), 200);

        String body = response.getContentAsString();

        //Converted Json string to Response.class
        Salary expectedSalary = mapper.readValue(body, Salary.class);
        assertEquals(actualSalary, expectedSalary);
    }

    @Test
    void testCreateSalary() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Date date = Date.valueOf("2020-4-10");
        Date date1 = Date.valueOf("2020-10-10");

        SalaryRequest salaryRequest = new SalaryRequest(
                50000,
                date,
                date1,
                true
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/salaries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(salaryRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateSalary ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 201);
    }

    @Test
    void testWithInvalidInputCreateSalary() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Date date = Date.valueOf("2020-4-10");
        Date date1 = Date.valueOf("2020-10-10");

        //TODO: Test all the inputs
        SalaryRequest salaryRequest = new SalaryRequest(
                0,
                date,
                date1,
                true
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/salaries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(salaryRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateSalary ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 400);

        Response res = mapper.readValue(body, Response.class);

        // Testing the error message
        assertEquals(res.getMessage(), "Salary should be more than 0");
    }

//    @Test
//    void testDeleteById() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        Date date = Date.valueOf("2020-4-10");
//        Date date1 = Date.valueOf("2020-10-10");
//
//        //TODO: No 2 or more than 2 employees can have same email or phone number
//        SalaryRequest salaryRequest = new SalaryRequest(
//                50000,
//                date,
//                date1,
//                true
//        );
//
//        MockHttpServletRequestBuilder requestSalary = MockMvcRequestBuilders.post("/salaries")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(salaryRequest));
//
//        String salaryBody = mockMvc.perform(requestSalary)
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        Salary actualSalary = mapper.readValue(salaryBody, Salary.class);
//
//        int salaryId = actualSalary.getId();
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/salaries/{id}",salaryId);
//
//        MockHttpServletResponse response = mockMvc.perform(request)
//                .andReturn()
//                .getResponse();
//
//        // Testing status code
//        assertEquals(response.getStatus(), 200);
////
////        String body = response.getContentAsString();
////
////        //Converted Json string to Response.class
////        Salary expectedSalary = mapper.readValue(body, Salary.class);
////        assertEquals(actualSalary, expectedSalary);
//    }

}
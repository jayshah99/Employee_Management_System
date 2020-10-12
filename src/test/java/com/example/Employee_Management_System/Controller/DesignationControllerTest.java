package com.example.Employee_Management_System.Controller;

import com.example.Employee_Management_System.Resources.model.Designation;
import com.example.Employee_Management_System.Resources.pojo.Response;
import com.example.Employee_Management_System.Resources.request.DesignationRequest;
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
class DesignationControllerTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(DesignationControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Test
    void testInvalidGetById() throws Exception {

        int designationId = 1;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/designations/{id}", designationId);

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
        assertEquals(res.getMessage(), String.format("Designation not found by id: %s", designationId));
    }

    @Test
    void testGetById() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Date date = Date.valueOf("2020-4-10");
        Date date1 = Date.valueOf("2020-10-10");

        //TODO: No 2 or more than 2 employees can have same email or phone number
        DesignationRequest designationRequest = new DesignationRequest(
                "code",
                date,
                date1,
                true
        );

        MockHttpServletRequestBuilder requestDesignation = MockMvcRequestBuilders.post("/designations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(designationRequest));

        String designationBody = mockMvc.perform(requestDesignation)
                .andReturn()
                .getResponse()
                .getContentAsString();

        Designation actualDesignation = mapper.readValue(designationBody, Designation.class);

        int designationId = actualDesignation.getId();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/designations/{id}", designationId);

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        // Testing status code
        assertEquals(response.getStatus(), 200);

        String body = response.getContentAsString();

        //Converted Json string to Response.class
        Designation expectedDesignation = mapper.readValue(body, Designation.class);
        assertEquals(actualDesignation, expectedDesignation);
    }

    @Test
    void testCreateDesignation() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Date date = Date.valueOf("2020-4-10");
        Date date1 = Date.valueOf("2020-10-10");

        DesignationRequest designationRequest = new DesignationRequest(
                "code",
                date,
                date1,
                true
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/designations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(designationRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateDesignation ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 201);
    }

    @Test
    void testWithInvalidInputCreateDesignation() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Date date = Date.valueOf("2020-4-10");
        Date date1 = Date.valueOf("2020-10-10");

        //TODO: Test all the inputs
        DesignationRequest designationRequest = new DesignationRequest(
                "",
                date,
                date1,
                true
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/designations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(designationRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateDesignation ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 400);

        Response res = mapper.readValue(body, Response.class);

        // Testing the error message
        assertEquals(res.getMessage(), "Designation cannot be empty");
    }

}
package com.example.Employee_Management_System.Controller;

import com.example.Employee_Management_System.Resources.model.Employee;
import com.example.Employee_Management_System.Resources.pojo.Response;
import com.example.Employee_Management_System.Resources.request.EmployeeRequest;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Test
    void testInvalidGetById() throws Exception {

        int employeeId = 10;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/employees/{id}", employeeId);

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
        assertEquals(res.getMessage(), String.format("Employee not found by id: %s", employeeId));
    }

    @Test
    void testGetById() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        //TODO: No 2 or more than 2 employees can have same email or phone number
        EmployeeRequest employeeRequest = new EmployeeRequest(
                "Rahul Prasad",
                28,
                "Kolkata",
                "Male",
                "aac@gmail.com",
                "90000543210",
                true,
                null,
                null
        );

        MockHttpServletRequestBuilder requestEmployee = MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeRequest));

        String employeeBody = mockMvc.perform(requestEmployee)
                .andReturn()
                .getResponse()
                .getContentAsString();

        Employee actualEmployee = mapper.readValue(employeeBody, Employee.class);

        int employeeId = actualEmployee.getId();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/employees/{id}", employeeId);

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        // Testing status code
        assertEquals(response.getStatus(), 200);

        String body = response.getContentAsString();

        //Converted Json string to Response.class
        Employee expectedEmployee = mapper.readValue(body, Employee.class);
        assertEquals(actualEmployee, expectedEmployee);
    }

    @Test
    void testCreateEmployee() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        EmployeeRequest employeeRequest = new EmployeeRequest(
                "Rahul Prasad",
                28,
                "Kolkata",
                "Male",
                "abc@gmail.com",
                "9876543210",
                true,
                null,
                null
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateEmployee ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 201);
    }

    @Test
    void testWithInvalidNameInputCreateEmployee() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        //TODO: Test all the inputs
        EmployeeRequest employeeRequest = new EmployeeRequest(
                "", // Passing empty name
                28,
                "Kolkata",
                "Male",
                "abc@gmail.com",
                "9876543210",
                true,
                null,
                null
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateEmployee ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 400);

        Response res = mapper.readValue(body, Response.class);

        // Testing the error message
        assertEquals(res.getMessage(), "Name cannot be empty");
    }

    @Test
    void testWithInvalidAgeInputCreateEmployee() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        //TODO: Test all the inputs
        EmployeeRequest employeeRequest = new EmployeeRequest(
                "Sid", // Passing empty name
                10,
                "Kolkata",
                "Male",
                "abc@gmail.com",
                "9876543210",
                true,
                null,
                null
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateEmployee ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 400);

        Response res = mapper.readValue(body, Response.class);

        // Testing the error message
        assertEquals(res.getMessage(), "Age should be equal or more than 18");
    }

    @Test
    void testWithInvalidAddressInputCreateEmployee() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        //TODO: Test all the inputs
        EmployeeRequest employeeRequest = new EmployeeRequest(
                "Sid", // Passing empty name
                28,
                "",
                "Male",
                "abc@gmail.com",
                "9876543210",
                true,
                null,
                null
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateEmployee ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 400);

        Response res = mapper.readValue(body, Response.class);

        // Testing the error message
        assertEquals(res.getMessage(), "Address cannot be empty");
    }

    @Test
    void testWithInvalidGenderInputCreateEmployee() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        //TODO: Test all the inputs
        EmployeeRequest employeeRequest = new EmployeeRequest(
                "Sid", // Passing empty name
                28,
                "kolkata",
                "",
                "abc@gmail.com",
                "9876543210",
                true,
                null,
                null
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateEmployee ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 400);

        Response res = mapper.readValue(body, Response.class);

        // Testing the error message
        assertEquals(res.getMessage(), "Gender cannot be empty");
    }

    @Test
    void testWithInvalidEmailInputCreateEmployee() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        //TODO: Test all the inputs
        EmployeeRequest employeeRequest = new EmployeeRequest(
                "Sid", // Passing empty name
                28,
                "kolkata",
                "male",
                "abc@gmail.com",
                "8216543210",
                true,
                null,
                null
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateEmployee ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 201);

        Response res = mapper.readValue(body, Response.class);

        // Testing the error message
        assertEquals(res.getMessage(), "Employee with email already present");
    }

    @Test
    void testWithInvalidPhoneNumberInputCreateEmployee() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        //TODO: Test all the inputs
        EmployeeRequest employeeRequest = new EmployeeRequest(
                "Sid", // Passing empty name
                28,
                "kolkata",
                "male",
                "abcdefgdi@gmail.com",
                "9876543210",
                true,
                null,
                null
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeRequest));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        String body = response.getContentAsString();
        LOGGER.info("### testCreateEmployee ### Response: {}", body);

        // Testing status code
        assertEquals(response.getStatus(), 201);

        Response res = mapper.readValue(body, Response.class);

        // Testing the error message
        assertEquals(res.getMessage(), "Employee with phone number already present");
    }

    @Test
    void testValidUpdateById() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        EmployeeRequest employeeRequest = new EmployeeRequest(
                "Rahul Prasad",
                28,
                "Kolkata",
                "Male",
                "bc@gmail.com",
                "9116543210",
                true,
                null,
                null
        );

        MockHttpServletRequestBuilder requestEmployee = MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeRequest));

        String employeeBody = mockMvc.perform(requestEmployee)
                .andReturn()
                .getResponse()
                .getContentAsString();

        Employee actualEmployee = mapper.readValue(employeeBody, Employee.class);

        int employeeId = actualEmployee.getId();

        EmployeeRequest employeeRequest1 = new EmployeeRequest(
                "Rahul",
                24,
                "Kolkata",
                "Male",
                "abcdef@gmail.com",
                "9876510000",
                true,
                null,
                null
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employeeRequest1));

        MockHttpServletResponse response = mockMvc.perform(request)
                .andReturn()
                .getResponse();

        // Testing status code
        assertEquals(response.getStatus(), 200);

//        String body = response.getContentAsString();
//
//        //Converted Json string to Response.class
//        Response res = mapper.readValue(body, Response.class);
//
//        // Testing the error message
//        assertEquals(res.getMessage(), String.format("Employee not found by id: %s", employeeId));
    }

    @Test
    void testDeleteById() throws Exception {
    ObjectMapper mapper = new ObjectMapper();

    //TODO: No 2 or more than 2 employees can have same email or phone number
    EmployeeRequest employeeRequest = new EmployeeRequest(
            "Rahul Prasad",
            28,
            "Kolkata",
            "Male",
            "aasabc@gmail.com",
            "9814143210",
            true,
            null,
            null
    );

    MockHttpServletRequestBuilder requestEmployee = MockMvcRequestBuilders.post("/employees")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(employeeRequest));

    String employeeBody = mockMvc.perform(requestEmployee)
            .andReturn()
            .getResponse()
            .getContentAsString();

    Employee actualEmployee = mapper.readValue(employeeBody, Employee.class);

    int employeeId = actualEmployee.getId();
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/employees/{id}", employeeId);

    MockHttpServletResponse response = mockMvc.perform(request)
            .andReturn()
            .getResponse();

    // Testing status code
    assertEquals(response.getStatus(), 200);

//    String body = response.getContentAsString();
//
//    //Converted Json string to Response.class
//    Employee expectedEmployee = mapper.readValue(body, Employee.class);
//    assertEquals(actualEmployee, expectedEmployee);
}


}
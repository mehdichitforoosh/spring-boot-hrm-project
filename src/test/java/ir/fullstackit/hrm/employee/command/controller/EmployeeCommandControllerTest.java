package ir.fullstackit.hrm.employee.command.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.fullstackit.App;
import ir.fullstackit.hrm.employee.command.controller.jsons.CreateEmployeeJsonObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class EmployeeCommandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnMediaTypeNotSupportedOnIncorrectMediaType() throws Exception {
        this.mockMvc.perform(post("/employees")
                .contentType(MediaType.TEXT_PLAIN)
                .content(""))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void shouldReturnBadRequestResponseOnEmptyEmployeeJson() throws Exception {
        this.mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnBadRequestResponseOnInvalidEmployeeJson() throws Exception {
        // Given
        ObjectMapper mapper = new ObjectMapper();
        CreateEmployeeJsonObject jsonObject = new CreateEmployeeJsonObject("M", "", null, "", "", "", "");
        String content = mapper.writeValueAsString(jsonObject);
        // When
        this.mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnBadRequestResponseOnInvalidJson() throws Exception {
        // Given
        String content = "{\"firstName\":\"Mehdi\"}";
        // When
        this.mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                // Then
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnOkOnValidEmployeeJson() throws Exception {
        // Given
        ObjectMapper mapper = new ObjectMapper();
        CreateEmployeeJsonObject jsonObject = new CreateEmployeeJsonObject("Meh", "1", null, "", "", "", "");
        String content = mapper.writeValueAsString(jsonObject);
        // When
        this.mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                // Then
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id",is(notNullValue())))
                .andExpect(status().isOk());
    }
}

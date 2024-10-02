package com.vds.huylq33.springbootdemo;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.ResultMatcher.matchAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vds.huylq33.springbootdemo.model.Journal;
import com.vds.huylq33.springbootdemo.service.JournalService;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
class ApplicationTests {

    final String SPRING_BOOT_MATCH = "Spring Boot";
    final String CLOUD_MATCH = "Cloud";

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private JournalService journalService;

    @Test
    void getAllJournals() throws Exception {
        when(journalService.getAll()).thenReturn(Arrays.asList(
            new Journal(1L, "Get to know Spring Boot", "Today I will learn Spring Boot"),
            new Journal(2L, "Simple Spring Boot Project", "I will do my first Spring Boot Project")
        ));

        mockMvc.perform(get("/journals").accept(APPLICATION_JSON)) // Build request
            .andDo(print()) // Log
            .andExpect(matchAll( // Expect response's behavior
                status().isOk(),
                content().contentType(APPLICATION_JSON),
                jsonPath("$").exists(),
                jsonPath("$[0].title", containsString(SPRING_BOOT_MATCH))
            ));
    }

    @Test
    void findByTitle() throws Exception {
        when(journalService.get(anyString())).thenReturn(Arrays.asList(
            new Journal(1L, "Cloud Test", "Random summary")
        ));

        mockMvc.perform(get("/journals/{title}", CLOUD_MATCH))
            .andDo(print())
            .andExpect(matchAll(
                status().isOk(),
                jsonPath("$").exists(),
                jsonPath("$[0].title", containsString(CLOUD_MATCH))
            ));
    }

    @Test
    void add() throws Exception {
        final String requestBody = toJsonString(new Journal(
            5L,
            "Spring Boot Testing",
            "Create Spring Boot Tests"));

        MockHttpServletRequestBuilder request = post("/journals")
            .content(requestBody)
            .contentType(APPLICATION_JSON);

        mockMvc.perform(request)
            .andDo(print())
            .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        final String requestBody = toJsonString(new Journal(
            2L,
            "Cloud Testing Update",
            "Update Cloud Tests"));

        MockHttpServletRequestBuilder requestBuilder = put("/journals/{id}", 2L)
            .content(requestBody)
            .contentType(APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/journals/{id}", 3L))
            .andDo(print())
            .andExpect(status().isNoContent());
    }

    String toJsonString(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
}

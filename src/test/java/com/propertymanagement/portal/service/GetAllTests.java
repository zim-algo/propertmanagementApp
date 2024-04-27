package com.propertymanagement.portal.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.propertymanagement.portal.PortalApplication;
import com.propertymanagement.portal.repository.OfferRepository;
import com.propertymanagement.portal.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = PortalApplication.class)
@AutoConfigureMockMvc
public class GetAllTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PropertyRepository propertyRepository;

    String getAuthToken(String username, String password) throws Exception {
        String credentials = String.format("{ \"email\" : \"%s\", \"password\": \"%s\"}", username, password);
        MvcResult result = mockMvc.perform(post("/api/v1/auth/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(credentials))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        JsonNode jsonNode = new ObjectMapper().readTree(result.getResponse().getContentAsString());
        return jsonNode.get("access_token").asText();
    }

    @Test
    void testGetAll() throws Exception {
        String token = getAuthToken("customer@mail.com", "password");
        mockMvc.perform(get("/api/v1/properties/all")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].name").value("Charming Villa"));
    }

}

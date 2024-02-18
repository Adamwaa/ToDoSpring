package io.github.Adam;

import io.github.Adam.DTO.LanguageDTO;
import io.github.Adam.controller.LanguageController;
import io.github.Adam.service.LanguageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@WebMvcTest(LanguageController.class)
public class LanguageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LanguageService service;
    private List<LanguageDTO> languageList;

    @BeforeEach
    void setUp() {
        LanguageDTO lang1 = new LanguageDTO(1, "English");
        LanguageDTO lang2 = new LanguageDTO(2, "Polish");
        languageList = Arrays.asList(lang1, lang2);
        when(service.findAll()).thenReturn(languageList);
    }

    @Test
    void findAllLang_ShouldReturnAllLanguages() throws Exception {
        mockMvc.perform(get("/api/langs")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2))) // Sprawdza czy lista ma 2 elementy
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].code", is("English")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].code", is("Polish")));
    }

}

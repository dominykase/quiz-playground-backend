package com.quizplayground.quizplayground.feature;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.quizplayground.quizplayground.QuizplaygroundApplication;
import com.quizplayground.quizplayground.models.Quiz;
import com.quizplayground.quizplayground.repositories.QuizRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = QuizplaygroundApplication.class)
@AutoConfigureMockMvc
public class QuizControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private QuizRepository quizRepository;

    @Test
    public void testGetAllQuizzes() throws Exception {
        Quiz quiz = new Quiz();
        quiz.setName("test_name");
        quiz.setDescription("test_description");
        quiz = this.quizRepository.save(quiz);

        mvc.perform(get("/quiz").contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("test_name"))
                .andExpect(jsonPath("$[0].description").value("test_description"));
    }
}

package bg.softuni.portfolio.controllers;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest extends ControllerTestBase {

    @Test
    public void indexShouldReturnCorrectView() throws Exception {

        this.mockMvc
                .perform(get("/"))
                .andExpect(view().name("/index"));
    }

}

package bg.softuni.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public class ControllerTestBase {

    @Autowired
    protected MockMvc mockMvc;
}

package bg.softuni.portfolio;

import bg.softuni.portfolio.web.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PortfolioApplicationTests {

    @Autowired
    private HomeController homeController;

    @Test
    void contextLoads() {
        assertThat(homeController).isNotNull();
    }

}

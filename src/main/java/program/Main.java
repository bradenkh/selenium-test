package program;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import td.api.HttpCommunication.ResourceType;
import td.api.Logging.History;
import td.api.TeamDynamix;

import java.util.ArrayList;
import java.util.Map;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        History history = new History(ResourceType.APPLICATION, "Ticket deleter");
        TeamDynamix tdApi = new TeamDynamix(System.getenv("TD_API_BASE_URL"), System.getenv("USERNAME"), System.getenv("PASSWORD"), history);

        System.setProperty("webdriver.chrome.driver","C:/Users/bradenkh/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        TdWebDriverUtils webUtils = new TdWebDriverUtils();
        webUtils.loginToTD(driver);

        TdApiUtils apiUtils = new TdApiUtils();
        ArrayList<Map<String,String>> tickets = apiUtils.getIDsFromReport(tdApi, 21061);
        for (Map<String, String> ticket : tickets) {
            webUtils.deleteTicket(ticket.get("TicketID"), );
        }


    }

}

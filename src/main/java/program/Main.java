package program;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
import java.util.Scanner;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        History history = new History(ResourceType.APPLICATION, "Ticket deleter");
        TeamDynamix tdApi = new TeamDynamix(System.getenv("TD_API_BASE_URL"), System.getenv("USERNAME"), System.getenv("PASSWORD"), history);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        TdWebDriverUtils webUtils = new TdWebDriverUtils();
        webUtils.loginToTD(driver);

        TdApiUtils apiUtils = new TdApiUtils();
        //prompt user for report id
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter a report id: ");
        String reportId = myObj.nextLine();  // Read user input

        //check if string is a number
        try {
            Integer.parseInt(reportId);
        } catch (NumberFormatException e) {
            System.out.println("Report id is not a number");
            System.exit(0);
        }

        ArrayList<Map<String,String>> tickets = apiUtils.getIDsFromReport(tdApi, Integer.parseInt(reportId));
        for (Map<String, String> ticket : tickets) {
            webUtils.deleteTicket(ticket.get("TicketID"), apiUtils.getAppId(ticket.get("AppName")), driver);
        }
        driver.quit();

    }

}

package program;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TdWebDriverUtils {
    public void loginToTD(WebDriver driver) {
        try {
            driver.get("https://td.byui.edu/TDNext/Home/Desktop/Default.aspx");
            System.out.println("Please log in to TD within the next 2 minutes");
            new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(By.id("appsMenuButton")));
        }
        catch (WebDriverException e) {
            e.printStackTrace();
        }

    }

    public void deleteTicket(String ticketId, String appId, WebDriver driver) {
        String url = "https://td.byui.edu/TDAdmin/fcb76cab-d63e-41d6-a1f0-34c67299d6bf/" + appId + "/Tickets/TicketDet.aspx?TicketID=" + ticketId;
        driver.get(url);
        driver.manage().window().setSize(new Dimension(968, 1020));
        driver.findElement(By.id("btnDelete")).click();
        driver.switchTo().alert().accept();
        System.out.println("Ticket " + ticketId + " deleted from " + appId);
    }
}

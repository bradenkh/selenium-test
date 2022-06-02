package program;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TdWebDriverUtils {
    public void loginToTD(WebDriver driver) {
        try {
            driver.get("https://td.byui.edu/TDNext/Home/Desktop/Default.aspx");
            driver.findElement(By.id("username")).sendKeys(System.getenv("BYUI_USERNAME"));
            driver.findElement(By.id("password")).sendKeys(System.getenv("BYUI_PASSWORD"));
            driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("appsMenuButton")));
        }
        catch (WebDriverException e) {
            e.printStackTrace();
        }

    }
}

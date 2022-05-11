package program;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class SeleniumTestController {

    @GetMapping(value = "/")
    public String testController() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/brade/Downloads/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        StringBuilder response = new StringBuilder("[");

        driver.get("https://td.byui.edu/TDClient/87/Portal/Questions");
        String originalWindow = driver.getWindowHandle();

        for (int page = 0; page < 10; page++) {
            for (int i = 2; i < 27; i++) {
                String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
                if (!driver.findElements(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[1]/div["+i+"]/h3/a")).isEmpty()) {
                    driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div/div[2]/div[1]/div[" + i + "]/h3/a")).sendKeys(selectLinkOpeninNewTab);
                }
            }

            Set<String> windows = driver.getWindowHandles();
            windows.remove(originalWindow);

            for (String window : windows) {
                driver.switchTo().window(window);
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div/ol/li[2]/a")));
                Question tempQuestion = new Question();
                if (!driver.findElements(By.xpath("/html/body/main/div/div[2]/div[2]/div[3]/div/h1")).isEmpty()) {
                    tempQuestion.title = driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div[3]/div/h1")).getText();
                }
                if (!driver.findElements(By.xpath("/html/body/main/div/div[2]/div[2]/div[4]/div[1]/div[1]/p")).isEmpty()) {
                    tempQuestion.text = driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div[4]/div[1]/div[1]/p")).getText();
                }
                if (!driver.findElements(By.xpath("/html/body/main/div/div[2]/div[2]/div[4]/div[1]/div[3]")).isEmpty()) {
                    tempQuestion.asker = driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div[4]/div[1]/div[3]")).getText();
                }
                if (!driver.findElements(By.xpath("/html/body/main/div/div[2]/div[2]/div[4]/div[1]/div[5]/div/div[2]/p")).isEmpty()) {
                    tempQuestion.answer = driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div[4]/div[1]/div[5]/div/div[2]/p")).getText();
                }
                if (!driver.findElements(By.xpath("/html/body/main/div/div[2]/div[2]/div[4]/div[1]/div[5]/div/div[3]/span")).isEmpty()) {
                    tempQuestion.feedback = driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div[4]/div[1]/div[5]/div/div[3]/span")).getText();
                }
                if (!driver.findElements(By.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div/ol/li[2]/a")).isEmpty()) {
                    tempQuestion.category = driver.findElement(By.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div/ol/li[2]/a")).getText();
                }

                System.out.println(tempQuestion);
                response.append(tempQuestion).append(",");
                driver.close();
            }
            driver.switchTo().window(originalWindow);
            driver.findElement(By.linkText("»")).click();
        }

        return response.toString();
    }
}

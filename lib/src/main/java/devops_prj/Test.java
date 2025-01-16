package devops_prj;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

    public static void loginAutomation(WebDriver driver) {
        try {
            driver.get("https://uims.cuchd.in/");
            driver.manage().window().maximize();

            String originalWindow = driver.getWindowHandle();
            WebElement lmsbtn = driver.findElement(By.xpath("/html/body/section/div/div[2]/div/div[2]/div/a"));
            lmsbtn.click();

            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            Thread.sleep(5000);
            WebElement emailField = driver.findElement(By.name("username"));
            emailField.sendKeys("22bcs12181");
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("Rb@098");
            WebElement nextbtn = driver.findElement(By.id("loginbtn"));
            nextbtn.click();
            Thread.sleep(5000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1600)", "");
            Thread.sleep(5000);

            WebElement subbtn = driver.findElement(By.xpath("//*[@id=\"frontpage-course-list\"]/div/div[5]/div[3]/a/div"));
            subbtn.click();
            Thread.sleep(5000);

            WebElement unitbtn = driver.findElement(By.xpath("//*[@id=\"tabs-tree-start\"]/div[1]/ul/li[4]/a"));
            unitbtn.click();
            Thread.sleep(5000);

            WebElement logout = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div[1]/div/div[2]/div[1]/a[2]"));
            logout.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "/Users/rishabh/Downloads/edgedriver_mac64_m1/msedgedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/rishabh/Downloads/geckodriver/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/Users/rishabh/Downloads/chromedriver-mac-arm64/chromedriver");

        WebDriver edgeDriver = new EdgeDriver();
        WebDriver firefoxDriver = new FirefoxDriver();
        WebDriver chromeDriver = new ChromeDriver();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(() -> loginAutomation(edgeDriver));
        executor.execute(() -> loginAutomation(firefoxDriver));
        executor.execute(() -> loginAutomation(chromeDriver));

        executor.shutdown();
    }
}

package devops_prj;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {

    @Test
    public void eLogin() {
        System.setProperty("webdriver.edge.driver", "/Users/rishabh/Downloads/edgedriver_mac64_m1/msedgedriver");
        
        EdgeOptions options = new EdgeOptions();
        options.setBinary("/Applications/Microsoft Edge Canary.app/Contents/MacOS/Microsoft Edge Canary");
        WebDriver driver = new EdgeDriver(options);
        
        try {
            driver.get("https://uims.cuchd.in/");
            driver.manage().window().maximize();
            String originalWindow = driver.getWindowHandle();
            
            WebElement lmsBtn = driver.findElement(By.xpath("/html/body/section/div/div[2]/div/div[2]/div/a"));
            lmsBtn.click();
            
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void fLogin() {
        System.setProperty("webdriver.gecko.driver", "/Users/rishabh/Downloads/geckodriver/geckodriver");
        WebDriver driverf = new FirefoxDriver();

        try {
            driverf.get("https://uims.cuchd.in/");
            driverf.manage().window().maximize();
            String originalWindow = driverf.getWindowHandle();
            
            WebElement lmsBtn = driverf.findElement(By.xpath("/html/body/section/div/div[2]/div/div[2]/div/a"));
            lmsBtn.click();
            
            Set<String> windowHandles = driverf.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindow)) {
                    driverf.switchTo().window(windowHandle);
                    break;
                }
            }

            Thread.sleep(5000);
            WebElement emailField = driverf.findElement(By.name("username"));
            emailField.sendKeys("22bcs12181");
            WebElement passwordField = driverf.findElement(By.name("password"));
            passwordField.sendKeys("Rb@098");
            
            WebElement loginBtn = driverf.findElement(By.id("loginbtn"));
            loginBtn.click();
            
            Thread.sleep(5000);
            JavascriptExecutor js = (JavascriptExecutor) driverf;
            js.executeScript("window.scrollBy(0,1600)", "");
            
            Thread.sleep(5000);
            WebElement subjectBtn = driverf.findElement(By.xpath("//*[@id=\"frontpage-course-list\"]/div/div[5]/div[3]/a/div"));
            subjectBtn.click();
            
            Thread.sleep(5000);
            WebElement unitBtn = driverf.findElement(By.xpath("//*[@id=\"tabs-tree-start\"]/div[1]/ul/li[4]/a"));
            unitBtn.click();
            
            Thread.sleep(5000);
            WebElement logoutBtn = driverf.findElement(By.xpath("//*[@id=\"page-footer\"]/div[1]/div/div[2]/div[1]/a[2]"));
            logoutBtn.click();
            
            Thread.sleep(5000);
            driverf.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cLogin() {
        System.setProperty("webdriver.chrome.driver", "/Users/rishabh/Downloads/chromedriver-mac-arm64/chromedriver");
        WebDriver driverc = new ChromeDriver();

        try {
            driverc.get("https://uims.cuchd.in/");
            driverc.manage().window().maximize();
            String originalWindow = driverc.getWindowHandle();
            
            WebElement lmsBtn = driverc.findElement(By.xpath("/html/body/section/div/div[2]/div/div[2]/div/a"));
            lmsBtn.click();
            
            Set<String> windowHandles = driverc.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindow)) {
                    driverc.switchTo().window(windowHandle);
                    break;
                }
            }

            Thread.sleep(5000);
            WebElement emailField = driverc.findElement(By.name("username"));
            emailField.sendKeys("22bcs12181");
            WebElement passwordField = driverc.findElement(By.name("password"));
            passwordField.sendKeys("Rb@098");
            
            WebElement loginBtn = driverc.findElement(By.id("loginbtn"));
            loginBtn.click();
            
            Thread.sleep(5000);
            JavascriptExecutor js = (JavascriptExecutor) driverc;
            js.executeScript("window.scrollBy(0,1600)", "");
            
            Thread.sleep(5000);
            WebElement subjectBtn = driverc.findElement(By.xpath("//*[@id=\"frontpage-course-list\"]/div/div[5]/div[3]/a/div"));
            subjectBtn.click();
            
            Thread.sleep(5000);
            WebElement unitBtn = driverc.findElement(By.xpath("//*[@id=\"tabs-tree-start\"]/div[1]/ul/li[4]/a"));
            unitBtn.click();
            
            Thread.sleep(5000);
            WebElement logoutBtn = driverc.findElement(By.xpath("//*[@id=\"page-footer\"]/div[1]/div/div[2]/div[1]/a[2]"));
            logoutBtn.click();
            
            Thread.sleep(5000);
            driverc.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Creating individual threads for each login
        Thread firefoxThread = new Thread(() -> new NewTest().fLogin());
        Thread chromeThread = new Thread(() -> new NewTest().cLogin());
        Thread edgeThread = new Thread(() -> new NewTest().eLogin());

        // Starting the threads
        firefoxThread.start();
        chromeThread.start();
        edgeThread.start();

        // Waiting for the threads to complete execution
        try {
            firefoxThread.join();
            edgeThread.join();
            chromeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All browser logins completed.");
    }
}

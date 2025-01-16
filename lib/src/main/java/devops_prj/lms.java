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

public class lms {

    public static void eLogin() {
        System.setProperty("webdriver.edge.driver", "/Users/rishabh/Downloads/edgedriver_mac64_m1/msedgedriver");
        WebDriver driver = new EdgeDriver();

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

            Thread.sleep(5000);
            WebElement emailField = driver.findElement(By.name("username"));
            emailField.sendKeys("22bcs12181");
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("Rb@098");
            
            WebElement loginBtn = driver.findElement(By.id("loginbtn"));
            loginBtn.click();
            
            Thread.sleep(5000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1600)", "");
            
            Thread.sleep(5000);
            WebElement subjectBtn = driver.findElement(By.xpath("//*[@id=\"frontpage-course-list\"]/div/div[5]/div[3]/a/div"));
            subjectBtn.click();
            
            Thread.sleep(5000);
            WebElement unitBtn = driver.findElement(By.xpath("//*[@id=\"tabs-tree-start\"]/div[1]/ul/li[4]/a"));
            unitBtn.click();
            
            Thread.sleep(5000);
            WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div[1]/div/div[2]/div[1]/a[2]"));
            logoutBtn.click();
            
            Thread.sleep(5000);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Kuch to gadbad hai");
        }
    }
    
    public static void fLogin() {
    	System.setProperty("webdriver.gecko.driver","/Users/rishabh/Downloads/geckodriver/geckodriver");
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
        } finally {
            System.out.println("Kuch to gadbad hai");
        }
    }
    

    public static void cLogin() {
    	System.setProperty("webdriver.chrome.driver","/Users/rishabh/Downloads/chromedriver-mac-arm64/chromedriver");
        WebDriver driverc = new EdgeDriver();

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
        } finally {
            System.out.println("Kuch to gadbad hai");
        }
    }
    
    public static void main(String[] args) {
    	// WebDriver edgeDriver = new EdgeDriver();
         WebDriver firefoxDriver = new FirefoxDriver();
         WebDriver chromeDriver = new ChromeDriver();

         ExecutorService executor = Executors.newFixedThreadPool(3);

         //executor.execute(() -> eLogin());
         executor.execute(() -> fLogin());
         executor.execute(() -> cLogin());

         executor.shutdown();
        
    }
}

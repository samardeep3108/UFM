package TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class testcase1 {

    @Test
    public void login() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://demotesttest.thinkexam.com/admin/");
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.id("loginId"));
        login.click();
        login.sendKeys("demotest@yopmail.com");
        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("Kau@12345");
        driver.findElement(By.id("loginSubmit2")).click();
        Thread.sleep(4000);
        Actions ac = new Actions(driver);
        WebElement hov = driver.findElement(By.xpath("//a[contains(@href,'index.php?pageName=proctoring')]"));
        ac.moveToElement(hov).perform();
        Thread.sleep(4000);
        WebElement submenu = driver.findElement(By.xpath("//a[contains(@href,'index.php?pageName=proctoring/history&Token')]"));
        submenu.click();
        Thread.sleep(4000);
        WebElement drop = driver.findElement(By.xpath("//select[@class='filtercombo']"));
        Select filter = new Select(drop);
        filter.selectByVisibleText("Test Name");
        Thread.sleep(2000);
        WebElement src = driver.findElement(By.xpath("//input[@id='testsearchfield']"));
        src.sendKeys("secure browser close issue");
        driver.findElement(By.xpath("//input[@id='proctoringhistorysearchbutton']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td//a[@class ='hand']")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("studentfield"));
        Thread.sleep(3000);
        WebElement dropdown = driver.findElement(By.id("studentfield"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Candidate Name");
        WebElement name = driver.findElement(By.id("studentsearchfield"));
        name.sendKeys("Kaushal");
        Thread.sleep(5000);
        driver.findElement(By.id("proctoringhistorystudentsearchbutton")).click();
        Thread.sleep(2000);
       
       
        driver.findElement(By.xpath("//a[normalize-space()='Kaushal']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("roomSanVideoButton")).click();
        Thread.sleep(6000);

        // List of locators
        List<WebElement> locators = driver.findElements(By.xpath("//img[contains(@id, 'UFM_NoteChecked')]"));
        int i = locators.size();
        System.out.println(i);

        List<WebElement> note = driver.findElements(By.xpath("//span[contains(@id,'UFM_add_note_punctuon_work_id')]"));
        List<WebElement> element2 = driver.findElements(By.xpath("//*[contains(@id,'UFM_face_analysis_remark')]"));
        List<WebElement> green =  driver.findElements(By.id("green_tick_image_hide"));

        for (int index = 0; index < i; index++) {
            WebElement locator = locators.get(index);
            WebElement currentNote = note.get(index);
            WebElement currentElement2 = element2.get(index);
            WebElement green2 = green.get(index);

            try {
                // Perform hover action
                Actions action = new Actions(driver);
                action.sendKeys(Keys.ARROW_DOWN).perform();
                Thread.sleep(2000);  
                action.moveToElement(locator).build().perform();
                locator.click();
                Thread.sleep(2000);

                // Example: Click on a sub-menu item
                currentNote.click();
                Thread.sleep(2000);

                // Other actions with the element
                // Perform actions with the 'currentElement2' element
                currentElement2.sendKeys("Invalid UFM");
                Thread.sleep(3000);
               green2.click();
                Thread.sleep(3000);

                // Hover using Actions
            } catch (StaleElementReferenceException e) {
                System.out.println("Element is no longer attached to the DOM");}
                // Handle the exception, for example by refreshing the page or; skipping to the next iteration
            
        }
//, for example by refreshing the page or skipping to the next iteration
            }
        }
                // Handle the exception, for example by refreshing the page or skipping to the next iteration
            
        
    
        // Close the browser
       
    





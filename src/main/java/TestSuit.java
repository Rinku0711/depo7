import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestSuit {

    protected static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver.exe");
        // open Chrome browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");



        // click on register button

    //  driver.findElement(By.className("ico-register")).click();
        clickOnElement(By.className("ico-register"));


        // enter firstname
       // driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Automation")
        typeText(By.xpath("//input[@name='FirstName']"),"Automation");

        //enter lastname
      //  driver.findElement(By.id("LastName")).sendKeys("LastNameTest");
        typeText(By.id("LastName"),"LastNameTest");

        //enter email
       // driver.findElement(By.id("Email")).sendKeys("charmy@gmail.com");
        typeText(By.id("Email"),"charmy"+randomDate()+"@gmail.com");

        //enter password


       // driver.findElement(By.id("Password")).sendKeys("12345@abc");
        typeText(By.id("Password"),"12345@abc");

        //enter confirm password

      //  driver.findElement(By.id("ConfirmPassword")).sendKeys("12345@abc");
        typeText(By.id("ConfirmPassword"),"12345@abc");


        //enter register
      //  driver.findElement(By.name("register-button")).click();
        clickOnElement(By.name("register-button"));

       // driver.quit();

    }

    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }


    public static void typeText(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    public static String randomDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);


    }
    public  static String getTextFromElement(By by) {
        return driver.findElement(by).getText();

        //  public static void  driverWaits(){
        // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));

    }
    public static  void  WaitForElementToBeClickable(By by , int time) {
        WebDriverWait WaitForClickable = new WebDriverWait(driver, Duration.ofSeconds(time));
        WaitForClickable.until(ExpectedConditions.elementToBeClickable(by));

    }

    public static void DriverWaitSelectElement (int time ,By by){


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
     }

     public static void DriverWaitUrlContains(int time , String UrlFraction){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(UrlFraction));

     }
     public static void DriverWaitelementToBeSelected(int time, By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
     }
     
     public static void DriverWaitTitleContains(int time , String name){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(name));
    }

     public  static void DriverWaitUrlContain(int time , String name){
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
         wait.until(ExpectedConditions.urlContains(name));

     }
     public static void DriverWaitPresenceOfElement(int time , By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }
    public static void DriverWaitInvisibilityOf(int time, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));


    }
       public static void DriverWaitAlertIsPresent(int time){
        WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
       }

       public static void DriverWaitAttributeToBe(int time , By by,String Attribute ,String value ){
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(by,Attribute,value));

       }

       public static void DriverWaitAttributeToBeNotEmpty(  int time,WebElement element , String text){
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element , text));
       }
       public static void DriverWaitElementToBeSelected(int time , By by){

       WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(time));
       wait.until(ExpectedConditions.elementToBeSelected(by));
  }
}



























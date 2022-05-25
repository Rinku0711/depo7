package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.openqa.selenium.By.*;


public class Testsuit {

    protected  WebDriver driver;

    @BeforeClass
    public  void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver.exe");

        //open Chrome browser:
        driver = new ChromeDriver();

        //Implicit wait method :
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Maximizing chrome window:
        driver.manage().window().maximize();

        //Driver to type URL :
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterClass
   public void driverQuit() {
        //   driver.quit();
   }



    @Test(priority = 1)
    public void userShouldBeableToRegisterSuccefuly() {
        // click on register button
        driver.findElement(className("ico-register")).click();
        //   clickOnElement(By.className("ico-register"));
        //select on male or


        driver.findElement(By.id("gender-male")).click();


        //driver.findElement(By.id("gender-male")).click();

        // enter firstname
        // driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Charmy");
        sendKeys(id("FirstName"), "Charmy");


        //enter last name
        //driver.findElement(By.id("LastName")).sendKeys("Patel");
        sendKeys(id("LastName"), "Patel");

        //Date of birth
        selectDropdownByValue(xpath("//select[@name='DateOfBirthDay']"), "2");

        //Month of birth
        selectDropdownByValue(xpath("//select[@name='DateOfBirthMonth']"), "9");

        //Year of the birth
        selectDropdownByValue(xpath("//select[@name='DateOfBirthYear']"), "1980");


        //EMAIL address
        //driver.findElement(By.id("Email")).sendKeys("rinku07@gmail.com");
        sendKeys(id("Email"), "rinkup07" + randomDate() + "@gmail.com");


        //password field
        // driver.findElement(By.id("Password")).sendKeys("12345678");
        sendKeys(id("Password"), "12345678");


        //Confirm Password
        // driver.findElement(By.id("ConfirmPassword")).sendKeys("12345678");
        sendKeys(id("ConfirmPassword"), "12345678");

        //click on Register button on the button of the page

        //driver.findElement(By.id("register-button")).click();
        click(id("register-button"));

        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(className("result")).getText();
        Assert.assertEquals(expectedMessage, actualMessage, "Your registration is NOT successful");


    }

    @Test(priority = 2)

    public void userShouldBeAbleToAddInAddToCartProduct() {


        {
            // click on computer
            driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();

            // click on desktop
            driver.findElement(By.xpath("//img[@alt=\"Picture for category Desktops\"]")).click();

            // click on bliud on your computer
            driver.findElement(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/build-your-own-computer\"]")).click();

            // select on processer
            selectByValueDropDown(By.id("product_attribute_1"), "1");

            // select on ram
            selectByValueDropDown(By.id("product_attribute_2"), "3");

            //select on hdd
            driver.findElement(By.xpath("//label[@for=\"product_attribute_3_6\"]")).click();

            //select on os
            driver.findElement(By.xpath("//label[@for=\"product_attribute_4_9\"]")).click();

            // select on acrobat reader
            driver.findElement(By.xpath("//label[@for=\"product_attribute_5_11\"] ")).click();

            // secelt on total commander
            driver.findElement(By.xpath("//input[@value=\"12\"]")).click();

            // click on add to cart
            clickOnElement(By.xpath("//button[@id=\"add-to-cart-button-1\"]"));

            // add to cart
            clickOnElement(By.xpath("//span[@class=\"cart-label\"]"));


            // acssert for shopingcart
            String expectedMessage = "Shopping cart";

            String actualMessage = driver.findElement(xpath("//h1 [contains (text (),'Shopping cart')]")).getText();

            Assert.assertEquals(expectedMessage, actualMessage, "The product will not added to the cart ");

            //  assert for  build on your computer


            String actualMessage1 = driver.findElement(By.className("product-name")).getText();

            String expectedMessage1 = "Build your own computer";

            Assert.assertEquals(actualMessage1, expectedMessage1, " build your computer error  computer  ");


        }
    }

    @Test(priority = 3)

    public  void RegisterUerShouldReferproductToTheirFriends() {


       clickOnElement(By.className("ico-register"));


        // enter your  firstname
        sendKeys(By.xpath("//input[@name='FirstName']"), " Charmy");

        //enter your lastname
        // driver.findElement(By.id("LastName")).sendKeys("LastNameTest");
        sendKeys(By.id("LastName"), "LastNameTest");

          // enter mail
        sendKeys(By.id("Email"), "rinku80" + randomDate() + "@gmail.com");

        //Enter your password
        //driver.findElement(By.id("Password")).sendKeys("Jb1984sn");
        sendKeys(By.id("Password"), "Rk198464");

        // Enter Confirm Password

        //driver.findElement(By.id("ConfirmPassword")).sendKeys("Jb1984sn");
        sendKeys(By.id("ConfirmPassword"), "Rk198464");
        //  Enter register Button
        driver.findElement(By.id("register-button")).click();


        //click on computer
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();

        //click on desk top
        driver.findElement(By.xpath("//img[@alt=\"Picture for category Desktops\"]")).click();

        //build your own compute added to the cart
        clickOnElement(By.xpath("//div[@data-productid=\"1\"]/div/div[3]/div[2]//button[@class=\"button-2 product-box-add-to-cart-button\"]"));

        //cilck on email friend button
        driver.findElement(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]")).click();

        //enter your friend email
        driver.findElement(By.xpath("//*[@id=\"FriendEmail\"]")).sendKeys("priya185@gmail.com");

        //enter your email address
        driver.findElement(By.xpath("//*[@id=\"YourEmailAddress\"]")).sendKeys(" ");

        // enter personal message
        driver.findElement(By.xpath("//*[@id=\"PersonalMessage\"]")).sendKeys("This computer is a very very nice and cheap.");

        //clik on send email Button
        driver.findElement(By.name("send-email")).click();

         // assert for sentmail
        String expectedMessage = "Your message has been sent.";

        String actualMessage = driver.findElement(By.className("result")).getText();

        Assert.assertEquals( actualMessage,expectedMessage, " your message has not been sent");


    }

//   This project is not competed
 //  @Test(priority = 4)

 // public void userShouldBeableToSuccesfullyChangethecurrency() {

    //   selectByValueDropDown(By.xpath("select[@id=\"customerCurrency\"]"),"https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F");


     //  String actualMessage3 =  getTextFromElement(By.xpath("//strong [contains (text (),'$1,200.00')]"));
    //   String expectedMessage3 = "Us Dollar";
//       Assert.assertEquals(actualMessage3,expectedMessage3, "Us Dollar is NOT the currency selected");


     //  String actualMessage4 = getTextFromElement(By.xpath("//select[@id=\"customerCurrency\"]"));
       //String expectedMessage4 = "Euro";
       //Assert.assertEquals(actualMessage4, expectedMessage4, "Euro is NOT the currency selected");


  // }


//---------------------------------------------------------------------------------------------------------
                                               //utility method




    public void sendKeys(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public  void click(By by) {
       driver.findElement(by).click();
    }


    public  String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMYyyyHHMmSs");
        return formatter.format(date);
    }

    public  void driverWaitUnTillElementToBeClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();

    }

    public  void driverWaitUnitElementContainsUrlFraction(By by, int time, String FractionUrl) {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait1.until(ExpectedConditions.urlContains("FractionUrl"));
    }

    public void driverWaitUntilElementLocated(By by, int time) {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait2.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public  void driverWaitUntilElementsTitleContains(int time, String TitleContains) {
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait4.until(ExpectedConditions.titleContains(TitleContains));

    }

    public  void driverWaitUntilContainsUrl(int time, String url) {

        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait5.until(ExpectedConditions.urlContains(url));

    }

    public  void driverWaitUntilPresenceOfElement(By by, int time) {
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait6.until(ExpectedConditions.presenceOfElementLocated(by));
    }



    public  void driverWaitUntilInvisibilityOfWebElement(int time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    public void driverWaitUntil(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public void selectDropdownByValue(By by, String value) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);

    }



    public void selectByValueDropDown(By by, String value) {

        //this method select value from drop down

        Select select = new Select(driver.findElement(by));

        //Select by value
        select.selectByValue(value);

    }
   // public  String getTextFromElement(By by){
     //   return driver.findElement(by).getText();
    //}
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }



   public void clickOnElement(By by) {

      driver.findElement(by).click();


    }
}

































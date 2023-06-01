package HomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class HM2 {
    /*
       Navigate to
"http://secure.smartbearsoftware.com/samples/Te
stComplete11/WebOrders/Login.aspx?"
Validate the title is equals to "Web Orders Login"
Input username "Tester"
Input password "test"
Click login button
Validate the title is equals to "Web Orders"
Validate header is equals to "List of All Orders"
        */
    @Test
    public void testCase1 (){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        Assert.assertEquals(driver.getTitle().trim(),"Web Orders Login");
        if(driver.getTitle().trim().equals("Web Orders Login")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        Assert.assertEquals(driver.getTitle().trim(),"Web Orders");
        WebElement header = driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowserUtils.getText(header), "List of All Orders");
    }
    @Test
    /*
    Navigate to
"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button
Validate "View all products" is selected
Validate header is equals to "List of Products"
Validate the url has "Products" keyword
     */
    public void testCase2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        WebElement viewAllProductsButton = driver.findElement(By.xpath("//a[contains(text(),'products')]"));
        viewAllProductsButton.click();
        WebElement header =driver.findElement(By.tagName("h2"));
        Assert.assertEquals(BrowserUtils.getText(header), "List of Products");
        String urlValidate= driver.getCurrentUrl();
        Assert.assertTrue(urlValidate.contains("Products"));
    }
    @Test
    /*
    Navigate to
"http://secure.smartbearsoftware.com/sample
s/TestComplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Find the links for
View all orders
View all products
Orders
Validate their href values are equals to :
"Default.aspx"
"Products.aspx"
"Process.aspx"
     */
    public void testCase3(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        WebElement viewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        System.out.println(viewAllOrders.getAttribute("href").contains("Default.aspx"));
        WebElement viewAllProducts = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        System.out.println(viewAllProducts.getAttribute("href").contains("Products.aspx"));
        WebElement orders = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        System.out.println(orders.getAttribute("href").contains("Process.aspx"));
    }
    @Test
    /*
    Navigate to
"http://secure.smartbearsoftware.com/samples/TestComplete11
/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "Order" button
Select product "Screen Saver"
Input quantity 5
Input Customer name "CodeFish IT School"
Input Street "2200 E devon"
Input City "Des Plaines"
Input State "Illinois"
Input Zip "60018"
Select MasterCard
Input card number "444993876233"
Input expiration date "03/24"
Click Process button
     */
    public void testCase4(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
        WebElement selectProduct= driver.findElement(By.xpath("//select"));
        BrowserUtils.selectBy(selectProduct,"MyMoney", "value");
        WebElement quantity = driver.findElement(By.xpath("//input[@onChange='productsChanged()']"));
        quantity.clear();
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//li[1]/input"));
        customerName.sendKeys("CodeFish IT School");
        WebElement address = driver.findElement(By.xpath("//ol[2]/li[2]/input"));
        address.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.xpath("//ol[2]//li[3]//input"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.xpath("//ol[2]//li[4]//input"));
        state.sendKeys("Illinois");
        WebElement zipCode = driver.findElement(By.xpath("//ol[2]//li[5]//input"));
        zipCode.sendKeys("60018");
        WebElement masterCard =driver.findElement(By.xpath("//input[@value='MasterCard']"));
        masterCard.click();
        WebElement cardNumber = driver.findElement(By.xpath("//ol[3]//li[2]//input"));
        cardNumber.sendKeys("444993876233");
        WebElement expireDate = driver.findElement(By.xpath("//ol[3]//li[3]//input"));
        expireDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.cssSelector(".btn_light"));
        processButton.click();
/*
Validate text "New order has been successfully
added." is displayed below the Process button.
Click View all orders button
Validate new order is added and all inputs are
matching with new order
 */
        WebElement successfulOrder = driver.findElement(By.xpath("//strong"));
        Assert.assertEquals(BrowserUtils.getText(successfulOrder),"New order has been successfully added.");
        WebElement viewAllOrdersButton = driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrdersButton.click();
        WebElement actualNewOrder=driver.findElement(By.xpath("//tr[2]"));
        String expectedNewOrder="CodeFish IT School MyMoney 5 06/01/2023 2200 E devon Des Plaines Illinois 60018 MasterCard 444993876233 03/24";
                Assert.assertEquals(BrowserUtils.getText(actualNewOrder),expectedNewOrder);

    }
}

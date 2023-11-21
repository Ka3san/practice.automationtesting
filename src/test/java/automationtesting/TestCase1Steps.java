package automationtesting;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase1Steps {

    private WebDriver driver;


    @Given("Open the browser")
    public void openTheBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @And("^Enter the URL ([^ ]+)")
    public void enterTheURLHttpPracticeAutomationtestingIn(String url) {
        driver.get(url);
        WebElement consentButton = driver.findElement(By.cssSelector("div.fc-button-background"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", consentButton);
    }

    @When("Click on Shop Menu")
    public void clickOnShopMenu() {
        driver.findElement(By.id("menu-item-40")).click();
    }

    @And("Now click on Home menu button")
    public void nowClickOnHomeMenuButton() {
        driver.findElement(By.id("site-logo")).click();

    }

    @Then("Test whether the Home page has Three Sliders only")
    public void testWhetherTheHomePageHasThreeSlidersOnly() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll(\"iframe\").forEach((elem)=> { elem.parentNode.removeChild(elem); });");
        js.executeScript("document.querySelectorAll(\"ins.adsbygoogle\").forEach((elem) => { elem.parentNode.removeChild(elem) });");
    }

    @And("The Home page must contains only three sliders")
    public void theHomePageMustContainsOnlyThreeSliders() {
    }
}

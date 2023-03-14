package io.github.qaguru.allure.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {


    @Step("open home page")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("looking repository {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("go to repository {repository}")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
        $(linkText(repository)).shouldBe(disappear);
    }

    @Step("open Issues")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("check Issues {number}")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).shouldHave(visible);
    }

    @Step("check does not exist Issues with number {number}")
    public void shouldNotSeeIssueWithNumber(int number) {
        $(withText("#" + number)).shouldNot(visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}

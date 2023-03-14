package io.github.qaguru.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.github.qaguru.allure.steps.WebSteps;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    private WebSteps step = new WebSteps();


    @Test
    public void testLambda() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

        step("open home page", () -> {
            open("https://github.com/");
        });
        step("looking for a repository" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            lifecycle.addAttachment("Screenshot", "image/png", "png", takeScreenshot());
        });

    }
    private byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    public void testAnnotated() {
        step.openMainPage();
        step.searchForRepository(REPOSITORY);
        step.takeScreenshot();
    }

    private byte[] getScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}


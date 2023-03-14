package io.github.qaguru.allure;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;
    @Test
    public void testGithub() {

        step("open home page", () -> {
            open("https://github.com/");
        });
        step("looking for a repository" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("go to the repository" + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
            $(linkText("eroshenkoam/allure-example")).shouldBe(disappear);
        });
        step("open Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("check Issues" + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).shouldHave(visible);
        });
    }

    @Test
    public void testGithub2() {
        step("open home page", () -> {
            open("https://github.com");
        });
        step("looking for a repository" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("go to the repository" + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("check does not exist Issues" + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).shouldNot(visible);
        });
    }
}


package io.github.qaguru.allure;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {


    @Test
    @Owner("Dahak123")
    @Feature("Авторизация")
    @Story("Авторизация через Email")
    @Severity(SeverityLevel.BLOCKER) //степень важности теста
    @DisplayName("Testing one love")
    @Link(name = "GitHub", url = "https://github.com")
    public void testLambda() {

    }

    @Test
    public void testAnnotated() {
        Allure.getLifecycle().updateTestCase(testCase -> { //данный код эквивалентен аннотации @Displayname
            testCase.setName("Testing my love");
        });
        Allure.label("owner", "Dahak123"); //данный код эквивалентен аннотации @Owner
        Allure.feature("Авторизация");
        Allure.story("Авторизация через Email");
        Allure.label("severity", "BLOCKER");
        Allure.link("GitHub", "https://github.com");
    }

}


package io.github.qaguru.allure;
import io.github.qaguru.allure.steps.WebSteps;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTests {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;
    private final WebSteps step = new WebSteps();
    @Test
    public void testGithub() {
        step.openMainPage();
        step.searchForRepository(REPOSITORY);
        step.goToRepository(REPOSITORY);
        step.openIssuesTab();
        step.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }

    @Disabled
    @Test
    public void testGithub2() {
        step.openMainPage();
        step.searchForRepository(REPOSITORY);
        step.goToRepository(REPOSITORY);
        step.shouldNotSeeIssueWithNumber(ISSUE_NUMBER);
    }
}


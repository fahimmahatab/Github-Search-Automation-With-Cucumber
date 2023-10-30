package StepDefinitions;

import Setup.Setup;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GithubHomePage;


public class GithubPageStepDefinitions extends Setup {
    GithubHomePage githubHomePage;

    @Given("User is a guest user on the GitHub landing page")
    public void i_am_a_guest_user_on_the_GitHub_landing_page() {
        driver.get("https://github.com");
    }
    @When("User search for {string} from the landing page search input")
    public void i_search_for_from_the_landing_page_search_input(String searchItem) throws InterruptedException {
        githubHomePage = new GithubHomePage(driver);
        githubHomePage.doSearch(searchItem);

    }
    @Then("User see a count of matching results")
    public void i_see_a_count_of_matching_results () throws InterruptedException {
        githubHomePage = new GithubHomePage(driver);
        Thread.sleep(2000);
        String actual = githubHomePage.searchResult.get(0).getText();
        Assert.assertTrue(actual.contains("results"));

    }
    @Then("User verify that {string} is the first result")
    public void i_verify_that_is_the_first_result(String expectName) throws InterruptedException {
        githubHomePage = new GithubHomePage(driver);
        Thread.sleep(2000);
        String repoActual = githubHomePage.resultField.get(0).getText();
        Assert.assertTrue(repoActual.contains(expectName));
    }
    @When("User click the About button in the landing page footer")
    public void i_click_the_button_in_the_landing_page_footer() throws InterruptedException {
        githubHomePage = new GithubHomePage(driver);
        githubHomePage.doClick();

    }
    @Then("User verify the About page")
    public void i_am_taken_to_the_GitHub_page() throws InterruptedException {
        Thread.sleep(2000);
        String actual = githubHomePage.aboutHeader.get(0).getText();
        Assert.assertTrue(actual.contains("Let's build from here"));
        Assert.assertTrue(driver.getCurrentUrl().contains("about"));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

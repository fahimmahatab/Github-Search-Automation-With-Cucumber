package pages;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GithubHomePage {

    @FindBy(xpath = "//span[contains(text(),'Search or jump to...')]")
    WebElement search;
    @FindBy(id = "query-builder-test")
    WebElement searchField;
    @FindBy(className = "cgQapc")
    public List<WebElement> searchResult;
    @FindBy(className = "qaOIC")
    public List<WebElement> resultField;
    @FindBy(xpath = "//a[contains(text(),'About')]")
    WebElement about;
    @FindBy(className = "h1-mktg")
    public List<WebElement> aboutHeader;

    public GithubHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doSearch(String searchItem) throws InterruptedException {
        search.click();
        Thread.sleep(2000);
        searchField.sendKeys(searchItem);
        Thread.sleep(2000);
        searchField.sendKeys(Keys.ENTER);
    }

    public void doClick() throws InterruptedException {
        resultField.get(0).click();
        Thread.sleep(2000);
        about.click();
    }

}

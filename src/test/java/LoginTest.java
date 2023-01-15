import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends AbstractTest{
    @Test
    void loginIn(){
        new LoginPage(getWebDriver())
                .setLogin("f27eb83c60")
                .setPassword("6451daa910")
                .loginIn();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//ul/li[3]/a[contains(text(),'Hello,')]")).getText().equals("Hello, f27eb83c60"));

    }
    @Test
    void loginInNegativeTest(){
        new LoginPage(getWebDriver())
            .setLogin("автотест")
            .setPassword("4956318935")
            .loginIn();
        //Assertions.assertTrue(getWebDriver().findElement(By.xpath("//ul/li[3]/a[contains(text(),'Hello,')]")).getText().equals("Hello, autotest"));
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//div[contains(@class, 'error-block')]/h2")).getText().equals("401"));

    }
    @Test
    void shortLoginNegativeTest(){
        new LoginPage(getWebDriver())
                .setLogin("au")
                .setPassword("4956318935")
                .loginIn();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//div[contains(@class, 'error-block')]/h2")).getText().equals("401"));

    }

    @Test
    void shortLoginPOsitiveTest(){
        new LoginPage(getWebDriver())
                .setLogin("aut")
                .setPassword("4956318935")
                .loginIn();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//div[contains(@class, 'error-block')]/h2")).getText().equals("401"));

    }
    @Test
    void longLoginPOsitiveTest(){
        new LoginPage(getWebDriver())
                .setLogin("autotestautotestauto")
                .setPassword("4956318935")
                .loginIn();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//div[contains(@class, 'error-block')]/h2")).getText().equals("401"));

    }
    @Test
    void longLoginNegativeTest(){
        new LoginPage(getWebDriver())
                .setLogin("autotestautotestautot")
                .setPassword("4956318935")
                .loginIn();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//div[contains(@class, 'error-block')]/h2")).getText().equals("401"));

    }
    @Test
    void emptyLoginNegativeTest(){
        new LoginPage(getWebDriver())
                .setLogin("")
                .setPassword("")
                .loginIn();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//div[contains(@class, 'error-block')]/h2")).getText().equals("401"));

    }
    @Test
    void specSymbLoginNegativeTest(){
        new LoginPage(getWebDriver())
                .setLogin("auto'test")
                .setPassword("4956318935")
                .loginIn();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//div[contains(@class, 'error-block')]/h2")).getText().equals("401"));

    }
}

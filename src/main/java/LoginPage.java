import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//span[.='Username']/following-sibling::input")
    private WebElement login;

    @FindBy(xpath = "//span[.='Password']/following-sibling::input")
    private WebElement password;

    @FindBy(xpath = "//span[.='Password']/following-sibling::input")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[.='Login']/ancestor::button")
    private WebElement submit;

    public LoginPage(WebDriver driver){

        super(driver);
    }

    public void loginIn(){
        this.submit.click();
    }

    public LoginPage setLogin(String login){
        this.login.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password){
        this.password.click();
        this.passwordInput.sendKeys(password);
        return this;
    }

    public HomePage loginIn(String login, String password){

        Actions loginIn = new Actions(getDriver());
        loginIn
                .sendKeys(this.login,login)
                .click(this.password)
                .sendKeys(password)
                .click(this.submit)
                .build()
                .perform();
        return new HomePage(getDriver());
    }

}

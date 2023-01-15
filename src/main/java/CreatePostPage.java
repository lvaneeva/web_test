import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends AbstractPage{


    @FindBy(xpath="//a[contains(text(),'About')]")
    private WebElement aboutBtn;

    @FindBy(xpath="//a[contains(text(),'Contact')]")
    private WebElement contactBtn;

    @FindBy(xpath="//span[contains(text(),'Home')]")
    private WebElement homeBtn;

    @FindBy(xpath="//a[contains(text(),'Hello,')]")
    private WebElement helloUser;




    public CreatePostPage(WebDriver driver) {
        super(driver);
    }
}

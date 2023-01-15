import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage{
    @FindBy(xpath = "//span[text()='Logout']")
    private WebElement exit;

    @FindBy(xpath="//a[contains(text(),'Hello,')]")
    private WebElement helloUser;

    @FindBy(xpath="//a[contains(text(),'Next Page')]")
    private WebElement nextPage;

    @FindBy(xpath="//a[contains(text(),'Previous Page')]")
    private WebElement prevPage;

    @FindBy(id="create-btn")
    private WebElement createBtn;

    @FindBy(xpath="//i[.='sort']/ancestor::button")
    private WebElement sortBtn;

    @FindBy(xpath="//button[@id='SMUI-form-field-1']")
    private WebElement notMyPostsBtn;

    @FindBy(xpath="//span[.='Not my Posts']")
    private WebElement notMyPostsSpan;

    @FindBy(xpath="//a[contains(text(),'About')]")
    private WebElement aboutBtn;

    @FindBy(xpath="//a[contains(text(),'Contact')]")
    private WebElement contactBtn;

    @FindBy(xpath="//span[contains(text(),'Home')]")
    private WebElement homeBtn;

    @FindBy(xpath="//p[contains(text(),'No items for your filter')]")
    private WebElement noItemstext;

    @FindBy(xpath="//div[@class='content']/div/a")
    private WebElement post;

    public HomePage(WebDriver driver){

        super(driver);
    }
    public LoginPage logOut() throws InterruptedException {
        Actions loginOut = new Actions(getDriver());
        loginOut
           .click(this.helloUser)
                .pause(3000)
               // .new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(exit));
           .click(this.exit)
           .build()
           .perform();
        return new LoginPage(getDriver());
    }
    public void nextPage() {
       // new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(nextPage));
        try {this.nextPage.click();}
        catch (NullPointerException e){System.out.println(e.getMessage());}
    }
    public void previousPage() {

        this.prevPage.click();
    }
    public CreatePostPage createBtn(){
        this.createBtn.click();
        return new CreatePostPage(getDriver());
    }

    public void sortBtn(){
        this.sortBtn.click();

    }
     public void notMyPostsSpan(){
        this.notMyPostsSpan.click();
     }

}

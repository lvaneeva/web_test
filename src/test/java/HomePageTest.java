import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageTest extends AbstractTest {


    @Test
    void clickToLogOut() throws InterruptedException {
        HomePage homePage = new LoginPage(getWebDriver())
                .loginIn("f27eb83c60", "6451daa910");
        Thread.sleep(10000);
        // new WebDriverWait(getWebDriver(), 5).until(ExpectedConditions.elementToBeClickable(logOut));
        homePage.logOut();
        Thread.sleep(5000);
        Assertions.assertEquals("https://test-stand.gb.ru/login", getWebDriver().getCurrentUrl());
    }

    @Test
    void clickToNext() throws InterruptedException {
        HomePage homePage = new LoginPage(getWebDriver())
                .loginIn("f27eb83c60", "6451daa910");
        Thread.sleep(10000);
        homePage.nextPage();
        Thread.sleep(5000);
        int a = getWebDriver().getCurrentUrl().toString().indexOf("=");
        String b = getWebDriver().getCurrentUrl().toString().substring(getWebDriver().getCurrentUrl().toString().indexOf("=") + 1, getWebDriver().getCurrentUrl().toString().length());
        switch (b) {
            case (""):
                Assertions.assertEquals("https://test-stand.gb.ru/", getWebDriver().getCurrentUrl());
                break;
            case ("2"):
                Assertions.assertEquals("https://test-stand.gb.ru/?page=2", getWebDriver().getCurrentUrl());
                break;
            case ("https://test-stand.gb.ru/"):
                Assertions.assertEquals("https://test-stand.gb.ru/", getWebDriver().getCurrentUrl());
                break;
            default:
                Assertions.assertEquals("https://test-stand.gb.ru/?page=" + b, getWebDriver().getCurrentUrl());
                break;
        }
    }

    @Test
    void clickToPrev() throws InterruptedException {
        HomePage homePage = new LoginPage(getWebDriver())
                .loginIn("f27eb83c60", "6451daa910");
        Thread.sleep(5000);
        int a = getWebDriver().getCurrentUrl().toString().indexOf("=");
        String b = getWebDriver().getCurrentUrl().toString().substring(getWebDriver().getCurrentUrl().toString().indexOf("=") + 1, getWebDriver().getCurrentUrl().toString().length());
        Integer c;
        try {
            c = Integer.valueOf(b);
            //  System.out.println(i2);
        } catch (NumberFormatException e) {
            //  System.err.println("Неправильный формат строки!");
            c = 0;
        }

        homePage.previousPage();
        Thread.sleep(5000);

        switch (b) {
            case ("https://test-stand.gb.ru/"):
                Assertions.assertEquals("https://test-stand.gb.ru/", getWebDriver().getCurrentUrl());
                break;
            case ("1"):
                Assertions.assertEquals("https://test-stand.gb.ru/", getWebDriver().getCurrentUrl());
                break;
            default:
                Assertions.assertEquals("https://test-stand.gb.ru/?page=" + (c - 1), getWebDriver().getCurrentUrl());
                break;
        }
    }

    @Test
    void clickToCreatePost() throws InterruptedException {
        HomePage homePage = new LoginPage(getWebDriver())
                .loginIn("f27eb83c60", "6451daa910");
        Thread.sleep(5000);
        homePage.createBtn();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//h1[contains(text(),'Create Post')]")).getText().equals("Create Post"));

        Assertions.assertEquals("https://test-stand.gb.ru/posts/create", getWebDriver().getCurrentUrl());
    }

    @Test
    void clickSortPost() throws InterruptedException {
        HomePage homePage = new LoginPage(getWebDriver())
                .loginIn("f27eb83c60", "6451daa910");
        Thread.sleep(5000);
        homePage.sortBtn();
        Thread.sleep(5000);
        Assertions.assertEquals("https://test-stand.gb.ru/?sort=createdAt&order=DESC", getWebDriver().getCurrentUrl());
    }

    @Test
    void clickNotMyPosts() throws InterruptedException {
        HomePage homePage = new LoginPage(getWebDriver())
                .loginIn("f27eb83c60", "6451daa910");
        Thread.sleep(5000);
        homePage.notMyPostsSpan();
        //Assertions.assertTrue(getWebDriver().findElement(By.xpath("//h1[contains(text(),'Create Post')]")).getText().equals("Create Post"));
        Thread.sleep(5000);
        Assertions.assertEquals("https://test-stand.gb.ru/?owner=notMe&sort=createdAt&order=ASC", getWebDriver().getCurrentUrl());
    }


}

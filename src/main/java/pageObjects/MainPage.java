package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;


public class MainPage {

    private final WebDriver driver;
    // кнопка принять куки
    protected final By acceptCookiesButton = By.className("App_CookieButton__3cvqF");
   //кнопка Заказать вверху страницы
    protected final By createOrderButtonInHeader = By.xpath("//button[text() = 'Заказать'][1]");
   //кнопка Заказать в середине страницы
    protected final By createOrderButtonInMiddle = By.xpath("//button[text() = 'Заказать'][2]");
   //Кнопки открытия ответа на вопрос
    protected final By questionsButtons = By.xpath("//div[contains(@id, 'accordion__heading-')]");
    //Текст ответов
    protected final By answerForQuestion = By.xpath("//p[text()]");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() throws Exception {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        Thread.sleep(10_000);
    }

    public void clickAcceptCoockies() {
        driver.findElement(acceptCookiesButton).click();
    }

    public void clickCreateOrderButtonInHeader() {
        driver.findElement(createOrderButtonInHeader).click();
    }

    public void clickCreateOrderButtonInMiddle() {
        driver.findElement(createOrderButtonInMiddle).click();
    }

    public void checkAnswerText(String question, String answer) {
        WebElement element = driver.findElement(questionsButtons);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(questionsButtons).click();
        assertTrue(driver.findElement(By.xpath("//p[text()]")).isDisplayed());

    }
}

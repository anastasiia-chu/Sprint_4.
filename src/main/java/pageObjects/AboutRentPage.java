package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class AboutRentPage {
    private final WebDriver driver;

    //поле выбора даты
    protected final By dateToBringField = By.xpath("//input[@placeholder ='* Когда привезти самокат']");
    // поле выбора срока аренды
    protected final By rentalPeriodField = By.xpath("//div[text() ='* Срок аренды']");
    //элементы для выбора периода
    protected final By choosePeriod = By.xpath("//div[@class = 'Dropdown-option' and text()]");
    //чек-бокс выбора цвета
    protected final By colorCheckBox = By.xpath("//label[@for]");
    //поле комментария
    protected final By commentField = By.xpath("//input[@placeholder = 'Комментарий для курьера']");
    //кнопка Заказать
    protected final By confirmOrderButton = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' " +
            "and text() = 'Заказать']");
    //Кнопка подтверждения заказа в модальном окне
    protected final By confirmOrderInModal = By.xpath("//button[text() = 'Да']");
    //Модальное окно,подтвержающее офорлменный заказ
    protected final By orderConfirmedModal = By.xpath("//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");


    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRentData(String date, String period, String color, String comment) throws InterruptedException {
        driver.findElement(dateToBringField).sendKeys(date);
        driver.findElement(colorCheckBox).click();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(choosePeriod).click();
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickToConfirmOrder() {
        driver.findElement(confirmOrderButton).click();
        driver.findElement(confirmOrderInModal).click();
        assertTrue(driver.findElement(By.xpath("//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']")).isDisplayed());
    }

}

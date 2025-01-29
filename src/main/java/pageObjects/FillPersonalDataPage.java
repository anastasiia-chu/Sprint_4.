package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FillPersonalDataPage {
    private final WebDriver driver;

    // поле ввода Имени
    protected final By nameField = By.xpath("//input[@placeholder ='* Имя']");
    //поле ввода фамилии
    protected final By lastNameField = By.xpath("//input[@placeholder ='* Фамилия']");
    //поле ввода адреса
    protected final By addressField = By.xpath("//input[@placeholder ='* Адрес: куда привезти заказ']");
   //поле выбора метро
    protected final By metroStationField = By.xpath("//input[@placeholder ='* Станция метро']");
    //поле ввода телефона
    protected final By phoneField = By.xpath("//input[@placeholder ='* Телефон: на него позвонит курьер']");
   //Кнопка Далее
    protected final By nextButton = By.xpath("//button[text() = 'Далее']");
    //выбор станции метро
    protected final By metroStation = By.xpath("//li[@data-index]");


    public FillPersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillPersonalData(String name, String lastName, String address, String phone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickToOpenMetroStations() {
        driver.findElement(metroStationField).click();
    }

    public void clickToChooseStation(String index) {
        driver.findElement(metroStation).click();
    }

}

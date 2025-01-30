package practikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import pageObjects.AboutRentPage;
import pageObjects.FillPersonalDataPage;
import pageObjects.MainPage;

@RunWith(Parameterized.class)
public class CreateOrderTests {
    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String index;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;


    public CreateOrderTests(String name, String lastName, String address, String phone, String index,
                            String date, String period, String color, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.index = index;
        this.date = date;
        this.color = color;
        this.period = period;
        this.comment = comment;
    }

    @Rule
    public DriverSettings settings = new DriverSettings();


    @Parameterized.Parameters
    public static Object[][] fillCustomerData() {
        return new Object[][]{
                {"Анастасия", "Пупкина", "Москва, Вымышленная ул, 2к5,кв.3", "89112344321",
                        "3", "25.02.2025", "grey", "сутки", "блабла"},
                {"Петр", "ИВАНОВ", "Спб, Фантазийный пр, 1111", "+79004564545",
                        "10", "02.03.2025", "black", "трое суток" , " "},
        };

    }

    @Test
    public void createOrder() throws Exception {
        WebDriver driver = settings.getDriver();
        MainPage mainPage = new MainPage(driver);
        FillPersonalDataPage fillPersonalData = new FillPersonalDataPage(driver);
        mainPage.openMainPage();
        mainPage.clickAcceptCookies();
        mainPage.clickCreateOrderButtonInHeader();
        fillPersonalData.fillPersonalData(name, lastName, address, phone);
        fillPersonalData.clickToOpenMetroStations();
        fillPersonalData.clickOnStationToChoose(index);
        fillPersonalData.clickNextButton();
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.fillRentData(date, color, period, comment);
        aboutRentPage.clickToConfirmOrder();


    }

    @Test
    public void createOrderUsingButtonInMiddle() throws Exception {
        WebDriver driver = settings.getDriver();
        MainPage mainPage = new MainPage(driver);
        FillPersonalDataPage fillPersonalData = new FillPersonalDataPage(driver);
        mainPage.openMainPage();
        mainPage.clickAcceptCookies();
        mainPage.clickCreateOrderButtonInMiddle();
        fillPersonalData.fillPersonalData(name, lastName, address, phone);
        fillPersonalData.clickToOpenMetroStations();
        fillPersonalData.clickOnStationToChoose(index);
        fillPersonalData.clickNextButton();
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.fillRentData(date, color, period, comment);
        aboutRentPage.clickToConfirmOrder();


    }

}

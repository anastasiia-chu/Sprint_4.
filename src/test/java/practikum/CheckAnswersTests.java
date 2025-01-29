package practikum;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageObjects.MainPage;

@RunWith(Parameterized.class)
public class CheckAnswersTests {
    private final String question;
    private final String answer;


    public CheckAnswersTests(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @ClassRule
    public static DriverSettings settings = new DriverSettings();

    @BeforeClass
    public static void closeCookies() throws Exception {
        MainPage mainPage = new MainPage(settings.getDriver());
        ;
        mainPage.openMainPage();
        mainPage.clickAcceptCoockies();
    }

    @Parameterized.Parameters
    public static Object[][] questionsAndAnswers() {
        return new Object[][]{
                {"24", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"25", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
                        " можете просто сделать несколько заказов — один за другим."},
                {"26", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт" +
                        " времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"27", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"28", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"29", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься" +
                        " без передышек и во сне. Зарядка не понадобится."},
                {"30", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. " +
                        "Все же свои."},
                {"31", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };

    }

    @Test
    public void checkAnswers() throws Exception {
        WebDriver driver = settings.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.checkAnswerText(question, answer);
    }
}

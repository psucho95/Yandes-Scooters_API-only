package YandexScooters.UI;

import Scooter_Data.UI.Data.PersonData;
import Scooter_Data.UI.POM.MainPage;
import Scooter_Data.UI.POM.OrderPage;
import Scooter_Data.UI.POM.RentPage;
import Scooter_Data.UI.Static.BasePage;
import Scooter_Data.UI.Static.RentPeriodDays;
import Scooter_Data.UI.Static.ScooterColor;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BasePage {
    private String name;
    private String surname;
    private String address;
    private String station;
    private String phone;
    private String date;
    private String period;
    private ScooterColor color;
    private String comment;

    public OrderTest(String name, String surname, String address, String station, String phone, String date, String period, ScooterColor color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]
                {
//                        {"Лариса", "Ли", "Новая россия", "Сокольники", "+99899999999", "27.01.2023", RentPeriodDays.ONE_DAY , ScooterColor.BLACK, "Хочу питтса"},
                        {"Додж", "Боб", "Техас", "Лубянка", "+7688999999", "21.05.2023", RentPeriodDays.FOUR_DAYS, ScooterColor.GREY, "Везите нагенс"}
                };
    }

    @Test
    @DisplayName("Тестирование заказа через вернхюю кнопку")
    public void correctOrder_orderTopButton_true() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickCookieButton();
        objMainPage.clickTopOrderButton();

        PersonData Ilya = new PersonData(name, surname, address, station, phone);

        OrderPage order1 = new OrderPage(driver);
        order1.fillOrderForm(Ilya);

        RentPage rent1 = new RentPage(driver);
        rent1.fillRentPage(date, color, period, comment);
        rent1.createRentOrder();
        assertTrue("Order number isn't correct", rent1.isorderConfirmPopup());
    }

    @Test
    @DisplayName("Тестирование заказа через нижнюю кнопку")
    public void correctOrder_orderDownButton_true() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickCookieButton();
        objMainPage.clickDownOrderButton();

        PersonData Ilya = new PersonData(name, surname, address, station, phone);

        OrderPage order1 = new OrderPage(driver);
        order1.fillOrderForm(Ilya);

        RentPage rent1 = new RentPage(driver);
        rent1.fillRentPage(date, color, period, comment);
        rent1.createRentOrder();
        assertTrue("Order number isn't correct", rent1.isorderConfirmPopup());
    }
}

package YandexScooters.UI;

import Scooter_Data.UI.POM.MainPage;
import Scooter_Data.UI.POM.OrderTrackPage;
import Scooter_Data.UI.Static.BasePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TrackNotFound extends BasePage {
    @Test
    @DisplayName("Проверка ненахождения трек номера")
    public void trackNotFoundTrue()
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickOrderStatusButton();
        mainPage.fillOrderStatusInput("555");
        mainPage.clickGoButton();
        OrderTrackPage orderTrackPage = new OrderTrackPage(driver);
        assertTrue("Element isn't exist",orderTrackPage.checkNotFoundPic());
    }
}

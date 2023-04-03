package YandexScooters.API.CourierCreate;

import Scooter_Data.API.BasePage_API;
import Scooter_Data.API.JSONs.Generator_JSON_createData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static Scooter_Data.API.CommonData.StaticData.courierCreate;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CourierCreating_CanCreateTwinks_FALSE extends BasePage_API {
	@Test
	@DisplayName("Невозможность создания 2 одинаковых курьеров")
	public void  CourierCreating_CanCreateTwinks_FALSE()
	{
		Generator_JSON_createData courierData = new Generator_JSON_createData();
		Response courier1 =
						given()
										.header("Content-type", "application/json")
										.and()
										.body(courierData.JSON_Register(1,1,1))
										.when()
										.post(courierCreate);
		Response courier2 =
				given()
						.header("Content-type", "application/json")
						.and()
						.body(courierData.JSON_Register(1,1,1))
						.when()
						.post(courierCreate);
		courier2.then().assertThat().body("code",equalTo(409)).body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
	}
}

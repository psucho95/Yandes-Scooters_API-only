package YandexScooters.API.CourierCreate;

import Scooter_Data.API.BasePage_API;
import Scooter_Data.API.JSONs.Generator_JSON_createData;
import Scooter_Data.API.RequestDeserializer.Deserializer_courierCreate;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static Scooter_Data.API.CommonData.StaticData.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CourierCreating_TRUE_Test extends BasePage_API {
	@Test
	@DisplayName("Курьер создаётся корректно")
	public void CourierCreatingTrue_test()
	{
		Generator_JSON_createData jsonCreateData = new Generator_JSON_createData();
		Response response =
		given()
				.header("Content-type", "application/json")
				.and()
				.body(jsonCreateData.JSON_Register(1,1,1))
				.when()
				.post(courierCreate);
		Deserializer_courierCreate courier1 = response.body().as(Deserializer_courierCreate.class);
		System.out.println(response.body().asString());
		response.then().assertThat().body("ok",equalTo(true));
	}
}

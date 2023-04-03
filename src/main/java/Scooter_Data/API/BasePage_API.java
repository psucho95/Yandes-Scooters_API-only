package Scooter_Data.API;
import io.restassured.RestAssured;
import org.junit.*;


import static io.restassured.RestAssured.*;
public class BasePage_API {
	@Before
	public void BeforeAll()
	{
		RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
	}
}

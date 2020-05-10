package main;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;


import org.testng.annotations.Test;


import utility.utillityYandex;





public class YandexRestWeater {
	
	
		utillityYandex uYan = new utillityYandex();
		String today = uYan.today();
		String tommorow = uYan.tomorrow();
		String season = uYan.season(uYan.today());
	
	 @Test
	 public void GetWeatherDetails() {
		 		given().
		 			header("X-Yandex-API-Key", "de26760d-dad2-48cd-95b7-bd12a0bae1de").
		 		when().
		 			get("https://api.weather.yandex.ru/v1/forecast?lat=55.753216&lon=37.622505&limit=2&hours=false&extra=false").
				then().    
//				   log().body();
	            	assertThat().
					body("info.'lat'", hasToString ("55.753216"), 
							"info.'lon'", hasToString ("37.622505"),
							"info.tzinfo.'offset'", is(10800),
		 					"info.tzinfo.'name'", hasToString ("Europe/Moscow"),
		 					"info.tzinfo.'abbr'", hasToString ("MSK"),
		 					"info.tzinfo.'dst'", hasToString ("false"),
		 					"info.'url'", hasToString ("https://yandex.ru/pogoda/?lat=55.753216&lon=37.622505"),
		 					"forecasts.'date'", contains(today, tommorow),
		 					"fact.'season'", is(season));
		 		
//		 		https://yandex.ru/dev/weather/doc/dg/concepts/forecast-test-docpage/
	 }
}



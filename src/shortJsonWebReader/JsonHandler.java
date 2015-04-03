package shortJsonWebReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonHandler {
	
	static UrlOpener opener = new UrlOpener();
	static String scheme = "http://";
	static String authority  = "api.openweathermap.org";
	static String pathForecast = "/data/2.5/forecast/daily?q=";
	String pathCurrent = "/data/2.5/find?q=";	
	static String querryImperial = ",%20us&units=imperial&cnt=";
	String querryMetric = ",%20us&units=metric&cnt=";
	String querryLike = "&type=like";
	static String querryAccurate = "&type=accurate";
	static String json;
	public JsonHandler(){}
	

	public static String generateString(String zipCode, String numberOfDays) throws IOException{
		String linkToHandle = scheme+authority+pathForecast+zipCode+querryImperial+numberOfDays+querryAccurate;
		System.out.println(linkToHandle);
		//typical link looks like these two below
		//http://api.openweathermap.org/data/2.5/forecast/daily?q=72032,%20us&units=imperial&cnt=16&type=accurate
		BufferedReader data = opener.openUrl(linkToHandle);
		String line;
		while((line = data.readLine()) != null){
		    json = line;
		}
		//ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		//mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//String json = mapper.writeValueAsString(data);
		//System.out.println(json);
		return json;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(generateString("72032", "3"));
		System.out.println("JSON NOT DOING WELL");
	}

}

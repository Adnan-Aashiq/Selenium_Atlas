package TestSuite;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class Provider extends Base {
	JSONObject ElementObj = null;
	@DataProvider(name = "FormData")
	public JSONObject[] ReadFormJson() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();

		String currentDirectory = System.getProperty("user.dir");
		String inputFileName = currentDirectory + "/DataProvider/Form.json";
		File inputFile = new File(inputFileName);
		FileReader reader = new FileReader(inputFile);

		Object obj = jsonParser.parse(reader);
		ElementObj = (JSONObject) obj;
		JSONArray Array = (JSONArray) ElementObj.get("FormTestData");
		JSONObject elements[] = new JSONObject[Array.size()];
		for (int i = 0; i < Array.size(); i++)
			elements[i] = null;

		for (int i = 0; i < Array.size(); i++)
			elements[i] = (JSONObject) Array.get(i);
		return elements;
	}
}

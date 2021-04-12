import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class HttpValidateIndex {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("https://thunderbird-index.azurewebsites.net/w0a6zk195e.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        
            
			String str = "";
			while (null != (str = br.readLine())) {
                System.out.println(str);
                JSONParser parser = new JSONParser();
                JsonElement json = new JsonParser().parse(str);
                JSONObject jsonObject = (JSONObject)json;
                String name = (String)jsonObject.get("firstName");

                System.out.println("Name"+ name);
                
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		   
	}
}
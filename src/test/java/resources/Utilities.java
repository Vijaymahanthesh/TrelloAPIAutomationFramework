package resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilities {

	static  RequestSpecification req;

	public static RequestSpecification requestSpecification() throws IOException {
		System.out.println("requestSpecification");
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setBaseUri(getBaseUrl("baseUrl")).addQueryParam("key", "d9bd6aa9587695801e590d1cc859aa72").addQueryParam("token", "e91ddf7b44cffd282a27cce6ae90e5e3f0444fcb757032dc18e9d406a1caf7cf").setContentType(ContentType.JSON).build()
					.filter(RequestLoggingFilter.logRequestTo(log)).filter(ResponseLoggingFilter.logResponseTo(log));

			return req;
		}
		return req;

	}

	    public static String getBaseUrl(String key) throws IOException
	    {
	       Properties prop= new Properties();
	       FileInputStream fs= new FileInputStream("C:\\Users\\Sony\\eclipse-workspace\\TrelloAutomationFrameWork\\src\\test\\java\\resources\\global.properties");
	       prop.load(fs);
	       return prop.getProperty(key);
	  
	    }
	    public String getorganizationId(Response response, String id)
	    {
	    	String responseValue=response.asString();
	    	JsonPath js= new JsonPath(responseValue);
	    	String organization_id= js.getString("id");
			return organization_id;
	    	
	    }
	    public String getMessage(Response response, String  key)
	    {
	    	String responseValue=response.asString();
	    	JsonPath js= new JsonPath(responseValue);
	    	String message=js.getString(key);
			return message;
	    	
	    }
	    public String getBoardId(Response response, String key)
	    {
	    	String responseValue= response.asString();
	    	JsonPath js= new JsonPath(responseValue);
	    	String boardId= js.getString(key);
	    	return boardId;
	    }
	    
	    public String getMemeberId(Response response, String key) {
	    	String responseValue=response.asString();
	    	JsonPath js= new JsonPath(responseValue);
	    	String memberId=js.getString(key);
			return memberId;
	    	
	    }
	    public String getMemberShipId(Response response, String key) {
	    	String responseValue=response.asString();
	    	JsonPath js= new JsonPath(responseValue);
	    	String memberId=js.getString("memberships[0]."+key+"");
			return memberId;
	    	
	    }
}

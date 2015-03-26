package server.handlers;

import java.io.IOException;
import java.io.OutputStream;

import server.facades.UserFacade;
import server.jsonConverters.UserLoginConverter;
import shared.communicator.ListGamesResults;
import shared.communicator.UserLoginParams;
import shared.communicator.UserLoginResults;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class UserLoginHandler implements HttpHandler  {
	
	private UserFacade thisFacade = new UserFacade();
	@Override
	public void handle(HttpExchange ex) throws IOException 
	{
		
		UserLoginConverter converter = new UserLoginConverter();
		UserLoginResults result = thisFacade.userLogin(converter.convert(ex.getRequestBody()));
		
		Gson gson = new Gson();
		
		ex.getResponseHeaders().add("Content-Type", "application/json");
		String body = "";
		String gsonObject = gson.toJson(body);
		
		if (result != null)
		{
			//also need to set the cookie look at http://www.programcreek.com/java-api-examples/index.php?api=com.sun.net.httpserver.Headers
			body = "Success";
			gsonObject = gson.toJson(body);
			ex.sendResponseHeaders(200, gsonObject.length());
		}
		else
		{
			body = "Invalid request/bad username or password";
			gsonObject = gson.toJson(body);
			ex.sendResponseHeaders(400, gsonObject.length());
		}
		
		
		
		//This method must be called after sendResponseHeaders
		OutputStream out = ex.getResponseBody();
		
		System.out.println("I'm here first"); //Not getting here
		out.write(gsonObject.getBytes()); 
		System.out.println("I'm here"); //Not getting here
		out.flush();	
		out.close();
		
		

	}
}
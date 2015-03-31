/**
 * 
 */
package server.handlers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import server.facades.MovesFacade;
import shared.communicator.BuildRoadParams;
import shared.models.CatanModel;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * @author campbeln
 *
 */
public class BuildRoadHandler implements HttpHandler {

	private MovesFacade movesFacade = new MovesFacade();
	
	/* (non-Javadoc)
	 * @see com.sun.net.httpserver.HttpHandler#handle(com.sun.net.httpserver.HttpExchange)
	 */
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		// TODO Auto-generated method stub

		Gson gson = new Gson(); 
		
		String qry;
		String encoding = "ISO-8859-1";
		InputStream in = exchange.getRequestBody();
		try {
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		    byte buf[] = new byte[4096];
		    for (int n = in.read(buf); n > 0; n = in.read(buf)) {
		        out.write(buf, 0, n);
		    }
		    qry = new String(out.toByteArray(), encoding);
		} finally {
		    in.close();
		}
		
		BuildRoadParams params = gson.fromJson(qry, BuildRoadParams.class);
		CatanModel result = movesFacade.buildRoad(params);
		String resultGson = gson.toJson(result);
		
		
		exchange.getResponseHeaders().add("Content-Type", "text/html");
		String body = "";
		if(result != null) {  //Facade passes back null if command is invalid
			body = resultGson;
			exchange.sendResponseHeaders(200, body.length());
		}
		else {
			body = "Invalid Command";
			exchange.sendResponseHeaders(400, body.length());
		}
		OutputStream out = exchange.getResponseBody();
		out.write(body.getBytes());
		out.flush();
		out.close();
	}

}

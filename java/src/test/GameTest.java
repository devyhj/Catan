package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import shared.locations.EdgeDirection;
import shared.locations.EdgeLocation;
import shared.locations.HexLocation;
import shared.models.DevCard;
import shared.models.Game;
import shared.models.ResourceList;
import shared.models.TurnTracker;
import shared.models.jsonholder.JsonModelHolder;

import com.google.gson.Gson;

public class GameTest {

	@Test
	public void testCanBuildRoad() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		Game thisGame = modelHolder.buildCatanGame();
		System.out.println("Testing CanBuildRoad");
		System.out.println("--------------------------------------------");
		System.out.println("Testing User doesn't have enough resources.");
		assertFalse("Error: user was permitted to build road.",
		        thisGame.canBuildRoad(new EdgeLocation(new HexLocation(-1, -1), EdgeDirection.SouthWest)));
		System.out.println("Testing User has enough resources but there is a road already.");
		TurnTracker.getInstance().setCurrentTurn(1);
		assertFalse("Error: User was permitted to build road ontop of an exsting road.",
		        thisGame.canBuildRoad(new EdgeLocation(new HexLocation(-1, -1), EdgeDirection.South)));
		System.out.println("Testing User has enough resources and location is good");
		assertTrue("Error: user could not build road.",thisGame.canBuildRoad(new EdgeLocation(new HexLocation(-1, -1), EdgeDirection.SouthWest)));
		System.out.println("");
		System.out.println("");
	}

	@Test
	public void testCanPlayDevCard() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		Game thisGame = modelHolder.buildCatanGame();
		
		System.out.println("Testing CanPlayDevCard");
		System.out.println("--------------------------------------------");
		System.out.println("Testing User has no Development Cards");
		assertFalse("Error: user was allowed to play a Development Card.",
				thisGame.canPlayDevCard());
		System.out.println("Testing User has a new Devlopment Card");
		TurnTracker.getInstance().setCurrentTurn(2);
		assertFalse("Error: user was allowed to play a new Development Card.",
				thisGame.canPlayDevCard());
		System.out.println("Testing user has Development Cards");
		TurnTracker.getInstance().setCurrentTurn(1);
		assertTrue("Error: user was not permitted to play a Development Card.",
				thisGame.canPlayDevCard());
		System.out.println("");
		System.out.println("");
	}

	@Test
	public void testCanOfferTrade() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		Game thisGame = modelHolder.buildCatanGame();
		
		System.out.println("Testing CanOfferTrade");
		System.out.println("--------------------------------------------");
		System.out.println("Testing user doesn't have enough cards");
		ResourceList offer = new ResourceList(-100,-100,-100,-100,-100);
		assertFalse("Error: user was permitted to offer an invalid trade.",
				thisGame.canOfferTrade(offer));
		System.out.println("Testing user has enough cards.");
		TurnTracker.getInstance().setCurrentTurn(1);
		assertTrue("Error: user was not permitted to offer a valid trade.",
				thisGame.canOfferTrade(offer));
		System.out.println("");
		System.out.println("");
	}

	@Test
	public void testCanAcceptTrade() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		Game thisGame = modelHolder.buildCatanGame();
		
		System.out.println("Testing CanAcceptTrade");
		System.out.println("--------------------------------------------");
		System.out.println("Testing no trade has been offered");
		assertFalse("Error: user was permitted to accept a non-existing trade.",
				thisGame.canAcceptTrade(0, null));  //Change null to TradeOffer object once created.
	}

	@Test
	public void testCanRoleDice() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		Game thisGame = modelHolder.buildCatanGame();
	}

	@Test
	public void testCanBuildSettlement() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		
		Game thisGame = modelHolder.buildCatanGame();
	}

	@Test
	public void testCanUpgradeToCity() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		
		Game thisGame = modelHolder.buildCatanGame();
	}

	@Test
	public void testCanBuyDevCard() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		
		Game thisGame = modelHolder.buildCatanGame();
		
		System.out.println("Testing CanBuyDevCard");
		System.out.println("--------------------------------------------");
		System.out.println("Testing User doesn't have enough resources.");
		assertFalse("Error: user was permitted to buy a Devolepment Card.",
				thisGame.canBuyDevCard());
		System.out.println("Testing user has enough resources");
		TurnTracker.getInstance().setCurrentTurn(1);
		assertTrue("Error: user was not permitted to buy a Development Card.",
				thisGame.canBuyDevCard());
		System.out.println("Testing User has enough resources, but there are no Devlopment cards");
		List<DevCard> newList = new ArrayList<DevCard>();
		thisGame.getBank().setDevCards(newList);
		assertFalse("Error: user was permitted to buy a Development Card.",
				thisGame.canBuyDevCard());
		System.out.println("");
		System.out.println("");
	}

	@Test
	public void testCanMoveRobber() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		
		Game thisGame = modelHolder.buildCatanGame();
	}

	@Test
	public void testCanFinishTurn() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		
		Game thisGame = modelHolder.buildCatanGame();
	}
	
	@Test
	public void testIsPlayerTurn() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath+"/java/src/TestJSON.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		JsonModelHolder modelHolder = gson.fromJson(br, JsonModelHolder.class);
		
		Game thisGame = modelHolder.buildCatanGame();
	}

}

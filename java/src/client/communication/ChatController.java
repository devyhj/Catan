package client.communication;

import java.util.ArrayList;
import java.util.Observable;

import shared.communicator.SendChatParams;
import shared.definitions.CatanColor;
import shared.models.CatanModel;
import shared.models.Game;
import shared.models.MessageLine;
import client.base.Controller;


/**
 * Chat controller implementation
 */
public class ChatController extends Controller implements IChatController {

	public ChatController(IChatView view) {
		
		super(view);
	}

	@Override
	public IChatView getView() {
		return (IChatView)super.getView();
	}

	@Override
	public void sendMessage(String message) {
		Game thisGame = CatanModel.getInstance().getGameManager().getGame();
		int playerIndex = thisGame.getPlayerIndexByPlayerId(ServerProxy.getInstance().getMyPlayerId());
		SendChatParams params = new SendChatParams(message,playerIndex);
		ServerProxy.getInstance().sendChat(params);
	}

	@Override
	public void update(Observable o, Object arg) {
		Game thisGame = (Game)arg;
		ArrayList<LogEntry> entries = new ArrayList<LogEntry>();
		for (MessageLine line : thisGame.getChats()) {
			String message = line.getMessage();
			String playerName = line.getSource();
			CatanColor color = thisGame.getPlayerColorByPlayerName(playerName);
			
			LogEntry entry = new LogEntry(color,message);
			entries.add(entry);
		}
		this.getView().setEntries(entries);
	}

}


package server.plugin;

import server.command.ICommand;
import server.persistence.ICommandsDAO;
import shared.model.IGame;


public class NoPersistenceCommandsDAO implements ICommandsDAO {
    @Override
    public void saveCommand(ICommand command) {
    }

    @Override
    public void loadCommands(IGame game) {

    }
}
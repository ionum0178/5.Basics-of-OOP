package by.treasure.command;

import java.util.HashMap;
import java.util.Map;

import by.treasure.command.impl.GetOutCommand;
import by.treasure.command.impl.LookCommand;
import by.treasure.command.impl.MostPreciousCommand;
import by.treasure.command.impl.SelectTreasuresCommand;
import by.treasure.command.impl.SortByPriceCommand;
import by.treasure.command.impl.SortByTitleCommand;

public class CommandProvider {
    private Map<String, Command> commands;
    
    public CommandProvider() {
	commands = new HashMap<String, Command>();
	
	commands.put("0", new GetOutCommand());
	commands.put("1", new LookCommand());
	commands.put("2", new SortByPriceCommand());
	commands.put("3", new SortByTitleCommand());
	commands.put("4", new MostPreciousCommand());
	commands.put("5", new SelectTreasuresCommand());
	// commands.put("authorization", new AuthorizationCommand());
	// commands.put("registration", new RegistrationCommand());
	
	
    }
    
    public Command getCommand(String commandName) {
	Command command;
	command = commands.get(commandName);
	return command;
    }
}

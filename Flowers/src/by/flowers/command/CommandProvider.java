package by.flowers.command;

import java.util.HashMap;
import java.util.Map;

import by.flowers.command.impl.AddFlower;
import by.flowers.command.impl.AddWrapper;
import by.flowers.command.impl.GetOutCommand;
import by.flowers.command.impl.LookCommand;
import by.flowers.command.impl.MakeNewBouquet;

public class CommandProvider {
    private Map<String, Command> commands;
    
    public CommandProvider() {
	commands = new HashMap<String, Command>();
	
	commands.put("0", new GetOutCommand());
	commands.put("1", new LookCommand());
	commands.put("2", new MakeNewBouquet());
	
	commands.put("addFlower", new AddFlower());
	commands.put("addWrapper", new AddWrapper());
	
	
    }
    
    public Command getCommand(String commandName) {
	Command command;
	command = commands.get(commandName);
	return command;
    }
}

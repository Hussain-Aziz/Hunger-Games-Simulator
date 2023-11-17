package InteractableObjects.Enviornment;

import Characters.Character;
import InteractableObjects.InteractableObject;
import InteractableObjects.InteractableObjectCommands.ClimbTree;
import InteractableObjects.InteractableObjectCommands.InteractableObjectCommand;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class EnvironmentObject extends InteractableObject {
    private final ArrayList<InteractableObjectCommand> commands;
    private final HashMap<String, Integer> commandMap;

    

    public EnvironmentObject(String name, String description, InteractableObjectCommand interactableObjectCommand) {
    	super(name, description);

        commands = new ArrayList<>();
        commands.add(interactableObjectCommand);

        commandMap = new HashMap<>();
        for(InteractableObjectCommand command : commands) {
            commandMap.put(command.getName(), commands.indexOf(command));
        }
	}

	@Override
    public void interact(Character sender, String command) {
        if (commandMap.containsKey(command)) {
            commands.get(commandMap.get(command)).execute(sender);
        } else {
            Singletons.UI.getInstance().print("I can't do that with ", name);
        }
    }
}

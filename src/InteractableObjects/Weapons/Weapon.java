package InteractableObjects.Weapons;

import Characters.Character;
import Characters.MainCharacter;
import Characters.MainCharacterCommands.*;
import InteractableObjects.InteractableObject;
import InteractableObjects.InteractableObjectCommands.InteractableObjectCommand;
import InteractableObjects.Weapons.Attacks.AttackBehaviour;
import Scenes.Position;
import Singletons.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A template class to be used for weapons
 */
public abstract class Weapon extends InteractableObject {

    private final ArrayList<InteractableObjectCommand> commands;
    private final HashMap<String, Integer> commandMap;
    /**
     * The attack behaviour of the weapon
     */
    protected AttackBehaviour attackBehaviour;

    /**
     * Constructor for the Weapon class
     */
    public Weapon(String name, String description, AttackBehaviour attackBehaviour) 
    {
        super(name, description);
        this.attackBehaviour = attackBehaviour;

        commands = new ArrayList<>();
        commands.add(new InteractableObjects.InteractableObjectCommands.Take(this));
        commands.add(new InteractableObjects.InteractableObjectCommands.Inspect(this));
        commands.add(new InteractableObjects.InteractableObjectCommands.Destroy(this));
        commands.add(new InteractableObjects.InteractableObjectCommands.Drop(this));
        commands.add(new InteractableObjects.InteractableObjectCommands.Attack(this));

        commandMap = new HashMap<>();
        for(InteractableObjectCommand command : commands) {
            commandMap.put(command.getName(), commands.indexOf(command));
        }
    }

    /** Called when the player interacts with this object
     * @param sender  the character that sent the interacting request
     * @param command the command that wants to be processed
     */
    @Override
    public void interact(Character sender, String command) {
        if (commandMap.containsKey(command)) {
            commands.get(commandMap.get(command)).execute(sender);
        } else {
            Singletons.UI.getInstance().print("I can't do that with ", name);
        }
    }

    public void attack(Character sender) {
        attackBehaviour.attack(sender);
    }
}

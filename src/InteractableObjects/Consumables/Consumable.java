package InteractableObjects.Consumables;

import Characters.Character;
import InteractableObjects.Consumables.ConsumableBehaviours.ConsumableBehavior;
import InteractableObjects.InteractableObject;
import InteractableObjects.InteractableObjectCommands.*;
import InteractableObjects.InteractableObjectCommands.Take;
import Singletons.UI;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A template class to be used for weapons
 */
public abstract class Consumable extends InteractableObject {

    private final ArrayList<InteractableObjectCommand> commands;
    private final HashMap<String, Integer> commandMap;
    private final ConsumableBehavior consumableBehavior;
    public Consumable(String name, String description, ConsumableBehavior consumableBehavior)
    {
        super(name, description);
        this.consumableBehavior = consumableBehavior;

        commands = new ArrayList<>();
        commands.add(new Take(this));
        commands.add(new Inspect(this));
        commands.add(new Destroy(this));
        commands.add(new Drop(this));
        commands.add(new Consume(this));

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
            UI.getInstance().print("I can't do that with ", name);
        }
    }

    public final void consume(Character sender) {
        openWrapping();
        consumeObject();
        throwWrapping();
        realizeEffects(sender);
    }

    protected abstract void throwWrapping();

    protected abstract void consumeObject();

    protected abstract void openWrapping();

    public void realizeEffects(Character sender) {
        consumableBehavior.consume(sender);
    }
}

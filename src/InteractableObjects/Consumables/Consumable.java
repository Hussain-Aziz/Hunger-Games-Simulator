package InteractableObjects.Consumables;

import Characters.Character;
import InteractableObjects.Consumables.ConsumableBehaviours.ConsumableBehavior;
import InteractableObjects.Consumables.ConsumableState.ConsumableState;
import InteractableObjects.Consumables.ConsumableState.Fresh;
import InteractableObjects.InteractableObject;
import InteractableObjects.InteractableObjectCommands.*;
import InteractableObjects.InteractableObjectCommands.SensorCommands.Consume;
import InteractableObjects.InteractableObjectCommands.Take;
import Singletons.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * A template class to be used for weapons
 */
public abstract class Consumable extends InteractableObject implements Runnable {
    private final ArrayList<InteractableObjectCommand> commands;
    private final HashMap<String, Integer> commandMap;
    private ConsumableState state = new Fresh();
    private Random random = new Random();

    public Consumable(String name, String description)
    {
        super(name, description);

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

        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);//60 * 1000);
                if (random.nextInt(10) < 3) {
                    nextState();
                }
            } catch (InterruptedException e) {
                UI.getInstance().printError(e);
            }
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
        state.getEffect().affect(sender);
    }

    protected abstract void throwWrapping();

    protected abstract void consumeObject();

    protected abstract void openWrapping();

    public void nextState() {
        state.next(this);
    }

    public void setState(ConsumableState state) {
        this.state = state;
    }
}

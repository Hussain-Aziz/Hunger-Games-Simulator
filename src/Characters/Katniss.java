package Characters;

import Characters.MainCharacterCommands.CharacterCommand;
import Characters.MainCharacterCommands.*;
import Scenes.Direction;
import InteractableObjects.Enviornment.EnvironmentObject;
import InteractableObjects.InteractableObject;
import MessageArchitecture.Message;
import Scenes.Position;
import Singletons.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Katniss extends Character implements MainCharacter, Runnable {
    private final Thread thread;
    private final ArrayList<CharacterCommand> commands;
    private final HashMap<String, Integer> commandMap;
    protected ArrayList<InteractableObject> inventory;
    protected final Random random = new Random();
    protected final static int MAX_INVENTORY_SIZE = 3;

    public Katniss() {
        super("Katniss", 5);

        inventory = new ArrayList<>();

        commands = new ArrayList<>();
        commands.add(new Move(this));
        commands.add(new Take(this));
        commands.add(new Inventory(this));
        commands.add(new Look(this));
        commands.add(new Health(this));
        commands.add(new LookAround(this));
        commands.add(new Use(this));
        commands.add(new Interact(this));
        commands.add(new Map(this));
        commands.add(new Drop(this));
        commands.add(new Inspect(this));
        commands.add(new Quit(this));

        commandMap = new HashMap<>();
        for(CharacterCommand command : commands) {
            for (String alias : command.getAliases()) {
                commandMap.put(alias, commands.indexOf(command));
            }
        }

        this.thread = new Thread(this);
        this.thread.start();
    }

    public void run() {
        try {
            mainLoop();
        } catch (InterruptedException e) {
            UI.getInstance().print(e);
        }
    }

    public void mainLoop() throws InterruptedException {

        while(currentScene == null) Thread.sleep(100);

        var ui = UI.getInstance();
        while (health > 0) {
            String[] inputs = ui.read().strip().toLowerCase().split(" ");
            String commmand = inputs[0];
            if (commandMap.containsKey(commmand)) {
                commands.get(commandMap.get(commmand)).execute(inputs);
            }
            else if(commmand.equals("help")) {
                if (inputs.length == 2) {
                    boolean found = false;
                    for(CharacterCommand command : commands) {
                        for (String alias : command.getAliases()) {
                            if (alias.equals(inputs[1])) {
                                ui.print(command.getDescription());
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        ui.print("Invalid command");
                    }
                }
                else {
                    String availableCommands = "Available commands:\n";
                    for (CharacterCommand command : commands) {
                        availableCommands += "\t- ";
                        for (String alias : command.getAliases()) {
                            availableCommands += alias + "/";
                        }
                        availableCommands = availableCommands.substring(0, availableCommands.length() - 1); // remove last /
                        availableCommands += "\n";
                    }
                    ui.print(availableCommands);
                }
            }
            else {
                ui.print("Invalid command");
            }
        }
    }

    public boolean take(InteractableObject object, Position position) {
        if (MAX_INVENTORY_SIZE > inventory.size()) {
            inventory.add(object);
            return true;
        } else {
            UI.getInstance().print("I can't carry any more items");
            return false;
        }
    }

    public void drop(InteractableObject object) {
        inventory.remove(object);
    }

    public ArrayList<InteractableObject> getInventory() {
        return inventory;
    }

    public void printInventory() {
        UI.getInstance().print("Inventory:");
        if (getInventory().isEmpty()) {
            UI.getInstance().print("\tEmpty");
        }
        else {
            for (InteractableObject object : getInventory()) {
                UI.getInstance().print("\t", object.getName());
            }
        }
    }

    public void move(Direction direction) {
        super.move(direction);
        UI.getInstance().print("You have moved", direction);

        var objects = getCurrentScene().getNearbyObjects(this);
        for(InteractableObject object : objects) {
            if (object instanceof EnvironmentObject) {
                object.interact(this, "use");
            }
        }

        var npc = getCurrentScene().getNearbyNPC(this);
        if (npc != null) {
            UI.getInstance().print("You have encountered", npc.getName());
            publishMessage(new Message(this, "meet", ""));
        }
    }

    public void die() {
        health = 0;
    }

    public void usedWeapon() {
        publishMessage(new Message(this, "attack", ""));
    }

    public void interactWithNPC(NPC npc) {
        npc.changeState();
    }
}

package Characters;

import Characters.CharacterStates.*;
import InteractableObjects.InteractableObject;
import MessageArchitecture.Message;
import MessageArchitecture.Observer;
import Scenes.Position;
import Singletons.SceneManager;
import Singletons.UI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Template class for NPCs in the game
 */
public abstract class NPC extends Character implements Observer, Runnable {

    private CharacterState state = new Dormant();

    /**
     * The inventory of the NPC
     */
    protected ArrayList<InteractableObject> inventory;
    private final Random random = new Random();

    /**
     * Constructor of the NPC class
     */
    public NPC(String name, int health, ArrayList<InteractableObject> inventory) {
        super(name, health);

        this.inventory = inventory;
        for (InteractableObject object : inventory) {
            object.setOwner(this);
        }

        new Thread(this).start();
    }

    /**
     * Adds an object to the inventory of the NPC
     */
    public boolean take(InteractableObject object, Position position) {
        // NPC's cant take stuff
        return false;
    }

    public abstract void talk();

    public String giveItem() {
        if (inventory.isEmpty()) return null;
        String name = inventory.get(inventory.size()-1).getName();
        inventory.get(inventory.size()-1).interact(this, "drop");
        return name;
    }

    public void run() {
        try {
            Thread.sleep(30 * 1000);
            changeState();
        } catch (Exception e) {
            UI.getInstance().printError(e);
        }
    }

    public void update(Message message) {
        // if a main character does something to npc
        if (message.origin instanceof MainCharacter) {
            switch (message.topic) {
                case "meet" -> {
                    changeState();
                }
                case "attack" -> {
                    // if they attacked the npc, then the npc will attack back with a 30% chance
                    if (random.nextInt(10) < 3) {
                        setState(Attack.name);
                    }
                }
            }
        }
    }

    public void changeState() {
        // 70% chance to go to next state, 30% chance to go to previous state
        if (random.nextInt(10) > 3) {
            nextState();
        } else {
            prevState();
        }
    }

    /**
     * Removes an object from the inventory of the NPC
     */
    public void drop(InteractableObject object) {
        inventory.remove(object);
    }

    public void nextState() {
        state.next(this);
    }

    public void prevState() {
        state.prev(this);
    }

    public synchronized void setState(String state) {
        if (SceneManager.getInstance().getMainCharacter().getCurrentScene() == getCurrentScene() && health > 0) {
            this.state = createState(state);
        }
    }

    private CharacterState createState(String name) {
        switch (name) {
            case "Talking" -> {
                return new Talk(this);
            }
            case "Giving" -> {
                return new Give(this);
            }
            case "Attacking" -> {
                return new Attack(this);
            }
            default -> {
                return new Dormant();
            }
        }
    }

    public ArrayList<InteractableObject> getInventory() {
        return inventory;
    }

    public String getState() {
        return state.toString();
    }
}

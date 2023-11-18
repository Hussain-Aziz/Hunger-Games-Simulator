package Characters;

import Characters.CharacterStates.Attack;
import Characters.CharacterStates.CharacterState;
import Characters.CharacterStates.Dormant;
import InteractableObjects.InteractableObject;
import MessageArchitecture.Message;
import MessageArchitecture.Observer;
import Scenes.Position;

import java.util.ArrayList;
import java.util.Random;

/**
 * Template class for NPCs in the game
 */
public abstract class NPC extends Character implements Observer {

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
        String name = inventory.get(0).getName();
        inventory.get(0).interact(this, "drop");
        return name;
    }

    public void update(Message message) {
        // if a main character does something to npc
        if (message.origin instanceof MainCharacter) {
            switch (message.topic) {
                case "meet" -> {
                    changeState();
                }
                case "attack" -> {
                    // if the npc is in the same scene as the main character, and they attacked
                    // the npc, then the npc will attack back with a 30% chance
                    if (((Katniss) message.origin).getCurrentScene() == getCurrentScene() && random.nextInt(10) < 3) {
                        setState(new Attack(this));
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

    public void setState(CharacterState state) {
        this.state = state;
    }

    public ArrayList<InteractableObject> getInventory() {
        return inventory;
    }
}

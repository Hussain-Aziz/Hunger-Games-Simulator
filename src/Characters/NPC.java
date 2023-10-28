package Characters;

import InteractableObjects.InteractableObject;
import Scenes.Position;

import java.util.ArrayList;

/**
 * Template class for NPCs in the game
 */
public abstract class NPC extends Character {

    /**
     * The maximum number of items that the NPC can hold in their inventory
     */
    protected final static int MAX_INVENTORY_SIZE = 2;

    /**
     * The inventory of the NPC
     */
    protected ArrayList<InteractableObject> inventory;

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
     * A function to be implemented that handles interaction with NPCs
     */
    public abstract void interract();

    /**
     * Adds an object to the inventory of the NPC
     */
    public boolean take(InteractableObject object, Position position) {
        if (MAX_INVENTORY_SIZE > inventory.size()) {
            inventory.add(object);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes an object from the inventory of the NPC
     */
    public void drop(InteractableObject object) {
        inventory.remove(object);
    }
}

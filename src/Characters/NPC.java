package Characters;

import Characters.CharacterStates.CharacterState;
import Characters.CharacterStates.Dormant;
import InteractableObjects.InteractableObject;
import Scenes.Position;

import java.util.ArrayList;

/**
 * Template class for NPCs in the game
 */
public abstract class NPC extends Character {

    private CharacterState state = new Dormant();

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
     * Adds an object to the inventory of the NPC
     */
    public boolean take(InteractableObject object, Position position) {
        // NPC's cant take stuff
        return false;
    }

    public abstract void interact();

    public String giveItem() {
        if (inventory.isEmpty()) return null;
        String name = inventory.get(0).getName();
        inventory.get(0).interact(this, "drop");
        return name;
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
    public void prevState(){
        state.prev(this);
    }
    public void setState(CharacterState state) {
        this.state = state;
    }

    public ArrayList<InteractableObject> getInventory() {
        return inventory;
    }
}

package InteractableObjects;

import Characters.Character;
import Singletons.UI;

/**
 * The parent class for Interactable Objects
 * Defines basic functionality for them
 */
public abstract class InteractableObject {
    /**
     * The name of this object. This is what the user will type to interact with it
     */
    protected String name;
    /**
     * The description of this object. This is what the user will see when they inspect it
     */
    protected String description;
    /**
     * The owner of this object. This is the character or scene that is currently holding it
     * used for taking and dropping the object
     */
    protected InteractableObjectOwner owner;

    /**
     * Constructor for the InteractableObject class
     */
    public InteractableObject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Sets the owner of this object.
     * This can't be done in the constructor because the owner does not exist yet
     */
    public void setOwner(InteractableObjectOwner owner) {
        this.owner = owner;
    }

    /**
     * Called when the player interacts with this object
     * @param sender the character that sent the interacting request
     * @param command the command that wants to be processed
     */
    public abstract void interact(Characters.Character sender, String command);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public InteractableObjectOwner getOwner() {
        return owner;
    }

    public void inspect() {
        UI.getInstance().print(getName(), ":", getDescription());
    }

    public void take(Characters.Character sender) {
        // make the character take the object
        if (sender.take(this, null)) {

            // if successful, drop the object from the current scene
            if (getOwner() != null) {
                getOwner().drop(this);
            }

            // set the owner to the character
            setOwner(sender);
        }
    }

    public void drop(Character sender) {
        // make the character drop the object
        sender.drop(this);

        // set the owner to the scene where it was dropped
        owner = sender.getCurrentScene();
        owner.take(this, sender.getPosition());

    }

    public void destroy(Character sender) {
        // make the owner drop the object and don't give it a new owner
        sender.drop(this);
    }
}

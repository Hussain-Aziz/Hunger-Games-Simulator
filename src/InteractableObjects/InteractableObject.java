package InteractableObjects;

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
}

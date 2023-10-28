package InteractableObjects;

import Characters.Character;
import Characters.MainCharacter;
import Scenes.Position;

import java.util.Map;

/**
 * A template class to be used for weapons
 */
public abstract class Weapon extends InteractableObject {

    /**
     * The damage that this weapon does
     */
    protected int damage;

    /**
     * The range of this weapon
     */
    protected int range;

    /**
     * Constructor for the Weapon class
     */
    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    /** Called when the player interacts with this object
     * @param sender  the character that sent the interacting request
     * @param command the command that wants to be processed
     */
    @Override
    public void interact(Character sender, String command) {
        switch (command) {
            case "inspect" -> Singletons.UI.getInstance().print(name, ":", description);
            case "take" -> {
                // make the character take the object
                if (sender.take(this, null)) {

                    // if successful, drop the object from the current scene
                    owner.drop(this);

                    // set the owner to the character
                    owner = sender;
                }
            }
            case "use" -> use(sender);
            case "drop" -> {
                // make the character drop the object
                sender.drop(this);

                // set the owner to the scene where it was dropped
                owner = sender.getCurrentScene();
                owner.take(this, sender.getPosition());
            }
            case "destroy" -> {
                // just drop the object without giving a new owner
                sender.drop(this);
            }
            default -> Singletons.UI.getInstance().print("I can't do that with", name);
        }
    }

    /**
     * Attacks all characters in the scene within range with the weapon
     * Does damage if the character is in range
     * @param sender the character that sent the request
     */
    private void use(Character sender) {
        var scene = sender.getCurrentScene();
        var position = sender.getPosition();

        for(Map.Entry<Character, Position> entry : scene.getCharacters().entrySet()) {
            var character = entry.getKey();
            var characterPosition = entry.getValue();

            // can't attack yourself
            if (character == sender)
                continue;

            if (characterPosition.isInContact(position, range)) {
                character.takeDamage(damage);
                // only do prints for main character
                if (!(sender instanceof MainCharacter)) {
                    Singletons.UI.getInstance().print("You hit", character.getName(), "for", damage, "damage");
                }
            }
        }

    }
}

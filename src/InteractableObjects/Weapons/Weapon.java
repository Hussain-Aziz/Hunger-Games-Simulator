package InteractableObjects.Weapons;

import Characters.Character;
import Characters.MainCharacter;
import InteractableObjects.InteractableObject;
import InteractableObjects.Weapons.Attacks.AttackBehaviour;
import Scenes.Position;

import java.util.Map;

/**
 * A template class to be used for weapons
 */
public abstract class Weapon extends InteractableObject {

    /**
     * The attack behaviour of the weapon
     */
    protected AttackBehaviour attackBehaviour;

    /**
     * Constructor for the Weapon class
     */
    public Weapon(String name, String description, AttackBehaviour attackBehaviour) {
        super(name, description);
        this.attackBehaviour = attackBehaviour;
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
            case "use" -> attackBehaviour.attack(sender);
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
}

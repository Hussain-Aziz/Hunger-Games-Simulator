package InteractableObjects.InteractableObjectCommands;

import Characters.Character;
import InteractableObjects.InteractableObject;
import InteractableObjects.Weapons.Weapon;

public class Attack implements InteractableObjectCommand{
    private final Weapon object;

    public Attack(Weapon object) {
        this.object = object;
    }
    @Override
    public void execute(Character sender) {
        object.attack(sender);
    }

    // use on a weapon is considered attack
    @Override
    public String getName() {
        return "use";
    }
}

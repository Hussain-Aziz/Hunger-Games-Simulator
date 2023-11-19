package InteractableObjects.Weapons;

import InteractableObjects.Weapons.Attacks.MeleeAttack;
import InteractableObjects.Weapons.Weapon;

public class Sword extends Weapon {
    public Sword() {
        super("Sword",
                "A short heavy blade that can be used to fight foes",
                new MeleeAttack(1));
    }
}

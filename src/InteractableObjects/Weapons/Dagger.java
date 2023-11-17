package InteractableObjects.Weapons;

import InteractableObjects.Weapons.Attacks.MeleeAttack;
import InteractableObjects.Weapons.Weapon;

public class Dagger extends Weapon {
    public Dagger() {
        super("Dagger",
                "A short blade that can be used to stab foes",
                new MeleeAttack(1));
    }
}

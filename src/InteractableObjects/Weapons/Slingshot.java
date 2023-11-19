package InteractableObjects.Weapons;

import InteractableObjects.Weapons.Attacks.RangeAttack;

public class Slingshot extends Weapon {
    public Slingshot() {
        super("Slingshot",
                "A small hand powered projectile weapon ",
                new RangeAttack(1));
    }
}

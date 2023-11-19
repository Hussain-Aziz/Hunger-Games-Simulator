package InteractableObjects.Weapons;

import InteractableObjects.Weapons.Attacks.RangeAttack;

public class Spear extends Weapon {
    public Spear() {
        super("Spear",
                "A long spear-headed weapon used to project at your foes.",
                new RangeAttack(1));
    }
}

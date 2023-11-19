package InteractableObjects.Weapons;


import InteractableObjects.Weapons.Attacks.RangeAttack;
import InteractableObjects.Weapons.Weapon;

public class BowAndArrow extends Weapon {
    public BowAndArrow() {
        super("Bow",
                "The bow and arrow is a ranged weapon system used to shoot your foes",
                new RangeAttack(1));
    }
}

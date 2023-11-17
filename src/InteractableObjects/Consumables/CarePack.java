package InteractableObjects.Consumables;

import InteractableObjects.Consumables.ConsumableBehaviours.Heal;

public class CarePack extends Consumable {
    public CarePack() {
        super("carepack", "A care package. It heals you", new Heal(3));
    }
}

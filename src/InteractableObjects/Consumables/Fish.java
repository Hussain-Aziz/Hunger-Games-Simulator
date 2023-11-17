package InteractableObjects.Consumables;

import InteractableObjects.Consumables.ConsumableBehaviours.Heal;

public class Fish extends Consumable {
    public Fish() {
        super("fish", "A fish. It looks delicious", new Heal(1));
    }
}

package InteractableObjects.Consumables;

import InteractableObjects.Consumables.ConsumableBehaviours.*;

public class Berry extends Consumable {
    public Berry() {
        super("berry", "A berry. It looks poisonous", new Damage());
    }
}

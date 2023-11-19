package InteractableObjects.Consumables.ConsumableState;

import Characters.NPC;
import InteractableObjects.Consumables.Consumable;
import InteractableObjects.Consumables.ConsumableBehaviours.ConsumableBehavior;

public interface ConsumableState {
    void next(Consumable object);
    ConsumableBehavior getEffect();
}

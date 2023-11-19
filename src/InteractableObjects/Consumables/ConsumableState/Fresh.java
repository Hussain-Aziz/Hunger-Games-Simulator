package InteractableObjects.Consumables.ConsumableState;

import InteractableObjects.Consumables.Consumable;
import InteractableObjects.Consumables.ConsumableBehaviours.ConsumableBehavior;
import InteractableObjects.Consumables.ConsumableBehaviours.Heal;

public class Fresh implements ConsumableState{
    @Override
    public void next(Consumable object) {
        object.setState(new Stale());
    }

    @Override
    public ConsumableBehavior getEffect() {
        return new Heal(2);
    }
}

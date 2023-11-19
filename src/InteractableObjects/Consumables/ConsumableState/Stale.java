package InteractableObjects.Consumables.ConsumableState;

import InteractableObjects.Consumables.Consumable;
import InteractableObjects.Consumables.ConsumableBehaviours.ConsumableBehavior;
import InteractableObjects.Consumables.ConsumableBehaviours.Heal;
import Singletons.UI;

public class Stale implements ConsumableState{
    @Override
    public void next(Consumable object) {
        object.setState(new Rotten());
    }

    @Override
    public ConsumableBehavior getEffect() {
        UI.getInstance().print("You take a bite of the stale food and feel nothing");
        return new Heal(0);
    }
}

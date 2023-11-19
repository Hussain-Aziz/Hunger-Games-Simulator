package InteractableObjects.Consumables.ConsumableState;

import InteractableObjects.Consumables.Consumable;
import InteractableObjects.Consumables.ConsumableBehaviours.ConsumableBehavior;
import InteractableObjects.Consumables.ConsumableBehaviours.Damage;
import Singletons.UI;

public class Rotten implements ConsumableState{
    @Override
    public void next(Consumable object) {
        object.setState(new Rotten());
    }

    @Override
    public ConsumableBehavior getEffect() {
        UI.getInstance().print("You take a bite of the rotten food and feel sick");
        return new Damage();
    }

    @Override
    public String toString() {
        return "Rotten";
    }
}

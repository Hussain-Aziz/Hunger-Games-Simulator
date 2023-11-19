package InteractableObjects.Consumables.ConsumableBehaviours;

import Characters.Character;
import Singletons.UI;

public class Damage implements ConsumableBehavior{
    @Override
    public void affect(Character sender) {
        sender.takeDamage(1);
    }
}

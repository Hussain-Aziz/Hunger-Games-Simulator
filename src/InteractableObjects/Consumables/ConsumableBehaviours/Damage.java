package InteractableObjects.Consumables.ConsumableBehaviours;

import Characters.Character;

public class Damage implements ConsumableBehavior{
    @Override
    public void consume(Character sender) {
        sender.takeDamage(1);
    }
}

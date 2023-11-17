package InteractableObjects.Consumables.ConsumableBehaviours;

import Characters.Character;

public class Heal implements ConsumableBehavior{
    private int healAmount;

    public Heal(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void consume(Character sender) {
        sender.heal(healAmount);
    }
}

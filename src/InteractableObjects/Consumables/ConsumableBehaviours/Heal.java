package InteractableObjects.Consumables.ConsumableBehaviours;

import Characters.Character;

public class Heal implements ConsumableBehavior{
    private final int healAmount;

    public Heal(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void affect(Character sender) {
        sender.heal(healAmount);
    }
}

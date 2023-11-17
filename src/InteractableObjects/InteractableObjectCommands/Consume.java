package InteractableObjects.InteractableObjectCommands;

import Characters.Character;
import InteractableObjects.Consumables.Consumable;

public class Consume implements InteractableObjectCommand{
    private final Consumable object;

    public Consume(Consumable object) {
        this.object = object;
    }
    @Override
    public void execute(Character sender) {
        object.consume(sender);
    }

    // use on a weapon is considered attack
    @Override
    public String getName() {
        return "use";
    }
}

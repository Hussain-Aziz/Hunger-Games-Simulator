package InteractableObjects.InteractableObjectCommands;

import Characters.Character;
import InteractableObjects.InteractableObject;

public class Drop implements InteractableObjectCommand{
    private final InteractableObject object;

    public Drop(InteractableObject object) {
        this.object = object;
    }
    @Override
    public void execute(Character sender) {
        object.drop(sender);
    }

    @Override
    public String getName() {
        return "drop";
    }
}

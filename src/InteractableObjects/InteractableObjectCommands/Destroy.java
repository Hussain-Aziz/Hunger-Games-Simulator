package InteractableObjects.InteractableObjectCommands;

import Characters.Character;
import InteractableObjects.InteractableObject;

public class Destroy implements InteractableObjectCommand{
    private final InteractableObject object;

    public Destroy(InteractableObject object) {
        this.object = object;
    }
    @Override
    public void execute(Character sender) {
        object.destroy(sender);
    }

    @Override
    public String getName() {
        return "destroy";
    }
}

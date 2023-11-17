package InteractableObjects.InteractableObjectCommands;

import Characters.Character;
import InteractableObjects.InteractableObject;
import Singletons.UI;

public class Inspect implements InteractableObjectCommand{
    private final InteractableObject object;

    public Inspect(InteractableObject object) {
        this.object = object;
    }
    @Override
    public void execute(Character sender) {
        object.inspect();
    }

    @Override
    public String getName() {
        return "inspect";
    }
}

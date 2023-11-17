package InteractableObjects.InteractableObjectCommands;

import Characters.Character;
import InteractableObjects.InteractableObject;
import Singletons.UI;

public class Take implements InteractableObjectCommand{
    private final InteractableObject object;

    public Take(InteractableObject object) {
        this.object = object;
    }
    @Override
    public void execute(Character sender) {
        object.take(sender);
    }

    @Override
    public String getName() {
        return "take";
    }
}

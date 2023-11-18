package InteractableObjects.InteractableObjectCommands;

import Characters.Character;

public interface InteractableObjectCommand {
    void execute(Character sender);
    String getName();
}

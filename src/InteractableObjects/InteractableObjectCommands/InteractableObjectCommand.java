package InteractableObjects.InteractableObjectCommands;

import Characters.Character;

public interface InteractableObjectCommand {
    public void execute(Character sender);
    public String getName();
}

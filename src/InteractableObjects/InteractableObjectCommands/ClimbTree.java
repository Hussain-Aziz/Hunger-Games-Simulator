package InteractableObjects.InteractableObjectCommands;

import Characters.Character;
import InteractableObjects.Enviornment.EnvironmentObject;

public class ClimbTree implements InteractableObjectCommand{

    public ClimbTree() {
    }
    @Override
    public void execute(Character sender) {
        // force climb by using sensor
        // read sensor
        // until sensor doesn't give correct ouput
        // wait
    }

    @Override
    public String getName() {
        return "use";
    }
}

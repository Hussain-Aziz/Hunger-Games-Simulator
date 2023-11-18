package InteractableObjects.InteractableObjectCommands.SensorCommands;

import Characters.Character;
import Singletons.SensorBehaviours.*;
import Singletons.*;

public class ClimbTree extends SensorCommand {
    @Override
    public void setSensorBehaviour(SensorManager sensorManager) {
        sensorManager.setSensorBehaviour(new Climbing());
    }

    @Override
    protected void onSuccess(Character sender) {
        UI.getInstance().print("You have climbed the tree");
    }
}

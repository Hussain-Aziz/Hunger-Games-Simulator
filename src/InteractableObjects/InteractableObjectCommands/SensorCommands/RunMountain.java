package InteractableObjects.InteractableObjectCommands.SensorCommands;

import Characters.Character;
import Singletons.SensorBehaviours.*;
import Singletons.*;

public class RunMountain extends SensorCommand {
    @Override
    public boolean setSensorBehaviour(SensorManager sensorManager) {
        return sensorManager.setSensorBehaviour(new Running());
    }

    @Override
    protected void onSuccess(Character sender) {
        UI.getInstance().print("You have ascended the mountain");
    }
}

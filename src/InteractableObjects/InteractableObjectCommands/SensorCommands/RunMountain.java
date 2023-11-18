package InteractableObjects.InteractableObjectCommands.SensorCommands;

import Characters.Character;
import Sensors.SensorBehaviours.Climbing;
import Sensors.SensorBehaviours.Running;
import Sensors.SensorManager;
import Singletons.UI;

public class RunMountain extends SensorCommand {
    @Override
    public void setSensorBehaviour(SensorManager sensorManager) {
        sensorManager.setSensorBehaviour(new Running());
    }

    @Override
    protected void onSuccess(Character sender) {
        UI.getInstance().print("You have ascended the mountain");
    }
}

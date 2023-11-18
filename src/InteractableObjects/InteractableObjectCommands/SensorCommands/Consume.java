package InteractableObjects.InteractableObjectCommands.SensorCommands;

import Characters.Character;
import InteractableObjects.Consumables.Consumable;
import InteractableObjects.InteractableObjectCommands.InteractableObjectCommand;
import Sensors.SensorBehaviours.Healing;
import Sensors.SensorManager;

public class Consume extends SensorCommand {
    private final Consumable object;

    public Consume(Consumable object) {
        this.object = object;
    }

    @Override
    public void setSensorBehaviour(SensorManager sensorManager) {
        sensorManager.setSensorBehaviour(new Healing());
    }

    @Override
    protected void onSuccess(Character sender) {
        object.consume(sender);
    }
}

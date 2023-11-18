package InteractableObjects.InteractableObjectCommands.SensorCommands;

import Characters.Character;
import InteractableObjects.Consumables.Consumable;
import Singletons.SensorBehaviours.*;
import Singletons.*;

public class Consume extends SensorCommand {
    private final Consumable object;

    public Consume(Consumable object) {
        this.object = object;
    }

    @Override
    public boolean setSensorBehaviour(SensorManager sensorManager) {
        return sensorManager.setSensorBehaviour(new Healing());
    }

    @Override
    protected void onSuccess(Character sender) {
        object.consume(sender);
    }
}

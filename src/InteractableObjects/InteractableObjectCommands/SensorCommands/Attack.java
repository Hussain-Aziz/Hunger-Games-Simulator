package InteractableObjects.InteractableObjectCommands.SensorCommands;

import Characters.Character;
import InteractableObjects.Weapons.Weapon;
import Singletons.*;
import Singletons.SensorBehaviours.*;

public class Attack extends SensorCommand {
    private final Weapon object;

    public Attack(Weapon object) {
        this.object = object;
    }

    @Override
    public void setSensorBehaviour(SensorManager sensorManager) {
        sensorManager.setSensorBehaviour(new Swinging());
    }

    @Override
    protected void onSuccess(Character sender) {
        object.attack(sender);
    }
}

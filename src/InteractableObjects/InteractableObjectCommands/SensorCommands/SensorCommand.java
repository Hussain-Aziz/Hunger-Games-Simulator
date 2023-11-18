package InteractableObjects.InteractableObjectCommands.SensorCommands;

import Characters.Character;
import InteractableObjects.InteractableObjectCommands.InteractableObjectCommand;
import Sensors.SensorManager;

/*
 * Template class for those commands that use sensors
 */
public abstract class SensorCommand implements InteractableObjectCommand {
    @Override
    public final void execute(Character sender) {
        var sensorManager = SensorManager.getInstance();

        setSensorBehaviour(sensorManager);

        if (printPrompt()) {
            sensorManager.getSensorBehaviour().printPrompt();
        }

        while (sensorManager.isStillRunning()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        onSuccess(sender);
    }

    /*
     * A function called by execute() to set the sensor behaviour
     */
    public abstract void setSensorBehaviour(SensorManager sensorManager);

    /*
     * A function called by execute() to that is called on successful completion of the sensor
     */
    protected abstract void onSuccess(Character sender);

    /*
     * A hook function which can be overridden to not print the starting prompt
     */
    public boolean printPrompt() {
        return true;
    }

    @Override
    public String getName() {
        return "use";
    }
}
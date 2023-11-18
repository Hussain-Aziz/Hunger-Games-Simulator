package InteractableObjects.InteractableObjectCommands.SensorCommands;

import Characters.Character;
import InteractableObjects.InteractableObjectCommands.InteractableObjectCommand;
import Singletons.*;

/*
 * Template class for those commands that use sensors
 */
public abstract class SensorCommand implements InteractableObjectCommand {
    @Override
    public final void execute(Character sender) {
        var sensorManager = SensorManager.getInstance();

        // still let the app run if sensor not connected
        if (setSensorBehaviour(sensorManager)) {
            if (printPrompt()) {
                sensorManager.getSensorBehaviour().printPrompt();
            }

            while (sensorManager.isStillRunning()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    UI.getInstance().print(e);
                }
            }
        }

        onSuccess(sender);
    }

    /*
     * A function called by execute() to set the sensor behaviour
     */
    public abstract boolean setSensorBehaviour(SensorManager sensorManager);

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

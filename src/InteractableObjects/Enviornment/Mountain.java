package InteractableObjects.Enviornment;

import InteractableObjects.InteractableObjectCommands.SensorCommands.RunMountain;

public class Mountain extends EnvironmentObject {
	public Mountain() {
		super("Mountain", "Large Impenetrable Mountain ", new RunMountain());
	}

}

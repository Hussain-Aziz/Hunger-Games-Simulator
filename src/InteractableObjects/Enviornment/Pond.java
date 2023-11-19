package InteractableObjects.Enviornment;

import InteractableObjects.InteractableObjectCommands.SensorCommands.RunMountain;

public class Pond extends EnvironmentObject {
	public Pond() {
		super("Pond", "Large body of water", new RunMountain());
	}

}

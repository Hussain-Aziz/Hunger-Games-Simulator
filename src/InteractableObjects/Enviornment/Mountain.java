package InteractableObjects.Enviornment;

import Characters.Character;
import InteractableObjects.InteractableObject;
import InteractableObjects.InteractableObjectCommands.RunMountain;
import Sensors.TCP;

public class Mountain extends EnvironmentObject {
	static TCP tcp;
	public Mountain() {
		super("Mountain", "Large Impenetrable Mountain ", new RunMountain(tcp));
	}

}

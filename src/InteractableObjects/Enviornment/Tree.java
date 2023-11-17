package InteractableObjects.Enviornment;

import Characters.Character;
import InteractableObjects.InteractableObject;
import InteractableObjects.InteractableObjectCommands.ClimbTree;
import Sensors.TCP;

public class Tree extends EnvironmentObject {

	 static TCP tcp;

	public Tree() {
		super("Tree", "A tall tree with a lot of branches", new ClimbTree(tcp));
	}

}

package InteractableObjects.Enviornment;

import InteractableObjects.InteractableObjectCommands.SensorCommands.ClimbTree;

public class Tree extends EnvironmentObject {

	public Tree() {
		super("Tree", "A tall tree with a lot of branches", new ClimbTree());
	}

}

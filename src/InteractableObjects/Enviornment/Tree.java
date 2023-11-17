package InteractableObjects.Enviornment;

import Characters.Character;
import InteractableObjects.InteractableObject;
import InteractableObjects.InteractableObjectCommands.ClimbTree;

public class Tree extends EnvironmentObject {

	public Tree() {
		super("Tree", "A tall tree with a lot of branches", new ClimbTree());
	}

}

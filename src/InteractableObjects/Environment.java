package InteractableObjects;

import Characters.Character;

public class Environment extends InteractableObject {

	public Environment(String name, String description) {
		super(name, description);
	}

	@Override
	public void interact(Character sender, String command) {
		// sender.interact(command);
		if (this.name == "Forest") {
			if (command.equals("Climb"))
				System.out.println(sender.getName() + "is Climbing a tree");
		}

	}

}

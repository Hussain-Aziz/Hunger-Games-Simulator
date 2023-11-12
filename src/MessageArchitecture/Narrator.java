package MessageArchitecture;

import Characters.Character;
import Singletons.UI;

public class Narrator extends ConcreteObserver {
	
	public Narrator(Character[] subject) {
		super(subject);
	}
	
	public void update(Message m) {
		switch(m.topic)
		{
			case "health" -> {
				UI.getInstance().print("Narrator: " + ((Character) m.origin).getName() + "'s health is running low!");
				//Outputs the character's name, need to add narration regarding health 
			}
			case "death" -> {
				//narration regarding character's death
			}
		}
	}
}

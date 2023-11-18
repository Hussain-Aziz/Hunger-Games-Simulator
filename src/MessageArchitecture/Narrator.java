package MessageArchitecture;

import Characters.Character;
import Singletons.UI;

import java.util.ArrayList;

public class Narrator extends ConcreteObserver {
	
	public Narrator(ArrayList<Character> subject) {
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
				UI.getInstance().print("Narrator: unfortunate events have lead to " + m.payload);
			}
			case "damage" -> {
				UI.getInstance().print("Narrator: " + ((Character) m.origin).getName() + " has done " + m.payload);
			}
			case "heal" -> {
				UI.getInstance().print("Narrator: " + ((Character) m.origin).getName() + " has been " + m.payload);
			}
		}
	}
}

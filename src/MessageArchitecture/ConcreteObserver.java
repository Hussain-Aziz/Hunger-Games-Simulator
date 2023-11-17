package MessageArchitecture;

import Characters.Character;

import java.util.ArrayList;

public abstract class ConcreteObserver implements Observer {

    ArrayList<Character> subject = null;

    ConcreteObserver(ArrayList<Character> subject) {
        this.subject = subject;
		for (Character character : subject) {
			character.registerObserver(this);
		}
    }


}
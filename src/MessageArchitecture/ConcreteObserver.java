package MessageArchitecture;

import Characters.Character;

public abstract class ConcreteObserver implements Observer{
	
		Character[] subject = null;
		
		ConcreteObserver(Character[] subject){
		this.subject = subject;
		for(int i = 0 ; i < subject.length; i++) {
			subject[i].registerObserver(this);
			
		}
	}
		
	
		
}
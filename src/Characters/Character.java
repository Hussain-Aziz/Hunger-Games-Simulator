package Characters;

import java.util.ArrayList;

import Enums.Direction;
import InteractableObjects.InteractableObjectOwner;
import MessageArchitecture.Message;
import MessageArchitecture.Observer;
import MessageArchitecture.Subject;
import Scenes.Position;
import Scenes.Scene;
import Singletons.UI;
/**
 * The base class for all characters in the game
 */
public abstract class Character implements InteractableObjectOwner, Subject {

    /**
     * The random number generator for the character
     */
    protected String name;
    /**
     * The current health of the character
     */
    protected int health;

    /**
     * The current scene that the character is in
     */
    protected Scene currentScene;

    /**
     * Observer array used for ConcreteSubject implementation
     */
    private ArrayList<Observer> observers;
    
    /**
     * Constructor of the Character class
     */
    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        observers = new ArrayList <Observer>();
    }

    /**
     * Moves the character in a direction
     */
    public void move(Direction direction) {
        Position newPosition = getPosition().Clone();

        switch (direction) {
            case north -> newPosition.setY(getPosition().getY() + 1);
            case south -> newPosition.setY(newPosition.getY() - 1);
            case east -> newPosition.setX(newPosition.getX() + 1);
            case west -> newPosition.setX(newPosition.getX() - 1);
        }
        currentScene.moveCharacter(this, newPosition);
    }

    /**
     * Sets the current scene of the character
     * This can't be done in the constructor because the scene does not exist yet
     */
    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }
    public Scene getCurrentScene() {
        return currentScene;
    }
    public Position getPosition() {
        return getCurrentScene().getCharacterPosition(this);
    }
    public void takeDamage(int damage) {
        health -= damage;
        if (health == 1) {
        	publishMessage(new Message(this, "health", "low health"));
        }
        else if (health == 0) {
        	publishMessage(new Message(this, "death", name + " has dying"));
            currentScene.killCharacter(this);
        }
    }
    
   public void heal(int health) {
        this.health += health;
        if (this.health == 1) {
        	publishMessage(new Message(this, "health", "low health"));
        }
        else if (this.health == 0) {
        	publishMessage(new Message(this, "health", "death"));
        }
    }
    
    public String getName() {
        return name;
    }
    
    /**
     *ConcreteSubject implementation
     */    
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObsever(Observer o) {
		observers.remove(o);
	}
	
	public void publishMessage(Message m) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
            observer.update(m);
		}
	}

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}

package Characters;

import java.util.ArrayList;

import Enums.Direction;
import InteractableObjects.Environment;
import InteractableObjects.InteractableObject;
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
public abstract class Character implements Runnable, InteractableObjectOwner, Subject {
    /**
     * The thread that the character runs on
     */
    private final Thread thread;
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

        this.thread = new Thread(this);
        this.thread.start();
    }

    /**
     * A function to be implemented that will be the main loop of the character
     * use it to make characters move around the map and interact with objects
     */
    protected abstract void mainLoop() throws InterruptedException;

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
        if ((newPosition.getY() >= 2 && newPosition.getX() >= 2) && (newPosition.getY() != 2 && newPosition.getX() != 2))
        {
        	Scene forestScene = Singletons.SceneManager.getInstance().getAdjacentScene(currentScene, direction);
        	if (forestScene != null)
        	{
        		forestScene.characterEntry(this, direction);
        		setCurrentScene(forestScene);
        		Environment forestEnvironment = forestScene.getEnv();
        		forestEnvironment.interact(this, "Climb");
        		//UI.getInstance().print("Player is in the forest !\n ");
        	}
        	
        	
        	//TODO: do the same but for cornucopia and mountain area ....
        }
        currentScene.moveCharacter(this, newPosition);
        
       // InteractableObject ObjectsAtNewPosition = currentScene.getInteractableObjectAtPosition(newPosition); 					  ()()()
    
    }

    /**
     * Implementation of the run function from the Runnable interface
     */
    public void run() {
        try {
            mainLoop();
        } catch (InterruptedException e) {
            UI.getInstance().print(e);
        }
    }

    /**
     * Sets the current scene of the character
     * This can't be done in the constructor because the scene does not exist yet
     */
    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }

    protected Thread getThread() {
        return thread;
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
        	publishMessage(new Message(this, "health", "death"));
        }
    }
    
   /* public void Heal(int damage) {
        health -= damage;
        if (health == 1) {
        	publishMessage(new Message(this, "health", "low health"));
        }
        else if (health == 0) {
        	publishMessage(new Message(this, "health", "death"));
        }
    }*/
    
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
			Observer observer = (Observer)
			observers.get(i); observer.update(m);
		}
	}
}

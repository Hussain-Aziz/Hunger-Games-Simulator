package Scenes;

import Characters.Character;
import Characters.Environment;
import Characters.MainCharacter;
import Enums.Direction;
import InteractableObjects.InteractableObject;
import InteractableObjects.InteractableObjectOwner;
import Singletons.SceneManager;
import Singletons.UI;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Template class for scenes in the game
 */
public abstract class Scene implements InteractableObjectOwner {
    /**
     * The name of the scene
     */
    protected String name;
    /**
     * The description of the scene
     */
    protected String description;

    /**
     * A Dictionary of the objects in the scene and their positions
     */
    protected HashMap<InteractableObject, Position> interactableObjects;
    /**
     * A Dictionary of the characters in the scene and their positions
     */
    protected HashMap<Character, Position> characters;

    /**
     * The size of the scene
     */
    protected int sceneSize;

    /**
     * Constructor of the Scene class
     */
    public Scene(String name,
                 String description,
                 int sceneSize,
                 HashMap<InteractableObject, Position> interactableObjects,
                 HashMap<Character, Position> characters) {

        this.name = name;
        this.description = description;
        this.sceneSize = sceneSize;
        this.interactableObjects = interactableObjects;
        this.characters = characters;

        for (InteractableObject object : interactableObjects.keySet()) {
            object.setOwner(this);
        }

        for (Character character : characters.keySet()) {
            character.setCurrentScene(this);
        }
    }

    /**
     * Returns the description of the scene plus the objects and characters in it
     */
    public String getDescription() {
        String output = description + "\n";
        output += "You see:\n";
        for (InteractableObject object : interactableObjects.keySet()) {
            output += "\t" + object.getName() + "\n";
        }
        for (Character character : characters.keySet()) {
            output += "\t" + character.getName() + "\n";
        }
        return output;
    }

    //TODO: print objects near player
    /**
     * Moves a character to a new position
     * If the new position is outside the scene, the character will exit the scene
     */
    public void moveCharacter(Character character, Position newPosition) {
        if (newPosition.getX() > sceneSize) {
            characterExit(character, Direction.east);
        } else if (newPosition.getX() < 0) {
            characterExit(character, Direction.west);
        } else if (newPosition.getY() > sceneSize) {
            characterExit(character, Direction.north);
        } else if (newPosition.getY() < 0) {
            characterExit(character, Direction.south);
        } else {
            characters.get(character).set(newPosition);
        }
    }

    /**
     * Removes a character from the scene
     * Adds the character to the adjacent scene in the exit direction
     */
    private void characterExit(Character character, Direction exitDirection) {
        var nextScene = SceneManager.getInstance().getAdjacentScene(this, exitDirection);
        if (nextScene != null) {
            nextScene.characterEntry(character, exitDirection);
            characters.remove(character);
        } else {
            if (character instanceof MainCharacter) {
                UI.getInstance().print("You can't go that way");
            }
        }
    }

    /**
     * Adds a character to the scene
     * Sets the position of the character based on the enter direction
     */
    public void characterEntry(Character character, Direction enterDirection) {
        int x = 0;
        int y = 0;

        switch (enterDirection) {
            case south -> y = sceneSize;
            case west -> x = sceneSize;
        }

        characters.put(character, new Position(x, y));
        character.setCurrentScene(this);

        UI.getInstance().print("You have entered " + name);
    }

    @Override
    public boolean take(InteractableObject object, Position position) {
        interactableObjects.put(object, position);
        return true;
    }
    @Override
    public void drop(InteractableObject object) {
        interactableObjects.remove(object);
    }
    public String getName() {
        return name;
    }
    public Position getCharacterPosition(Character character) {
        return characters.get(character);
    }
    public Position getInteractableObjectPosition(InteractableObject object) {
        return interactableObjects.get(object);
    }
    public HashMap<Character, Position> getCharacters() {
        return characters;
    }

	public abstract InteractableObjects.Environment getEnv();
}

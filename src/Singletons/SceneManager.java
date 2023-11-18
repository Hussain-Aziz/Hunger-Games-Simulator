package Singletons;

import Characters.Character;
import Scenes.Direction;
import Scenes.Cornucopia;
import Scenes.Forest;
import Scenes.Scene;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Singleton class for managing scenes
 * Creates scenes at the start of the game
 * Handles movement between scenes
 */
public class SceneManager {

    /**
     * The instance of the SceneManager class
     */
    private static SceneManager instance = null;

    /**
     * A graph of scenes (stored as adjacency lists) used for movement between them
     */
    private final HashMap<Scene, HashMap<Direction, Scene>> adjacentScenes;

    private final Scene startScene;

    /**
     * Private constructor of the SceneManager class
     * Creates the scenes and adds them to the graph
     */
    private SceneManager() {
        adjacentScenes = new HashMap<>();

        var cornucopia = new Cornucopia();
        var forest = new Forest();

        startScene = cornucopia;

        adjacentScenes.put(cornucopia, new HashMap<Direction, Scene>() {{
            put(Direction.north, forest);
        }});
        adjacentScenes.put(forest, new HashMap<Direction, Scene>() {{
            put(Direction.south, cornucopia);
        }});
    }

    /**
     * Returns the instance of the SceneManager class
     */
    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    /**
     * Returns the array of scenes of the game
     */
    public ArrayList<Scene> getSceneList() {
        return new ArrayList<>(adjacentScenes.keySet());
    }

    public Scene getStartScene() {
        return startScene;
    }

    /**
     * Returns the scene that is adjacent to the current scene in the given direction
     * Returns null if there is no scene in that direction
     */
    public Scene getAdjacentScene(Scene currentScene, Direction exitDirection) {
        return adjacentScenes.get(currentScene).get(exitDirection);
    }

    public ArrayList<Character> getAllCharacters() {
        ArrayList<Character> allCharacters = new ArrayList<Character>();
    	for (Scene scene : adjacentScenes.keySet()) {
    		allCharacters.addAll(scene.getCharacters().keySet());
    	}
        return allCharacters;
    }
}

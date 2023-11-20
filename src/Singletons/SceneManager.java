package Singletons;

import Characters.Character;
import Characters.Katniss;
import Characters.MainCharacter;
import Scenes.*;

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
    private MainCharacter mainCharacter;
    private int score;

    /**
     * Private constructor of the SceneManager class
     * Creates the scenes and adds them to the graph
     */
    private SceneManager() {
        adjacentScenes = new HashMap<>();

        var cornucopia = new Cornucopia();
        var forest = new Forest();
        var lake = new Lake();
        var nutMountain = new NutMountain();

        startScene = cornucopia;

        adjacentScenes.put(cornucopia, new HashMap<Direction, Scene>() {{
            put(Direction.north, forest);
            put(Direction.south, nutMountain);
            put(Direction.east, lake);
        }});
        adjacentScenes.put(forest, new HashMap<Direction, Scene>() {{
            put(Direction.south, cornucopia);
        }});

        adjacentScenes.put(lake, new HashMap<Direction, Scene>() {{
            put(Direction.west, cornucopia);
        }});

        adjacentScenes.put(nutMountain, new HashMap<Direction, Scene>() {{
            put(Direction.north, cornucopia);
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

    public void setMainCharacter(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
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

    public void addScore() {
        this.score += 1;

        if (score >= 4) {
            UI.getInstance().print("             ___________");
            UI.getInstance().print("            '._==_==_=_.'");
            UI.getInstance().print("            .-\\:      /-.");
            UI.getInstance().print("           | (|:.     |) |");
            UI.getInstance().print("            '-|:.     |-'");
            UI.getInstance().print("              \\::.    /");
            UI.getInstance().print("               '::. .'");
            UI.getInstance().print("                 ) (");
            UI.getInstance().print("               _.' '._");
            UI.getInstance().print("              `\"\"\"\"\"\"\"`");
            UI.getInstance().print("You have bested all your foes and survived the hunger games!");
            UI.getInstance().print("You have finished this game and you may now close this window");
            System.exit(0);
        }
    }

    public Katniss getMainCharacter() {
        return (Katniss) mainCharacter;
    }
}

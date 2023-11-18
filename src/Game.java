import Characters.Katniss;
import Characters.Character;
import Enums.Direction;
import Sensors.SensorManager;
import Singletons.SceneManager;
import Singletons.UI;
import MessageArchitecture.Narrator;

/**
 * Class that acts as the entry point of the game
 */
public class Game {
    /**
     * Entry point of the game
     */
    public static void main(String[] args) {
        // initialize singletons
        UI.getInstance();
        SceneManager.getInstance();
        SensorManager.getInstance();

        UI.getInstance().print("Welcome to the Hunger Games!");
        UI.getInstance().print("You will now be dropped into the arena.");

        // create main character
        var startingScene = SceneManager.getInstance().getStartScene();
        Character mainCharacter = new Katniss();
        startingScene.characterEntry(mainCharacter, Direction.north);

        // create narrator and add characters as subjects
        Narrator narrator = new Narrator(SceneManager.getInstance().getAllCharacters());
    }
}

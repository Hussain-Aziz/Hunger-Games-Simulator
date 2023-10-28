import Characters.Katniss;
import Characters.Character;
import Enums.Direction;
import Singletons.SceneManager;
import Singletons.UI;

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

        UI.getInstance().print("Welcome to the Hunger Games!");
        UI.getInstance().print("You will now be dropped into the arena.");

        // create main character
        var startingScene = SceneManager.getInstance().getSceneList().get(0);
        Character mainCharacter = new Katniss();
        startingScene.characterEntry(mainCharacter, Direction.north);

    }
}

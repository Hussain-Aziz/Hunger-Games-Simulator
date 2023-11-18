import Characters.*;
import Characters.Character;
import Scenes.*;
import Singletons.*;
import MessageArchitecture.*;

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
        var characters = SceneManager.getInstance().getAllCharacters();
        Narrator narrator = new Narrator(characters);

        // register NPC as observer manually because Katniss is always created after the NPCs
        for (Character character : characters) {
            if (character instanceof NPC) {
                mainCharacter.registerObserver((NPC)character);
            }
        }
    }
}

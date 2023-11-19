import Characters.*;
import Characters.Character;
import Scenes.*;
import Singletons.*;
import MessageArchitecture.*;

public class Game {

    public static void main(String[] args) {

        handleArgs(args);

        // initialize singletons
        UI.getInstance();
        SceneManager.getInstance();
        SensorManager.getInstance().start();

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

    private static void handleArgs(String[] args) {
        if (args.length == 2) {
            SensorManager.getInstance().setHost(args[0], Integer.parseInt(args[1]));
        }

        UI.getInstance().print("                    . .:.:.:.:. .:  \\     /:. .:.:.:.:. ,");
        UI.getInstance().print("               .-._  `..:.:. . .:.:`- -':.:. . .:.:.,'  _.-.");
        UI.getInstance().print("              .:.:.`-._`-._..-''_...---..._``-.._.-'_.-'.:.:.");
        UI.getInstance().print("           .:.:. . .:_.`' _..-''._________,``-.._ `.._:. . .:.:.");
        UI.getInstance().print("        .:.:. . . ,-'_.-''      ||_-(O)-_||      ``-._`-. . . .:.:.");
        UI.getInstance().print("       .:. . . .,'_.'           '---------'           `._`.. . . .:.");
        UI.getInstance().print("     :.:. . . ,','               _________               `.`. . . .:.:");
        UI.getInstance().print("    `.:.:. .,','            _.-''_________``-._            `._.     _.'");
        UI.getInstance().print("  -._  `._./ /            ,'_.-'' ,       ``-._`.          ,' '`:..'  _.-");
        UI.getInstance().print(" .:.:`-.._' /           ,','                   `.`.       /'  '    \\  \\.-':.:.");
        UI.getInstance().print(" :.:. . ./ /          ,','               ,       `.`.    / '  '  '  \\  \\. .:.:");
        UI.getInstance().print(":.:. . ./ /          / /    ,                        \\   \\  :  '  '  '   \\  \\. .:.:");
        UI.getInstance().print(".:. . ./ /          / /            ,          ,       \\   \\ :  '  '  ' '::. .:.");
        UI.getInstance().print(":. . .: :    o     / /                                 \\ ;'  '  '  ' ':: . .:");
        UI.getInstance().print(".:. . | |   /_  \\   : :     ,                      ,    : '  '  '  ' ' :: .:.");
        UI.getInstance().print(":. . .| |  ((<))  | |,          ,       ,             |  \\'__',-._.' ' ||. .:");
        UI.getInstance().print(".:.:. | |   `-'   | |---....____                      | ,---  \\/--/  ' ||:.:.");
        UI.getInstance().print("------| |         : :    ,.     ```--..._   ,         |''  '  '  ' ' ||----");
        UI.getInstance().print("_...--. |  ,         \\   \\             ,.    `-._     ,  /: '  '  '  ' ' ;;..._");
        UI.getInstance().print(":.:. .| | -O-         \\   \\    ,.                `._    / /:'  '  '  ' ':: .:.:");
        UI.getInstance().print(".:. . | |_(`__         \\   \\                        `. / / :'  '  '  ' ';;. .:.");
        UI.getInstance().print(":. . .<' (_)  `>      `.`.          ,.    ,.     ,','     \\  '  '  ' ;;. . .:");
        UI.getInstance().print(".:. . |):-.--'(         `.`-._  ,.           _,-','        \\ '  '  '//| . .:.");
        UI.getInstance().print(":. . .;)()(__)(___________`-._`-.._______..-'_.-'_________  \\'  '  //_:. . .:");
        UI.getInstance().print(".:.:,'   \\/  \\/--  \\/--------------------------------------------`._',;'`. `.:.:.");
        UI.getInstance().print(":.,' ,' ,'  ,'  /   /   /   ,-------------------.     \\     \\     \\  `. `.`. `..:");
        UI.getInstance().print(",' ,'  '   /   /   /   /   //                     \\  \\     \\     \\     \\     \\  ` `.");
        
    }
}

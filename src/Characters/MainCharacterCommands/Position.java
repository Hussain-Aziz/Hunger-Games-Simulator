package Characters.MainCharacterCommands;

import Characters.Katniss;
import Scenes.Direction;
import Singletons.SceneManager;
import Singletons.UI;

public class Position implements CharacterCommand {
    private final Katniss katniss;

    public Position(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        StringBuilder output = new StringBuilder();
        output.append("You are in " + katniss.getCurrentScene().getName() + " at "  + katniss.getPosition() + "\n");
        if (!katniss.getCurrentScene().getCharacters().keySet().isEmpty()) {
            output.append("Characters:\n");
            for (var character : katniss.getCurrentScene().getCharacters().keySet()) {
                if (character != katniss) {
                    output.append("\t" + character.getName() + " is at " + katniss.getCurrentScene().getCharacters().get(character) + "\n");
                }
            }
        }
        if (!katniss.getCurrentScene().getInteractableObjects().keySet().isEmpty()) {
            output.append("Objects:\n");
            for (var object : katniss.getCurrentScene().getInteractableObjects().keySet()) {
                output.append("\t" + object.getName() + " is at " + katniss.getCurrentScene().getInteractableObjects().get(object) + "\n");
            }
        }

        output.append("Scenes:\n");
        for(Direction direction: Direction.values()) {
            var adjacentScene = SceneManager.getInstance().getAdjacentScene(katniss.getCurrentScene(), direction);
            if (adjacentScene != null) {
                output.append("\t" + direction.toString() + ": " + adjacentScene.getName() + "\n");
            }
        }

        UI.getInstance().print(output.toString());
    }

    @Override
    public String[] getAliases() {
        return new String[]{"position", "pos", "map"};
    }

    @Override
    public String getDescription() {
        return "Prints your position in the current scene";
    }
}

package Characters.MainCharacterCommands;

import Characters.Katniss;
import Scenes.Direction;
import Singletons.UI;

public class Move implements CharacterCommand {
    private final Katniss katniss;

    public Move(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            UI.getInstance().print("I can't move there");
            return;
        }
        Direction direction = Direction.getDirection(args[1]);
        if (direction == null) {
            UI.getInstance().print("I can't move there");
            return;
        }
        katniss.move(direction);
    }

    @Override
    public String[] getAliases() {
        return new String[]{"move", "go", "walk"};
    }

    @Override
    public String getDescription() {
        return "Moves the character in the specified direction (args: either north, south, east, west)";
    }
}

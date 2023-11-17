package Characters.MainCharacterCommands;

import Characters.Katniss;
import Singletons.UI;

public class Position implements CharacterCommand {
    private final Katniss katniss;

    public Position(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        UI.getInstance().print("You are in " + katniss.getCurrentScene().getName() + " at "  +katniss.getPosition());
    }

    @Override
    public String[] getAliases() {
        return new String[]{"position", "pos"};
    }

    @Override
    public String getDescription() {
        return "Prints your position in the current scene";
    }
}

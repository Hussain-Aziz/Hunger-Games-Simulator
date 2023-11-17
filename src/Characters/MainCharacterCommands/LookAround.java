package Characters.MainCharacterCommands;

import Characters.Katniss;
import Singletons.UI;

public class LookAround implements CharacterCommand {
    private final Katniss katniss;

    public LookAround(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        UI.getInstance().print(katniss.getCurrentScene().getDescription());
    }

    @Override
    public String[] getAliases() {
        return new String[]{"lookaround", "overview"};
    }

    @Override
    public String getDescription() {
        return "Prints the description of the current scene";
    }
}

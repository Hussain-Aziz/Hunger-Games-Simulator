package Characters.MainCharacterCommands;

import Characters.Katniss;
import Singletons.UI;

public class Health implements CharacterCommand {
    private final Katniss katniss;

    public Health(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        UI.getInstance().print("Your current health is: " + katniss.getHealth());
    }

    @Override
    public String getName() {
        return "health";
    }

    @Override
    public String getDescription() {
        return "Prints current health";
    }
}

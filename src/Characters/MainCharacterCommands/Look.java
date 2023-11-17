package Characters.MainCharacterCommands;

import Characters.Katniss;
import Singletons.UI;

public class Look implements CharacterCommand {
    private final Katniss katniss;

    public Look(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        katniss.getCurrentScene().printNearby(katniss);
    }

    @Override
    public String getName() {
        return "look";
    }

    @Override
    public String getDescription() {
        return "Prints all nearby objects and characters";
    }
}

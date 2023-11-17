package Characters.MainCharacterCommands;

import Characters.Katniss;
import Singletons.UI;

public class Quit implements CharacterCommand {
    private final Katniss katniss;

    public Quit(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        UI.getInstance().print("You have quit the game.");
        katniss.die();
    }

    @Override
    public String getName() {
        return "quit";
    }

    @Override
    public String getDescription() {
        return "Quit the game.";
    }
}

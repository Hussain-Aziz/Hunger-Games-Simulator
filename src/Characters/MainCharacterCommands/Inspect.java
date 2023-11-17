package Characters.MainCharacterCommands;

import Characters.Katniss;
import InteractableObjects.InteractableObject;
import Singletons.UI;

public class Inspect implements CharacterCommand {
    private final Katniss katniss;

    public Inspect(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            UI.getInstance().print("I can't use that");
            return;
        }
        for (InteractableObject object: katniss.getInventory()) {
            if (object.getName().toLowerCase().equals(args[1])) {
                object.interact(katniss, "inspect");
                return;
            }
        }
    }

    @Override
    public String[] getAliases() {
        return new String[]{"inspect", "examine"};
    }

    @Override
    public String getDescription() {
        return "Use an object";
    }
}

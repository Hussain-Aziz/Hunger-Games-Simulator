package Characters.MainCharacterCommands;

import Characters.Katniss;
import Singletons.UI;

public class Take implements CharacterCommand {
    private final Katniss katniss;

    public Take(Katniss katniss) {
        this.katniss = katniss;
    }
    @Override
    public void execute(String[] args) {
        var nearbyObjects = katniss.getCurrentScene().getNearbyObjects(katniss);
        if (nearbyObjects.isEmpty()) {
            UI.getInstance().print("There is nothing to take");
        } else {
            if (args.length != 2) {
                UI.getInstance().print("Please specify an item to take");
                return;
            }
            for (var object : nearbyObjects) {
                if (object.getName().toLowerCase().equals(args[1])) {
                    object.interact(katniss, "take");
                    return;
                }
            }
            UI.getInstance().print("I cant take that");
        }
    }

    @Override
    public String[] getAliases() {
        return new String[]{"take", "grab", "pickup"};
    }

    @Override
    public String getDescription() {
        return "Take an item from the scene. (args: item name)";
    }
}

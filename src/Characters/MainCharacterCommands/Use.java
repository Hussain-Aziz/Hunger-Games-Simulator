package Characters.MainCharacterCommands;

import Characters.Katniss;
import InteractableObjects.InteractableObject;
import InteractableObjects.Weapons.Weapon;
import Singletons.UI;

public class Use implements CharacterCommand {
    private final Katniss katniss;

    public Use(Katniss katniss) {
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
                object.interact(katniss, "use");
                if (object instanceof Weapon) {
                    katniss.usedWeapon();
                }
                return;
            }
        }
        UI.getInstance().print("I can't use that");
    }

    @Override
    public String[] getAliases() {
        return new String[]{"use", "attack", "consume", "eat"};
    }

    @Override
    public String getDescription() {
        return "Use an object (args: item name)";
    }
}

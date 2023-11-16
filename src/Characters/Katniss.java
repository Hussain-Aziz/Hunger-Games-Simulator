package Characters;

import Enums.Direction;
import InteractableObjects.Environment;
import InteractableObjects.InteractableObject;
import Scenes.Position;
import Singletons.UI;

import java.util.ArrayList;
public class Katniss extends Character implements MainCharacter {

    protected ArrayList<InteractableObject> inventory;
    protected Environment environment;
    protected final static int MAX_INVENTORY_SIZE = 3;

    public Katniss() {
        super("Katniss", 5);
    }

    @Override
    public void mainLoop() throws InterruptedException {

        while(currentScene == null) Thread.sleep(100);

        var ui = UI.getInstance();
        while (health > 0) {
            String[] inputs = ui.read().strip().toLowerCase().split(" ");
            String commmand = inputs[0];
            switch (commmand) {
                case "quit" -> {
                    ui.print("You have quit the game.");
                    health = 0; // kill character
                }
                case "help" -> ui.print("Commands: quit, help, lookaround, move, take, drop, inventory");
                case "lookaround" -> ui.print(currentScene.getDescription());
                // TODO: do something when item and player are on same position
                // TODO: do something when character is blocking movement
                case "move" -> {
                    if (inputs.length != 2) {
                        ui.print("I can't move there");
                        break;
                    }
                    Direction direction = Direction.getDirection(inputs[1]);
                    if (direction == null) {
                        ui.print("I can't move there");
                        break;
                    }
                    super.move(direction);
                    ui.print("You have moved", direction);
                }
                // TODO: take
                // TODO: drop
                // TODO: handle talking to characters
                // TODO: handle using objects
                case "inventory" -> {
                    ui.print("Inventory:");
                    if (inventory.isEmpty()) {
                        ui.print("\tEmpty");
                    }
                    else {
                        for (InteractableObject object : inventory) {
                            ui.print("\t", object.getName());
                        }
                    }
                }
                default -> ui.print("Invalid command");
            }
        }
    }

    public boolean take(InteractableObject object, Position position) {
        if (MAX_INVENTORY_SIZE > inventory.size()) {
            inventory.add(object);
            return true;
        } else {
            UI.getInstance().print("I can't carry any more items");
            return false;
        }
    }

    public void drop(InteractableObject object) {
        inventory.remove(object);
    }
}

package InteractableObjects.InteractableObjectCommands;

import Characters.Character;
import Sensors.TCP;

public class ClimbTree implements InteractableObjectCommand{

	private TCP tcp;
	
	
    public ClimbTree(TCP tcp) {
    	
    	this.tcp = tcp;
    }
    @Override
    public void execute(Character sender) {
       
    	String state = tcp.getState();
    	
    if (state == "Running")
    	{
    	System.out.println("Player is running up the mountain");
    	}
    	
    }

    @Override
    public String getName() {
        return "use";
    }
}



// until sensor doesn't give correct ouput
// wait
package InteractableObjects.InteractableObjectCommands;

import Characters.Character;
import InteractableObjects.Enviornment.EnvironmentObject;
import Sensors.TCP;

public class RunMountain implements InteractableObjectCommand{

	private TCP tcp;
	
	
    public RunMountain(TCP tcp) {
    	
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

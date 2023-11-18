package Sensors.SensorBehaviours;

import org.json.simple.JSONObject;

public interface SensorBehaviour {

    public void printPrompt();

    public double[] parseJson(JSONObject jsonObject);

    public boolean isBehaviourFound(double[] values);
}

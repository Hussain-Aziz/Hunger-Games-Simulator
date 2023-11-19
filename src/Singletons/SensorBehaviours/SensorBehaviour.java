package Singletons.SensorBehaviours;

import org.json.simple.JSONObject;

public interface SensorBehaviour {
    void printPrompt();
    double[] parseJson(JSONObject jsonObject);
    boolean isBehaviourFound(double[] values);
}

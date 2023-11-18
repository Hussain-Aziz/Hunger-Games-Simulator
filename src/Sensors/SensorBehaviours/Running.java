package Sensors.SensorBehaviours;

import Singletons.UI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Running implements SensorBehaviour {
    @Override
    public void printPrompt() {
        UI.getInstance().print("Shake to continue...");
    }

    @Override
    public double[] parseJson(JSONObject jsonObject) {
        JSONObject GravityObject = (JSONObject) jsonObject.get("gravity");
        JSONArray GravityValues = (JSONArray) GravityObject.get("value");
        double GravityX = (double) GravityValues.get(0);
        double GravityY = (double) GravityValues.get(1);
        double GravityZ = (double) GravityValues.get(2);
        return new double[]{GravityX, GravityY, GravityZ};
    }

    @Override
    public boolean isBehaviourFound(double[] values) {
        return (values[1] > 8 && values[1] < 10);
    }
}

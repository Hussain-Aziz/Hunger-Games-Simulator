package Singletons.SensorBehaviours;

import Singletons.UI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Swinging implements SensorBehaviour {
    @Override
    public void printPrompt() {
        UI.getInstance().print("Swing to continue...");
    }

    @Override
    public double[] parseJson(JSONObject jsonObject) {
        JSONObject accObject = (JSONObject) jsonObject.get("accelerometer");
        JSONArray accValues = (JSONArray) accObject.get("value");
        double AccX = (double) accValues.get(0);
        double AccY = (double) accValues.get(1);
        double AccZ = (double) accValues.get(2);
        return new double[]{AccX, AccY, AccZ};
    }

    @Override
    public boolean isBehaviourFound(double[] values) {
        return (Math.abs(values[0]) > 17) && ((Math.abs(values[1]) > 17));
    }
}

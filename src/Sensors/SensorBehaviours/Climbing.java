package Sensors.SensorBehaviours;

import Singletons.UI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Climbing implements SensorBehaviour {
    @Override
    public void printPrompt() {
        UI.getInstance().print("Shake to continue...");
    }

    @Override
    public double[] parseJson(JSONObject jsonObject) {
        JSONObject gyObject = (JSONObject) jsonObject.get("gyroscope");
        JSONArray gyroValues = (JSONArray) gyObject.get("value");
        double GyroX = (double) gyroValues.get(0);
        double GyroY = (double) gyroValues.get(1);
        double GyroZ = (double) gyroValues.get(2);
        return new double[]{GyroX, GyroY, GyroZ};
    }

    @Override
    public boolean isBehaviourFound(double[] values) {
        return (Math.abs(values[1]) < 10) && ((Math.abs(values[2]) > 5));
    }
}

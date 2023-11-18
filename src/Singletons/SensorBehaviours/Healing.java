package Singletons.SensorBehaviours;

import Singletons.UI;
import org.json.simple.JSONObject;

public class Healing implements SensorBehaviour {
    @Override
    public void printPrompt() {
        UI.getInstance().print("Hide from the light to continue...");
    }

    @Override
    public double[] parseJson(JSONObject jsonObject) {
        JSONObject lightObject = (JSONObject) jsonObject.get("light");
        double light = (double) lightObject.get("value");
        return new double[]{light};
    }

    @Override
    public boolean isBehaviourFound(double[] values) {
        return values[0] < 20;
    }
}

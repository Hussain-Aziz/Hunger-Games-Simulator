package Singletons;

import Singletons.SensorBehaviours.SensorBehaviour;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SensorManager implements Runnable {
	private final String host = "192.168.1.14";
	private final int port = 26950;
	private SensorBehaviour sensorBehaviour;
	private final JSONParser parser = new JSONParser();
	private boolean isRunning = false;
	private static SensorManager instance = null;

	private SensorManager()
	{
		new Thread(this).start();
	}

	public static SensorManager getInstance()
	{
		if(instance == null) {
			instance = new SensorManager();
		}
		return instance;
	}

	public boolean setSensorBehaviour(SensorBehaviour sensorBehaviour) {
		if (!isRunning) {
			warnServerNotRunning();
			return false;
		}
		this.sensorBehaviour = sensorBehaviour;
		return true;
	}

	public void run() {
		try (Socket socket = new Socket(this.host, this.port)) {

			isRunning = true;

			InputStream input = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);

			BufferedReader br = new BufferedReader(reader);
			String line = "";

			while ((line = br.readLine()) != null) {
				JSONObject jsonObject = (JSONObject) parser.parse(line);

				if (sensorBehaviour != null) {
					var values = sensorBehaviour.parseJson(jsonObject);
					if (sensorBehaviour.isBehaviourFound(values)) {
						sensorBehaviour = null;
					}
				}
			}
		} catch (IOException ex) {
			warnServerNotRunning();
		} catch (ParseException e) {
            UI.getInstance().printError("Not able to parse JSON from server", e);
        } finally {
			isRunning = false;
		}
	}

	private void warnServerNotRunning() {
		UI.getInstance().printError("Not able to connect to server. Please make sure the server is running.");
	}

	public boolean isStillRunning() {
		return sensorBehaviour != null;
	}

	public SensorBehaviour getSensorBehaviour() {
		return sensorBehaviour;
	}
}

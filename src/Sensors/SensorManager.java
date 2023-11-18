package Sensors;

import Sensors.SensorBehaviours.SensorBehaviour;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SensorManager implements Runnable
{
	private final String host = "192.168.1.14";
	private final int port = 26950;
	private final JSONParser parser = new JSONParser();

	private static SensorManager instance = null;
	private SensorBehaviour sensorBehaviour;

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

	public void setSensorBehaviour(SensorBehaviour sensorBehaviour) {
		this.sensorBehaviour = sensorBehaviour;
	}

	public void run() {
		try (Socket socket = new Socket(this.host, this.port)){
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
			throw new RuntimeException("Not able to connect to server: ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isStillRunning() {
		return sensorBehaviour != null;
	}

	public SensorBehaviour getSensorBehaviour() {
		return sensorBehaviour;
	}
}

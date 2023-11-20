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
import java.util.concurrent.Semaphore;

public class SensorManager implements Runnable {
	private final Thread thread;
	private String host = "192.168.137.120";
	private int port = 26951;
	private SensorBehaviour sensorBehaviour;
	private final JSONParser parser = new JSONParser();
	private boolean isRunning = false;
	private static SensorManager instance = null;

	private Semaphore semaphore = new Semaphore(1);

	private SensorManager() {
		this.thread = new Thread(this);
	}

	public void start() {
		this.thread.start();
	}

	public static SensorManager getInstance()
	{
		if(instance == null) {
			instance = new SensorManager();
		}
		return instance;
	}

	public void setHost(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public synchronized boolean setSensorBehaviour(SensorBehaviour sensorBehaviour) {
		if (!isRunning) {
			warnServerNotRunning();
			return false;
		}
		try {
			semaphore.acquire();
			this.sensorBehaviour = sensorBehaviour;
			semaphore.release();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

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
				semaphore.acquire();
				if (sensorBehaviour != null) {
					var values = sensorBehaviour.parseJson(jsonObject);
					if (sensorBehaviour.isBehaviourFound(values)) {
						sensorBehaviour = null;
					}
				}
				semaphore.release();
			}
		} catch (IOException ex) {
			warnServerNotRunning();
		} catch (ParseException e) {
            UI.getInstance().printError("Not able to parse JSON from server", e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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

package Sensors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.Socket;

import java.net.UnknownHostException;
import java.lang.Math;

public class TCP implements Runnable

{

	String host;

	int port;
	private String state = "Unknown";

	TCP(String host, int port)

	{
		this.host = host;

		this.port = port;

		Thread t = new Thread(this);

		t.start();

	}

	JSONParser parser = new JSONParser();

	// -----------------------------------------------
	public String getState() {
		return state;
	}

	// ------------------------------------------------
	public void run() {
		try {

			Socket socket = new Socket(this.host, this.port);
			InputStream input = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);

//-------------------------------- new reader -------------------------------
			BufferedReader br = new BufferedReader(reader);
			String line = "";

			while ((line = br.readLine()) != null) {// read line by line
				// print what you received
				// System.out.println(line);
				// parse String to JSON
				JSONObject jsonObject = (JSONObject) parser.parse(line);
				JSONObject jsonObject1 = (JSONObject) parser.parse(line);
				JSONObject jsonObject2 = (JSONObject) parser.parse(line);
				JSONObject jsonObject3 = (JSONObject) parser.parse(line);

				JSONObject accObject = (JSONObject) jsonObject.get("accelerometer");
				JSONArray accValues = (JSONArray) accObject.get("value");
				double AccX = (double) accValues.get(0);
				double AccY = (double) accValues.get(1);// Melee

				JSONObject gyObject = (JSONObject) jsonObject1.get("gyroscope");
				JSONArray gyroValues = (JSONArray) gyObject.get("value");
				double GyroY = (double) gyroValues.get(1);
				double GyroZ = (double) gyroValues.get(2);// Climbing

				JSONObject lightObject = (JSONObject) jsonObject2.get("light");
				JSONArray lightValues = (JSONArray) lightObject.get("value");
				double Light = (double) lightValues.get(1);// healing

				JSONObject GravityObject = (JSONObject) jsonObject3.get("gravity");
				JSONArray GravityValues = (JSONArray) GravityObject.get("value");
				double GravityY = (double) GravityValues.get(1); // running

				if ((Math.abs(AccX) > 17) && ((Math.abs(AccY) > 17)))

				{
					System.out.println("Swinging motion detected! \\n\\n "); // use weapon
					state = "Melee";
				}

				else if ((Math.abs(GyroZ) > 5) && (Math.abs(GyroY) < 10)) {
					System.out.println("shaking/waving motion detected! \n\n"); // climbing

					state = "Climbing";
				}

				else if (Light <= 20.0) {
					System.out.println("Light Sensor Covered"); // using care package/healing

					state = "Healing";
				}
//			else
//			{
//				System.out.println("Light Sensor not covered"); 
//			}

				else if (GravityY > 8 && GravityY < 10) {
					System.out.println("Running");

					state = "Running";
				}

//			else if (GravityY < -8 && GravityY > -10) 
//			System.out.println("Climbing");

			}
//----------------------------------------------------------------------------

		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O error: " + ex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

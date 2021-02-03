package Multithreading;
/**
 * Nurse is an outside entity. She sets the values of the temperature ranges, responds to the alarms and puts the baby entity inside the isolette 
 */
public class Nurse extends User {

	/**
	 * Sets the desired minimum temperature
	 */
	float desiredmin = 98;

	/**
	 * Sets the desired maximum temperature
	 */
	float desiredmax = 99;

	/**
	 * Sets the alarm minimum temperature
	 */
	float alarmmin = 95;

	/**
	 * Sets the alarm maximum temperature
	 */
	float alarmmax = 101;

	/**
	 * Turns ON the thermostat via Display.
	 */
	boolean eventon = false;

	private Display display;
	
	
//	Nurse(){
//		this.alarmmax = alarmmax;
//		this.alarmmin = alarmmin;
//		this.desiredmax = desiredmax;
//		this.desiredmin = desiredmin;
//		this.eventon = eventon;
//	}
	
	public float getDmin() {
	
		return desiredmin;
	}

	public float getDmax() {
		return desiredmax;
	}

	public float getAmin() {
		return alarmmin;
	}

	public float getAmax() {
		return alarmmax;
	}

	public boolean getON() {
		return eventon;
	}

	

	public void setDmin(float dmin) {
		this.desiredmin = dmin;
	}

	public void setDmax(float dmax) {
		this.desiredmax = dmax;
	}

	public void setAmin(float almin) {
		this.alarmmin = almin;
	}

	public void setAmax(float almax) {
		this.alarmmax = almax;
	}

	public void setON(boolean onevent) {
		this.eventon = onevent;
	}

}

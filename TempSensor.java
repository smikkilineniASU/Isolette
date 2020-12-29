package Multithreading;
/**
 * Temperature Sensors is event enabled (by Clock). It senses the current temperature from the air and give it to the thermostat.
 */
public class TempSensor {

	/**
	 * Current temperature of the isolette
	 */

	private float currTemp;
	private boolean round = false;
	private boolean tempSensorStatus = true;
	Air air = new Air();
	HeatSource h1 = new HeatSource();
	Display d = new Display();
//	Thermostat t = new Thermostat();
//	float temp;
	/**
	 * senses the temperature
	 */

	TempSensor(){
//		this.round = false;
//		this.currTemp = 0;
//		this.tempSensorStatus = true;
	}

	public float getcurrTemp(Patient b, HeatSource h, Thermostat t) {
		if (round) {
			boolean r = t.babyStatus;
			boolean s = t.heatStatus;
			
			currTemp = air.gettemp(currTemp,h1.incrTemp(s),b1.bGradient(r));
			//System.out.println("hi" + currTemp);
			d.setCurrentTemp(currTemp);
			t.setcurrTemp(currTemp);
		}

		//seton the display screen and update thermostat 

		
		return currTemp;
	}
	public boolean getSensorStatus() {
		return tempSensorStatus;
	
	}
	
	
	/**
	 * retrieves event second from Clock
	 */
	public void setevent(boolean on,Baby b, HeatSource h, Thermostat t) {
		this.round= on;
		getcurrTemp(b,h,t);
		this.getSensorStatus() = y;
	
	}


	public void setroomtemp(float value) {
		this.currTemp = value;
		
	}
	//retrieve the temp amount
	
	

}
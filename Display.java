package Multithreading;

/**
 * The operator interface using which the nurse sets the value for the desired ranges and alarm ranges.
 */
public class Display {

	private float currentTemp = 97;

	/**
	 * Regulator status is set using this flag when the desired range entered by the nurse is wrong 
	 */
	private boolean tStatus = false;

	/**
	 * Monitor status is set using this when the alarm range entered by the nurse is wrong
	 */
	private boolean mStatus = false ;


	/**
	  * Defining the variables for min and max ranges
	 **/

	private float amin;

	private float amax;

	private float max_temp;

	private float min_temp;
	enum state{INIT,NORMALMODE,FAILUREMODE;}
	private state ThermostatMode = state.INIT;
	
	/**
	 * Displays the Mode of the thermostat
	 */
	
	Display(){
//		amin = 95;
//		amax = 101;
//		max_temp = 99;
//		min_temp = 98;
//		tStatus = false;
//		mStatus = false;
//		currentTemp = 0;
	}
//	
	public void setmode(Boolean m) {
		if(!m) {
			ThermostatMode = state.FAILUREMODE;
			
			System.out.println("Thermostat has failed " + ThermostatMode);
		}
		else {
			ThermostatMode = state.NORMALMODE;
			System.out.println("Thermostat is working " + ThermostatMode );
		}

	}

	/**
	 * Validates the inputs of the nurse
	 */
	public boolean[] setStatus(Nurse n) {
//		the min_temp must be within the range [97,99]
		amin = n.getAmin();
		amax =n.getAmax();
		min_temp = n.getDmin();
		max_temp = n.getDmax();

		
		if ( min_temp < 97 || min_temp > 99 ) {
			min_temp = 97;
//			setThermostatMode (" FAILURE ");
			System.out.println("Desired Minimum error,  default " + min_temp);
			tStatus = true;
		}
		
//		the max_temp must be within the range [98,100] and no less than the min_temp
		if ( max_temp < Math.max(min_temp + 1, 98) || max_temp > 100 ) {
			max_temp = 100;
//			setThermostatMode (" FAILURE ");
			System.out.println("Desired Maximum error, default " + max_temp);
			tStatus = true;
		} 
		
//		the amin must be within the range [93,98] and no more than min_temp
		if ( amin < 93 || amin > Math.min(98, min_temp - 1) ) {
			amin = 93;
//			setThermostatMode (" FAILURE ");
			System.out.println("Alarm Minimum error, default " + amin);
			mStatus = true;
		} 
		
//		the amax must be within the range [99,103] and no less than max_temp
		if ( amax < Math.max(max_temp + 1, 99) || amax > 103)  {
			amax = 103;
//			setThermostatMode (" FAILURE ");
			System.out.println("Alarm Maximum error, default " + amax);
			mStatus = true;
		}
		
//		setThermostatMode('Init');
//		System.out.println("Thermostat initialized to Init mode...");
//		if set executed correctly with valid values, returns true;
		boolean ar[] = new boolean[2];
		ar[0] = tStatus;
		ar[1] = mStatus;
		
		return ar;
		
//		if (tStatus || mStatus) {
//		return true;}
//		
//		else {
//			return false;
//			
//		}
	}

	/**
	 * Displays the temperatures ranges
	 */
	public void display() {
		System.out.println("Current Temperature is " + currentTemp);
		System.out.println("Desired range is: " + this.min_temp + " to " + this.max_temp + " F");
		System.out.println("Alarm range is: " + this.amin + " to " + this.amax + " F");
		//setMode(); // displays thermostat mode
	}

	

	public void setCurrentTemp(float currTemp) {
		this.currentTemp = currTemp;
		//System.out.println("Current Temperature is " + currentTemp);
		
		
	}

}

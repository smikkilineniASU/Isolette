package Multithreading;

/**
 * Thermostat interacts with the temperature sensor to know the current temperature and set the variables for heatsource and alarm
 */
public class Thermostat {

	/**
	 * Thermostat initially begins in the Normal mode but the mode changes when there is failure (internal , regualtor, monitor, display or invalid temperature inputs)
	 */
	private boolean mode = true;

	/**
	 * Status is changed when thermostat is working properly and the desired temperature is achieved to show that the nurse has put the baby inside the isolette
	 */
	boolean babyStatus  ;

	boolean heatStatus  ;

	private boolean alarmStatus ;
	private float currTemp  ;
	enum state{INIT,NORMAL,FAILURE;}
	/**
	 * Set when the desired temperatures put by the nurse are invalid
	 */
	private state regulatorStatus= state.INIT;

	/**
	 * Set when the alarm temperatures put by the nurse are invalid
	 */
	private state monitorStatus = state.INIT;
//	
//	HeatSource h = new HeatSource();
//	Baby b = new Baby();
	//TempSensor ts = new TempSensor(); 
	Nurse n = new Nurse();
	Alarm a = new Alarm();
	Thermostat(){
//		currTemp = 0;
//		babyStatus = false;
//		heatStatus = false;
//		alarmStatus = false;
	}

	/**
	 * Sets the thermostat mode
	 */
	public boolean setMode(Display d) {
	
	
		boolean m1 ;
		//= d.setStatus(n);

		boolean t = d.setStatus(n)[0];
		boolean m = d.setStatus(n)[1];
		//System.out.printf(t,m);
		if (t ) {regulatorStatus = state.FAILURE;
		System.out.printf("Regulator Status: " + regulatorStatus);
		System.out.println("");}
		else{regulatorStatus = state.NORMAL;
		System.out.printf("Regulator Status: " +  regulatorStatus);
		System.out.println("");}
		if (m ) {monitorStatus = state.FAILURE;
		System.out.printf("Monitor Status: " + monitorStatus);
		System.out.println("");}
		else {monitorStatus = state.NORMAL;
		System.out.printf("Monitor Status: " + monitorStatus);
		System.out.println("");}
		if (t||m ) {m1 = true;}
		else {m1 = false;}
		
		
		
		if(m1)
		{
			mode = false;
			alarmStatus = true;
			a.displayAlarm();
			if (babyStatus) {
				Baby b = new Baby(false);
				babyStatus = false;
				b.setbStatus(false);
				System.out.println(" Baby is removed ");
				
			}
			else {
				Baby b = new Baby(false);
				babyStatus = false;
				b.setbStatus(false);
				System.out.println(" Mode not safe for the Baby ");
				
			}
			d.setmode(mode);

		}
		else 
		{
			mode = true;
			d.setmode(mode);
		}

		return mode;

	}

	/**
	 * set the alarm and heat source status to be turned ON or OFF.
	 * @param nurse 
	 * @param t 
	 */
	
	public void setHeatSource(Nurse n) {
		if (mode) {
		if(currTemp < n.getDmin())
		{
			if(heatStatus) {
				heatStatus = true;
				HeatSource h = new HeatSource(true);
				h.setheatStatus(true);
				System.out.println (" Heat Source is still ON");
			}
			else {			
				heatStatus = true;
				HeatSource h = new HeatSource(true);
				h.setheatStatus(true);
				System.out.println (" Heat Source is turned ON");}

			
		}
		if(currTemp > n.getDmax())
		{
			if(heatStatus) {		
				heatStatus = false;
				HeatSource h = new HeatSource(false);
				h.setheatStatus(false);
				System.out.println (" Heat Source is turned OFF");
				}
			else {
				heatStatus = false;
				HeatSource h = new HeatSource(false);
				h.setheatStatus(false);
				System.out.println (" Heat Source is OFF");
				}
			
		}
		}
		else {
			System.out.println("Regulator Failure has occured");
			System.exit(0);

			
		}

	}

	public void setStatuses( Nurse n ) {
		
		System.out.println(" ------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Display Temperature is " + Math.round(currTemp));
		System.out.println("Current Temperature is " + currTemp);
		//System.out.println(mode);	
		
		if(mode)
		{
			if(currTemp >= n.getDmin() && currTemp <= n.getDmax()) {
				
				if (!babyStatus) {
					Baby b = new Baby(true);
					babyStatus = true;
					b.setbStatus(true);
					System.out.println(" Put Baby inside ");
				}
				else {
					Baby b = new Baby(true);
					babyStatus = true;
					b.setbStatus(true);
					System.out.println(" Baby is still inside ");
				}
			} 
			if(((currTemp - 0.5 )> n.getAmax()) || ((currTemp + 0.5) < n.getAmin()))
			{
				alarmStatus = true;
//				System.out.println(" ALARM  2");
				a.displayAlarm();
				if (alarmStatus) {
				if (babyStatus) {
					Baby b = new Baby(false);
					babyStatus = false;
					b.setbStatus(false);
					System.out.println(" Baby is removed ");
					
				}
				else {
					Baby b = new Baby(false);
					babyStatus = false;
					b.setbStatus(false);
					System.out.println(" Temperature still not safe for the Baby ");
					
				}
				
			}
			}
			if((( currTemp - 0.5 ) <= n.getAmax()) && ((currTemp + 0.5 )>= n.getAmin()))
			{
				
				if(alarmStatus) {
					alarmStatus = false;
					System.out.println(" Alarm is turned OFF ");
					
				}
				else{alarmStatus = false;}

			}
		}
		
		else {
			System.out.println("Monitor / Internal Failure has occured");
			System.exit(0);

			
		}
	}

	public void setcurrTemp(float currTemp) {
		this.currTemp = currTemp;
		
		
	}

}

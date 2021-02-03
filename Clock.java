package Multithreading;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Clock provides with the even boolean which triggers the temperature sensors to get the current temperautre every second. 
 */
public class Clock {

	/**
	 * For triggering the temperature sensor
	 */
	
	private boolean eventsecond;
	private boolean on = false;
	/**
	 * This method sets the event variable whenever the isolette is turned ON by the Nurse.
	 */
	
	TempSensor ts ;
	Thermostat t ;
	Nurse n;
	public Clock(boolean onevent,TempSensor ts, Thermostat t, Nurse n,Patient b, HeatSource h)  {
		this.ts= ts;
		this.t = t;
		this.n=n;
		this.on = onevent;
		Timer timer = new Timer();
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		if (on) {


		timer.schedule( new TimerTask() {
		    public void run() {
		       setevent(on);
		       exec.schedule(new Runnable() {
		            public void run() {
		            	 t.setStatuses(n);
		            }
		        }, 1, TimeUnit.SECONDS);

		        exec.schedule(new Runnable() {
		            public void run() {
		                t.setHeatSource(n);
		            }
		        }, 1, TimeUnit.SECONDS);
		        exec.schedule(new Runnable() {
		            public void run() {
		                ts.setevent(on,b,h,t);
		            }
		        }, 2, TimeUnit.SECONDS);
//		       t.setStatuses(n);
//		       t.setHeatSource(n);
		      // ts.setevent(on,b,h,t);

//		       System.out.println(getevent());
		       
		    }
		 }, 0, 6*1000);
	}
		else {
			setevent(on);
			ts.setevent(on,b,h,t);
			timer.cancel();
			System.exit(0);
//			System.out.println(getevent());
		}
	}
	
	
	public void setevent(Boolean on) {
		this.eventsecond = on;
		
	}

}
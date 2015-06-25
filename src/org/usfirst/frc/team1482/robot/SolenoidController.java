package org.usfirst.frc.team1482.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class SolenoidController {
	Solenoid extend;
	Solenoid retract;
	boolean extended = false;
	public SolenoidController(int extendChannel, int retractChannel){
		extend = new Solenoid(extendChannel);
		retract = new Solenoid(retractChannel);
	}
	public void extend(){
		extend.set(true);
		retract.set(false);
		extended = true;
	}
	public void retract(){
		extend.set(false);
		retract.set(true);
		extended = false;
	}
	public boolean isExtended(){
		return extended;
	}
	public void setState(boolean state){
		extend.set(state);
		retract.set(!state);
	}
}

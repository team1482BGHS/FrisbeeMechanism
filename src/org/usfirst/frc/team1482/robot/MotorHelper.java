package org.usfirst.frc.team1482.robot;

import edu.wpi.first.wpilibj.hal.CanTalonSRX;

public class MotorHelper {
	CanTalonSRX motor;
	boolean state = false;
	double speed = -1;
	public MotorHelper(int motorPort){
		motor = new CanTalonSRX(motorPort);
		
	}
	public void toggle(){
		if(state){
			motor.Set(0);
			state = false;
			
		}
		else{
			motor.Set(speed);
			state = true; 
		}
	}
	public void setSpeed(double newSpeed){
		speed = newSpeed;
	}
}

package org.usfirst.frc.team1482.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * direct
 */
public class Robot extends IterativeRobot {
	CanTalonSRXPrime frontLeft;
	CanTalonSRXPrime frontRight;
	CanTalonSRXPrime backRight;
	CanTalonSRXPrime backLeft;
	RobotDrive drive;
	Joystick joystick;
	SolenoidController shooter;
	MotorHelper shooterMotor;
	public void robotInit() {
		frontLeft = new CanTalonSRXPrime(3);
		frontRight = new CanTalonSRXPrime(4);
		backRight = new CanTalonSRXPrime(5);
		backLeft = new CanTalonSRXPrime(2);
		drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		joystick = new Joystick(0);
		shooter = new SolenoidController(0 , 1);
		shooterMotor = new MotorHelper(1);
	}

	public void autonomousPeriodic() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	boolean state = false;
	public void teleopPeriodic() {
		double xAxis = -joystick.getRawAxis(0); //Forward
		double yAxis = -joystick.getRawAxis(1); //Sideways 
		double leftTrigger = joystick.getRawAxis(2); 
		double rightTrigger = joystick.getRawAxis(3);
		double strafe = 0;
		if(rightTrigger > leftTrigger){
			strafe = -rightTrigger; 
		}else{
			strafe = leftTrigger;
		}
		xAxis = Math.pow(xAxis, 3);
		yAxis = Math.pow(yAxis, 3);
		drive.mecanumDrive_Cartesian(strafe, xAxis, yAxis, 0);
		shooter.setState(joystick.getRawButton(6));
		boolean button = joystick.getRawButton(4);
		if(!state && button){
			shooterMotor.toggle();
			state = true;
		}
		if(state && !button){
			state = false;
		}
	}
	
		
		 

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}

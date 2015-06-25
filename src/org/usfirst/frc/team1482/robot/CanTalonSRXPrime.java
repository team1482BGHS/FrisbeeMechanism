package org.usfirst.frc.team1482.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;

public class CanTalonSRXPrime extends CanTalonSRX implements SpeedController {

	public CanTalonSRXPrime(int channel) {
		super(channel);
	}
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		System.err.println("Unimplemted Method!!");

	}

	@Override
	public double get() {
		// TODO Auto-generated method stub
		System.err.println("Unimplemted Method!!");
		return 0;
	}

	@Override
	public void set(double speed, byte syncGroup) {
		Set(speed);

	}

	@Override
	public void set(double speed) {
		Set(speed);

	}

	@Override
	public void disable() {
		System.err.println("Unimplemted Method!!");
		// TODO Auto-generated method stub

	}

}

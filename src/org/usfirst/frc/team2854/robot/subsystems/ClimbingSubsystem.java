package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author deven.navani
 */
public class ClimbingSubsystem extends Subsystem {

	private SpeedController winch1;
	private SpeedController winch2;
	private SpeedController windowMotor1;

	public ClimbingSubsystem(SpeedController w1, SpeedController w2, SpeedController wM1) {

		winch1 = w1;
		winch2 = w2;
		windowMotor1 = wM1;
	}

	public void stop() {
		winch1.set(0);
		winch2.set(0);
		windowMotor1.set(0);
	}

	public void turn() {
		windowMotor1.set(0.5);
	}

	public void pull() {
		winch1.set(0.5);
		winch2.set(0.5);
	}

	public void release() {
		winch1.set(-0.5);
		winch2.set(-0.5);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {

	}

}

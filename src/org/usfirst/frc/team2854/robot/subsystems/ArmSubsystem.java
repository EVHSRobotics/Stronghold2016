package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author deven.navani
 */
public class ArmSubsystem extends Subsystem {

	SpeedController armMotor;

	public ArmSubsystem(SpeedController aMotor) {
		armMotor = aMotor;
	}

	public void armUp() {
		armMotor.set(0.5);
	}

	public void armDown() {
		armMotor.set(-0.5);
	}

	public void armStop() {
		armMotor.set(0);
	}

	protected void initDefaultCommand() {
	}
}
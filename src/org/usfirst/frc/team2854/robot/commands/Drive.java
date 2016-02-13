package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Axis;
import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

	private DriveTrain driveTrain;
	private Axis leftAxis;
	private Axis leftTrigger;
	private Axis rightTrigger;
	private Button directionButton;

	private int direction;

	public Drive(DriveTrain aDriveTrain, Axis aleft, Axis lTrig, Axis rTrig,
			Button buttonDirection) {
		leftAxis = aleft;
		leftTrigger = lTrig;
		rightTrigger = rTrig;
		driveTrain = aDriveTrain;
		directionButton = buttonDirection;

		direction = -1;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(driveTrain);
	}

	boolean pressed = false;

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		if (directionButton.get() && !pressed) {
			direction *= -1;
			pressed = true;
		} else if (!directionButton.get()) {
			pressed = false;
		}

		double aku = leftAxis.deadbandGet();

		/* if (Math.abs(aku)>.9){
		aku = Math.round(aku);
		System.out.println("nitros activated");
}
		*/ 

		double left = Math.pow(aku, 3) * direction;
		double right = left;
		double trigger = Math.pow(rightTrigger.deadbandGet(), 3)
				- Math.pow(leftTrigger.deadbandGet(), 3);
		left -= trigger;
		right += trigger;

		driveTrain.tankDrive(left, right);
		// Cubed for smoother driving
		System.out.println("Left: " + left + " Right: " + right);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		driveTrain.stop();
	}
}

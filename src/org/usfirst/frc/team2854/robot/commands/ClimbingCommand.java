package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.ClimbingSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author deven.navani
 */
public class ClimbingCommand extends Command {

	private ClimbingSubsystem climbingSubsystem;
	private Button lb; //climb
	private Button rb; //turn
	private Boolean toggle; // should start off false

	public ClimbingCommand(ClimbingSubsystem aCS, Button aClimb, Button aTurn, Boolean t) {
		climbingSubsystem = aCS;
		lb = aClimb;
		rb = aTurn;
		toggle = t;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(climbingSubsystem);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (rb.get()) {
			climbingSubsystem.turn();
		}
		if (lb.get()) {
			if (toggle == false) {
				climbingSubsystem.pull();
				toggle = true;
			} else {
				climbingSubsystem.release();
				toggle = false;
			}
		} else {
			climbingSubsystem.stop();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		climbingSubsystem.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		climbingSubsystem.stop();
	}
}
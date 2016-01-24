package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.ArmSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author deven.navani
 */
public class ArmCommand extends Command {

	private ArmSubsystem armSubsystem;
	private Button a; //swing
	private boolean toggle; // should start off false

	public ArmCommand(ArmSubsystem aAS, Button aSwing, Boolean t) {
		armSubsystem = aAS;
		a = aSwing;
		toggle = t;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(armSubsystem);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (a.get()) {
			if (toggle == false) {
				armSubsystem.armUp();
				toggle = true;
			} else {
				armSubsystem.armDown();
				toggle = false;
			}
		} else {
			armSubsystem.armStop();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		armSubsystem.armStop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		armSubsystem.armStop();
	}
}
package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.subsystems.BreachSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DropBreach extends Command {
	BreachSystem breachSystem;
    public DropBreach(BreachSystem bSys) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	breachSystem = bSys;

    	requires(breachSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	breachSystem.moveArm(.8);
    	Timer.delay(.5);
    	breachSystem.moveArm(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	breachSystem.moveArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	breachSystem.moveArm(0);
    }
}

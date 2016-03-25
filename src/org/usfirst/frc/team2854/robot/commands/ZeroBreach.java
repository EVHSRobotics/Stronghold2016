package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.subsystems.PIDBreachSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroBreach extends Command {
	PIDBreachSystem breachSystem;
    public ZeroBreach(PIDBreachSystem bSys) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(breachSystem);
    	breachSystem = bSys;
    	breachSystem.setCounterStart();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	breachSystem.moveArm(-.6);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return breachSystem.counterSame();
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

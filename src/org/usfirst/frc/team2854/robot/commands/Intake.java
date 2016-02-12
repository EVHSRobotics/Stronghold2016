package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {
	private IntakeSystem intakeSystem;
	private Button buttonX; //out
	private Button buttonA; //in
    public Intake(IntakeSystem intake, Button abuttonA, Button abuttonX) {
    	intakeSystem = intake;
    	buttonA = abuttonA;
    	buttonX = abuttonX;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	requires(intakeSystem); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(buttonA.get()){
    		intakeSystem.roll(1);
    	} else if(buttonX.get()) {
    		intakeSystem.roll(-1);
    	} else {
    		intakeSystem.roll(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	intakeSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	intakeSystem.stop();
    }
}

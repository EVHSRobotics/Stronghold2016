package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Axis;
import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {
	private IntakeSystem intakeSystem;
	private Axis lt;
	private Axis rt;
	private Button x; //in
	private Button b; //out
    public Intake(IntakeSystem intake, Axis alt, Axis art, Button ax, Button ab) {
    	lt = alt;
    	rt = art;
    	intakeSystem = intake;
    	x = ax;
    	b = ab;
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	requires(intakeSystem); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	intakeSystem.roll(rt.deadbandGet()-lt.deadbandGet());
    	if (x.get() == true){
    		intakeSystem.boardSet(1);
    	}
    	else if (b.get() == true) {
    		intakeSystem.boardSet(-1);
    	}
    	else{
    		intakeSystem.boardSet(0);
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

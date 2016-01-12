package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.OI.OIMap;
import org.usfirst.frc.team2854.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {
	private int joystickId;
	private int RT;
	private int LT;
    public Intake(int aJoystickId, int aRT, int aLT) {
    	requires(Robot.intakeSystem); 
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	joystickId = aJoystickId;
    	RT = aRT;
    	LT = aLT;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int RT = (int) (Robot.oi.getAxis(joystickId, OIMap.Axis.RT));
    	int LT = (int) (Robot.oi.getAxis(joystickId, OIMap.Axis.LT));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

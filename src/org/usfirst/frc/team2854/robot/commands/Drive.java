package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Axis;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {
	
	private DriveTrain driveTrain;
	private Axis leftAxis;
	private Axis rightAxis;
	
	
    public Drive(DriveTrain aDriveTrain, Axis aleft, Axis aright) {
    	
    	leftAxis = aleft;
    	rightAxis = aright;
    	driveTrain = aDriveTrain;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.tankDrive(leftAxis.deadbandGet(), rightAxis.deadbandGet());
    	System.out.println(leftAxis.deadbandGet());
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

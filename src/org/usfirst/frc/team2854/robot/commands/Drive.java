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
	private Axis rightAxis;
	private Axis leftTrigger;
	private Axis rightTrigger;
	private Button y;
	private Button a;
	
    public Drive(DriveTrain aDriveTrain, Axis aleft, Axis aright, Axis lTrig, Axis rTrig, Button ay, Button aa) {
    	
    	leftAxis = aleft;
    	rightAxis = aright;
    	leftTrigger = lTrig;
    	rightTrigger = rTrig;
    	driveTrain = aDriveTrain;
    	y = ay;
    	a= aa;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double left = Math.pow(leftAxis.deadbandGet(), 3);
    	double right = left;
    	double trigger = Math.pow(rightTrigger.deadbandGet(), 3) - Math.pow(leftTrigger.deadbandGet(), 3);
    	left -= trigger;
    	right += trigger;
    	driveTrain.tankDrive(left, right);
    	//Cubed for smoother driving
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

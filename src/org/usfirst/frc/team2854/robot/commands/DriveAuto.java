package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAuto extends Command {
	
	private DriveTrain driveTrain;
	private double leftDist;
	private double rightDist;
	private double rightStart;
	private double leftStart;
    public DriveAuto(DriveTrain dTrain, double lDist, double rDist) {
		leftDist = lDist;
		rightDist = rDist;
		driveTrain = dTrain;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis)
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	leftStart = driveTrain.getLeftEnc();
    	rightStart = driveTrain.getRightEnc();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(driveTrain.getLeftEnc() - leftStart < leftDist){
    		driveTrain.moveLeft(.8);
    	}else{
    		driveTrain.moveLeft(0);
    	}
    	if(driveTrain.getRightEnc() - rightStart< rightDist){
    		driveTrain.moveRight(.8);
    	}else{
    		driveTrain.moveRight(0);
    	}
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

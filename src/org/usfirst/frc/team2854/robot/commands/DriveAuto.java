package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAuto extends Command {
	
	private DriveTrain driveTrain;

    public DriveAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis)
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.tankDrive(.75, .75);;
    	Timer.delay(5); //change later with encoders?
    	driveTrain.stop();
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
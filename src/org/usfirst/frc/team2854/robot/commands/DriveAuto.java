package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveAuto extends Command {
	DriveTrain driveTrain;
	Encoder encoder;
	int t = 10;

	public DriveAuto(DriveTrain adriveTrain) {
    	driveTrain = adriveTrain;
    	requires(driveTrain);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis)
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	encoder = new Encoder(1,2, true, Encoder.EncodingType.k4X);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.driveStraight(.75);
    	SmartDashboard.putNumber("Print", t++);
    	SmartDashboard.putNumber("Encoder Value", encoder.getRaw());
    	Timer.delay(2); //change later with encoders?
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

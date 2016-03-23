package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.RMap;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveAuto extends Command {
	int x = 10;
	DriveTrain driveTrain;	
    public DriveAuto(DriveTrain adriveTrain) {
    	driveTrain = adriveTrain;
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis)
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RMap.motor1.set(1);
    	SmartDashboard.putNumber("PRINT", x++);
    	driveTrain.driveStraight(1);
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

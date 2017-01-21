package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2854.robot.subsystems.PIDBreachSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto extends Command {
	
	private DriveTrain driveTrain;
	private double startTime = -1;
	private double driveTime; //this should be in seconds
	private PIDBreachSystem breachSystem;
	
    public Auto(double aDriveTime, PIDBreachSystem aBreachSystem) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis)
    	driveTime = aDriveTime;
    	breachSystem = aBreachSystem;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    	requires(driveTrain);
    	startTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Math.abs(Timer.getFPGATimestamp() - startTime) < driveTime){
    		driveTrain.tankDrive(.75, .75);
        	//change later with encoders?
    	} else {
    		breachSystem.goTo(PIDBreachSystem.BOT_SETPOINT);
    		end();
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

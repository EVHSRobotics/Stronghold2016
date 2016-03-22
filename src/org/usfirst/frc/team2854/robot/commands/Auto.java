package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2854.robot.subsystems.PIDBreachSystem;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto extends Command {
	
	private Encoder encoder;
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
    	encoder = new Encoder(8,9, true, EncodingType.k4X);
    	encoder.reset();
    	//startTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	double startPoint = encoder.getRaw();
    	driveTrain.tankDrive(.75);
    	if (encoder.getRaw() - startPoint>500){
    		driveTrain.stop();
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

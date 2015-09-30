package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Lift extends Command {
	Encoder encoder;
	private int joystickID;
	private int rb;
	private int lb;

    public Lift(int ajoystickID, int arb, int alb) {
    	requires(Robot.liftSystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	joystickID = ajoystickID;
    	rb = arb;
    	lb = alb;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	encoder = new Encoder(3,4, true, EncodingType.k4X);
    	encoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(encoder.get());
    	if (Robot.oi.getButton(joystickID, rb)){
    		Robot.liftSystem.up();	
    	}
    	else if (Robot.oi.getButton(joystickID, lb)){
    		Robot.liftSystem.down();
    	}
    	else {
    		Robot.liftSystem.stop();
    	}
    	
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

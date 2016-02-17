package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Axis;
import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.BreachSystem;
import org.usfirst.frc.team2854.robot.subsystems.PIDBreachSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Breach extends Command {

//	private BreachSystem breachSystem; should toggle between these two 
	private PIDBreachSystem breachSystem;
	private Axis liftAxis;
	private Button resetButton;
	private Button botButton;
	private Button topButton;
	
	//toggle me
//    public Breach(BreachSystem aBreachSystem, Axis aLiftAxis, Button aResetButton, Button aBottomButton, Button aTopButton) {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    	breachSystem = aBreachSystem;
//    	liftAxis = aLiftAxis;
//    	resetButton = aResetButton;
//    }
    public Breach(PIDBreachSystem aBreachSystem, Axis aLiftAxis, Button aResetButton, Button aBottomButton, Button aTopButton) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	breachSystem = aBreachSystem;
    	liftAxis = aLiftAxis;
    	resetButton = aResetButton;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	requires(breachSystem);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!breachSystem.getPIDEnabled()){
    		breachSystem.raise(piecewise(liftAxis.deadbandGet()));
    	}else{
        	System.out.println("breach encoder: " + breachSystem.encoderGet());
        	if(resetButton.getHold()){
        		breachSystem.resetEncoder();
        		System.out.println("ENCODER RESET");
        	}
        	if(botButton.getHold()){
        		breachSystem.goTo(PIDBreachSystem.BOT_SETPOINT);
        		System.out.println("MOVE BOT");
        	}else if(topButton.getHold()){
        		System.out.println("MOVE TOP");
        		breachSystem.goTo(PIDBreachSystem.TOP_SETPOINT);
        	}
    	}
    	
    }

    private double piecewise(double in){
		double val = 0;
		if(in > 0){
			val = Math.min(in, 4*in*in*in);
		} else {
			val = Math.max(in,  4*in*in*in);
		}
		return val;
	}
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	breachSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	breachSystem.stop();
    }
}

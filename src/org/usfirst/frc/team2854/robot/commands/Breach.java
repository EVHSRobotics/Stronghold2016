package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Axis;
import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.BreachSystem;
import org.usfirst.frc.team2854.robot.subsystems.Breaching;
import org.usfirst.frc.team2854.robot.subsystems.PIDBreachSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Breach extends Command {
 
	private Breaching breachSystem;
	private Axis liftAxis;
	private Button resetButton;
	private Button botButton;
	private Button midButton;
	private Button topButton;
	private Button switchButton;
	
	//toggle me
    public Breach(Breaching aBreachSystem, Axis aLiftAxis, Button aResetButton, Button aBottomButton, Button aMidButton,
    		Button aTopButton, Button aSwitchButton) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	breachSystem = aBreachSystem;
    	liftAxis = aLiftAxis;
    	resetButton = aResetButton;
    	resetButton = aResetButton;
    	botButton = aBottomButton;
    	midButton = aMidButton;
    	topButton = aTopButton;
    	switchButton = aSwitchButton;
    	requires((Subsystem)breachSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	requires((Subsystem) breachSystem);
//    	((BreachSystem)breachSystem).initDefaultPID();
//    	((PIDBreachSystem)breachSystem).enableZeroing(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

		((BreachSystem)breachSystem).moveArm(piecewise(liftAxis.deadbandGet()));
//    	if(((PIDBreachSystem)breachSystem).isZeroing()){
//    		System.out.println("ZEROING");
//    		if(resetButton.getHold()){ //manual breakout, but do not reset encoder
//    			((PIDBreachSystem)breachSystem).moveArm(0);
//    			((PIDBreachSystem)breachSystem).enableZeroing(false);
//    		}else if(((PIDBreachSystem)breachSystem).counterSame()){
//        		((PIDBreachSystem)breachSystem).moveArm(-.6);
//    		}else{ //hall effect has been tripped, counter vals are now different
//    			((PIDBreachSystem)breachSystem).moveArm(0);
//    			((PIDBreachSystem)breachSystem).enableZeroing(false);
//    			((PIDBreachSystem)breachSystem).resetEncoder();
//    		}
//    	}else{
//        	if(switchButton.getHold()){
//        		if(((PIDBreachSystem)breachSystem).getPIDEnabled()){
//            		((PIDBreachSystem)breachSystem).disablePID();
//            		((PIDBreachSystem)breachSystem).changeDefaultPID(false);
//        		}else{
//        			((PIDBreachSystem)breachSystem).enablePID();
//        			((PIDBreachSystem)breachSystem).changeDefaultPID(true);
//        		}
//        	}
//        	if(resetButton.getHold() && (breachSystem.encoderGet() >= 0)){ //only works (hopefully) if arm is ahead of magnet
//        		((PIDBreachSystem)breachSystem).enableZeroing(true);
//        		System.out.println("ENCODER RESET");
//        	}
//        	if(!((PIDBreachSystem)breachSystem).getPIDEnabled()){
//        		((PIDBreachSystem)breachSystem).moveArm(piecewise(liftAxis.deadbandGet()));
//        	}else{ //PID is enabled
//            	System.out.println("breach encoder: " + ((PIDBreachSystem)breachSystem).encoderGet());
//            	if(botButton.getHold()){
//            		((PIDBreachSystem)breachSystem).goTo(PIDBreachSystem.BOT_SETPOINT);
//            		System.out.println("MOVE BOT");
//            	}else if(midButton.getHold()){
//            		((PIDBreachSystem)breachSystem).goTo(PIDBreachSystem.MID_SETPOINT);
//            	}else if(topButton.getHold()){
//            		System.out.println("MOVE TOP");
//            		((PIDBreachSystem)breachSystem).goTo(PIDBreachSystem.TOP_SETPOINT);
//            	}
//        	}

//        	SmartDashboard.putBoolean("PID ENABLED", ((PIDBreachSystem)breachSystem).getPIDEnabled());
//    	}
        	
        	
//    	double liftspeed = liftAxis.deadbandGet();
//    	breachSystem.moveArm(liftspeed);
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

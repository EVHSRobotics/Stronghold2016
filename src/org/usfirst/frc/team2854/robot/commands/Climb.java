package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Axis;
import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.ClimbSystem;
import org.usfirst.frc.team2854.robot.subsystems.PIDClimbSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Climb extends Command {

//	private ClimbSystem climbSystem; should toggle between these two 
	private ClimbSystem climbSystem;
	private Axis liftAxis;
	private Axis winchAxis;
	private Button resetButton;
	private Button botButton;
	private Button topButton;
	private Button switchButton;
	
	//toggle me
    public Climb(ClimbSystem aclimbSystem, Axis aLiftAxis, Axis aWinchAxis) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	climbSystem = aclimbSystem;
    	liftAxis = aLiftAxis;
    	winchAxis = aWinchAxis;
    }
//    public Climb(ClimbSystem aClimbSystem, Axis aLiftAxis, Axis aWinchAxis, Button aResetButton, Button aBottomButton, 
//    		Button aTopButton, Button aSwitchButton) {
//        // Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    	climbSystem = aClimbSystem;
//    	liftAxis = aLiftAxis;
//    	winchAxis = aWinchAxis;
//    	resetButton = aResetButton;
//    	resetButton = aResetButton;
//    	botButton = aBottomButton;
//    	topButton = aTopButton;
//    	switchButton = aSwitchButton;
//    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	requires(climbSystem);
//    	climbSystem.enableZeroing(true);
    }

    // Called repeatedly when this Command is scheduled to run 
    protected void execute() {
//    	if(climbSystem.isZeroing()){
//    		System.out.println("ZEROING");
//    		if(climbSystem.counterSame()){
//        		climbSystem.moveArm(-.5);
//    		}else{ //hall effect has been tripped
//    			climbSystem.incrementCounter();
//    			climbSystem.moveArm(0);
//    			climbSystem.enableZeroing(false);
//    		}
//    	}else{
//        	if(switchButton.getHold()){
//        		if(climbSystem.getPIDEnabled()){
//            		climbSystem.disablePID();
//        		}else{
//        			climbSystem.enablePID();
//        		}
//        	}
//        	if(resetButton.getHold()){
//        		climbSystem.enableZeroing(true);
//        		System.out.println("ENCODER RESET");
//        	}
//        	if(!climbSystem.getPIDEnabled()){
//        		climbSystem.moveArm(piecewise(liftAxis.deadbandGet()));
//        	}else{ //PID is enabled
//            	System.out.println("climb encoder: " + climbSystem.encoderGet());
//            	if(botButton.getHold()){
//            		climbSystem.goTo(PIDClimbSystem.BOT_SETPOINT);
//            		System.out.println("MOVE BOT");
//            	}else if(topButton.getHold()){
//            		System.out.println("MOVE TOP");
//            		climbSystem.goTo(PIDClimbSystem.TOP_SETPOINT);
//            	}
//        	}
//    	}
    	double winchSpeed = winchAxis.deadbandGet();
    	SmartDashboard.putNumber("WINCH", winchAxis.deadbandGet());
//    	if(Math.abs(winchSpeed) > 0){
//    		climbSystem.moveWinch(winchSpeed);
//    	}else{
//    		climbSystem.moveWinch(0);
//    	}
    	climbSystem.moveWinch(winchSpeed);
    	double liftSpeed = liftAxis.deadbandGet();
    	climbSystem.moveArm(liftSpeed);
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
    	climbSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	climbSystem.stop();
    }
}

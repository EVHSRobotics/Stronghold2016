package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Axis;
import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2854.robot.subsystems.PIDBreachSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive extends Command {

	private DriveTrain driveTrain;
	private Axis leftAxis;
	private Axis leftTrigger;
	private Axis rightTrigger;
	private Button directionButton;
	private Button pidButton;

	private int direction;

	public Drive(DriveTrain aDriveTrain, Axis aleft, Axis lTrig, Axis rTrig,
			Button buttonDirection, Button pidSwitch) {
		leftAxis = aleft;
		leftTrigger = lTrig;
		rightTrigger = rTrig;
		driveTrain = aDriveTrain;
		directionButton = buttonDirection;
		pidButton = pidSwitch;

		direction = 1;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(driveTrain);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (directionButton.getHold()) {
			direction *= -1;
		}
//		
//		if(pidButton.getHold()){
//    		if(driveTrain.getPIDEnabled()){
//        		driveTrain.disablePID();
//        		driveTrain.changeDefaultPID(false);
//    		}else{
//    			driveTrain.enablePID();
//    			driveTrain.changeDefaultPID(true);
//    		}
//		}

		
		/* if (Math.abs(aku)>.9){
			aku = Math.round(aku);
			System.out.println("nitros activated");
		}
		*/ 
		double trigger = piecewise(leftTrigger.deadbandGet()-rightTrigger.deadbandGet());
		
		double left = trigger;
		double right = left;
		double aku = leftAxis.deadbandGet(); //goes left and right
		
		left -= aku;
		right += aku;
//		double left = piecewise(aku) * direction;
//		double right = left;
//		left -= trigger;
//		right += trigger;
		
//		double trigger = Math.pow(rightTrigger.deadbandGet(), 3)
//				- Math.pow(leftTrigger.deadbandGet(), 3);
		
		left = roundBounds(left);
		right = roundBounds(right);
		
		driveTrain.tankDrive(left, right);
		SmartDashboard.putNumber("LEFT DRIVE", left);
		SmartDashboard.putNumber("RIGHT DRIVE", right);
//		driveTrain.pidDrive(left, right);
//		SmartDashboard.putBoolean("DRIVE PID ENABLED", driveTrain.getPIDEnabled());
		SmartDashboard.putNumber("leftDriveEnc", driveTrain.getLeftEnc());
		SmartDashboard.putNumber("rightDriveEnc", driveTrain.getRightEnc());
		SmartDashboard.putNumber("left speed", driveTrain.getLeftSpeed());
		SmartDashboard.putNumber("right speed", driveTrain.getRightSpeed());
//		 Cubed for smoother driving
//		System.out.println("Left: " + left + " Right: " + right);
	}
	
	private double sigmoid(double in){
		double val = 1/(0.96034 + 16*Math.pow(Math.E, -6*Math.abs(in)))*Math.signum(in);
		return val;
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
	private double roundBounds(double in){
		if(Math.abs(in) < .15){
			return 0;
		}else if(Math.abs(in) > .85){
			return Math.signum(in);
		}
		return in;
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
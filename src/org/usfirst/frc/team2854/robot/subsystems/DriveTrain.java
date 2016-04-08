package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	private SpeedController fl;
	private SpeedController fr;
	private SpeedController bl;
	private SpeedController br;
//	private MotorSide leftMotors;
//	private MotorSide rightMotors;
	
	private Encoder leftEnc;
	private Encoder rightEnc;
	private PIDController pidMoveLeft;
	private PIDController pidMoveRight;
	private boolean PIDEnabled = true;
	private boolean defaultPID = true; //turns it on or off on start
	
	private final double P_VAL = .0005;
	private final double I_VAL = 0;
	private final double D_VAL = 0;
	
	public DriveTrain(SpeedController frontleft, SpeedController backleft, SpeedController frontright, SpeedController backright, Encoder aLeftE, Encoder aRightE){
//		leftMotors = new MotorSide(frontleft,backleft, "LEFT DRIVE", 1);
//		rightMotors = new MotorSide(frontright,backright, "RIGHT DRIVE", 1);
//		
		leftEnc = aLeftE;
		rightEnc = aRightE;
//		pidMoveLeft = new PIDController(P_VAL, I_VAL, D_VAL, leftEnc, leftMotors);
//		pidMoveRight = new PIDController(P_VAL, I_VAL, D_VAL, rightEnc, rightMotors);
//		
//		initPID();
		fl = frontleft;
		fr = frontright;
		bl = backleft;
		br = backright;
		leftEnc.reset();
		rightEnc.reset();
	}
	
//	public void initPID(){
//		if(defaultPID){
//			enablePID();
//		}else{
//			disablePID();
//		}
//	}
//	
//	public void changeDefaultPID(boolean b){
//		defaultPID = b;
//	}
//	
//	public void enablePID(){
//		PIDEnabled = true;
//		pidMoveLeft.enable();
//		pidMoveRight.enable();
//	}
//	public void disablePID(){
//		PIDEnabled = false;
//		pidMoveLeft.disable();
//		pidMoveRight.disable();
//	}
	public double getLeftEnc(){
		return leftEnc.get();
	}
	
	public double getRightEnc(){
		return rightEnc.get();
	}
	
	public double getLeftSpeed(){
		return fl.get();
	}
	public double getRightSpeed(){
		return fr.get();
	}
//	public boolean getPIDEnabled(){
//		return PIDEnabled;
//	}
//	
//	private double adjustVal = 2000; //converts target voltage to target encoder rate
//	
//	public void pidDrive(double leftSpeed, double rightSpeed){
//		pidMoveLeft.setSetpoint(leftSpeed*adjustVal);
//		pidMoveRight.setSetpoint(rightSpeed*adjustVal);
//		SmartDashboard.putNumber("LEFT PID SETPOINT", pidMoveLeft.getSetpoint());
//		SmartDashboard.putNumber("RIGHT PID SETPOINT", pidMoveRight.getSetpoint());
//		SmartDashboard.putNumber("CURRENT LEFT ERR", pidMoveLeft.getError());
//		SmartDashboard.putNumber("CURRENT RIGHT ERR", pidMoveRight.getError());
//		SmartDashboard.putBoolean("LEFT PID ENABLED", pidMoveLeft.isEnabled());
//		
//	}
	
	public void stop() {
//		leftMotors.set(0);
//		rightMotors.set(0);
//		disablePID();
		tankDrive(0,0);
	}
	
	public void tankDrive(double y1, double y2){
		fl.set(-y1);
		bl.set(-y1);
		fr.set(y2);
		br.set(y2);
//    	leftMotors.set(-y1);
//    	rightMotors.set(y2);
    }
	
	public void moveLeft(double speed){
		fl.set(speed);
		bl.set(speed);
	}
	
	public void moveRight(double speed){
		fr.set(-speed);
		br.set(-speed);
	}
	
	public void resetEncoders(){ //should not need
//		leftEnc.reset();
//		rightEnc.reset();
	}
	

    public void initDefaultCommand() {
    }    
}


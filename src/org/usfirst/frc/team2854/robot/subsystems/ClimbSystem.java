package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController armMotor;
	private Encoder armEncoder;
	private SpeedController winchMotor;
	private SpeedController winchMotor2;
	boolean PIDEnabled = false;
	
	public ClimbSystem(SpeedController aArmMotor, SpeedController aWinchMotor, SpeedController aWinchMotor2, Encoder aArmEncoder) {
		// TODO Auto-generated constructor stub
		armMotor = aArmMotor;
		armEncoder = aArmEncoder;
		winchMotor = aWinchMotor;
		winchMotor2 = aWinchMotor2;
	}
	
	public void stop(){
		armMotor.set(0);
		winchMotor.set(0);
	}
	
	public boolean getPIDEnabled(){
		return PIDEnabled;
	}
	
	public void goTo(int i){ //does nothing, just for compatibility
		
	}
	
	public int encoderGet(){
		return armEncoder.getRaw();
	}
	
	public void resetEncoder(){
		armEncoder.reset();
	}
	
	public void moveArm(double speed){
		armMotor.set(speed);
	}
	
	public void moveWinch(double speed){
		winchMotor.set(speed);
		winchMotor2.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


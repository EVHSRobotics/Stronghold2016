package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDClimbSystem extends PIDSubsystem {

    // Initialize your subsystem here
	
	private SpeedController armMotor;
	private Encoder armEncoder;
	private SpeedController winchMotor;
	public static final int TOP_SETPOINT = 800;
	public static final int BOT_SETPOINT = 0;
	private boolean PIDEnabled = true;
	private boolean zeroing = false;
	private Counter counter;
	
	private int count = counter.get();
	public PIDClimbSystem(SpeedController aArmMotor, Encoder aArmEncoder, SpeedController aWinchMotor, Counter aCounter) {
		super("arm", .008, 0, .00075);
		// TODO Auto-generated constructor stub
		armMotor = aArmMotor;
		armEncoder = aArmEncoder;
		winchMotor = aWinchMotor;
		counter = aCounter;
		//enablePID(); no PID right now, since no setpoints
		disablePID();
		setOutputRange(-1,1); //min, max vals for motor to move
		setAbsoluteTolerance(80); //how close arm can be
		goTo(BOT_SETPOINT);
		
	}
	
	public void enableZeroing(boolean b){
		zeroing = b;
		if(zeroing){
			count = counter.get(); //get initial position
		}
		if(PIDEnabled){
			if(zeroing){ //if it's resetting, disable PID
				disable();
			}else{ //finished zeroing
				resetEncoder();
				setSetpoint(getPosition()); //prevents any future motion upon reenable; could get rid of if desired
				enable();
			}
		}

	}
	
	public boolean isZeroing(){
		return zeroing;
	}
	
	public boolean counterSame(){
//		System.out.println("COUNT: "+ count + " COUNTER:" + counter.get());
		return count == counter.get();
	}
	
	public void incrementCounter(){
		count = counter.get();
	}

	
	public void goTo(int setpoint){
		setSetpoint(setpoint);
	}
	
	public boolean getPIDEnabled(){
		return PIDEnabled;
	}
	public void stop(){
		armMotor.set(0);
		winchMotor.set(0);
		disablePID();
	}
	
	
	public void enablePID(){
		PIDEnabled = true;
		setSetpoint(getPosition()); //prevents any future motion upon reenable; could get rid of if desired
		enable();
	}
	public void disablePID(){
		PIDEnabled = false;
		disable();
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
	}
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return encoderGet();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	armMotor.set(output);
    }
}

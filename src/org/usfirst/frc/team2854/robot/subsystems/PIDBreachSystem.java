package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDBreachSystem extends PIDSubsystem implements Breaching {

    // Initialize your subsystem here
	private SpeedController defenseMotor;
	private Encoder breachEncoder;
	public static final int TOP_SETPOINT = 850;
	public static final int MID_SETPOINT = 660;
	public static final int BOT_SETPOINT = 50;
	private boolean PIDEnabled = true;
	private boolean defaultPID = true; //turns it on or off on start
	private boolean zeroing = false;
	
	private Counter counter; //insert DIO port
	
	private int count;
	
	public PIDBreachSystem(SpeedController aDefenseMotor, Encoder aBreachEncoder, Counter aCounter) {
		super("Breach", .008, 0, .01);
		defenseMotor = aDefenseMotor;
		breachEncoder = aBreachEncoder;
		counter = aCounter;
		setOutputRange(-1,1); //min, max vals for motor to move
		setAbsoluteTolerance(40); //how close arm can be
		count = counter.get();
	}
	
	public void changeDefaultPID(boolean b){
		defaultPID = b;
	}
	
	
	
	public void initDefaultPID(){
		if(defaultPID){
			enablePID();
		}else{
			disablePID();
		}
	}
	
//	public void disable(){
//		
//	}
//	public void enable(){
//		
//	}
//	public int getPosition(){
//		return 0;
//	}
//	
//	public void setSetpoint(int i){
//		
//	}
	
	public int getCounter(){
		return counter.get();
	}
	
	public void enableZeroing(boolean b){
		zeroing = b;
		count = counter.get(); //get initial or final position
		if(PIDEnabled){
			if(zeroing){ //if it's resetting, disable PID
				disable();
			}else{ //finished zeroing
				resetEncoder();
				goTo(getPosition()); //prevents any future motion upon reenable; could get rid of if desired
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
	
	
	public void goTo(double setpoint){
		setSetpoint(setpoint);
	}
	
	public boolean getPIDEnabled(){
		return PIDEnabled;
	}
	public void stop(){
		defenseMotor.set(0);
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
		return breachEncoder.getRaw();
	}
	
	public void resetEncoder(){
		breachEncoder.reset();
	}
	
	public void moveArm(double speed){
		defenseMotor.set(speed);
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
    	defenseMotor.set(output);
    }
}

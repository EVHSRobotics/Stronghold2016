package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDBreachSystem extends PIDSubsystem {

    // Initialize your subsystem here
	private SpeedController defenseMotor;
	private Encoder breachEncoder;
	public static final int TOP_SETPOINT = 800;
	public static final int BOT_SETPOINT = 0;
	boolean PIDEnabled = true;
	
	public PIDBreachSystem(SpeedController aDefenseMotor, Encoder aBreachEncoder) {
		super("Breach", .008, 0, .00075);
		// TODO Auto-generated constructor stub
		defenseMotor = aDefenseMotor;
		breachEncoder = aBreachEncoder;
		enable();
		setOutputRange(-1,1); //min, max vals for motor to move
		setAbsoluteTolerance(80); //how close arm can be
		goTo(BOT_SETPOINT);
	}
	
	public void goTo(int setpoint){
		setSetpoint(setpoint);
	}
	
	public boolean getPIDEnabled(){
		return PIDEnabled;
	}
	public void stop(){
		defenseMotor.set(0);
		disablePID();
	}
	
	public void disablePID(){
		PIDEnabled = false;
		setSetpoint(getPosition()); //prevents any future motion upon reenable; could get rid of if desired
		disable();
	}
	
	public int encoderGet(){
		return breachEncoder.getRaw();
	}
	
	public void resetEncoder(){
		breachEncoder.reset();
	}
	
	public void raise(double speed){
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

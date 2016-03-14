package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BreachSystem extends Subsystem implements Breaching	 {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController defenseMotor;
	private Encoder breachEncoder;
	boolean PIDEnabled = false;
	private Counter counter;
	
	public BreachSystem(SpeedController aDefenseMotor, Encoder aBreachEncoder, Counter aCounter) {
		// TODO Auto-generated constructor stub
		defenseMotor = aDefenseMotor;
		breachEncoder = aBreachEncoder;
		counter = aCounter;
	}
	
	public void stop(){
		defenseMotor.set(0);
	}
	
	public boolean getPIDEnabled(){
		return PIDEnabled;
	}
	
	public void goTo(double i){ //does nothing, just for compatibility
		
	}
	
	public int encoderGet(){
		return breachEncoder.getRaw();
	}
	
	public void resetEncoder(){
		breachEncoder.reset();
	}
	
	public int getCounter(){
		return counter.get();
	}
	
	public void moveArm(double speed){
		defenseMotor.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


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
	boolean PIDEnabled = false;
	
	public BreachSystem(SpeedController aDefenseMotor) {
		// TODO Auto-generated constructor stub
		defenseMotor = aDefenseMotor;
	}
	
	public void stop(){
		defenseMotor.set(0);
	}
	
	public boolean getPIDEnabled(){
		return PIDEnabled;
	}
	
	public void goTo(double i){ //does nothing, just for compatibility
		
	}
	
	
	public void moveArm(double speed){
		defenseMotor.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


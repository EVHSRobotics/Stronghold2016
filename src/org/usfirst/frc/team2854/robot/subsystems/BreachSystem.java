package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BreachSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController defenseMotor;
	
	public BreachSystem(SpeedController aDefenseMotor) {
		// TODO Auto-generated constructor stub
		defenseMotor = aDefenseMotor;
	}
	
	public void stop(){
		defenseMotor.set(0);
	}
	
	public void raise(double speed){
		defenseMotor.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


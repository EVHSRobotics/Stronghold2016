package org.usfirst.frc.team2854.robot.subsystems;

import org.usfirst.frc.team2854.robot.OI;
import org.usfirst.frc.team2854.robot.RobotMap;
import org.usfirst.frc.team2854.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;

/**
 *
 */

public class LiftSystem extends Subsystem {
	CanTalonSRX motorL;
	CanTalonSRX motorR;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public LiftSystem(){
	motorL = new CanTalonSRX(RobotMap.MapLiftSystem.motorL);
	motorR = new CanTalonSRX(RobotMap.MapLiftSystem.motorR);
	}

	
	public void up(){
		motorL.Set(.75);
		motorR.Set(.75);
	}
	
	public void down(){
		motorL.Set(-.75);
		motorR.Set(-.75);
	}
	
	public void stop(){
		motorL.Set(0);
		motorR.Set(0);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive(OI.OIMap.JoystickId.JOY1, OI.OIMap.Button.RB, OI.OIMap.Button.LB));
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}
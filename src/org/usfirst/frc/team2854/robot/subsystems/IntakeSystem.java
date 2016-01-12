package org.usfirst.frc.team2854.robot.subsystems;

import org.usfirst.frc.team2854.robot.OI;
import org.usfirst.frc.team2854.robot.RobotMap;
import org.usfirst.frc.team2854.robot.commands.Intake;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSystem extends Subsystem {
    CANTalon motorRO;
    CANTalon motorI;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public IntakeSystem() {
    	motorRO = new CANTalon(RobotMap.Front.motorRO);
    	motorI = new CANTalon(RobotMap.Intake.motorI);
    }
    
    public void stop(){
    	motorRO.set(0);
    	motorI.set(0);
    }
    
    public void roll(){
    	motorRO.set(.5);
    }
    
    public void pickup(){
    	motorI.set(.1);
    	Timer.delay(.1);
    	motorI.set(0);
    }
    public void initDefaultCommand() {
    	//TODO: Intakes
    	setDefaultCommand(new Intake(OI.OIMap.JoystickId.JOY1, OI.OIMap.Axis.RT, OI.OIMap.Axis.LT));
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSystem extends Subsystem{
    SpeedController rollerController;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public IntakeSystem(SpeedController roller) {
    	rollerController = roller;
    }
    
    public void stop(){
    	rollerController.set(0);
    }
    
    public void roll(double speed){
    	rollerController.set(speed);
    }
    
    public void initDefaultCommand() {

    }
}


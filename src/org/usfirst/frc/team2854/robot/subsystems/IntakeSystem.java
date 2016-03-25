package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSystem extends Subsystem{
    SpeedController rollerController;
    SpeedController dropController; //* drops down the intake
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public IntakeSystem(SpeedController roller, SpeedController drop) {
    	rollerController = roller;
    	dropController = drop;
    }
    
    public void stop(){
    	rollerController.set(0);
    	dropController.set(0);
    }
    
    public void drop(double speed){
    	dropController.set(speed); //PLEASE REENABLE THIS
    }
    public void roll(double speed){
    	rollerController.set(speed);
    }
    
    public void initDefaultCommand() {

    }
}


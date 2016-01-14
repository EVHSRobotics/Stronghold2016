package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSystem extends Subsystem{
    SpeedController i;
    SpeedController r;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public IntakeSystem(SpeedController intake, SpeedController roller) {
    	i = intake;
    	r = roller;
    }
    
    public void stop(){
    	r.set(0);
    	i.set(0);
    }
    
    public void roll(double speed){
    	r.set(speed);
    }
    
    public void boardSet(double speed){
    	i.set(speed);
    }
    public void initDefaultCommand() {

    }
}


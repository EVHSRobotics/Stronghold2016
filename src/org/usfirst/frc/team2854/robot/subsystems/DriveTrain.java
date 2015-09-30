package org.usfirst.frc.team2854.robot.subsystems;

import org.usfirst.frc.team2854.robot.OI;
import org.usfirst.frc.team2854.robot.RobotMap;
import org.usfirst.frc.team2854.robot.commands.Drive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	CANTalon motorFL;
	CANTalon motorFR;
	CANTalon motorBR;
	CANTalon motorBL;
	
	public DriveTrain(){
		
		motorFL = new CANTalon(RobotMap.MapDriveTrain.motorFL);
		motorBL = new CANTalon(RobotMap.MapDriveTrain.motorBL);
		motorFR = new CANTalon(RobotMap.MapDriveTrain.motorFR);
		motorBR = new CANTalon(RobotMap.MapDriveTrain.motorBR);
	}
	
	//Methods will be given later***
	/*public void drive(double x, double y, double t) {
		motorFL.set(x+y+t);
		motorBL.set(y-x+t);
		motorFR.set(y-x-t);
		motorBR.set(x+y-t);
	}
	*/
	//old drive train
	
	public void stop() {
		motorFL.set(0);
		motorFR.set(0);
		motorBL.set(0);
		motorBR.set(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive(OI.OIMap.JoystickId.JOY1, OI.OIMap.Axis.LY, OI.OIMap.Axis.RY));
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void mecDrive(double x, double y, double t, double a){
	    double temp = y*Math.cos(Math.toRadians(a)) - x*Math.sin(Math.toRadians(a));
	    x = y*Math.sin(Math.toRadians(a)) + x*Math.cos(Math.toRadians(a));
	    y = temp;
	    if(Math.abs(x+y+t) > 0){
	        System.out.println("DriveX: " +x + " DriveY: " + y);
	    }
	    
	    double front_left = y + t + x;
	    double front_right = y - t - x;
	    double back_left = y + t - x;
	    double back_right = y - t + x;
	    
	    double max = Math.abs(front_left);
	    if (Math.abs(front_right)>max) {
	        max = Math.abs(front_right);
	    }
	    if (Math.abs(back_left)>max){
	        max=Math.abs(back_left);
	    }
	    if (Math.abs(back_right)>max) {
	        max=Math.abs(back_right);
	    }
	    if (max>1){
	      front_left/=max; front_right/=max; back_left/=max; back_right/=max;

	    }
	    motorFL.set(front_left); 
	    motorFR.set(-front_right);//inverts motor
	    motorBR.set(-back_right);//inverts motor
	    motorBL.set(back_left); 
	}
}


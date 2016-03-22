package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	private SpeedController motor1;
	public SpeedController motor2;

	
	public DriveTrain(SpeedController amotor1, SpeedController amotor2){
		
		motor1=  amotor1;
		motor2 = amotor2;
		
	}

	
	public void stop() {
		motor1.set(0);
		motor2.set(0);
		
	}
	
	//driving imbalance
	public void driveStraight(double t){
		motor1.set(t);
		motor2.set(t);
		
	}
	public void drivestraightback(){
		motor1.set(-1);
		motor2.set(-1);
		
	}
	public void turn(double speed){
		motor1.set(speed);
		motor2.set(speed);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
	
    public void initDefaultCommand() {

    }
    

    
    public void tankDrive(double y1){
    	motor1.set(-y1);
    	motor2.set(-y1);
    }
}


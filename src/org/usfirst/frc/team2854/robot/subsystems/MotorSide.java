package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MotorSide implements PIDOutput{
	private SpeedController motor1;
	private SpeedController motor2;
	private String ID = "none";
	private int count = 0;
	private int reversed; //not reversed;
	public MotorSide(SpeedController m1, SpeedController m2, String id, int aReversed){
		motor1 = m1;
		motor2= m2;
		ID = id;
		reversed = aReversed;
	}
	
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		motor1.set(output*reversed);
		motor2.set(output*reversed);
		SmartDashboard.putNumber(ID, output*reversed);
		SmartDashboard.putNumber("COUNTER", count++);
	}
	
	public void set(double speed){
		motor1.set(speed);
		motor2.set(speed);
	}
	
	public double getSpeed(){
		return motor1.get();
	}
	
}

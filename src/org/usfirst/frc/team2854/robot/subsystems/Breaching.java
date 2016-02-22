package org.usfirst.frc.team2854.robot.subsystems;

public interface Breaching {
	public void stop();

	public boolean getPIDEnabled();

	public void goTo(double i);

	public int encoderGet();

	public void resetEncoder();

	public void moveArm(double speed);
	
	public int getCounter();


}

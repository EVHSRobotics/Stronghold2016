package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.OI.OIMap;
import org.usfirst.frc.team2854.robot.Robot;
import org.usfirst.frc.team2854.robot.RobotMap;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {
	
	private int joystickId;
	private int axisIdL;
	private int axisIdR;
	private int axisLT;
	private int axisRT;
	
    public Drive(int aJoystickId, int aAxisIdL, int aAxisIdR) {
    	requires(Robot.driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	joystickId = aJoystickId;
    	axisIdL = aAxisIdL;
    	axisIdR = aAxisIdR;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*double t;
    	double leftAxisYay = (Robot.oi.getAxis(joystickId, axisLT));
    	double rightAxisYay = (Robot.oi.getAxis(joystickId, axisRT));
    	
    	t = Math.max(leftAxisYay, rightAxisYay); //always positive
    	if(leftAxisYay > rightAxisYay){
    		t = -leftAxisYay;
    	}else{
    		t = rightAxisYay;
    	}
    	
    	Robot.driveTrain.mecDrive(Robot.oi.getAxis(joystickId, OIMap.Axis.LX), Robot.oi.getAxis(joystickId, OIMap.Axis.LY), t, 0);
    
    */
    int y1 = (int) Robot.oi.getAxis(joystickId, axisLT);
    int y2 = (int) Robot.oi.getAxis(joystickId, axisRT);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}

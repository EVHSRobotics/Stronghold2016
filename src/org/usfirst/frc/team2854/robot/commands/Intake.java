package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.oi.Axis;
import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.IntakeSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {
	private IntakeSystem intakeSystem;
	private Axis outAxis; //out
	private Axis inAxis; //in
	private Button moveButton; //  to drop intake
	private Button outButton; //to undrop intake
    public Intake(IntakeSystem intake, Axis aOutAxis, Axis aInAxis, Button aMoveButton, Button aMoveButton2) {
    	intakeSystem = intake;
    	outAxis = aOutAxis;
    	inAxis = aInAxis;
    	moveButton = aMoveButton;
    	outButton = aMoveButton2;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	requires(intakeSystem); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Math.abs(inAxis.deadbandGet()) > 0){
    		intakeSystem.roll(1);
    	} else if(Math.abs(outAxis.deadbandGet()) > 0){
    		intakeSystem.roll(-1);
    	} else {
    		intakeSystem.roll(0);
    	}
    	if(moveButton.get()){
    		intakeSystem.drop(1);
    	} else if(outButton.get()){
    		intakeSystem.drop(-1);
    	} else {
    		intakeSystem.drop(0);
    	} 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	intakeSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	intakeSystem.stop();
    }
}

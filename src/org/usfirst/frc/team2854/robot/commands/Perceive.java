package org.usfirst.frc.team2854.robot.commands;
	
import org.usfirst.frc.team2854.robot.oi.Button;
import org.usfirst.frc.team2854.robot.subsystems.CameraSystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Perceive extends Command {

	private CameraSystem cameraSystem;
	private Button cameraFlipButton;
	
	
    public Perceive(CameraSystem aCameraSystem, Button aCameraFlipButton) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	cameraSystem = aCameraSystem;
    	cameraFlipButton = aCameraFlipButton;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cameraSystem.updateCam();
    	if (cameraFlipButton.getHold()){
    		if (cameraSystem.getCurrCam() == cameraSystem.CAM_0){
    			System.out.println("Switched to cam1");
    			cameraSystem.changeCam(cameraSystem.CAM_1);
    		} else {
    			System.out.println("Switched to cam0");
    			cameraSystem.changeCam(cameraSystem.CAM_0);
    		}
    	}
//    	Timer.delay(0.005);	mehbe we need this - we don't
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

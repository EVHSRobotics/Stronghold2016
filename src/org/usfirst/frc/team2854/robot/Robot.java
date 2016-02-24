
package org.usfirst.frc.team2854.robot;

import org.usfirst.frc.team2854.robot.commands.Breach;
import org.usfirst.frc.team2854.robot.commands.Climb;
import org.usfirst.frc.team2854.robot.commands.Drive;
import org.usfirst.frc.team2854.robot.commands.Intake;
import org.usfirst.frc.team2854.robot.subsystems.Breaching;
import org.usfirst.frc.team2854.robot.subsystems.ClimbSystem;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2854.robot.subsystems.IntakeSystem;
import org.usfirst.frc.team2854.robot.subsystems.PIDBreachSystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	private static OI oi;
//	private static final CameraSystem cameraSystem = new CameraSystem();

	private static  Breaching breachSystem;
	private static  DriveTrain driveTrain;
	private static  IntakeSystem intakeSystem;
	private static  ClimbSystem climbSystem;

    private Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		RMap.initMap();
		breachSystem = new PIDBreachSystem(RMap.TALONSRX_1, RMap.ENCODER_34, RMap.COUNTER_6);
//		breachSystem = new BreachSystem(RMap.TALON_1, RMap.ENCODER_01, RMap.COUNTER_9);
		
		//ONE SRX IS NOT WORKING DO NOT USE DRIVE TRAIN
		driveTrain = new DriveTrain(RMap.TALON_1, RMap.TALON_3, RMap.TALON_2, RMap.TALON_4);
		intakeSystem = new IntakeSystem(RMap.TALON_5, RMap.TALON_0);
//		climbSystem = new ClimbSystem(RMap.TALON_2, RMap.TALON_3, RMap.TALON_4, RMap.ENCODER_34);
		System.out.println("INIT");
        // instantiate the command used for the autonomous period
//        autonomousCommand = new Auto(3, breachSystem);
		
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out
    	System.out.println("Teleop");
        if (autonomousCommand != null) autonomousCommand.cancel();
//        Scheduler.getInstance().add(new Perceive(cameraSystem, oi.controller0.bstart));

        Scheduler.getInstance().add(new Drive(driveTrain, oi.controller0.aly, oi.controller0.alt, oi.controller0.art, oi.controller0.bstart));
        Scheduler.getInstance().add(new Intake(intakeSystem, oi.controller1.alt, oi.controller1.art, oi.controller1.ba, oi.controller1.bx));
        Scheduler.getInstance().add(new Breach(breachSystem, oi.controller1.aly, oi.controller1.bback,
        		oi.controller1.blb, oi.controller1.bls, oi.controller1.brb, oi.controller1.bstart));
//        Scheduler.getInstance().add(new Climb(climbSystem, oi.controller1.ary, oi.controller1.arx));
//        System.out.println("Left Y Axis " + oi.controller0.aly);
//        System.out.println("Right Y Axis " + oi.controller0.ary);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}


package org.usfirst.frc.team2854.robot;

import org.usfirst.frc.team2854.robot.commands.AutoSequence;
import org.usfirst.frc.team2854.robot.commands.Breach;
import org.usfirst.frc.team2854.robot.commands.DoNothing;
import org.usfirst.frc.team2854.robot.commands.Drive;
import org.usfirst.frc.team2854.robot.commands.DriveAuto;
import org.usfirst.frc.team2854.robot.commands.ZeroBreach;
import org.usfirst.frc.team2854.robot.subsystems.BreachSystem;
import org.usfirst.frc.team2854.robot.subsystems.Breaching;
import org.usfirst.frc.team2854.robot.subsystems.CameraSystem;
import org.usfirst.frc.team2854.robot.subsystems.ClimbSystem;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;
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
	private static CameraSystem cameraSystem;

	private static  Breaching breachSystem;
	private static  DriveTrain driveTrain;
//	private static  IntakeSystem intakeSystem;
	private static  ClimbSystem climbSystem;

    private Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		RMap rmap = new RMap();
		breachSystem = new BreachSystem(rmap.TALON_5);
//		breachSystem = new BreachSystem(rmap.TALON_1, rmap.ENCODER_01, rmap.COUNTER_9);
		
//		cameraSystem = new CameraSystem();
		driveTrain = new DriveTrain(rmap.TALON_1, rmap.TALON_2, rmap.TALON_3, rmap.TALON_4, rmap.ENCODER_89, rmap.ENCODER_01);
//		intakeSystem = new IntakeSystem(rmap.TALON_5, rmap.TALON_0);
//		climbSystem = new ClimbSystem(rmap.TALON_2, rmap.TALON_3, rmap.TALON_4, rmap.ENCODER_34);
		System.out.println("INIT");
        // instantiate the command used for the autonomous period
        Command lowerCommand = new ZeroBreach((BreachSystem)breachSystem);
		Command driveCommand = new DriveAuto(driveTrain,4000,4000);
//		Command secondCommand = new DropBreach((PIDBreachSystem)breachSystem);
		Command nullCommand = new DoNothing();
		autonomousCommand = new AutoSequence(lowerCommand, driveCommand, nullCommand);
//		autonomousCommand = driveCommand;
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
//        Scheduler.getInstance().add(new Perceive(cameraSystem, oi.controller0.brb));

        Scheduler.getInstance().add(new Drive(driveTrain, oi.controller0.alx, oi.controller0.alt, oi.controller0.art, oi.controller0.bstart, oi.controller0.bback));
//        Scheduler.getInstance().add(new Intake(intakeSystem, oi.controller1.alt, oi.controller1.art, oi.controller1.ba, oi.controller1.bx));
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

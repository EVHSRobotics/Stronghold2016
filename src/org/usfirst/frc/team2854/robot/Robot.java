
package org.usfirst.frc.team2854.robot;

import org.usfirst.frc.team2854.robot.commands.Auto;
import org.usfirst.frc.team2854.robot.commands.Breach;
import org.usfirst.frc.team2854.robot.commands.Drive;
import org.usfirst.frc.team2854.robot.commands.DriveAuto;
import org.usfirst.frc.team2854.robot.commands.Intake;
import org.usfirst.frc.team2854.robot.commands.Perceive;
import org.usfirst.frc.team2854.robot.subsystems.CameraSystem;
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
	private static final CameraSystem cameraSystem = new CameraSystem();
	private static final DriveTrain driveTrain = new DriveTrain(RMap.TALON_1, RMap.TALON_2, RMap.TALON_3, RMap.TALON_4); // change
																														// motor
																														// port
																														// in
																														// rmap
	private static final IntakeSystem intakeSystem = new IntakeSystem(RMap.TALON_5, RMap.TALON_0);
	private static final PIDBreachSystem breachSystem = new PIDBreachSystem(RMap.TALONSRX_1, RMap.encoder3, RMap.counter6);

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// autoChooser = new SendableChooser();
		// autoChooser.addDefault("Default", new DriveAuto(driveTrain));
		// autoChooser.addObject("Experimental", new Experimental());
		// SmartDashboard.putData("Auto Mode Chooser", autoChooser);
		autonomousCommand = new DriveAuto(driveTrain);
		 oi = new OI();
		/*
		 * System.out.println("INIT"); // instantiate the command used for the
		 * autonomous period
		 */
		autonomousCommand = new Auto(3, breachSystem);

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		// if (autonomousCommand != null) autonomousCommand.start();
		// autonomousCommand = (DriveAuto) autoChooser.getSelected();
		autonomousCommand.start();
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
		if (autonomousCommand != null){
			autonomousCommand.cancel();
		}
		System.out.println(cameraSystem);
		System.out.println(oi.controller0);
		 Scheduler.getInstance().add(new Perceive(cameraSystem,oi.controller0.ba));
		 Scheduler.getInstance().add(new Intake(intakeSystem,oi.controller1.ba, oi.controller1.bx, oi.controller1.bb, oi.controller1.by));
		 Scheduler.getInstance().add(new Drive(driveTrain, oi.controller0.aly,oi.controller0.alt, oi.controller0.art, oi.controller0.bback));
		 Scheduler.getInstance().add(new Breach(breachSystem,oi.controller1.ary,oi.controller1.bstart, oi.controller1.bb, oi.controller1.by,
		 oi.controller0.brb));
		 System.out.println("Left Y Axis " + oi.controller0.aly);
		 System.out.println("Right Y Axis " + oi.controller0.ary);
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

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

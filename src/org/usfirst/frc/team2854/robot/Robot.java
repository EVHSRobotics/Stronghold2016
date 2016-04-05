
package org.usfirst.frc.team2854.robot;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2854.robot.commands.ArmCommand;
import org.usfirst.frc.team2854.robot.commands.ClimbingCommand;
=======
>>>>>>> e99f0f0604b0ea4d0eef54401873fad44ce1c8d6
import org.usfirst.frc.team2854.robot.commands.Drive;
import org.usfirst.frc.team2854.robot.commands.ExampleCommand;
import org.usfirst.frc.team2854.robot.commands.Intake;
import org.usfirst.frc.team2854.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team2854.robot.subsystems.ClimbingSubsystem;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2854.robot.subsystems.IntakeSystem;

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
<<<<<<< HEAD
	private static final DriveTrain driveTrain = new DriveTrain(RMap.MA, RMap.MAA, RMap.MB, RMap.MBB);
	private static final IntakeSystem intakeSystem = new IntakeSystem(RMap.MC, RMap.MCC);
	
	private static final ArmSubsystem armSubsystem = new ArmSubsystem(RMap.a); // check parameters
	private static final ClimbingSubsystem climbingSubsystem = new ClimbingSubsystem(RMap.b, RMap.c, RMap.d); // check parameters
=======
	private static final DriveTrain driveTrain = new DriveTrain(RMap.TALONSRX_0, RMap.TALONSRX_1, RMap.TALONSRX_3, RMap.TALONSRX_2);
	private static final IntakeSystem intakeSystem = new IntakeSystem(RMap.TALON_0);
>>>>>>> e99f0f0604b0ea4d0eef54401873fad44ce1c8d6

	private Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
<<<<<<< HEAD
		// instantiate the command used for the autonomous period
		autonomousCommand = new ExampleCommand();
	}

=======
		System.out.println("INIT");
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
    }
	
>>>>>>> e99f0f0604b0ea4d0eef54401873fad44ce1c8d6
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
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
<<<<<<< HEAD
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		Scheduler.getInstance().add(new Intake(intakeSystem, oi.controller0.alt, oi.controller0.art, oi.controller0.bx, oi.controller0.bb));
		Scheduler.getInstance().add(new Drive(driveTrain, oi.controller0.aly, oi.controller0.ary));
		Scheduler.getInstance().add(new ArmCommand(armSubsystem, oi.controller0.ba, false));
		Scheduler.getInstance().add(new ClimbingCommand(climbingSubsystem, oi.controller0.blb, oi.controller0.brb, false));
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
=======
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out
    	System.out.println("Teleop");
        if (autonomousCommand != null) autonomousCommand.cancel();
        Scheduler.getInstance().add(new Intake(intakeSystem, oi.controller0.ba, oi.controller0.bx));
        Scheduler.getInstance().add(new Drive(driveTrain, oi.controller0.aly, oi.controller0.alt, oi.controller0.art, oi.controller0.bback));
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
>>>>>>> e99f0f0604b0ea4d0eef54401873fad44ce1c8d6
}

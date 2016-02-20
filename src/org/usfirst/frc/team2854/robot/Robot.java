
package org.usfirst.frc.team2854.robot;

import org.usfirst.frc.team2854.robot.commands.Breach;
import org.usfirst.frc.team2854.robot.commands.Climb;
import org.usfirst.frc.team2854.robot.commands.Drive;
import org.usfirst.frc.team2854.robot.commands.ExampleCommand;
import org.usfirst.frc.team2854.robot.commands.Intake;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2854.robot.subsystems.IntakeSystem;
import org.usfirst.frc.team2854.robot.subsystems.PIDBreachSystem;
import org.usfirst.frc.team2854.robot.subsystems.PIDClimbSystem;

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
	private static final DriveTrain driveTrain = new DriveTrain(RMap.TALONSRX_2, RMap.TALONSRX_4, RMap.TALONSRX_1, RMap.TALONSRX_3);
	private static final IntakeSystem intakeSystem = new IntakeSystem(RMap.TALON_1, RMap.TALON_2);
	private static final PIDBreachSystem breachSystem = new PIDBreachSystem(RMap.TALON_0, RMap.ENCODER_89, RMap.COUNTER_6);
	private static final PIDClimbSystem climbSystem = new PIDClimbSystem(RMap.TALON_3, RMap.ENCODER_67, RMap.TALON_4, RMap.COUNTER_5);

    private Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		System.out.println("INIT");
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
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

        Scheduler.getInstance().add(new Drive(driveTrain, oi.controller0.aly, oi.controller0.alt, oi.controller0.art, oi.controller0.bback));
        
        Scheduler.getInstance().add(new Intake(intakeSystem, oi.controller1.alt, oi.controller1.art, oi.controller1.brb));
        Scheduler.getInstance().add(new Breach(breachSystem, oi.controller1.aly, 
        		oi.controller1.bback, oi.controller1.ba, oi.controller1.bx, oi.controller1.bstart));
        Scheduler.getInstance().add(new Climb(climbSystem, oi.controller1.ary, oi.controller1.arx, 
        		oi.controller1.blb, oi.controller1.bb, oi.controller1.by, oi.controller1.bstart));
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

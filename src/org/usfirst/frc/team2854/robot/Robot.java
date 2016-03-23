
package org.usfirst.frc.team2854.robot;

import org.usfirst.frc.team2854.robot.commands.DriveAuto;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;

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
	Command autonomousCommand;
	private static OI oi;
//	private static final CameraSystem cameraSystem = new CameraSystem();
	private static final DriveTrain driveTrain = new DriveTrain(RMap.motor1, RMap.motor2); //change motor port in rmap
	//private static final IntakeSystem intakeSystem = new IntakeSystem(RMap.TALON_1);
	//private static final PIDBreachSystem breachSystem = new PIDBreachSystem(RMap.TALON_0, RMap.ENCODER_89);


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
//    	autonomousCommand.init();
//    	autoChooser = new SendableChooser();
//    	autoChooser.addDefault("Default", new DriveAuto(driveTrain));
//    	autoChooser.addObject("Experimental", new Experimental());
//    	SmartDashboard.putData("Auto Mode Chooser	", autoChooser);
////    	Command autoDriveTest;
//    	autoDriveTest = new DriveAuto(driveTrain);	
//    	autonomousCommand = (Command) autoChooser.getSelected();
//		oi = new OI();
		/*
		System.out.println("INIT");
        // instantiate the command used for the autonomous period
        autonomousCommand = new Auto(3, breachSystem);
        */
    	autonomousCommand = new DriveAuto(driveTrain);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
       // if (autonomousCommand != null) autonomousCommand.start();
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
        if (autonomousCommand != null) autonomousCommand.cancel();
//        Scheduler.getInstance().add(new Perceive(cameraSystem, oi.controller0.bstart));
        //Scheduler.getInstance().add(new Intake(intakeSystem, oi.controller0.ba, oi.controller0.bx));
//        Scheduler.getInstance().add(new Drive(driveTrain, oi.controller0.aly, oi.controller0.alt, oi.controller0.art, oi.controller0.bback));
  //      Scheduler.getInstance().add(new Breach(breachSystem, oi.controller0.ary, 
    //    		oi.controller0.bstart, oi.controller0.bb, oi.controller0.by, oi.controller0.brb));
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

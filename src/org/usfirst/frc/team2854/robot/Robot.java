package org.usfirst.frc.team2854.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 * This is a demo program showing the use of the RobotDrive class. The
 * SampleRobot class is the base of a robot application that will automatically
 * call your Autonomous and OperatorControl methods at the right time as
 * controlled by the switches on the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're
 * inexperienced, don't. Unless you know what you are doing, complex code will
 * be much more difficult under this system. Use IterativeRobot or Command-Based
 * instead if you're new.
 */
public class Robot extends SampleRobot {
	NetworkTable server; // defines NetworkTable, used to send/receive info
							// wirelessly
	Timer timer; // defines timer, used to keep time (accesses info from Driver
					// Station)
	boolean shot; // tells if ball has been shot
	double count; // counter to keep time
	double distance; // distance from goal

	public Robot() {
		server = NetworkTable.getTable("RoborealmData"); // Gets data from table
															// in Tableviewer
															// (external
															// program)
		// As of 2016, Tableviewer IP should be 10.28.54.38 (start client)
		
		// called "RoborealmData"

	}

	public void robotInit() {
		System.out.println("INIT");
		shot = false; // ball has not been shot
		count = 0; // counter starts at 0
		timer = new Timer(); // timer initialized
		timer.start(); // timer started
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * if-else structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	public void autonomous() {
		System.out.println("AUTO START: server-" + server);
		while(true){
			System.out.println("AASFSD");
			Timer.delay(.05);
		}
//		while(true){
//			String s = server.getString(("Oranges"));
//			System.out.println(s);
//			Timer.delay(.05);
//		}
	
//		while (!shot) {
//			count++; // counter incremented every iteration of loop
//			System.out.println("COUNT:" + count);
//
//			try {
//				String s = server.getString("Triangle"); // gets data from table
//															// named Triangle
//															// (boolean
//															// represented as
//															// String)
//															// tells if
//															// retroreflective
//															// tape form a sort
//															// of Triangle
//				distance = server.getNumber("Distance"); // gets data from table
//															// named Distance
//															// (number)
//															// gives distance
//															// from goal
//				if (s.equals("True")) { // if retroreflective tape forms a
//										// triangle (both horizontal and
//										// vertical strips showing)
//					Timer.delay(.2); // Wait .2 seconds
//					if (s.equals("True")) { // check again for triangle (helps
//											// avoid false positives)
//						// Scheduler.getInstance().add(new ShootBall()); //add
//						// ShootBall command
//
//						shot = true; // mark that ball was shot
//						System.out.println("Ball shot sensor"); // shows on
//																// console that
//																// shot was
//																// attempted
//					}
//				}
//				System.out.println("TRI:" + server.getString("Triangle")); // shows
//																			// on
//																			// console
//																			// state
//																			// of
//																			// "Triangle"
//
//			}
//
//			catch (TableKeyNotDefinedException ex) // if data that doesn't exist
//													// on the table is asked for
//			{
//				System.out.println("Error");
//			}
//
//			// more data for testing/logging purposes below
//			System.out.println("Count " + count);
//			System.out.println("Time " + timer.get());
//			System.out.println("Distance " + distance);
//
//			if (timer.get() > 5 || count > 500) { // If either the DriverStation
//													// clock or internal count
//													// exceeds limit
//
//				// Scheduler.getInstance().add(new MoveandShoot()); //adds
//				// MoveandShoot command to queue
//				System.out.println("Ball shot timer");
//				shot = true; // mark that ball was shot
//			}
//		}
	}

	/**
	 * Runs the motors with arcade steering.
	 */
	public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			Timer.delay(0.005); // wait for a motor update time
		}
	}

	/**
	 * Runs during test mode
	 */
	public void test() {
	}
}

package org.usfirst.frc.team2854.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static class MapDriveTrain {
		public static final int motorFL = 6;
		public static final int motorBL = 7;
		public static final int motorFR = 8;
		public static final int motorBR = 9;
	}
	/*public static class MapLiftSystem {
		public static final int motorL = 0;
		public static final int motorR = 1;
	}*/
	public static class Front{
		public static final int motorRO = 5;
	}
	public static class Intake{
		public static final int motorI = 4;
	}
}

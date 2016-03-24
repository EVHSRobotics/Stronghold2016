package org.usfirst.frc.team2854.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;


/**
 * Created by Kevin on 10/24/2015.
 */
public class RMap{
	public static final Talon TALON_0 = new Talon(0);//window
	public static final Talon TALON_1 = new Talon(1);
	public static final Talon TALON_4 = new Talon(4);
	public static final Talon TALON_5 = new Talon(5);
	public static final Encoder encoderDriveLeft = new Encoder(8, 9, true, Encoder.EncodingType.k4X);
	public static final Encoder encoderDriveRight = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
	public static final Encoder encoder3 = new Encoder(3, 4, true, Encoder.EncodingType.k4X);
	public static final CANTalon TALONSRX_1 = new CANTalon(1);
	public static final CANTalon TALONSRX_2 = new CANTalon(2);
	public static final CANTalon TALONSRX_3 = new CANTalon(3);
	
	public static final Talon TALON_2 = new Talon(2);//additional talons
	public static final Talon TALON_3 = new Talon(3);
//	public static final Talon TALON_2 = new Talon(6);
//	public static final Talon TALON_3 = new Talon(7);
	
	public static final Counter counter6 = new Counter(6);
	 //boolean is whether reversed or not
	/*
	enccoders:
	89 on the left
	01 right
	34 breach and climb
	6 hall effect
	motors:
	winch = 
	window motor = 
	lift = 
	breach arm = 
	left drive = 
	right drive = 
	
	*/
	/*
	window motor 0 
	right motor 2
	left 2,1
	pg-srx 1
	right-4, 3
	*/
}

package org.usfirst.frc.team2854.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;


/**
 * Created by Kevin on 10/24/2015.
 */
public class RMap{
	public static final CANTalon TALONSRX_4 = new CANTalon(4);
	public static final CANTalon TALONSRX_1 = new CANTalon(1);
	public static final CANTalon TALONSRX_2 = new CANTalon(2);
	public static final CANTalon TALONSRX_3 = new CANTalon(3);
	
	public static final Talon TALON_0 = new Talon(0);
	public static final Talon TALON_1 = new Talon(1);
	public static final Talon TALON_2 = new Talon(2);
	public static final Talon TALON_3 = new Talon(3);
	public static final Talon TALON_4 = new Talon(4);
	public static final Talon TALON_5 = new Talon(5);
	public static final Talon TALON_6 = new Talon(6);
	public static final Talon TALON_7 = new Talon(7);
	
	public static final Encoder ENCODER_89 = new Encoder(8, 9, true, Encoder.EncodingType.k4X);
	public static final Encoder ENCODER_67 = new Encoder(6, 7, true, Encoder.EncodingType.k4X);
	//boolean is whether reversed or not

	public static final Counter COUNTER_5 = new Counter(5); //insert DIO port
	public static final Counter COUNTER_6 = new Counter(6); //insert DIO port
	
}

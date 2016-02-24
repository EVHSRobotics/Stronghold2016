package org.usfirst.frc.team2854.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;


/**
 * Created by Kevin on 10/24/2015.
 */
public class RMap{
//	public static  CANTalon TALONSRX_4 = new CANTalon(4);
	public static  CANTalon TALONSRX_1;
	public static  CANTalon TALONSRX_2;
	public static  CANTalon TALONSRX_3;
	
	public static  Talon TALON_0;
	public static  Talon TALON_1;
	public static  Talon TALON_2;
	public static  Talon TALON_3;
	public static  Talon TALON_4;
	public static  Talon TALON_5;
//	public static  Talon TALON_6 = new Talon(6);
//	public static  Talon TALON_7 = new Talon(7);
	
	public static  Encoder ENCODER_34;
	public static  Encoder ENCODER_01;
	//boolean is whether reversed or not

	public static  Counter COUNTER_6; //insert DIO port
//	public static  Counter COUNTER_6 = new Counter(6); //insert DIO port
	
	public static void initMap(){
//		TALONSRX_4 = new CANTalon(4);
		TALONSRX_1 = new CANTalon(1);
		TALONSRX_2 = new CANTalon(2);
		TALONSRX_3 = new CANTalon(3);
		
		TALON_0 = new Talon(0);
		TALON_1 = new Talon(1);
		TALON_2 = new Talon(2);
		TALON_3 = new Talon(3);
		TALON_4 = new Talon(4);
		TALON_5 = new Talon(5);
//		TALON_6 = new Talon(6);
//		TALON_7 = new Talon(7);
		
		ENCODER_34 = new Encoder(3, 4, true, Encoder.EncodingType.k4X);
		ENCODER_01 = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		//boolean is whether reversed or not

		COUNTER_6 = new Counter(6); //insert DIO port
//		COUNTER_6 = new Counter(6); //insert DIO port
	}
}

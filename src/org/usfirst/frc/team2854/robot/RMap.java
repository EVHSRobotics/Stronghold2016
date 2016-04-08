package org.usfirst.frc.team2854.robot;

//import org.usfirst.frc.team2854.robot.subsystems.RateEncoder;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;


/**
 * Created by Kevin on 10/24/2015.
 */
public class RMap{
//	public final  CANTalon TALONSRX_4 = new CANTalon(4);
//	public final CANTalon TALONSRX_1;
//	public final CANTalon TALONSRX_2;
//	public final CANTalon TALONSRX_3;
	
	public final Talon TALON_0;
	public final Talon TALON_1;
	public final Talon TALON_2;
	public final Talon TALON_3;
	public final Talon TALON_4;
	public final Talon TALON_5;
//	public final Talon TALON_6 = new Talon(6);
//	public final Talon TALON_7 = new Talon(7);
	
	public final Encoder ENCODER_34;
	public final Encoder ENCODER_01;
//	public final Encoder ENCODER_67;
	public final Encoder ENCODER_89;
	//boolean is whether reversed or not

//	public final Counter COUNTER_2; //insert DIO port
//	public final Counter COUNTER_6; //insert DIO port
	
	public RMap(){
//		TALONSRX_4 = new CANTalon(4);
//		TALONSRX_1 = new CANTalon(1);
//		TALONSRX_2 = new CANTalon(2);
//		TALONSRX_3 = new CANTalon(3);
		
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
//		ENCODER_67 = new Encoder(6, 7, true, Encoder.EncodingType.k4X);
		ENCODER_89 = new Encoder(8, 9, true, Encoder.EncodingType.k4X);
		//boolean is whether reversed or not

//		COUNTER_6 = new Counter(6); //insert DIO port
	}
}

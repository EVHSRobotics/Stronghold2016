package org.usfirst.frc.team2854.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;


/**
 * Created by Kevin on 10/24/2015.
 */
public class RMap{
  public static final Talon MA = new Talon(0); //done
  public static final Talon MB = new Talon(1); //done
  public static final CANTalon MC = new CANTalon(3); //done
  public static final Talon MAA = new Talon(2); //done
  public static final Talon MBB = new Talon(3); //done
  public static final CANTalon MCC = new CANTalon(2); //done
  
  //CANTalon 2 is farthest from roborio
  //CANTalon 3 is nearest to roborio
}

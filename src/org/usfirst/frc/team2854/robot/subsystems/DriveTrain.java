package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	private SpeedController fl;
	private SpeedController fr;
	private SpeedController bl;
	private SpeedController br;
	
	public DriveTrain(SpeedController frontleft, SpeedController frontright, SpeedController backleft, SpeedController backright){
		
		fl = frontleft;
		bl = backleft;
		fr = frontright;
		br = backright;
	}

	
	public void stop() {
		fl.set(0);
		fr.set(0);
		bl.set(0);
		br.set(0);
	}
	
	public void tankDrive(double y1, double y2){
    	fl.set(-y1);
    	bl.set(-y1);
    	fr.set(y2);
    	br.set(y2);
    }

    public void initDefaultCommand() {

    }    
}


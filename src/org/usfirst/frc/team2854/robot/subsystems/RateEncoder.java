package org.usfirst.frc.team2854.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RateEncoder extends Encoder {

	int getSource = 0;
	int setSource = 0;
	String ID = "none";
	public RateEncoder(int p1, int p2, boolean b, EncodingType e, String id){
		super(p1, p2, b, e);
		ID = id;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber(ID, getRate());
		return getRate();
	}
//	
//	public int getRaw(){
//		return enc.getRaw();
//	}
//	
//	public void reset(){
//		enc.reset();
//	}
//	
//	public double getRate(){
//		return enc.getRate();
//	}

}

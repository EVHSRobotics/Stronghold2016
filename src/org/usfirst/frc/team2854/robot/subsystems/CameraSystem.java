package org.usfirst.frc.team2854.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 *
 */
public class CameraSystem extends Subsystem {
    
	private USBCamera usbcamera;
	private CameraServer server1;
	private String camera;
	private Image frame;
	
	public final int CAM_0;
	public final int CAM_1;
	private int currCam;
	private NIVision.Rect rect;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public CameraSystem() {
		// TODO Auto-generated constructor stub
    	CAM_0 = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        CAM_1 = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        currCam = CAM_0;

        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        rect = new NIVision.Rect(10, 10, 100, 100);
        changeCam(CAM_1);
	}

	public void changeCam(int newId)
    {
		NIVision.IMAQdxStopAcquisition(currCam);
    	NIVision.IMAQdxConfigureGrab(newId);
    	NIVision.IMAQdxStartAcquisition(newId);
    	currCam = newId;	
    }
	
    public void updateCam()
    {
    	NIVision.IMAQdxGrab(currCam, frame, 1);
        NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
        
        CameraServer.getInstance().setImage(frame);
    }
    
    public int getCurrCam(){
    	return currCam;
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


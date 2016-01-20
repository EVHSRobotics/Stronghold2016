package org.usfirst.frc.team2854.robot.subsystems;
 
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
 
/**
 *@author Deven Navani
 */
public class PneumaticsSubsystem extends Subsystem {
     
    private Compressor compressor;
    private DoubleSolenoid valveUno;

    /**
     * 
     * @param PCMcanID - PCM CAN device ID
     * @param forwardValveChannel - forward channel number on PCM(0....7)
     * @param backwardValveChannel - backward channel number on PCM(0.....7)
     */
    public PneumaticsSubsystem(int PCMcanID, int forwardValveChannel, int backwardValveChannel)
    {
        compressor = new Compressor(PCMcanID);
        valveUno = new DoubleSolenoid(forwardValveChannel, backwardValveChannel);
    }
 
    /**
     * Puts compressor in closed loop control mode.
     */
    public void start()
    {
        compressor.start();
    }
     
    /**
     * Removes compressor from closed loop control mode.
     */
    public void stop()
    {
        compressor.stop();
    }
 
    /**
     * Checks if compressor is running.
     * @return - true if compressor is running
     */
    public boolean isOn()
    {
        return compressor.enabled();
    }
     
    /**
     * Enables forward channel of solenoid
     */
    public void enableForwardChannel()
    {
    	valveUno.set(DoubleSolenoid.Value.kForward);
    }
    
    /**
     * Enables backward channel of solenoid
     */
    public void enableBackwardChannel()
    {
    	valveUno.set(DoubleSolenoid.Value.kReverse);
    }
    
    /**
     * Deactivates both solenoid outputs
     */
    public void disableSolenoidOutput()
    {
    	valveUno.set(DoubleSolenoid.Value.kOff);
    }
 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
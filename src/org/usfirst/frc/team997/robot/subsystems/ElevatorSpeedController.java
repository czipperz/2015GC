
package org.usfirst.frc.team997.robot.subsystems;

import org.usfirst.frc.team997.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorSpeedController implements SpeedController {

	private SpeedController motor;
	private DoubleSolenoid brake;
	private DigitalInput High;
	private DigitalInput Low;
	
	public ElevatorSpeedController(SpeedController m, DoubleSolenoid b) {
		motor = m;
		brake = b;
	
	}
	
	public void addLimits( DigitalInput high, DigitalInput low) {
		
		High = high;
		Low = low;
		
	}
	@Override
	public void pidWrite(double arg0) {
		motor.pidWrite(arg0);
	}

	@Override
	public void disable() {
		motor.disable();
	}

	@Override
	public double get() {
		return motor.get();
	}

	@Override
	public void set(double speed) {
		double lspeed = speed;
		
		
		if (lspeed<0 && (!High.get())) {
			lspeed = 0;		
		} 
		if(lspeed>0 && (!Low.get())) {
			lspeed = 0;		
		}
		if (Math.abs(lspeed)< .05) {
			motor.set(0);
			brake.set(DoubleSolenoid.Value.kForward);
		} else if (getElevatorCurrent()>RobotMap.ElevatorMaxCurrent) {
			motor.set(0);
		} else {
			brake.set(DoubleSolenoid.Value.kReverse);
			motor.set(lspeed);
		}
	}

	public void set(double arg0, byte arg1) {
		set(arg0);
	}
	
	PowerDistributionPanel panel = new PowerDistributionPanel();
	private double getElevatorCurrent() {
		double current = panel.getCurrent(RobotMap.ElevatorMotorSlot);
		SmartDashboard.putNumber("ElevatorCurrent", current);
		return current;
	}
}

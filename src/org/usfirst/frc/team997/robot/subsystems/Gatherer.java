package org.usfirst.frc.team997.robot.subsystems;

import org.usfirst.frc.team997.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * this is the gatherer. it spins to intake totes and spins in reverse to spit
 * them back out
 */
public class Gatherer extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public SpeedController gatherMotorLeft;
	public SpeedController gatherMotorRight;
	public DoubleSolenoid mySolenoid;
	public AnalogInput Ultrasonic;

	public Gatherer(DoubleSolenoid sol, SpeedController left,
			SpeedController right, int UltrasonicSlot) {
		mySolenoid = sol;
		gatherMotorLeft = left;
		gatherMotorRight = right;
		Ultrasonic = new AnalogInput(UltrasonicSlot);
	}

	public void initDefaultCommand() {

	}

	// gathers in. the '1' sets the motor to full speed. may change later
	public void in() {

		gatherMotorLeft.set(-1);
		gatherMotorRight.set(-1);
	}

	// spits out. the '-1' sets the motor to full reverse. may change later.
	public void out() {

		gatherMotorLeft.set(1);
		gatherMotorRight.set(1);
	}

	public void stop() {
		gatherMotorLeft.set(0);
		gatherMotorRight.set(0);
	}

	public boolean solenoidExtended;

	public void setSolenoid(boolean a) {
		solenoidExtended = a;
		if (a) {
			mySolenoid.set(DoubleSolenoid.Value.kForward);
		} else {
			mySolenoid.set(DoubleSolenoid.Value.kReverse);
		}
		SmartDashboard.putBoolean("GatherSolenoid Extended", solenoidExtended);
	}
	
	public void toggleSolenoid() {
		if( solenoidExtended) {
			setSolenoid(false);
		} else {
			setSolenoid(true);
		}
		
	}

	public double getUltrasonic() {
		return Ultrasonic.getVoltage() * RobotMap.CalibrationUltrasonic;
	}

	public void SmartDashboard() {
		SmartDashboard.putData(this);
		SmartDashboard.putNumber("Ultrasonic", getUltrasonic());
	}

}

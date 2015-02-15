package org.usfirst.frc.team997.robot;

import org.usfirst.frc.team997.robot.commands.ArcadeDrive;
import org.usfirst.frc.team997.robot.commands.DriveStraight;
import org.usfirst.frc.team997.robot.commands.ElevatorPosition;
import org.usfirst.frc.team997.robot.commands.ElevatorRaw;
import org.usfirst.frc.team997.robot.commands.GatherIn;
import org.usfirst.frc.team997.robot.commands.GatherOut;
import org.usfirst.frc.team997.robot.commands.Rotate;
import org.usfirst.frc.team997.robot.commands.SetElevatorPosition;
import org.usfirst.frc.team997.robot.commands.SetGatherSolenoid;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Controller myController;
	public Controller jumpPad;
	
	public Button setSolenoidButtonOn;
	public Button setSolenoidButtonOff;
	public Button GatherOutButton;
	public Button GatherInButton;
	
	public OI () {
		myController = new Controller(0);
		jumpPad = new Controller(1);
		
		setSolenoidButtonOn = new JoystickButton(myController, 1);
		setSolenoidButtonOff = new JoystickButton(myController, 2);
		GatherInButton = new JoystickButton(myController, 5);
		GatherOutButton = new JoystickButton(myController, 6);
		
		
		
		setSolenoidButtonOff.whenPressed(new SetGatherSolenoid(false));
		setSolenoidButtonOn.whenPressed(new SetGatherSolenoid(true));
		GatherInButton.whileHeld(new GatherIn());
		GatherOutButton.whileHeld(new GatherOut());
		
		SmartDashboard.putData("Arcade Drive", new ArcadeDrive());
		SmartDashboard.putData("ElevatorPosition", new ElevatorPosition());
		SmartDashboard.putData("ElevatorRaw", new ElevatorRaw());
		SmartDashboard.putData("DriveStright", new DriveStraight());
		SmartDashboard.putData("Turn", new Rotate());
		SmartDashboard.putData("SetElev.5", new SetElevatorPosition(.5));
		SmartDashboard.putData("SetElev1", new SetElevatorPosition(1));
		SmartDashboard.putData("SetElev.75", new SetElevatorPosition(.75));
		
	}
	
	
	public double getDesiredArcadeLeftSpeed() {
		return getGear()*deadBand((myController.getLY() + myController.getRX()),.25);
	}
	
	public double getDesiredArcadeRightSpeed() {
		return getGear()*deadBand((myController.getLY() - myController.getRX()),.25);
	}
	
	public double getDesiredElevatorPosition() {
		return ((jumpPad.getModZ()*1.1)+.1);
	}
	
	public double deadBand(double a, double dead) {
		if (Math.abs(a)<dead){
			return 0;
		} else {
			return a;
		}
	}
	
	public double getGear() {
		return .5;
	}

	public void SmartDashboard() {
		SmartDashboard.putNumber("left X", myController.getLX());
		SmartDashboard.putNumber("right X", myController.getRX());
		SmartDashboard.putNumber("left y", myController.getLY());
		SmartDashboard.putNumber("right y", myController.getRY());
		SmartDashboard.putNumber("desired arcade left", getDesiredArcadeLeftSpeed());
		SmartDashboard.putNumber("desired arcade right", getDesiredArcadeRightSpeed());
		
	}

	public double getElevatorVoltage() {
		return myController.getTriggersAsAxis();
	}
}


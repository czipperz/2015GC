package org.usfirst.frc.team997.robot.commands;

import org.usfirst.frc.team997.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class zeroElevator extends Command {
	public zeroElevator() {
		requires(Robot.myElevator());
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.myElevator().setVoltage(.5);
	}
	
	@Override
	protected boolean isFinished() {
		return Robot.myElevator().getLowLimit();
	}
	
	@Override
	protected void interrupted() {
		Robot.myElevator().setVoltage(0);
	}
	
	@Override
	protected void end() {
		Robot.myElevator().setVoltage(0);
		Robot.myElevator().zeroEncoder();
		
	}
}

package org.usfirst.frc.team997.robot.commands;

import org.usfirst.frc.team997.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorRaw extends Command {
	public ElevatorRaw() {
		requires(Robot.myElevator());
	}
	
	@Override
	protected void initialize() {
		
	}	


	@Override
	protected void execute() {
		Robot.myElevator().setVoltage(Robot.oi.getElevatorVoltage());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

}

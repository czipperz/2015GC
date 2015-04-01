package org.usfirst.frc.team997.robot.commands;

import org.usfirst.frc.team997.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnTime extends Command {
	boolean mClockwise;
	public TurnTime(boolean clockwise) {
		mClockwise = clockwise;
	}
	@Override
	protected void end() {
		Robot.subDriveTrain().drive(0, 0);
	}

	@Override
	protected void execute() {
		if (mClockwise){
			Robot.subDriveTrain().drive(.5, -.5);
		} else {
			Robot.subDriveTrain().drive(-.5, .5);
		}
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Robot.subDriveTrain().drive(0, 0);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

package org.usfirst.frc.team997.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraightCommand extends CommandGroup {
	public DriveStraightCommand() {
		addSequential(new DriveStraight(), .66);
	}

}

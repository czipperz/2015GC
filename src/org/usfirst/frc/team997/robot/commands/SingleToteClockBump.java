package org.usfirst.frc.team997.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SingleToteClockBump extends CommandGroup {
	public SingleToteClockBump(){
	addSequential(new AutoGrabTote());
    addSequential(new RotateClockwise(90, true));
    addSequential(new Wait(), .25);
    addSequential(new DriveStraight(), 1.5);
    addSequential(new zeroElevator());
    addSequential(new SetGatherSolenoid(true));
    addSequential(new GatherOut(), 2);
}
}
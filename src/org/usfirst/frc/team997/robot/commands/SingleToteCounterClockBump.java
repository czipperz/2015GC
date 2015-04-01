package org.usfirst.frc.team997.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SingleToteCounterClockBump extends CommandGroup {
	public SingleToteCounterClockBump(){
	addSequential(new AutoGrabTote());
    addSequential(new RotateCounterClockwise(90, true));
    addSequential(new Wait(), .25);
    addSequential(new DriveStraight(), 1.5);
   // addSequential(new zeroElevator());
}
}
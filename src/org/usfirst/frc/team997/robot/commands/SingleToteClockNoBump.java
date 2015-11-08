package org.usfirst.frc.team997.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SingleToteClockNoBump extends CommandGroup {
    
    public  SingleToteClockNoBump() {
      addSequential(new AutoGrabTote());
      addSequential(new RotateClockwise(90, true));
      addSequential(new Wait(), .25);
      addSequential(new DriveStraight(), 1.15);
      addSequential(new zeroElevator());
      addSequential(new SetGatherSolenoid(true));
      addSequential(new GatherOut(), 2);
    }
}

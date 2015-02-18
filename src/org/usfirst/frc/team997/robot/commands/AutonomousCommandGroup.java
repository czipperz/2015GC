package org.usfirst.frc.team997.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommandGroup extends CommandGroup {
    
    public  AutonomousCommandGroup() {
    	addSequential(new SetGatherSolenoid(false));
      addSequential(new zeroElevator());
      addSequential(new SetElevatorPosition(.5), 1);
      addSequential(new Rotate(90));
      addSequential(new Wait(), 1);
      addSequential(new DriveStraight());
    }
}

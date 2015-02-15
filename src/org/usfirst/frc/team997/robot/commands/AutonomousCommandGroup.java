package org.usfirst.frc.team997.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommandGroup extends CommandGroup {
    
    public  AutonomousCommandGroup() {
      addSequential(new zeroElevator());
      addSequential(new SetElevatorPosition(.5), 2);
      addSequential(new Rotate(), 1);
      addSequential(new DriveStraight(),2);
    }
}

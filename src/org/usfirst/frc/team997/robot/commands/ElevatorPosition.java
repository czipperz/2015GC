package org.usfirst.frc.team997.robot.commands;

import static org.usfirst.frc.team997.robot.Robot.myElevator;
import static org.usfirst.frc.team997.robot.Robot.oi;

import org.usfirst.frc.team997.robot.Robot;
import org.usfirst.frc.team997.robot.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorPosition extends Command {

    public ElevatorPosition() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(myElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	myElevator.setPIDtarget(1);
    	myElevator.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	myElevator.setPIDtarget(oi.getDesiredElevatorPosition());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	myElevator.disable();

    }
    
    private double getElevatorCurrent() {
		return new PowerDistributionPanel().getCurrent(RobotMap.ElevatorMotorSlot);
	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.myElevator.disable();
    }
}

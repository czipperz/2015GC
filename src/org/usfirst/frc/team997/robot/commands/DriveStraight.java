package org.usfirst.frc.team997.robot.commands;

import org.usfirst.frc.team997.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends Command {

    public DriveStraight() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.subDriveTrain());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.subDriveTrain().resetGyro();
    	Robot.subDriveTrain().resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double leftSpeed = .8;
    	double rightSpeed = .8;
    			
    	SmartDashboard.putNumber("leftSpeedGyro", leftSpeed);
    	SmartDashboard.putNumber("Right Speed Gyro", rightSpeed);
    	Robot.subDriveTrain().drive(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.subDriveTrain().drive(0,0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.subDriveTrain().drive(0,0);

    }
}

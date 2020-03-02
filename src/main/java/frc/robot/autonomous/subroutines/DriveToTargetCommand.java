/*/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
package frc.robot.commands;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveToTargetCommand extends CommandBase {
  double distance;
  
  boolean isFinished = false;

  public DriveToTargetCommand(double myDistance, DrivetrainSubsystem mDrivetrain) {
    
    Requires(RobotContainer.mDrivetrain);
    distance = myDistance;  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    isFinished = RobotContainer.mDrivetrain.driveToTarget(distance, 2);
  }
 
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return isFinished;
    }
    
    @Override
    protected void end() {
  RobotContainer.mDrivetrain.reset();
    }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mDrivetrain.reset();
  }
}
*/
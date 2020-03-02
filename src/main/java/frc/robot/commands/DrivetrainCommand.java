/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DrivetrainCommand extends CommandBase {

  private final DrivetrainSubsystem mDrive;
  private final DoubleSupplier mForward;
  private final DoubleSupplier mRotation;
  private final BooleanSupplier mGearshift;

  private final BooleanSupplier mInvertDrivetrain;
  private boolean mDrivetrainIsInverted = true;
  
  /**
   * Creates a new DrivetrainCommand.
   */
  public DrivetrainCommand(
      DrivetrainSubsystem drivetrain, 
      DoubleSupplier forward, 
      DoubleSupplier rotation,
      BooleanSupplier gearShift,
      BooleanSupplier invertDrivetrain
      
    ) {
    
    mGearshift = gearShift;
    mForward = forward;
    mRotation = rotation;
    mDrive = drivetrain;
    mInvertDrivetrain = invertDrivetrain;

    addRequirements(mDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {  

    if (mInvertDrivetrain.getAsBoolean())
      mDrivetrainIsInverted = !mDrivetrainIsInverted;

    if (mGearshift.getAsBoolean())
      mDrive.shift();
     

    if (mDrivetrainIsInverted) {
      mDrive.cheezy_drive(
        mForward.getAsDouble(),
        mRotation.getAsDouble()
        );
    } else {
      mDrive.cheezy_drive(
        mForward.getAsDouble() * -1,
        mRotation.getAsDouble() * -1
        );
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

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
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends CommandBase {
  /**
   * Creates a new ShootCommand.
   */

   private final ShooterSubsystem mShooter;
   private final BooleanSupplier mIndex;
   private final BooleanSupplier mFlushIndex;
   private final DoubleSupplier mPositiveShooterSpeed;
   private final DoubleSupplier mNegativeShooterSpeed;
   
  public ShootCommand(ShooterSubsystem shooter, 
    BooleanSupplier index,
    BooleanSupplier flushIndex,
    DoubleSupplier positiveShooterSpeed,
    DoubleSupplier negativeShooterSpeed
    ) {
    
    mShooter = shooter;
    mIndex = index;
    mFlushIndex = index;
    mPositiveShooterSpeed = positiveShooterSpeed;
    mNegativeShooterSpeed = negativeShooterSpeed;

    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (mIndex.getAsBoolean()) {
      mShooter.index();
    }
    
    else if (mFlushIndex.getAsBoolean()) {
      mShooter.flushIndex();
    }
    else {
      mShooter.stopIndex();
    }

  
    mShooter.shoot_analog(
      (mPositiveShooterSpeed.getAsDouble() >  mNegativeShooterSpeed.getAsDouble())
          ?
          mPositiveShooterSpeed.getAsDouble()   
          :
          mNegativeShooterSpeed.getAsDouble()
      );
    
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

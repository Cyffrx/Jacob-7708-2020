/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;


public class LiftCommand extends CommandBase {
  /**
   * Creates a new LiftCommand.
   */

  private final LiftSubsystem mLift;
  private final IntSupplier mPOV;
  private final BooleanSupplier mUnlockWinch;


   public LiftCommand(LiftSubsystem Lift,
        IntSupplier POV,
        BooleanSupplier unlockWinch
    ) {
    // Use addRequirements() here to declare subsystem dependencies.
    mLift = Lift;
    mPOV = POV;
    mUnlockWinch = unlockWinch;

    addRequirements(Lift);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (mUnlockWinch.getAsBoolean()) {
      mLift.unlockWinch();
    }

    if (mPOV.getAsInt() == 0) {
      mLift.raiseRobot();
    } else {
      mLift.brake();
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

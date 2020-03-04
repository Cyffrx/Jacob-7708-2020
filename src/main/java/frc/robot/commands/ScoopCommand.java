/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ScoopSubsystem;

public class ScoopCommand extends CommandBase {
  /**
   * Creates a new scoop.
   */

   private final ScoopSubsystem mScoop;
   private final BooleanSupplier mToggleDeploy;
   private final BooleanSupplier mIsIntaking;
   private BooleanSupplier mIsOuttaking;
   
  public ScoopCommand(ScoopSubsystem scoop,
          BooleanSupplier toggleDeploy,
          BooleanSupplier isIntaking,
          BooleanSupplier isOuttaking
          ) {
    // Use addRequirements() here to declare subsystem dependencies.

    mScoop = scoop;
    mToggleDeploy = toggleDeploy;
    mIsIntaking = isIntaking;
    mIsOuttaking = isOuttaking;

    addRequirements(scoop);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (mIsIntaking.getAsBoolean())
      mScoop.intake();
    else if (mIsOuttaking.getAsBoolean())
      mScoop.outtake();
    else
      mScoop.stopMotor();

    if (mToggleDeploy.getAsBoolean())
      mScoop.toggleDeploy();
    

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

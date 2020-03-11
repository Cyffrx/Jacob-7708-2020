/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSubsystem;

public class OldColorWheelCommand extends CommandBase {
  /**
   * Creates a new ColorWheelCommand.
   */

   private final ColorWheelSubsystem mColorWheel;
   private final BooleanSupplier mSpinColorWheelStage2;
   private final BooleanSupplier mSpinColorWheelStage3;
   private final BooleanSupplier mDeployColorWheel;

  public OldColorWheelCommand(ColorWheelSubsystem colorWheel,
          BooleanSupplier spinColorWheelStage2,
          BooleanSupplier spinColorWheelStage3,
          BooleanSupplier deployColorWheel
          ) {
    // Use addRequirements() here to declare subsystem dependencies.
    mColorWheel = colorWheel;
    mSpinColorWheelStage2 = spinColorWheelStage2;
    mSpinColorWheelStage3 = spinColorWheelStage3;
    mDeployColorWheel = deployColorWheel;

    addRequirements(colorWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  
  public void execute() {
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

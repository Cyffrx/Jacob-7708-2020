/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
  /**
   * Creates a new IntakeSubystem.
   */

   private final IntakeSubsystem mIntake;
   private final BooleanSupplier mIsIntaking;
   private final BooleanSupplier mIsIndexing;
   private final BooleanSupplier mSlide;

   private boolean indexing = false;

   /*
   hold to intake
   toggle to index into indexer and power shooter
   hold to shoot
   */
   
   
  public IntakeCommand(IntakeSubsystem Intake,
    BooleanSupplier isIntaking,
    BooleanSupplier isIndexing,
    BooleanSupplier Slide
  ) {
    // Use addRequirements() here to declare subsystem dependencies.
    
    mIntake = Intake;
    mIsIntaking = isIntaking;
    mIsIndexing = isIndexing;
    mSlide = Slide;

    addRequirements(Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (mIsIndexing.getAsBoolean()) {
      indexing=!indexing;
    }

    if (indexing) {
      mIntake.index();
    } else {
      mIntake.setInactive();
    }
    
    if (mIsIntaking.getAsBoolean()) {
      mIntake.intake();
    }

    // NEEDS TO HAPPEN ONLY IF THE LOW SWITCH IS ACTIVATED
    if (mSlide.getAsBoolean() && !mIntake.isLow()) {
      mIntake.sliderail_toggle();
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

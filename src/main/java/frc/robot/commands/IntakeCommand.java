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
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
  /**
   * Creates a new IntakeSubystem.
   */

   private final IntakeSubsystem mIntake;
   private final BooleanSupplier mIsIntaking;
   private final BooleanSupplier mIsOuttaking;
   private final BooleanSupplier mIsPassivelyIndexing;
   private final BooleanSupplier mSlide;

   private boolean isPassivelyIntaking = false;

   /*
   hold to intake
   toggle to index into indexer and power shooter
   hold to shoot
   */
   
   
  public IntakeCommand(IntakeSubsystem Intake,
    BooleanSupplier isIntaking,
    BooleanSupplier isOuttaking,
    BooleanSupplier isPassivelyIndexing,
    BooleanSupplier Slide
  ) {
    // Use addRequirements() here to declare subsystem dependencies.
    
    mIntake = Intake;
    
    mIsIntaking = isIntaking;
    mIsOuttaking = isOuttaking;

    mIsPassivelyIndexing = isPassivelyIndexing;
    
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

    if (mIsPassivelyIndexing.getAsBoolean()) {
      isPassivelyIntaking=!isPassivelyIntaking;
    }

    if (isPassivelyIntaking) {
      mIntake.passivelyIndex();
    }

    if (mIsIntaking.getAsBoolean()) {
      mIntake.intake();
    }
    else if (mIsOuttaking.getAsBoolean()) {
      mIntake.outtake();
    } else {
      mIntake.stop();
    }

    // NEEDS TO HAPPEN \ONLY IF THE LOW SWITCH IS ACTIVATED
    if (mSlide.getAsBoolean() && true/*!mIntake.limitSwitches.isLow()*/) {
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

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ChassisSubsystem;

public class ChassisCommand extends CommandBase {
  /**
   * Creates a new ChassisCommand.
   */

   private final ChassisSubsystem mChassis;
   private final BooleanSupplier mRaiseChassis;
   private final BooleanSupplier mLowerChassis;



   public ChassisCommand(ChassisSubsystem Chassis, 
      BooleanSupplier RaiseChassis, 
      BooleanSupplier LowerChassis
  ) {
    // Use addRequirements() here to declare subsystem dependencies.
    mRaiseChassis = RaiseChassis;
    mLowerChassis = LowerChassis;

    mChassis = Chassis;

    addRequirements(Chassis);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    if (mRaiseChassis.getAsBoolean()) {
      mChassis.raise_chassis();
    } else if (mLowerChassis.getAsBoolean()) {
      mChassis.lower_chassis();
    } else {
      mChassis.hold_chassis();
    }

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

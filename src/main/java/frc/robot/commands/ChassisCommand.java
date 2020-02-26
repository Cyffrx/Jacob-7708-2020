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
import frc.robot.subsystems.ChassisSubsystem;

public class ChassisCommand extends CommandBase {
  /**
   * Creates a new ChassisCommand.
   */

   private final ChassisSubsystem mChassis;
   private final DoubleSupplier mChangeChassis;



   public ChassisCommand(ChassisSubsystem Chassis, 
      DoubleSupplier ChangeChassis
      
  ) {
    // Use addRequirements() here to declare subsystem dependencies.
    mChangeChassis = ChangeChassis;

    mChassis = Chassis;

    addRequirements(Chassis);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mChassis.delta_chassis(mChangeChassis.getAsDouble());
    
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

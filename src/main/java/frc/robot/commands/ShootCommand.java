/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends CommandBase {
  /**
   * Creates a new ShootCommand.
   */

   private final ShooterSubsystem mShooter;
   private final IndexerSubsystem mIndexer;
   private final BooleanSupplier mShoot;
   private final BooleanSupplier mIndex;

  public ShootCommand(ShooterSubsystem shooter, 
    IndexerSubsystem indexer, 
    BooleanSupplier shoot, 
    BooleanSupplier index) {
    
    mShooter = shooter;
    mIndexer = indexer;
    
    mShoot = shoot;
    mIndex = index;

    addRequirements(shooter);
    addRequirements(indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (mShoot.getAsBoolean()) {
      mIndexer.indexBall();
      mShooter.shoot();
      
    } else {
      mIndexer.stopIndex();
      mShooter.brake();
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

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new TESTShooterSubsystem.
   */

   private static final double BRAKE = 0.0;

  private WPI_TalonFX RFalcon_Master = new WPI_TalonFX(Constants.SHOOTER_FALCON_MASTER);
  private WPI_TalonFX RFalcon_Slave = new WPI_TalonFX(Constants.SHOOTER_FALCON_SLAVE);

  private WPI_TalonFX indexer = new WPI_TalonFX(Constants.INDEXER);


  public ShooterSubsystem() {
    RFalcon_Master.setInverted(false);
    RFalcon_Slave.setInverted(true);

    RFalcon_Slave.follow(RFalcon_Master);
   
  }

  public void shoot() {
    indexer.set(Constants.INDEX_SPEED*Constants.INDEXER_LIMIT);
  }

  public void ramp() {
    RFalcon_Master.set(Constants.FLYWHEEL_SPEED*Constants.FLYWHEEL_LIMIT);
  }

  public void coast() {
    RFalcon_Master.set(Constants.FLYWHEEL_COAST_SPEED*Constants.FLYWHEEL_LIMIT);
  }

  public void brake() {
    RFalcon_Master.set(BRAKE);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

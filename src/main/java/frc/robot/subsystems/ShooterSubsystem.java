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

   private static final double SHOOT_SPEED = 0.8;
   private static final double BRAKE = 0.0;
   private static final double COAST = 0.4;

  private WPI_TalonFX RFalcon_Master = new WPI_TalonFX(Constants.SHOOTER_FALCON_MASTER);
  private WPI_TalonFX RFalcon_Slave = new WPI_TalonFX(Constants.SHOOTER_FALCON_SLAVE);

  public ShooterSubsystem() {
    RFalcon_Master.setInverted(false);
    RFalcon_Slave.setInverted(true);

    RFalcon_Slave.follow(RFalcon_Master);
   
  }

  public void shoot() {
    RFalcon_Master.set(SHOOT_SPEED);
  }

  public void coast() {
    RFalcon_Master.set(COAST);
  }

  public void brake() {
    RFalcon_Master.set(BRAKE);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

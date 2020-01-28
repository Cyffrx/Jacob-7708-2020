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

public class LiftSubsystem extends SubsystemBase {
  /**
   * Creates a new LiftSubsystem.
   */

  private static double RAISE_SPEED = 1.0;
  private static double LOWER_SPEED = .10;
  private static double BRAKE = 0;

   private WPI_TalonFX LiftFalcon = new WPI_TalonFX(Constants.LIFT_FALCON);

   public LiftSubsystem() {

  }

  public void raiseRobot() {
    LiftFalcon.set(RAISE_SPEED);
   }

   public void lowerRobot() {
    LiftFalcon.set(LOWER_SPEED);
   }

   public void brake() {
    LiftFalcon.set(BRAKE);
   }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

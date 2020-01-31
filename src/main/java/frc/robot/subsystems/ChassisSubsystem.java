/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ChassisSubsystem extends SubsystemBase {
  /**
   * Creates a new ChassisSubsystem.
   */

  private WPI_TalonSRX chassis_motor = new WPI_TalonSRX(Constants.TALON_CHASSIS);
  
  private final static double VERTICAL_ADJUST_SPEED = .5;
  
  public ChassisSubsystem() {

  }

  public void raise_chassis() {
    chassis_motor.set(VERTICAL_ADJUST_SPEED);
  }

  public void lower_chassis() {
    chassis_motor.set(-VERTICAL_ADJUST_SPEED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
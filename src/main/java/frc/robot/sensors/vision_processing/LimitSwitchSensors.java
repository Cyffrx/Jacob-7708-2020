/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.sensors.vision_processing;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimitSwitchSensors extends SubsystemBase {
  /**
   * Creates a new LimitSwitchSensors.
   */

  public LimitSwitchSensors() {

  }

  public boolean isHigh() {
    //return limitSwitchHigh.get();
    return false;
  }

  public boolean isLow() {
    //return limitSwitchLow.get();
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

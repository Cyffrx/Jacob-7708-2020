/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.sensors.vision_processing;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LimelightSubsystem extends SubsystemBase {
  /**
   * Creates a new LimelightSubsystem.
   */

   NetworkTableEntry ledMode = Constants.LED_MODE;
   NetworkTableEntry camMode = Constants.CAM_MODE;
   NetworkTableEntry pipeline = Constants.PIPELINE;

   double validTarget = Constants.tv.getDouble(0.0);


  public LimelightSubsystem() {

  }

  public void visionMode() {
    camMode.setNumber(0); // sets camera to vision processing mode
    pipeline.setNumber(0);
  }

  public void driverMode() {
    camMode.setNumber(1); // sets camera to driving mode
    pipeline.setNumber(0);
  }

  /**
   * Forces on light
   */
  public void lightOn() {
    ledMode.setNumber(3);
  }

  /**
   * Forces off light
   */
  public void lightOff() {
    ledMode.setNumber(1);
  }

  /**
   * Changes light settings according to how vision pipeline is set
   */
  public void lightAuto() {
    ledMode.setNumber(0);
  }

  /**
   * Checks if there is no valid targets, which is then sent to isFinsished() 
   */
  public boolean noValidTarget() {
    if (validTarget == 0) {
      System.out.println("ERROR: Vision Target was lost");
      return true; 

    } else {
      return false;

    }
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

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

  private WPI_TalonSRX chassis_motor = new WPI_TalonSRX(Constants.CHASSIS_RAISE);
  
  private final static double VERTICAL_ADJUST_SPEED = .5;
  private final static double BRAKE = 0;
  
  public ChassisSubsystem() {

  }

  public void raise_chassis() {
      if (!true) //READS LIMIT SWITCH HIGH
        chassis_motor.set(BRAKE);
      else
        chassis_motor.set(VERTICAL_ADJUST_SPEED);
  }

  public void lower_chassis() {
      if (!true) //READS LIMIT SWITCH LOW
        chassis_motor.set(BRAKE);
      else
        chassis_motor.set(-VERTICAL_ADJUST_SPEED);
  }

  public void hold_chassis() {
    // potentially replace with a PID loop to keep at current setting
    chassis_motor.set(BRAKE);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

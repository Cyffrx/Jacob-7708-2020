/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ChassisSubsystem extends SubsystemBase {
  /**
   * Creates a new ChassisSubsystem
   */

  private WPI_TalonSRX chassis_motor = new WPI_TalonSRX(Constants.CHASSIS_RAISE);
  
  private DigitalInput limitSwitchHigh = new DigitalInput(Constants.LIFT_HIGH);
  private DigitalInput limitSwitchLow = new DigitalInput(Constants.LIFT_LOW);

  private final static double BRAKE = 0;
  
  public ChassisSubsystem() {

  }

  public boolean isHigh() {
    //return limitSwitchHigh.get();
    return true;
  }

  public boolean isLow() {
    //return limitSwitchLow.get();
    return true;
  }

  public void delta_chassis(double speed) {
    if (speed > 0) { // if limit is false and speed is over 0
      if (!isHigh())
        chassis_motor.set(speed*Constants.CHASSIS_VERTICAL_ADJUST_LIMIT);
      else
        hold_chassis();
    }
    else if (speed < 0) {
      if (!isLow())
        chassis_motor.set(speed*Constants.CHASSIS_VERTICAL_ADJUST_LIMIT);
      else
        hold_chassis();
    } else hold_chassis();
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

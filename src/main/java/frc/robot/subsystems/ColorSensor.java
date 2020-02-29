/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ColorSensor extends SubsystemBase {
  /**
   * Creates a new ColorSensor.
   */
  
   private TalonFX colorWheel = new TalonFX(Constants.COLOR_WHEEL);
   
   private DoubleSolenoid colorWheelSolenoid = new DoubleSolenoid(Constants.COLOR_WHEEL_FWD, Constants.COLOR_WHEEL_BKWD);

   private ColorSensor colorSensor = new ColorSensor();

   public ColorSensor() {
  }

  public void spinColorWheel() {
    //code
    

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

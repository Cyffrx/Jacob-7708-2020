/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.sensors.vision_processing.ColorSensor;

public class ColorWheelSubsystem extends SubsystemBase {
  /**
   * Creates a new ColorSensor.
   */
  
   private WPI_TalonFX colorWheel = new WPI_TalonFX(Constants.COLOR_WHEEL);
   
   private DoubleSolenoid colorWheelSolenoid = new DoubleSolenoid(Constants.COLOR_WHEEL_FWD, Constants.COLOR_WHEEL_BKWD);

   private ColorSensor colorSensor = new ColorSensor();

   public ColorWheelSubsystem() {
  }

  public void spinColorWheel() {
    //code
    colorWheel.set(Constants.COLOR_WHEEL_SPEED);


  }

  public void stopColorWheel() {
    colorWheel.set(0);    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

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

public class LiftSubsystem extends SubsystemBase {
  /**
   * Creates a new LiftSubsystem.
   */

  private static double RAISE_SPEED = .5;
  private static double BRAKE = 0;

   private WPI_TalonSRX LiftFalcon = new WPI_TalonSRX(Constants.LIFT);

   public LiftSubsystem() {

  }

  public void raiseRobot() {
    LiftFalcon.set(RAISE_SPEED);
   }

   public void brake() {
    LiftFalcon.set(BRAKE); // will likely need to be replaced with a PID subsystem to keep the robot's position on the bar
                           // also might need to remove safety feature of FMS so it does not fall from its suspension.
   }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

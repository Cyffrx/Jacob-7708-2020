/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeSubsystem.
   */

   private WPI_TalonFX intakeMotor = new WPI_TalonFX(Constants.INTAKE);

   DoubleSolenoid RSlider = new DoubleSolenoid(Constants.R_SLIDERAIL_FWD, Constants.R_SLIDERAIL_BKWD);
   DoubleSolenoid LSlider = new DoubleSolenoid(Constants.L_SLIDERAIL_FWD, Constants.L_SLIDERAIL_BKWD);
 
   private static final double SPEED = .2;
   private static final double STOP = 0;

  public IntakeSubsystem() {

    RSlider.set(Value.kForward);
    LSlider.set(Value.kForward);
  }

  public void slide() {
    if (RSlider.get() == Value.kForward) {
      RSlider.set(Value.kReverse);
      LSlider.set(Value.kReverse);  
    } else {
      RSlider.set(Value.kForward);
      LSlider.set(Value.kForward);  
    }
  }
  
  public void set_active() {
    intakeMotor.set(SPEED);
  }

  public void set_inactive() {
    intakeMotor.set(STOP);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

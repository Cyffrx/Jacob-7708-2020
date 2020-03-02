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

  private static final double STOP = 0;


   private WPI_TalonFX intakeMotor = new WPI_TalonFX(Constants.INTAKE);

   private DoubleSolenoid sliderail = new DoubleSolenoid(Constants.SLIDERAIL_FWD, Constants.SLIDERAIL_BKWD);

   ///public LimitSwitchSensors limitSwitches = new LimitSwitchSensors();



  public IntakeSubsystem() {
    sliderail.set(Value.kReverse);
  }
  

  public void sliderail_toggle() {
    if (sliderail.get() == Value.kReverse && true/*!limitSwitches.isLow()*/) {
      //needs to check if low limit switch is activated
      sliderail.set(Value.kForward);
    } else {
      sliderail.set(Value.kReverse);
    }
  }
  
  public void intake() {
    intakeMotor.set(Constants.INTAKE_SPEED*Constants.INTAKE_LIMIT);
  }

  public void outtake() {
    intakeMotor.set(-1 * Constants.INTAKE_SPEED*Constants.INTAKE_LIMIT);
  }

  public void passivelyIndex() {
    intakeMotor.set(Constants.INTAKE_INDEX_SPEED*Constants.INTAKE_LIMIT);
  }


  public void stop() {
    intakeMotor.set(STOP);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

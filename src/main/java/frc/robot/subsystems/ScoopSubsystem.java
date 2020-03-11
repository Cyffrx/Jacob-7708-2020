/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ScoopSubsystem extends SubsystemBase {
  /**
   * Creates a new CellScoppSubsystem.
   */

   private WPI_TalonFX scoop = new WPI_TalonFX(Constants.CELL_SCOOP);

   //public DoubleSolenoid deployScoop = new DoubleSolenoid(Constants.DEPLOY_SCOOP, Constants.RETRACT_SCOOP);

  public ScoopSubsystem() {
    //deployScoop.set(Value.kReverse);
    scoop.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 60, 65, 0.25));

  }

  public void toggleDeploy() {
    /*
    if (deployScoop.get() == Value.kReverse)
      deployScoop.set(Value.kForward);
    else
      deployScoop.set(Value.kReverse);
      */
    
  }

  public void intake() {
    scoop.set(Constants.SCOOP_SPEED);
  }

  public void outtake() {
    scoop.set(-1*Constants.SCOOP_SPEED);
  }

  public void stopMotor() {
    scoop.set(0);
  }

  /*
  public Value getScoopStatus() {
    return deployScoop.get();
  }
*/

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

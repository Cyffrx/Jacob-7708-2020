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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DrivetrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DrivetrainSub.
   */

  private static double debug_limiter = 1;

  private WPI_TalonFX RFalcon_Leader = new WPI_TalonFX(Constants.DT_RIGHT_FALCON_LEADER);
  private WPI_TalonFX RFalcon_1 = new WPI_TalonFX(Constants.DT_RIGHT_FALCON_1);
  private WPI_TalonFX RFalcon_2 = new WPI_TalonFX(Constants.DT_RIGHT_FALCON_2);
  
  private WPI_TalonFX LFalcon_Leader = new WPI_TalonFX(Constants.DT_LEFT_FALCON_LEADER);
  private WPI_TalonFX LFalcon_1 = new WPI_TalonFX(Constants.DT_LEFT_FALCON_1);
  private WPI_TalonFX LFalcon_2 = new WPI_TalonFX(Constants.DT_LEFT_FALCON_2);

  DoubleSolenoid RGearbox = new DoubleSolenoid(Constants.R_GEARBOX_SHIFT_FWD, Constants.R_GEARBOX_SHIFT_BKWD);
  DoubleSolenoid LGearbox = new DoubleSolenoid(Constants.L_GEARBOX_SHIFT_FWD, Constants.L_GEARBOX_SHIFT_BKWD);

  
  
  private DifferentialDrive drivetrain = new DifferentialDrive(LFalcon_Leader, RFalcon_Leader);
  
  
  public DrivetrainSubsystem() {
    RGearbox.set(Value.kForward);
    LGearbox.set(Value.kForward);

    RFalcon_Leader.setInverted(true);

    RFalcon_1.setInverted(false);
    RFalcon_2.setInverted(false);

    RFalcon_1.follow(RFalcon_Leader);
    RFalcon_2.follow(RFalcon_Leader);


    LFalcon_Leader.setInverted(true);
    LFalcon_1.setInverted(false);
    LFalcon_2.setInverted(false);

    LFalcon_1.follow(LFalcon_Leader);
    LFalcon_2.follow(LFalcon_Leader);
  
  }

  public void shift() {
    if (RGearbox.get() == Value.kForward) {
      RGearbox.set(Value.kReverse);
      LGearbox.set(Value.kReverse);  
    } else {
      RGearbox.set(Value.kForward);
      LGearbox.set(Value.kForward);  
    }
  }
  
  public void cheezy_drive(double move, double turn) {

    drivetrain.curvatureDrive(
      move*debug_limiter,
      turn*debug_limiter,
      true
    );

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

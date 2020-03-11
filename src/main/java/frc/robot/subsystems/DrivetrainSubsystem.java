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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DrivetrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DrivetrainSub.
   */

  private WPI_TalonFX RFalcon_Leader = new WPI_TalonFX(Constants.DT_RIGHT_FALCON_LEADER);
  private WPI_TalonFX RFalcon_1 = new WPI_TalonFX(Constants.DT_RIGHT_FALCON_1);
  private WPI_TalonFX RFalcon_2 = new WPI_TalonFX(Constants.DT_RIGHT_FALCON_2);
  
  private WPI_TalonFX LFalcon_Leader = new WPI_TalonFX(Constants.DT_LEFT_FALCON_LEADER);
  private WPI_TalonFX LFalcon_1 = new WPI_TalonFX(Constants.DT_LEFT_FALCON_1);
  private WPI_TalonFX LFalcon_2 = new WPI_TalonFX(Constants.DT_LEFT_FALCON_2);

//  private DoubleSolenoid gearshift = new DoubleSolenoid(Constants.GEARSHIFT_FWD, Constants.GEARSHIFT_BKWD);
  
  private DifferentialDrive drivetrain = new DifferentialDrive(LFalcon_Leader, RFalcon_Leader);
  
  
  public DrivetrainSubsystem() {
//    gearshift.set(Value.kForward);

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

    
/**
  * Configure the current limits that will be used
  * Stator Current is the current that passes through the motor stators.
  *  Use stator current limits to limit rotor acceleration/heat production
  * Supply Current is the current that passes into the controller from the supply
  *  Use supply current limits to prevent breakers from tripping
  *
  *                                                               enabled | Limit(amp) | Trigger Threshold(amp) | Trigger Threshold Time(s)  */

    RFalcon_Leader.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 60, 65, 0.25));
    RFalcon_1.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 60, 65, 0.25));
    RFalcon_2.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 60, 65, 0.25));

    LFalcon_Leader.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 60, 65, 0.25));
    LFalcon_1.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 60, 65, 0.25));
    LFalcon_2.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, 60, 65, 0.25));

  }

  public void shift() {
    /*
    if (gearshift.get() == Value.kForward) {
      gearshift.set(Value.kReverse);
    } else {
      gearshift.set(Value.kForward);  
    }
    */
  }
  
  public void cheezy_drive(double move, double turn) {

    drivetrain.curvatureDrive(
      move*Constants.DRIVETRAIN_LIMIT,
      turn*Constants.DRIVETRAIN_LIMIT*Constants.DRIVETRAIN_TURN_LIMIT,
      true
    );

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

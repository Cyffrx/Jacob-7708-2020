/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DrivetrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DrivetrainSub.
   */

  private WPI_TalonSRX RFalcon_Leader = new WPI_TalonSRX(Constants.DT_RIGHT_FALCON_LEADER);
  private WPI_TalonSRX RFalcon_1 = new WPI_TalonSRX(Constants.DT_RIGHT_FALCON_1);
  private WPI_TalonSRX RFalcon_2 = new WPI_TalonSRX(Constants.DT_RIGHT_FALCON_2);
  
  private WPI_TalonSRX LFalcon_Leader = new WPI_TalonSRX(Constants.DT_LEFT_FALCON_LEADER);
  private WPI_TalonSRX LFalcon_1 = new WPI_TalonSRX(Constants.DT_LEFT_FALCON_1);
  private WPI_TalonSRX LFalcon_2 = new WPI_TalonSRX(Constants.DT_LEFT_FALCON_2);
  
  private DifferentialDrive drive_logic = new DifferentialDrive(LFalcon_Leader, RFalcon_Leader);
  //private double turn_limiter = .70;
  
  public DrivetrainSubsystem() {
    RFalcon_Leader.setInverted(false);
    RFalcon_1.setInverted(true);
    RFalcon_2.setInverted(true);

    RFalcon_1.follow(RFalcon_Leader);
    RFalcon_2.follow(RFalcon_Leader);

    LFalcon_Leader.setInverted(false);
    LFalcon_1.setInverted(true);
    LFalcon_2.setInverted(true);

    LFalcon_1.follow(LFalcon_Leader);
    LFalcon_2.follow(LFalcon_Leader);
  }

  public void cheezy_drive(double move, double turn) {

    drive_logic.curvatureDrive(
      move,
      turn,
      true
    );
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

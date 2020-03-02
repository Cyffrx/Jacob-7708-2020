/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    public static final int DVT_GAMEPAD = 0;
    public static final int SHT_GAMEPAD = 1;

    /// MOTOR PORTS ///

    public static final int DT_RIGHT_FALCON_LEADER = 1;
    public static final int DT_RIGHT_FALCON_1 = 2;
    public static final int DT_RIGHT_FALCON_2 = 3;

    public static final int DT_LEFT_FALCON_LEADER = 4;
    public static final int DT_LEFT_FALCON_1 = 5;
    public static final int DT_LEFT_FALCON_2 = 6;

    public static final int SHOOTER_FALCON_MASTER = 10;
    public static final int SHOOTER_FALCON_SLAVE = 11;
    public static final int INTAKE = 8;
    public static final int INDEXER = 9;
    public static final int CHASSIS_RAISE = 7;
    
    public static final int LIFT = 13;

    public static final int COLOR_WHEEL = 12;    

    /// PNEUMATICS ///

    public static final int GEARSHIFT_FWD = 1;
    public static final int GEARSHIFT_BKWD = 2;

    public static final int SLIDERAIL_FWD= 0;
    public static final int SLIDERAIL_BKWD= 7;

    public static final int COLOR_WHEEL_FWD = 6;
    public static final int COLOR_WHEEL_BKWD = 5;    

    public static final int HANG_LOCK_HOLD = 4;
    public static final int HANG_LOCK_RELEASE = 3;

    /// DIGITIAL INPUT ///

    public static final int LIMIT_SWITCH_HIGH = 0;
    public static final int LIMIT_SWITCH_LOW = 1;


    /// SPEEDS ///

    public static final double INTAKE_SPEED = .7;
    public static final double INTAKE_INDEX_SPEED = .25;
    public static final double INDEX_SPEED = .8;
    public static final double FLYWHEEL_SPEED = .8;
    public static final double FLYWHEEL_COAST_SPEED = FLYWHEEL_SPEED / 2;
    public static final double COLOR_WHEEL_SPEED = 0.08;
    public static final double LIFT_WINCH_SPEED = .5;


    /// LIMITERS ///

    public static final double DRIVETRAIN_LIMIT = .45;
    public static final double FLYWHEEL_LIMIT = .5;
    public static final double INDEXER_LIMIT = .5;  
    public static final double INTAKE_LIMIT = 1;
    public static final double CHASSIS_VERTICAL_ADJUST_LIMIT = -.5;

    /// Colors ///

    public static final class WheelColors {
        public static final Color BLUE = new Color(0.143, 0.427, 0.429);
        public static final Color GREEN = new Color(0.197, 0.561, 0.240);
        public static final Color RED = new Color(0.561, 0.232, 0.114);
        public static final Color YELLOW = new Color(0.361, 0.524, 0.113);
    }

    /// time ////
    
    public static double MATCH_TIME = 0;

    /// VISION ///

    public static final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    // public static final NetworkTableEntry tmx = table.getEntry("tx");
    public static final NetworkTableEntry ty = table.getEntry("ty");
    public static final NetworkTableEntry ta = table.getEntry("ta");
    public static final NetworkTableEntry tv = table.getEntry("tv");

    public static final NetworkTableEntry LED_MODE = table.getEntry("ledMode");
    public static final NetworkTableEntry CAM_MODE = table.getEntry("camMode");
    public static final NetworkTableEntry PIPELINE = table.getEntry("pipeline");
    
    public static final double cameraHeightInches = 0; // 15 inches

    public static final double cameraMountingAngle = 0; // 17.2 degrees

    public static final double visionTargetHeightLow = 0; // X feet, Y inches
    public static final double visionTargetHeightHigh = 0; // X feet, Y inches

}
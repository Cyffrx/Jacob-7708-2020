package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ChassisCommand;
import frc.robot.commands.DrivetrainCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LiftCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.sensors.vision_processing.LimelightSubsystem;
import frc.robot.subsystems.ChassisSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  
  // The robot's subsystems and commands are defined here...

  //  Subsystems
  private DrivetrainSubsystem mDrivetrain = new DrivetrainSubsystem();
  private ShooterSubsystem mShooter = new ShooterSubsystem();
  private LiftSubsystem mLift = new LiftSubsystem();
  private ChassisSubsystem mChassis = new ChassisSubsystem();
  private IndexerSubsystem mIndexer = new IndexerSubsystem();
  private IntakeSubsystem mIntake = new IntakeSubsystem();
  
  private LimelightSubsystem mLimelight = new LimelightSubsystem();

  //  Commands

  // Controller
  XboxController ControllerMaster = new XboxController(Constants.DVT_GAMEPAD);
  XboxController ControllerShooter = new XboxController(Constants.SHT_GAMEPAD);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    mDrivetrain.setDefaultCommand(
      new DrivetrainCommand(
        mDrivetrain,
        () -> ControllerMaster.getY(GenericHID.Hand.kLeft), // power
        () -> ControllerMaster.getX(GenericHID.Hand.kRight), // rotation
        () -> ControllerMaster.getAButtonReleased() // gearshift
        )
    );


    mLift.setDefaultCommand(
      new LiftCommand(mLift,
      () -> ControllerMaster.getPOV() // lift dpad
      )
    );

    mChassis.setDefaultCommand(
      new ChassisCommand (
        mChassis,
        () -> ControllerMaster.getBButton(), // move chassis up
        () -> ControllerMaster.getXButton() // move chassis down
      )
    );

    mIntake.setDefaultCommand(
      new IntakeCommand (
        mIntake,
        () -> ControllerMaster.getBumper(GenericHID.Hand.kLeft), // toggle intake
        () -> ControllerMaster.getXButtonReleased() // slide toggle
    )
    );


    mShooter.setDefaultCommand(
      new ShootCommand (
        mShooter,
        mIndexer,
        () -> ControllerShooter.getBumper(GenericHID.Hand.kRight), // shoot
        () -> ControllerShooter.getBumper(GenericHID.Hand.kRight) // shoot
        
      )
    );

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.622
1   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DrivetrainCommand;
import frc.robot.commands.LiftCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.ScoopSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;

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
  private LiftSubsystem mLift = new LiftSubsystem();
  private ScoopSubsystem mScoop = new ScoopSubsystem();


  // Controller
  XboxController ControllerDriver = new XboxController(Constants.DVT_GAMEPAD);
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
        () -> ControllerDriver.getY(GenericHID.Hand.kLeft), // power
        () -> ControllerDriver.getX(GenericHID.Hand.kRight), // rotation
        () -> ControllerDriver.getAButtonReleased(), // gearshift
        () -> ControllerDriver.getYButtonPressed() // invert drivetrain
        )
    );


    mLift.setDefaultCommand(
      new LiftCommand(mLift, mScoop,
      () -> ControllerDriver.getPOV(), // lift dpad
      () -> ControllerDriver.getBumper(GenericHID.Hand.kLeft)
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

  public DrivetrainSubsystem returnDrivetrain() {
    return mDrivetrain;
  }
}

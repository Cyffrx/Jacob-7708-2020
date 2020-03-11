/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ColorWheelSubsystem extends SubsystemBase {
//sensors & sensor-sensors
  private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);;
  private final ColorMatch colorMatch = new ColorMatch();
//motor
  private final WPI_TalonFX colorWheel = new WPI_TalonFX(Constants.COLOR_WHEEL);;

//vars
  private Color detectedColor;
  private int colorCount;
  private String colorStr;
  private String desiredColor;
  //private int rawIr;
//colors
  private final Color kBlue = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreen = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRed = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellow = ColorMatch.makeColor(0.361, 0.524, 0.113);
  
  public ColorWheelSubsystem() {
 
    colorMatch.addColorMatch(kBlue);
    colorMatch.addColorMatch(kGreen);
    colorMatch.addColorMatch(kRed);
    colorMatch.addColorMatch(kYellow);

    //rawIr = colorSensor.getIR();
    colorCount = 0;
  }

  @Override
  public void periodic() {
    detectedColor = colorSensor.getColor();

    ColorMatchResult currentColor = colorMatch.matchClosestColor(detectedColor);

    if(currentColor.color == kBlue){
      colorStr = "Blue";
    } else if(currentColor.color == kRed){
      colorStr = "Red";
    } else if(currentColor.color == kYellow){
      colorStr = "Yellow";
    } else if(currentColor.color == kGreen){
      colorStr = "Green";
    } else {
      colorStr = "IDK Bro";
    }

    String neededColor = SmartDashboard.getString("Control Color", "u");


    //Im not insane, 90 degree offset based off of where their color sensor is compared to ours

    if(neededColor == "B"){
      desiredColor = "Red";
    } else if(neededColor == "R"){
      desiredColor = "Blue";
    } else if(neededColor == "Y"){
      desiredColor = "Green";
    } else if(neededColor == "G") {
      desiredColor = "Yellow";
    }

    SmartDashboard.putString("Detected Color", colorStr);
    SmartDashboard.putNumber("Confidence", currentColor.confidence);
  }

  //Spins the wheel for 3 rotations and matches color
  //We see the color once, two colors per rotation, land on it at 7

  public synchronized void matchColor(){
    if(colorStr == desiredColor){
      colorCount += 1;
    }    

    if(colorCount < 7){
      colorWheel.set(ControlMode.PercentOutput, .8);
    } else {
      colorWheel.set(ControlMode.PercentOutput, 0);
      System.out.println("At Color");
    }

    System.out.println(desiredColor);
  } 
}
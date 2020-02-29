/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.sensors.vision_processing;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants;
import frc.robot.Constants.WheelColors;

public class ColorSensorSubsystem {
    public ColorSensorSubsystem(Port konboard) {
    }

    private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
    private final ColorMatch colorMatcher = new ColorMatch();

    public ColorSensorSubsystem() {
        colorMatcher.addColorMatch(WheelColors.BLUE);
        colorMatcher.addColorMatch(WheelColors.GREEN);
        colorMatcher.addColorMatch(WheelColors.RED);
        colorMatcher.addColorMatch(WheelColors.YELLOW);
    }

    public Color getColorOfWheel() {
        ColorMatchResult matchedColor = colorMatcher.matchClosestColor(colorSensor.getColor());

        if (matchedColor.color == Constants.WheelColors.BLUE)
            return Constants.WheelColors.BLUE;
        else if (matchedColor.color == WheelColors.GREEN)
            return Constants.WheelColors.GREEN;
        else if (matchedColor.color == WheelColors.RED)
            return Constants.WheelColors.RED;
        else if (matchedColor.color == WheelColors.YELLOW)
            return Constants.WheelColors.YELLOW;
        else
            return null;

    }

}
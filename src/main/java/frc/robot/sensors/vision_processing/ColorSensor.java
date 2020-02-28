/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.sensors.vision_processing;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revroborics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants.WheelColors;

public class ColorSensor {
    public ColorSensor(Port konboard) {
    }

    private final ColorSensorV3 _colorSensor = new ColorSensor(I2C.Port.kOnboard);
    private final ColorMatch _colorMatcher = new ColorMatch();
}

public ColorSensor() {
    _colorMatcher.addColorMatch(WheelColors.BLUE);
    _colorMatcher.addColorMatch(WheelColors.GREEN);
    _colorMatcher.addColorMatch(WheelColors.RED);
    _colorMatcher.addColorMatch(WheelColors.YELLOW);
}

public Color getRawColor() {
    return _colorSensor.getColor()
}

public WheelColor getStripColor() {
    ColorMatchResult = _colorMatcher.matchClosestColor.getColor();

    if (colorMatchResult.color) == WheelColors.BLUE) {
    return WheelColor.BLUE;
 } else if (colorMatchResult.color) == WheelColors.GREEN) {
    return WheelColor.GREEN;
} else if (colorMatchResult.color) == WheelColors.RED) {
return WheelColor.RED;
} else if (colorMatchResult.color) == WheelColors.YELLOW) {
return WheelColor.YELLOW;
 } else {
     return WheelColor.UNKNOWN;
     }
}

enum WheelColor {
    BLUE, GREEN, RED, YELLOW, UNKNOWN
 }
}
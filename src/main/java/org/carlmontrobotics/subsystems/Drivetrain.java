// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import org.carlmontrobotics.Constants.*;

import com.revrobotics.CANSparkMax;
import org.carlmontrobotics.subsystems.*;
import static org.carlmontrobotics.Constants.Drivetrain.*;
import static org.carlmontrobotics.RobotContainer.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.carlmontrobotics.RobotContainer.*;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  //private final CANSparkMax left = MotorControllerFactory.createSparkMax(Constants.Driver.leftDriveSparkMax, TemperatureLimit.NEO);
  //private final CANSparkMax right = MotorControllerFactory.createSparkMax(Constants.MotorPorts.rightDriveSparkMax, TemperatureLimit.NEO);
  private final CANSparkMax right = MotorControllerFactory.createSparkMax(LEFT_PORT, MotorConfig.NEO);
  private final CANSparkMax left = MotorControllerFactory.createSparkMax(RIGHT_PORT, MotorConfig.NEO);//TODO: fix import or gradle issue pls
  private final XboxController controller;
  
  public Drivetrain(XboxController driverController) {
    this.controller = driverController;
  }

  public void drive(double rightJoystickValue, double leftJoystickValue) {}

  public void autoDrive() {}

  @Override
  public void periodic() {}
}

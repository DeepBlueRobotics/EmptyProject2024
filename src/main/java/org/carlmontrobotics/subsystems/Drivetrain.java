// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import org.carlmontrobotics.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import org.carlmontrobotics.subsystems.*;
import static org.carlmontrobotics.Constants.Drivetrainc.*;
import static org.carlmontrobotics.RobotContainer.*;

import org.carlmontrobotics.Constants;

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
  private boolean isAuto = false;
  
  private final CANSparkMax right = MotorControllerFactory.createSparkMax(LEFTDT_PORT, MotorConfig.NEO);
  private final CANSparkMax left = MotorControllerFactory.createSparkMax(RIGHTDT_PORT, MotorConfig.NEO);
  private RelativeEncoder rightEncoder = right.getEncoder();
  private final XboxController controller;
  
  public Drivetrain(XboxController driverController) {
    this.controller = driverController;
  }
  public void drive(double rightJoystickValue, double leftJoystickValue) {
    //TODO: If needed, set inversions for motors
    left.set(leftJoystickValue);
    right.set(rightJoystickValue);
  }
  public void slowmode() {
      double rightSlow = controller.getRightY() * Constants.Drivetrainc.halfDriveSpeedMultiplier;
      double leftSlow = controller.getLeftY() * Constants.Drivetrainc.halfDriveSpeedMultiplier;
      left.set(leftSlow);
      right.set(rightSlow);
  }


  public double rightPosition() {
    return rightEncoder.getPosition();
  }
  public void setAuto(boolean isAutonomous) {
    isAuto = isAutonomous;
  }
  public void autoDrive() {
    left.set(0.3);
    right.set(0.3);
  }
  

  @Override
  public void periodic() {}
}

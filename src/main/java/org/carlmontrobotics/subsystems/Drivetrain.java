// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import org.carlmontrobotics.Constants.*;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax leftMotor = MotorControllerFactory.createSparkMax(Drivetrainc.LEFT_PORT, MotorConfig.NEO);
  private CANSparkMax rightMotor = MotorControllerFactory.createSparkMax(Drivetrainc.RIGHT_PORT, MotorConfig.NEO);
  private XboxController controller;
  private boolean isTank = true;


  /** Creates a new Drivetrain. */
  public Drivetrain(XboxController controller) {
    this.controller = controller;
  }

  @Override
  public void periodic() {
    if (isTank) {
      tankDrive(controller.getLeftY(), controller.getRightY());
    }
    else {
      arcadeDrive(controller.getLeftY(), controller.getRightX());
    }
  }

  public void tankDrive(double leftY, double rightY) {
    leftMotor.set(leftY);
    rightMotor.set(-rightY);
  }

  public void arcadeDrive(double speed, double turn) {
    double left = speed + turn;
    double right = speed - turn;
    leftMotor.set(left);
    rightMotor.set(right); 
  }

  public void switchMode() {
    isTank = !isTank;
  }
}

//hello
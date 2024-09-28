// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics;

//199 files
// import org.carlmontrobotics.subsystems.*;
// import org.carlmontrobotics.commands.*;

import org.carlmontrobotics.Constants.*;
import org.carlmontrobotics.commands.Autonomous;

//controllers
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;

//commands
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

//control bindings
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import org.carlmontrobotics.subsystems.Drivetrain;


public class RobotContainer {

  //1. using GenericHID allows us to use different kinds of controllers
  //2. Use absolute paths from constants to reduce confusion
  private final XboxController driverController = new XboxController(Constants.Driver.DRIVER_CONTROLLER_PORT);
  private final XboxController manipulatorController = new XboxController(Constants.Manipulator.MANIPULATOR_CONTROLLER_PORT);
  private final Drivetrain drivetrain = new Drivetrain(driverController);

  public RobotContainer() {
    setDefaultCommands();
    setBindingsDriver();
    setBindingsManipulator();
  }

  private void setDefaultCommands() {

  }
  private void setBindingsDriver() {

  }
  private void setBindingsManipulator() {
    
  }



  public double rightJoystickValue() {
    return driverController.getRightX();
  }
  public double leftJoystickValue() {
    return driverController.getLeftY();
  }



  public Command getAutonomousCommand() {
    return new Autonomous(drivetrain);
  }
}

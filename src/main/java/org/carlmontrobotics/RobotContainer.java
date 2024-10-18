// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics;

import static org.carlmontrobotics.Constants.OI;

import org.carlmontrobotics.commands.Autonomous;
import org.carlmontrobotics.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {

  public static final XboxController controller = new XboxController(OI.port);
  public static final Drivetrain drivetrain = new Drivetrain(controller);

  public RobotContainer() {
    setBindings();
  }

  private void setBindings() {
    new JoystickButton(controller, Constants.OI.BUTTON_X).onTrue(new InstantCommand(() -> drivetrain.switchMode()));
  }

  public Command getAutonomousCommand() {
    return new Autonomous(drivetrain);
  }

}

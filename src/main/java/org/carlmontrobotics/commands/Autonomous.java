// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.carlmontrobotics.commands;

import edu.wpi.first.wpilibj2.command.Command;

import org.carlmontrobotics.Constants;
import org.carlmontrobotics.subsystems.Drivetrain;

public class Autonomous extends Command {
  /** Creates a new Autonomous. */
  private final Drivetrain dt;

  public Autonomous(Drivetrain drivetrain) {
    addRequirements(dt = drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dt.setAuto(true);
    dt.autoDrive();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dt.setAuto(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return dt.rightPosition() * (Constants.Drivetrainc.WHEEL_RADIUS*2) >= (Constants.Drivetrainc.GOAL_FEET)/12;
    //TODO: for MA, change wheel radius and goal pos if needed
  }
}

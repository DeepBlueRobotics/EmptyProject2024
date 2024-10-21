package org.carlmontrobotics.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static org.carlmontrobotics.Constants.*;
import static org.carlmontrobotics.Constants.DrivetrainC.*;
import static org.carlmontrobotics.Constants.OI.*;
public class Drivetrain extends SubsystemBase{
    
    int port3;
    DrivetrainC drivetrain = new DrivetrainC();
    CANSparkMax leftMotor = MotorControllerFactory.createSparkMax(leftmotorport, MotorConfig.NEO);
    CANSparkMax rightMotor = MotorControllerFactory.createSparkMax(rightmotorport, MotorConfig.NEO);
    private XboxController controller = new XboxController(XBOX_CONTROLLER_PORT);

    public void drive(){
        double leftspeed = controller.getLeftY();
        double rightspeed = controller.getRightY();
        leftMotor.set(leftspeed);
        rightMotor.set(rightspeed);
        
        
    }

    public void arcadedrive(double speed, double turn){
        /* 
        double speed = controller.getLeftY();
        double turn = controller.getRightX(); */
        /* 
        speed = controller.getLeftY();
        turn = controller.getRightX(); */
        leftMotor.set(speed + turn);
        rightMotor.set(speed - turn);

    }
    

    
    
}

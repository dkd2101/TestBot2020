/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Imports begin - Zack

package frc.robot.subsystems;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//Imports end - Zack


/**
 * Add your docs here.
 */
public class Turret extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // I think this is where I put the functions - Zack

  //periodic does this periodically I assume? -Zack
  @Override
  public void periodic() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    //Creation of first object (SRX motor) - Zack
    TalonSRX myTalon = new TalonSRX(0);

    // Overide followed with initialization of the motor at 0 output and then start to accelerate the motor - Zack
    @Override
    public void initialize() {

      myTalon.set(ControlMode.PercentOutput, 0);

      myTalon.configMotionAcceleration(5);



    }


    // Overide with stop function - Zack
    @Override
    public void stop() {
      // integer stop Voltage with generic voltage for testing - Zack
      int stopVoltage = 60;
      //integer set to current Voltage using myTalon.getMotorOutputVoltage(); - Zack
      int currentVoltage = myTalon.getMotorOutputVoltage();

      //if then statement, if currentVoltage is greater than or equal to the required stop voltage, set acceleration to 0 and set control output percent to 0 - Zack
      if (currentVoltage >= stopVoltage) {
        myTalon.configMotionAcceleration(0);
        myTalon.set(ControlMode.PercentOutput, 0);
      }


    } 

  }
}

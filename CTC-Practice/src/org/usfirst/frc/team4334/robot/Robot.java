package org.usfirst.frc.team4334.robot;

import org.usfirst.frc.team4334.actuators.SuperJoystickModule;
import org.usfirst.frc.team4334.actuators.TankDrivetrain;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Victor;

public class Robot extends IterativeRobot {
    
    private final Victor L1 = new Victor(Ports.LEFT_MOTOR_1);
    private final Victor L2 = new Victor(Ports.LEFT_MOTOR_2);
    private final Victor R1 = new Victor(Ports.RIGHT_MOTOR_1);
    private final Victor R2 = new Victor(Ports.RIGHT_MOTOR_2);
    
    private final DigitalInput limitSwitch = new DigitalInput(Ports.LIMIT_SWITCH);
    
    private final TankDrivetrain drivetrain = new TankDrivetrain(L1, L2, R1, R2);
    
    private final SuperJoystickModule driver = new SuperJoystickModule(Ports.JOYSTICK_1);
    private final SuperJoystickModule operator = new SuperJoystickModule(Ports.JOYSTICK_2);
    
    public void robotInit() {
        
    }
    
    public void autonomousInit() {
    	
    }

    public void autonomousPeriodic() {
    	
    }

    public void teleopPeriodic() {
        drivetrain.getHalo(driver.getAxis(4, 0.17, 1),
                           driver.getAxis(1, 0.17, -1), 1, 0.74);
        
        Arm.setIntake(operator.getAxis(1, 0.17, -1));
        if(!limitSwitch.get()) {
            if(operator.getAxis(5, 0.17, -1) >= 0) {
                Arm.setArm(operator.getAxis(5, 0.17, -1));
            }
            else {
                Arm.setArm(0);
            }
        }
        else {
            Arm.setArm(operator.getAxis(5, 0.17, -1));
        }
    }
    
    public void testPeriodic() {
    
    }
    
    public void disabledPeriodic() {
        
    }
    
}

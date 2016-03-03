package org.usfirst.frc.team4334.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

public class Arm {

    private static final Talon armLeft = new Talon(Ports.ARM_MOTOR_LEFT);
    private static final Talon armRight = new Talon(Ports.ARM_MOTOR_RIGHT);
    private static final Victor armIntake = new Victor(Ports.INTAKE_MOTOR);
    
    public static void setIntake(double pow) {
        armIntake.set(-pow);
    }
    
    public static void setArm(double pow) {
        armLeft.set(pow);
        armRight.set(-pow);
    }
    
    public static void disable() {
        armLeft.set(0);
        armRight.set(0);
        armIntake.set(0);
    }
    
}

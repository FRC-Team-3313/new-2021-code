package frc.robot;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.TimedRobot;
import jdk.dynalink.beans.StaticClass;

import com.revrobotics.CANEncoder;

public class Autonomous extends TimedRobot {

    public static final double kDistancePerRevolution = 42.0; // distance per ticks (or revolution)
    public static final double kPulsesPerRevolution = 2048; // ticks per revolution
    public static final double kDistancePerPulse = kDistancePerRevolution / kPulsesPerRevolution;

    private CANSparkMax leftRearMotor;
    private CANSparkMax rightRearMotor;
    private CANSparkMax leftFrontMotor;
    private CANSparkMax rightFrontMotor;
    private CANEncoder driveEncoder;
    // Motor configuration

    public void robotInit() {
        driveEncoder.setDistancePerPulse(kDistancePerPulse);

        driveEncoder.start();

        resetEncoders();
    }

    private void resetEncoders() {
    }

    @Override
    public void autonomousInit() {
        // this is called once when the robot first enters autonomous

        resetEncoders();
        Object drive;
        do {
            drive.arcadeDrive(0.5, 0.0);
        } while (getAverageEncoderPosition() < 50.0);
        drive.arcadeDrive(0.0, 0.0);

    }

    private double getAverageEncoderPosition() {
        return (driveEncoder.getDistance()) / 2;
        resetEncoders();
        driveEncoder.reset();

    }

    @Override
    public void autonomousPeriodic() {
        // this is called ocasioncally while the robot is in autonomous mode

    }

}
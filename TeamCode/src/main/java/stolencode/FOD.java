package stolencode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.notstolencode.Devices;

public class FOD {
    //Declare classes
    Devices dev;
    //Identify other classes
    public FOD(Devices dev) {
        this.dev = dev;
    }

    //Resetting IMU
    public void resetOrientation(){dev.imu.resetYaw();}
    //All of the Driving Components
    public void FODDrive(double y, double x, double rx, double ry, double power) {
        //Speed multiplier
        x *= 1;
        y *= 1;
        rx *= 1.1;

        //Gets the direction the robot is facing (yaw)
        double orientation = dev.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        rx = FlickStickRXCalc(orientation, rx, ry);

        //Math to decide how the robot will move (with its current orientation)
        double fodStrafe = x * Math.cos(-orientation) - y * Math.sin(-orientation);
        double fodForward = x * Math.sin(-orientation) + y * Math.cos(-orientation);

        //Math to set the power/speed of the motors
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1); // Makes sure power <= maxSpeed
        double FLPower = (fodForward + fodStrafe + rx) / denominator;
        double BLPower = (fodForward - fodStrafe + rx) / denominator;
        double FRPower = (fodForward - fodStrafe - rx) / denominator;
        double BRPower = (fodForward + fodStrafe - rx) / denominator;

        //Engage the motors
        dev.FLMotor.setPower(FLPower * power);
        dev.FRMotor.setPower(FRPower * power);
        dev.BLMotor.setPower(BLPower * power);
        dev.BRMotor.setPower(BRPower * power);
    }
    // stolen code ends here, i write this stuff ↓
    double FlickStickRXCalc(double botOrientation, double joystickX, double joystickY){ // calc is short for calculator if you didn't know
        double joystickOrientation = Math.atan2(-joystickX,joystickY);
        double turnPower = 0;

        if (Math.abs(joystickX) > 0.4 || Math.abs(joystickY) > 0.4) {
            //if (botOrientation - joystickOrientation > 0.02 || botOrientation - joystickOrientation < -0.02) { // if the difference of botOrientation and joystickOrientation is positive, turning value is positive
                turnPower = 1 * (botOrientation - joystickOrientation);
            //}
        }

        return turnPower;
    }
}

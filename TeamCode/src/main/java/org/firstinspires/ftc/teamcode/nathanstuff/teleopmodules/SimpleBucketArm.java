package org.firstinspires.ftc.teamcode.nathanstuff.teleopmodules;

import org.firstinspires.ftc.teamcode.nathanstuff.Arm;
import org.firstinspires.ftc.teamcode.nathanstuff.ArmPosition;
import org.firstinspires.ftc.teamcode.nathanstuff.Claw;

public class SimpleBucketArm {
    private Arm arm;
    private Claw claw;

    public double distance = 0;
    public int[] distanceRange = {0, 100};

    public double wormGearHeight = 0; // TODO: Measure worm gear height
    public double desiredClawHeight = 0; // TODO: Measure desired claw height for easy sample grab

    public SimpleBucketArm(Arm arm, Claw claw) {
        this.arm = arm;
        this.claw = claw;
    }

    private void moveArmAndClawForDistance(double distance) {
        ArmPosition newPosition = new ArmPosition();
        newPosition.setSlides(calculateSlidesExtensionForDistance(distance));
        newPosition.setWormGear(calculateWormGearTicksForDistance(distance));

        arm.setArmPosition(newPosition);

        claw.setWristPitch(calculateServoPitchForDistance(distance));
    }

    public void engage() {
        distance = 0;

        claw.open();

        moveArmAndClawForDistance(distance);
    }

    private int calculateWormGearTicksForDistance(double distance) {
        int ticksPerRadian = 0; // TODO: Figure out the amount of DCMotor ticks per degree of rotation.

        return (int) Math.atan(distance / (wormGearHeight-desiredClawHeight))*ticksPerRadian;
    }

    private int calculateSlidesExtensionForDistance(double distance) {
        int ticksPerInch = 0; // TODO: Figure out how many ticks of DCMotor equates to an inch of slide extension.

        return (int) Math.sqrt(Math.pow((wormGearHeight-desiredClawHeight),2) + Math.pow(distance,2))*ticksPerInch;
    }

    private double calculateServoPitchForDistance(double distance) {
        int servoTicksPerRadian = 0; // TODO: Figure out how many servo ticks it per degree of rotation.

        return (Math.atan((wormGearHeight-desiredClawHeight) / distance) + Math.PI/2) * servoTicksPerRadian;
    }

    public void setDistance(double newDistance) {
        distance = newDistance;

        moveArmAndClawForDistance(distance);
    }

    public double getDistance() {
        return distance;
    }

    public void grab() {
        // TODO: Write code to close claw and switch to bucket position
    }

    public void release() {
        // TODO: Write code to drop sample and return to default position
    }

    public void disengage() {
        // TODO: Write code to cancel and return to default position
    }
}

package org.firstinspires.ftc.teamcode.nathanstuff.teleopmodules;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.nathanstuff.Arm;
import org.firstinspires.ftc.teamcode.nathanstuff.ArmPosition;
import org.firstinspires.ftc.teamcode.nathanstuff.Claw;
import org.firstinspires.ftc.teamcode.nathanstuff.positions.BasicPositions;

public class SimpleBucketArm {
    private BasicPositions positions;

    private Arm arm;
    private Claw claw;

    private double distance = 0;
    private final double[] lowDistanceRange = {0,100};
    private final double[] highDistanceRange = {50, 75};
    public double[] distanceRange = lowDistanceRange;

    public final double wormGearHeight = 0; // TODO: Measure worm gear height
    public final double lowClawHeight = 0; // TODO: Measure desired claw height for easy sample grab
    public final double highClawHeight = 0; // TODO: Measure desired claw height for easy sample drop
    private double desiredClawHeight = lowClawHeight;


    public GrabState state;

    public enum GrabState {
        UNENGAGED,
        GRABBING,
        TRANSITIONING,
        DROPPING,
    }

    private ElapsedTime actionTimer;
    private boolean grabExecutedBefore;
    private boolean releaseExecutedBefore;

    public SimpleBucketArm(Arm arm, Claw claw) {
        this.positions = new BasicPositions();
        this.distanceRange = lowDistanceRange;
        this.distance = distanceRange[0];
        this.arm = arm;
        this.claw = claw;
        this.state = GrabState.UNENGAGED;
        this.actionTimer = new ElapsedTime();
        this.grabExecutedBefore = false;
        this.releaseExecutedBefore = false;
    }

    private void moveArmAndClawForDistance(double distance) {
        ArmPosition newPosition = new ArmPosition();
        newPosition.setSlides(calculateSlidesExtensionForDistance(distance));
        newPosition.setWormGear(calculateWormGearTicksForDistance(distance));

        arm.setArmPosition(newPosition);

        claw.setWristPitch(calculateServoPitchForDistance(distance));
    }

    public void engage() {
        this.distanceRange = lowDistanceRange;
        distance = distanceRange[0];
        grabExecutedBefore = false;
        releaseExecutedBefore = false;

        claw.open();

        moveArmAndClawForDistance(distance);

        state = GrabState.GRABBING;
    }

    private int calculateWormGearTicksForDistance(double distance) {
        double ticksPerDegree = 1.5; // TODO: Figure out the amount of DCMotor ticks per degree of rotation.

        double degrees = Math.toDegrees(Math.atan(distance / (wormGearHeight-desiredClawHeight)));

        if (degrees < 0) {
            degrees += 180;
        }

        return (int) (degrees*ticksPerDegree);
    }

    private int calculateSlidesExtensionForDistance(double distance) {
        int ticksPerInch = 0; // TODO: Figure out how many ticks of DCMotor equates to an inch of slide extension.

        return (int) Math.sqrt(Math.pow((wormGearHeight-desiredClawHeight),2) + Math.pow(distance,2))*ticksPerInch;
    }

    private double calculateServoPitchForDistance(double distance) {
        int servoTicksPerRadian = 0; // TODO: Figure out how many servo ticks it per degree of rotation.

        double radians = Math.atan((wormGearHeight - desiredClawHeight) / distance);

        if (radians < 0) {
            radians += 180;
        }

        if (state == GrabState.GRABBING) {
            return (radians + Math.PI / 2) * servoTicksPerRadian;
        } else /*if (state == GrabState.TRANSITIONING || state == GrabState.DROPPING)*/ {
            return (radians) * servoTicksPerRadian;
        }
    }

    public void setDistance(double newDistance) {
        distance = newDistance;

        if (distance < distanceRange[0]) {
            distance = distanceRange[0];
        }

        if (distance > distanceRange[1]) {
            distance = distanceRange[1];
        }

        if (state != GrabState.UNENGAGED && state != GrabState.TRANSITIONING) {
            moveArmAndClawForDistance(distance);
        }
    }

    public double getDistance() {
        return distance;
    }

    public boolean grab() {
        if (!grabExecutedBefore) {
            actionTimer.reset();
            grabExecutedBefore = true;
        }

        claw.close();
        state = GrabState.TRANSITIONING;

        if (actionTimer.seconds() < 0.1) {
            return false;
        }

        distanceRange = lowDistanceRange;
        distance = distanceRange[0];

        moveArmAndClawForDistance(distance);

        state = GrabState.DROPPING;

        grabExecutedBefore = false;
        return true;
    }

    public boolean release() {
        if (!releaseExecutedBefore) {
            actionTimer.reset();
            releaseExecutedBefore = true;
        }

        claw.open();

        if (actionTimer.seconds() < 0.1) {
            return false;
        }

        disengage();

        releaseExecutedBefore = false;
        return true;
    }

    public void disengage() {
        arm.setArmPosition(positions.armZeroPosition);
        claw.setClawPosition(positions.clawZeroPosition);
        claw.close();

        state = GrabState.UNENGAGED;
    }
}

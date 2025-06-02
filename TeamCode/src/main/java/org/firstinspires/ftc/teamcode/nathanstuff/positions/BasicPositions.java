package org.firstinspires.ftc.teamcode.nathanstuff.positions;

import org.firstinspires.ftc.teamcode.nathanstuff.ArmPosition;
import org.firstinspires.ftc.teamcode.nathanstuff.ClawPosition;

public class BasicPositions {
    public ArmPosition armZeroPosition;

    public ClawPosition clawZeroPosition;

    public BasicPositions() {
        armZeroPosition = new ArmPosition();
        armZeroPosition.setWormGear(0);
        armZeroPosition.setSlides(0);

        clawZeroPosition = new ClawPosition(); // TODO: Fill this in with appropriate zero position
        clawZeroPosition.setWristPitch(0);
        clawZeroPosition.setWristRoll(0);
    }
}

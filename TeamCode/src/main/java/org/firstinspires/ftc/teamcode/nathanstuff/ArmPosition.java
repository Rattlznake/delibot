package org.firstinspires.ftc.teamcode.nathanstuff;

public class ArmPosition {
    public int wormGear;
    public boolean useWormGear;
    public int slides;
    public boolean useSlides;

    // infinite parameters!!! don't use this.
    public ArmPosition(int wormGear, boolean useWormGear, int slides, boolean useSlides) {
        this.wormGear = wormGear;
        this.useWormGear = useWormGear;
        this.slides = slides;
        this.useSlides = useSlides;
    }

    public ArmPosition() {
        this.wormGear = 0;
        this.useWormGear = false;
        this.slides = 0;
        this.useSlides = false;
    }

    public ArmPosition(Arm arm) {
        this.wormGear = arm.wormGear.getCurrentPosition();
        this.useWormGear = true;
        this.slides = arm.slides.getCurrentPosition();
        this.useSlides = true;
    }

    // worm gear code
    public void setWormGear(int wormGear) {
        this.wormGear = wormGear;
        this.useWormGear = true;
    }

    public void disableWormGear() {
        this.useWormGear = false;
    }

    // slides code
    public void setSlides(int slides) {
        this.slides = slides;
        this.useSlides = true;
    }

    public void disableSlides() {
        this.useSlides = false;
    }
}

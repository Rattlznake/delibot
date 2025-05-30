package org.firstinspires.ftc.teamcode.nathanstuff;

public class ArmPosition {
    int wormGear;
    boolean useWormGear;
    int slides;
    boolean useSlides;

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

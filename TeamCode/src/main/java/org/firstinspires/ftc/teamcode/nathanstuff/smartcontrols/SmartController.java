package org.firstinspires.ftc.teamcode.nathanstuff.smartcontrols;

import com.qualcomm.robotcore.hardware.Gamepad;

public class SmartController {
    public SmartButton a;
    public SmartButton b;
    public SmartButton x;
    public SmartButton y;

    public SmartButton dpad_up;
    public SmartButton dpad_down;
    public SmartButton dpad_left;
    public SmartButton dpad_right;

    public SmartButton left_stick_button;
    public SmartButton right_stick_button;

    public SmartButton left_bumper;
    public SmartButton right_bumper;

    public SmartButton start;
    public SmartButton back;
    public SmartButton guide;

    public SmartTrigger right_trigger;
    public SmartTrigger left_trigger;

    public SmartJoystick left_stick;
    public SmartJoystick right_stick;

    public SmartController(Gamepad gamepad) {
        this.a = new SmartButton(gamepad.a);
        this.b = new SmartButton(gamepad.b);
        this.x = new SmartButton(gamepad.x);
        this.y = new SmartButton(gamepad.y);

        this.dpad_up    = new SmartButton(gamepad.dpad_up);
        this.dpad_down  = new SmartButton(gamepad.dpad_down);
        this.dpad_left  = new SmartButton(gamepad.dpad_left);
        this.dpad_right = new SmartButton(gamepad.dpad_right);

        this.left_stick_button  = new SmartButton(gamepad.left_stick_button);
        this.right_stick_button = new SmartButton(gamepad.right_stick_button);

        this.left_bumper  = new SmartButton(gamepad.left_bumper);
        this.right_bumper = new SmartButton(gamepad.right_bumper);

        this.start = new SmartButton(gamepad.start);
        this.back  = new SmartButton(gamepad.back);
        this.guide = new SmartButton(gamepad.guide);

        this.left_trigger  = new SmartTrigger(gamepad.left_trigger, 0.2f);
        this.right_trigger = new SmartTrigger(gamepad.right_trigger, 0.2f);

        this.left_stick  = new SmartJoystick(gamepad.left_stick_x, gamepad.left_stick_y, 0.1f);
        this.right_stick = new SmartJoystick(gamepad.right_stick_x, gamepad.right_stick_y, 0.1f);
    }

    public void think(Gamepad gamepad) {
        a.think(gamepad.a);
        b.think(gamepad.b);
        x.think(gamepad.x);
        y.think(gamepad.y);

        dpad_up.think(gamepad.dpad_up);
        dpad_down.think(gamepad.dpad_down);
        dpad_left.think(gamepad.dpad_left);
        dpad_right.think(gamepad.dpad_right);

        left_stick_button .think(gamepad.left_stick_button);
        right_stick_button.think(gamepad.right_stick_button);

        left_bumper.think(gamepad.left_bumper);
        right_bumper.think(gamepad.right_bumper);

        start.think(gamepad.start);
        back.think(gamepad.back);
        guide.think(gamepad.guide);

        left_trigger.think(gamepad.left_trigger);
        right_trigger.think(gamepad.right_trigger);

        left_stick.think(gamepad.left_stick_x, gamepad.left_stick_y);
        right_stick.think(gamepad.right_stick_x, gamepad.right_stick_y);
    }
}

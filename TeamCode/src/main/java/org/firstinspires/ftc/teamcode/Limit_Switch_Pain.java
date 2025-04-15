package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name="Limit Switch Pain", group = "Shame")
public class Limit_Switch_Pain extends LinearOpMode {

    /*
    Apparently the reason for our pain, sadness, and misery related to the VEX
    limit switch was because VEX is incompatible with REV, or there has to be
    some sort of special wiring thingy bc one's 5v and the other's not??? Idk.
    */
    public TouchSensor TS;
@Override
    public void runOpMode(){
        waitForStart();
        telemetry.addData("Status", "Started");
        telemetry.update();

        while (opModeIsActive()){
        TS = hardwareMap.get(TouchSensor.class, "TouchSensor");
        if (TS.isPressed()) {
            telemetry.addData("Pressed?", "Yes");
            telemetry.update();
        }
        else {
            telemetry.addData("Pressed?", "NAH");
            telemetry.update();
            }
        }
    }
}

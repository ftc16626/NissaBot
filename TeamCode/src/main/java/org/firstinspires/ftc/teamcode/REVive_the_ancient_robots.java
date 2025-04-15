package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name="REVive_the_ancient_robots", group = "Shame")
public class REVive_the_ancient_robots extends LinearOpMode {

    public RevTouchSensor RTS;
    @Override
    public void runOpMode(){
        waitForStart();
        telemetry.addData("Status", "Started");
        telemetry.update();

        while (opModeIsActive()){
            RTS = hardwareMap.get(RevTouchSensor.class, "RevTouchSensor");
            if (RTS.isPressed()) {
                telemetry.addData("Pressed?", "YAH");
                telemetry.update();
            }
            else if (!RTS.isPressed()){
                telemetry.addData("Pressed?", "NAH");
                telemetry.update();
            }
        }
    }
}

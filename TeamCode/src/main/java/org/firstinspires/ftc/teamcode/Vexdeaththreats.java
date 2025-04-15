package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name="Vexandria", group = "Shame")
public class Vexdeaththreats extends LinearOpMode {

    public RevTouchSensor TS;
    public TouchSensor VS;

    @Override
    public void runOpMode(){
        waitForStart();
        telemetry.addData("Status", "Started");
        telemetry.update();

        while (opModeIsActive()){
            TS = hardwareMap.get(RevTouchSensor.class, "RevTouchSensor");
            VS = hardwareMap.get(TouchSensor.class, "TouchSensor");

            if (VS.isPressed()) {
                telemetry.addData("VexPressed?", "YAH");
                telemetry.update();
            }
            else if (!VS.isPressed()){
                telemetry.addData("VexPressed?", "NAH");
                telemetry.update();
            }
        }
    }
}

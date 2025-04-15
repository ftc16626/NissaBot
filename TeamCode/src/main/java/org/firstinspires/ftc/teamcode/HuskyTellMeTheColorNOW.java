package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;

import java.util.concurrent.TimeUnit;

@Autonomous(name = "Husky, Tell me the color NOW!", group = "Shame")
public class HuskyTellMeTheColorNOW extends LinearOpMode {

    public HuskyLens Husky;

    @Override
    public void runOpMode(){

        Husky = hardwareMap.get(HuskyLens.class, "huskylens");
        Husky.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

        waitForStart();
    while (opModeIsActive()) {
            int READ_PERIOD = 1;
            ;

            Deadline rateLimit = new Deadline(READ_PERIOD, TimeUnit.SECONDS);

            // Immediately expire so that the first time through we'll do the read.

            rateLimit.expire();

            HuskyLens.Block[] block = Husky.blocks();
            telemetry.addData("Block count", block.length);
            for (int i = 0; i < block.length; i++) {
                if (block[i].width * block[i].height > 20000) {
                    if (block[i].id == 1) {
                        telemetry.addData("Pickup?", "Yes");
                    }
                    else {
                        telemetry.addData("Pickup?", "I would say yes, but it's the wrong color.");
                    }
                }
                else{
                    telemetry.addData("Pickup?", "NO!");
                }
            }
            telemetry.update();
        }
    }
}

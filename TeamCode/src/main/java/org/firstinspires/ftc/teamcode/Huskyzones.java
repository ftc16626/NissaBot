package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.EncoderProgramExample;

import org.firstinspires.ftc.robotcore.internal.system.Deadline;

import java.util.concurrent.TimeUnit;

@Autonomous(name = "Huskyzones", group = "Shame")
public class Huskyzones extends LinearOpMode {

    public HuskyLens Husky;

    @Override
    public void runOpMode(){


         EncoderProgramExample object = new EncoderProgramExample();
        Husky = hardwareMap.get(HuskyLens.class, "huskylens");
        Husky.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);




        waitForStart();

    while (opModeIsActive()) {
        object.encoderDrive(0,0,0,0,0,0,false,0,0,0,0,0);
            int READ_PERIOD = 1;
            ;

            Deadline rateLimit = new Deadline(READ_PERIOD, TimeUnit.SECONDS);

            // Immediately expire so that the first time through we'll do the read.

            rateLimit.expire();
        final int AREAONE = 320;
        final int AREATWO = 185;
        final int AREATHREE = 186;
        int zone = 0;



        HuskyLens.Block[] blocks = Husky.blocks();
            telemetry.addData("Block count", blocks.length);
            for (int i = 0; i < blocks.length; i++) {
                int blockX = blocks[i].x;
                telemetry.addData("Block X", blockX);

                if (blockX <= AREAONE) {
                    zone = 1;
                }
                else if (blockX <= AREATWO){
                    zone = 1;
                } else if (blockX >= AREATHREE) {
                    zone = 1;

                }
            }
            if (zone == 1) {
                object.encoderDrive(0.7,0,15,15,15,15,true,0,0,0,0,5);
                object.encoderDrive(0.7,0,21,21,21,21,false,0,0,0,0,5);
                object.encoderDrive(0.7,0,0,0,0,0,false,10,13,1,-1,5);




            } //else if (zone == 3) {
               // encoderDrive(0.7, ROT_SPEED,21, 21, 21, 21, false, 0, 0 , 0, 0, 5);
              //  encoderDrive(0.7, ROT_SPEED,-5, -5, -5, -5, true, 10, 13 , 1, -1, 5);

           // }


    }
    }
    }



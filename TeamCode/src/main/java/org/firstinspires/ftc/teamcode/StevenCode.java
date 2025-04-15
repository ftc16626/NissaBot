package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.EncoderProgramExample;

import org.firstinspires.ftc.robotcore.internal.system.Deadline;

import java.util.concurrent.TimeUnit;

@Autonomous(name = "Husky, Tell me the color NOW!", group = "Shame")
public class StevenCode extends LinearOpMode {

    public HuskyLens Husky;
    private DcMotor         LFMotor   = null;
    private DcMotor         RFMotor  = null;
    private DcMotor         LBMotor   = null;
    private DcMotor         RBMotor  = null;
    private DcMotor         rotateArm = null;
    private DcMotor         extendArm = null;
    private DcMotor         extendArm2 = null;
    CRServo Wheel1;
    CRServo Wheel2;

    private ElapsedTime runtime = new ElapsedTime(); // runs time

    // Calculate the COUNTS_PER_INCH for your specific drive train.
    // Go to your motor vendor website to determine your motor's COUNTS_PER_MOTOR_REV
    // For external drive gearing, set DRIVE_GEAR_REDUCTION as needed.
    // For example, use a value of 2.0 for a 12-tooth spur gear driving a 24-tooth spur gear.
    // This is gearing DOWN for less speed and more torque.
    // For gearing UP, use a gear ratio less than 1.0. Note this will affect the direction of wheel rotation.

    @Override
    public void runOpMode(){

        Husky = hardwareMap.get(HuskyLens.class, "huskylens");
        Husky.selectAlgorithm(HuskyLens.Algorithm.COLOR_RECOGNITION);

        waitForStart();
    while (opModeIsActive()) {
        EncoderProgramExample Encode = null;
        Encode.encoderDrive();
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


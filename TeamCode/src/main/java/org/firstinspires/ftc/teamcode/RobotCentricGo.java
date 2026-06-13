package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
@TeleOp (name = "RobotCentric")
public class RobotCentricGo extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor leftFrontMotor = hardwareMap.get(DcMotor.class, "LFMotor");
        DcMotor leftBackMotor = hardwareMap.get(DcMotor.class, "LBMotor");
        DcMotor rightFrontMotor = hardwareMap.get(DcMotor.class, "RFMotor");
        DcMotor rightBackMotor = hardwareMap.get(DcMotor.class, "RBMotor");

        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);



       
        waitForStart();

        while (opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            double strafe = -gamepad1.left_stick_x;

            double denom = Math.max(Math.abs(drive) + Math.abs(strafe) + Math.abs(turn), 1.0);
           
               leftFrontMotor.setPower(drive + strafe + turn / denom);
            leftBackMotor.setPower(drive - strafe + turn / denom);
            rightFrontMotor.setPower(drive - strafe - turn / denom);
            rightBackMotor.setPower(drive + strafe -turn / denom);
        }

    }
}

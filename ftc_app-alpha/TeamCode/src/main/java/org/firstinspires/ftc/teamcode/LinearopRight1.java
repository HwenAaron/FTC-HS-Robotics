package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.configuration.DeviceConfiguration;
import com.qualcomm.robotcore.util.ThreadPool;

@Autonomous(name="LinearopRight1", group = "Iterative Opmode")

public class LinearopRight1 extends LinearOpMode {

    double hpPow = .8;
    DcMotor leftWheel;
    DcMotor rightWheel;
    DcMotor flyWheel1;
    DcMotor flyWheel2;
    DcMotor tubeMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        leftWheel = hardwareMap.dcMotor.get("leftWheel");
        rightWheel = hardwareMap.dcMotor.get("rightWheel");
        rightWheel.setDirection(DcMotor.Direction.REVERSE);

        flyWheel1 = hardwareMap.dcMotor.get("flyWheel1");
        flyWheel2 = hardwareMap.dcMotor.get("flyWheel2");
        flyWheel1.setDirection(DcMotor.Direction.REVERSE);

        tubeMotor = hardwareMap.dcMotor.get("tubeMotor");

        waitForStart();

        DriveForward(.5);
        Thread.sleep(1000);
        StopDriving();
        flyWheelPow(-1);
        for (int i=0; i<2; i++){  //modify value of i depending on how may balls we will preload
            elevator(1);
            Thread.sleep(2500);
            stopElevating();
        }
        stopFlying();

        DriveBack(.5);
        Thread.sleep(500);
        StopDriving();
        Thread.sleep(500);

        DriveRight(.5);
        Thread.sleep(500);
        StopDriving();
        Thread.sleep(500);

        DriveForward(.5);
        Thread.sleep(1850);
        StopDriving();
        Thread.sleep(500);

        DriveRight(.5);
        Thread.sleep(500);
        StopDriving();
        Thread.sleep(500);

        DriveForward(.5);
        Thread.sleep(1200);
        StopDriving();
        Thread.sleep(500);

        DriveBack(.5);
        Thread.sleep(500);
        StopDriving();

        DriveRight(.5);
        Thread.sleep(10);
        StopDriving();

        DriveBack(.5);
        Thread.sleep(2000);
        StopDriving();

    }
    public void DriveForward(double power){
        leftWheel.setPower(power);
        rightWheel.setPower(power);
    }
    public void DriveLeft(double power){
        leftWheel.setPower(power);
        rightWheel.setPower(-power);
    }
    public void DriveRight(double power){
        leftWheel.setPower(-power);
        rightWheel.setPower(power);
    }
    public void DriveBack(double power){
        leftWheel.setPower(-power);
        rightWheel.setPower(-power);
    }
    public void flyWheelPow(double power){
        flyWheel1.setPower(power);
        flyWheel2.setPower(power);
    }
    public void elevator(double power)
    {
        tubeMotor.setPower(power);
    }
    public void stopFlying()
    {
        flyWheelPow(0);
    }
    public void stopElevating() {

        elevator(0);
    }
    public void StopDriving() {

        DriveForward(0);
    }
}
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="highPower", group = "Iterative Opmode")

public class highPower extends OpMode
{
    DcMotor leftWheel;
    DcMotor rightWheel;
    double flyWheel1Pow;
    double flyWheel2Pow;

    DcMotor swipMotor;
    DcMotor flyWheel1;
    DcMotor flyWheel2;
    DcMotor tubeMotor;

    Servo forkServo;


    DcMotor liftMotor1;
    DcMotor liftMotor2;

    @Override
    public void init() {
        // drive
        leftWheel = hardwareMap.dcMotor.get("leftWheel");
        rightWheel = hardwareMap.dcMotor.get("rightWheel");
        leftWheel.setDirection(DcMotor.Direction.REVERSE);
        // particle shooter
        swipMotor = hardwareMap.dcMotor.get("swipMotor");

        flyWheel1 = hardwareMap.dcMotor.get("flyWheel1");
        flyWheel2 = hardwareMap.dcMotor.get("flyWheel2");
        flyWheel2.setDirection(DcMotor.Direction.REVERSE);

        tubeMotor = hardwareMap.dcMotor.get("tubeMotor");
        // cap ball
        forkServo = hardwareMap.servo.get("forkServo");
        liftMotor1 = hardwareMap.dcMotor.get("liftMotor1");
        liftMotor2 = hardwareMap.dcMotor.get("liftMotor2");
    }
    @Override
    public void start(){
    }
    @Override
    public void loop(){
// 2 wheel drive motor
// fork Servos
        if (gamepad1.y) {
            forkServo.setPosition(1);
        }
        if(gamepad1.dpad_up){
            rightWheel.setPower(-.9);
            leftWheel.setPower(-.9);
        }
        if(gamepad1.dpad_down){
            rightWheel.setPower(.9);
            leftWheel.setPower(.9);
        }
        if(gamepad1.dpad_left){
            rightWheel.setPower(.9);
            leftWheel.setPower(-.9);
        }
        if(gamepad1.dpad_right){
            rightWheel.setPower(-.9);
            leftWheel.setPower(.9);
        }
        if(!(gamepad1.dpad_up || gamepad1.dpad_right || gamepad1.dpad_down || gamepad1.dpad_left)){
            rightWheel.setPower(0);
            leftWheel.setPower(0);
        }
/*vertical slides;
first two if statments makes the motor spin in opposite direction
so the the slides will release
 */
        if (gamepad1.left_bumper) {
            liftMotor1.setPower(-1);
            liftMotor2.setPower(1);
        }
        if (gamepad1.right_bumper) {
            liftMotor1.setPower(1);
            liftMotor2.setPower(-1);
        }
        //vertical slide stops moving with bumpers are not pressed
        if (!(gamepad1.right_bumper || gamepad1.left_bumper)) {
            liftMotor1.setPower(0);
            liftMotor2.setPower(0);
        }

        //Low Ppower driving

        //Game Pad 2 controls

        flyWheel1Pow = gamepad2.left_stick_y;    //control the flywheel power alowing aiming
        flyWheel2Pow = gamepad2.right_stick_y;
        flyWheel1.setPower(flyWheel1Pow);
        flyWheel2.setPower(flyWheel2Pow);

        // flapping motor
        if (gamepad2.left_bumper){
            swipMotor.setPower(-1);
        }if (!gamepad2.left_bumper){
            swipMotor.setPower(0);
        }
// particle elevator motor
        if (gamepad2.right_bumper){
            tubeMotor.setPower(1);
        }if(!gamepad2.right_bumper){
            tubeMotor.setPower(0);
        }

    }
}

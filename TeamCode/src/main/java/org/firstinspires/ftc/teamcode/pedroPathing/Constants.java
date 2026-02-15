package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.pedropathing.ftc.localization.constants.DriveEncoderConstants;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants();

    // Initialize the object first, then call setters individually
    public static MecanumConstants driveConstants = new MecanumConstants();

    static {
        driveConstants.setLeftFrontMotorName("leftFront");
        driveConstants.setRightFrontMotorName("rightFront");
        driveConstants.setLeftRearMotorName("leftRear");
        driveConstants.setRightRearMotorName("rightRear");
        driveConstants.setLeftFrontMotorDirection(DcMotorSimple.Direction.REVERSE);
        driveConstants.setLeftRearMotorDirection(DcMotorSimple.Direction.REVERSE);
    }

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .driveEncoderLocalizer(new DriveEncoderConstants())
                .build();
    }
}
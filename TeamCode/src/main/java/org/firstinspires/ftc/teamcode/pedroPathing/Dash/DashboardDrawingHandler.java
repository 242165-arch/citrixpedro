package org.firstinspires.ftc.teamcode.pedroPathing.Dash; // Make sure this matches your folder!

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.canvas.Canvas;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;

public class DashboardDrawingHandler {
    public static void drawDebug(Follower follower) {
        TelemetryPacket packet = new TelemetryPacket();
        Canvas fieldOverlay = packet.fieldOverlay();

        Pose robotPose = follower.getPose();

        // Draw the robot as a circle (9 inch radius)
        fieldOverlay.setStroke("#3F51B5");
        fieldOverlay.strokeCircle(robotPose.getX(), robotPose.getY(), 9);

        // Draw a line for the heading
        double vX = Math.cos(robotPose.getHeading()) * 10;
        double vY = Math.sin(robotPose.getHeading()) * 10;
        fieldOverlay.strokeLine(robotPose.getX(), robotPose.getY(), robotPose.getX() + vX, robotPose.getY() + vY);

        FtcDashboard.getInstance().sendTelemetryPacket(packet);
    }
}
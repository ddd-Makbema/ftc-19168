package org.firstinspires.ftc.teamcode.team;


        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

        import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
        import org.openftc.easyopencv.OpenCvCamera;
        import org.openftc.easyopencv.OpenCvCameraFactory;
        import org.openftc.easyopencv.OpenCvCameraRotation;

        import java.util.List;
@TeleOp
public class cameraDebugTest extends LinearOpMode {


    tpmpDebug tpmpDebug;

    @Override
    public void runOpMode() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");
        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId);
        tpmpDebug = new tpmpDebug();
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                camera.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
                camera.setPipeline(tpmpDebug);
            }
            @Override
            public void onError(int errorCode)
            {
                telemetry.addData("error openCv", errorCode);
            }
        });


        waitForStart();

            if (opModeIsActive()) {
                while (opModeIsActive()) {
                    telemetry.addData("cound", getRuntime());

//                if (gamepad1.a) {
                    telemetry.addData("Partisian", tpmpDebug.getLastResults());
//                }
                }}}}

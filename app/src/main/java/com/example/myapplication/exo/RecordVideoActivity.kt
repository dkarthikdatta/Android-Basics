package com.example.myapplication.exo

import android.Manifest
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.media.CamcorderProfile
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.SurfaceHolder
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRecordVideoBinding
import java.io.File
import java.io.IOException


class RecordVideoActivity : AppCompatActivity(), SurfaceHolder.Callback {
    private lateinit var recorder: MediaRecorder
    private lateinit var holder: SurfaceHolder
    private lateinit var binding: ActivityRecordVideoBinding
    private var recording = false
    private val REQUEST_PERMISSIONS_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordVideoBinding.inflate(layoutInflater)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        recorder = MediaRecorder()

        setContentView(binding.root)

        checkPermissions()

        val cameraView = binding.cameraView

        holder = cameraView.holder

        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        initRecorder()

        cameraView.setClickable(true)
        cameraView.setOnClickListener {
            if (recording) {
                recorder.stop()
                recording = false

                // Let's initRecorder so we can record again
                initRecorder()
                prepareRecorder()
            } else {
                recording = true
                recorder.start()
            }
        }
//        cameraView.setOnClickListener(this);
    }


    private fun initRecorder() {

        val outputFile = File(filesDir.parentFile, "fileName.mp4")

        Log.d("TEST_RECORD", outputFile.absolutePath)
        // Ensure the file is created
        if (!outputFile.exists()) {
            outputFile.createNewFile()
        }
        println("TEST_RECORD " + outputFile.absolutePath)
        // Get the app-specific directory on external storage
//        val outputDir = getExternalFilesDir(Environment.DIRECTORY_MOVIES)
//        if (outputDir != null && !outputDir.exists()) {
//            outputDir.mkdirs()
//        }


        recorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT)
        recorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT)
        val cpHigh = CamcorderProfile
            .get(CamcorderProfile.QUALITY_HIGH)
        recorder.setProfile(cpHigh)

        recorder.setOutputFile(outputFile.absolutePath)

        recorder.setMaxDuration(50000) // 50 seconds
        recorder.setMaxFileSize(5000000) // Approximately 5 megabytes
    }

    private fun prepareRecorder() {
        recorder.setPreviewDisplay(holder.surface)
        try {
            recorder.prepare()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
            finish()
        } catch (e: IOException) {
            e.printStackTrace()
            finish()
        }
    }

    fun checkPermissions() {
        if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.CAMERA
                ), REQUEST_PERMISSIONS_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSIONS_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissions granted, proceed with initialization
                Log.d("TEST_RECORD", "in permission")
                initRecorder()
            } else {
                // Permissions denied, handle accordingly
                Toast.makeText(this, "Permissions required for recording", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        prepareRecorder()
    }

    override fun surfaceChanged(
        holder: SurfaceHolder, format: Int, width: Int,
        height: Int
    ) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        if (recording) {
            recorder.stop()
            recording = false
        }
        recorder.release()
        finish()
    }
}
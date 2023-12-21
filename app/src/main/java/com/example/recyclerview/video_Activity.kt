package com.example.recyclerview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

// deklarasi kelas mewarisi sifat dari kelas AppCompatActivity
class video_Activity : AppCompatActivity() {

   // mendeklarasikan properti videoView, yang digunakan untuk menampilkan video di dalam aplikasi.
    private lateinit var videoView: VideoView

    // Metode ini dipanggil saat aktivitas dibuat.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        val videoId=intent.getIntExtra("videoId",-1)
        videoView=findViewById(R.id.vv_video)
        val videoPath="android.resource://${packageName}/${videoId}"
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.setMediaController(MediaController(this))
        videoView.start()
    }
}
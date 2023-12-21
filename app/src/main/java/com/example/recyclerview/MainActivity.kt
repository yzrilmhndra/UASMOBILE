// kelas Kotlin yang diberi nama MainActivity.

package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// deklarasi kelas yang mewarisi sifat dari kelas AppCompatActivity
class MainActivity : AppCompatActivity() {

    // properti kelas (recyclerview dan list) untuk menampilkan daftar vidio
    private lateinit var recyclerView: RecyclerView
    private val list= ArrayList<video>()

    // metode oncreate seperti mengatur tata letak,xml dan menampilkan list
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.rv_video)
        recyclerView.setHasFixedSize(true)
        list.addAll(getList())
        showRecyclerList()
    }

    // metode getlist dari vidio,gambar,deskripsi.
    private fun getList():ArrayList<video>{
        val gambar=resources.obtainTypedArray(R.array.data_gambar)
        val dataName=resources.getStringArray(R.array.judul_video)
        val dataDesripsi=resources.getStringArray(R.array.data_dekripsi)
        val videoId=resources.obtainTypedArray(R.array.video_id)
        val listvideo=ArrayList<video>()
        for (i in dataName.indices){
            val video=video(gambar.getResourceId(i,-1),dataName[i],dataDesripsi[i],videoId.getResourceId(i,-1))
            listvideo.add(video)
        }
        return listvideo
    }

    //  menetapkan LayoutManager dari RecyclerView menjadi LinearLayoutManager
    private fun showRecyclerList(){
        // Menetapkan layout manager untuk RecyclerView
        recyclerView.layoutManager=LinearLayoutManager(this)

        // Membuat adapter dan menetapkan ke RecyclerView
        val listadapter=ListAdapter(list)
        recyclerView.adapter=listadapter
    }

}
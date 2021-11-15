package com.tecbabel.alammall

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pesan.*

class Activity_Pesan: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)

        name.text = GlobalData.names
        harga.text = "$" + GlobalData.hargas.toString()
        deskripsi.text = GlobalData.deskripsis
        Picasso.get().load(GlobalData.photos).into(image)

        pesan.setOnClickListener {

            var hargaproduct = GlobalData.hargas
            var edittextHarga = jumlah.text.toString()
            var convertharga = edittextHarga.toInt()
            var kalikan = convertharga * hargaproduct.toInt()
            Log.d("tampilkan","${kalikan.toInt()}")

        }


    }

}
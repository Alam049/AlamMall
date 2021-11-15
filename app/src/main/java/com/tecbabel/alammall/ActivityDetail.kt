package com.tecbabel.alammall

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.tecbabel.alammall.payment.PaymentsMidtrans
import kotlinx.android.synthetic.main.activity_detail.*

class ActivityDetail: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        name.text = GlobalData.names
        Picasso.get().load(GlobalData.photos).into(image)
        harga.text = "$ " + GlobalData.hargas.toString()
        deskripsi.text = GlobalData.deskripsis


        pesan.setOnClickListener {
            var i = Intent(applicationContext, PaymentsMidtrans:: class.java)
            startActivity(i)

        }
    }

}
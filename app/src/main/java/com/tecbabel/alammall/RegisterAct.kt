package com.tecbabel.alammall

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.btn_register
import kotlinx.android.synthetic.main.activity_register.*

class RegisterAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var url:String = "http://192.168.43.129/store/register.php";

        supportActionBar!!.hide()

        btn_register.setOnClickListener {

            if(username1.text.toString().isEmpty() || email.text.toString().isEmpty() || alamat.text.toString().isEmpty() || password1.text.toString().isEmpty() ){

                Toast.makeText(applicationContext,"Input Data dengan benar!",Toast.LENGTH_LONG).show()

            }else {

                var request : RequestQueue = Volley.newRequestQueue(applicationContext)

                var strRequest = StringRequest(Request.Method.GET,url +"?user="+username1.text.toString()+"&email="+email.text.toString()+
                        "&phone="+alamat.text.toString()+ "&password="+password1.text.toString(), Response.Listener { response ->

                    if (response.equals("1")){

                        var a = Intent(this,LoginAct :: class.java)
                        startActivity(a)
                    }else{
                        Toast.makeText(applicationContext,"Gagal register",Toast.LENGTH_LONG).show();

                    }

                },Response.ErrorListener { error ->
                    Log.d("errorApp",error.toString())
                })
                request.add(strRequest)

            }



        }

    }

}
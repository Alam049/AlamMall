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
import kotlinx.android.synthetic.main.activity_login.*

class LoginAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_register.setOnClickListener {

            var movetoregister = Intent(this,RegisterAct :: class.java)
            startActivity(movetoregister)

        }

        var url:String = "http://192.168.43.129/store/login.php";

        supportActionBar!!.hide()

        btn_login.setOnClickListener {

            var request : RequestQueue = Volley.newRequestQueue(applicationContext)

            var stringRequest = StringRequest(Request.Method.GET,url +"?email="+username.text.toString()+"&password="+password.text.toString(), Response.Listener { response ->

                if (response.equals("0")){

                    var a = Intent(this,MainActivity :: class.java)
                    GlobalData.email = username.text.toString()
                    startActivity(a)
                }else{
                    Toast.makeText(applicationContext,"Gagal Login",Toast.LENGTH_LONG).show();

                }

            },Response.ErrorListener { error ->
                Log.d("errorApp",error.toString());
            })
            request.add(stringRequest)
        }

    }

}
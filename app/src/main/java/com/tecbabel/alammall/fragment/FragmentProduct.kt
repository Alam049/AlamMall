package com.tecbabel.alammall.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.tecbabel.alammall.GlobalData
import com.tecbabel.alammall.R
import com.tecbabel.alammall.adapter.CategoryProduct
import com.tecbabel.alammall.adapter.ProductAdapter
import com.tecbabel.alammall.modal.Category
import com.tecbabel.alammall.modal.Product
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentProduct : Fragment() {

    var list = ArrayList<Category>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_product, container, false)

        getProduct()
        return view


    }

    private fun getProduct () {

        var queue: RequestQueue = Volley.newRequestQueue(requireContext())
        var request = JsonArrayRequest(Request.Method.GET,"http://192.168.43.129/store/apicategory.php",null, Response.Listener{ response ->

            for (s in 0..response.length() - 1) {

                var job = response.getJSONObject(s)

                var id = job.getInt("id")
                var name = job.getString("name")
                var photo = job.getString("photo").replace("localhost","192.168.43.129")

                list.add(Category(id, name , photo))
                var adapterku = CategoryProduct(requireContext(),list)
                recycler.layoutManager = LinearLayoutManager(requireContext())
                recycler.adapter = adapterku


            }


        }, Response.ErrorListener { error ->
            Log.d("categoryError", error.toString())
        })
        queue.add(request)
    }

}
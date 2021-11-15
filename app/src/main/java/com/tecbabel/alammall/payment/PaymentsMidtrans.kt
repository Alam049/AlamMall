package com.tecbabel.alammall.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback
import com.midtrans.sdk.corekit.core.MidtransSDK
import com.midtrans.sdk.corekit.core.TransactionRequest
import com.midtrans.sdk.corekit.core.themes.CustomColorTheme
import com.midtrans.sdk.corekit.models.BillingAddress
import com.midtrans.sdk.corekit.models.CustomerDetails
import com.midtrans.sdk.corekit.models.ItemDetails
import com.midtrans.sdk.corekit.models.ShippingAddress
import com.midtrans.sdk.uikit.SdkUIFlowBuilder
import com.squareup.picasso.Picasso
import com.tecbabel.alammall.GlobalData
import com.tecbabel.alammall.R
import kotlinx.android.synthetic.main.activity_pesan.*


class PaymentsMidtrans: AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)
        supportActionBar!!.hide()
        name.text = GlobalData.names
        harga.text = "$" + GlobalData.hargas.toString()
        deskripsi.text = GlobalData.deskripsis
        Picasso.get().load(GlobalData.photos).into(image)


        SdkUIFlowBuilder.init()
            .setClientKey("SB-Mid-client-rTZjIXYIcQ0nwqv8")
            .setContext(applicationContext)
            .setTransactionFinishedCallback(TransactionFinishedCallback {

                result->
//                this is logic
            })
            .setMerchantBaseUrl("http://192.168.43.129/store/midtrans.php")
            .enableLog(true)
            .setColorTheme(CustomColorTheme("#FFE51255", "#B61548", "#FFE51255"))
            .setLanguage("id")
            .buildSDK()

        pesan.setOnClickListener {

            val hargaproduct = GlobalData.hargas
            val edittextHarga = jumlah.text.toString()
            val catatan = catatan.text.toString()
            GlobalData.jumlah = edittextHarga.toInt()
            GlobalData.catatan = catatan.toString()
            val convertharga = edittextHarga.toInt()
            val kalikan = convertharga * hargaproduct.toDouble()

            val transactionRequest = TransactionRequest("Alam-Mall-"+System.currentTimeMillis().toShort() + "", kalikan)
            val detail = ItemDetails("NamaItemId", GlobalData.hargas.toDouble(), edittextHarga.toInt(), "Smarthome (nama)")
            val itemDetails = ArrayList<ItemDetails>()
            itemDetails.add(detail)
            uiKitDetails(transactionRequest)
            transactionRequest.itemDetails = itemDetails
            MidtransSDK.getInstance().transactionRequest = transactionRequest
            MidtransSDK.getInstance().startPaymentUiFlow(this)



        }


    }
    fun uiKitDetails (transactionRequest: TransactionRequest) {


        val customerDetails = CustomerDetails()
        customerDetails.setCustomerIdentifier("budi-6789")
        customerDetails.setPhone("08123456789")
        customerDetails.setFirstName("Budi")
        customerDetails.setLastName("Utomo")
        customerDetails.setEmail("budi@utomo.com")

        val shippingAddress = ShippingAddress()
        shippingAddress.address = "Jalan Andalas Gang Sebelah No. 1"
        shippingAddress.city = "Jakarta"
        shippingAddress.postalCode = "10220"
        customerDetails.setShippingAddress(shippingAddress)

        val billingAddress = BillingAddress()
        billingAddress.address = "Jalan Andalas Gang Sebelah No. 1"
        billingAddress.city = "Jakarta"
        billingAddress.postalCode = "10220"
        customerDetails.setBillingAddress(billingAddress)

        transactionRequest.setCustomerDetails(customerDetails)


    }


}
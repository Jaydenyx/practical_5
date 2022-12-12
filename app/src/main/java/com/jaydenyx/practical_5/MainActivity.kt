package com.jaydenyx.practical_5

import android.app.Notification
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jaydenyx.practical_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener {
            val sellingPrice = binding.editTextSellingPrice.text.toString().toInt()
            val downPayment = binding.editTextDownPayment.text.toString().toInt()
            val firstTimeBuyer = binding.checkBoxFirstBuyer.isChecked

            var legalFee: Float = 0.0f
            var stampDuty: Float = 0.0f

            //Check first time buyer down payment is 10% of the selling price
            if (firstTimeBuyer) {
                if (downPayment >= sellingPrice * 0.1) {
                    //this is ok
                } else {
                    //this is not ok
                }
            } else {
                //None first time buyer
            }
            val myLoan = Loan(legalFee.toString(), stampDuty.toString())
            binding.myLoan = myLoan
        }

        //Link to the phone and web
        binding.imageButtonPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: 01162316614")
            startActivity(intent)
        }

        binding.imageButtonWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://pbebanl.com.my")
            startActivity(intent)
        }
    }
}

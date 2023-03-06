package com.example.calbmi
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calbmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCal.setOnClickListener {
            if (binding.edtWeight.text.toString().isNotEmpty() && binding.edtHeight.text.toString().isNotEmpty()) {
                val wt = (binding.edtWeight.text.toString()).toDouble()
                val ht = (binding.edtHeight.text.toString()).toDouble()
                val htnew = (ht / 100).toDouble()
                val bmi = wt / (htnew * htnew)
                binding.txtMsg.text = R.string.strBMI.toString()
                binding.txtResult.text = " Your BMI is ${bmi.toInt()}"
                if (bmi > 25) {
                    Toast.makeText(this@MainActivity, R.string.strOverweight, Toast.LENGTH_SHORT)
                        .show()
                    binding.txtMsg.text = resources.getString(R.string.strOverweight)
                } else if (bmi < 18) {
                    Toast.makeText(this@MainActivity, R.string.strUnderweight, Toast.LENGTH_SHORT)
                        .show()
                    binding.txtMsg.text = resources.getString(R.string.strUnderweight)
                } else  if(bmi>18&&bmi<25) {
                    Toast.makeText(this@MainActivity, R.string.strHealthy, Toast.LENGTH_SHORT)
                        .show()
                    binding.txtMsg.text = resources.getString(R.string.strHealthy)
                }


            }
            else
            {
               Toast.makeText(this@MainActivity,R.string.strinvalid, Toast.LENGTH_LONG).show()
                binding.txtMsg.text = resources.getString(R.string.strinvalid)

            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_memu , menu)
        return super.onCreateOptionsMenu(menu)
    }


    }


package com.example.country

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.country.API.APIInterface
import com.example.country.API.APIclient
import com.example.country.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: countryabapter

    //    lateinit var countryList : List<Countrymodel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = countryabapter()
        callAPI()



    }

    private fun callAPI() {

        var api = APIclient.getClient()?.create(APIInterface::class.java)

        api?.getCountries()?.enqueue(object : Callback<List<Countrymodel>> {

            override fun onResponse(
                call: Call<List<Countrymodel>>,
                response: Response<List<Countrymodel>>
            ) {
                if (response.isSuccessful) {
//                    var countryList = response.body()?.get(0)?.flags
                    var countryList = response.body() as List<Countrymodel>
                    adapter.setcountrylist(countryList)


                    binding.rcv.layoutManager = GridLayoutManager(this@MainActivity, 1)
                    binding.rcv.adapter = adapter


                }

            }

            override fun onFailure(call: Call<List<Countrymodel>>, t: Throwable) {
            }

        })

    }
}
package com.starkindustries.retrofit.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.starkindustries.retrofit.Builder.RetrofitBuilder
import com.starkindustries.retrofit.R
import com.starkindustries.retrofit.RetrofitInterfaces.RetrofitInterface
import com.starkindustries.retrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
   lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        val quotesApi = RetrofitBuilder.getInstance().create(RetrofitInterface::class.java)
      GlobalScope.launch {
          val result = quotesApi.getQuotes()
          if(result!=null)
              Log.d("response",result.body().toString().trim())
      }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
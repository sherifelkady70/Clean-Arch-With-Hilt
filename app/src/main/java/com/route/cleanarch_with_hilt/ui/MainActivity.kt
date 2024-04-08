package com.route.cleanarch_with_hilt.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.route.cleanarch_with_hilt.R
import com.route.cleanarch_with_hilt.domain.entity.MyModelItem
import com.route.cleanarch_with_hilt.domain.usecase.UseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getUseCase : UseCase
    lateinit var textView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)
        getUseCase()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getUseCase() = GlobalScope.launch(Dispatchers.IO){
        val result : List<MyModelItem> = getUseCase.invoke().await().filter {it.id== 2}
        withContext(Dispatchers.Main){
            textView.text = result.toString()
            Log.d("getUseCase","${textView.text}")
        }
    }
}
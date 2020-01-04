package com.ypk.textviewsegment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laodao.library.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        button1.setOnClickListener {

            startActivity(Intent(MainActivity@ this, BasicUseActivity::class.java))

        }

        button2.setOnClickListener {
            startActivity(Intent(MainActivity@ this, ToolActivity::class.java))
        }
    }
}

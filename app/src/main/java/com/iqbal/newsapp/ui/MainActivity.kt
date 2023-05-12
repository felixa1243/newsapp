package com.iqbal.newsapp.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.iqbal.newsapp.R
import com.iqbal.newsapp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.Home -> replaceFragment(Home())
                R.id.News -> replaceFragment(News())
                else ->{



                }

            }

            true

        }


    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }
}
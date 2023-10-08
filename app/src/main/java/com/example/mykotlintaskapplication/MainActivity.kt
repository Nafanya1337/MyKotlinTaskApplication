package com.example.mykotlintaskapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mykotlintaskapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonNext.setOnClickListener {
            if (count == 0)
                binding.buttonPrev.isEnabled = true
            when (count) {
                0 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.container.id, Fragment2::class.java, null)
                        .addToBackStack(null)
                        .commit()
//                    findNavController(binding.container.id).navigate(R.id.action_fragment1_to_fragment2)
                }
                1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(binding.container.id, Fragment3::class.java, null)
                        .addToBackStack(null)
                        .commit()
//                    findNavController(binding.container.id).navigate(R.id.action_fragment2_to_fragment3)
                }
            }
            count++
            if (count == 2)
                binding.buttonNext.isEnabled = false
        }

        binding.buttonPrev.setOnClickListener {
            if (count == 1) {
                binding.buttonPrev.isEnabled = false
                binding.buttonNext.isEnabled = true
            }
            supportFragmentManager.popBackStack()
//            findNavController(binding.container.id).navigateUp()
            count--
        }
    }


}
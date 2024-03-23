package com.example.studentprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentprofile.databinding.ActivityStudentDetailBinding

class StudentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStudentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val id = intent.getIntExtra("id", 0)
        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val phoneNumber = intent.getStringExtra("phoneNumber")
        val image = intent.getIntExtra("image", 0)


        binding.apply {
            imageViewProfilePic.setImageResource(image)
            textViewId.text = getString(R.string.id_text, id)
            textViewName.text = getString(R.string.name_text, firstName, lastName)
            textViewPhoneNumber.text = getString(R.string.phone_text, phoneNumber)
        }
    }
}

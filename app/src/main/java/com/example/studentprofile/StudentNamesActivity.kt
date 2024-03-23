package com.example.studentprofile


import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentprofile.adapters.StudentAdapter
import com.example.studentprofile.data.StudentRepository
import com.example.studentprofile.databinding.ActivityStudentNamesBinding
import com.example.studentprofile.databinding.DialogAddStudentBinding
import com.example.studentprofile.models.StudentModel

class StudentNamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentNamesBinding
    private lateinit var studentRepository: StudentRepository
    private lateinit var adapter: StudentAdapter
    private lateinit var userList: ArrayList<StudentModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentNamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentRepository = StudentRepository()
        userList = studentRepository.getStudentsList()

        adapter = StudentAdapter(this, userList)
        binding.studentListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.studentListRecyclerView.adapter = adapter


        binding.addStudentButton.setOnClickListener {
            showAddStudentDialog()
        }
    }

    private fun showAddStudentDialog() {
        val dialogBinding = DialogAddStudentBinding.inflate(LayoutInflater.from(this))
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setTitle("Add Student")
            .setPositiveButton("Add") { _, _ ->

                val id = dialogBinding.editTextId.text.toString().toInt()
                val firstName = dialogBinding.editTextFirstName.text.toString()
                val lastName = dialogBinding.editTextLastName.text.toString()
                val phoneNumber = dialogBinding.editTextPhoneNumber.text.toString()


                if (id.toString().isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()) {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                } else {

                    val newStudent = StudentModel(id, firstName, lastName, phoneNumber, R.drawable.student)

                    userList.add(newStudent)

                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->

                dialog.dismiss()
            }
        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }
}

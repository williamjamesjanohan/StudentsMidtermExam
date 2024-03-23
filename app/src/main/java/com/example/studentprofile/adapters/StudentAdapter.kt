package com.example.studentprofile.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentprofile.R
import com.example.studentprofile.StudentDetailActivity
import com.example.studentprofile.databinding.StudentItemBinding
import com.example.studentprofile.models.StudentModel


class StudentAdapter(private val context: Context, private val studentList: List<StudentModel>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(private val binding: StudentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int, student: StudentModel) {
            binding.studentRecord.text = context.getString(R.string.student_record, position + 1, student.lastName, student.firstName)
            binding.root.setOnClickListener {
                val intent = Intent(context, StudentDetailActivity::class.java).apply {
                    putExtra("id", student.id)
                    putExtra("firstName", student.firstName)
                    putExtra("lastName", student.lastName)
                    putExtra("phoneNumber", student.phoneNumber)
                    putExtra("image", student.imageResourceId)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StudentItemBinding.inflate(inflater, parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.bind(position, student)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}

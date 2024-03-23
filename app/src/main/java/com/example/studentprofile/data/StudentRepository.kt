package com.example.studentprofile.data

import com.example.studentprofile.models.StudentModel
import com.example.studentprofile.R
class StudentRepository{

    fun getStudentsList(): ArrayList<StudentModel> {
        return arrayListOf(
            StudentModel(1001, "Ant", "Man", "0912345678", R.drawable.ant),
            StudentModel(1011, "Bat", "Man", "0912345611", R.drawable.bat),
            StudentModel(1110, "Cat", "Man", "0911145678", R.drawable.cat),
            StudentModel(1010, "Dog", "Man", "0998945678", R.drawable.dog)
        )
    }

}
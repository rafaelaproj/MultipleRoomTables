package rafaelacs.com.br.multipleroomtables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.solver.widgets.analyzer.Direct
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import rafaelacs.com.br.multipleroomtables.entities.Director
import rafaelacs.com.br.multipleroomtables.entities.School
import rafaelacs.com.br.multipleroomtables.entities.Student
import rafaelacs.com.br.multipleroomtables.entities.Subject
import rafaelacs.com.br.multipleroomtables.entities.relations.StudentSubjectCrossRef

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao: SchoolDao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director("Rafaela Souza", "UEG"),
            Director("Bruno Souza", "UFG"),
            Director("Luiz Souza", "UCG")
        )

        val schools = listOf(
            School("UEG"),
            School("UFG"),
            School("UCG")
        )

        val subjects = listOf(
            Subject("Databases"),
            Subject("Geology"),
            Subject("Cardiology"),
            Subject("OOP"),
            Subject("Climates"),
            Subject("Medical Ethics")
        )

        val students = listOf(
            Student("Albert Thorn", 2, "UFG"),
            Student("Alicia Brooke", 1, "UCG"),
            Student("Bernard Ollie", 10, "UEG"),
            Student("Will Dasher", 5, "UFG"),
            Student("Marla Knicks", 3, "UCG"),
            Student("David Bernard", 7, "UEG")
        )

        val studentsSubjectRelations = listOf(
            StudentSubjectCrossRef("Albert Thorn", "Geology"),
            StudentSubjectCrossRef("Albert Thorn", "Climates"),
            StudentSubjectCrossRef("Alicia Brooke", "Cardiology"),
            StudentSubjectCrossRef("Alicia Brooke", "Medical Ethics"),
            StudentSubjectCrossRef("Bernard Ollie", "Databases"),
            StudentSubjectCrossRef("Bernard Ollie", "OOP"),
            StudentSubjectCrossRef("Will Dasher", "Databases"),
            StudentSubjectCrossRef("Will Dasher", "OOP"),
            StudentSubjectCrossRef("Marla Knicks", "Geology"),
            StudentSubjectCrossRef("Marla Knicks", "Climates"),
            StudentSubjectCrossRef("David Bernard", "Cardiology"),
            StudentSubjectCrossRef("David Bernard", "Medical Ethics"),
        )

        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentsSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector = dao.getSchoolAndDirectorWithSchoolName("UCG")

            val schoolWithStudents = dao.getSchoolWithStudents("UCG")

        }
    }
}
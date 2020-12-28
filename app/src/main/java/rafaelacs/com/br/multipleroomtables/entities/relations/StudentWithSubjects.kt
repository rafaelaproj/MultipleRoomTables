package rafaelacs.com.br.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import rafaelacs.com.br.multipleroomtables.entities.Student
import rafaelacs.com.br.multipleroomtables.entities.Subject

data class StudentWithSubjects(

    @Embedded
    val student: Student,

    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>


)

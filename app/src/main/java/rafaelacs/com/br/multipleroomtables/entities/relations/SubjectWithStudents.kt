package rafaelacs.com.br.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import rafaelacs.com.br.multipleroomtables.entities.Student
import rafaelacs.com.br.multipleroomtables.entities.Subject

data class SubjectWithStudents(

    @Embedded
    val subject: Subject,

    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>

)

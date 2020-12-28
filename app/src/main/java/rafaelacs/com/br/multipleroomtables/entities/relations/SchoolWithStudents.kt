package rafaelacs.com.br.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import rafaelacs.com.br.multipleroomtables.entities.School
import rafaelacs.com.br.multipleroomtables.entities.Student

data class SchoolWithStudents(

    @Embedded
    val school: School,

    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>

)

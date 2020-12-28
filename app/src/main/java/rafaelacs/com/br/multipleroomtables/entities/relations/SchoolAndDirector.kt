package rafaelacs.com.br.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import rafaelacs.com.br.multipleroomtables.entities.Director
import rafaelacs.com.br.multipleroomtables.entities.School

data class SchoolAndDirector(
    @Embedded
    val school: School,

    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director

)
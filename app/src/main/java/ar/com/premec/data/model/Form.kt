package ar.com.premec.data.model

//TODO set the real properties of the forms
data class Form(
    val id: Int,
    val prioridad: String,
    val asignadoPor: String,
    val empleado: String,
    val numero: Int,
    val fecha: String,
    val hora: String,
    val synchronized: Boolean = false
)
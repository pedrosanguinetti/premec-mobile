package ar.com.premec.data

import ar.com.premec.data.model.Form

class FormDAO {

    //TODO fetch the data from the SQLite
    fun get(query: String, nextPageNumber: Int): List<Form> {
        when (nextPageNumber) {
            1 -> {
                return listOf(
                    Form(1, "Alta", "Rodrigo Perez", "Marcos Trinche", 34, "24/11", "08:30", true),
                    Form(2, "Media", "Rodrigo Perez", "Marcos Trinche", 34, "23/11", "09:30", true),
                    Form(3, "Media", "Rodrigo Perez", "Ramón Ramirez", 34, "25/11", "11:00"),
                    Form(4, "Alta", "Pablo Bing", "Ramón Ramirez", 34, "22/11", "08:15", true),
                    Form(5, "Baja", "Rodrigo Perez", "Marcos Trinche", 34, "24/11", "12:30", true),
                    Form(6, "Alta", "Pablo Bing", "Ramón Ramirez", 34, "24/11", "08:45"),
                    Form(7, "Media", "Pablo Bing", "Marcos Trinche", 34, "26/11", "07:30", true),
                    Form(8, "Baja", "Pablo Bing", "Julián A.", 34, "27/11", "06:30"),
                    Form(9, "Media", "Rodrigo Perez", "Julián A.", 34, "22/11", "14:30"),
                    Form(10, "Alta", "Rodrigo Perez", "Marcos Trinche", 34, "20/11", "08:15")
                )
            }
            2 -> {
                return listOf(
                    Form(11, "Alta", "Rodrigo Perez", "Marcos Trinche", 34, "24/11", "08:30"),
                    Form(12, "Media", "Rodrigo Perez", "Marcos Trinche", 34, "23/11", "09:30", true),
                    Form(13, "Media", "Rodrigo Perez", "Ramón Ramirez", 34, "25/11", "11:00", true),
                    Form(14, "Alta", "Pablo Bing", "Ramón Ramirez", 34, "22/11", "08:15"),
                    Form(15, "Baja", "Rodrigo Perez", "Marcos Trinche", 34, "24/11", "12:30", true),
                    Form(16, "Alta", "Pablo Bing", "Ramón Ramirez", 34, "24/11", "08:45"),
                    Form(17, "Media", "Pablo Bing", "Marcos Trinche", 34, "26/11", "07:30", true),
                    Form(18, "Baja", "Pablo Bing", "Julián A.", 34, "27/11", "06:30"),
                    Form(19, "Media", "Rodrigo Perez", "Julián A.", 34, "22/11", "14:30", true),
                    Form(20, "Alta", "Rodrigo Perez", "Marcos Trinche", 34, "20/11", "08:15")
                )
            }
            3 -> {
                return listOf(
                    Form(21, "Alta", "Rodrigo Perez", "Marcos Trinche", 34, "24/11", "08:30"),
                    Form(22, "Media", "Rodrigo Perez", "Marcos Trinche", 34, "23/11", "09:30"),
                    Form(23, "Media", "Rodrigo Perez", "Ramón Ramirez", 34, "25/11", "11:00"),
                    Form(24, "Alta", "Pablo Bing", "Ramón Ramirez", 34, "22/11", "08:15"),
                    Form(25, "Baja", "Rodrigo Perez", "Marcos Trinche", 34, "24/11", "12:30"),
                    Form(26, "Alta", "Pablo Bing", "Ramón Ramirez", 34, "24/11", "08:45"),
                    Form(27, "Media", "Pablo Bing", "Marcos Trinche", 34, "26/11", "07:30"),
                    Form(28, "Baja", "Pablo Bing", "Julián A.", 34, "27/11", "06:30"),
                    Form(29, "Media", "Rodrigo Perez", "Julián A.", 34, "22/11", "14:30"),
                    Form(30, "Alta", "Rodrigo Perez", "Marcos Trinche", 34, "20/11", "08:15")
                )
            }
        }
        return listOf()
    }
}

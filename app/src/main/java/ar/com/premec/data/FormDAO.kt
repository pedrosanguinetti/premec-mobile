package ar.com.premec.data

import ar.com.premec.data.model.Form

class FormDAO {

    //TODO fetch the data from the SQLite
    fun get(query: String, nextPageNumber: Int): List<Form> {
        when (nextPageNumber) {
            1 -> {
                return listOf(
                    Form(1, "1A"),
                    Form(2, "1B"),
                    Form(3, "1C"),
                    Form(4, "1D"),
                    Form(5, "1E"),
                    Form(6, "1F"),
                    Form(7, "1G"),
                    Form(8, "1H"),
                    Form(9, "1I"),
                    Form(10, "1J")
                )
            }
            2 -> {
                return listOf(
                    Form(11, "2A"),
                    Form(12, "2B"),
                    Form(13, "2C"),
                    Form(14, "2D"),
                    Form(15, "2E"),
                    Form(16, "2F"),
                    Form(17, "2G"),
                    Form(18, "2H"),
                    Form(19, "2I"),
                    Form(20, "2J")
                )
            }
            3 -> {
                return listOf(
                    Form(21, "3A"),
                    Form(22, "3B"),
                    Form(23, "3C"),
                    Form(24, "3D"),
                    Form(25, "3E"),
                    Form(26, "3F"),
                    Form(27, "3G"),
                    Form(28, "3H"),
                    Form(29, "3I"),
                    Form(30, "3J")
                )
            }
        }
        return listOf()
    }
}

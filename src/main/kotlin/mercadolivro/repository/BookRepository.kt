package mercadolivro.repository

import mercadolivro.enums.BookStatus
import mercadolivro.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, Int> {
    abstract fun findByStatus(status: BookStatus): List<BookModel>

}
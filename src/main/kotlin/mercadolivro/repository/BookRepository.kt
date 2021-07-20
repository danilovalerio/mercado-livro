package mercadolivro.repository

import mercadolivro.enums.BookStatus
import mercadolivro.model.BookModel
import mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, Int> {
    abstract fun findByStatus(status: BookStatus): List<BookModel>
    fun findByCustomer(customer: CustomerModel) : List<BookModel>

}
package mercadolivro.repository

import mercadolivro.enums.BookStatus
import mercadolivro.model.BookModel
import mercadolivro.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository: JpaRepository<BookModel, Int> {
    abstract fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel) : List<BookModel>

    //fun findAll(pageable: Pageable): Page<BookModel>

}
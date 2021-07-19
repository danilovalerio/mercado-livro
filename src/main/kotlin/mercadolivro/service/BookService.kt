package mercadolivro.service

import mercadolivro.model.BookModel
import mercadolivro.repository.BookRepository

class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

}

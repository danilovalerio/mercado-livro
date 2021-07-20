package mercadolivro.controller

import mercadolivro.controller.request.PostBookRequest
import mercadolivro.controller.request.PutBookRequest
import mercadolivro.controller.response.BookResponse
import mercadolivro.extension.toBookModel
import mercadolivro.extension.toResponse
import mercadolivro.model.BookModel
import mercadolivro.service.BookService
import mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest){
        val customer = customerService.findById(request.customerId)

        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun getAll(): List<BookResponse> {
        return bookService.getAll().map { it.toResponse() }
    }

    @GetMapping("/active")
    fun findActives(): List<BookResponse> =
        bookService.findActives().map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookResponse =
        bookService.findById(id).toResponse()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.findById(id)
        bookService.update(book.toBookModel(bookSaved))
    }

}
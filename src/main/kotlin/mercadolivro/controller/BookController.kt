package mercadolivro.controller

import mercadolivro.controller.request.PostBookRequest
import mercadolivro.extension.toBookModel
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
        val customer = customerService.getById(request.customerId)

        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun getAll(): List<BookModel> {
        return bookService.getAll()
    }

    @GetMapping("/active")
    fun findActives(): List<BookModel> =
        bookService.findActives()
}
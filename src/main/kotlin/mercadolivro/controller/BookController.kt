package mercadolivro.controller

import mercadolivro.controller.request.PostBookRequest
import mercadolivro.extension.toBookModel
import mercadolivro.service.BookService
import mercadolivro.service.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    fun create(@RequestBody request: PostBookRequest){
        val customer = customerService.getById(request.customerId)

        bookService.create(request.toBookModel(customer))
    }
}
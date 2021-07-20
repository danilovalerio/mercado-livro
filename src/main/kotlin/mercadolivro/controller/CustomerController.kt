package mercadolivro.controller

import mercadolivro.controller.request.PostCustomerRequest
import mercadolivro.controller.request.PutCustomerRequest
import mercadolivro.controller.response.CustomerReponse
import mercadolivro.extension.toCustomerModel
import mercadolivro.extension.toResponse
import mercadolivro.model.CustomerModel
import mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(
    val customerService: CustomerService //Injeta a service para o controller fazer uso
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerReponse> {
        return customerService.getAll(name).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Especifica que o recurso foi criado com sucesso
    fun create(@RequestBody customer: PostCustomerRequest) {
        customerService.create(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerReponse {
        return customerService.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        val customerSaved = customerService.findById(id)
        customerService.update(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }
}
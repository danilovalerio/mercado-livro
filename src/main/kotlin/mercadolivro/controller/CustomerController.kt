package mercadolivro.controller

import mercadolivro.controller.request.PostCustomerRequest
import mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController {

    @GetMapping
    fun getCustomer(): CustomerModel {
        return CustomerModel("1", "Danilo", "meuemail@email.com")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Especifica que o recurso foi criado com sucesso
    fun create(@RequestBody customer: PostCustomerRequest) {
        println(customer)
    }

}
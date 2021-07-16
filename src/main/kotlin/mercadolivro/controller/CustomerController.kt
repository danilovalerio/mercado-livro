package mercadolivro.controller

import mercadolivro.model.CustomerModel
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController {

    @GetMapping
    fun getCustomer(): CustomerModel {
        return CustomerModel("1", "Danilo", "meuemail@email.com")
    }

    @PostMapping
    fun create(@RequestBody customer: CustomerModel): CustomerModel {
        return customer
    }

}
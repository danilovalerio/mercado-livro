package mercadolivro.service

import mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam

@Service //Essa classe é uma service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }
}
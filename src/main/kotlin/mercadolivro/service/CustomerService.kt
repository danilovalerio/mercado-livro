package mercadolivro.service

import mercadolivro.controller.request.PostCustomerRequest
import mercadolivro.controller.request.PutCustomerRequest
import mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
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

    //TODO:Aqui nao deveria receber um customerRequest e sim um objeto pronto
    fun create(customer: CustomerModel) {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }.toString()

        customer.id = id

        customers.add(customer)
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.filter { it.id == id }.first() //Ao encontrar para no primeiro registro o ID é unico
    }

    fun update(customer: CustomerModel) {
        //Ao encontrar para no primeiro registro o ID é unico
        customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}
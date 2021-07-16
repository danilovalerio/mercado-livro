package mercadolivro.service

import mercadolivro.controller.request.PostCustomerRequest
import mercadolivro.controller.request.PutCustomerRequest
import mercadolivro.model.CustomerModel
import mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service //Essa classe é uma service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception("Id not exists.")
        }
    }

    fun delete(id: Int) {
        if (!customerRepository.existsById(id)) {
            throw Exception("Id not exists.")
        }

        customerRepository.deleteById(id)
    }
}
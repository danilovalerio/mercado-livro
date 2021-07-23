package mercadolivro.service

import mercadolivro.enums.CustomerStatus
import mercadolivro.enums.Errors
import mercadolivro.exception.NotFoundException
import mercadolivro.model.CustomerModel
import mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service //Essa classe é uma service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
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

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id)
            .orElseThrow { NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code) }
    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception("Id not exists.")
        }
    }

    fun delete(id: Int) {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INATIVO

        customerRepository.save(customer)
    }

    fun emailDisponivel(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }
}
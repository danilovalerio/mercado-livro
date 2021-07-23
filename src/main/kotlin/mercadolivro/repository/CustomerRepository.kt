package mercadolivro.repository

import mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<CustomerModel, Int> {

    fun findByNameContaining(name: String): List<CustomerModel>
    abstract fun existsByEmail(email: String): Boolean
}
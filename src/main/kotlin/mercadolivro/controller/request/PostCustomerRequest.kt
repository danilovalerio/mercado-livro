package mercadolivro.controller.request

import mercadolivro.model.CustomerModel

/**
 * Esse post igona o ID informado para cadastro pelo usuário
 * Pois não faz sentido, tem que ser controlado internamente
 */
data class PostCustomerRequest(
    val name: String,
    val email: String
) {
    fun toCustomerModel(): CustomerModel {
        return CustomerModel(name = this.name,email = this.email)
    }
}
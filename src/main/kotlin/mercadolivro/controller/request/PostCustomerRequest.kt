package mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

/**
 * Esse post igona o ID informado para cadastro pelo usuário
 * Pois não faz sentido, tem que ser controlado internamente
 */
data class PostCustomerRequest(
    @field:NotEmpty
    val name: String,

    @field:Email
    val email: String
)
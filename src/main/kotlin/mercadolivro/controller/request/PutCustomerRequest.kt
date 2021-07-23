package mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

/**
 * Esse post igona o ID informado para cadastro pelo usuário
 * Pois não faz sentido, tem que ser controlado internamente
 */
data class PutCustomerRequest(
    @field:NotEmpty(message = "Nome deve ser informado.")
    val name: String,

    @field:Email(message = "E-mail deve ser valido.")
    val email: String
)
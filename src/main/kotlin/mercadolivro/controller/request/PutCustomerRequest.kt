package mercadolivro.controller.request

import mercadolivro.exception.EMAIL_INVALIDO
import mercadolivro.exception.NOME_VAZIO
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

/**
 * Esse post igona o ID informado para cadastro pelo usuário
 * Pois não faz sentido, tem que ser controlado internamente
 */
data class PutCustomerRequest(
    @field:NotEmpty(message = NOME_VAZIO)
    val name: String,

    @field:Email(message = EMAIL_INVALIDO)
    val email: String
)
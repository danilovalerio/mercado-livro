package mercadolivro.controller.request

import mercadolivro.exception.EMAIL_INVALIDO
import mercadolivro.exception.NOME_VAZIO
import mercadolivro.validation.EmailDisponivel
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

/**
 * Esse post igona o ID informado para cadastro pelo usuário
 * Pois não faz sentido, tem que ser controlado internamente
 */
data class PostCustomerRequest(
    @field:NotEmpty(message = NOME_VAZIO)
    val name: String,

    @field:Email(message = EMAIL_INVALIDO)
    @EmailDisponivel(message = "E-mail já existe.")
    val email: String
)
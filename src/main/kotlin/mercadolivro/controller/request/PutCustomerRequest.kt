package mercadolivro.controller.request

/**
 * Esse post igona o ID informado para cadastro pelo usuário
 * Pois não faz sentido, tem que ser controlado internamente
 */
data class PutCustomerRequest(
    val name: String,
    val email: String
)
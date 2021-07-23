package mercadolivro.exception

/**
 * Exception não encontrado
 */
class NotFoundException(override val message: String, val errorCode: String): Exception() {
}
package mercadolivro.exception

/**
 * Exception não encontrado
 */
class BadRequestException(override val message: String, val errorCode: String): Exception() {
}
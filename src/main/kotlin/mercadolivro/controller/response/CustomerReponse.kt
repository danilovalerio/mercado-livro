package mercadolivro.controller.response

import mercadolivro.enums.CustomerStatus

data class CustomerReponse(
    var id: Int? = null,
    var name: String,
    var email: String,
    var status: CustomerStatus
)

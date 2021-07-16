package mercadolivro.extension

import mercadolivro.controller.request.PostCustomerRequest
import mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name,email = this.email)
}
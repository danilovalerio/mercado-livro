package mercadolivro.validation

import mercadolivro.service.CustomerService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

/**
 * Um validator que extend de constraint, passando a Annotation e o tipo String, pois e-mail é uma string
 */
class EmailDisponivelValidator(
    var customerService: CustomerService
) : ConstraintValidator<EmailDisponivel, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            return false
        }
        return customerService.emailDisponivel(value)
    }
}

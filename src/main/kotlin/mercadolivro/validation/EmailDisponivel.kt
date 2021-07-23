package mercadolivro.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

/**
 * Annotation customizada
 * Target - Alvo, CLASS | FIELD etc...
 */

@Constraint(validatedBy = [EmailDisponivelValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class EmailDisponivel(//TODO: Testar novamente a validacao
    val message: String = "Email já cadastrado",
    val group: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

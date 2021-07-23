package mercadolivro.enums

enum class Errors(val code: String,val message: String) {
    /** 100 - 199 Faixa de erros referentes a books */
    /** 200 - 299 Faixa de erros referentes a books */
    ML101("ML-101", "Book [%s] not exists"),
    ML201("ML-201", "Customer [%s] not exists")
}
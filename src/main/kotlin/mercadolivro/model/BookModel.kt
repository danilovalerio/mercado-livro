package mercadolivro.model

import mercadolivro.enums.BookStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @Column
    var name: String,
    @Column
    var price: BigDecimal,
    @Column

    @Enumerated(EnumType.STRING) //Esse item só receberá um valor ENUM
    var status: BookStatus? = null,

    @ManyToOne //Muitos livro para um usuário
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
)

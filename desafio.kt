enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val idade: Int, val email: String)

data class ConteudoEducacional(val id: Int, val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    fun matricular(usuario: Usuario, nomeFormacao: String) {
        inscritos[usuario.nome] = nomeFormacao
        println("Usuario(a) ${usuario.nome} foi matriculado(a) na Formação: $nomeFormacao")
    }
}
val inscritos = mutableMapOf<String, String>()

fun listaDeInscritos() {
    println("Lista de usuarios matriculados: ")
    inscritos.forEach { (k, v) ->
        println("Usuario:$k = Matriculado em: $v")
    }
}

fun main() {

    val user1 = Usuario("João", 18, "joao@desafiodio.com")
    val user2 = Usuario("Maria", 20, "maria@desafiodio.com")
    val user3 = Usuario("Daniel", 25, "daniel@desafiodio.com")

    val k1 = ConteudoEducacional(1, "Introdução a linguagem de programação Kotlin ", 60, Nivel.BASICO)
    val k2 = ConteudoEducacional(2, "Estruturas de controle em Kotlin", 60, Nivel.BASICO)
    val k3 = ConteudoEducacional(3, "Orientação a objetos em Kotlin", 120, Nivel.INTERMEDIARIO)
    val k4 = ConteudoEducacional(4, "O poder das Funções em Kotlin", 120, Nivel.INTERMEDIARIO)
    val k5 = ConteudoEducacional(5, "Tratamento de exceções em Kotlin", 120, Nivel.AVANCADO)

    val j1 = ConteudoEducacional(6, "Introdução a linguagem de programação Java ", 60, Nivel.BASICO)
    val j2 = ConteudoEducacional(7, "Estruturas de controle em Java", 60, Nivel.BASICO)
    val j3 = ConteudoEducacional(8, "Orientação a objetos em Java", 120, Nivel.INTERMEDIARIO)
    val j4 = ConteudoEducacional(9, "O poder das Funções em Java", 120, Nivel.INTERMEDIARIO)
    val j5 = ConteudoEducacional(10, "Tratamento de exceções em Java", 120, Nivel.AVANCADO)

    val formJava = Formacao("Java", listOf(j1, j2, j3, j4, j5))
    val formKotlin = Formacao("Kotlin", listOf(k1, k2, k3, k4, k5))

    formJava.matricular(user2, formJava.nome)
    formKotlin.matricular(user1, formKotlin.nome)
    formKotlin.matricular(user3, formKotlin.nome)
    println()

    listaDeInscritos()

}

programa
{
 funcao inicio()
 {
  inteiro soma_total
  soma_total = somar(5, 3) // Capturando o valor retornado
  escreva("A soma de 5 e 3 é: ", soma_total, "\n")

  escreva("A soma de 10 e 20 é: ", somar(10, 20), "\n") // Chamando e exibindo diretamente
 }

 funcao inteiro somar(inteiro a, inteiro b)
 {
  inteiro resultado
  resultado = a + b
  retorne resultado
 }
}
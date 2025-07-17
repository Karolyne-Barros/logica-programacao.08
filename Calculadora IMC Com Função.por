programa
{
  // Função para ler um número real do usuário
  funcao real lerNumero(cadeia mensagem)
  {
    real numero
    escreva(mensagem)
    leia(numero)
    retorne numero
  }

  // Função para calcular o IMC
  funcao real calcularIMC(real peso, real altura)
  {
    real imc = peso / (altura * altura)
    retorne imc
  }

  // Função para exibir a classificação do IMC
  funcao exibirClassificacaoIMC(real imc)
  {
    escreva("Seu IMC é: " + imc + "\n")
    se (imc < 18.5) {
      escreva("Classificação: Abaixo do peso\n")
    } senao se (imc < 24.9) {
      escreva("Classificação: Peso normal\n")
    } senao {
      escreva("Classificação: Sobrepeso\n")
    }
  }

  funcao inicio()
  {
    real peso_digitado, altura_digitada, imc_calculado

    peso_digitado = lerNumero("Digite seu peso (kg): ")
    altura_digitada = lerNumero("Digite sua altura (m): ")

    imc_calculado = calcularIMC(peso_digitado, altura_digitada)

    exibirClassificacaoIMC(imc_calculado)
  }
}
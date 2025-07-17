programa
{
  funcao somar(inteiro a, inteiro b)
 {
  inteiro resultado
  resultado = a + b
  escreva(resultado)
 }


  funcao subtrair(inteiro a, inteiro b) {
    inteiro resultado
  resultado = a - b
  escreva(resultado)
  }

  funcao multiplicar(real a, real b) {
    real resultado
  resultado = a * b
  escreva(resultado)
  }

  funcao dividir(real a, real b) {
    real resultado
  resultado = a / b
  escreva(resultado)
  }


 funcao inicio()
 {
  escreva("A soma de 5 e 3 é: ") 
    somar(5, 3) 

    escreva("\n")

    escreva("A subtração de 9 e 2 é: ") 
    subtrair(9, 2) 

    escreva("\n")

    escreva("A multiplicação de 9 e 2 é: ") 
    multiplicar(9.0, 2.0) 

    escreva("\n")

    escreva("A divisão de 5 e 2 é: ") 
    dividir(5.0, 2.0) 
 } 

  
}
# Projeto FiapRide - Luiz Gustavo de Almeida

## 📊 Informações do Aluno

- **Nome:** Luiz Gustavo de Almeida
- **RM:** 566613
- **Turma:** 2CCPR
- **Curso:** Ciências da computação
- **GitHub:** [@gstvalma](https://github.com/gstvalma)

---

## 🎯 Descrição do Projeto

Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos o sistema **FiapRide**, um app de mobilidade urbana (tipo Uber) com passageiros, carteira digital, veículos (carro, moto, carro elétrico) e viagens.

Junto com ele desenvolvi o meu projeto pessoal, um **sistema de cadastro de pets para uma clínica veterinária**, com pets (cachorro, gato e pássaro), tutores e vacinação.

---

## ✅ Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## 🤔 Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`?

**Pense:** E se o FiapRide tiver 1 milhão de usuários? Como a Classe ajuda a resolver isso?

**Sua Resposta:**
Com 2 passageiros as variáveis soltas até funcionam, mas com 1 milhão eu teria que criar 2 milhões de variáveis (`nomeAna`, `saldoAna`, `nomeCarlos`...) e nada garante que o `saldoAna` é mesmo da Ana. A classe é o molde: eu escrevo uma vez o que todo passageiro tem e depois só faço `new Passageiro(...)` quantas vezes precisar, e cada objeto guarda os próprios dados juntos.
Isso também ajuda a manter: se amanhã o passageiro precisar de CPF, eu adiciono em um lugar só (foi o que aconteceu na aula 2). No meu projeto foi igual, a classe `Pet` me deixou criar o Hemerson e a Maria Braga com o mesmo molde, só mudando os valores.

---

### Aula 2 - Métodos

**Pergunta:** Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100` diretamente no código principal, por que dá tanto trabalho criar um método específico chamado `adicionarSaldo(valor)` para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade se deixássemos qualquer programador alterar o saldo diretamente?

**Sua Resposta:**
Porque o método é o único lugar onde a regra de negócio fica. Dentro do `adicionarSaldo()` tem o `if (valor <= 0)` que impede recarga negativa, e no `pagarViagem()` tem a verificação de saldo suficiente. Se cada programador mexer direto no atributo, cada um vai lembrar (ou esquecer) da regra de um jeito, e uma hora alguém coloca `saldo = saldo - 500` sem checar nada.
Para uma startup isso vira prejuízo real: passageiro com saldo negativo andando de graça, recarga de "-20 reais", ou até fraude. Com o método, se a regra mudar (ex: recarga mínima de R$ 10) eu altero em um lugar só. No meu Pet fiz o mesmo com o `atualizarPeso()`, que não aceita peso negativo nem acima de 100 kg.

---

### Aula 3 - Encapsulamento

**Pergunta:** No nosso código, os atributos são `private`, mas os métodos `getSaldo()` e `getNome()` são `public`. Por que é seguro deixar o `get` público, mas perigoso deixar o atributo original público?

Pense bem: Qual a diferença entre dar a alguém uma CÓPIA de um documento seu, e entregar o documento ORIGINAL para a pessoa rasurar?

**Sua Resposta:**
O `get` só devolve o valor, é como entregar uma cópia do documento: a pessoa pode ler, mas se rasurar a cópia o original continua igual. Já o atributo `public` é entregar o original, qualquer classe pode escrever `passageiro1.saldo = 999999` e o objeto não tem como se defender.
Por isso deixei os setters do `Passageiro` como `private`: o saldo só muda pelo `adicionarSaldo()` e `pagarViagem()`. No Pet, o `setIdade()` é público mas tem a regra de 0 a 40 anos, e o `setPeso()` é privado porque a ação real é "pesar o pet" (`atualizarPeso`). Quando testei `pet2.idade = -5` no main, nem compilou, e foi aí que eu entendi que o erro vermelho era a proteção funcionando.

---

### Aula 4 - Construtores

**Pergunta:** Na nossa classe `Veiculo`, nós tomamos duas decisões arquitetônicas muito importantes:

1. Nós **não** criamos o método `setModelo()`.
2. O `setPlaca()` foi criado como **privado**, e criamos um método público chamado `atualizarPlaca()` para acessá-lo.

Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em 'Gerar Getters e Setters para tudo' automaticamente na sua IDE? Como as nossas duas decisões acima protegem o sistema de fraudes e falhas de lógica?

_Dica: Pense sobre o que pode ou não mudar fisicamente em um carro, e a diferença entre "alterar um dado no banco" e "executar um processo real no Detran"_

**Sua Resposta:**
Gerar tudo automático cria uma "porta" para cada atributo, inclusive para coisas que nunca deveriam mudar. Um Fiat Uno não vira um Corolla, então se existisse `setModelo()` alguém poderia trocar o modelo de um carro cadastrado e o passageiro entraria num carro diferente do que aparece no app, o que é um risco de segurança.
A placa pode mudar, mas não é só trocar um texto no banco: no mundo real é um processo no Detran. O `atualizarPlaca()` representa esse processo e chama o `setPlaca()` privado, que valida (não aceita placa vazia). Assim o único caminho para mudar a placa passa pela regra.
Fiz a mesma coisa no Pet: tirei o `setEspecie()` porque um cachorro não vira gato, a espécie só é definida no construtor. E o construtor garante que todo pet já nasce com nome e espécie; o construtor padrão `Pet()` usa `this(...)` para chamar o construtor completo com valores padrão, sem repetir código.

---

### Aula 5 - Associação

**Pergunta:** No construtor da `Viagem`, nós exigimos o objeto inteiro (`Passageiro solicitante`). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve pedir apenas a String do nome no construtor da Viagem (`String nomeDoPassageiro`) em vez do objeto todo?

_Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa descontar o saldo? Se a Viagem tiver apenas a String "Ana Silva", ela consegue mexer no dinheiro dela?_

**Sua Resposta:**
Não, porque a String é só um texto, ela não tem saldo nem métodos. Quando a viagem termina é preciso cobrar a passageira, e com o objeto a Viagem consegue chamar `solicitante.pagarViagem(valor)`. Foi exatamente isso que eu fiz no método `finalizarViagem()`. Com só o nome não teria como descontar nada, e ainda poderiam existir duas "Ana Silva".
Também não fica "mais pesado": o Java passa a referência do objeto, não uma cópia. Deu para ver isso no teste: a Ana colocou saldo depois de a viagem ser criada e a viagem enxergou o saldo novo. No meu projeto o Pet guarda o objeto `Tutor`; quando o tutor atualiza o telefone, a ficha do pet já mostra o número novo.

---

### Aula 6 - Herança

**Pergunta:** No nosso código, a mãe `Veiculo` possui os atributos `placa` e `modelo` como `private`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o código dentro de `Carro` NÃO consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super()` ou o `setPlaca()`.

Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princípio das aulas passadas que isso está protegendo?

**Sua Resposta:**
É o **encapsulamento** da aula 3. A regra de validação da placa está dentro da `Veiculo`; se a filha pudesse escrever `this.placa = ""` direto, ela pulava a validação, e qualquer classe nova (uma `Van`, um `Caminhao`) poderia quebrar a regra sem ninguém perceber. Herdar não quer dizer ter acesso a tudo: o `Carro` é um Veiculo, mas tem que respeitar as regras da mãe.
Por isso a filha usa o `super(placa, modelo)`, que passa os dados para o construtor da mãe fazer a validação. No Pet foi igual: `Cachorro`, `Gato` e `Passaro` chamam `super(nome, "Cachorro", tutor)` e para ler os dados usam `getPeso()`, `getNome()`. Os atributos exclusivos (porte, castrado, asaCortada) ficaram `private` em cada filha.

---

### Aula 7 - Polimorfismo

**Pergunta:** No nosso loop `for (Veiculo veiculo : frota)`, a variável `veiculo` é do tipo genérico `Veiculo`. Se esquecêssemos de criar o método `calcularAutonomia()` lá na classe mãe `Veiculo`, nós conseguiríamos chamá-lo dentro do loop, mesmo sabendo que ele existe dentro do `Carro` e da `Moto`? Por que o contrato precisa existir na base da hierarquia?

**Sua Resposta:**
Não conseguiríamos, dá erro de compilação. O compilador olha o tipo da variável (`Veiculo`) e não o objeto que está dentro dela, então só deixa chamar o que existe em `Veiculo`. Só na hora de rodar o Java descobre se é Carro ou Moto e executa a versão certa (10 km/l ou 35 km/l).
Por isso o "contrato" tem que estar na mãe: é ele que promete que todo veículo sabe calcular autonomia. Sem ele eu teria que fazer `if (veiculo instanceof Carro)` para cada tipo, e toda vez que entrasse um tipo novo teria que mexer no loop. No meu projeto o `emitirSom()` e o `calcularRacaoDiaria()` estão na `Pet`, e a lista `List<Pet>` imprime "Au Au!", "Miau!" e "Piu piu!" sem nenhum if.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Pense no mundo real: Faz sentido existir um objeto que é APENAS 'Veículo' sem ser um tipo específico? Você já entrou em uma concessionária e comprou "um veículo" genérico, sem ser carro, moto, caminhão ou nada disso?

Por que, então, no código, precisamos EXPLICITAMENTE dizer ao Java que `Veiculo` é `abstract`? Por que ele não deduz isso sozinho?

Pense: Se esquecermos de colocar `abstract`, qual o risco que corremos? Alguém pode criar `new Veiculo()` e quebrar a lógica do nosso sistema?

**Sua Resposta:**
Não faz sentido, ninguém compra "um veículo", compra um carro ou uma moto. Mas o Java não tem como saber disso, para ele `Veiculo` é uma classe como qualquer outra; o que é genérico ou concreto é uma decisão de negócio, então quem decide somos nós, e o `abstract` é a forma de deixar essa decisão escrita no código.
Sem o `abstract`, alguém poderia fazer `new Veiculo("ABC-1234", "Generico")` e colocar na frota. Esse veículo não teria autonomia de verdade ("Autonomia não definida...") e nem tipo, e uma viagem poderia ser feita com ele. Com o `abstract` o compilador bloqueia, e o método abstrato `exibirTipo()` obriga toda filha nova a implementar.
No Pet foi a mesma coisa: na clínica não existe "um pet" sem espécie, então `Pet` virou abstrata e o `emitirSom()` abstrato. Precisei mudar os testes antigos que faziam `new Pet(...)` para usar `Cachorro`/`Gato`, e aí vi na prática o compilador me protegendo.

---

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite herança simples (apenas uma mãe), mas múltipla implementação de interfaces (vários contratos)?

Pense: Se `CarroEletrico` pudesse herdar de `Veiculo` E de `Bateria` ao mesmo tempo (herança múltipla), o que aconteceria se AMBAS as mães tivessem um método chamado `ligar()`?

Como as interfaces resolvem esse problema?

**Sua Resposta:**
Se as duas mães tivessem `ligar()` com códigos diferentes, o Java não saberia qual executar no `carroEletrico.ligar()` (é o "problema do diamante"). Com uma mãe só nunca tem essa dúvida de qual implementação herdar.
A interface resolve porque ela é só um contrato: tem a assinatura do método, mas não tem o código. Se duas interfaces pedirem o mesmo `ligar()`, a classe escreve uma implementação só e cumpre as duas. Então o `CarroEletrico` herda o "ser um veículo" da `Veiculo` e assina o contrato `Recarregavel`, junto com o `Celular`, que não tem nada a ver com veículo.
No meu projeto criei a `Vacinavel`, com a constante `IDADE_MINIMA_VACINA_MESES = 2`. `Cachorro` e `Gato` implementam, `Passaro` não (pássaro não toma antirrábica), e o `Tutor`, que nem é Pet, também implementa. Coloquei todos num array `Vacinavel[]` e chamei `vacinar()` de uma vez só.

---

## 🚀 Desafios Técnicos Implementados

### Desafio Pessoal (Seu Projeto)

**Qual foi o domínio que você escolheu para seu projeto pessoal?**
Sistema de cadastro de Pets para uma clínica veterinária / pet shop.

**Quais classes você criou?**
`Pet` (abstrata), `Cachorro`, `Gato`, `Passaro`, `Tutor` e a interface `Vacinavel`. O teste fica em `TestePet`.

| Aula | O que entrou no projeto pessoal                                                                            |
| ---- | ---------------------------------------------------------------------------------------------------------- |
| 1    | Classe `Pet` com nome, espécie e idade                                                                     |
| 2    | `fazerAniversario()`, `atualizarPeso()`, `calcularIdadeEmMeses()` e `calcularRacaoDiaria()` com validações |
| 3    | Atributos `private`, getters/setters, regra de idade (0 a 40) e nome não vazio                             |
| 4    | Construtor padrão + customizados com `this(...)`, sem `setEspecie()`                                       |
| 5    | Classe `Tutor` associada ao Pet, `trocarTutor()` e `exibirFicha()`                                         |
| 6    | `Cachorro` (porte P/M/G), `Gato` (castrado / `castrar()`), `Passaro` (asa cortada)                         |
| 7    | `emitirSom()` e `calcularRacaoDiaria()` sobrescritos com `@Override`                                       |
| 8    | `Pet` abstrata com `emitirSom()` abstrato                                                                  |
| 9    | Interface `Vacinavel` em `Cachorro`, `Gato` e `Tutor`                                                      |

**Qual foi o maior desafio técnico que você enfrentou?**
O maior desafio foi na aula 8, quando transformei `Pet` (e `Veiculo`) em abstrata. Na hora todo o meu `TestePet` ficou vermelho, porque desde a aula 2 eu criava os pets com `new Pet("Hemerson", "Cachorro", 1.0)`. No começo achei que tinha quebrado o projeto, mas depois entendi que era justamente o `abstract` fazendo o trabalho dele.
Para resolver, reescrevi os testes das aulas anteriores usando as filhas (`new Cachorro(...)`, `new Gato(...)`). Só que apareceu outro problema: o construtor padrão da aula 4 (`new Pet()`) não podia mais ser usado direto. A solução foi criar construtores padrão nas filhas (`Gato()` chama `this("Sem nome", null, false)`), mantendo a ideia do pet resgatado sem informação.
Outro ponto que me pegou foi a ordem dos construtores com `this(...)`: o `this()` tem que ser a primeira linha, e eu tive que deixar o `Pet(nome, especie, tutor)` como construtor principal e fazer os outros chamarem ele. Também tive um erro bobo no `fazerAniversario()`, que mostrava "Parabéns" mesmo quando a idade era bloqueada; corrigi colocando a validação antes de alterar.
Por fim, na associação demorei para entender que passar o objeto `Tutor` não copia ele: testei alterando o telefone do tutor depois e vi que a ficha do pet já mostrava o novo número, que é a mesma ideia da Viagem enxergando o saldo novo da Ana.

---

## 🎓 Conclusão

**O que você aprendeu nestas 9 aulas?**
Aprendi que orientação a objetos é mais sobre organizar e proteger as regras do sistema do que sobre sintaxe. Comecei com uma classe com 3 atributos públicos e terminei com uma hierarquia com classe abstrata, interface e associação. O que mais mudou minha forma de pensar foi parar de criar get/set para tudo e começar a perguntar "isso pode mudar no mundo real?" e "qual é a ação de verdade?" (`atualizarPlaca`, `atualizarPeso`, `castrar`). Também aprendi a organizar o repositório (o `.gitignore` estava dentro de `src` e eu tinha subido a pasta `.metadata` do Eclipse inteira, que corrigi no primeiro commit do checkpoint) e passei a usar o VS Code em vez do Eclipse.

**Qual conceito foi mais difícil de entender?**
Polimorfismo. No começo eu não entendia por que `Veiculo veiculo = new Carro(...)` chamava o método do Carro, sendo que a variável é do tipo Veiculo. O que me ajudou foi separar as duas coisas: o tipo da variável decide **o que** posso chamar (por isso o método tem que existir na mãe) e o objeto decide **qual versão** roda. Depois de fazer o loop dos pets imprimindo "Au Au!" e "Miau!" sem nenhum `if`, ficou claro.

**O que você melhoraria no seu projeto se pudesse refazer?**

- O código de vacinação está repetido em `Cachorro` e `Gato` (mesma regra de idade mínima). Eu criaria uma classe intermediária ou um método auxiliar para não duplicar.
- Os erros são só `System.out.println`; o método não avisa quem chamou se deu certo ou não (por exemplo, o `finalizarViagem()` não sabe se o `pagarViagem()` foi bloqueado). Eu faria os métodos retornarem `boolean` ou usaria exceções.
- Usaria uma lista de vacinas (`List<String>`) em vez de só um contador, para ter o histórico.
- Separaria os testes por aula em métodos menores, porque os `main` ficaram muito grandes.

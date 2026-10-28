# fiap-poo

Exercícios de POO - FIAP.

Projeto da aula: **FiapRide** (sistema de mobilidade urbana).
Projeto pessoal: **Pet** (cadastro de pets).

## Classe Pet

Representa um animal de estimação do mundo real (cachorro, gato, calopsita...). Guarda o nome, a espécie, a idade (em anos) e o peso (em kg).

### Métodos

| Método | O que faz | Regra de negócio |
|---|---|---|
| `fazerAniversario()` | soma 1 ano na idade do pet | a idade não pode passar de 40 anos |
| `atualizarPeso(double novoPeso)` | altera o peso do pet | o peso tem que ser maior que 0 e no máximo 100 kg |
| `calcularIdadeEmMeses()` | retorna a idade em meses (`int`) | - |
| `calcularRacaoDiaria()` | retorna quantos gramas de ração o pet come por dia (20g por kg) | se o peso não foi cadastrado retorna 0 |

### Como usar

```java
Pet pet1 = new Pet();
pet1.nome = "Hemerson";
pet1.especie = "Cachorro";
pet1.idade = 1.0;

pet1.atualizarPeso(12.5);      // ok
pet1.atualizarPeso(-3);        // bloqueado, peso inválido
pet1.fazerAniversario();       // idade vai para 2.0
pet1.calcularRacaoDiaria();    // 250.0 gramas
```

Para rodar, execute a classe `br.com.fiapride.main.SistemaPrincipal`.

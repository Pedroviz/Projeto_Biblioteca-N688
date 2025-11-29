# 📚 Sistema de Biblioteca – Projeto N688

## 👤 Dados do Aluno

**Aluno:** Pedro Atila Freitas Costa
**Matrícula:** 2323832
**Curso:** Análise e Desenvolvimento de Sistemas (ADS)
**Disciplina:** N688 – Ambiente de Dados
**GitHub:** [https://github.com/Pedroviz](https://github.com/Pedroviz)

---

## 📘 Descrição do Projeto

Este projeto consiste em um sistema simples de Biblioteca desenvolvido em **Java**, utilizando **MySQL** como banco de dados e **JDBC** para conexão.

Ele permite:

- Cadastro de alunos
- Cadastro de livros
- Realização de empréstimos
- Listagem de alunos, livros e empréstimos

O sistema funciona totalmente no terminal e foi organizado seguindo boas práticas básicas de programação.

---

## 🛠 Tecnologias Utilizadas

- **Java 17+**
- **MySQL Server**
- **MySQL Workbench**
- **MySQL Connector/J 9.5.0**
- **VS Code**
- Terminal macOS Ventura

---

## 🗂 Estrutura do Projeto

```
Projeto_Biblioteca-N688/
 ├── lib/
 │    └── mysql-connector-j-9.5.0.jar
 ├── src/
 │    ├── dao/
 │    ├── model/
 │    ├── util/
 │    ├── Main.java
 │    └── TesteConexao.java
 ├── out/
 └── run.sh
```

---

## ⚙️ Configuração do Ambiente

### 1. Instalar MySQL Server e Workbench

Requer instalação padrão no macOS (Intel ou M1/M2). Durante a instalação, configure a senha do usuário `root`.

### 2. Verificar instalação do MySQL no terminal

```
mysql -u root -p
```

### 3. Criar o banco de dados

```
CREATE DATABASE biblioteca;
USE biblioteca;
```

### 4. Criar tabelas

As tabelas **Alunos**, **Livros** e **Emprestimos** são criadas automaticamente utilizando o script fornecido durante o desenvolvimento.

---

## 🚀 Executando o Projeto

### 1. Dar permissão ao script

```
chmod +x run.sh
```

### 2. Rodar o sistema

```
./run.sh
```

O script realiza automaticamente:

- Compilação completa do projeto
- Execução via JDBC
- Inicialização do menu principal

---

## 🔧 Teste de Conexão com o Banco

```
java -cp "out:lib/mysql-connector-j-9.5.0.jar" TesteConexao
```

Saída esperada:

```
Conexão estabelecida com sucesso!
```

---

## 📄 Observações Importantes

- O MySQL Connector deve estar na pasta **lib/**.
- O menu do sistema é iniciado a partir do arquivo **Main.java**.
- Necessário manter o MySQL rodando para que a conexão funcione.

---

## 📞 Contato do Aluno

Para dúvidas ou melhorias:
**GitHub:** [https://github.com/Pedroviz](https://github.com/Pedroviz)

---

## ✔ Status do Projeto

**Concluído e funcional ✔**

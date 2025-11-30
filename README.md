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
---
# 🛠️ Configuração do Ambiente

Para executar o projeto corretamente, é necessário configurar um ambiente básico de desenvolvimento.  
As etapas abaixo são universais e funcionam em qualquer sistema operacional (Windows, macOS ou Linux).

---

## ⚙️ Passo a Passo

### 1. Instale o Java Development Kit (JDK)
Certifique-se de ter uma versão atualizada do JDK (Java 17 ou superior).  
Isso permitirá compilar e executar aplicações Java no terminal.

---

### 2. Instale um gerenciador de banco de dados
O projeto utiliza **MySQL**, mas qualquer SGBD compatível com **JDBC** pode ser utilizado.  
Após a instalação, configure um usuário com permissões de criação e consulta de tabelas.

---

### 3. Crie o banco de dados do projeto
Execute o arquivo SQL fornecido ou crie manualmente as tabelas indicadas no diagrama ER.

---

### 4. Configure o driver JDBC
Baixe o driver JDBC apropriado (como o *MySQL Connector/J*)  
e adicione o arquivo `.jar` ao **classpath** do projeto.

---

### 5. Utilize um editor de código ou IDE de sua preferência
Pode ser **VS Code**, **IntelliJ IDEA**, **Eclipse** ou qualquer outro editor que suporte Java.  
Apenas certifique-se de apontar o classpath para o diretório `lib/`.

---

### 6. Compile e execute o projeto
A compilação pode ser feita via terminal ou por script.  
Após compilar, execute a classe principal para iniciar o sistema.

---

## ✔️ Pronto!
Com essa configuração, qualquer usuário em qualquer sistema operacional consegue preparar o ambiente e rodar o projeto sem dificuldades.


## ⚙️ Configuração do Ambiente /(Mac Os)

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

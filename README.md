# Fintech - Projeto Integrador FIAP

## Descrição
Sistema de gestão financeira pessoal desenvolvido como parte do Projeto Integrador da FIAP.  
Permite ao usuário controlar **receitas, despesas e saldo**, com backend em **Spring Boot** e frontend em **React (Vite)**, integrados ao banco **Oracle FIAP**.

---

## Funcionalidades
- **CRUD completo** para Usuário, Receita e Despesa  
- **Autenticação de login**  
- **Dashboard com resumo financeiro**  
- Integração **frontend ↔ backend ↔ Oracle**  
- Páginas SPA com **React Router** e **Hooks**

---

## Tecnologias
**Backend:** Java 17, Spring Boot, JPA, Maven, Oracle  
**Frontend:** React (Vite), React Router DOM, Axios, JavaScript, HTML, CSS  

---

## Estrutura
```
📦 fintech
├── backend/   → API REST (Spring Boot)
└── frontend/  → Interface Web (React)
```

---

## Instruções de Execução

### Backend
1. Configure o arquivo `application.properties` com o acesso ao Oracle FIAP:
   ```properties
   spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   ```
2. No terminal:
   ```bash
   cd backend
   mvn spring-boot:run
   ```
   A API iniciará em: **http://localhost:8080**

### Frontend
1. No terminal:
   ```bash
   cd frontend
   npm install
   npm run dev
   ```
   Acesse: **http://localhost:5173**

---

## Login de Teste
```
Email: lucascasotti@fintech.com
Senha: 12345
```

---

## Entidades
| Entidade | Descrição |
|-----------|------------|
| Usuário | Cadastro e autenticação de usuários |
| Receita | Registro de ganhos |
| Despesa | Registro de gastos |

---

## Autor
**Lucas Casotti**  
Análise e Desenvolvimento de Sistemas – FIAP  

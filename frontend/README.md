# Controle Financeiro - Frontend (React + Vite)

Este frontend consome o backend do projeto `Casotti10/controle-finan-as`.

Importante: O backend atual não retorna um token JWT no endpoint `/api/login`. Em vez disso o backend retorna `usuarioId` e `usuarioNome`. Por isso este frontend salva um objeto de autenticação no `localStorage` (chave `auth`) e envia um header `Authorization: Bearer <token-simulado>` nas requisições. Se o backend for atualizado para retornar JWT, basta ajustar `src/services/authService.js`.

Como rodar:

1. Instalar dependências:

```bash
npm install
```

2. Iniciar em modo desenvolvimento:

```bash
npm run dev
```

Endpoints usados (do backend):
- POST /api/login
- POST /api/usuario
- GET /api/receita, POST /api/receita, PUT /api/receitas/{id}, DELETE /api/receitas/{id}
- GET /api/despesa, POST /api/despesa, PUT /api/despesas/{id}, DELETE /api/despesas/{id}
- GET /api/relatorio/saldo/{usuarioId}?ano=YYYY&mes=MM
 - POST /api/usuarios
 - GET /api/receitas, POST /api/receitas, PUT /api/receitas/{id}, DELETE /api/receitas/{id}
 - GET /api/despesas, POST /api/despesas, PUT /api/despesas/{id}, DELETE /api/despesas/{id}
 - GET /api/relatorio/saldo/{usuarioId}?ano=YYYY&mes=MM

Estrutura de pastas principal:
- src/components  (reutilizáveis)
- src/pages       (páginas / rotas)
- src/services    (axios, auth)
- src/utils       (formatadores / validadores)
- src/styles      (CSS)


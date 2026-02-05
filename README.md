👤 Usuários
➕ Criar usuário
POST /users
Request:
{
  "name": "Maria Oliveira",
  "email": "maria@gmail.com",
  "cpf": "22222222222",
  "password": "123456",
  "isAdmin": false,
  "isActive": true
}
📋 Listar todos os usuários
GET /users
🔍 Buscar usuário por ID
GET /users/{id}
Exemplo:
/users/6
✏️ Atualizar usuário
PUT /users/{id}
Request:
{
  "name": "Maria Silva",
  "email": "maria@gmail.com",
  "password": "novaSenha123",
  "isActive": true
}
❌ Deletar usuário
DELETE /users/{id}
=================================================================================
🐶 Pets
➕ Criar pet
POST /pets
Request:
{
  "name": "Rex",
  "species": "Cachorro",
  "breed": "Labrador",
  "age": 2,
  "price": 1500.00,
  "isAvailable": true
}
🔍 Buscar pet por ID
GET /pets/{id}
Exemplo:
/pets/5
📋 Listar pets (com filtros opcionais)
GET /pets
Parâmetros opcionais (query params):
species → espécie do animal
isAvailable → disponibilidade
maxPrice → preço máximo
Exemplos:
Listar todos:
/pets
Filtrar por espécie:
/pets?species=Cachorro
Filtrar por disponibilidade:
/pets?isAvailable=true
Filtrar por preço máximo:
/pets?maxPrice=1000
Combinação de filtros:
/pets?species=Gato&isAvailable=true&maxPrice=800
✏️ Atualizar pet
PUT /pets/{id}
Request:
{
  "name": "Rex",
  "species": "Cachorro",
  "breed": "Golden Retriever",
  "age": 3,
  "price": 1800.00,
  "isAvailable": true
}
Exemplo:
/pets/5
❌ Deletar pet
DELETE /pets/{id}
Exemplo:
/pets/5
=================================================================================
🔐 Autenticação
➕ Login do usuário
POST /auth/login
Request:
{
  "email": "usuario@gmail.com",
  "password": "123456"
}
Response (exemplo — token JWT ou similar):
"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
🚪 Logout do usuário
POST /auth/logout
Header:
Authorization: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
Exemplo de uso:
POST /auth/logout
Authorization: SEU_TOKEN_AQUI
=================================================================================
🛒 Pedidos (Orders)
➕ Criar pedido para um usuário
POST /orders
Parâmetro (query param):
userId=1
Exemplo:
POST /orders?userId=1
📋 Listar pedidos de um usuário
GET /orders/user/{userId}
Exemplo:
/orders/user/1
➕ Adicionar item a um pedido
POST /orders/{orderId}/items
Parâmetros (query params):
productId=10
quantity=2
Exemplo:
POST /orders/5/items?productId=10&quantity=2
❌ Remover item do pedido
DELETE /orders/{orderId}/items/{itemId}
Exemplo:
/orders/5/items/3
📋 Listar todos os pedidos
GET /orders
Exemplo:
/orders
✅ Finalizar pedido
POST /orders/{orderId}/finalize
Exemplo:
/orders/5/finalize
🔍 Buscar pedido por ID
GET /orders/{orderId}
Exemplo:
/orders/5
=================================================================================
📦 Produtos
➕ Criar produto
POST /products
Request:
{
  "name": "Ração Premium",
  "category": "Alimentação",
  "price": 120.50,
  "stock": 30,
  "description": "Ração para cães adultos de médio porte"
}
📋 Listar produtos (com filtro opcional por categoria)
GET /products
Sem filtro:
/products
Com filtro por categoria:
/products?category=Alimentação
🔍 Buscar produto por ID
GET /products/{id}
Exemplo:
/products/8
✏️ Atualizar produto
PUT /products/{id}
Request:
{
  "name": "Ração Premium Plus",
  "category": "Alimentação",
  "price": 135.00,
  "stock": 40,
  "description": "Ração melhorada para cães adultos"
}
Exemplo:
/products/8
❌ Deletar produto
DELETE /products/{id}
Exemplo:
/products/8
📦 Atualizar estoque do produto
PATCH /products/{id}/stock
Parâmetro (query param):
stock=25
Exemplo:
/products/8/stock?stock=25
=================================================================================
🛁 Serviços do Petshop
➕ Criar serviço
POST /services
Request:
{
  "name": "Banho e Tosa",
  "description": "Serviço completo de higiene para pets",
  "price": 80.00,
  "durationMinutes": 60
}
📋 Listar todos os serviços
GET /services
Exemplo:
/services
🔍 Buscar serviço por ID
GET /services/{id}
Exemplo:
/services/3
✏️ Atualizar serviço
PUT /services/{id}
Request:
{
  "name": "Banho e Tosa Premium",
  "description": "Inclui hidratação e perfume especial",
  "price": 120.00,
  "durationMinutes": 90
}
Exemplo:
/services/3
❌ Deletar serviço
DELETE /services/{id}
Exemplo:
/services/3
=================================================================================
📅 Agendamento de Serviços
➕ Criar agendamento de serviço
POST /service-schedules
Request:
{
  "userId": 1,
  "petId": 3,
  "serviceId": 2,
  "scheduledDate": "2026-02-10T14:00:00",
  "status": "AGENDADO"
}
❌ Cancelar agendamento
PUT /service-schedules/{id}/cancel
Exemplo:
/service-schedules/5/cancel
📋 Listar agendamentos de um usuário
GET /service-schedules/user/{userId}
Exemplo:
/service-schedules/user/1
=================================================================================
🏠 Agendamento de Visitas
➕ Criar agendamento de visita
POST /visit-schedules
Request:
{
  "userId": 1,
  "petId": 4,
  "visitDate": "2026-02-12T10:30:00",
  "status": "AGENDADO"
}
📋 Listar visitas agendadas de um usuário
GET /visit-schedules/user/{userId}
Exemplo:
/visit-schedules/user/1

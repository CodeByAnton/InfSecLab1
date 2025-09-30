# Лабораторная работа 1


## API Эндпоинты
### Методы доступные для всех пользователей
#### Регистрация пользователя
```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "user",
  "password": "password"
}
````
Ответ:

User user123 registered successfully

#### Авторизация пользователя
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "user",
  "password": "password"
}
````
Ответ:

eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzU5MjY5OTE1LCJleHAiOjE3NTkyNzAyNzV9.9m1tffe7s5mxNKkBe2Iuc6nhfAm7lM-Qlbq4CSgxUhk

### Методы доступные только авторизованным пользователям
#### Добавление авто

```http
POST /api/data
Content-Type: application/json
Authorization: Bearer {jwt-token}

{
  "model": "Toyota Camry",
  "power": 200,
  "price": 2500000
}
````
Ответ:

Car Toyota Camry append

#### Получение всех авто

```http
GET /api/data
Content-Type: application/json
Authorization: Bearer {jwt-token}
````
Ответ:
```json
[
  {
    "id": 1,
    "model": "Toyota Camry",
    "power": 180,
    "price": 25000.0
  },
  {
    "id": 2,
    "model": "Toyota Camry1",
    "power": 180,
    "price": 25000.0
  }
]
```

## Реализованные методы защиты
### 1. Аутентификация по JWT

- **JWT токены** с алгоритмом подписи HS256 для безопасной передачи данных аутентификации
- **Stateless подход** - не требуется хранение сессий на сервере, уменьшая нагрузку и упрощая масштабирование
- **Автоматическая валидация** токенов при каждом запросе к защищенным эндпоинтам
- **JwtAuthFilter** проверяет наличие и валидность токена в заголовке Authorization

### 2. Защита от SQL-инъекций
- **Spring Data**

### 3. Защита от XSS (Cross-Site Scripting)

- **HtmlUtils.htmlEscape()** используется для экранирования специальных символо в теле ответа

## Скриншоты отчетов

### SAST

![SAST review](./images/spotbugs.png)

### SCA

![SCA review](./images/depcheck.png)


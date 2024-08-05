
```markdown
# Tarefas API
```

#### 2. **Descrição Breve**
```markdown
Uma API RESTful para gerenciamento de tarefas, permitindo a criação, leitura, atualização e exclusão de tarefas, com suporte a categorias, prioridades, status e responsáveis.
```

#### 3. **Índice**
```markdown
1. [Descrição](#descrição)
2. [Funcionalidades](#funcionalidades)
3. [Instalação](#instalação)
4. [Configuração](#configuração)
5. [Uso](#uso)
6. [Documentação da API](#documentação-da-api)
7. [Contribuição](#contribuição)
8. [Licença](#licença)
```

#### 4. **Descrição**
```markdown
A Tarefas API é uma aplicação backend desenvolvida em Java com Spring Boot, que fornece endpoints para gerenciar tarefas, suas categorias, prioridades, status, e responsáveis. Esta API pode ser integrada em aplicações maiores para fornecer funcionalidades de gestão de tarefas de forma eficiente e escalável.
```

#### 5. **Funcionalidades**
```markdown
- Gerenciamento de Tarefas (CRUD)
- Gerenciamento de Categorias de Tarefas (CRUD)
- Gerenciamento de Prioridades (CRUD)
- Gerenciamento de Status (CRUD)
- Gerenciamento de Responsáveis (CRUD)
```

#### 6. **Instalação**
```markdown

### Pré-requisitos
- [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/tarefas-api.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd tarefas-api
   ```
3. Compile e construa o projeto:
   ```bash
   ./mvnw clean install
   ```
4. Inicie a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```
```

#### 7. **Configuração**
```markdown

### Variáveis de Ambiente
- `DATABASE_URL`: URL de conexão com o banco de dados.
- `DATABASE_USERNAME`: Nome de usuário para o banco de dados.
- `DATABASE_PASSWORD`: Senha do banco de dados.

### Arquivo de Configuração (`application.properties`)
Configure as propriedades do banco de dados e outras configurações no arquivo `src/main/resources/application.properties`.

Exemplo:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tarefas
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```
```

#### 8. **Uso**
```markdown

### Exemplo de Requisição
Para criar uma nova tarefa:

```bash
curl -X POST "http://localhost:8080/listaTarefas" -H "Content-Type: application/json" -d '{
  "titulo": "Finalizar relatório",
  "descricao": "Concluir o relatório mensal",
  "prioridade": {"id": "1"},
  "categoriaTarefa": {"id": "2"},
  "status": {"id": "3"},
  "responsavel": {"id": "4"}
}'
```

### Exemplo de Resposta
```json
{
  "id": "123",
  "titulo": "Finalizar relatório",
  "descricao": "Concluir o relatório mensal",
  "prioridade": {"id": "1", "nome": "Alta"},
  "categoriaTarefa": {"id": "2", "nome": "Trabalho"},
  "status": {"id": "3", "nome": "Em Progresso"},
  "responsavel": {"id": "4", "nome": "João"}
}
```
```

#### 9. **Documentação da API**
```markdown

### Endpoints Disponíveis
1. **Categorias**
   - `GET /categoriaTarefas` - Lista todas as categorias
   - `POST /categoriaTarefas` - Cria uma nova categoria
   - `GET /categoriaTarefas/{id}` - Obtém uma categoria pelo ID
   - `PUT /categoriaTarefas/{id}` - Atualiza uma categoria pelo ID
   - `DELETE /categoriaTarefas/{id}` - Remove uma categoria pelo ID

2. **Tarefas**
   - `GET /listaTarefas` - Lista todas as tarefas
   - `POST /listaTarefas` - Cria uma nova tarefa
   - `GET /listaTarefas/{id}` - Obtém uma tarefa pelo ID
   - `PUT /listaTarefas/{id}` - Atualiza uma tarefa pelo ID
   - `DELETE /listaTarefas/{id}` - Remove uma tarefa pelo ID

E assim por diante para os outros recursos...

### Coleção Postman
Uma coleção Postman com exemplos de requisições está incluída no repositório:
- [Tarefas API.postman_collection.json](Tarefas%20API.postman_collection.json)
```

#### 10. **Contribuição**
```markdown
Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/sua-feature`).
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`).
4. Envie para o repositório remoto (`git push origin feature/sua-feature`).
5. Abra um Pull Request.
```

#### 11. **Licença**
```markdown
Este projeto é licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
```

---

Podemos trabalhar em cada uma dessas seções para personalizá-las conforme necessário. Se desejar, podemos começar escrevendo a descrição e funcionalidades detalhadas ou focar em qualquer outra seção que considere mais urgente.
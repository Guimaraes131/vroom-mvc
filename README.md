# 🏍️ Vroom

**Vroom** é um projeto desenvolvido para gerenciar estacionamentos de motocicletas, permitindo o cadastro de veículos, o acompanhamento de vagas e monitorar o problema do veículo. O sistema combina componentes de hardware, software e banco de dados para otimizar o controle e a identificação de veículos de maneira prática e eficaz.

---

# 👤 Integrantes
* **Guilherme Guimarães** - RM557074
* **Matheus Oliveira de Luna** - RM555547
* **Gabriel Marcello Cândido Freire** - RM556783

## 🛠️ Descrição do Projeto


A proposta do projeto é desenvolver uma solução tecnológica voltada para otimizar a organização e o monitoramento de motocicletas em pátios, tornando a gestão e a identificação dos veículos mais ágil e precisa. Para isso, o sistema contará com a integração de diferentes componentes, como Arduino, um aplicativo móvel e um banco de dados centralizado.

A solução contará com pequenas placas eletrônicas, denominadas **Tags**, que serão fixadas em cada motocicleta. Cada Tag será equipada com:

- Um **buzzer** para sinalização sonora;

- Um **LED** para indicação visual;

- Um **ímã** que permitirá uma fixação prática e segura na moto.

Ao chegar ao pátio, cada motocicleta terá seus dados, como **placa**, **chassi** e informações sobre eventuais problemas, registrados em um banco de dados. Essas informações poderão ser consultadas por meio de uma **API** desenvolvida em **Java**.

Além disso, os funcionários responsáveis pelo controle e monitoramento das motocicletas no pátio terão acesso a um **aplicativo móvel** integrado ao banco de dados. Por meio desse aplicativo, eles poderão:

- Consultar informações detalhadas de cada moto, como **placa**, **chassi** e **problemas registrados**.
- Alterar ou atualizar os dados das motocicletas conforme necessário.
- Acionar o **buzzer** da motocicleta selecionada, emitindo sinais sonoros.
- O **LED** indicará um problema específico de acordo com a sua cor, facilitando a identificação rápida da situação de cada moto, mesmo em um pátio com várias unidades.

Esta solução tem como objetivo facilitar a localização rápida das motocicletas no pátio. Sem uma identificação clara e imediata, os funcionários encontram dificuldades para identificar a moto correta entre várias outras. Com a implementação deste sistema, será possível organizar melhor as motos e reduzir o tempo gasto na identificação e localização dos veículos, garantindo uma gestão mais ágil e eficiente.


---
## 🎯 Objetivo

- Garantir uma gestão mais organizada e eficiente.
- Reduzir o tempo necessário para a identificação dos veículos pelos funcionários.
- Tornar mais rápida e prática a localização das motos no pátio.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **Thymeleaf**
- **PostgreSQL**
- **Flyway**
- **Docker Compose**
- **Gradle**

---

## 📋 Requisitos Para Execução

Antes de executar a aplicação, certifique-se de ter instalado:

- **Java 21**
- **Docker**
- **Git** (para clonar o repositório)

---

## ⚙️ Configuração

### 1. Clone o repositório
```
git clone https://github.com/Guimaraes131/vroom-mvc.git
cd vroom-mvc
```

---

## 🛠️ Instalação e Execução

### Método 1: Intellij
- Clique no botão **▶️ Run** ao lado da classe `VroomApplication`.

### Método 2: Usando Docker Compose

1. **Inicie o banco de dados PostgreSQL:**
```
docker-compose up -d
```

2. **Execute a aplicação:**
```
# Windows
.\gradlew bootRun

# Linux/Mac
./gradlew bootRun
```

---

## 🌐 Acesso à Aplicação

### URLs da Aplicação
- **URL Principal:** http://localhost:8080
- **Login:** http://localhost:8080/login

---

## Funcionalidades

### Para Operadores:
- ✅ Listar Tags
- ✅ Listar Motos
- ✅ Adicionar Motos
- ✅ Editar Motos

### Para Gerentes:
- ✅ Todas as funcionalidades de usuário comum
- ✅ Excluir Motos

---

## 🗃️ Banco de Dados

A aplicação utiliza **PostgreSQL** e o **Flyway** para migração automática do banco de dados. As migrações estão localizadas em:
```
src/main/resources/db/migration/
```

### Estrutura das Tabelas:
- **tb_tags** - Armazena informações das Tags
- **tb_motorcycle** - Contém dados das motocicletas
- **tb_user** - Informações dos usuários do sistema

---
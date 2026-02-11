# 🩺 VitalCheck

Aplicativo Android desenvolvido em Kotlin utilizando Jetpack Compose para registro e acompanhamento de sintomas de saúde.

---

# 📐 1. Decisões Arquiteturais

## 🏗 Padrão Arquitetural

Foi adotado o padrão **MVVM (Model-View-ViewModel)**.

### ✔ Por que MVVM?

- Separação clara entre UI e lógica de negócio
- Melhor organização do código
- Facilidade para testes
- Integração natural com:
    - Jetpack Compose
    - ViewModel
    - Flow
    - DataStore

### ❌ Por que não MVP?

- Maior verbosidade
- Necessidade de interfaces adicionais
- Menos alinhado ao ecossistema moderno do Android

### ❌ Por que não MVC?

- Mistura excessiva entre UI e lógica
- Dificulta manutenção em projetos maiores

---

## 🧱 Camadas do Projeto

UI (Compose)
↓
ViewModel (Gerencia estado)
↓
Data Layer (DataStore)

---

# 📦 2. Gestão de Dependências

As dependências foram adicionadas via Gradle (KTS).

## 🔹 Jetpack Compose

androidx.compose.ui:ui
androidx.compose.material3:material3

Justificativa:
- UI declarativa moderna
- Redução de boilerplate
- Melhor gerenciamento de estado

---

## 🔹 Navigation Compose

androidx.navigation:navigation-compose

Justificativa:
- Navegação declarativa
- Suporte a argumentos entre telas
- Integração natural com Compose

---

## 🔹 ViewModel

androidx.lifecycle:lifecycle-viewmodel-compose

Justificativa:
- Separação de responsabilidades
- Sobrevive a mudanças de configuração
- Gerenciamento adequado de estado

---

## 🔹 DataStore Preferences

androidx.datastore:datastore-preferences

Justificativa:
- Substitui SharedPreferences
- Baseado em Flow
- Assíncrono e seguro
- Evita ANR (Application Not Responding)

---

## 🔹 Coroutines

org.jetbrains.kotlinx:kotlinx-coroutines-android

Justificativa:
- Operações assíncronas
- Integração com Flow
- Melhor performance

---

# ▶ 3. Instruções de Execução

## 🔧 Requisitos

- Android Studio (Jellyfish ou superior)
- JDK 17
- SDK mínimo: API 24
- Gradle sincronizado

---

## 🚀 Como executar o projeto

1. Clonar o repositório:

git clone https://github.com/seu-usuario/vitalcheck.git

2. Abrir no Android Studio

3. Sincronizar o Gradle

4. Executar em:
    - Emulador Android
    - Dispositivo físico com modo desenvolvedor ativado

---

## 🔑 Configuração de API Key

Atualmente o projeto **não utiliza API externa**.

Caso futuramente seja integrada uma API:

1. Criar um arquivo local.properties
2. Adicionar:

API_KEY=SUACHAVEAQUI

3. Referenciar no build.gradle

---

# 💾 Persistência de Dados

Os sintomas são armazenados utilizando DataStore Preferences.

- Armazenamento local
- Estrutura baseada em Flow
- Persistência após fechar o app

---

# 📱 Funcionalidades Implementadas

✔ Dashboard com dados simulados  
✔ Registro de sintomas  
✔ Registro automático de data e hora  
✔ Persistência local  
✔ Histórico de sintomas  
✔ Interface moderna com Material 3

---

# 📊 Fluxo do Aplicativo

Dashboard → Entrada → Resumo  
↓
DataStore

---

# 🔮 Melhorias Futuras

- Implementação de Room Database
- Gráficos com MPAndroidChart
- Integração com sensores reais
- Backend REST (Spring ou Node)
- Autenticação de usuário
- Análise inteligente de sintomas

---
## 🧠 Considerações Éticas sobre IA

Este projeto considera princípios fundamentais de ética no desenvolvimento de Inteligência Artificial, especialmente em aplicações relacionadas à saúde.

- Proteção de dados sensíveis (LGPD)
- Transparência nas recomendações geradas por IA
- Não substituição de diagnóstico médico
- Mitigação de vieses algorítmicos
- Segurança e governança dos dados
---


### 🔐 Privacidade e Proteção de Dados

- Armazenamento local utilizando DataStore
- Não compartilhamento de dados sensíveis sem consentimento
- Conformidade com LGPD (Lei Geral de Proteção de Dados)
- Possibilidade futura de criptografia de dados

### 📊 Transparência Algorítmica

Caso o projeto evolua para utilização de IA:

- As recomendações serão apresentadas como sugestões
- O usuário será informado de que não se trata de diagnóstico médico
- O funcionamento da IA deverá ser documentado

### 🏥 Não Substituição Médica

Este aplicativo não substitui avaliação médica profissional.  
As informações apresentadas são apenas para acompanhamento pessoal.

### ⚖ Mitigação de Viés

Em caso de uso de modelos de IA:

- Utilização de dados diversos para treinamento
- Validação com múltiplos perfis de usuários
- Documentação de limitações do modelo

### 🔒 Segurança

- Sanitização de entradas
- Proteção contra vazamento de dados
- Não exposição de chaves de API
- Armazenamento seguro de informações sensíveis

### 🌍 Responsabilidade Social

O sistema deve:

- Evitar linguagem alarmista
- Incentivar acompanhamento médico quando necessário
- Priorizar bem-estar do usuário

---


# 👨‍💻 Autor

Odilon Monteiro

Projeto desenvolvido para estudo de:

- Android moderno
- Arquitetura MVVM
- Jetpack Compose
- Persistência local
- Navegação entre telas

---

# 📄 Licença

Projeto desenvolvido para fins educacionais.

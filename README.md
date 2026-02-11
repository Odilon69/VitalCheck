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
## 🏗 Arquitetura

O projeto segue uma arquitetura baseada em:

- UI (Compose)
- ViewModel
- Data Layer (DataStore)
- Navigation Component

Fluxo simplificado:

EntradaScreen → salva sintoma → DataStore  
ResumoScreen → exibe sintoma e data  
Dashboard → mostra dados simulados


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

git clone https://github.com/Odilon69/VitalCheck.git


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

## 🧠 Pensamento Crítico: Ética da IA no Desenvolvimento de Software

O desenvolvimento de soluções que envolvem Inteligência Artificial exige responsabilidade técnica e social. A IA não deve ser tratada apenas como uma ferramenta tecnológica, mas como um sistema que impacta diretamente pessoas, decisões e comportamentos.

### 1️⃣ Privacidade e Proteção de Dados

Em qualquer sistema que lide com dados sensíveis — especialmente dados de saúde — a proteção da informação é prioridade.

- Coletar apenas os dados estritamente necessários.
- Armazenar informações localmente sempre que possível.
- Garantir conformidade com legislações como a LGPD.
- Evitar compartilhamento de dados sem consentimento explícito.
- Aplicar boas práticas de segurança e criptografia quando necessário.

A ética começa no respeito à privacidade do usuário.

---

### 2️⃣ Transparência Algorítmica

Usuários devem entender que estão interagindo com um sistema automatizado.

- Explicar quando uma recomendação é gerada por IA.
- Deixar claro que não se trata de diagnóstico médico.
- Documentar limitações do modelo.
- Evitar promessas exageradas sobre precisão.

Transparência gera confiança.

---

### 3️⃣ Mitigação de Viés

Modelos de IA podem refletir preconceitos presentes nos dados de treinamento.

Para reduzir esse risco:

- Utilizar dados diversos e representativos.
- Testar o sistema com diferentes perfis de usuários.
- Monitorar resultados inesperados.
- Revisar continuamente o comportamento do modelo.

A ética exige vigilância constante contra discriminação algorítmica.

---

### 4️⃣ Responsabilidade e Limites

A IA deve auxiliar, não substituir decisões humanas críticas.

No contexto de saúde:

- O sistema deve atuar como ferramenta de apoio.
- Nunca substituir avaliação médica.
- Incluir avisos claros quando necessário.

A responsabilidade final deve permanecer com o ser humano.

---

### 5️⃣ Segurança e Robustez

Sistemas inteligentes devem ser resilientes contra falhas e ataques.

- Validação rigorosa de entradas.
- Tratamento de exceções.
- Proteção contra manipulação de dados.
- Atualizações constantes de dependências.

Segurança também é um compromisso ético.

### 🌍 Responsabilidade Social

O sistema deve:

- Evitar linguagem alarmista
- Incentivar acompanhamento médico quando necessário
- Priorizar bem-estar do usuário

---

---

### 📌 Conclusão

Desenvolver com IA significa assumir responsabilidade não apenas pelo código, mas pelo impacto social da solução.  
A ética deve ser integrada desde o planejamento arquitetural até a implementação final.

Tecnologia responsável é tecnologia sustentável.



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

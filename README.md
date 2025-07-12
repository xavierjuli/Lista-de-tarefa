# Lista de tarefas
Aplicativo simples de lista de tarefas desenvolvido com JavaFX e integração com banco de dados SQLite. 
O código permite adicionar tarefas, atualizar seu status (pendente/concluída) e listar itens de forma dinâmica.
As funcionalidades foram exibidas com interface JavaFX para maior usabilidade.
Ideal para praticar conceitos de interface gráfica, persistência de dados, e Java.


## Como executar
- Java 11 ou superior
- JavaFX configurado no projeto
- IDE como IntelliJ, Eclipse, ou NetBeans
- SQLite ou JDBC incluído como dependência

### Execução
1. Clone ou baixe o projeto.
2. Execute a classe GUI.MainApp como aplicação JavaFX.
3. A interface será exibida com o título "Lista de Tarefas".

#### Estrutura do prjeto
```
src/
├── GUI/             
│   ├── MainApp.java
│   └── menu.fxml
├── database/         
│   ├── DBTarefa.java
│   └── DBConnection.java
├── model/          
    └── Tarefa.java
```
    
##### Funcionalidades
[x] Criar tarefas com descrição e status

[x] Salvar dados no banco SQLite

[x] Atualizar status da tarefa

[x] Listar tarefas por categoria 

[x] Interface com JavaFX

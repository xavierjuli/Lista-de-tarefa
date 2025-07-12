# Lista de tarefas

> Este projeto utiliza o JavaFX SDK 24, compatível com Java 17 ou superior

Aplicativo simples de lista de tarefas desenvolvido com JavaFX e integração com banco de dados SQLite. 
O código permite adicionar tarefas, atualizar seu status (pendente/concluída) e listar itens de forma dinâmica.
As funcionalidades foram exibidas com interface JavaFX para maior usabilidade.
Ideal para praticar conceitos de interface gráfica, persistência de dados, e Java.


## Como executar

Para executar pelo Terminal use o MainTerminal, contido na pasta "service"

Para executar a interface gráfica, use o MainApp, contido na pasta "GUI". Porém antes é necessário configurar o IntelliJ 


##Configuração no ambiente do IntelliJ 

### Adicionar  bibliotecas (JavaFX e SQLite)
Acesse File > Project Structure 
Vá em Modules > Dependencies
Clique em + > JARs or directories
Adicione todos os arquivos .jar da pasta: lib\

## Configurar o Run Configuration para a interface Gráfica 
No IntelliJ, vá no menu:
Run > Edit Configurations
Clique no botão + para criar uma nova configuração e escolha Application.
Configure da seguinte forma:
Name: MainAPP
Main class: GUI.MainApp

Working directory: diretório raiz do projeto
VM options:  --module-path=lib --add-modules=javafx.controls,javafx.fxml -Djava.library.path=lib

Clique em "Apply" e depois em "Ok"
```

import database.DBTarefa;

    public class Main {
        public static void main(String[] args) {
//Interface pelo o terminal
            final DBTarefa tarefaDB = new DBTarefa();

            MenuTerminal App = new MenuTerminal();
            App.menu();
        }
    }

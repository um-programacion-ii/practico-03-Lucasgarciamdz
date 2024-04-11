package src.main.um.excepciones;

public class StockInsuficiente extends Exception{

    public StockInsuficiente(String mensaje){
        super(mensaje);
    }
}

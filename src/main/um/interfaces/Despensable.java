package src.main.um.interfaces;

import src.main.um.excepciones.StockInsuficiente;
import src.main.um.excepciones.VidaUtilInsuficiente;

public interface Despensable {

  String sacar(int cantidad) throws VidaUtilInsuficiente, StockInsuficiente;
}

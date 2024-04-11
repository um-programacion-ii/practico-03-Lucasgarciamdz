package src.main.um.entidades;

import java.util.HashMap;
import java.util.Map;

import src.main.um.excepciones.StockInsuficiente;
import src.main.um.excepciones.VidaUtilInsuficiente;
import src.main.um.interfaces.Despensable;

public class Despensa {

  Map<String, Despensable> despensaMap;

  public Despensa() {
    despensaMap = new HashMap<>();
  }

  public void addDespensable(String nombre, Despensable despensable) {
    despensaMap.put(nombre, despensable);
  }

  public String getDespensable(String nombre, int cantidad)
      throws VidaUtilInsuficiente, StockInsuficiente {
    Despensable despensable = despensaMap.get(nombre);
    if (despensable != null) {


        return despensable.sacar(cantidad);

    }
    return "No se encontro el item";
  }

  @Override
  public String toString() {
    String despensaStr = "Despensa:\n";
    for (Map.Entry<String, Despensable> entry : despensaMap.entrySet()) {
      despensaStr += entry.getKey() + ": " + entry.getValue() + "\n";
    }
    return despensaStr;
  }
}

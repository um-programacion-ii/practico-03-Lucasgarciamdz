package src.main.um.entidades;

import src.main.um.excepciones.StockInsuficiente;
import src.main.um.excepciones.VidaUtilInsuficiente;

import java.util.List;

public class RecetaBase {

  int tiempoCoccion;
  List<Ingrediente> ingredientes;
  List<Utensilio> utensilios;

  String preparacion;

  public RecetaBase() {
  }

  public RecetaBase(
      int tiempoCoccion,
      List<Ingrediente> ingredientes,
      List<Utensilio> utensilios,
      String preparacion) {

    this.tiempoCoccion = tiempoCoccion;
    this.ingredientes = ingredientes;
    this.utensilios = utensilios;
    this.preparacion = preparacion;
  }

  public int getTiempoCoccion() {
    return tiempoCoccion;
  }

  public void setTiempoCoccion(int tiempoCoccion) {
    this.tiempoCoccion = tiempoCoccion;
  }

  public List<Ingrediente> getIngredientes() {
    return ingredientes;
  }

  public void setIngredientes(List<Ingrediente> ingredientes) {
    this.ingredientes = ingredientes;
  }

  public List<Utensilio> getUtensilios() {
    return utensilios;
  }

  public void setUtensilios(List<Utensilio> utensilios) {
    this.utensilios = utensilios;
  }

  public String getPreparacion() {
    return preparacion;
  }

  public void setPreparacion(String preparacion) {
    this.preparacion = preparacion;
  }

  public Boolean sePuedeCocinar(Despensa despensa) throws VidaUtilInsuficiente, StockInsuficiente {
    for (Ingrediente ingrediente : this.getIngredientes()) {
      if (ingrediente != null) {
        String hayIngredientes =
            despensa.getDespensable(ingrediente.getNombre(), ingrediente.getCantidad());
        if (hayIngredientes.equals("No se encontro el ingrediente")
            || hayIngredientes.startsWith("No hay suficiente")) {
          return false;
        }
      }
    }

    for (Utensilio utensilio : this.getUtensilios()) {
      if (utensilio != null) {
        String hayUtensilios = despensa.getDespensable(utensilio.getClass().getSimpleName(), 1);
        if (hayUtensilios.equals("No se encontro el utensilio")
            || hayUtensilios.startsWith("No hay suficiente")) {
          return false;
        }
      }
    }
    return true;
  }

  public String queFalta(Despensa despensa) throws VidaUtilInsuficiente, StockInsuficiente {
    String faltan = "Faltan los siguientes ingredientes:\n";
    for (Ingrediente ingrediente : this.getIngredientes()) {
      if (ingrediente != null) {
        String hayIngredientes =
            despensa.getDespensable(ingrediente.getNombre(), ingrediente.getCantidad());
        if (hayIngredientes.equals("No se encontro el ingrediente")
            || hayIngredientes.startsWith("No hay suficiente")) {
          faltan += hayIngredientes + "\n";
        }
      }
    }

    faltan += "Faltan los siguientes utensilios:\n";
    for (Utensilio utensilio : this.getUtensilios()) {
      if (utensilio != null) {
        String hayUtensilios = despensa.getDespensable(utensilio.getClass().getSimpleName(), 1);
        if (hayUtensilios.equals("No se encontro el utensilio")
            || hayUtensilios.startsWith("No hay suficiente")) {
          faltan += hayUtensilios + "\n";
        }
      }
    }
    return faltan;
  }

  @Override
  public String toString() {
    String recetaStr = "Receta:\n";
    recetaStr += "Tiempo de coccion: " + tiempoCoccion + "\n";
    recetaStr += "Ingredientes:\n";
    for (Ingrediente ingrediente : ingredientes) {
      if (ingrediente != null) {
        recetaStr += ingrediente + "\n";
      }
    }
    recetaStr += "Preparacion: " + preparacion + "\n";
    return recetaStr;
  }
}

package src.main.um.recetas;

import java.util.List;
import src.main.um.entidades.Ingrediente;
import src.main.um.entidades.RecetaBase;
import src.main.um.entidades.Utensilio;

public class HuevosRevueltos extends RecetaBase {
  public HuevosRevueltos() {
    super(
        5,
        List.of(
            new Ingrediente("Huevos", 2),
            new Ingrediente("Sal", 1),
            new Ingrediente("Mantequilla", 1)),
        List.of(new Utensilio("Sartén", 1), new Utensilio("Espátula", 1)),
        "Bate los huevos, derrite la mantequilla en una sartén, añade los huevos, revuelve hasta que estén cocidos, añade sal al gusto.");
  }
}

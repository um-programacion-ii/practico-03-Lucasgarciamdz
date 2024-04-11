package src.main.um.recetas;

import java.util.List;
import src.main.um.entidades.Ingrediente;
import src.main.um.entidades.RecetaBase;
import src.main.um.entidades.Utensilio;

public class Helado extends RecetaBase {
  public Helado() {
    super(
        0,
        List.of(new Ingrediente("Helado", 1)),
        List.of(new Utensilio("Copa", 1), new Utensilio("Cuchara", 1)),
        "Sirve el helado.");
  }
}

package src.main.um;

import src.main.um.entidades.Chef;
import src.main.um.entidades.Despensa;
import src.main.um.entidades.Ingrediente;
import src.main.um.entidades.RecetaBase;
import src.main.um.recetas.*;
import src.main.um.services.CocinaService;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Aplicacion {
  public static void main(String[] args) {

    List<String> diasSemana = List.of("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo");

    Despensa despensa1 = new Despensa();
    Despensa despensa2 = new Despensa();
    Despensa despensa3 = new Despensa();
    Despensa despensa4 = new Despensa();
    Despensa despensa5 = new Despensa();
    Despensa despensa6 = new Despensa();
    Despensa despensa7 = new Despensa();
    Despensa despensa8 = new Despensa();

    ExecutorService domingoAjueves = Executors.newFixedThreadPool(3);
    ExecutorService findesYferiados = Executors.newFixedThreadPool(5);

    List<RecetaBase> recetas = List.of(
        new Espaguetis(),
        new Helado(),
        new HuevosRevueltos(),
        new RodajasDeManzana(),
        new SopaDeTomate()
    );

    List<Ingrediente> ingredientes = List.of(
    new Ingrediente("Espaguetis", 100),
    new Ingrediente("Salsa de Tomate", 100),
    new Ingrediente("Sal", 1),
    new Ingrediente("Helado", 1),
    new Ingrediente("Huevos", 2),
    new Ingrediente("Mantequilla", 1),
    new Ingrediente("Manzana", 1),
    new Ingrediente("Tomates", 4),
    new Ingrediente("Pimienta", 1)
);

    fillDespensa(despensa1, ingredientes);
    fillDespensa(despensa2, ingredientes);
    fillDespensa(despensa3, ingredientes);
    fillDespensa(despensa4, ingredientes);
    fillDespensa(despensa5, ingredientes);
    fillDespensa(despensa6, ingredientes);
    fillDespensa(despensa7, ingredientes);
    fillDespensa(despensa8, ingredientes);


    List<Chef> chefs = List.of(
      new Chef("Chef 1", 3, despensa1, null),
      new Chef("Chef 2", 2, despensa2, null),
      new Chef("Chef 3", 1, despensa3, null),
      new Chef("Chef 4", 3, despensa4, null),
      new Chef("Chef 5", 2, despensa5, null),
      new Chef("Chef 6", 1, despensa6, null),
      new Chef("Chef 7", 3, despensa7, null),
      new Chef("Chef 8", 2, despensa8, null)
    );

    Random random = new Random();
    for (Chef chef : chefs) {
      // Assign a random recipe to each chef
      RecetaBase randomReceta = recetas.get(random.nextInt(recetas.size()));
      chef.setReceta(randomReceta);

      // Submit the chef to the executor service
      if (diasSemana.contains("Domingo") || diasSemana.contains("Jueves")) {
        domingoAjueves.submit(chef);
      } else {
        findesYferiados.submit(chef);
      }
    }

    // Shutdown the executor services after all tasks are submitted
    domingoAjueves.shutdown();
    findesYferiados.shutdown();

  }

public static void fillDespensa(Despensa despensa, List<Ingrediente> ingredientes) {
    Random random = new Random();
    for (Ingrediente ingrediente : ingredientes) {
        if (random.nextBoolean()) {
            despensa.addDespensable(ingrediente.getNombre(), ingrediente);
        }
    }
}

}

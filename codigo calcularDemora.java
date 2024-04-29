public class Trayecto {
    // Atributos y métodos de la clase Trayecto...

    private AdaptadorConcreto adaptador;
    public List<Double> listaTiempoEntreParadas = new ArrayList<>();

    public Double calcularDemora() {

        if (this.seDetieneEnCadaParada()) {
            for (int i = 0; i < paradas.size() - 1; i++) {
                Parada paradaActual = this.paradas.get(i);
                Parada siguienteParada = this.paradas.get(i + 1);
                Double distancia = this.adaptador.adaptar(paradaActual, siguienteParada);
                Double tiempoEntreParadas = calcularTiempo(distancia);
                listaTiempoEntreParadas.add(tiempoEntreParadas);
            }
            return listaTiempoEntreParadas;
        } else {
            // Calcular demora total aproximada
            Parada primeraParada = this.paradas.get(0);
            Parada ultimaParada = this.paradas.get(paradas.size() - 1);
            Double distanciaTotal = this.adaptador.adaptar(primeraParada, ultimaParada);
            return Collections.singletonList(calcularTiempo(distanciaTotal));
        }
    }

    public Double calcularTiempo(Double distancia) {
        // Implementación de cálculo de tiempo,utiliza una velocidad promedio para
        // calcular el tiempo en función de la distancia
        // y devuelve el tiempo aproximado en minutos;
    }
}

class AdaptadorConcreto implements Adaptador {
    private DistanceMatrix api;

    public Double adaptar(Parada origen, Parada destino) {
        // la api calcula la distancia entre dos paradas y se adapta mediante la funcion
        // adaptarDistancia
        Integer distancia = this.api.sacarDistancia(origen, destino);
        return adaptarDistancia(distancia);
    }

    public Double adaptarDistancia(Integer distancia) {
        // Implementación de adaptación de distancia...
        return (double) distancia; // Por ahora solo se devuelve la misma distancia
    }
}

public interface Adaptador {
    public Double adaptar(Parada origen, Parada destino);
}

// Código de la API
public interface DistanceMatrix {
    public Integer sacarDistancia(Parada origen, Parada destino);
}

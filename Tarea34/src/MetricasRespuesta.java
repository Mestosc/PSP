import java.net.URI;

public record MetricasRespuesta(Long tiempoRespuesta, int tamanoRespuesta, URI url) {
}

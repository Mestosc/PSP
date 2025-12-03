import java.net.URI;
import java.net.http.HttpResponse;

public record MetricasRespuesta(Long tiempoRespuesta, int tamanoPeticionBytes, URI url) {
}

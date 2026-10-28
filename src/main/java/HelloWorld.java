import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            byte[] response = "Hello DevOps! - Feature branch by Om Laware\n"
                    .getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, response.length);
            try (var output = exchange.getResponseBody()) {
                output.write(response);
            }
            System.out.println("Request: " + exchange.getRequestURI());
        });
        server.start();
        System.out.println("DevOps app running on port 8080");
    }
}

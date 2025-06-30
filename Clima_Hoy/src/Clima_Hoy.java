import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;

public class Clima_Hoy extends JFrame {
    private JTextField ciudadInput;
    private JTextArea resultadoArea;
    private JLabel mensajeError;

    public Clima_Hoy() {
        setTitle("Clima Actual - OpenWeatherMap");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo de entrada
        JLabel labelCiudad = new JLabel("Ciudad:");
        ciudadInput = new JTextField(20);
        mensajeError = new JLabel(" ");
        mensajeError.setForeground(Color.RED);
        mensajeError.setFont(new Font("SansSerif", Font.PLAIN, 12));

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(labelCiudad, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(ciudadInput, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(mensajeError, gbc);

        // Botón de búsqueda
        JButton botonBuscar = new JButton("Buscar Clima");
        botonBuscar.setBackground(new Color(70, 130, 180));
        botonBuscar.setForeground(Color.WHITE);
        botonBuscar.setFocusPainted(false);
        botonBuscar.addActionListener(this::buscarClima);

        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(botonBuscar, gbc);

        // Área de resultados tipo "tarjeta"
        resultadoArea = new JTextArea(8, 30);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resultadoArea.setBackground(new Color(255, 255, 255));
        resultadoArea.setBorder(new CompoundBorder(
                new TitledBorder(new LineBorder(new Color(200, 200, 200), 1), "Resultado"),
                new EmptyBorder(8, 8, 8, 8)
        ));

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(new JScrollPane(resultadoArea), gbc);

        add(panel);
    }

    private void buscarClima(ActionEvent e) {
        String ciudad = ciudadInput.getText().trim();
        mensajeError.setText(" ");
        resultadoArea.setText("");

        if (ciudad.isEmpty()) {
            mensajeError.setText("⚠️ Ingresa una ciudad válida.");
            return;
        }

        resultadoArea.setText("Buscando clima para " + ciudad + "...\n");

        try {
            HttpClient client = HttpClient.newHttpClient();

            // 🔑 TU API KEY AQUÍ
            String apiKey = "6dd180c4b7b759353f5b5eaa1bece694"; // Reemplázala por tu clave real

            // Codificar ciudad (espacios, tildes, etc.)
            String ciudadCodificada = URLEncoder.encode(ciudad, StandardCharsets.UTF_8);
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudadCodificada +
                    "&appid=" + apiKey + "&units=metric&lang=es";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent", "JavaApp")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject data = new JSONObject(response.body());

            if (data.has("cod") && data.getInt("cod") != 200) {
                resultadoArea.setText("❌ Ciudad no encontrada o error: " + data.getString("message"));
                return;
            }

            String nombreCiudad = data.getString("name");
            JSONObject main = data.getJSONObject("main");
            JSONArray weatherArray = data.getJSONArray("weather");
            JSONObject weather = weatherArray.getJSONObject(0);

            double temp = main.getDouble("temp");
            double tempMin = main.getDouble("temp_min");
            double tempMax = main.getDouble("temp_max");
            String estado = weather.getString("description");

            StringBuilder sb = new StringBuilder();
            sb.append("📍 Ciudad: ").append(nombreCiudad).append("\n");
            sb.append("🌤️ Estado: ").append(estado).append("\n");
            sb.append("🌡️ Temperatura: ").append(String.format("%.1f", temp)).append(" °C\n");
            sb.append("🔻 Mínima: ").append(String.format("%.1f", tempMin)).append(" °C\n");
            sb.append("🔺 Máxima: ").append(String.format("%.1f", tempMax)).append(" °C\n");

            resultadoArea.setText(sb.toString());

        } catch (Exception ex) {
            resultadoArea.setText("🚫 Error al consultar el clima:\n" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Clima_Hoy().setVisible(true));
    }
}

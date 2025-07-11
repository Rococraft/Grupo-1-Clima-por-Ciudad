/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clima_hoy;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author USUARIO
 */
public class Buscar_Clima extends javax.swing.JFrame {
    private boolean mostrarFahrenheit = false; 


    
    /**
     * Creates new form Buscar_Clim
     */
    public Buscar_Clima() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        bttnLupa = new javax.swing.JButton();
        tfCiudad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadosArea = new javax.swing.JTextArea();
        bttnFahrenheit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(235, 239, 245));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setBackground(new java.awt.Color(102, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Clima de Hoy ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(180, 180, 180))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ingrese una ciudad:");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        bttnLupa.setBackground(new java.awt.Color(153, 204, 255));
        bttnLupa.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Desktop\\Buscar Ciudad\\Lupa.png")); // NOI18N
        bttnLupa.setBorder(null);
        bttnLupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnLupaActionPerformed(evt);
            }
        });

        tfCiudad.setBackground(new java.awt.Color(153, 204, 255));
        tfCiudad.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tfCiudad.setForeground(new java.awt.Color(0, 0, 0));
        tfCiudad.setBorder(null);
        tfCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCiudadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCiudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(bttnLupa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        resultadosArea.setBackground(new java.awt.Color(255, 255, 255));
        resultadosArea.setColumns(20);
        resultadosArea.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        resultadosArea.setForeground(new java.awt.Color(0, 0, 0));
        resultadosArea.setRows(5);
        resultadosArea.setText("\n\n");
        resultadosArea.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Resultados:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(51, 153, 255))); // NOI18N
        jScrollPane1.setViewportView(resultadosArea);

        bttnFahrenheit.setBackground(new java.awt.Color(204, 0, 0));
        bttnFahrenheit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bttnFahrenheit.setForeground(new java.awt.Color(255, 255, 0));
        bttnFahrenheit.setText("FAHRENHEIT");
        bttnFahrenheit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnFahrenheitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttnFahrenheit)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(bttnFahrenheit)))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttnLupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnLupaActionPerformed
    // Variable
    String ciudad = tfCiudad.getText().trim();
    resultadosArea.setText("");

    // Condicion si el tffield esta vacio
    if (ciudad.isEmpty()) {
        resultadosArea.setText("¡Ingrese una ciudad!");
        return;
    }
    
    // Buscar el clima de la ciudad ingresada
    resultadosArea.setText("Buscando clima para " + ciudad + "...\n");

    // Consulta a la API
    try {
        HttpClient client = HttpClient.newHttpClient();
        String apiKey = "6dd180c4b7b759353f5b5eaa1bece694"; // API Key
        String ciudadCodificada = URLEncoder.encode(ciudad, StandardCharsets.UTF_8);
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudadCodificada +
                "&appid=" + apiKey + "&units=metric&lang=es";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "JavaApp")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject data = new JSONObject(response.body());

        // Error si la ciudad no es encontrada
        if (data.has("cod") && data.getInt("cod") != 200) {
            resultadosArea.setText("Ciudad no encontrada: " + data.getString("message"));
            return;
        }
        
        // Libreria JSON
        String nombreCiudad = data.getString("name");
        JSONObject main = data.getJSONObject("main");
        JSONArray weatherArray = data.getJSONArray("weather");
        JSONObject weather = weatherArray.getJSONObject(0);

        // Variables de los resultados
        double temp = main.getDouble("temp");
        double tempMin = main.getDouble("temp_min");
        double tempMax = main.getDouble("temp_max");
        String estado = weather.getString("description");

        // Resultados
        String emoji;
        if (estado.contains("nube")) {
            emoji = "☁️";
        } else if (estado.contains("sol") || estado.contains("despejado")) {
            emoji = "☀️";
        } else if (estado.contains("parcial")) {
            emoji = "⛅";
        } else {
            emoji = "🌤️";  // Emoji por defecto
        }

        StringBuilder sb = new StringBuilder();
        sb.append("📍 Ciudad: ").append(nombreCiudad).append("\n");
        sb.append(emoji).append(" Estado: ").append(estado).append("\n");
        sb.append("🌡️ Temperatura: ").append(String.format("%.1f", temp)).append(" °C\n");
        sb.append("🔻 Mínima: ").append(String.format("%.1f", tempMin)).append(" °C\n");
        sb.append("🔺 Máxima: ").append(String.format("%.1f", tempMax)).append(" °C\n");

                  
        // Insertar resultados en el textarea
        resultadosArea.setText(sb.toString());

        // Error si la consulta a la API falla
    } catch (Exception ex) {
        resultadosArea.setText("Error al consultar el clima:\n" + ex.getMessage());
    }
    }//GEN-LAST:event_bttnLupaActionPerformed

    private void tfCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCiudadActionPerformed

    }//GEN-LAST:event_tfCiudadActionPerformed

    private void bttnFahrenheitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnFahrenheitActionPerformed
    mostrarFahrenheit = !mostrarFahrenheit;

    String texto = resultadosArea.getText();
    if (texto.isEmpty() || !texto.contains("Temperatura:")) {
        return; // Si no hay datos para convertir
    }

    // Cambiar el valor de unidad
    String nuevaUnidad = mostrarFahrenheit ? "°F" : "°C";

    String[] lineas = texto.split("\n");
    for (int i = 0; i < lineas.length; i++) {
        if (lineas[i].contains("Temperatura:") || lineas[i].contains("Mínima:") || lineas[i].contains("Máxima:")) {
            try {
                // Extraer el valor numerico
                double valor = Double.parseDouble(lineas[i].replaceAll("[^0-9.-]", ""));
                double nuevoValor = mostrarFahrenheit ? (valor * 9 / 5) + 32 : (valor - 32) * 5 / 9;

                // Actualizar linea con nuevo valor y unidad
                lineas[i] = lineas[i].replaceAll(":.*", ": " + String.format("%.1f", nuevoValor) + " " + nuevaUnidad);
            } catch (Exception ex) {
                // Si hay un error al convertir
                continue;
            }
        }
    }
    // Mostrar resultados
    resultadosArea.setText(String.join("\n", lineas));
    bttnFahrenheit.setText(mostrarFahrenheit ? "Mostrar en °C" : "Mostrar en °F");
    }//GEN-LAST:event_bttnFahrenheitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar_Clima().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnFahrenheit;
    private javax.swing.JButton bttnLupa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea resultadosArea;
    private javax.swing.JTextField tfCiudad;
    // End of variables declaration//GEN-END:variables

}

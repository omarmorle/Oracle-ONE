import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Conversor extends JFrame implements ActionListener {
    private JLabel label1, label2;
    private JTextField textField;
    private JComboBox<String> comboBox;
    private JRadioButton radioButton1, radioButton2, radioButton3;
    private JButton button;

    public Conversor() {
        setTitle("Conversor");
        setLayout(new GridLayout(5, 1));

        // Crear los componentes
        label1 = new JLabel("Cantidad a convertir:");
        textField = new JTextField(10);
        radioButton1 = new JRadioButton("Monedas");
        radioButton2 = new JRadioButton("Temperatura");
        radioButton3 = new JRadioButton("Longitud");
        button = new JButton("Convertir");
        label2 = new JLabel("Resultado:");

        // Agrupar los botones de radio
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        radioGroup.add(radioButton3);

        // Crear el combo box
        comboBox = new JComboBox<String>();
        
        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.removeAllItems();
                comboBox.addItem("Pesos a dolares");
                comboBox.addItem("Dolares a pesos");
                comboBox.addItem("Pesos a euros");
                comboBox.addItem("Euros a pesos");
            }
        });
        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.removeAllItems();
                comboBox.addItem("Celsius a Fahrenheit");
                comboBox.addItem("Fahrenheit a Celsius");
                comboBox.addItem("Fahrenheit a Kelvin");
                comboBox.addItem("Kelvin a Fahrenheit");
                comboBox.addItem("Celsius a Kelvin");
                comboBox.addItem("Kelvin a Celsius");
            }
        });
        radioButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.removeAllItems();
                comboBox.addItem("Kilometros a Millas");
                comboBox.addItem("Millas a Kilometros");
                comboBox.addItem("Kilometros a Metros");
                comboBox.addItem("Metros a Kilometros");
                comboBox.addItem("Metros a Centimetros");
                comboBox.addItem("Centimetros a Metros");
            }
        });

        // Añadir los componentes al panel
        JPanel panel1 = new JPanel();
        panel1.add(label1);
        panel1.add(textField);
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.add(radioButton1);
        panel2.add(radioButton2);
        panel2.add(radioButton3);
        add(panel2);

        JPanel panel3 = new JPanel();
        panel3.add(comboBox);
        add(panel3);

        JPanel panel4 = new JPanel();
        panel4.add(button);
        add(panel4);

        JPanel panel5 = new JPanel();
        panel5.add(label2);
        add(panel5);

        // Añadir el listener al botón
        button.addActionListener(this);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Obtener la cantidad a convertir
        String input = textField.getText();
        double cantidad = Double.parseDouble(input);

        // Obtener la opción seleccionada en el combo box
        int seleccion = comboBox.getSelectedIndex();

        // Realizar la conversión
        double resultado = 0;
        String unidad1 = "", unidad2 = "";
        if (radioButton1.isSelected()) {
            // Conversión de monedas
            if (seleccion == 0) {
                resultado = cantidad / 18.29;
                unidad1 = "pesos";
                unidad2 = "dolares";
            } else if (seleccion == 1) {
                resultado = cantidad * 18.29;
                unidad1 = "dolares";
                unidad2 = "pesos";
            }
            else if (seleccion == 2) {
                resultado = cantidad / 19.61;
                unidad1 = "pesos";
                unidad2 = "euros";
            }
            else if (seleccion == 3) {
                resultado = cantidad * 19.61;
                unidad1 = "euros";
                unidad2 = "pesos";
            }
        } else if (radioButton2.isSelected()) {
            // Conversión de temperatura
            if (seleccion == 0) {
                resultado = (cantidad * 9/5) + 32;
                unidad1 = "Celsius";
                unidad2 = "Fahrenheit";
            } else if (seleccion == 1) {
                resultado = (cantidad - 32) * 5/9;
                unidad1 = "Fahrenheit";
                unidad2 = "Celsius";
            }
            else if (seleccion == 2) {
                resultado = (cantidad - 32) * 5/9 + 273.15;
                unidad1 = "Fahrenheit";
                unidad2 = "Kelvin";
            }
            else if (seleccion == 3) {
                resultado = (cantidad - 273.15) * 9/5 + 32;
                unidad1 = "Kelvin";
                unidad2 = "Fahrenheit";
            }
            else if (seleccion == 4) {
                resultado = cantidad + 273.15;
                unidad1 = "Celsius";
                unidad2 = "Kelvin";
            }
            else if (seleccion == 5) {
                resultado = cantidad - 273.15;
                unidad1 = "Kelvin";
                unidad2 = "Celsius";
            }
        } else if (radioButton3.isSelected()) {
            // Conversión de longitud
            if (seleccion == 0) {
                resultado = cantidad * 0.62137;
                unidad1 = "Kilometros";
                unidad2 = "Millas";
            } else if (seleccion == 1) {
                resultado = cantidad / 0.62137;
                unidad1 = "Millas";
                unidad2 = "Kilometros";
            }
            else if (seleccion == 2) {
                resultado = cantidad * 1000;
                unidad1 = "Kilometros";
                unidad2 = "Metros";
            }
            else if (seleccion == 3) {
                resultado = cantidad / 1000;
                unidad1 = "Metros";
                unidad2 = "Kilometros";
            }
            else if (seleccion == 4) {
                resultado = cantidad * 100;
                unidad1 = "Metros";
                unidad2 = "Centimetros";
            }
            else if (seleccion == 5) {
                resultado = cantidad / 100;
                unidad1 = "Centimetros";
                unidad2 = "Metros";
            }
        }
        

        // Mostrar el resultado en el label
        String output = String.format("%.2f %s = %.2f %s", cantidad, unidad1, resultado, unidad2);
        label2.setText(output);
    }

    public static void main(String[] args) {
        new Conversor();
    }
}
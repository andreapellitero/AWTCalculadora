
package andreaPellitero;

// Importo los paquetes necesarios para trabajar con awt y sus eventos
import java.awt.*; 
import java.awt.event.*;

/**
 *
 * @author andre
 */

public class Calculadora extends Frame implements ActionListener {
    /*
       Declaro algunas de las variables y componentes, 
       para poder utilizarlas en toda la clase.
    */
    String s1,s2,s3,s4,s5;
    Label display;
    Button but0, but1, but2, but3, but4, but5, but6, but7, but8, but9, div, mult, restar, sumar, igual, borrar;
    int c, n;
    
    // Fuente para todos los botones
    Font fuente = new Font("Monospaced", Font.BOLD, 24);
    
    // Constructor de la clase
    public Calculadora() {
        this.setBackground(Color.GRAY); // Fondo del Frame del color gris

        // Panel Display donde se verá el resultado, y los num que introducimos
        Panel displayPanel = new Panel(); // Creo el Panel 
        display = new Label (); // Creo una etiqueta para utilizarlo como display
        // Utilizo este layout, para que el display ocupe todo el espacio
        displayPanel.setLayout(new GridLayout(1,1)); 
        displayPanel.add(display); // Lo añado en el panel
        display.setFont(new Font("Monospaced", Font.BOLD, 70));
        display.setForeground(Color.GRAY); // Color de la letra
        display.setBackground(Color.WHITE);
        // Fondo Blanco para diferenciarlo del color gris del Frame
        
        /* 
        Creo el Panel números con GridLayout para que los números tengan 
        la misma disposición y tamaño.
        */
        Panel numeros = new Panel();
        numeros.setLayout(new GridLayout(4, 3, 3, 3));//(filas,col,hueco horiz, vert);
        but7 = new Button ("7");
        //Le añado la acción creada en el método->actionPerformed(ActionEvent e)
        but7.addActionListener(this); // This señala
        but7.setForeground(Color.BLACK); // Color de la letra
        but7.setFont(fuente); // Utilizo la fuente creada fuera del constructor
        numeros.add(but7); // Añado el botón al Panel numeros
        /*
        Con el resto de botones de este Panel, es lo mismo que con el botón 7,
        por eso, no los vuelvo a comentar.
        */
        but8 = new Button ("8");
        but8.addActionListener(this);
        but8.setForeground(Color.BLACK); // Se puede utilizar un color básico
        but8.setFont(fuente);
        numeros.add(but8);
        
        but9 = new Button ("9");
        but9.addActionListener(this);
        but9.setForeground(Color.BLACK);
        but9.setFont(fuente);
        numeros.add(but9);
        
        but4 = new Button ("4");
        but4.addActionListener(this);
        but4.setForeground(Color.BLACK);
        but4.setFont(fuente);
        numeros.add(but4);
        
        but5 = new Button ("5");
        but5.addActionListener(this);
        but5.setForeground(Color.BLACK);
        but5.setFont(fuente);
        numeros.add(but5);
        
        but6 = new Button ("6");
        but6.addActionListener(this);
        but6.setForeground(new Color(28, 40, 51)); // Crearlo. Los numeros
        but6.setFont(fuente); // indican la cantidad de (rojo, verde, azul)
        numeros.add(but6);
        
        but1 = new Button ("1");
        but1.addActionListener(this);
        but1.setForeground(new Color(28, 40, 51));
        but1.setFont(fuente);
        numeros.add(but1);
        
        but2 = new Button ("2");
        but2.addActionListener(this);
        but2.setForeground(new Color(28, 40, 51));
        but2.setFont(fuente);
        numeros.add(but2);
        
        but3 = new Button ("3");
        but3.addActionListener(this);
        but3.setForeground(new Color(28, 40, 51));
        but3.setFont(fuente);
        numeros.add(but3);
        
        igual = new Button ("=");
        igual.addActionListener(this);
        igual.setForeground(Color.WHITE);
        igual.setFont(fuente);
        igual.setBackground(new Color(150, 200, 200));
        numeros.add(igual);
        
        but0 = new Button ("0");
        but0.addActionListener(this);
        but0.setForeground(new Color(28, 40, 51));
        but0.setFont(fuente);
        numeros.add(but0);
        
        borrar = new Button ("DEL");
        borrar.addActionListener(this);
        borrar.setBackground(new Color(255, 175, 175));
        borrar.setForeground(new Color(255, 100, 100));
        borrar.setFont(fuente);
        numeros.add(borrar);
        
        // Panel operadores (Lo mismo que expliqué en el Panel números)
        Panel operadores = new Panel();
        operadores.setLayout(new GridLayout(4, 1, 4, 3));
        div = new Button ("÷");
        div.setForeground(Color.GRAY);
        div.setFont(fuente);
        div.addActionListener(this);
        operadores.add(div);
        
        mult = new Button ("x");
        mult.addActionListener(this);
        mult.setForeground(Color.GRAY);
        mult.setFont(fuente);
        operadores.add(mult);
        
        restar = new Button ("-");
        restar.addActionListener(this);
        operadores.add(restar);
        restar.setForeground(Color.GRAY);
        restar.setFont(fuente);
        
        sumar = new Button ("+");
        sumar.addActionListener(this);
        sumar.setForeground(Color.GRAY);
        sumar.setFont(fuente);
        operadores.add(sumar);
 
        // Metemos todo en un GridBagLayout
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        GridBagConstraints gcon = new GridBagConstraints();
        gcon.weightx = 1;
        gcon.weighty = 1;
        gcon.fill = GridBagConstraints.BOTH; 
        // BOTH para que los componentes ocupen las celdas
        
        // Introduzco el Panel Display
        gcon.gridy = 0; // El displayPanel empieza en la fila cero.
        gcon.gridx = 0; // Empieza en la columna cero.
        gcon.gridwidth = 2; // Ocupa 4 columnas
        /*
        Paso el objeto de tipo GridBagConstraints (gcon)
        para que el panel principal(gbl) sepa dónde ha de situar displayPanel:
        */
        gbl.setConstraints(displayPanel, gcon); 
        add(displayPanel);
        
        // Lo mismo con el Panel numeros
        gcon.gridy = 1; // Empieza en la fila 1
        gcon.gridx = 0; // Empieza en la columna 0
        gcon.gridwidth = 1; // Ocupa 3 columas
        gcon.gridheight = 1; // Ocupa 4 filas
        gbl.setConstraints(numeros, gcon);
        add(numeros);
        
        // Y con el Panel operadores
        gcon.gridy = 1; // Empieza en la fila 1
        gcon.gridx = 1; // Empieza en la columna 3
        gcon.gridwidth = 1; // Ocupa 1 columna
        gcon.gridheight = 1; // Ocupa 2 columnas
        gbl.setConstraints(operadores, gcon);
        add(operadores);
        
        this.setResizable(false); // Método para que no se pueda maximizar la calculadora
        setTitle("Calculadora ©Andrea"); // Título del Frame
        setVisible(true); 
        setSize(300,450); // Tamaño de la calculadora (ancho, alto)
        
        // Método para que podamos cerrar la calculadora
        addWindowListener(new WindowAdapter() {
            public void windowClosing( WindowEvent e) {
            System.exit(0);
            }
        } ); 
    }
    
    // En un mismo método, le doy acción a cada uno de los botones
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == but0){ // Cuando pulsamos el botón 0
            s3 = display.getText(); // El display obtiene el texto
            s4 = "0";
            s5 = s3 + s4; // A lo que había en el display, le suma en este caso 0
            display.setText(s5); // Muestra en el display la última cifra introducida (en este caso 0)
        }
        // Lo mismo para el resto de botones
        if(e.getSource() == but1){
            s3 = display.getText();
            s4 = "1";
            s5 = s3 + s4;
            display.setText(s5);
        }
        if(e.getSource() == but2){
            s3 = display.getText();
            s4 = "2";
            s5 = s3 + s4;
            display.setText(s5);
        }
        if(e.getSource() == but3){
            s3 = display.getText();
            s4 = "3";
            s5 = s3 + s4;
            display.setText(s5);
        }
        if(e.getSource() == but4){
            s3 = display.getText();
            s4 = "4";
            s5 = s3 + s4;
            display.setText(s5);
        }
        if(e.getSource() == but5){
            s3 = display.getText();
            s4 = "5";
            s5 = s3 + s4;
            display.setText(s5);
        }
        if(e.getSource() == but6){
            s3 = display.getText();
            s4 = "6";
            s5 = s3 + s4;
            display.setText(s5);
        }
        if(e.getSource() == but7){
            s3 = display.getText();
            s4 = "7";
            s5 = s3 + s4;
            display.setText(s5);
        }
        if(e.getSource() == but8){
            s3 = display.getText();
            s4 = "8";
            s5 = s3 + s4;
            display.setText(s5);
        }
        if(e.getSource() == but9){
            s3 = display.getText();
            s4 = "9";
            s5 = s3 + s4;
            display.setText(s5);
        }
        if(e.getSource() == sumar){
            s1 = display.getText();
            display.setText(""); // Cadena vacía para vaciar el display
            // pulsar un operador e introducir otro numero
            c = 1; // Al pulsar +, caso 1
        }
        if(e.getSource() == restar){
            s1 = display.getText();
            display.setText(""); 
            c = 2; // Al pulsar -, caso 1
        }
        if(e.getSource() == mult){
            s1 = display.getText();
            display.setText("");
            c = 3; // Al pulsar x, caso 1
        }
        if(e.getSource() == div){
            s1 = display.getText();
            display.setText("");
            c = 4; // Al pulsar ÷, caso 1
        }
        if(e.getSource() == igual){ // Al pulsar el botón igual
            s2 = display.getText();
            /*
              En todas pasamos las cadenas String a int para poder hacer
              las operaciones con Integer.parseInt y después al revés, con 
              String.valueOf para poder mostrarlos en el Label (display) 
              con .setText
            */
            if(c == 1){ // Caso 1, suma
                n = Integer.parseInt(s1) + Integer.parseInt(s2); 
                display.setText(String.valueOf(n));
            }
            if(c == 2){ // Caso 2, resta
                n = Integer.parseInt(s1) - Integer.parseInt(s2);
                display.setText(String.valueOf(n));
           
            }
            if(c == 3){ // Caso 3, multiplicación
                n = Integer.parseInt(s1) * Integer.parseInt(s2);
                display.setText(String.valueOf(n));
            }
            if(c == 4){ // Caso 4, división
                n = Integer.parseInt(s1) / Integer.parseInt(s2);
                display.setText(String.valueOf(n));
            }
        }
        if(e.getSource() == borrar){
            display.setText(""); // Colocamos una cadena vacía
        }
    }
    
    public static void main (String [] args){
        // En el main llamo al Constructor
        Calculadora app = new Calculadora();
        app.setVisible(true); // Para poder hacer visible la calculadora
    }

}
package  tarea1_mundialdqatar;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class CalculadoraPostal extends javax.swing.JFrame {
    
    String usuario, cedula, direccion, pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9, pos10, pos11, pos12, pos13, pos14, pos15, pos16, pos17, pos18, pos19, pos20;
    String servicios[] = { "Secciones","Pagina Principal", "Estadios", "Extra Sticker", "Postales", "Museo FIFA"};
    String postalesPaginaPrincipal[] = {"FWC1", "FWC2", "FWC3", "FWC4", "FWC5", "FWC6", "FWC7"};
    String postalesEstadios[] = {"FWC8", "FWC9", "FWC10", "FWC11", "FWC12", "FWC13", "FWC14", "FWC15", "FWC16", "FWC17", "FWC18"};
    String extraStickers[] = {"Sadio Mané", "Lionel Messi", "Cristiano Ronaldo", "Luka Modric", "Neymar",  "Luis Suárez", "Heung-Min Son", "Ryan Gravenberch", "Jude Bellingham", "Giovanni Reyna"};
    String postales[] = {
        "QAT1", "QAT2", "QAT3", "QAT4", "QAT5", "QAT6", "QAT7", "QAT8", "QAT9", "QAT10", "ECU1", "ECU2", "ECU3", "ECU4", "ECU5", "ECU6", "ECU7", "ECU8", "ECU9", "ECU10", "MEX1", "MEX2", "MEX3", "MEX4", "MEX5", "MEX6", "MEX7", "MEX8", "MEX9", "MEX10",
        "POL1", "POL2", "POL3", "POL4", "POL5", "POL6", "POL7", "POL8", "POL9", "POL10", "ENG1", "ENG2", "ENG3", "ENG4", "ENG5", "ENG6", "ENG7", "ENG8", "ENG9", "ENG10", "ESP1", "ESP2", "ESP3", "ESP4", "ESP5", "ESP6", "ESP7", "ESP8", "ESP9", "ESP10",
        "CRC1", "CRC2", "CRC3", "CRC4", "CRC5", "CRC6", "CRC7", "CRC8", "CRC9", "CRC10", "FRA1", "FRA2", "FRA3", "FRA4", "FRA5", "FRA6", "FRA7", "FRA8", "FRA9", "FRA10"
    };
    String postalesMuseosFifa[] = {"FWC23", "FWC24", "FWC25", "FWC26", "FWC27", "FWC28", "FWC29"};

    private int precios[] = {0, 150, 100, 150, 200, 150};   //Array que almacena los precios
    public static int precio = 0, indice = 0;                        //Variable para contar el indice del ComboBox y para almacenar el precio
    public static int servicioDomicilio = 3000;                   //Variable que almacena el monto de envio
    public static int contador = 0;                                    //Variable para contar la cantidad de postales
    public static int subtotal = 0;
    private int a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, b1, b2, b3, b4, b5, c1, c2, c3, c4, c5, d1, d2, d3, d4, d5, con1, con2, con3, con4, con5 = 0; //Variables para la elección de postales
    char validarSoloNumeros; //Variable para validar la entrada de solamente numeros en el TextField de la cédula
    
    DefaultTableModel modelo = new DefaultTableModel();   //Declaramos un nuevo modelo para nuestra JTable que vamos a usar
    ArrayList<Postal> listaVentas = new ArrayList<Postal>(); //Declaramos una nueva lista para imprimir valores dentro de la JTable 

    public CalculadoraPostal() {
        initComponents();
        this.setTitle("TIENDA DE POSTALES"); //Asiganmos este titulo para la interface
        this.setLocationRelativeTo(this);           //Su ubicación ssera en el centro de la pntalla de la pc
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/qatar.png"));   //Le ponemos un icono del país de Qatar
        this.setIconImage(icono);                                                                                                                         //Aca se lo asignamos para que se pueda visualizar
        Image logo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/postale.png")); //Le ponemos un logo a nuestros JPanel los cuales son registro y tienda
        logoQatar.setIcon(new ImageIcon(logo.getScaledInstance(logoQatar.getWidth(), logoQatar.getHeight(), Image.SCALE_SMOOTH))); //Aca se lo asignamos al JLabel del JPanel Registro
        logoQatar1.setIcon(new ImageIcon(logo.getScaledInstance(logoQatar1.getWidth(), logoQatar1.getHeight(), Image.SCALE_SMOOTH))); //Aca se lo asignamos al JLabel del JPanel Tienda
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel(servicios); //Al comoboBox le cremos un nuevo modelo, que contendra las secciones dentro de nuestro array de servicios
        seccionesDesplegables.setModel(comboModel); //Aca se lo asignamos a nuestro ComboBox con nombre seccionesDesplegables
        calcularPrecio();
        borrarVenta();
        modelo.addColumn("DESCRIPCION"); //A la JTable le asignamos sus debidos nombres en las columnas, en este caso son 5
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("POSTALES");
        modelo.addColumn("TOTAL");
        tablaDeCompras.setGridColor(new java.awt.Color(255, 255, 255)); //Aca le ponemos a la JTable separaciones de color blanco para que esteticamente se vea mejor con nuestro contenedor
        Scroll.setBorder(null); //Aca le ponemos al Scroll bordes nulos, para que no se vean y se aprecie mejor
        seccionesDesplegables.setBorder(null); //Igual al JComboBox
        contenedorDireccionTextField.setVisible(false); //Ocultamos el Textfield de la dirección para que se muestre cuando pase un evento
        contenedorDiseñoRedondeado.setVisible(false);
        panelTienda.setVisible(false); //Igual con estos dos JPanel
        panelFactura.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistro = new javax.swing.JPanel();
        contenedorBienvenida = new tarea1_mundialdqatar.BordesRedondeados();
        tituloFifa3 = new javax.swing.JLabel();
        contenedorBotonAvanzar = new tarea1_mundialdqatar.BordesRedondeados();
        avanzarBoton = new javax.swing.JButton();
        contenedorBotonSalirBienvenida = new tarea1_mundialdqatar.BordesRedondeados();
        salirBotonBienvenida = new javax.swing.JButton();
        bienvenidaLabel = new javax.swing.JLabel();
        text6 = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        text3 = new javax.swing.JLabel();
        text4 = new javax.swing.JLabel();
        text5 = new javax.swing.JLabel();
        contenedorBotonSalirBienvenida1 = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorBotonSalirBienvenida2 = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorBotonSalirBienvenida3 = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorBotonSalirBienvenida4 = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorBotonSalirBienvenida5 = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorDiseñoRedondeado = new tarea1_mundialdqatar.BordesRedondeados();
        preguntaDomicilioLabel = new javax.swing.JLabel();
        checkSi = new javax.swing.JCheckBox();
        labelSi = new javax.swing.JLabel();
        costoLabelDeEnvio = new javax.swing.JLabel();
        direccionLabel = new javax.swing.JLabel();
        contenedorDireccionTextField = new tarea1_mundialdqatar.BordesRedondeados();
        direccionTextField = new javax.swing.JTextField();
        contenedorCedulaField = new tarea1_mundialdqatar.BordesRedondeados();
        cedulaTextField = new javax.swing.JTextField();
        contenedorUsuarioField = new tarea1_mundialdqatar.BordesRedondeados();
        usuarioTextField = new javax.swing.JTextField();
        contenedorLogin = new tarea1_mundialdqatar.BordesRedondeados();
        logoQatar = new javax.swing.JLabel();
        diseño8x = new tarea1_mundialdqatar.BordesRedondeados();
        diseño6x = new tarea1_mundialdqatar.BordesRedondeados();
        diseño4x = new tarea1_mundialdqatar.BordesRedondeados();
        diseño2x = new tarea1_mundialdqatar.BordesRedondeados();
        titulo2022 = new javax.swing.JLabel();
        tituloFifa1 = new javax.swing.JLabel();
        contenedorBotonRegistro = new tarea1_mundialdqatar.BordesRedondeados();
        registroBoton = new javax.swing.JButton();
        contenedorBotonSalir = new tarea1_mundialdqatar.BordesRedondeados();
        salirBoton = new javax.swing.JButton();
        usuarioLabel = new javax.swing.JLabel();
        cedulaLabel = new javax.swing.JLabel();
        contenedorBotonSalirBienvenida6 = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorBotonSalirBienvenida7 = new tarea1_mundialdqatar.BordesRedondeados();
        panelTienda = new javax.swing.JPanel();
        contenedorPanini = new tarea1_mundialdqatar.BordesRedondeados();
        tituloLabel1 = new javax.swing.JLabel();
        productoLabel = new javax.swing.JLabel();
        totalAPagarLabel = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        contenedorLogin1 = new tarea1_mundialdqatar.BordesRedondeados();
        logoQatar1 = new javax.swing.JLabel();
        diseño8x1 = new tarea1_mundialdqatar.BordesRedondeados();
        diseño6x1 = new tarea1_mundialdqatar.BordesRedondeados();
        diseño4x1 = new tarea1_mundialdqatar.BordesRedondeados();
        diseño2x1 = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorPrecioMostrara = new tarea1_mundialdqatar.BordesRedondeados();
        precioQSeMostraraLabel = new javax.swing.JLabel();
        contenedorTotalMostrar = new tarea1_mundialdqatar.BordesRedondeados();
        totalAPagarQSeMostraraLabel = new javax.swing.JLabel();
        contenedorSecciones = new tarea1_mundialdqatar.BordesRedondeados();
        seccionesDesplegables = new javax.swing.JComboBox<>();
        contenedorSpinner = new tarea1_mundialdqatar.BordesRedondeados();
        cantidadEnSpinner = new javax.swing.JSpinner();
        contenedorAgregarCompra = new tarea1_mundialdqatar.BordesRedondeados();
        adregarMasBoton = new javax.swing.JButton();
        contenedorSalir = new tarea1_mundialdqatar.BordesRedondeados();
        obtenerFactura = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        contenedorBotonSalirBienvenida8 = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorBotonSalirBienvenida9 = new tarea1_mundialdqatar.BordesRedondeados();
        panelFactura = new javax.swing.JPanel();
        contenedorDiseñoRedondeado1 = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorSalirSistemaFactura = new tarea1_mundialdqatar.BordesRedondeados();
        salirDelSistemFactura = new javax.swing.JButton();
        contenedorCedulaUsuario = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorTablaDeCompras = new tarea1_mundialdqatar.BordesRedondeados();
        Scroll = new javax.swing.JScrollPane();
        tablaDeCompras = new javax.swing.JTable();
        subTotalLabel = new javax.swing.JLabel();
        subTotalQueSeMostrara = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        cedulaUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tituloFactura = new javax.swing.JLabel();
        direccionUsuario = new javax.swing.JLabel();
        contenedorBotonSalirBienvenida10 = new tarea1_mundialdqatar.BordesRedondeados();
        contenedorBotonSalirBienvenida11 = new tarea1_mundialdqatar.BordesRedondeados();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        panelRegistro.setBackground(new java.awt.Color(255, 255, 255));
        panelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorBienvenida.setBackground(new java.awt.Color(85, 0, 43));
        contenedorBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        contenedorBienvenida.setRoundBottomLeft(30);
        contenedorBienvenida.setRoundBottomRight(30);
        contenedorBienvenida.setRoundTopLeft(30);
        contenedorBienvenida.setRoundTopRight(30);
        contenedorBienvenida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloFifa3.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        tituloFifa3.setForeground(new java.awt.Color(255, 255, 255));
        tituloFifa3.setText("Bienvenido a nuestra tienda");
        contenedorBienvenida.add(tituloFifa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 630, 40));

        contenedorBotonAvanzar.setBackground(new java.awt.Color(255, 153, 0));
        contenedorBotonAvanzar.setRoundBottomLeft(60);
        contenedorBotonAvanzar.setRoundBottomRight(60);
        contenedorBotonAvanzar.setRoundTopLeft(60);
        contenedorBotonAvanzar.setRoundTopRight(60);
        contenedorBotonAvanzar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        avanzarBoton.setBackground(new java.awt.Color(255, 153, 0));
        avanzarBoton.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        avanzarBoton.setForeground(new java.awt.Color(0, 0, 0));
        avanzarBoton.setText("Avanzar");
        avanzarBoton.setBorder(null);
        avanzarBoton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        avanzarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avanzarBotonActionPerformed(evt);
            }
        });
        contenedorBotonAvanzar.add(avanzarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 15, -1, 26));

        contenedorBienvenida.add(contenedorBotonAvanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 720, 160, 50));

        contenedorBotonSalirBienvenida.setBackground(new java.awt.Color(255, 153, 0));
        contenedorBotonSalirBienvenida.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida.setRoundBottomLeft(60);
        contenedorBotonSalirBienvenida.setRoundBottomRight(60);
        contenedorBotonSalirBienvenida.setRoundTopLeft(60);
        contenedorBotonSalirBienvenida.setRoundTopRight(60);
        contenedorBotonSalirBienvenida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salirBotonBienvenida.setBackground(new java.awt.Color(255, 153, 0));
        salirBotonBienvenida.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        salirBotonBienvenida.setForeground(new java.awt.Color(0, 0, 0));
        salirBotonBienvenida.setText("Salir");
        salirBotonBienvenida.setBorder(null);
        salirBotonBienvenida.setMargin(new java.awt.Insets(2, 2, 2, 2));
        salirBotonBienvenida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonBienvenidaActionPerformed(evt);
            }
        });
        contenedorBotonSalirBienvenida.add(salirBotonBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, 130, 28));

        contenedorBienvenida.add(contenedorBotonSalirBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 720, 160, 50));

        bienvenidaLabel.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        bienvenidaLabel.setForeground(new java.awt.Color(204, 204, 204));
        bienvenidaLabel.setText("Antes de proceder, porque no te detienes a leer nuestras condiciones");
        contenedorBienvenida.add(bienvenidaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 820, -1));

        text6.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        text6.setForeground(new java.awt.Color(204, 204, 204));
        text6.setText("La factura de tus compras se mostrara al final.");
        contenedorBienvenida.add(text6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 1000, -1));

        text1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        text1.setForeground(new java.awt.Color(204, 204, 204));
        text1.setText("Las postales serán elegidas al azar.");
        contenedorBienvenida.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 620, -1));

        text2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        text2.setForeground(new java.awt.Color(204, 204, 204));
        text2.setText("Solo podras comprar 5 postales en cualquier sección, a ecepción de la sección de postales");
        contenedorBienvenida.add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 1030, -1));

        text3.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        text3.setForeground(new java.awt.Color(204, 204, 204));
        text3.setText("en estapodras comprar hasta 20 postales.");
        contenedorBienvenida.add(text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 1000, -1));

        text4.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        text4.setForeground(new java.awt.Color(204, 204, 204));
        text4.setText("Solo tendras una oportunidad para hacer tu compra, ya que después de seleccionar una vez");
        contenedorBienvenida.add(text4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 1000, -1));

        text5.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        text5.setForeground(new java.awt.Color(204, 204, 204));
        text5.setText("cada sección, esta se bloqueara.");
        contenedorBienvenida.add(text5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 1000, -1));

        contenedorBotonSalirBienvenida1.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida1.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida1.setRoundBottomLeft(30);
        contenedorBotonSalirBienvenida1.setRoundBottomRight(30);
        contenedorBotonSalirBienvenida1.setRoundTopLeft(30);
        contenedorBotonSalirBienvenida1.setRoundTopRight(30);
        contenedorBotonSalirBienvenida1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorBienvenida.add(contenedorBotonSalirBienvenida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 290, 10));

        contenedorBotonSalirBienvenida2.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida2.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida2.setRoundBottomLeft(30);
        contenedorBotonSalirBienvenida2.setRoundTopLeft(30);
        contenedorBotonSalirBienvenida2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorBienvenida.add(contenedorBotonSalirBienvenida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 100, 20, 610));

        contenedorBotonSalirBienvenida3.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida3.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida3.setRoundBottomLeft(30);
        contenedorBotonSalirBienvenida3.setRoundBottomRight(30);
        contenedorBotonSalirBienvenida3.setRoundTopLeft(30);
        contenedorBotonSalirBienvenida3.setRoundTopRight(30);
        contenedorBotonSalirBienvenida3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorBienvenida.add(contenedorBotonSalirBienvenida3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 590, 540, 10));

        contenedorBotonSalirBienvenida4.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida4.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida4.setRoundBottomLeft(30);
        contenedorBotonSalirBienvenida4.setRoundBottomRight(30);
        contenedorBotonSalirBienvenida4.setRoundTopLeft(30);
        contenedorBotonSalirBienvenida4.setRoundTopRight(30);
        contenedorBotonSalirBienvenida4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorBienvenida.add(contenedorBotonSalirBienvenida4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 850, 10));

        contenedorBotonSalirBienvenida5.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida5.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida5.setRoundBottomRight(30);
        contenedorBotonSalirBienvenida5.setRoundTopRight(30);
        contenedorBotonSalirBienvenida5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorBienvenida.add(contenedorBotonSalirBienvenida5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 20, 610));

        panelRegistro.add(contenedorBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1160, 810));

        contenedorDiseñoRedondeado.setBackground(new java.awt.Color(85, 0, 43));
        contenedorDiseñoRedondeado.setForeground(new java.awt.Color(255, 255, 255));
        contenedorDiseñoRedondeado.setRoundBottomLeft(30);
        contenedorDiseñoRedondeado.setRoundBottomRight(30);
        contenedorDiseñoRedondeado.setRoundTopLeft(30);
        contenedorDiseñoRedondeado.setRoundTopRight(30);
        contenedorDiseñoRedondeado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        preguntaDomicilioLabel.setFont(new java.awt.Font("Courier New", 1, 19)); // NOI18N
        preguntaDomicilioLabel.setForeground(new java.awt.Color(255, 255, 255));
        preguntaDomicilioLabel.setText("¿Desea que su compra sea de envio a dimicilio?");
        contenedorDiseñoRedondeado.add(preguntaDomicilioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, -1));

        checkSi.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        checkSi.setForeground(new java.awt.Color(204, 204, 204));
        checkSi.setBorder(null);
        checkSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSiActionPerformed(evt);
            }
        });
        contenedorDiseñoRedondeado.add(checkSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, -1, -1));

        labelSi.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        labelSi.setForeground(new java.awt.Color(255, 255, 255));
        labelSi.setText("Si");
        contenedorDiseñoRedondeado.add(labelSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, -1, -1));

        costoLabelDeEnvio.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        costoLabelDeEnvio.setForeground(new java.awt.Color(204, 204, 204));
        costoLabelDeEnvio.setText("Costo de envio $ 3000");
        contenedorDiseñoRedondeado.add(costoLabelDeEnvio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, -1, -1));

        direccionLabel.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        direccionLabel.setForeground(new java.awt.Color(204, 204, 204));
        direccionLabel.setText("Dirección");
        contenedorDiseñoRedondeado.add(direccionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, -1, -1));

        contenedorDireccionTextField.setBackground(new java.awt.Color(255, 255, 255));
        contenedorDireccionTextField.setForeground(new java.awt.Color(255, 255, 255));
        contenedorDireccionTextField.setRoundBottomLeft(30);
        contenedorDireccionTextField.setRoundBottomRight(30);
        contenedorDireccionTextField.setRoundTopLeft(30);
        contenedorDireccionTextField.setRoundTopRight(30);
        contenedorDireccionTextField.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        direccionTextField.setBackground(new java.awt.Color(255, 255, 255));
        direccionTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        direccionTextField.setForeground(new java.awt.Color(0, 0, 0));
        direccionTextField.setBorder(null);
        direccionTextField.setCaretColor(new java.awt.Color(255, 51, 0));
        direccionTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccionTextFieldKeyTyped(evt);
            }
        });
        contenedorDireccionTextField.add(direccionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 20));

        contenedorDiseñoRedondeado.add(contenedorDireccionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 380, 40));

        contenedorCedulaField.setBackground(new java.awt.Color(255, 255, 255));
        contenedorCedulaField.setRoundBottomLeft(30);
        contenedorCedulaField.setRoundBottomRight(30);
        contenedorCedulaField.setRoundTopLeft(30);
        contenedorCedulaField.setRoundTopRight(30);
        contenedorCedulaField.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cedulaTextField.setBackground(new java.awt.Color(255, 255, 255));
        cedulaTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        cedulaTextField.setForeground(new java.awt.Color(0, 0, 0));
        cedulaTextField.setBorder(null);
        cedulaTextField.setCaretColor(new java.awt.Color(255, 51, 0));
        cedulaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaTextFieldKeyTyped(evt);
            }
        });
        contenedorCedulaField.add(cedulaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 20));

        contenedorDiseñoRedondeado.add(contenedorCedulaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 330, 40));

        contenedorUsuarioField.setBackground(new java.awt.Color(255, 255, 255));
        contenedorUsuarioField.setForeground(new java.awt.Color(255, 255, 255));
        contenedorUsuarioField.setRoundBottomLeft(30);
        contenedorUsuarioField.setRoundBottomRight(30);
        contenedorUsuarioField.setRoundTopLeft(30);
        contenedorUsuarioField.setRoundTopRight(30);
        contenedorUsuarioField.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarioTextField.setBackground(new java.awt.Color(255, 255, 255));
        usuarioTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        usuarioTextField.setForeground(new java.awt.Color(0, 0, 0));
        usuarioTextField.setBorder(null);
        usuarioTextField.setCaretColor(new java.awt.Color(255, 51, 0));
        usuarioTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usuarioTextFieldKeyTyped(evt);
            }
        });
        contenedorUsuarioField.add(usuarioTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 20));

        contenedorDiseñoRedondeado.add(contenedorUsuarioField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 330, 40));

        contenedorLogin.setBackground(new java.awt.Color(255, 255, 255));
        contenedorLogin.setForeground(new java.awt.Color(255, 255, 255));
        contenedorLogin.setRoundBottomLeft(100);
        contenedorLogin.setRoundBottomRight(30);
        contenedorLogin.setRoundTopLeft(100);
        contenedorLogin.setRoundTopRight(30);
        contenedorLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorLogin.add(logoQatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 40, 500, 500));

        diseño8x.setBackground(new java.awt.Color(85, 0, 43));
        diseño8x.setRoundBottomLeft(10);
        diseño8x.setRoundBottomRight(10);
        diseño8x.setRoundTopLeft(10);
        diseño8x.setRoundTopRight(10);

        javax.swing.GroupLayout diseño8xLayout = new javax.swing.GroupLayout(diseño8x);
        diseño8x.setLayout(diseño8xLayout);
        diseño8xLayout.setHorizontalGroup(
            diseño8xLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        diseño8xLayout.setVerticalGroup(
            diseño8xLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        contenedorLogin.add(diseño8x, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, -1, 10));

        diseño6x.setBackground(new java.awt.Color(85, 0, 43));
        diseño6x.setRoundBottomLeft(10);
        diseño6x.setRoundBottomRight(10);
        diseño6x.setRoundTopLeft(10);
        diseño6x.setRoundTopRight(10);
        contenedorLogin.add(diseño6x, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, 130, -1));

        diseño4x.setBackground(new java.awt.Color(85, 0, 43));
        diseño4x.setRoundBottomLeft(10);
        diseño4x.setRoundBottomRight(10);
        diseño4x.setRoundTopLeft(10);
        diseño4x.setRoundTopRight(10);
        contenedorLogin.add(diseño4x, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 50, -1));

        diseño2x.setBackground(new java.awt.Color(85, 0, 43));
        diseño2x.setRoundBottomLeft(10);
        diseño2x.setRoundBottomRight(10);
        diseño2x.setRoundTopLeft(10);
        diseño2x.setRoundTopRight(10);
        contenedorLogin.add(diseño2x, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 700, -1, -1));

        contenedorDiseñoRedondeado.add(contenedorLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 460, 730));

        titulo2022.setFont(new java.awt.Font("Courier New", 0, 36)); // NOI18N
        titulo2022.setForeground(new java.awt.Color(255, 255, 255));
        titulo2022.setText("Qatar 2022");
        contenedorDiseñoRedondeado.add(titulo2022, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 280, 40));

        tituloFifa1.setFont(new java.awt.Font("Courier New", 0, 36)); // NOI18N
        tituloFifa1.setForeground(new java.awt.Color(255, 255, 255));
        tituloFifa1.setText("FIFA WORLD CUP");
        contenedorDiseñoRedondeado.add(tituloFifa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 350, 40));

        contenedorBotonRegistro.setBackground(new java.awt.Color(255, 153, 0));
        contenedorBotonRegistro.setRoundBottomLeft(60);
        contenedorBotonRegistro.setRoundBottomRight(60);
        contenedorBotonRegistro.setRoundTopLeft(60);
        contenedorBotonRegistro.setRoundTopRight(60);
        contenedorBotonRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registroBoton.setBackground(new java.awt.Color(255, 153, 0));
        registroBoton.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        registroBoton.setForeground(new java.awt.Color(0, 0, 0));
        registroBoton.setText("Registrarse");
        registroBoton.setBorder(null);
        registroBoton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        registroBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBotonActionPerformed(evt);
            }
        });
        contenedorBotonRegistro.add(registroBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, 26));

        contenedorDiseñoRedondeado.add(contenedorBotonRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 720, 160, 50));

        contenedorBotonSalir.setBackground(new java.awt.Color(255, 153, 0));
        contenedorBotonSalir.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalir.setRoundBottomLeft(60);
        contenedorBotonSalir.setRoundBottomRight(60);
        contenedorBotonSalir.setRoundTopLeft(60);
        contenedorBotonSalir.setRoundTopRight(60);
        contenedorBotonSalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salirBoton.setBackground(new java.awt.Color(255, 153, 0));
        salirBoton.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        salirBoton.setForeground(new java.awt.Color(0, 0, 0));
        salirBoton.setText("Salir");
        salirBoton.setBorder(null);
        salirBoton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        salirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonActionPerformed(evt);
            }
        });
        contenedorBotonSalir.add(salirBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, 130, 28));

        contenedorDiseñoRedondeado.add(contenedorBotonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 720, 160, 50));

        usuarioLabel.setFont(new java.awt.Font("Courier New", 0, 20)); // NOI18N
        usuarioLabel.setForeground(new java.awt.Color(204, 204, 204));
        usuarioLabel.setText("Usuario :");
        contenedorDiseñoRedondeado.add(usuarioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 130, -1));

        cedulaLabel.setFont(new java.awt.Font("Courier New", 0, 20)); // NOI18N
        cedulaLabel.setForeground(new java.awt.Color(204, 204, 204));
        cedulaLabel.setText("Cedula  :");
        contenedorDiseñoRedondeado.add(cedulaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 110, -1));

        contenedorBotonSalirBienvenida6.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida6.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida6.setRoundBottomRight(30);
        contenedorBotonSalirBienvenida6.setRoundTopRight(30);
        contenedorBotonSalirBienvenida6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorDiseñoRedondeado.add(contenedorBotonSalirBienvenida6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 20, 610));

        contenedorBotonSalirBienvenida7.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida7.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida7.setRoundBottomLeft(30);
        contenedorBotonSalirBienvenida7.setRoundTopLeft(30);
        contenedorBotonSalirBienvenida7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorDiseñoRedondeado.add(contenedorBotonSalirBienvenida7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 100, 20, 610));

        panelRegistro.add(contenedorDiseñoRedondeado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1160, 810));

        panelTienda.setBackground(new java.awt.Color(255, 255, 255));
        panelTienda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorPanini.setBackground(new java.awt.Color(85, 0, 43));
        contenedorPanini.setPreferredSize(new java.awt.Dimension(1120, 770));
        contenedorPanini.setRoundBottomLeft(30);
        contenedorPanini.setRoundBottomRight(30);
        contenedorPanini.setRoundTopLeft(30);
        contenedorPanini.setRoundTopRight(30);
        contenedorPanini.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloLabel1.setBackground(new java.awt.Color(0, 0, 0));
        tituloLabel1.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        tituloLabel1.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel1.setText("Tienda Oficial Panini");
        contenedorPanini.add(tituloLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 390, -1));

        productoLabel.setFont(new java.awt.Font("Courier New", 0, 20)); // NOI18N
        productoLabel.setForeground(new java.awt.Color(204, 204, 204));
        productoLabel.setText("Secciónes");
        contenedorPanini.add(productoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 260, -1));

        totalAPagarLabel.setFont(new java.awt.Font("Courier New", 0, 20)); // NOI18N
        totalAPagarLabel.setForeground(new java.awt.Color(204, 204, 204));
        totalAPagarLabel.setText("Total a pagar");
        contenedorPanini.add(totalAPagarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, -1, -1));

        precioLabel.setFont(new java.awt.Font("Courier New", 0, 20)); // NOI18N
        precioLabel.setForeground(new java.awt.Color(204, 204, 204));
        precioLabel.setText("Precio por sección");
        contenedorPanini.add(precioLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        contenedorLogin1.setBackground(new java.awt.Color(255, 255, 255));
        contenedorLogin1.setForeground(new java.awt.Color(255, 255, 255));
        contenedorLogin1.setRoundBottomLeft(100);
        contenedorLogin1.setRoundBottomRight(30);
        contenedorLogin1.setRoundTopLeft(100);
        contenedorLogin1.setRoundTopRight(30);
        contenedorLogin1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorLogin1.add(logoQatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 40, 500, 500));

        diseño8x1.setBackground(new java.awt.Color(85, 0, 43));
        diseño8x1.setRoundBottomLeft(10);
        diseño8x1.setRoundBottomRight(10);
        diseño8x1.setRoundTopLeft(10);
        diseño8x1.setRoundTopRight(10);

        javax.swing.GroupLayout diseño8x1Layout = new javax.swing.GroupLayout(diseño8x1);
        diseño8x1.setLayout(diseño8x1Layout);
        diseño8x1Layout.setHorizontalGroup(
            diseño8x1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        diseño8x1Layout.setVerticalGroup(
            diseño8x1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        contenedorLogin1.add(diseño8x1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, -1, 10));

        diseño6x1.setBackground(new java.awt.Color(85, 0, 43));
        diseño6x1.setRoundBottomLeft(10);
        diseño6x1.setRoundBottomRight(10);
        diseño6x1.setRoundTopLeft(10);
        diseño6x1.setRoundTopRight(10);
        contenedorLogin1.add(diseño6x1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, 130, -1));

        diseño4x1.setBackground(new java.awt.Color(85, 0, 43));
        diseño4x1.setRoundBottomLeft(10);
        diseño4x1.setRoundBottomRight(10);
        diseño4x1.setRoundTopLeft(10);
        diseño4x1.setRoundTopRight(10);
        contenedorLogin1.add(diseño4x1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 50, -1));

        diseño2x1.setBackground(new java.awt.Color(85, 0, 43));
        diseño2x1.setRoundBottomLeft(10);
        diseño2x1.setRoundBottomRight(10);
        diseño2x1.setRoundTopLeft(10);
        diseño2x1.setRoundTopRight(10);
        contenedorLogin1.add(diseño2x1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 700, -1, -1));

        contenedorPanini.add(contenedorLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 460, 730));

        contenedorPrecioMostrara.setBackground(new java.awt.Color(255, 255, 255));
        contenedorPrecioMostrara.setRoundBottomLeft(30);
        contenedorPrecioMostrara.setRoundBottomRight(30);
        contenedorPrecioMostrara.setRoundTopLeft(30);
        contenedorPrecioMostrara.setRoundTopRight(30);
        contenedorPrecioMostrara.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        precioQSeMostraraLabel.setBackground(new java.awt.Color(255, 255, 255));
        precioQSeMostraraLabel.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        precioQSeMostraraLabel.setForeground(new java.awt.Color(0, 0, 0));
        precioQSeMostraraLabel.setText(" $ 0.00");
        precioQSeMostraraLabel.setOpaque(true);
        contenedorPrecioMostrara.add(precioQSeMostraraLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 20));

        contenedorPanini.add(contenedorPrecioMostrara, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 230, 40));

        contenedorTotalMostrar.setBackground(new java.awt.Color(255, 255, 255));
        contenedorTotalMostrar.setRoundBottomLeft(30);
        contenedorTotalMostrar.setRoundBottomRight(30);
        contenedorTotalMostrar.setRoundTopLeft(30);
        contenedorTotalMostrar.setRoundTopRight(30);
        contenedorTotalMostrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalAPagarQSeMostraraLabel.setBackground(new java.awt.Color(255, 255, 255));
        totalAPagarQSeMostraraLabel.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        totalAPagarQSeMostraraLabel.setForeground(new java.awt.Color(0, 0, 0));
        totalAPagarQSeMostraraLabel.setText(" $ 0.00");
        totalAPagarQSeMostraraLabel.setOpaque(true);
        contenedorTotalMostrar.add(totalAPagarQSeMostraraLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 20));

        contenedorPanini.add(contenedorTotalMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 230, 40));

        contenedorSecciones.setBackground(new java.awt.Color(255, 255, 255));
        contenedorSecciones.setRoundBottomLeft(30);
        contenedorSecciones.setRoundBottomRight(30);
        contenedorSecciones.setRoundTopLeft(30);
        contenedorSecciones.setRoundTopRight(30);
        contenedorSecciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seccionesDesplegables.setBackground(new java.awt.Color(255, 255, 255));
        seccionesDesplegables.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        seccionesDesplegables.setForeground(new java.awt.Color(0, 0, 0));
        seccionesDesplegables.setBorder(null);
        seccionesDesplegables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seccionesDesplegablesActionPerformed(evt);
            }
        });
        contenedorSecciones.add(seccionesDesplegables, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 5, 210, 30));

        contenedorPanini.add(contenedorSecciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 260, 40));

        contenedorSpinner.setBackground(new java.awt.Color(255, 255, 255));
        contenedorSpinner.setRoundBottomLeft(30);
        contenedorSpinner.setRoundBottomRight(30);
        contenedorSpinner.setRoundTopLeft(30);
        contenedorSpinner.setRoundTopRight(30);
        contenedorSpinner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cantidadEnSpinner.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        cantidadEnSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        cantidadEnSpinner.setBorder(null);
        cantidadEnSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cantidadEnSpinnerStateChanged(evt);
            }
        });
        contenedorSpinner.add(cantidadEnSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 5, 210, 30));

        contenedorPanini.add(contenedorSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 260, 40));

        contenedorAgregarCompra.setBackground(new java.awt.Color(255, 153, 0));
        contenedorAgregarCompra.setRoundBottomLeft(60);
        contenedorAgregarCompra.setRoundBottomRight(60);
        contenedorAgregarCompra.setRoundTopLeft(60);
        contenedorAgregarCompra.setRoundTopRight(60);
        contenedorAgregarCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adregarMasBoton.setBackground(new java.awt.Color(255, 153, 0));
        adregarMasBoton.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        adregarMasBoton.setForeground(new java.awt.Color(0, 0, 0));
        adregarMasBoton.setText("Añadir Compra");
        adregarMasBoton.setBorder(null);
        adregarMasBoton.setMargin(new java.awt.Insets(14, 14, 2, 14));
        adregarMasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adregarMasBotonActionPerformed(evt);
            }
        });
        contenedorAgregarCompra.add(adregarMasBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 170, 30));
        adregarMasBoton.getAccessibleContext().setAccessibleParent(contenedorPanini);

        contenedorPanini.add(contenedorAgregarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 720, 210, 50));

        contenedorSalir.setBackground(new java.awt.Color(255, 153, 0));
        contenedorSalir.setRoundBottomLeft(60);
        contenedorSalir.setRoundBottomRight(60);
        contenedorSalir.setRoundTopLeft(60);
        contenedorSalir.setRoundTopRight(60);
        contenedorSalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        obtenerFactura.setBackground(new java.awt.Color(255, 153, 0));
        obtenerFactura.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        obtenerFactura.setForeground(new java.awt.Color(0, 0, 0));
        obtenerFactura.setText("Generar Factura");
        obtenerFactura.setBorder(null);
        obtenerFactura.setMargin(new java.awt.Insets(14, 14, 2, 14));
        obtenerFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenerFacturaActionPerformed(evt);
            }
        });
        contenedorSalir.add(obtenerFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 13, 190, 30));
        obtenerFactura.getAccessibleContext().setAccessibleParent(contenedorPanini);

        contenedorPanini.add(contenedorSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 720, 220, 50));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Cantidad");
        contenedorPanini.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        contenedorBotonSalirBienvenida8.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida8.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida8.setRoundBottomRight(30);
        contenedorBotonSalirBienvenida8.setRoundTopRight(30);
        contenedorBotonSalirBienvenida8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorPanini.add(contenedorBotonSalirBienvenida8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 20, 610));

        contenedorBotonSalirBienvenida9.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida9.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida9.setRoundBottomLeft(30);
        contenedorBotonSalirBienvenida9.setRoundTopLeft(30);
        contenedorBotonSalirBienvenida9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorPanini.add(contenedorBotonSalirBienvenida9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 100, 20, 610));

        panelTienda.add(contenedorPanini, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1160, 810));

        panelFactura.setBackground(new java.awt.Color(255, 255, 255));
        panelFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorDiseñoRedondeado1.setBackground(new java.awt.Color(85, 0, 43));
        contenedorDiseñoRedondeado1.setForeground(new java.awt.Color(255, 255, 255));
        contenedorDiseñoRedondeado1.setRoundBottomLeft(30);
        contenedorDiseñoRedondeado1.setRoundBottomRight(30);
        contenedorDiseñoRedondeado1.setRoundTopLeft(30);
        contenedorDiseñoRedondeado1.setRoundTopRight(30);
        contenedorDiseñoRedondeado1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorSalirSistemaFactura.setBackground(new java.awt.Color(255, 153, 0));
        contenedorSalirSistemaFactura.setRoundBottomLeft(60);
        contenedorSalirSistemaFactura.setRoundBottomRight(60);
        contenedorSalirSistemaFactura.setRoundTopLeft(60);
        contenedorSalirSistemaFactura.setRoundTopRight(60);
        contenedorSalirSistemaFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salirDelSistemFactura.setBackground(new java.awt.Color(255, 153, 0));
        salirDelSistemFactura.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        salirDelSistemFactura.setForeground(new java.awt.Color(0, 0, 0));
        salirDelSistemFactura.setText("Salir");
        salirDelSistemFactura.setBorder(null);
        salirDelSistemFactura.setMargin(new java.awt.Insets(14, 14, 2, 14));
        salirDelSistemFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirDelSistemFacturaActionPerformed(evt);
            }
        });
        contenedorSalirSistemaFactura.add(salirDelSistemFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 110, 30));

        contenedorDiseñoRedondeado1.add(contenedorSalirSistemaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 730, 150, 50));

        contenedorCedulaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        contenedorCedulaUsuario.setForeground(new java.awt.Color(0, 0, 0));
        contenedorCedulaUsuario.setRoundBottomLeft(30);
        contenedorCedulaUsuario.setRoundBottomRight(30);
        contenedorCedulaUsuario.setRoundTopLeft(30);
        contenedorCedulaUsuario.setRoundTopRight(30);
        contenedorCedulaUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorTablaDeCompras.setBackground(new java.awt.Color(255, 255, 255));
        contenedorTablaDeCompras.setRoundBottomLeft(30);
        contenedorTablaDeCompras.setRoundBottomRight(30);
        contenedorTablaDeCompras.setRoundTopLeft(30);
        contenedorTablaDeCompras.setRoundTopRight(30);
        contenedorTablaDeCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Scroll.setBackground(new java.awt.Color(0, 204, 204));

        tablaDeCompras.setBackground(new java.awt.Color(255, 255, 255));
        tablaDeCompras.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        tablaDeCompras.setForeground(new java.awt.Color(0, 0, 0));
        tablaDeCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaDeCompras.setGridColor(new java.awt.Color(153, 153, 153));
        tablaDeCompras.setOpaque(false);
        tablaDeCompras.setSelectionBackground(new java.awt.Color(102, 102, 102));
        Scroll.setViewportView(tablaDeCompras);

        contenedorTablaDeCompras.add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1000, 370));

        contenedorCedulaUsuario.add(contenedorTablaDeCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1040, 400));

        subTotalLabel.setFont(new java.awt.Font("Courier New", 1, 19)); // NOI18N
        subTotalLabel.setForeground(new java.awt.Color(0, 0, 0));
        subTotalLabel.setText("  SubTotal");
        contenedorCedulaUsuario.add(subTotalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 120, -1));

        subTotalQueSeMostrara.setFont(new java.awt.Font("Courier New", 0, 19)); // NOI18N
        subTotalQueSeMostrara.setForeground(new java.awt.Color(0, 0, 0));
        subTotalQueSeMostrara.setText("$ 0.00");
        contenedorCedulaUsuario.add(subTotalQueSeMostrara, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, -1, -1));

        nombreUsuario.setFont(new java.awt.Font("Courier New", 0, 19)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(0, 0, 0));
        nombreUsuario.setText("Usuario");
        contenedorCedulaUsuario.add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 320, 30));

        cedulaUsuario.setFont(new java.awt.Font("Courier New", 0, 19)); // NOI18N
        cedulaUsuario.setForeground(new java.awt.Color(0, 0, 0));
        cedulaUsuario.setText("0-0000-0000");
        contenedorCedulaUsuario.add(cedulaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 310, 20));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("FACTURAR A");
        contenedorCedulaUsuario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 19)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ES-001");
        contenedorCedulaUsuario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(955, 120, 70, -1));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 19)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("N° DE FACTURA");
        contenedorCedulaUsuario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 19)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("FECHA VENCIMIENTO");
        contenedorCedulaUsuario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 19)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("22/06/2023");
        contenedorCedulaUsuario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, 110, -1));

        tituloFactura.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        tituloFactura.setForeground(new java.awt.Color(0, 0, 0));
        tituloFactura.setText("Factura de Compra");
        contenedorCedulaUsuario.add(tituloFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 410, 40));

        direccionUsuario.setFont(new java.awt.Font("Courier New", 0, 19)); // NOI18N
        direccionUsuario.setForeground(new java.awt.Color(0, 0, 0));
        contenedorCedulaUsuario.add(direccionUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 490, 30));

        contenedorDiseñoRedondeado1.add(contenedorCedulaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 1040, 650));

        contenedorBotonSalirBienvenida10.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida10.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida10.setRoundBottomRight(30);
        contenedorBotonSalirBienvenida10.setRoundTopRight(30);
        contenedorBotonSalirBienvenida10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorDiseñoRedondeado1.add(contenedorBotonSalirBienvenida10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 20, 610));

        contenedorBotonSalirBienvenida11.setBackground(new java.awt.Color(255, 255, 255));
        contenedorBotonSalirBienvenida11.setForeground(new java.awt.Color(0, 0, 0));
        contenedorBotonSalirBienvenida11.setRoundBottomLeft(30);
        contenedorBotonSalirBienvenida11.setRoundTopLeft(30);
        contenedorBotonSalirBienvenida11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        contenedorDiseñoRedondeado1.add(contenedorBotonSalirBienvenida11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 100, 20, 610));

        panelFactura.add(contenedorDiseñoRedondeado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1160, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adregarMasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adregarMasBotonActionPerformed
        switch (indice) {
            /*Otra vez hacemos lo mismo, esto porque el usuario tendra solo una oportunidad para hacer su compra, ya que desde un principio puede comprar las 5 o las 20 postales
            //entonces le impedimos volver a comprar otra vex en la misma sección ya que sino pasa esto podra comprar mas de una vez en la misma sección y no hay un recuento de la
            cantidad de postales en la factura para garantizar que solamente compre de 1 a 5 o de 1 a 20*/
            case 1 -> { con1 = con1 + 1; } 
            case 2 -> { con2 = con2 + 1; }
            case 3 -> { con3 = con3 + 1; } 
            case 4 -> { con4 = con4 + 1; } 
            case 5 -> { con5 = con5 + 1; } default -> { }
        }
        if (indice == 1 && con1 > 2) { //Si el usuario llego a su limite de compra se mostrara estos mensajes de aviso para que proceda con la factura o compre postales de otra sección
            JOptionPane.showMessageDialog(null, "Solo tienes un intento en cada sección, agotaste tu intento en la sección [ Pagina Principal ]");
        } else  if (indice == 2 && con2 > 2) {
            JOptionPane.showMessageDialog(null, "Solo tienes un intento en cada sección, agotaste tu intento en la sección [ Estadiosl ]");
        } else  if (indice == 3 && con3 > 2) {
            JOptionPane.showMessageDialog(null, "Solo tienes un intento en cada sección, agotaste tu intento en la sección [ Extra Sticker ]");
        } else  if (indice == 4 && con4 > 2) {
            JOptionPane.showMessageDialog(null, "Solo tienes un intento en cada sección, agotaste tu intento en la sección [ Postales ]");
        } else if (indice == 5 && con5 > 2) {
            JOptionPane.showMessageDialog(null, "Solo tienes un intento en cada sección, agotaste tu intento en la sección [ Museos FIFA ]");
        } else {
             if (indice == 0 || contador == 0) { //Si el indice es 0, o el indice es 1  y la cantidad es 0 no podra hacer la compra
                JOptionPane.showMessageDialog(null, "Primero debes seleccionar una sección o ingresar una cantidad para poder realizar tu compra");
            } else { //Si todo resulta bien podra hacer la compra y esta se añadira a la factura
                agregarCompra();
            }
        }
    }//GEN-LAST:event_adregarMasBotonActionPerformed

    private void obtenerFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtenerFacturaActionPerformed
        panelTienda.setVisible(false); //Si el usuario presiona el boton de obtener factura, el JPanel tienda se ocultara y se mostrara el de factura
        panelFactura.setVisible(true);
        if (checkSi.isSelected()) { //Y si la opción de envio a domicilio esta habilitada se procedera a sumar 3000 mas a la factura
            calcularEnvio();
        }
    }//GEN-LAST:event_obtenerFacturaActionPerformed

    private void salirDelSistemFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirDelSistemFacturaActionPerformed
        JOptionPane.showMessageDialog(null, "Gracias por comprar en nuestra tienda, el precio de su compra es de $ " + subtotal); //Cuando el usuario le da al boton de salir del programa en la factura se desplegara un JOptionpane con el subtotal
        dispose(); //Y despues sale del programa
    }//GEN-LAST:event_salirDelSistemFacturaActionPerformed

    private void cantidadEnSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cantidadEnSpinnerStateChanged
        calcularPrecio();
    }//GEN-LAST:event_cantidadEnSpinnerStateChanged

    private void seccionesDesplegablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seccionesDesplegablesActionPerformed
        indice = seccionesDesplegables.getSelectedIndex(); //Capturamos las secciones del JComboBox en una variable entera con el getSelectedIndex
        limiteSpinner(); //Llamamos al metodo que pone los limites del JSpinner dependiendo de la sección 
        calcularPrecio();
        switch (indice) {
            case 0-> { cantidadEnSpinner.setVisible(false); } //Si en el JComboBox el usuario elige la primera sección osea el indice 0, el JSpinner se ocultara impidiendo la compra
            case 1 -> { con1 = con1 + 1; } //Cuando el usuario selecciona una sección una variable contadora aumentara
            case 2 -> { con2 = con2 + 1; }
            case 3 -> { con3 = con3 + 1; } 
            case 4 -> { con4 = con4 + 1; } 
            case 5 -> { con5 = con5 + 1; } default -> { }
        }
    }//GEN-LAST:event_seccionesDesplegablesActionPerformed

    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
        dispose(); //Boton para salir del registro y por ende del programa
    }//GEN-LAST:event_salirBotonActionPerformed

    private void registroBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroBotonActionPerformed
        registro(); //Llamamos al metodo de registro que nos permitira avanzar al panel tienda si se preciona este boton 
        cantidadEnSpinner.setVisible(false);
    }//GEN-LAST:event_registroBotonActionPerformed

    private void checkSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSiActionPerformed
        sinoCheck(); //Llamamos al metodo que muestra los campos de dirección
    }//GEN-LAST:event_checkSiActionPerformed

    private void cedulaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaTextFieldKeyTyped
        validarSoloNumeros = evt.getKeyChar(); //Aca igualamos nuestra variable char a nuestra funcion de getKeyChar que nos suministra las teclas que se pulsan
        if (Character.isLetter(validarSoloNumeros)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Por favor ingresar solamente numeros. Gracias");
        }
    }//GEN-LAST:event_cedulaTextFieldKeyTyped

    private void avanzarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanzarBotonActionPerformed
        contenedorBienvenida.setVisible(false); //Si el ususario a leido tados las normas y condiciones y presiona el boton avanzar se mostrara el JPanel registro y el de bienvenida se ocultara
        contenedorDiseñoRedondeado.setVisible(true);
    }//GEN-LAST:event_avanzarBotonActionPerformed

    private void salirBotonBienvenidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonBienvenidaActionPerformed
        dispose(); //El usuario puede salir del programa en la pagina de bienvenida
    }//GEN-LAST:event_salirBotonBienvenidaActionPerformed

    private void usuarioTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioTextFieldKeyTyped
       if ( usuarioTextField.getText().length() > 20) { //Aca validamos que el nombre de usuario no exceda los 20 caracteres de longitud
             JOptionPane.showMessageDialog(null, "Los nombres ingresados dentro de este campo solo pueden contener menos de 20 caracteres");
             usuarioTextField.setText (null); //Y si eso pasa borramos el contenido del TextField
       } 
    }//GEN-LAST:event_usuarioTextFieldKeyTyped

    private void direccionTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionTextFieldKeyTyped
        if (direccionTextField.getText().length() > 30) { ///Aca validamos que la dirección de envío no exceda los 30 caracteres de longitud
             JOptionPane.showMessageDialog(null, "La dirección ingresada dentro de este campo solo puede contener menos de 30 caracteres");
             direccionTextField.setText (null); //Y si eso pasa borramos el contenido del TextField
       } 
    }//GEN-LAST:event_direccionTextFieldKeyTyped

    public void calcularPrecio() {
        precio = precios[seccionesDesplegables.getSelectedIndex()];
        contador = Integer.parseInt(cantidadEnSpinner.getValue().toString());
        precioQSeMostraraLabel.setText(Moneda(precio));
        totalAPagarQSeMostraraLabel.setText(Moneda(precio * contador));
    }
    
    public void registro() {
        usuario = usuarioTextField.getText(); //Le asignamos a nuestra variable usuario el contenido del Textfield de usuario
        cedula = cedulaTextField.getText();   //Le asignamos a nuestra variable cedula el contenido del Textfield de cedula
        direccion = direccionTextField.getText(); //Le asignamos a nuestra variable dirección el contenido del Textfield de dirección
        nombreUsuario.setText(usuario);      //Aca le aignamos el contenido de esta variable al JLabel que muestra el nombre del usuario en la factura
        cedulaUsuario.setText(cedula);         //Aca le aignamos el contenido de esta variable al JLabel que muestra el numero de cedula  en la factura
        cantidadEnSpinner.setVisible(false); //Cuando arranca el programa ocultamos el JSpinner para que se muestre solo cuando se seleccione una sección
        
        if(usuario.isEmpty() || cedula.isEmpty()) { //Aca validamos que las variables que almacenan los datos del usuario no esten vacias para poder avanzar 
              JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos para poder avanzar");
        } 
        if (cedula.length() < 7 || cedula.length() > 12) { //Aca validamos que los numeros de cedula no sean menos a 7 y que tampoco sean mayor a 12 en cualquier parte del mundo
                JOptionPane.showMessageDialog(null, "Los numeros de identificación contienen 7 y 12 numeros incluyendo ( 0 )");
            } else {
                    if (checkSi.isSelected() && direccion.isEmpty()) { //Aca validamos que si el usuario selleciona la opciónde envio a domisilo no deje el JTextfield vacio para poder enviarle su paquete
                         JOptionPane.showMessageDialog(null, "Por favor ingrese una dirección para poder hacerle el envio a domisilio");
                    } else { //Si todo esta bien se procede a ocultar el panel de registro y mostrar el panel de tienda
                          panelTienda.setVisible(true);
                          direccionLabel.setVisible(false);
                          contenedorDireccionTextField.setVisible(false);
                          direccionTextField.setVisible(false);
                          panelRegistro.setVisible(false);
                    }
            }
    }
    
    public void sinoCheck() { //Metodo para mostrar los campos de dirección
        if (checkSi.isSelected()) { //Si el usuario selecciona este opción se mostraran los campos de la dirección
             direccionLabel.setVisible(true);
             direccionTextField.setVisible(true);
             contenedorDireccionTextField.setVisible(true);
        } else if (!checkSi.isSelected()) { //Sino se a seleccionado esta opción, estos compos no se ocultaran por si el usuario cmbia de opinión
             direccionLabel.setVisible(false);
             direccionTextField.setVisible(false);
             contenedorDireccionTextField.setVisible(false);
        }
    }
    
    public void limiteSpinner() { //Metodo para poner un limite al JSpinner usando un switch
        switch (indice) { 
            case 1 -> { cantidadEnSpinner.setVisible(true); cantidadEnSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1)); } //Aca empezara en 1 y llegara hasta 5 aumentando de 1 en 1 (todas las demas secciónes
            case 2 -> { cantidadEnSpinner.setVisible(true); cantidadEnSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1)); }
            case 3 -> { cantidadEnSpinner.setVisible(true); cantidadEnSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1)); } 
            case 4 -> { cantidadEnSpinner.setVisible(true); cantidadEnSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1)); } //Aca empezara en 1 y llegara hasta 20 aumentando de 1 en 1 (sección de postales)
            case 5 -> { cantidadEnSpinner.setVisible(true); cantidadEnSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0 ,5, 1)); } default -> { }
        }
    }
    
    public void agregarCompra() { //Metdo para agregar las compras a la factura
        //Aca inicializamos todas estas variables para poder elejir las postales de manera aleatoria
        a1 = (int) (Math.random() * 19 + 1); a2 = (int) (Math.random() * 19 + 1); a3 = (int) (Math.random() * 19 + 1); a4 = (int) (Math.random() * 19 + 1); a5 = (int) (Math.random() * 19 + 1);
        a6 = (int) (Math.random() * 19 + 1); a7 = (int) (Math.random() * 19+ 1); a8 = (int) (Math.random() * 19 + 1); a9 = (int) (Math.random() * 19 + 1); a10 = (int) (Math.random() * 19 + 1);
        a11 = (int) (Math.random() * 19 + 1); a12 = (int) (Math.random() * 19+ 1); a13 = (int) (Math.random() * 19 + 1); a14 = (int) (Math.random() * 19 + 1); a15 = (int) (Math.random() * 19 + 1);
        a16 = (int) (Math.random() * 19 + 1); a17 = (int) (Math.random() * 19+ 1); a18 = (int) (Math.random() * 19 + 1); a19 = (int) (Math.random() * 19 + 1); a20 = (int) (Math.random() * 19 + 1);
        b1 = (int) (Math.random() * 6 + 1); b2 = (int) (Math.random() * 6 + 1); b3 = (int) (Math.random() * 6 + 1); b4 = (int) (Math.random() * 6 + 1); b5 = (int) (Math.random() * 6 + 1);
        c1 = (int) (Math.random() * 10 + 1); c2 = (int) (Math.random() * 10 + 1); c3 = (int) (Math.random() * 10 + 1); c4 = (int) (Math.random() * 10 + 1); c5 = (int) (Math.random() * 10 + 1);
        d1 = (int) (Math.random() * 9 + 1); d2 = (int) (Math.random() * 9 + 1); d3 = (int) (Math.random() * 9 + 1); d4 = (int) (Math.random() * 9 + 1); d5 = (int) (Math.random() * 9 + 1);
        
        Postal venta = new Postal(); //Instanciamos la clase postal para a los seters asignarles un valor
        venta.setDescripcion(seccionesDesplegables.getSelectedItem().toString());
        venta.setPrecio(precio);
        venta.setContador(contador);
        venta.setCostoSolcitado(precio * contador);
        
        switch (indice) { //Aca dependiendo la sección que selecione el usuario se elegiran aleatoriamente 5 postales
            case 1 -> { pos1 = postalesPaginaPrincipal[b1]; pos2 = postalesPaginaPrincipal[b2];  pos3 = postalesPaginaPrincipal[b3];  pos4 = postalesPaginaPrincipal[b4]; pos5 = postalesPaginaPrincipal[b5];
                switch (contador) { //Dependiendo de la cantidad de postales que el ususario elija, esas se mostraran en la factura
                    case 1 -> venta.setPostales(pos1);
                    case 2 -> venta.setPostales(pos1 + " " + pos2);
                    case 3 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3);
                    case 4 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4); //Por ejemplo si elije 4, se mostraran 4 y asi con las demas secciones y se iran concatenando para que aparescan a la par con un espacio que las separa
                    case 5 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5);
                    default -> { }
                }
            }
            case 2 -> { pos1 = postalesEstadios[c1];  pos2 = postalesEstadios[c2]; pos3 = postalesEstadios[c3]; pos4 = postalesEstadios[c4]; pos5 = postalesEstadios[c5];
                switch (contador) {
                    case 1 -> venta.setPostales(pos1);
                    case 2 -> venta.setPostales(pos1 + " " + pos2);
                    case 3 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3);
                    case 4 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4);
                    case 5 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5);
                    default -> { }
                }
            }
            case 3 -> { pos1 = extraStickers[d1]; pos2 = extraStickers[d2]; pos3 = extraStickers[d3];  pos4 = extraStickers[d4]; pos5 = extraStickers[d5];
                switch (contador) {
                    case 1 -> venta.setPostales(pos1);
                    case 2 -> venta.setPostales(pos1 + " " + pos2);
                    case 3 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3);
                    case 4 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4);
                    case 5 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5);
                    default -> { }
                }
            }
            case 4 -> { pos1 = postales[a1]; pos2 = postales[a2]; pos3 = postales[a3]; pos4 = postales[a4];  pos5 = postales[a5]; pos6 = postales[a6];  pos7 = postales[a7]; pos8 = postales[a8];  pos9 = postales[a9]; pos10 = postales[a10];
                pos11 = postales[a11];   pos12 = postales[a12]; pos13 = postales[a13];   pos14 = postales[a14]; pos15 = postales[a15];  pos16 = postales[a16]; pos17 = postales[a17]; pos18 = postales[a18]; pos19 = postales[a19]; pos20 = postales[a20];
                switch (contador) {
                    case 1 ->   venta.setPostales(pos1);
                    case 2 ->   venta.setPostales(pos1 + " " + pos2);
                    case 3 ->   venta.setPostales(pos1 + " " + pos2 + " " + pos3);
                    case 4 ->   venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4);
                    case 5 ->   venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5);
                    case 6 ->   venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6);
                    case 7 ->   venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7);
                    case 8 ->   venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8);
                    case 9 ->   venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9);
                    case 10 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10);
                    case 11 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10 + " " + pos11);
                    case 12 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10 + " " + pos11 + " " + pos12);
                    case 13 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10 + " " + pos11 + " " + pos12 + " " + pos13);
                    case 14 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10 + " " + pos11 + " " + pos12 + " " + pos13 + " " + pos14);
                    case 15 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10 + " " + pos11 + " " + pos12 + " " + pos13 + " " + pos14 + " " + pos15);
                    case 16 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10 + " " + pos11 + " " + pos12 + " " + pos13 + " " + pos14 + " " + pos15 + " " + pos16);
                    case 17 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10 + " " + pos11 + " " + pos12 + " " + pos13 + " " + pos14 + " " + pos15 + " " + pos16 + " " + pos17);
                    case 18 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10 + " " + pos11 + " " + pos12 + " " + pos13 + " " + pos14 + " " + pos15 + " " + pos16 + " " + pos17 + " " + pos18);
                    case 19 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10 + " " + pos11 + " " + pos12 + " " + pos13 + " " + pos14 + " " + pos15 + " " + pos16 + " " + pos17 + " " + pos18 + " " + pos19);
                    case 20 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5 + " " + pos6 + " " + pos7 + " " + pos8 + " " + pos9 + " " + pos10 + " " + pos11 + " " + pos12 + " " + pos13 + " " + pos14 + " " + pos15 + " " + pos16 + " " + pos17 + " " + pos18 + " " + pos19 + " " + pos20);
                    default -> { }
                }
            }
            case 5 -> {  pos1 = postalesMuseosFifa[b1]; pos2 = postalesMuseosFifa[b2]; pos3 = postalesMuseosFifa[b3]; pos4 = postalesMuseosFifa[b4];  pos5 = postalesMuseosFifa[b5];
                switch (contador) {
                    case 1 -> venta.setPostales(pos1);
                    case 2 -> venta.setPostales(pos1 + " " + pos2);
                    case 3 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3);
                    case 4 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4);
                    case 5 -> venta.setPostales(pos1 + " " + pos2 + " " + pos3 + " " + pos4 + " " + pos5);
                    default -> { }
                }
            } default -> { }
        }
        listaVentas.add(venta); //Aca agregamos a nuestra lista todas nuestras opciones, descipcion, cantidad, postales, precio y total
        mostrarEnTabla();        //Aca llamamos al metodo que imprime la lista en la tabla
        borrarVenta();              //Despues de precionar el boton de agregar compra la cantidad sera 0 y el total a pagar sera de 0 en el label de total en el JPanel de tienda
    }
     
    public void calcularEnvio() { //Metodo para calcular el envio esto para mostrarlo en un JOptionpane al final de la factura
        subtotal += servicioDomicilio;
    }
     
     public void mostrarEnTabla() {
         while (modelo.getRowCount() > 0) { //Aca decimos que si las filas en la tabla se reíten sea que si hay mas de 1 fila repedita
             modelo.removeRow(0); //Con este comando las borramos y evitamos que se dupliquen las filas
         }
         int subtotalis = 0; //Variable que almacena el subtotal de las compras y que con cada compra este monto ira cambiando
         for (Postal i : listaVentas) { //For para hacer el llenado de la tabla instanciando la clase Postal
            Object x[] = new Object[5]; //Creamos un array de 5 poisiciones el cual sera un objeto
            x[0] = i.getDescripcion(); //Y aca mostramos el contenido de los geters para asignarlos al array ya que anteriormente le añadimos el contenido usando los seters
            x[1] = Moneda(i.getPrecio());
            x[2] = i.getContador();
            x[3] = i.getPostales();
            x[4] = Moneda(i.getCostoSolcitado());
            subtotalis += i.getCostoSolcitado(); //Aca llevamos el recuento del subtotal cada vez que se añada una compra este se ira acomulando
            modelo.addRow(x); //Aca añadimos el array al modelo de la JTable
        }
         if (checkSi.isSelected()) { //Aca mostramos en la factura el subtotal mas el servicio a domicilio si el usuario elijio el envio a domisilio
             subTotalQueSeMostrara.setText(Moneda(subtotalis + servicioDomicilio));
         } else { //Sino solo se muestra el subtotal
            subTotalQueSeMostrara.setText(Moneda(subtotalis));
         }
        subtotal = subtotalis; //Aca igualamos nuestra variable global con la local para poder usarla en otras partes
        tablaDeCompras.setModel(modelo); //Aca imprimimos el modelo en la JTable
    }
    
     public void borrarVenta() { //Metodo que borra la venta, asi si la cantidad es 0 y el usuario le da añadir una nueva comprar no va a poder por la condicion de agregar compra
        contador = 0;
        totalAPagarQSeMostraraLabel.setText(Moneda(precio)); 
    }
    
    public String Moneda(int precio) { //Metodo para mostrar el signo de dolar en los precios, totales y el subtotal
        return " $ " + Math.round(precio * 100) / 100;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JButton adregarMasBoton;
    private javax.swing.JButton avanzarBoton;
    private javax.swing.JLabel bienvenidaLabel;
    private javax.swing.JSpinner cantidadEnSpinner;
    private javax.swing.JLabel cedulaLabel;
    private javax.swing.JTextField cedulaTextField;
    private javax.swing.JLabel cedulaUsuario;
    private javax.swing.JCheckBox checkSi;
    private tarea1_mundialdqatar.BordesRedondeados contenedorAgregarCompra;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBienvenida;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonAvanzar;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonRegistro;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalir;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida1;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida10;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida11;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida2;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida3;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida4;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida5;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida6;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida7;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida8;
    private tarea1_mundialdqatar.BordesRedondeados contenedorBotonSalirBienvenida9;
    private tarea1_mundialdqatar.BordesRedondeados contenedorCedulaField;
    private tarea1_mundialdqatar.BordesRedondeados contenedorCedulaUsuario;
    private tarea1_mundialdqatar.BordesRedondeados contenedorDireccionTextField;
    private tarea1_mundialdqatar.BordesRedondeados contenedorDiseñoRedondeado;
    private tarea1_mundialdqatar.BordesRedondeados contenedorDiseñoRedondeado1;
    private tarea1_mundialdqatar.BordesRedondeados contenedorLogin;
    private tarea1_mundialdqatar.BordesRedondeados contenedorLogin1;
    private tarea1_mundialdqatar.BordesRedondeados contenedorPanini;
    private tarea1_mundialdqatar.BordesRedondeados contenedorPrecioMostrara;
    private tarea1_mundialdqatar.BordesRedondeados contenedorSalir;
    private tarea1_mundialdqatar.BordesRedondeados contenedorSalirSistemaFactura;
    private tarea1_mundialdqatar.BordesRedondeados contenedorSecciones;
    private tarea1_mundialdqatar.BordesRedondeados contenedorSpinner;
    private tarea1_mundialdqatar.BordesRedondeados contenedorTablaDeCompras;
    private tarea1_mundialdqatar.BordesRedondeados contenedorTotalMostrar;
    private tarea1_mundialdqatar.BordesRedondeados contenedorUsuarioField;
    private javax.swing.JLabel costoLabelDeEnvio;
    private javax.swing.JLabel direccionLabel;
    private javax.swing.JTextField direccionTextField;
    private javax.swing.JLabel direccionUsuario;
    private tarea1_mundialdqatar.BordesRedondeados diseño2x;
    private tarea1_mundialdqatar.BordesRedondeados diseño2x1;
    private tarea1_mundialdqatar.BordesRedondeados diseño4x;
    private tarea1_mundialdqatar.BordesRedondeados diseño4x1;
    private tarea1_mundialdqatar.BordesRedondeados diseño6x;
    private tarea1_mundialdqatar.BordesRedondeados diseño6x1;
    private tarea1_mundialdqatar.BordesRedondeados diseño8x;
    private tarea1_mundialdqatar.BordesRedondeados diseño8x1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelSi;
    private javax.swing.JLabel logoQatar;
    private javax.swing.JLabel logoQatar1;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JButton obtenerFactura;
    private javax.swing.JPanel panelFactura;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JPanel panelTienda;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JLabel precioQSeMostraraLabel;
    private javax.swing.JLabel preguntaDomicilioLabel;
    private javax.swing.JLabel productoLabel;
    private javax.swing.JButton registroBoton;
    private javax.swing.JButton salirBoton;
    private javax.swing.JButton salirBotonBienvenida;
    private javax.swing.JButton salirDelSistemFactura;
    private javax.swing.JComboBox<String> seccionesDesplegables;
    private javax.swing.JLabel subTotalLabel;
    private javax.swing.JLabel subTotalQueSeMostrara;
    private javax.swing.JTable tablaDeCompras;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel text4;
    private javax.swing.JLabel text5;
    private javax.swing.JLabel text6;
    private javax.swing.JLabel titulo2022;
    private javax.swing.JLabel tituloFactura;
    private javax.swing.JLabel tituloFifa1;
    private javax.swing.JLabel tituloFifa3;
    private javax.swing.JLabel tituloLabel1;
    private javax.swing.JLabel totalAPagarLabel;
    private javax.swing.JLabel totalAPagarQSeMostraraLabel;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JTextField usuarioTextField;
    // End of variables declaration//GEN-END:variables
}

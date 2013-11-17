/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaCompleta.java
 *
 * Created on 04-nov-2013, 17:47:56
 */
package grundwaldtvarela.interfaz;

import grundwaldtvarela.dominio.Actividad;
import grundwaldtvarela.dominio.Comentario;
import grundwaldtvarela.dominio.Sistema;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Palmera
 */
public class VentanaCompleta extends javax.swing.JFrame {

    Sistema data;
    ArrayList<Actividad> categoriaSeleccionada;
    boolean cambiarEstado;
    private ArrayList<Actividad> resultados;
    private Actividad actividadSeleccionada;
    private JButton playaBoton;
    private JButton baresBoton;
    private JButton restaurantesBoton;
    private JButton favoritosBoton;
    private JButton heladeriaBoton;
    private JButton cercaMioBoton;
    private int botonOprimido;
    private ButtonGroup ranking;

    /**
     * Creates new form VentanaCompleta
     */
    public VentanaCompleta() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        cambiarEstado = true;
        
        this.setResizable(false);
        this.setTitle("Descubra Uruguay");
        ranking = new ButtonGroup();
        ranking.add(this.radioButton1);
        ranking.add(this.radioButton2);
        ranking.add(this.radioButton3);
        ranking.add(this.radioButton4);
        ranking.add(this.radioButton5);

        playaBoton = null;
        baresBoton = null;
        restaurantesBoton = null;
        favoritosBoton = null;
        heladeriaBoton = null;
        cercaMioBoton = null;

        //favoritosLabel.setText("");
        // this.setSize(1500, 730);
        //this.setResizable(false);
        data = new Sistema();
        data.cargarData(data.getActividades());
        data.ordenarListaActividades();
        //categoriasScrollPane.setBounds(0, 0, 100, this.getHeight());
        //categoriasScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        cargarVentana(data.getPlayas());
        crearBotonera();
        listaActividades.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                //listaActividades.setSelectedIndex(0);
                mostrarActividadSeleccionada();

            }

            public void mostrarActividadSeleccionada() {
                int seleccionado = listaActividades.getSelectedIndex();
                if (seleccionado < 0) {
                    seleccionado = 0;
                }

                cargarInfo(seleccionado);
                // actividadSeleccionada = categoriaSeleccionada.get(seleccionado);
                actualizarComentarios();

                // throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        listaActividades.setSelectedIndex(0);
        actividadSeleccionada = categoriaSeleccionada.get(0);
        
        
    }

    final public void cargarInfo(int seleccionado) {

        if (categoriaSeleccionada.isEmpty()) {
            tipoLabel.setText("No hay favoritos actualmete.");
            favoritoCheckBox.setEnabled(false);
            nombreLabel.setText("");
            imagenLabel.setEnabled(false);
            mapaLabel.setEnabled(false);
            descripcionTextArea.setText("");
            
            comentarioTextArea.setEnabled(false);
            usuarioTextField.setEnabled(false);
            comentariosLabel.setText("");
            String[] s = {""};
            comentariosList.setListData(s);
            guardarButton.setEnabled(false);
        } else {
            //TODO linea agregada recientemente. Observar comportamiento.
            comentarioTextArea.setEnabled(true);
            usuarioTextField.setEnabled(true);
            comentariosLabel.setText("Comentarios:");
            //String[] s = {""};
            //comentariosList.setListData(s);
            guardarButton.setEnabled(true);
            
            actividadSeleccionada = categoriaSeleccionada.get(seleccionado);
            favoritoCheckBox.setEnabled(true);
            imagenLabel.setEnabled(true);
            mapaLabel.setEnabled(true);
            //buscadorTextField.setEnabled(true);
            Image mapa = categoriaSeleccionada.get(seleccionado).getMapa();
            Image imagen = categoriaSeleccionada.get(seleccionado).getImg();
            Image resizedMapa = mapa.getScaledInstance(mapaLabel.getWidth(), mapaLabel.getHeight(), 0);
            Image resizedImage = imagen.getScaledInstance(imagenLabel.getWidth(), 300, 0);
            imagenLabel.setIcon(new ImageIcon(resizedImage));
            mapaLabel.setIcon(new ImageIcon(resizedMapa));
            nombreLabel.setText(categoriaSeleccionada.get(seleccionado).getNombre());
            String descripcion = categoriaSeleccionada.get(seleccionado).getDescripcion();
            descripcionTextArea.setText(descripcion);
            cambiarEstado = false;
            favoritoCheckBox.setSelected(categoriaSeleccionada.get(seleccionado).isFavorito());
            cambiarEstado = true;
            String textTipoLabel = categoriaSeleccionada.get(seleccionado).getTipo();
            tipoLabel.setText(textTipoLabel);
        }
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Actividad> filtrarActividades(Sistema data, String tipoActividad) {
        ArrayList<Actividad> actividades = new ArrayList<>();
        switch (tipoActividad) {
            case "Playas":
                actividades = data.getPlayas();
                break;
            case "Bares":
                actividades = data.getBares();
                break;
            case "Heladerias":
                actividades = data.getHeladerias();
                break;
            case "Favoritos":
                actividades = data.getFavoritos();
                break;
            case "Restaurantes":
                actividades = data.getRestaurantes();
                break;
            case "Buscador":
                actividades = data.getActividades();
                break;
            case "CM":
                actividades = data.getCercaMio();
                break;
        }
        return actividades;
    }

    public Image getImageIcon(String rutaImagen, JButton boton) {
        ImageIcon iconoBoton = new javax.swing.ImageIcon(getClass().getResource(rutaImagen));
        Image imagen = iconoBoton.getImage();
        Image resizedImage = imagen.getScaledInstance(boton.getWidth(), boton.getHeight(), 0);
        return resizedImage;
    }

    public JButton crearBoton(String rutaImagen, int x, int y, int lado, String tipo) {
        JButton boton = new JButton();
        boton.setBounds(x, y, lado, lado);
        Image resizedImage = getImageIcon(rutaImagen, boton);
        boton.setIcon(new ImageIcon(resizedImage));
        boton.setVisible(true);
        boton.setToolTipText(tipo);
        final String tipoActividad = tipo;
        boton.addActionListener(new ActionListener() {
            //cuando hacen click en el boton, filtra las actividades correspondientes

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Actividad> actividades = filtrarActividades(data, tipoActividad);
                categoriaSeleccionada = actividades;
                cargarVentana(actividades);
                listaActividades.setSelectedIndex(0);
                cargarInfo(0);
                oprimirBoton();
                switch (tipoActividad) {
                    case "Playas":
                        botonOprimido = 1;
                        playaBoton.setBackground(Color.BLUE);
                        break;
                    case "Bares":
                        botonOprimido = 2;
                        baresBoton.setBackground(Color.BLUE);
                        break;
                    case "Heladerias":
                        botonOprimido = 5;
                        heladeriaBoton.setBackground(Color.BLUE);
                        break;
                    case "Favoritos":
                        botonOprimido = 4;
                        favoritosBoton.setBackground(Color.BLUE);
                        break;
                    case "Restaurantes":
                        botonOprimido = 3;
                        restaurantesBoton.setBackground(Color.BLUE);
                        break;
                    case "Buscador":
                        botonOprimido = 7;
                        break;
                    case "CM":
                        botonOprimido = 6;
                        cercaMioBoton.setBackground(Color.BLUE);
                        break;
                }

                //abrirVentanaCorrespondiente(actividades, tipoActividad);
            }

            public void oprimirBoton() {
                if (playaBoton != null) {
                    playaBoton.setBackground(Color.WHITE);
                }

                if (baresBoton != null) {
                    baresBoton.setBackground(Color.WHITE);
                }
                if (restaurantesBoton != null) {
                    restaurantesBoton.setBackground(Color.WHITE);
                }
                if (favoritosBoton != null) {
                    favoritosBoton.setBackground(Color.WHITE);
                }
                if (heladeriaBoton != null) {
                    heladeriaBoton.setBackground(Color.WHITE);
                }
                if (cercaMioBoton != null) {
                    cercaMioBoton.setBackground(Color.WHITE);
                }
            }
        });
        return boton;
    }

    public String[] getNombresActividades(ArrayList<Actividad> actividades) {
        //imagenLabel.setBounds(0, 30, this.getWidth(), 300);
        String[] nombres = new String[actividades.size()];
        for (int i = 0; i < actividades.size(); i++) {
            String nombre = actividades.get(i).getNombre();
            nombres[i] = nombre;
        }
        return nombres;
    }

    public void cargarVentana(final ArrayList<Actividad> actividades) {
        String[] nombres = getNombresActividades(actividades);
        listaActividades.setListData(nombres);        
        //micargarActividadDefault(actividades);



    }

    public void crearBotonera() {
        int x = this.getHeight()/6-8;
        //JButton todos [] = new JButton[7];

        String rutaPlaya = "/grundwaldtvarela/imagenes/playa_icono.png";
        playaBoton = crearBoton(rutaPlaya, 0, 0 * x, x, "Playas");
        playaBoton.doClick();
        this.add(playaBoton);
        playaBoton.setName("playaBoton");

        //todos[0] = playaBoton;

        //categoriasList.add(playaBoton);



        String rutaBares = "/grundwaldtvarela/imagenes/bares_icono.png";
        baresBoton = crearBoton(rutaBares, 0, 1 * x, x, "Bares");
        baresBoton.setEnabled(false);
        this.add(baresBoton);
        playaBoton.setName("baresBoton");
        //categoriasList.add(baresBoton);

        //todos[1] = baresBoton;

        String rutaRestaurantes = "/grundwaldtvarela/imagenes/restaurantes_icono.png";
        restaurantesBoton = crearBoton(rutaRestaurantes, 0, 2 * x, x, "Restaurantes");
        this.add(restaurantesBoton);
        playaBoton.setName("restaurantesBoton");
        //categoriasList.add(restaurantesBoton);
        // todos[2] = restaurantesBoton;


        String rutaFavoritos = "/grundwaldtvarela/imagenes/favoritos_icono.png";
        favoritosBoton = crearBoton(rutaFavoritos, 0, 3 * x, x, "Favoritos");
        this.add(favoritosBoton);
        playaBoton.setName("favoritosBoton");
        //categoriasList.add(favoritosBoton);
        //   todos[3] = favoritosBoton;

        String rutaHeladeria = "/grundwaldtvarela/imagenes/heladeria_icono.png";
        heladeriaBoton = crearBoton(rutaHeladeria, 0, 4 * x, x, "Heladerias");
        heladeriaBoton.setEnabled(false);
        this.add(heladeriaBoton);
        playaBoton.setName("heladeriaBoton");
        //categoriasList.add(heladeriaBoton);

        //     todos[4] = heladeriaBoton;

        String rutaCercaMio = "/grundwaldtvarela/imagenes/pin.png";
        cercaMioBoton = crearBoton(rutaCercaMio, 0, 5 * x, x, "CM");
        //cercaMioBoton.setEnabled(false);
        this.add(cercaMioBoton);
        playaBoton.setName("cercaMioBoton");
        //categoriasList.add(cercaMioBoton);
        //    todos[5] = cercaMioBoton;

//        String rutaBuscador = "/grundwaldtvarela/imagenes/lupa.png";
//        JButton buscadorBoton = crearBoton(rutaBuscador, 0, 6*x,x, "Buscador");
//        this.add(buscadorBoton);
//        //categoriasList.add(buscadorBoton);
//  //      todos[6] = buscadorBoton;





        //pruebaScrollPane.add(prueba,0);
        //pruebaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //this.add(prueba);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaActividades = new javax.swing.JList();
        tipoLabel = new javax.swing.JLabel();
        buscadorTextField = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        favoritoCheckBox = new javax.swing.JCheckBox();
        mapaLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcionTextArea = new javax.swing.JTextArea();
        usuarioTextField = new javax.swing.JTextField();
        guardarButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        comentariosList = new javax.swing.JList();
        comentariosLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        comentarioTextArea = new javax.swing.JTextArea();
        radioButton1 = new javax.swing.JRadioButton();
        radioButton2 = new javax.swing.JRadioButton();
        radioButton3 = new javax.swing.JRadioButton();
        radioButton4 = new javax.swing.JRadioButton();
        radioButton5 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuNoreste = new javax.swing.JMenu();
        riveraMenuItem = new javax.swing.JMenuItem();
        tacuaremboMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaActividades.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaActividades);

        tipoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tipoLabel.setText("jLabel1");

        buscadorTextField.setText("Buscar");
        buscadorTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscadorTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscadorTextFieldFocusLost(evt);
            }
        });
        buscadorTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorTextFieldKeyTyped(evt);
            }
        });

        nombreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombreLabel.setText("jLabel1");

        favoritoCheckBox.setText("Favorito");
        favoritoCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        favoritoCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                favoritoCheckBoxItemStateChanged(evt);
            }
        });

        descripcionTextArea.setColumns(20);
        descripcionTextArea.setEditable(false);
        descripcionTextArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(5);
        jScrollPane3.setViewportView(descripcionTextArea);

        usuarioTextField.setText("Usuario");
        usuarioTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usuarioTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usuarioTextFieldFocusLost(evt);
            }
        });

        guardarButton.setText("Guardar");
        guardarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarButtonMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(comentariosList);

        comentariosLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comentariosLabel.setText("Comentarios:");

        comentarioTextArea.setColumns(20);
        comentarioTextArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        comentarioTextArea.setRows(5);
        comentarioTextArea.setText("Escriba aquí un comentario sobre la atracción");
        comentarioTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comentarioTextAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                comentarioTextAreaFocusLost(evt);
            }
        });
        jScrollPane4.setViewportView(comentarioTextArea);

        radioButton1.setText("1");

        radioButton2.setText("2");

        radioButton3.setText("3");

        radioButton4.setText("4");

        radioButton5.setText("5");

        menu.setText("Departamentos");

        menuNoreste.setText("Noreste");

        riveraMenuItem.setText("Rivera");
        riveraMenuItem.setEnabled(false);
        menuNoreste.add(riveraMenuItem);

        tacuaremboMenuItem.setText("Tacuarembó");
        tacuaremboMenuItem.setEnabled(false);
        menuNoreste.add(tacuaremboMenuItem);

        jMenuItem1.setText("Durazno");
        jMenuItem1.setEnabled(false);
        menuNoreste.add(jMenuItem1);

        jMenuItem2.setText("Treinta Y Tres");
        jMenuItem2.setEnabled(false);
        menuNoreste.add(jMenuItem2);

        jMenuItem3.setText("Cerro Largo");
        jMenuItem3.setEnabled(false);
        menuNoreste.add(jMenuItem3);

        menu.add(menuNoreste);

        jMenu2.setText("Noroeste");

        jMenuItem4.setText("Artigas");
        jMenuItem4.setEnabled(false);
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Salto");
        jMenuItem5.setEnabled(false);
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Paysandù");
        jMenuItem6.setEnabled(false);
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Rio Negro");
        jMenuItem7.setEnabled(false);
        jMenu2.add(jMenuItem7);

        menu.add(jMenu2);

        jMenu3.setText("Suroeste");

        jMenuItem8.setText("Soriano");
        jMenuItem8.setEnabled(false);
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Flores");
        jMenuItem9.setEnabled(false);
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Florida");
        jMenuItem10.setEnabled(false);
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("San José");
        jMenuItem11.setEnabled(false);
        jMenu3.add(jMenuItem11);

        jMenuItem12.setText("Colonia");
        jMenuItem12.setEnabled(false);
        jMenu3.add(jMenuItem12);

        menu.add(jMenu3);

        jMenu4.setText("Sureste");

        jMenuItem13.setText("Montevideo");
        jMenuItem13.setEnabled(false);
        jMenu4.add(jMenuItem13);

        jMenuItem14.setText("Canelones");
        jMenuItem14.setEnabled(false);
        jMenu4.add(jMenuItem14);

        jMenuItem15.setText("Lavalleja");
        jMenuItem15.setEnabled(false);
        jMenu4.add(jMenuItem15);

        jMenuItem16.setText("Rocha");
        jMenuItem16.setEnabled(false);
        jMenu4.add(jMenuItem16);

        jMenu1.setText("Maldonado");

        jMenuItem17.setText("Punta Del Este");
        jMenu1.add(jMenuItem17);

        jMenuItem18.setText("Piriapolis");
        jMenuItem18.setEnabled(false);
        jMenu1.add(jMenuItem18);

        jMenuItem19.setText("Punta Ballena");
        jMenuItem19.setEnabled(false);
        jMenu1.add(jMenuItem19);

        jMenu4.add(jMenu1);

        menu.add(jMenu4);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscadorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(imagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                                .addComponent(favoritoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mapaLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(usuarioTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comentariosLabel)
                        .addGap(0, 166, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(radioButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButton2)
                            .addComponent(radioButton3)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioButton5)
                                    .addComponent(radioButton4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(guardarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscadorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comentariosLabel))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipoLabel)
                            .addComponent(usuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(favoritoCheckBox)
                            .addComponent(nombreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imagenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                    .addComponent(mapaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioButton1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                        .addComponent(guardarButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(radioButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioButton5)
                                .addGap(63, 63, 63)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(radioButton2)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscadorTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorTextFieldFocusGained
        buscadorTextField.setText("");
    }//GEN-LAST:event_buscadorTextFieldFocusGained

    private void buscadorTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorTextFieldFocusLost
        buscadorTextField.setText("Buscador");
    }//GEN-LAST:event_buscadorTextFieldFocusLost

    private void favoritoCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_favoritoCheckBoxItemStateChanged
        int seleccionado = listaActividades.getSelectedIndex();
        if (seleccionado < 0) {
            seleccionado = 0;
        }
        Actividad seleccionada = categoriaSeleccionada.get(seleccionado);
        if (cambiarEstado && !favoritoCheckBox.isSelected()) {
            String texto = "¿Desea eliminar a " + categoriaSeleccionada.get(seleccionado).getNombre() + " de sus favoritos?";
            int resultado = JOptionPane.showConfirmDialog(this, texto);
            if (resultado == JOptionPane.OK_OPTION) {
                seleccionada.setFavorito(false);
                cambiarEstado = false;
                favoritoCheckBox.setSelected(false);
                //TODO una vez que se hayan pasado a los botones como atributos de clase, fijarse si el boton Favorito es el que esta seleccionado y entonces darle el refresh() de abajo
                if (this.botonOprimido == 4) {
                    actualizarFavoritos();
                }


//                if (favoritosLabel.getText().equals("Favoritos") && actividadSeleccionada.isEmpty()) {
//                    tipoLabel.setText("No hay favoritos actualmete.");
//                    favoritoCheckBox.setEnabled(false);
//                    nombreLabel.setText("");
//                    imagenLabel.setEnabled(false);
//                    mapaLabel.setEnabled(false);
//                    descripcionTextArea.setText("");
//                    buscadorTextField.setEnabled(false);
//                }
            }
        } else {
            seleccionada.setFavorito(favoritoCheckBox.isSelected());
        }
        cambiarEstado = true;
    }//GEN-LAST:event_favoritoCheckBoxItemStateChanged

    private void buscadorTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorTextFieldKeyTyped
        String buscar = buscadorTextField.getText().toLowerCase();

        resultados = new ArrayList<>();
        boolean enter = false;
        if (evt.getKeyChar() != '\b') {
            buscar = buscadorTextField.getText() + evt.getKeyChar();
        }
        if (evt.getKeyChar() == '\n') {
            buscar = buscadorTextField.getText();
            enter = true;
        }

        if (enter == false) {
            cargarResultadosPorNombre(buscar);
        } else {
            cargarResultadosPorNombreYDescripcion(buscar);
        }
        String[] nombres = getNombresActividades(resultados);
        categoriaSeleccionada = resultados;
        listaActividades.setListData(nombres);

    }//GEN-LAST:event_buscadorTextFieldKeyTyped

    private void guardarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseClicked
        int calificacion = obtenerCalificacion();
        
        
        String usuario = usuarioTextField.getText();;
        if(calificacion != -1)
            usuario = usuario +" - "+ calificacion + " estrella/s";
            
            
        String comentario = comentarioTextArea.getText();
        if(usuarioTextField.getText().equals("Usuario") && comentarioTextArea.getText().equals("Escriba aquí un comentario sobre la atracción")){
            JOptionPane.showMessageDialog(this, "Comentario vacio, intente nuevamente.");
        }
        else if(usuarioTextField.getText().equals("Usuario")){
            JOptionPane.showMessageDialog(this, "Falta introducir el nombre.");
        }
        else if(comentarioTextArea.getText().equals("Escriba aquí un comentario sobre la atracción")){
            JOptionPane.showMessageDialog(this, "Falta introducir el comentario.");
        }
        else{
            actividadSeleccionada.insetarComentario(usuario, comentario);
            actualizarComentarios();
        }
        
        usuarioTextField.setText("Usuario");
        comentarioTextArea.setText("Escriba aquí un comentario sobre la atracción");
        ranking.clearSelection();

    }//GEN-LAST:event_guardarButtonMouseClicked

    private void usuarioTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuarioTextFieldFocusGained
        if(usuarioTextField.getText().equals("Usuario"))
            usuarioTextField.setText("");
    }//GEN-LAST:event_usuarioTextFieldFocusGained

    private void usuarioTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuarioTextFieldFocusLost
        if(usuarioTextField.getText().equals(""))
            usuarioTextField.setText("Usuario");
    }//GEN-LAST:event_usuarioTextFieldFocusLost

    private void comentarioTextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comentarioTextAreaFocusGained
         if(comentarioTextArea.getText().equals("Escriba aquí un comentario sobre la atracción"))
            comentarioTextArea.setText("");
    }//GEN-LAST:event_comentarioTextAreaFocusGained

    private void comentarioTextAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comentarioTextAreaFocusLost
        if(comentarioTextArea.getText().equals(""))
            comentarioTextArea.setText("Escriba aquí un comentario sobre la atracción");
    }//GEN-LAST:event_comentarioTextAreaFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscadorTextField;
    private javax.swing.JTextArea comentarioTextArea;
    private javax.swing.JLabel comentariosLabel;
    private javax.swing.JList comentariosList;
    private javax.swing.JTextArea descripcionTextArea;
    private javax.swing.JCheckBox favoritoCheckBox;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listaActividades;
    private javax.swing.JLabel mapaLabel;
    private javax.swing.JMenu menu;
    private javax.swing.JMenu menuNoreste;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JRadioButton radioButton1;
    private javax.swing.JRadioButton radioButton2;
    private javax.swing.JRadioButton radioButton3;
    private javax.swing.JRadioButton radioButton4;
    private javax.swing.JRadioButton radioButton5;
    private javax.swing.JMenuItem riveraMenuItem;
    private javax.swing.JMenuItem tacuaremboMenuItem;
    private javax.swing.JLabel tipoLabel;
    private javax.swing.JTextField usuarioTextField;
    // End of variables declaration//GEN-END:variables

    public void cargarResultadosPorNombre(String buscar) {
        //buscar solo entre los nombres
        for (int i = 0; i < data.getActividades().size(); i++) {
            Actividad act = data.getActividades().get(i);
            String nombre = act.getNombre().toLowerCase();
            if (nombre.contains(buscar.toLowerCase())) {
                resultados.add(act);
            }
        }
    }

    public void cargarResultadosPorNombreYDescripcion(String buscar) {
        for (int i = 0; i < data.getActividades().size(); i++) {
            Actividad act = data.getActividades().get(i);
            String nombre = act.getNombre().toLowerCase();
            String descripcion = act.getDescripcion().toLowerCase();
            if (nombre.contains(buscar.toLowerCase()) || descripcion.contains(buscar.toLowerCase())) {
                resultados.add(act);
            }
        }
    }

//    public void actualizarComentarios() {
//        ArrayList<Comentario> comentarios = actividadSeleccionada.recuperarComentarios();
//        String[] com = new String[comentarios.size()];
//        for (int i = 0; i < comentarios.size(); i++) { 
//            com[i] = comentarios.get(i).toString();
//        }
//        comentariosList.setListData(com);
//    }
    
    
    public void actualizarComentarios() {
        ArrayList<Comentario> comentarios = actividadSeleccionada.recuperarComentarios();
        ArrayList<String> ret = new ArrayList<>();
        //String[] com = new String[comentarios.size()];
        for (int i = 0; i < comentarios.size(); i++) { 
            String usu = "("+(i+1)+") --- "+comentarios.get(i).getUsuario()+" ---";
            ret.add(usu);
            String com = "      "+comentarios.get(i).getComentario();
            ret.add(com);
        }
        comentariosList.setListData(ret.toArray());
    }
    
  
    public void actualizarFavoritos() {
        ArrayList<Actividad> actividades = filtrarActividades(data, "Favoritos");
        categoriaSeleccionada = actividades;
        cargarVentana(actividades);
        if (actividades.isEmpty()) {
            listaActividades.setSelectedIndex(0);
        }
        cargarInfo(0);

    }

    private int obtenerCalificacion() {
        if(radioButton1.isSelected())
            return 1;
        else if(radioButton2.isSelected())
            return 2;
        else if(radioButton3.isSelected())
            return 3;
        else if(radioButton4.isSelected())
            return 4;
        else if (radioButton5.isSelected()) 
            return 5;        
        return -1;
    }
}

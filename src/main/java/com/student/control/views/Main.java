package com.student.control.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.TableModelEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.transaction.Transactional;

import org.apache.poi.sl.draw.geom.GuideIf.Op;

import com.student.control.controllers.UserController;
import com.student.control.dto.EmailDetails;
import com.student.control.interfaces.TableActionEvent;
import com.student.control.models.Calificacion;
import com.student.control.models.Corte;
import com.student.control.models.Periodo;
import com.student.control.models.User;
import com.student.control.repositories.CalificacionRepository;
import com.student.control.repositories.CorteRepository;
import com.student.control.repositories.PeriodoRepository;
import com.student.control.repositories.UserRepository;
import com.student.control.services.EmailService;
import com.student.control.utils.ExcelUtil;
import com.student.control.utils.TableActionCellEditor;
import com.student.control.utils.TableActionCellRender;

public class Main extends javax.swing.JFrame {

    private UserRepository userRepository;
    private PeriodoRepository periodoRepository;
    private CorteRepository corteRepository;
    private CalificacionRepository calificacionRepository;
    private EmailService emailService;
    private HashMap<String, ArrayList<HashMap<String, Integer>>> lstCortes = new HashMap<>();
    Periodo peridoActual = null;

    /**
     * Creates new form Main
     *
     * @param userRepository
     * @param emailService
     * @param username
     */
    public Main(UserRepository userRepository, PeriodoRepository periodoRepository, CorteRepository corteRepository,
            CalificacionRepository calificacionRepository, EmailService emailService, String username) {
        this.userRepository = userRepository;
        this.periodoRepository = periodoRepository;
        this.corteRepository = corteRepository;
        this.calificacionRepository = calificacionRepository;
        this.emailService = emailService;
        initComponents();
        lblUsername.setText(username.toUpperCase());

        BoxCortes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acciones a realizar cuando se selecciona un nuevo elemento
                String selectedItem = (String) BoxCortes.getSelectedItem();
                txtQuiz.setText("");
                txtTallers.setText("");
                txtTareas.setText("");
                txtActPrac.setText("");
            }
        });

        jComboBoxPeriodosNotas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String periodo = jComboBoxPeriodosNotas.getSelectedItem().toString();

                if (!"SELECCIONE UN PERIODO:".equals(periodo)) {
                    lblPeriodo.setText(periodo);
                }
            }
        });

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                if (jTable1.isEditing()) {
                    jTable1.getCellEditor().stopCellEditing();
                }
                int id = (int) jTable1.getValueAt(row, 0);
                userRepository.deleteById(id);
                loadTable();
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
            }
        };
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        jTable1.getModel().addTableModelListener((e) -> tableChanged(e));

        //table students
        TableActionEvent eventStudents = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                if (jTable1.isEditing()) {
                    jTable1.getCellEditor().stopCellEditing();
                }
                int id = (int) jTable1.getValueAt(row, 0);

            }
        };
        jTable2.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        jTable2.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
        jTable2.getModel().addTableModelListener((e) -> tableStudentsChanged(e));

        loadTable();
        loadComboPeriodos();
        loadComboStudents();

        // variables
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Home = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        PanelAdminstrativo = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddStudents = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        RIGHT2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        LEFT2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        GestorAcademico = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxPeriodos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtCortes = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        BoxCortes = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtQuiz = new javax.swing.JTextField();
        txtTallers = new javax.swing.JTextField();
        txtTareas = new javax.swing.JTextField();
        txtActPrac = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        Notas = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        LEFT1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        jComboBoxPeriodosNotas = new javax.swing.JComboBox<>();
        RIGHT1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Group.png"))); // NOI18N
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("BIENVENIDO");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 350, 60));

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
            .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
            .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HomeLayout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("INICIO", Home);

        jPanel.setBackground(new java.awt.Color(0, 102, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "#", "Nombres", "Apellidos", "Correo Electrónico", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(1);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(1);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(2).setMinWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(3).setMinWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(4).setMinWidth(263);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(263);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(263);
            jTable1.getColumnModel().getColumn(5).setMinWidth(24);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(24);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(24);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelAdminstrativoLayout = new javax.swing.GroupLayout(PanelAdminstrativo);
        PanelAdminstrativo.setLayout(PanelAdminstrativoLayout);
        PanelAdminstrativoLayout.setHorizontalGroup(
            PanelAdminstrativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
            .addGroup(PanelAdminstrativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelAdminstrativoLayout.setVerticalGroup(
            PanelAdminstrativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(PanelAdminstrativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PANEL ADMINISTRATIVO", PanelAdminstrativo);

        AddStudents.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RIGHT2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("AGREGAR ESTUDIANTES");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Nombres:");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Apellidos:");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Correo Electrónico:");

        jButton6.setText("Agregar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveStudent(evt);
            }
        });

        jLabel22.setText("o");

        jButton7.setText("Cargar Excel");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Vector.png"))); // NOI18N

        javax.swing.GroupLayout RIGHT2Layout = new javax.swing.GroupLayout(RIGHT2);
        RIGHT2.setLayout(RIGHT2Layout);
        RIGHT2Layout.setHorizontalGroup(
            RIGHT2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RIGHT2Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(RIGHT2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RIGHT2Layout.createSequentialGroup()
                        .addGroup(RIGHT2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addGroup(RIGHT2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail)
                                .addComponent(txtApellidos)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RIGHT2Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RIGHT2Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        RIGHT2Layout.setVerticalGroup(
            RIGHT2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RIGHT2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(12, 12, 12)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(RIGHT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 420, 460));

        LEFT2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regiterLogo.png"))); // NOI18N

        javax.swing.GroupLayout LEFT2Layout = new javax.swing.GroupLayout(LEFT2);
        LEFT2.setLayout(LEFT2Layout);
        LEFT2Layout.setHorizontalGroup(
            LEFT2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LEFT2Layout.setVerticalGroup(
            LEFT2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEFT2Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );

        jPanel4.add(LEFT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 460));

        javax.swing.GroupLayout AddStudentsLayout = new javax.swing.GroupLayout(AddStudents);
        AddStudents.setLayout(AddStudentsLayout);
        AddStudentsLayout.setHorizontalGroup(
            AddStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        AddStudentsLayout.setVerticalGroup(
            AddStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.addTab("AGREGAR ESTUDIANTES", AddStudents);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 102, 255));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regiterLogo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("PERIODOS ACADEMICOS");

        jComboBoxPeriodos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UN PERIODO:" }));
        jComboBoxPeriodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPeriodosActionPerformed(evt);
            }
        });

        jButton1.setText("RESETEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jComboBoxPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 430));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        txtCortes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCortesActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("INGRESE LA CANTIDAD DE CORTES:");

        jButton5.setText("GENERAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        BoxCortes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "POR FAVOR INGRESE LA CANTIDAD DE CORTES" }));
        BoxCortes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxCortesActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("QUIZ: (%)");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("TALLERES: (%)");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("TAREAS: (%)");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("ACT. PRACTICA: (%)");

        BtnGuardar.setText("GUARDAR ");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuiz)
                            .addComponent(txtTallers)
                            .addComponent(txtTareas)
                            .addComponent(txtActPrac, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(BoxCortes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(txtCortes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(BtnGuardar)
                        .addGap(126, 126, 126)))
                .addGap(49, 49, 49))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(txtCortes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(BoxCortes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTallers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTareas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtActPrac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 0, 430, 430));

        javax.swing.GroupLayout GestorAcademicoLayout = new javax.swing.GroupLayout(GestorAcademico);
        GestorAcademico.setLayout(GestorAcademicoLayout);
        GestorAcademicoLayout.setHorizontalGroup(
            GestorAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        GestorAcademicoLayout.setVerticalGroup(
            GestorAcademicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestorAcademicoLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("GESTOR ACADEMICO", GestorAcademico);

        Notas.setBackground(new java.awt.Color(255, 255, 255));
        Notas.setPreferredSize(new java.awt.Dimension(629, 450));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LEFT1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/regiterLogo.png"))); // NOI18N

        lblPeriodo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblPeriodo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jComboBoxPeriodosNotas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UN PERIODO:" }));
        jComboBoxPeriodosNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPeriodosNotasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LEFT1Layout = new javax.swing.GroupLayout(LEFT1);
        LEFT1.setLayout(LEFT1Layout);
        LEFT1Layout.setHorizontalGroup(
            LEFT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEFT1Layout.createSequentialGroup()
                .addGroup(LEFT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LEFT1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LEFT1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(LEFT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LEFT1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jComboBoxPeriodosNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        LEFT1Layout.setVerticalGroup(
            LEFT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEFT1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPeriodosNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        jPanel5.add(LEFT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 250, 440));

        RIGHT1.setBackground(new java.awt.Color(255, 255, 255));
        RIGHT1.setPreferredSize(new java.awt.Dimension(360, 517));

        jButton3.setText("ENVIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("ENVIAR A TODOS");

        jLabel8.setText("o");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Estudiante:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "QUIZ", "TALLERES", "TAREAS", "ACT. PRACTICA", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable2.getColumnModel().getColumn(5).setMinWidth(24);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(24);
            jTable2.getColumnModel().getColumn(5).setMaxWidth(24);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("AGREGAR NOTA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RIGHT1Layout = new javax.swing.GroupLayout(RIGHT1);
        RIGHT1.setLayout(RIGHT1Layout);
        RIGHT1Layout.setHorizontalGroup(
            RIGHT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RIGHT1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(27, 27, 27)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(118, 118, 118))
            .addGroup(RIGHT1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RIGHT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RIGHT1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RIGHT1Layout.setVerticalGroup(
            RIGHT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RIGHT1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(RIGHT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(RIGHT1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel5.add(RIGHT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 500, 420));

        javax.swing.GroupLayout NotasLayout = new javax.swing.GroupLayout(Notas);
        Notas.setLayout(NotasLayout);
        NotasLayout.setHorizontalGroup(
            NotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );
        NotasLayout.setVerticalGroup(
            NotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NotasLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("GESTION DE NOTAS", Notas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String comboStudents = jComboBox1.getSelectedItem().toString();

        if ("SELECCIONE UN ESTUDIANTE:".equals(comboStudents)) {
            JOptionPane.showMessageDialog(null, "POR FAVOR SELECCIONE UN ESTUDIANTE", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        model.addRow(new Object[]{model.getRowCount() + 1, "", "", "", ""});

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxPeriodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPeriodosActionPerformed

        String periodoSelect = jComboBoxPeriodos.getSelectedItem().toString();
        actualizarCortes(periodoSelect);
    }//GEN-LAST:event_jComboBoxPeriodosActionPerformed

    private void actualizarCortes(String seleccion) {
        // Limpiar los elementos actuales del JComboBox de entidades
        if (seleccion != null) {
            String[] parts = seleccion.split("-");
            String name = parts[0];
            Optional<Periodo> p = periodoRepository.findByNombre(name.trim());
            List<Corte> cortes = corteRepository.selectByPeriodoId(p.get().getId());

            if (!cortes.isEmpty()) {
                BoxCortes.removeAllItems();

                BoxCortes.addItem("POR FAVOR SELECCIONA UN CORTE");

                int i = 1;
                for (Corte entidad : cortes) {
                    BoxCortes.addItem("CORTE " + i + " - " + entidad.getPorcentaje() + "%");
                    i++;
                }
            }

        }
    }


    private void BoxCortesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxCortesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxCortesActionPerformed

    private void jComboBoxPeriodosNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPeriodosNotasActionPerformed
        String periodo = jComboBoxPeriodos.getSelectedItem().toString();
        if (!"SELECCIONE UN PERIODO:".equals(periodo)) {
            String[] parts = periodo.split("-");
            String name = parts[0];

            Optional<Periodo> p = periodoRepository.findByNombre(name);
            peridoActual = p.get();
        }


    }//GEN-LAST:event_jComboBoxPeriodosNotasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

        String periodo = jComboBoxPeriodos.getSelectedItem().toString();

        if (!"SELECCIONE UN PERIODO:".equals(periodo)) {
            int response = JOptionPane.showConfirmDialog(null,
                    "¿ESTA SEGURO DE QUE DESEA REINICIAR EL PERIODO? \n ESTA ACCION ELIMINARA TODOS LOS DATOS DEL PERIODO SELECCIONADO",
                    "CONFIRMACION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                // delete all the data from the period
                try {

                    String[] parts = periodo.split("-");
                    String name = parts[0];
                    if (resetearPeriodo(name.trim())) {

                        String message = "EL PERIODO " + name
                                + " HA SIDO REINICIADO CORRECTAMENTE";
                        JOptionPane.showMessageDialog(null, message);
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR AL REINICIAR EL PERIODO");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }

    }// GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_jTabbedPane1StateChanged
        JTabbedPane pane = (JTabbedPane) evt.getSource();
        if (pane.getSelectedIndex() == 1) {
            loadTable();
        }
        if (pane.getSelectedIndex() == 4) {
            loadComboStudents();
        }
    }// GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        try {
            EmailDetails details = new EmailDetails();
            details.setRecipientAddress("jgonzalezce@uninpahu.edu.co");
            details.setBody("PRUEBA DE CORREO ELECTRONICO");
            details.setSubject("ENTREGA DE NOTAS");

            String message = emailService.sendMail(details);

            JOptionPane.showMessageDialog(rootPane, message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }// GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed

        String combo = jComboBoxPeriodos.getSelectedItem().toString();

        if ("SELECCIONE UN PERIODO:".equals(combo)) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un periodo.", "Advertencia",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] parts = combo.split("-");
        String name = parts[0];
        Optional<Periodo> p = periodoRepository.findByNombre(name.trim());

        if (p.isPresent()) {
            Periodo periodo = p.get();

            String c = txtCortes.getText();

            if (c.isBlank()) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa un número.", "Advertencia",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int cortes = 0;
            try {
                cortes = Integer.parseInt(c);
                if (cortes < 0 || cortes > 10) {
                    throw new Exception("Error");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa un número valido. (1-10)",
                        "Advertencia",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            ArrayList<String> porcentajesValidos = new ArrayList<>();
            ArrayList<Corte> cortesValidos = new ArrayList<>();
            int sumaPorcentajes = 0;

            while (sumaPorcentajes != 100) {
                sumaPorcentajes = 0;
                int restante = 100;

                for (int i = 1; i <= cortes; i++) {
                    String res = null;
                    while (res == null) {
                        res = JOptionPane.showInputDialog(null,
                                "Ingrese el porcentaje para el corte número " + i
                                + "\nRestante: " + restante + "%",
                                "Porcentaje", JOptionPane.QUESTION_MESSAGE);
                    }

                    try {
                        int porcentaje = Integer.parseInt(res);
                        if (porcentaje < 0 || porcentaje > restante) {
                            throw new Exception("Error");
                        }

                        sumaPorcentajes += porcentaje;
                        restante -= porcentaje;

                        String porcentajeString = "CORTE " + i + " - " + porcentaje + "%";
                        porcentajesValidos.add(porcentajeString);
                        cortesValidos.add(new Corte(null, porcentaje, null, periodo));

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                "Por favor ingresa un porcentaje válido.\nRestante: "
                                + restante + "%",
                                "Advertencia",
                                JOptionPane.INFORMATION_MESSAGE);
                        i--;
                    }

                    if (sumaPorcentajes == 100 && i < cortes) {
                        JOptionPane.showMessageDialog(null,
                                "No puedes tener más cortes después de un porcentaje del 100%. Por favor, ingresa un nuevo número de cortes.",
                                "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                        porcentajesValidos.clear();
                        sumaPorcentajes = 0;
                        break;
                    }
                }

                if (sumaPorcentajes != 100) {
                    JOptionPane.showMessageDialog(null,
                            "La suma de los porcentajes no es igual a 100. Por favor, vuelva a ingresar los valores.",
                            "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    porcentajesValidos.clear();
                }

            }

            periodo.setCortes(cortesValidos);

            periodoRepository.save(periodo);

            Collections.reverse(porcentajesValidos);

            porcentajesValidos.add("POR FAVOR SELECCIONA UN CORTE");

            Collections.reverse(porcentajesValidos);

            BoxCortes.setModel(new DefaultComboBoxModel<>(porcentajesValidos.toArray(String[]::new)));
        }

    }// GEN-LAST:event_jButton5ActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnGuardarActionPerformed

        String comboValue = (String) BoxCortes.getSelectedItem();

        if (comboValue.equalsIgnoreCase("POR FAVOR SELECCIONA UN CORTE")) {
            JOptionPane.showMessageDialog(null, "POR FAVOR SELECCIONA UN CORTE", "Advertencia",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String valorQuiz = txtQuiz.getText();
        String valorTalleres = txtTallers.getText();
        String valorTareas = txtTareas.getText();
        String valorActPrac = txtActPrac.getText();

        int quiz = 0;
        int talleres = 0;
        int tareas = 0;
        int actPractica = 0;

        try {
            quiz = Integer.valueOf(valorQuiz);
            talleres = Integer.valueOf(valorTalleres);
            tareas = Integer.valueOf(valorTareas);
            actPractica = Integer.valueOf(valorActPrac);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "POR FAVOR INGRESA VALORES CORRECTOS, PARA CADA ITEM A CALIFICAR.",
                    "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (quiz + talleres + tareas + actPractica == 100) {
            ArrayList<HashMap<String, Integer>> listItems = new ArrayList<>(); // valor del porcentaje de
            // cada corte

            HashMap<String, Integer> items = new HashMap<>();

            items.put("QUIZ", quiz);
            items.put("TALLERES", talleres);
            items.put("TAREAS", tareas);
            items.put("ACTPRACTICA", actPractica);

            listItems.add(items);

            String[] arrayValues = comboValue.split("-");

            lstCortes.put(arrayValues[1], listItems);

            txtQuiz.setText("");
            txtTallers.setText("");
            txtTareas.setText("");
            txtActPrac.setText("");
        } else {
            JOptionPane.showMessageDialog(null,
                    "La suma de los valores no es igual a 100. Verifique los valores ingresados.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }// GEN-LAST:event_BtnGuardarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        FileFilter filter = new FileNameExtensionFilter("Hoja de cálculo de Microsoft Excel", "xlsx");

        fileChooser.setDialogTitle("Abre el archivo");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int returnedValue = fileChooser.showOpenDialog(null);

        if (returnedValue == JFileChooser.APPROVE_OPTION) {

            HashMap<Integer, List<String>> data = new HashMap<>();
            List<User> users = new ArrayList<>();

            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            try {
                data = ExcelUtil.ReadFile(path);

                for (int i = 0; i < data.size(); i++) {
                    List<String> student = data.get(i);

                    User user = new User();
                    user.setFirstName(student.get(0));
                    user.setLastName(student.get(1));
                    user.setEmail(student.get(2));

                    users.add(user);
                }

                userRepository.saveAll(users);
                JOptionPane.showMessageDialog(null, "Listado de estudiantes cargado correctamente.");
                jTabbedPane1.setSelectedIndex(1);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
    }// GEN-LAST:event_jButton7ActionPerformed

    private void saveStudent(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveStudent
        UserController userController = new UserController(userRepository);

        User user = new User();
        user.setFirstName(txtNombres.getText());
        user.setLastName(txtApellidos.getText());
        user.setEmail(txtEmail.getText());

        userController.saveUser(user);
        jTabbedPane1.setSelectedIndex(1);

        JOptionPane.showMessageDialog(null, "Estudiante Creado con exito");
    }// GEN-LAST:event_saveStudent

    private void txtCortesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCortesActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtCortesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddStudents;
    private javax.swing.JComboBox<String> BoxCortes;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JPanel GestorAcademico;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel LEFT1;
    private javax.swing.JPanel LEFT2;
    private javax.swing.JPanel Notas;
    private javax.swing.JPanel PanelAdminstrativo;
    private javax.swing.JPanel RIGHT1;
    private javax.swing.JPanel RIGHT2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxPeriodos;
    private javax.swing.JComboBox<String> jComboBoxPeriodosNotas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtActPrac;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCortes;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtQuiz;
    private javax.swing.JTextField txtTallers;
    private javax.swing.JTextField txtTareas;
    // End of variables declaration//GEN-END:variables

    private void loadTable() {
        List<User> users = userRepository.findAll();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.setNumRows(0);
        int i = 1;
        for (User user : users) {
            if (user.getPassword() == null) {
                model.addRow(
                        new Object[]{user.getId(), i++, user.getFirstName(),
                            user.getLastName(), user.getEmail()});
            }
        }
    }

    private void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        String columnName = model.getColumnName(column);
        if (!columnName.isEmpty()) {
            int id = (int) jTable1.getValueAt(row, 0);
            String firstName = (String) jTable1.getValueAt(row, 2);
            String lastName = (String) jTable1.getValueAt(row, 3);
            String email = (String) jTable1.getValueAt(row, 4);

            User u = userRepository.findById(id).get();
            if (!u.getFirstName().equals(firstName) || !u.getLastName().equals(lastName)
                    || !u.getEmail().equals(email)) {

                User user = new User(id, firstName, lastName, email, null);

                userRepository.save(user);
                loadTable();
                JOptionPane.showMessageDialog(null, "Estudiante Actualizado con exito");
            }

        }
    }

    private void tableStudentsChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        String columnName = model.getColumnName(column);
        if (!columnName.isEmpty()) {
            String studente = jComboBox1.getSelectedItem().toString();

            String[] part = studente.split("-");

            int idStudent = Integer.parseInt(part[0]);
            Optional<User> u = userRepository.findById(idStudent);
            User user = u.get();
            int id = 0;
            if (jTable2.getValueAt(row, 0) != null) {
                if (String.valueOf(jTable2.getValueAt(row, 0)).isBlank()) {
                    return;
                }
                id = (int) jTable2.getValueAt(row, 0);
            }
            if (jTable2.getValueAt(row, 1) != null) {
                if (String.valueOf(jTable2.getValueAt(row, 1)).isBlank()) {
                    return;
                }
                int quiz = (int) jTable2.getValueAt(row, 1);
//                calificacionRepository.save(new Calificacion(id, "QUIZ", PROPERTIES, corte, user));
            }
            if (jTable2.getValueAt(row, 2) != null) {
                if (String.valueOf(jTable2.getValueAt(row, 2)).isBlank()) {
                    return;
                }

                int tallers = (int) jTable2.getValueAt(row, 2);
            }
            if (jTable2.getValueAt(row, 3) != null) {
                if (String.valueOf(jTable2.getValueAt(row, 3)).isBlank()) {
                    return;
                }

                int tareas = (int) jTable2.getValueAt(row, 3);
            }

            if (jTable2.getValueAt(row, 4) != null) {
                if (String.valueOf(jTable2.getValueAt(row, 4)).isBlank()) {
                    return;
                }

                int actPrac = (int) jTable2.getValueAt(row, 4);
            }

//            String firstName = (String) jTable1.getValueAt(row, 2);
//            String lastName = (String) jTable1.getValueAt(row, 3);
//            String email = (String) jTable1.getValueAt(row, 4);
//
//            User u = userRepository.findById(id).get();
//            if (!u.getFirstName().equals(firstName) || !u.getLastName().equals(lastName)
//                    || !u.getEmail().equals(email)) {
//
//                User user = new User(id, firstName, lastName, email, null);
//
//                userRepository.save(user);
//                loadTable();
//                JOptionPane.showMessageDialog(null, "Estudiante Actualizado con exito");
//            }
        }
    }

    private void loadComboStudents() {

        ArrayList<String> students = (ArrayList<String>) userRepository.findAll().stream()
                .filter(s -> s.getPassword() == null)
                .map(s -> s.getId() + "-" + s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.toList());

        Collections.reverse(students);

        students.add("SELECCIONE UN ESTUDIANTE:");

        Collections.reverse(students);

        jComboBox1.setModel(new DefaultComboBoxModel<>(students.toArray(String[]::new)));

    }

    private void loadComboPeriodos() {
        ArrayList<String> periods = (ArrayList<String>) periodoRepository.findAll().stream()
                .map(p -> p.getNombre() + " - " + Calendar.getInstance().get(Calendar.YEAR))
                .collect(Collectors.toList());

        Collections.reverse(periods);

        periods.add("SELECCIONE UN PERIODO:");

        Collections.reverse(periods);

        jComboBoxPeriodos.setModel(new DefaultComboBoxModel<>(periods.toArray(String[]::new)));
        jComboBoxPeriodosNotas.setModel(new DefaultComboBoxModel<>(periods.toArray(String[]::new)));

    }

    private boolean resetearPeriodo(String nombre) {

        Optional<Periodo> p = periodoRepository.findByNombre(nombre);

        if (p.isPresent()) {

            Periodo periodo = p.get();

            corteRepository.deleteCalificacionesByPeriodoId(periodo.getId());
            corteRepository.deleteByPeriodoId(periodo.getId());
            return true;
        }

        return false;
    }

}

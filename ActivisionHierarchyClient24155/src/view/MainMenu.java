
package view;

import Service.BusinessUnitsService;
import Service.CompanyService;
import Service.DirectorService;
import Service.GamesService;
import Service.LicenceService;
import Service.StudiosService;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.BusinessUnits;
import model.Company;
import model.Director;
import model.Games;
import model.Licence;
import model.Studios;
import org.dom4j.*;
import java.util.stream.*;
import org.dom4j.DocumentException;



/**
 *
 * @author royon
 */
public class MainMenu extends javax.swing.JFrame {
 String path2 = null;
 DefaultTableModel tableModel = new DefaultTableModel();
 DefaultTableModel tableModel1 = new DefaultTableModel();
  DefaultTableModel tableModel2 = new DefaultTableModel();
  DefaultTableModel tableModel3 = new DefaultTableModel();
  DefaultTableModel tableModel4 = new DefaultTableModel();
  DefaultTableModel tableModel5 = new DefaultTableModel();
    /**
     * Creates new form MainMenu
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     */
    public MainMenu() throws RemoteException, NotBoundException, SQLException {
        initComponents();
        addComboItemCompany ();
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        addColumnsHeaderCompany();
        addColumnsHeaderBusiness();
        addColumnsHeaderStudio();
        addColumnsHeaderGame();
        addColumnsHeaderDirector();
        addColumnsHeaderLicence();
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
       
    }

    private void addComboItemCompany () {
    try{ 

    Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
    CompanyService service =(CompanyService) theRegistry.lookup("comp");
    List<Company> companies = service.allCompanies();
    for(Company theCompany : companies) {
  
    companyBox3.addItem(theCompany);
    companyBusiBox2.addItem(theCompany);
    
    }
    }catch (Exception ex){
    ex. printStackTrace();
    }
    }
    
    private void addComboItemBusines () {
    try{ 

    Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
    BusinessUnitsService service = (BusinessUnitsService) theRegistry.lookup("busi");
    List<BusinessUnits> businesses = service.allBusinesses();
    for(BusinessUnits theBusiness : businesses) {
    
    businessStudiobox.addItem(theBusiness);
    businessStudiobox1.addItem(theBusiness);
    }
    }catch (Exception ex){
    ex. printStackTrace();
    }
    }
    private void addComboItemStudio () {
    try{ 

    Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
    StudiosService service = (StudiosService) theRegistry.lookup("stu");
    List<Studios> studios = service.allStudios();
    for(Studios theStudios : studios) {
    
    Studiobox3.addItem(theStudios);
    jComboBox1.addItem(theStudios);
    studioGameUpdate.addItem(theStudios);
    studioLicenceBox.addItem(theStudios);
    }
    }catch (Exception ex){
    ex. printStackTrace();
    }
    }
    private void addComboItemDirector () {
    try{ 

    Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
    DirectorService service = (DirectorService) theRegistry.lookup("dir");
    List<Director> directors = service.allDirectors();
    for(Director theDirector : directors) {
    directorBox1.addItem(theDirector);
    directorCompanyBox.addItem(theDirector);
    }
    
    }catch (Exception ex){
    ex. printStackTrace();
    }
    }
    private void addComboItemLicence () {
    try{ 

    Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
    LicenceService service = (LicenceService) theRegistry.lookup("lice");
    List<Licence> licences = service.allLicences();
    for(Licence theLicence : licences) {
    licenceGameBox.addItem(theLicence);
    licenceComboBox1.addItem(theLicence);
    
    }
    
    }catch (Exception ex){
    ex. printStackTrace();
    }
    }
     private void addColumnsHeaderCompany(){
        tableModel.addColumn("Company ID");
        tableModel.addColumn("Company Name");
        tableModel.addColumn("Company Industry");
        tableModel.addColumn("LEI");
        tableModel.addColumn("Founded Date");       
        tableModel.addColumn("Logo");       
        compTable.setModel(tableModel);
    }
     private void addColumnsHeaderBusiness(){
         tableModel1.addColumn("Business ID");
        tableModel1.addColumn("Business Name");
        tableModel1.addColumn("Founded Date");
        tableModel1.addColumn("Studios");
        tableModel1.addColumn("Company Name");
        businessTable.setModel(tableModel1);
    }
     
     private void addColumnsHeaderStudio(){
         tableModel2.addColumn("Studio Id");
         tableModel2.addColumn("Studio Name");
        tableModel2.addColumn("Number of employee");
        tableModel2.addColumn("Business Name");
        tableModel2.addColumn("Creation date");
        studioTable.setModel(tableModel2);
    }
     
      private void addColumnsHeaderGame(){
          tableModel3.addColumn("Game ID");
         tableModel3.addColumn("Game Name");
        tableModel3.addColumn("Type ");
        tableModel3.addColumn("Publisghing Date");
        tableModel3.addColumn("Studios");
        tableModel3.addColumn("Licence");
        
        gameTable.setModel(tableModel3);
    }
       private void addColumnsHeaderDirector(){
          tableModel4.addColumn("Director ID"); 
         tableModel4.addColumn("Director Name");
        tableModel4.addColumn("Date Of Birth ");
        
        tableModel4.addColumn("Contact");
        directorTable.setModel(tableModel4);
    }
       private void addColumnsHeaderLicence(){
         tableModel5.addColumn("Licence ID");  
         tableModel5.addColumn("Licence Name");
        
        tableModel5.addColumn("Creation Date");
        tableModel5.addColumn("Games");
        tableModel5.addColumn("Studios");
        licenceTable.setModel(tableModel5);
    }
    
    private void addRowDataCompany() throws RemoteException, NotBoundException{
        
        tableModel.setRowCount(0);
        Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            CompanyService service = (CompanyService) theRegistry.lookup("comp");
            Company theCompany = new Company();
        List<Company> companie = service.allCompanies();
        for(Company theComp : companie){
            tableModel.addRow(new Object[]{
                theComp.getId(),
                theComp.getCompName(),
                theComp.getCompIndustry(),
                theComp.getLei(),
                theComp.getFoundedDate(),
                theComp.getImage()
        });
    }
    }
         private void addRowDataBusiness() throws RemoteException, NotBoundException{
        
        tableModel1.setRowCount(0);
        Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
    BusinessUnitsService service = (BusinessUnitsService) theRegistry.lookup("busi");
            BusinessUnits theBusiness = new BusinessUnits();
        List<BusinessUnits> business = service.allBusinesses();
        for(BusinessUnits theBusi : business){
            tableModel1.addRow(new Object[]{
                theBusi.getBusinessID(),
                theBusi.getBussinessName(),
                theBusi.getFoundedDate(),
                theBusi.getStudios(),
                theBusi.getCompany(),
        });
    }
  }
         private void addRowDataStudios() throws RemoteException, NotBoundException{
        
        tableModel2.setRowCount(0);
        Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
    StudiosService service = (StudiosService) theRegistry.lookup("stu");
            Studios theStudio = new Studios();
        List<Studios> studio = service.allStudios();
        for(Studios theStu : studio){
            tableModel2.addRow(new Object[]{
                theStu.getStudioId(),
                theStu.getStudioName(),
                theStu.getEmployees(),
                theStu.getBusiness(),
                theStu.getFoundedDate(),
        });
    }
  }
         private void addRowDataLicence() throws RemoteException, NotBoundException{
        
        tableModel5.setRowCount(0);
        Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
             LicenceService service = (LicenceService) theRegistry.lookup("lice");
            Licence theLicence = new Licence();
        List<Licence> licence = service.allLicences();
        for(Licence theLi : licence){
            tableModel5.addRow(new Object[]{
                theLi.getId(),
                theLi.getLicence_name(),
                theLi.getCreation_date(),
                theLi.getGames(),
                theLi.getStudios(),
        });
    }
  }
          private void addRowDataGame() throws RemoteException, NotBoundException{
        
        tableModel3.setRowCount(0);
        Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
             GamesService service = (GamesService) theRegistry.lookup("game");
            Games theGame = new Games();
        List<Games> games = service.allGames();
        for(Games theGa : games){
            tableModel3.addRow(new Object[]{
              theGa.getGameId(),
              theGa.getGameName(),
              theGa.getType(),
              theGa.getPublishingDate(),
              theGa.getStudios(),
              theGa.getLicence(),
        });
    }
  }
           private void addRowDataDirector() throws RemoteException, NotBoundException{
        
        tableModel4.setRowCount(0);
        Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
             DirectorService service = (DirectorService) theRegistry.lookup("dir");
            Director theDirector = new Director();
        List<Director> directors = service.allDirectors();
        for(Director theDi : directors){
            tableModel4.addRow(new Object[]{
              theDi.getDirectorId(),
              theDi.getDirName(),
              theDi.getDob(),
              theDi.getContact(),
              
        });
    }
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        directorTable = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        contactTxt = new Components.MyTextField();
        dirnameTxt = new Components.MyTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        contactTxt1 = new Components.MyTextField();
        jLabel54 = new javax.swing.JLabel();
        updateDirector = new javax.swing.JButton();
        searchId = new Components.MyTextField();
        directorName = new Components.MyTextField();
        jLabel55 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        myPasswordField3 = new Components.MyPasswordField();
        jLabel56 = new javax.swing.JLabel();
        deleteBttnDirector = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        compTable = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        compNameTxt = new Components.MyTextField();
        compIndusrtyTxt = new Components.MyTextField();
        foundedDate = new com.toedter.calendar.JDateChooser();
        leiTxt = new Components.MyTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        imageliber = new javax.swing.JLabel();
        imaged = new javax.swing.JButton();
        photoname = new javax.swing.JTextField();
        directorBox1 = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        leiUpdateTxt = new Components.MyTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        updateCompanyButton = new javax.swing.JButton();
        searchCompanyTxt = new Components.MyTextField();
        searchBttnCompany = new javax.swing.JButton();
        companyUpdateNameTxt = new Components.MyTextField();
        jLabel57 = new javax.swing.JLabel();
        directorCompanyBox = new javax.swing.JComboBox<>();
        passwordCompanyTxt = new Components.MyPasswordField();
        jLabel58 = new javax.swing.JLabel();
        deleteCompanyBttn = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        businessTable = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        companyBox3 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        searchBusinessTxt = new Components.MyTextField();
        businessUnitUpdateTxt1 = new Components.MyTextField();
        searchBttnBusiness = new javax.swing.JButton();
        passwordBusiness = new Components.MyPasswordField();
        jLabel26 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        businessnameTxt = new Components.MyTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        foundedDate1 = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        companyBusiBox2 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        studioTable = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        employeeTxt = new Components.MyTextField();
        studionameTxt = new Components.MyTextField();
        businessStudiobox = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        recordstudio = new javax.swing.JButton();
        foundedDatestudio = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        employeeTxt1 = new Components.MyTextField();
        businessStudiobox1 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        searchStuinTxt = new Components.MyTextField();
        studioNameUpdateTxt1 = new Components.MyTextField();
        BttnSearchStudio = new javax.swing.JButton();
        passwordStudio = new Components.MyPasswordField();
        jLabel35 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        gameTable = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        gameName = new Components.MyTextField();
        Studiobox3 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        recordGame = new javax.swing.JButton();
        typegame = new Components.MyTextField();
        publishingDate = new com.toedter.calendar.JDateChooser();
        jLabel41 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        licenceGameBox = new javax.swing.JComboBox<>();
        jPanel31 = new javax.swing.JPanel();
        gameNameUpdate = new Components.MyTextField();
        searchGameTxt = new Components.MyTextField();
        studioGameUpdate = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        licenceSearchBttn = new javax.swing.JButton();
        updateLicenceBttn = new javax.swing.JButton();
        passwordGame = new Components.MyPasswordField();
        updateLicenceBttn1 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        licenceTable = new javax.swing.JTable();
        jPanel40 = new javax.swing.JPanel();
        studioLicenceBox = new javax.swing.JComboBox<>();
        searchLicenceTxt = new Components.MyTextField();
        licenceComboBox1 = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        BttnSearchLicence = new javax.swing.JButton();
        updateBttnLicence = new javax.swing.JButton();
        passwordLicence = new Components.MyPasswordField();
        jLabel61 = new javax.swing.JLabel();
        deleteBttnLicence = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        licenceName = new Components.MyTextField();
        creationDate = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        recordlicenceBttn = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 625));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/burger-bar (1).png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 50, 40));

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/open-book.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Companies");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 270, 60));

        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/seller.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Business Units");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/office-desk.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Studios");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/games.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Games");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, -1));

        jPanel43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel43MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel43MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel43MouseExited(evt);
            }
        });

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pen-tool.png"))); // NOI18N

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel46.setText("Licence");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 270, -1));

        jPanel44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel44MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel44MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel44MouseExited(evt);
            }
        });

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (1).png"))); // NOI18N

        jLabel48.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel48.setText("Directors");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel48)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 270, 550));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu-bar.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 88, 50, 40));

        jPanel16.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 750, 70));

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        directorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(directorTable);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Director", jPanel34);

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setText("Name");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setText("Date Of Birth");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setText("Contact");

        jButton11.setText("Record");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel44)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contactTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dirnameTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addGap(270, 270, 270))
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jButton11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dirnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel43))
                .addGap(31, 31, 31)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addGap(78, 78, 78)
                .addComponent(jButton11)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane6.addTab("Record Director", jPanel35);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel53.setText("Name");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel54.setText("Contact");

        updateDirector.setText("Update");
        updateDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDirectorActionPerformed(evt);
            }
        });

        searchId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchIdActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel55.setText("ID");

        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel56.setText("Password");

        deleteBttnDirector.setText("Delete");
        deleteBttnDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBttnDirectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(directorName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addGap(31, 31, 31)
                                .addComponent(contactTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(updateDirector)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(0, 377, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addGap(18, 18, 18)
                        .addComponent(searchId, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton7)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                                .addComponent(deleteBttnDirector)
                                .addGap(61, 61, 61)))
                        .addGap(152, 152, 152))))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(searchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(45, 45, 45)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(directorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(contactTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(updateDirector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(29, 29, 29)
                .addComponent(deleteBttnDirector)
                .addGap(105, 105, 105))
        );

        jTabbedPane6.addTab("Update /Delete Director", jPanel36);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6)
        );

        jTabbedPane1.addTab("Director", jPanel15);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        compTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        compTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(compTable);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Companies", jPanel17);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        compNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compNameTxtActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Company name");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Industry");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("LEI Number");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Founded Date");

        jButton1.setText("Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        imageliber.setBackground(new java.awt.Color(0, 0, 0));
        imageliber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        imageliber.setMaximumSize(new java.awt.Dimension(208, 212));
        imageliber.setMinimumSize(new java.awt.Dimension(208, 212));
        imageliber.setOpaque(true);

        imaged.setText("Choose Company Logo");
        imaged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagedActionPerformed(evt);
            }
        });

        photoname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photonameActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setText("Director");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel45))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(compIndusrtyTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(compNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(leiTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(foundedDate, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(directorBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(imageliber, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(photoname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(imaged))))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(compNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(33, 33, 33)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compIndusrtyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(29, 29, 29)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(30, 30, 30)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(foundedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directorBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(imageliber, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(photoname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imaged))
                .addGap(27, 27, 27))
        );

        jTabbedPane2.addTab("Record Company", jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("LEI Number");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText(" Company Name");

        updateCompanyButton.setText("Update");
        updateCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCompanyButtonActionPerformed(evt);
            }
        });

        searchBttnCompany.setText("Search ");
        searchBttnCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBttnCompanyActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel57.setText("Password");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel58.setText("Director ");

        deleteCompanyBttn.setText("Delete");
        deleteCompanyBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCompanyBttnActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel65.setText("ID");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel16)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel17)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(leiUpdateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(companyUpdateNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(directorCompanyBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(updateCompanyButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(350, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteCompanyBttn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(168, 168, 168))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel65)
                .addGap(18, 18, 18)
                .addComponent(searchCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBttnCompany)
                .addGap(99, 99, 99))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addComponent(jLabel58)
                    .addContainerGap(570, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBttnCompany)
                    .addComponent(jLabel65))
                .addGap(46, 46, 46)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(companyUpdateNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(leiUpdateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(directorCompanyBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(updateCompanyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addGap(26, 26, 26)
                .addComponent(deleteCompanyBttn)
                .addGap(86, 86, 86))
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(258, 258, 258)
                    .addComponent(jLabel58)
                    .addContainerGap(270, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Update Company", jPanel19);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 66, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Company", jPanel8);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        businessTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(businessTable);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jTabbedPane3.addTab("Business Units", jPanel21);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Company Name");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setText("Business Unit Name");

        searchBttnBusiness.setText("Search");
        searchBttnBusiness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBttnBusinessActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setText("Password");

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel66.setText("ID");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(companyBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(businessUnitUpdateTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jButton4)))
                .addContainerGap(262, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchBusinessTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(passwordBusiness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addComponent(searchBttnBusiness)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(195, 195, 195))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBusinessTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBttnBusiness)
                    .addComponent(jLabel66))
                .addGap(70, 70, 70)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(businessUnitUpdateTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(companyBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordBusiness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(143, 143, 143))
        );

        jTabbedPane3.addTab("Update & Delete Business", jPanel23);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Company name");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Founded Date");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Business Unit Name");

        jButton5.setText("Record");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(foundedDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(businessnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(companyBusiBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jButton5)))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(businessnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(34, 34, 34)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(companyBusiBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foundedDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(108, 108, 108)
                .addComponent(jButton5)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Record Business Unit", jPanel22);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 74, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane3))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Business Units", jPanel9);

        jPanel13.setBackground(new java.awt.Color(50, 50, 50));

        jTabbedPane4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        studioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(studioTable);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Studios", jPanel25);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setText("Business Unit");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setText("Studio Name");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setText("Number of employees");

        recordstudio.setText("Record");
        recordstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordstudioActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setText("Founded date");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(recordstudio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(jLabel31))
                .addGap(41, 41, 41)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foundedDatestudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(businessStudiobox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studionameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                .addGap(260, 260, 260))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studionameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(27, 27, 27)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(33, 33, 33)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(businessStudiobox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(40, 40, 40)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(foundedDatestudio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(recordstudio)
                .addGap(59, 59, 59))
        );

        jTabbedPane4.addTab("Record Studio", jPanel26);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setText("Studio Name");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setText("Number of Employee");

        businessStudiobox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessStudiobox1ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setText("Password");

        jButton8.setText("Update");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        BttnSearchStudio.setText("Search");
        BttnSearchStudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnSearchStudioActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setText("Business Unit");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel67.setText("ID");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(102, 102, 102)
                                .addComponent(studioNameUpdateTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(employeeTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(businessStudiobox1, 0, 161, Short.MAX_VALUE)))))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jButton8)))
                .addContainerGap(389, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addGap(18, 18, 18)
                        .addComponent(searchStuinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BttnSearchStudio)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(27, 27, 27)
                        .addComponent(passwordStudio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(173, 173, 173))))
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jLabel35)
                    .addContainerGap(638, Short.MAX_VALUE)))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchStuinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BttnSearchStudio)
                    .addComponent(jLabel67))
                .addGap(22, 22, 22)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(studioNameUpdateTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(employeeTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(businessStudiobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34)
                    .addComponent(passwordStudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(235, 235, 235)
                    .addComponent(jLabel35)
                    .addContainerGap(268, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Update & Delete Studio", jPanel27);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Studios", jPanel10);

        jPanel3.setOpaque(false);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        gameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(gameTable);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jTabbedPane5.addTab("Games", jPanel29);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Game Name");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setText("Type Of Game");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setText("Studios");

        recordGame.setText("Record");
        recordGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordGameActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setText("Publishing Date");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel52.setText("Licence");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(recordGame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel41)
                    .addComponent(jLabel37)
                    .addComponent(jLabel39)
                    .addComponent(jLabel52))
                .addGap(28, 28, 28)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(licenceGameBox, 0, 274, Short.MAX_VALUE)
                    .addComponent(typegame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gameName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Studiobox3, 0, 274, Short.MAX_VALUE)
                    .addComponent(publishingDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(256, 256, 256))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typegame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(32, 32, 32)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(publishingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(19, 19, 19)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(licenceGameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Studiobox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(34, 34, 34)
                .addComponent(recordGame)
                .addGap(112, 112, 112))
        );

        jTabbedPane5.addTab("Record Game", jPanel30);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel62.setText("Game Name");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel63.setText("Studios");

        licenceSearchBttn.setText("Search");
        licenceSearchBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenceSearchBttnActionPerformed(evt);
            }
        });

        updateLicenceBttn.setText("Delete");
        updateLicenceBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateLicenceBttnActionPerformed(evt);
            }
        });

        updateLicenceBttn1.setText("Update");
        updateLicenceBttn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateLicenceBttn1ActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel64.setText("Password");

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel68.setText("ID");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63))
                .addGap(29, 29, 29)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gameNameUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studioGameUpdate, 0, 165, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(289, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                        .addComponent(updateLicenceBttn)
                        .addGap(310, 310, 310))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchGameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addGap(18, 18, 18)
                                .addComponent(passwordGame, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(licenceSearchBttn)
                        .addGap(205, 205, 205))))
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel31Layout.createSequentialGroup()
                    .addGap(205, 205, 205)
                    .addComponent(updateLicenceBttn1)
                    .addContainerGap(510, Short.MAX_VALUE)))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchGameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(licenceSearchBttn)
                    .addComponent(jLabel68))
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gameNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studioGameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(passwordGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel64)))
                .addGap(18, 18, 18)
                .addComponent(updateLicenceBttn)
                .addGap(126, 126, 126))
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                    .addContainerGap(281, Short.MAX_VALUE)
                    .addComponent(updateLicenceBttn1)
                    .addGap(247, 247, 247)))
        );

        jTabbedPane5.addTab("Update & Delete Game", jPanel31);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Game", jPanel14);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        licenceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(licenceTable);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        jTabbedPane7.addTab("Licences", jPanel38);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel59.setText("Licence Name");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel60.setText("Studio");

        BttnSearchLicence.setText("Search");
        BttnSearchLicence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnSearchLicenceActionPerformed(evt);
            }
        });

        updateBttnLicence.setText("Update");
        updateBttnLicence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBttnLicenceActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel61.setText("Password");

        deleteBttnLicence.setText("Delete");
        deleteBttnLicence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBttnLicenceActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel69.setText("ID");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studioLicenceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(licenceComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(updateBttnLicence)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchLicenceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(BttnSearchLicence)
                .addGap(0, 170, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addGap(18, 18, 18)
                        .addComponent(passwordLicence, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                        .addComponent(deleteBttnLicence)
                        .addGap(261, 261, 261))))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLicenceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BttnSearchLicence)
                    .addComponent(jLabel69))
                .addGap(49, 49, 49)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(licenceComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addGap(41, 41, 41)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studioLicenceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addGap(56, 56, 56)
                .addComponent(updateBttnLicence)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLicence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addGap(18, 18, 18)
                .addComponent(deleteBttnLicence)
                .addGap(159, 159, 159))
        );

        jTabbedPane7.addTab("Update & Delete Licence", jPanel40);

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel49.setText("Studio");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setText("Licence Name");

        recordlicenceBttn.setText("Record");
        recordlicenceBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordlicenceBttnActionPerformed(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel51.setText("Creation Date");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(9, 9, 9)))
                .addGap(18, 18, 18)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(creationDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(licenceName, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(299, 299, 299))
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(recordlicenceBttn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(licenceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(creationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(132, 132, 132)
                .addComponent(recordlicenceBttn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Record Licence", jPanel39);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7)
        );

        jTabbedPane1.addTab("Licence", jPanel33);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 43, -1, 580));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Untitled-43.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
int x = 270;
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
      if (x ==270) {
          jPanel2.setSize(120, 552);
          Thread th = new Thread() {
              @Override
              public void run(){
                  try{
                      for( int i = 270; i >= 0; i--){
                         Thread.sleep(1);
                         jPanel2.setSize(i,552);
                      }
                  }catch(Exception e){
                      JOptionPane.showMessageDialog(null, e);
                  }
              }
          };th.start();
          x=0;
      }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       if (x ==0) {
          jPanel2.show();
          jPanel2.setSize(x,552);
          Thread th = new Thread() {
              @Override
              public void run(){
                  try{
                      for( int i = 0; i <= x; i++){
                         Thread.sleep(1);
                         jPanel2.setSize(i,552);
                      }
                  }catch(Exception e){
                      JOptionPane.showMessageDialog(null, e);
                  }
              }
          };th.start();
          x=270;
      }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        labelcolor(jLabel4);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        resetcolor(jLabel4);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
          labelcolor(jPanel4);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
         resetcolor(jPanel4);
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        labelcolor(jPanel5);
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        resetcolor(jPanel5);
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        labelcolor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        resetcolor(jPanel6);
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        labelcolor(jPanel7);
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
       resetcolor(jPanel7);
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
            jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
       jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
       jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void compNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compNameTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(compNameTxt.getText().trim().isEmpty() || compIndusrtyTxt.getText().trim().isEmpty() || photoname.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter All Your Details","Data required",JOptionPane.WARNING_MESSAGE);
        }else {
        
            
            try{
                Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            CompanyService service = (CompanyService) theRegistry.lookup("comp");
            Company theCompany = new Company();
            theCompany.setCompName(compNameTxt.getText());
            theCompany.setCompIndustry(compIndusrtyTxt.getText());
            theCompany.setLei(leiTxt.getText());
            theCompany.setFoundedDate(foundedDate.getDate());
            InputStream is= new FileInputStream(new File(path2));
            byte[] bFile = new byte[(int) path2.length()];
            theCompany.setImage(bFile);
            theCompany.setDirector((Director) directorBox1.getSelectedItem());
            
            Company companyObj = service.RegisterCompany(theCompany);
            if (companyObj!=null){
            JOptionPane.showMessageDialog(this, "Company Saved");
            addRowDataCompany();
            addComboItemCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
        }else{
            JOptionPane.showMessageDialog(this, "Company not Saved!");
        }
            }catch(Exception ex){
                ex.printStackTrace();
            }
       
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void photonameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photonameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_photonameActionPerformed

    private void imagedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagedActionPerformed
        JFileChooser fchoser=new JFileChooser();
        fchoser.showOpenDialog(null);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("* .Images", "jpg","gif","png");
        File f=fchoser.getSelectedFile();
        String path = f.getAbsolutePath();
        photoname.setText(path);
        try {
            BufferedImage bi = ImageIO.read(new File(path));
            Image img = bi.getScaledInstance(134, 172,Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            imageliber.setIcon(icon);
            
            path2 = path;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_imagedActionPerformed

    private void compTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compTableMouseClicked
        // TODO add your handling code here:
   
    
    
    }//GEN-LAST:event_compTableMouseClicked

    private void recordstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordstudioActionPerformed
        try{
                Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            StudiosService service = (StudiosService)theRegistry.lookup("stu");
            Studios theStudio = new Studios();
            theStudio.setStudioName(studionameTxt.getText());
            theStudio.setEmployees(employeeTxt.getText());
            theStudio.setBusiness((BusinessUnits) businessStudiobox.getSelectedItem());
            theStudio.setFoundedDate(foundedDatestudio.getDate());
            Studios stuObj = service.RegisterStudios(theStudio);
            if (stuObj!=null){
            JOptionPane.showMessageDialog(this, "Studio Saved");
            addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
        }else{
            JOptionPane.showMessageDialog(this, "Studio not Saved!");
        }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
    }//GEN-LAST:event_recordstudioActionPerformed
        
    private void recordGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordGameActionPerformed
         try{
                Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            GamesService service = (GamesService)theRegistry.lookup("game");
            Games theGame = new Games();
            theGame.setGameName(gameName.getText());
            theGame.setPublishingDate(publishingDate.getDate());
            theGame.setType(typegame.getText());
            theGame.setStudios( (Studios) Studiobox3.getSelectedItem());
            theGame.setLicence((Licence)licenceGameBox.getSelectedItem());
            
            
            
            Games gameObj = service.RegisterGames(theGame);
            if (gameObj!=null){
            JOptionPane.showMessageDialog(this, "Game Saved");
            addRowDataCompany();
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
        }else{
            JOptionPane.showMessageDialog(this, "Game not Saved!");
        }
            }catch(Exception ex){
                ex.printStackTrace();
            }
    }//GEN-LAST:event_recordGameActionPerformed

    private void jPanel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel43MouseClicked
       jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jPanel43MouseClicked

    private void jPanel43MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel43MouseEntered
        labelcolor(jPanel43);
    }//GEN-LAST:event_jPanel43MouseEntered

    private void jPanel43MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel43MouseExited
        resetcolor(jPanel43);
    }//GEN-LAST:event_jPanel43MouseExited

    private void jPanel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel44MouseClicked
       jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jPanel44MouseClicked

    private void jPanel44MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel44MouseEntered
        labelcolor(jPanel44);
    }//GEN-LAST:event_jPanel44MouseEntered

    private void jPanel44MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel44MouseExited
            resetcolor(jPanel44);
    }//GEN-LAST:event_jPanel44MouseExited

    private void recordlicenceBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordlicenceBttnActionPerformed
        try{
                Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            LicenceService service = (LicenceService)theRegistry.lookup("lice");
            Licence theLicence = new Licence();
            theLicence.setLicence_name(licenceName.getText());
            theLicence.setCreation_date(creationDate.getDate());
            theLicence.setStudios( (Studios) jComboBox1.getSelectedItem());
            
            
            
            Licence liceObj = service.RegisterLicence(theLicence);
            if (liceObj!=null){
            JOptionPane.showMessageDialog(this, "Licence Saved");
            
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
        }else{
            JOptionPane.showMessageDialog(this, "Licence not Saved!");
        }
            }catch(Exception ex){
                ex.printStackTrace();
            }
    }//GEN-LAST:event_recordlicenceBttnActionPerformed

    private void updateCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCompanyButtonActionPerformed
           if ( (companyUpdateNameTxt.getText().isEmpty()) || (leiUpdateTxt.getText().isEmpty())){
        JOptionPane.showMessageDialog(this, "Put the company's required data");
    }else if (companyUpdateNameTxt.getText().length() != 5) {
        JOptionPane.showMessageDialog(this, "Comapany Name must be 5 characters long");}
           else{
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            CompanyService service =(CompanyService) theRegistry.lookup("comp");
            Company theCompany = new Company(Integer.parseInt(searchCompanyTxt.getText()));
            
            theCompany.setCompName(companyUpdateNameTxt.getText());
            theCompany.setLei(leiUpdateTxt.getText());
            theCompany.setDirector((Director) directorCompanyBox.getSelectedItem());
           
            
            Company compObj = service.UpdateCompany(theCompany);
//            
            if(compObj!=null){
                JOptionPane.showMessageDialog(this, "Company Updated");
               
                addComboItemCompany();
                addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Company Not Updated");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
    }//GEN-LAST:event_updateCompanyButtonActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(contactTxt.getText());
if( ! matcher.matches() ) {
    JOptionPane.showMessageDialog(this, "Put the company's required data");
}
else{
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            DirectorService service = (DirectorService)theRegistry.lookup("dir");
            Director theDirector = new Director();
            theDirector.setDirName(dirnameTxt.getText());
            theDirector.setContact(contactTxt.getText());
            theDirector.setDob(jDateChooser1.getDate());
            Director dirObj = service.RegisterDirector(theDirector);
            if (dirObj!=null){
                JOptionPane.showMessageDialog(this, "Director Saved");
                addComboItemCompany ();
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Director not Saved!");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
}
    }//GEN-LAST:event_jButton11ActionPerformed

    private void searchIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchIdActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
 if ( (searchId.getText().isEmpty()) ){
        JOptionPane.showMessageDialog(this, "Put the director's ID");
    }
           else{
        
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            DirectorService service =(DirectorService) theRegistry.lookup("dir");
            Director theDirector = new Director(Integer.parseInt(searchId.getText()));
            Director dirObj = service.SearchDirector(theDirector);
//            JOptionPane.showMessageDialog(this, feedBack);
//            Faculty facObj = service.registerFac(theFaculty);
            if(dirObj!=null){
                directorName.setText(dirObj.getDirName());
                contactTxt1.setText(dirObj.getContact());
//                
            }else{
                JOptionPane.showMessageDialog(this, "Data Not Found");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
 }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void updateDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDirectorActionPerformed
      if ( (directorName.getText().isEmpty()) || (contactTxt1.getText().isEmpty())){
        JOptionPane.showMessageDialog(this, "Put the director's data");
    }
           else{
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            DirectorService service =(DirectorService) theRegistry.lookup("dir");
            Director theDirector = new Director(Integer.parseInt(searchId.getText()));
            
            theDirector.setDirName(directorName.getText());
            theDirector.setContact(contactTxt1.getText());
           
            
            Director dirObj = service.UpdateDirector(theDirector);
//            
            if(dirObj!=null){
                JOptionPane.showMessageDialog(this, "Data Updated");
              addComboItemCompany ();
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Data Not Updated");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
    }//GEN-LAST:event_updateDirectorActionPerformed

    private void deleteBttnDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBttnDirectorActionPerformed
       if(  ! myPasswordField3.getText().equals("24155")){
                 JOptionPane.showMessageDialog(this, "Put the correct Password for delete data");
             }
       else {
           if (searchId.getText().isEmpty() || (directorName.getText().isEmpty()) || (contactTxt1.getText().isEmpty())){
        JOptionPane.showMessageDialog(this, "Put the director's ID then click on the search button");
    }
           else{
            try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            DirectorService service =(DirectorService) theRegistry.lookup("dir");
            Director theDirector = new Director(Integer.parseInt(searchId.getText()));
           
            
            Director dirObj = service.DeleteDirector(theDirector);
//            
            if(dirObj!=null){
                JOptionPane.showMessageDialog(this, "Director Deleted");
                directorName.setText("");
                contactTxt1.setText("");
                searchId.setText("");
                addComboItemCompany ();
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        addColumnsHeaderCompany();
        addColumnsHeaderBusiness();
        addColumnsHeaderStudio();
        addColumnsHeaderGame();
        addColumnsHeaderDirector();
        addColumnsHeaderLicence();
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Director not deleted");
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
       }
    }//GEN-LAST:event_deleteBttnDirectorActionPerformed

    private void searchBttnCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBttnCompanyActionPerformed
       if ( (searchCompanyTxt.getText().isEmpty()) ){
        JOptionPane.showMessageDialog(this, "Put the company's ID");
    }
           else{
        
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            CompanyService service =(CompanyService) theRegistry.lookup("comp");
            Company theCompany = new Company(Integer.parseInt(searchCompanyTxt.getText()));
            Company compObj = service.SearchCompany(theCompany);

            if(compObj!=null){
                companyUpdateNameTxt.setText(compObj.getCompName());
                leiUpdateTxt.setText(compObj.getLei());
                directorCompanyBox.setSelectedItem(compObj.getDirector());
//                
            }else{
                JOptionPane.showMessageDialog(this, "Data Not Found");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
    }//GEN-LAST:event_searchBttnCompanyActionPerformed

    private void deleteCompanyBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCompanyBttnActionPerformed
              if(  ! passwordCompanyTxt.getText().equals("24155")){
                 JOptionPane.showMessageDialog(this, "Put the correct Password for delete data");
             }
       else {
           if (searchCompanyTxt.getText().isEmpty() || (companyUpdateNameTxt.getText().isEmpty()) || (leiUpdateTxt.getText().isEmpty())){
        JOptionPane.showMessageDialog(this, "Put the company's ID then click on the search button");
    }
           else{
            try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            CompanyService service =(CompanyService) theRegistry.lookup("comp");
            Company theCompany = new Company(Integer.parseInt(searchCompanyTxt.getText()));
           
            
            Company compObj = service.DeleteCompany(theCompany);
//            
            if(compObj!=null){
                JOptionPane.showMessageDialog(this, "Company Deleted");
                companyUpdateNameTxt.setText("");
                leiUpdateTxt.setText("");
                searchCompanyTxt.setText("");
                 addComboItemCompany();
                addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Company not deleted");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
       }
    }//GEN-LAST:event_deleteCompanyBttnActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       if(businessnameTxt.getText().trim().isEmpty() ){
            JOptionPane.showMessageDialog(this, "Please Enter All Your Details","Data required",JOptionPane.WARNING_MESSAGE);
       }else{
           try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", 5000);
            BusinessUnitsService service = (BusinessUnitsService)theRegistry.lookup("busi");
            BusinessUnits theBusi = new BusinessUnits();
            theBusi.setBussinessName(businessnameTxt.getText());
            theBusi.setCompany((Company) companyBusiBox2.getSelectedItem());
            theBusi.setFoundedDate(foundedDate1.getDate());
            BusinessUnits busiObj = service.RegisterBusinessUnits(theBusi);
            if (busiObj!=null){
                JOptionPane.showMessageDialog(this, "Business Unit Saved");
        addComboItemCompany();        
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
       
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Business Unit not Saved!");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void searchBttnBusinessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBttnBusinessActionPerformed
              if ( (searchBusinessTxt.getText().isEmpty()) ){
        JOptionPane.showMessageDialog(this, "Put the Business ID");
    }
           else{
        
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            BusinessUnitsService service =(BusinessUnitsService) theRegistry.lookup("busi");
            BusinessUnits theBusiness = new BusinessUnits(Integer.parseInt(searchBusinessTxt.getText()));
            BusinessUnits busiObj = service.SearchBusinessUnits(theBusiness);

            if(busiObj!=null){
                businessUnitUpdateTxt1.setText(busiObj.getBussinessName());
                companyBox3.setSelectedItem(busiObj.getCompany());
          
            }else{
                JOptionPane.showMessageDialog(this, "Data Not Found");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
 }
    }//GEN-LAST:event_searchBttnBusinessActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                  if  (businessUnitUpdateTxt1.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Put the business required data");
    }
           else{
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            BusinessUnitsService service =(BusinessUnitsService) theRegistry.lookup("busi");
            BusinessUnits theBusiness = new BusinessUnits(Integer.parseInt(searchBusinessTxt.getText()));
            
            theBusiness.setBussinessName(businessUnitUpdateTxt1.getText());
            theBusiness.setCompany((Company) companyBox3.getSelectedItem());
           
            
            BusinessUnits busiObj = service.UpdateBusinessUnits(theBusiness);
            
            if(busiObj!=null){
                JOptionPane.showMessageDialog(this, "Business Updated");
                addRowDataCompany();
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
                
            }else{
                JOptionPane.showMessageDialog(this, "Business not Updated");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                      if(  ! passwordBusiness.getText().equals("24155")){
                 JOptionPane.showMessageDialog(this, "Put the correct Password for delete data");
             }
       else {
           if (searchBusinessTxt.getText().isEmpty() || (businessUnitUpdateTxt1.getText().isEmpty()) ){
        JOptionPane.showMessageDialog(this, "Put the Business ID then click on the search button");
    }
           else{
            try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            BusinessUnitsService service =(BusinessUnitsService) theRegistry.lookup("busi");
            BusinessUnits theBusiness = new BusinessUnits(Integer.parseInt(searchBusinessTxt.getText()));
           
            
            BusinessUnits busiObj = service.DeleteBusinessUnits(theBusiness);
//            
            if(busiObj!=null){
                JOptionPane.showMessageDialog(this, "Business Deleted");
                businessUnitUpdateTxt1.setText(""); 
                searchBusinessTxt.setText("");
               addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Business not deleted");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BttnSearchStudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnSearchStudioActionPerformed
                    if ( (searchStuinTxt.getText().isEmpty()) ){
        JOptionPane.showMessageDialog(this, "Put the Studio ID");
    }
           else{
        
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            StudiosService service =(StudiosService) theRegistry.lookup("stu");
            Studios theStudio = new Studios(Integer.parseInt(searchStuinTxt.getText()));
            Studios stuObj = service.SearchStudios(theStudio);

            if(stuObj!=null){
                studioNameUpdateTxt1.setText(stuObj.getStudioName());
                employeeTxt1.setText(stuObj.getEmployees());
                businessStudiobox1.setSelectedItem(stuObj.getBusiness());
          
            }else{
                JOptionPane.showMessageDialog(this, "Data Not Found");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
 }
    }//GEN-LAST:event_BttnSearchStudioActionPerformed

    private void businessStudiobox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_businessStudiobox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_businessStudiobox1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
                     if  (studioNameUpdateTxt1.getText().isEmpty()|| (employeeTxt1.getText().isEmpty())){
        JOptionPane.showMessageDialog(this, "Put the studio required data");
    }
           else{
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            StudiosService service =(StudiosService) theRegistry.lookup("stu");
            Studios theStudio = new Studios(Integer.parseInt(searchStuinTxt.getText()));
            
            theStudio.setStudioName(studioNameUpdateTxt1.getText());
            theStudio.setEmployees(employeeTxt1.getText());
            theStudio.setBusiness((BusinessUnits) businessStudiobox1.getSelectedItem());
           
            
            Studios stuObj = service.UpdateStudios(theStudio);
//            
            if(stuObj!=null){
                JOptionPane.showMessageDialog(this, "Studio Updated");
                addRowDataCompany();
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Studio not Updated");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
                     }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                           if(  ! passwordStudio.getText().equals("24155")){
                 JOptionPane.showMessageDialog(this, "Put the correct Password for delete data");
             }
       else {
           if (searchStuinTxt.getText().isEmpty() ){
        JOptionPane.showMessageDialog(this, "Put the Studio ID then click on the search button");
    }
           else{
            try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            StudiosService service =(StudiosService) theRegistry.lookup("stu");
            Studios theStudio = new Studios(Integer.parseInt(searchStuinTxt.getText()));
           
            
            Studios stuObj = service.DeleteStudios(theStudio);
//            
            if(stuObj!=null){
                JOptionPane.showMessageDialog(this, "Studio Deleted");
                searchStuinTxt.setText("");
                studioNameUpdateTxt1.setText("");
                employeeTxt1.setText("");
                addRowDataCompany();
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Studio not deleted");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BttnSearchLicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnSearchLicenceActionPerformed
                    if ( (searchLicenceTxt.getText().isEmpty()) ){
        JOptionPane.showMessageDialog(this, "Put the Licence ID");
    }
           else{
        
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            LicenceService service =(LicenceService) theRegistry.lookup("lice");
            Licence theLicence = new Licence(Integer.parseInt(searchLicenceTxt.getText()));
            Licence liceObj = service.SearchLicence(theLicence);

            if(liceObj!=null){
                licenceComboBox1.setSelectedItem(liceObj.getLicence_name());
                studioLicenceBox.setSelectedItem(liceObj.getStudios());
          
            }else{
                JOptionPane.showMessageDialog(this, "Data Not Found");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
 }
    }//GEN-LAST:event_BttnSearchLicenceActionPerformed

    private void updateBttnLicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBttnLicenceActionPerformed
                         if  (searchLicenceTxt.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Put the business required data");
    }
           else{
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            LicenceService service =(LicenceService) theRegistry.lookup("lice");
            Licence theLicence = new Licence(Integer.parseInt(searchLicenceTxt.getText()));
            
            theLicence.setLicence_name((String) licenceComboBox1.getSelectedItem());
            theLicence.setStudios((Studios) studioLicenceBox.getSelectedItem());
           
            
            Licence liceObj = service.UpdateLicence(theLicence);
//            
            if(liceObj!=null){
                JOptionPane.showMessageDialog(this, "Licence Updated");
              
       addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Licence not Updated");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
    }//GEN-LAST:event_updateBttnLicenceActionPerformed

    private void deleteBttnLicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBttnLicenceActionPerformed
                              if(  ! passwordLicence.getText().equals("24155")){
                 JOptionPane.showMessageDialog(this, "Put the correct Password for delete data");
             }
       else {
           if (searchLicenceTxt.getText().isEmpty() ){
        JOptionPane.showMessageDialog(this, "Put the Licence ID then click on the search button");
    }
           else{
            try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            LicenceService service =(LicenceService) theRegistry.lookup("lice");
            Licence theLicence = new Licence(Integer.parseInt(searchLicenceTxt.getText()));
           
            
            Licence liceObj = service.DeleteLicence(theLicence);
//            
            if(liceObj!=null){
                JOptionPane.showMessageDialog(this, "Licence Deleted");
                searchLicenceTxt.setText("");
                addRowDataCompany();
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
        
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Licence not deleted");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
       }
    }//GEN-LAST:event_deleteBttnLicenceActionPerformed

    private void licenceSearchBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenceSearchBttnActionPerformed
                            if ( (searchGameTxt.getText().isEmpty()) ){
        JOptionPane.showMessageDialog(this, "Put the Game ID");
    }
           else{
        
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            GamesService service =(GamesService) theRegistry.lookup("game");
            Games theGmae = new Games(Integer.parseInt(searchGameTxt.getText()));
            Games gameObj = service.SearchGames(theGmae);

            if(gameObj!=null){
                gameNameUpdate.setText(gameObj.getGameName());
                studioGameUpdate.setSelectedItem(gameObj.getStudios());
          
            }else{
                JOptionPane.showMessageDialog(this, "Data Not Found");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
 }
    }//GEN-LAST:event_licenceSearchBttnActionPerformed

    private void updateLicenceBttn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateLicenceBttn1ActionPerformed
                               if  (searchGameTxt.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Put the game required data");
    }
           else{
        try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            GamesService service =(GamesService) theRegistry.lookup("game");
            Games theGame = new Games(Integer.parseInt(searchGameTxt.getText()));
            
            theGame.setStudios((Studios) studioGameUpdate.getSelectedItem());
            
           
            
            Games gameObj = service.UpdateGames(theGame);
//            
            if(gameObj!=null){
                JOptionPane.showMessageDialog(this, "Game Updated");
               addRowDataCompany();
        addComboItemBusines();
        addComboItemStudio ();
        addComboItemDirector ();
        addComboItemLicence ();
       
        addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Game not Updated");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
    }//GEN-LAST:event_updateLicenceBttn1ActionPerformed

    private void updateLicenceBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateLicenceBttnActionPerformed
                                    if(  ! passwordGame.getText().equals("24155")){
                 JOptionPane.showMessageDialog(this, "Put the correct Password for delete data");
             }
       else {
           if (searchGameTxt.getText().isEmpty() ){
        JOptionPane.showMessageDialog(this, "Put the Game ID then click on the search button");
    }
           else{
            try{
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1",5000);
            GamesService service =(GamesService) theRegistry.lookup("game");
            Games theGame = new Games(Integer.parseInt(searchGameTxt.getText()));
           
            
            Games gameObj = service.DeleteGames(theGame);
//            
            if(gameObj!=null){
                JOptionPane.showMessageDialog(this, "Game Deleted");
              gameNameUpdate.setText("");
              searchGameTxt.setText("");
              addRowDataCompany();
        addRowDataBusiness();
        addRowDataStudios();
        addRowDataLicence();
        addRowDataGame();
        addRowDataDirector();
            }else{
                JOptionPane.showMessageDialog(this, "Game not deleted");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
       }
    }//GEN-LAST:event_updateLicenceBttnActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    try {
                        new MainMenu().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BttnSearchLicence;
    private javax.swing.JButton BttnSearchStudio;
    private javax.swing.JComboBox<Studios> Studiobox3;
    private javax.swing.JComboBox<BusinessUnits> businessStudiobox;
    private javax.swing.JComboBox<BusinessUnits> businessStudiobox1;
    private javax.swing.JTable businessTable;
    private Components.MyTextField businessUnitUpdateTxt1;
    private Components.MyTextField businessnameTxt;
    private Components.MyTextField compIndusrtyTxt;
    private Components.MyTextField compNameTxt;
    private javax.swing.JTable compTable;
    private javax.swing.JComboBox<Company> companyBox3;
    private javax.swing.JComboBox<Company> companyBusiBox2;
    private Components.MyTextField companyUpdateNameTxt;
    private Components.MyTextField contactTxt;
    private Components.MyTextField contactTxt1;
    private com.toedter.calendar.JDateChooser creationDate;
    private javax.swing.JButton deleteBttnDirector;
    private javax.swing.JButton deleteBttnLicence;
    private javax.swing.JButton deleteCompanyBttn;
    private javax.swing.JComboBox<Director> directorBox1;
    private javax.swing.JComboBox<Director> directorCompanyBox;
    private Components.MyTextField directorName;
    private javax.swing.JTable directorTable;
    private Components.MyTextField dirnameTxt;
    private Components.MyTextField employeeTxt;
    private Components.MyTextField employeeTxt1;
    private com.toedter.calendar.JDateChooser foundedDate;
    private com.toedter.calendar.JDateChooser foundedDate1;
    private com.toedter.calendar.JDateChooser foundedDatestudio;
    private Components.MyTextField gameName;
    private Components.MyTextField gameNameUpdate;
    private javax.swing.JTable gameTable;
    private javax.swing.JButton imaged;
    private javax.swing.JLabel imageliber;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<Studios> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private Components.MyTextField leiTxt;
    private Components.MyTextField leiUpdateTxt;
    private javax.swing.JComboBox<Licence> licenceComboBox1;
    private javax.swing.JComboBox<Licence> licenceGameBox;
    private Components.MyTextField licenceName;
    private javax.swing.JButton licenceSearchBttn;
    private javax.swing.JTable licenceTable;
    private Components.MyPasswordField myPasswordField3;
    private Components.MyPasswordField passwordBusiness;
    private Components.MyPasswordField passwordCompanyTxt;
    private Components.MyPasswordField passwordGame;
    private Components.MyPasswordField passwordLicence;
    private Components.MyPasswordField passwordStudio;
    private javax.swing.JTextField photoname;
    private com.toedter.calendar.JDateChooser publishingDate;
    private javax.swing.JButton recordGame;
    private javax.swing.JButton recordlicenceBttn;
    private javax.swing.JButton recordstudio;
    private javax.swing.JButton searchBttnBusiness;
    private javax.swing.JButton searchBttnCompany;
    private Components.MyTextField searchBusinessTxt;
    private Components.MyTextField searchCompanyTxt;
    private Components.MyTextField searchGameTxt;
    private Components.MyTextField searchId;
    private Components.MyTextField searchLicenceTxt;
    private Components.MyTextField searchStuinTxt;
    private javax.swing.JComboBox<Studios> studioGameUpdate;
    private javax.swing.JComboBox<Studios> studioLicenceBox;
    private Components.MyTextField studioNameUpdateTxt1;
    private javax.swing.JTable studioTable;
    private Components.MyTextField studionameTxt;
    private Components.MyTextField typegame;
    private javax.swing.JButton updateBttnLicence;
    private javax.swing.JButton updateCompanyButton;
    private javax.swing.JButton updateDirector;
    private javax.swing.JButton updateLicenceBttn;
    private javax.swing.JButton updateLicenceBttn1;
    // End of variables declaration//GEN-END:variables
private void labelcolor(JLabel label){
    label.setBackground(new java.awt.Color(255,0,0));
}
private void resetcolor(JLabel label){
    label.setBackground(new java.awt.Color(255,255,255));
}

private void labelcolor(JPanel panel){
    panel.setBackground(new java.awt.Color(255,0,0));
}
private void resetcolor(JPanel panel){
    panel.setBackground(new java.awt.Color(240,240,240));
}
}

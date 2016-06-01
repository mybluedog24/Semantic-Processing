package semanticprocessing;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * The GUI controller of the program.
 * @author Moody, Hussam
 */
public class GUI extends JFrame {

    /** The header for the column of the URL Table. */
    private final String[] urlHeader = {"URL", "Cached"};
    /** The model that controls the URLs table. */
    private DefaultTableModel urlModel = new DefaultTableModel(null,
            urlHeader);
    /** The headers for the columns of the Results table. */
    private final String[] resultHeaders = {"URL"};
    /** The model that controls the Results table. */
    private DefaultTableModel resultModel = new DefaultTableModel(null,
            resultHeaders);
    /** The current Search object. */
    private Search search;
    /** The window that controls the upkeep of the ignored words. */
    private IgnoreWordsWindow igWin;

    /** Creates the GUI form and initializes its child UI.*/
    public GUI() {
        setTitle("Semantic Processing");
        initComponents();
        igWin = new IgnoreWordsWindow();
        Cache cache = new Cache();
        search = new Search(cache, "", "");
        // This ensures the user is prompted to store search before closing.
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    /**
     * Updates the results table. Searches if there are no results, otherwise
     * just retrieves the last results.
     */
    private void updateResultsTable() {
        resultModel = new DefaultTableModel(null, resultHeaders);
        int i = 1;
        for (Result res : search.getResults()) {
            String s = i + ". " + res.getPage().getMainURL();
            Object[] rowData = {s};
            resultModel.addRow(rowData);
            i++;
        }
        listOfResults.setModel(resultModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        URLTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOfURLs = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }}
            ;
            urlTextField = new javax.swing.JTextField();
            addURLButton = new javax.swing.JButton();
            selectAllButton = new javax.swing.JButton();
            deleteFromList = new javax.swing.JButton();
            importURLsButton = new javax.swing.JButton();
            enterParagraph = new javax.swing.JButton();
            searchTab = new javax.swing.JPanel();
            searchLabel = new javax.swing.JLabel();
            jScrollPane2 = new javax.swing.JScrollPane();
            probStateTextArea = new javax.swing.JTextArea();
            ignoreWordsBox = new javax.swing.JCheckBox();
            searchURLsButton = new javax.swing.JButton();
            importSearchButton = new javax.swing.JButton();
            editIgWords = new javax.swing.JButton();
            resultTab = new javax.swing.JPanel();
            searchInfoLabel = new javax.swing.JLabel();
            jScrollPane3 = new javax.swing.JScrollPane();
            listOfResults = new javax.swing.JTable() {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;   //Disallow the editing of any cell
                }}
                ;
                hideSelectedButton = new javax.swing.JButton();
                showHiddenButton = new javax.swing.JButton();
                menuBar = new javax.swing.JMenuBar();
                fileMenu = new javax.swing.JMenu();
                newSearchMenuItem = new javax.swing.JMenuItem();
                jMenuItem2 = new javax.swing.JMenuItem();
                jMenuItem1 = new javax.swing.JMenuItem();
                exitOptionMenuItem = new javax.swing.JMenuItem();
                helpMenu = new javax.swing.JMenu();
                openHelpMenuItem = new javax.swing.JMenuItem();

                jTabbedPane4.addTab("tab1", jTabbedPane5);

                jButton2.setText("jButton2");

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent evt) {
                        formWindowClosing(evt);
                    }
                    public void windowOpened(java.awt.event.WindowEvent evt) {
                        formWindowOpened(evt);
                    }
                });

                listOfURLs.setModel(urlModel);
                jScrollPane1.setViewportView(listOfURLs);

                urlTextField.setText("http://");
                urlTextField.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        urlTextFieldKeyPressed(evt);
                    }
                });

                addURLButton.setText("Add URL to List");
                addURLButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        addURLButtonMouseReleased(evt);
                    }
                });

                selectAllButton.setText("Select All");
                selectAllButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        selectAllButtonMouseReleased(evt);
                    }
                });

                deleteFromList.setText("Delete from List");
                deleteFromList.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        deleteFromListMouseReleased(evt);
                    }
                });

                importURLsButton.setText("Import URLs from File...");
                importURLsButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        importURLsButtonMouseReleased(evt);
                    }
                });

                enterParagraph.setText("Enter Paragraph");
                enterParagraph.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        enterParagraphMouseReleased(evt);
                    }
                });

                javax.swing.GroupLayout URLTabLayout = new javax.swing.GroupLayout(URLTab);
                URLTab.setLayout(URLTabLayout);
                URLTabLayout.setHorizontalGroup(
                    URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(URLTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(URLTabLayout.createSequentialGroup()
                                .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, URLTabLayout.createSequentialGroup()
                                        .addComponent(urlTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(addURLButton))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, URLTabLayout.createSequentialGroup()
                                        .addComponent(selectAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addGap(126, 126, 126)
                                        .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(enterParagraph, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(URLTabLayout.createSequentialGroup()
                                                .addGap(153, 153, 153)
                                                .addComponent(importURLsButton)))))
                                .addContainerGap())
                            .addGroup(URLTabLayout.createSequentialGroup()
                                .addComponent(deleteFromList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(471, 471, 471))))
                );
                URLTabLayout.setVerticalGroup(
                    URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(URLTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addURLButton))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(importURLsButton)
                            .addComponent(selectAllButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteFromList)
                            .addComponent(enterParagraph))
                        .addContainerGap(14, Short.MAX_VALUE))
                );

                jTabbedPane1.addTab("Enter URLs", URLTab);

                searchLabel.setText("Copy out your problem statement in the follow area, or import from file:");

                probStateTextArea.setColumns(20);
                probStateTextArea.setFont(new java.awt.Font("Arial", 0, 13));
                probStateTextArea.setLineWrap(true);
                probStateTextArea.setRows(5);
                jScrollPane2.setViewportView(probStateTextArea);

                ignoreWordsBox.setSelected(true);
                ignoreWordsBox.setText("Use Ignore Words");
                ignoreWordsBox.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        ignoreWordsBoxMouseReleased(evt);
                    }
                });

                searchURLsButton.setText("Search URLs");
                searchURLsButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        searchURLsButtonMouseReleased(evt);
                    }
                });

                importSearchButton.setText("Import from File...");
                importSearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        importSearchButtonMouseReleased(evt);
                    }
                });

                editIgWords.setText("Edit Ignore Words");
                editIgWords.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        editIgWordsMouseReleased(evt);
                    }
                });

                javax.swing.GroupLayout searchTabLayout = new javax.swing.GroupLayout(searchTab);
                searchTab.setLayout(searchTabLayout);
                searchTabLayout.setHorizontalGroup(
                    searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                            .addComponent(searchLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchTabLayout.createSequentialGroup()
                                .addComponent(ignoreWordsBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editIgWords)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                                .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(searchURLsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(importSearchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                );
                searchTabLayout.setVerticalGroup(
                    searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(importSearchButton)
                            .addComponent(ignoreWordsBox)
                            .addComponent(editIgWords))
                        .addGap(23, 23, 23)
                        .addComponent(searchURLsButton)
                        .addGap(21, 21, 21))
                );

                jTabbedPane1.addTab("Searching", searchTab);

                searchInfoLabel.setText("A search of the cache of URL's yielded the following results of professors:");

                listOfResults.setModel(resultModel);
                jScrollPane3.setViewportView(listOfResults);

                hideSelectedButton.setText("Hide Selected");
                hideSelectedButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        hideSelectedButtonMouseReleased(evt);
                    }
                });

                showHiddenButton.setText("Show Hidden");
                showHiddenButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        showHiddenButtonMouseReleased(evt);
                    }
                });

                javax.swing.GroupLayout resultTabLayout = new javax.swing.GroupLayout(resultTab);
                resultTab.setLayout(resultTabLayout);
                resultTabLayout.setHorizontalGroup(
                    resultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resultTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(resultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                            .addComponent(searchInfoLabel)
                            .addGroup(resultTabLayout.createSequentialGroup()
                                .addComponent(hideSelectedButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showHiddenButton)))
                        .addContainerGap())
                );
                resultTabLayout.setVerticalGroup(
                    resultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resultTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchInfoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(resultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hideSelectedButton)
                            .addComponent(showHiddenButton))
                        .addContainerGap())
                );

                jTabbedPane1.addTab("Results", resultTab);

                fileMenu.setText("File");

                newSearchMenuItem.setText("New Search");
                newSearchMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        newSearchMenuItemMouseReleased(evt);
                    }
                });
                fileMenu.add(newSearchMenuItem);

                jMenuItem2.setText("Import Cache");
                jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        jMenuItem2MouseReleased(evt);
                    }
                });
                fileMenu.add(jMenuItem2);

                jMenuItem1.setText("Export Cache");
                jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        jMenuItem1MouseReleased(evt);
                    }
                });
                fileMenu.add(jMenuItem1);

                exitOptionMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
                exitOptionMenuItem.setText("Exit");
                exitOptionMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseReleased(java.awt.event.MouseEvent evt) {
                        exitOptionMenuItemMouseReleased(evt);
                    }
                });
                fileMenu.add(exitOptionMenuItem);

                menuBar.add(fileMenu);

                helpMenu.setText("Help");

                openHelpMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
                openHelpMenuItem.setText("Open Help Menu");
                openHelpMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        openHelpMenuItemMousePressed(evt);
                    }
                });
                helpMenu.add(openHelpMenuItem);

                menuBar.add(helpMenu);

                setJMenuBar(menuBar);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                );

                pack();
            }// </editor-fold>//GEN-END:initComponents

    /** END OF NETBEANS CODE **************************** */
    /**
     * Allows the user to press Enter in order to enter his URL, as opposed to
     * clicking the "Add to URL List" button. Simple functionality.
     * @param evt The key event as defined by the user, the ENTER is retrieved
     * from this parameter.
     */
    private void urlTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urlTextFieldKeyPressed
        char key = evt.getKeyChar();
        if (key == KeyEvent.VK_ENTER) {
            validateAndAddURL(this.urlTextField.getText(), true);
        }

    }//GEN-LAST:event_urlTextFieldKeyPressed

    /**
     * Functionality for Menu Bars. Opens the help file under Help.
     * @param evt The mouse event specified by the user.
     */
    private void openHelpMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openHelpMenuItemMousePressed
        try {
            // open the userguide.pdf
            Desktop d = java.awt.Desktop.getDesktop();
            d.open(new java.io.File("UserGuideWhole.pdf"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Invalid directory", "ERROR", 0);
        }

    }//GEN-LAST:event_openHelpMenuItemMousePressed

    /**
     * The course of action taken by pressing "Import URLs from File..".
     * Will prompt the user with a JFileChooser to select the file that contains
     * a list of URLs to be read into the program.
     * @param evt The mouse event specified by the user.
     */
    private void importURLsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importURLsButtonMouseReleased
        JFileChooser file = new JFileChooser();
        int openFile = file.showOpenDialog(null);

        //PUTTING URLS IN urlTextField
        if (openFile == JFileChooser.APPROVE_OPTION) {
            File urlFile = file.getSelectedFile();
            try {
                ArrayList<String> urlList =
                        FileOps.readURLsFromFile(urlFile);
                boolean aURLhasBeenAdded = false;
                for (String url : urlList) {
                    boolean currentURLValid = validateAndAddURL(url, false);
                    aURLhasBeenAdded = aURLhasBeenAdded || currentURLValid;
                }
                if (!aURLhasBeenAdded) {
                    JOptionPane.showMessageDialog(this, "No valid URLs found "
                            + "in the selected file.", "NOTICE",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(URLTab,
                        "Cannot read given file.", "NOTICE",
                        JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_importURLsButtonMouseReleased
    /**
     * The course of action the be taken upon pressing "Add URL to List". It
     * will only be added if it is valid, and not already contained in the list.
     * @param evt The mouse event specified by the user.
     */
    private void addURLButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addURLButtonMouseReleased
        validateAndAddURL(this.urlTextField.getText(), true);
    }

    /**
     * Adds the URL in URL text field to cache and table.
     * @param url The URL string to validate and add.
     * @param displayMessage true displays error messages to the user if the
     * given URL is invalid. false does not.
     * @return true iff URL is validated (not necessarily added). The case
     * where its validated but not added is if it already exists in list.
     */
    private boolean validateAndAddURL(
            final String url, final boolean displayMessage) {
        boolean error = false;
        if (!url.startsWith("http://")) {
            error = true;
        } else {
            try {
                // Validation
                URI uri = new URI(url);
                URL urlObject = new URL(url);
                addURL(urlObject);
            } catch (MalformedURLException e) {
                error = true;
            } catch (URISyntaxException ex) {
                error = true;
            }
        }
        if (error && displayMessage) {
            JOptionPane.showMessageDialog(URLTab, "Please enter a valid URL.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return !error;
    }//GEN-LAST:event_addURLButtonMouseReleased

    /**
     * The course of action to be taken upon pressing "Select All". This will
     * change the "Select" button back and from "Deselect" accordingly.
     * @param evt The mouse action specified by the user.
     */
    private void selectAllButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectAllButtonMouseReleased
        if (selectAllButton.getText().equals("Select All")) {
            listOfURLs.selectAll();
            selectAllButton.setText("Deselect All");
        } else {
            listOfURLs.clearSelection();
            selectAllButton.setText("Select All");
        }
    }//GEN-LAST:event_selectAllButtonMouseReleased

    /**
     * The course of action to be taken upon the pressing of "Delete from
     * List". Will delete all of the selected URLs.
     *  @param evt The user-entered action event.
     */
    private void deleteFromListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteFromListMouseReleased
        int rowNums = listOfURLs.getSelectedRows().length;
        for (int i = 0; i < rowNums; i++) {
            search.cache.remove((URL) urlModel.getValueAt(
                    listOfURLs.getSelectedRow(), 0));
            urlModel.removeRow(listOfURLs.getSelectedRow());
        }
    }//GEN-LAST:event_deleteFromListMouseReleased

    /**
     * The course of action to be taken upon a the pressing of "Import Search"
     * button. Prompts the user with a JFileChooser to choose a file, and
     * copies text from the file, to the correct TextArea.
     *  @param evt The user-entered action event.
     */
    private void importSearchButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importSearchButtonMouseReleased
        JFileChooser file = new JFileChooser();
        int openFile = file.showOpenDialog(null);

        if (openFile == JFileChooser.APPROVE_OPTION) {
            File parFile = file.getSelectedFile();
            try {
                String newFile = FileOps.readFile(parFile);
                probStateTextArea.append(newFile);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "File does not Exist",
                        "NOTICE", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_importSearchButtonMouseReleased

    /**
     * The course of action to be taken upon checking the "Ignore Words"
     * check box. Opens a new window, IgnoreWordsWindow, that allows the user
     * to define the words they wish to ignore.
     * @param evt The user-entered action event.
     */
    private void ignoreWordsBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ignoreWordsBoxMouseReleased
        if (ignoreWordsBox.isSelected()) {
            igWin.setVisible(true);
        }
    }//GEN-LAST:event_ignoreWordsBoxMouseReleased

    /**
     * Returns true iff the input is valid before searching. Valid input means
     * the search text box is non-empty and at least one URL has been added.
     * @return true iff the input is valid.
     */
    private boolean isInputValid() {
        // The expression is for invalid input, so we negate it
        return !(probStateTextArea.getText().replaceAll("\\s*|\n", "").
                equals("")
                || (search.cache.getPendingURLs().isEmpty()
                && search.cache.getCachedURLs().isEmpty()));

    }

    /**
     * The course of action to be taken upon a the pressing of "Search URLs".
     * Creates a new search using the information available to the GUI: The list
     * of URLs, the Problem Statement.
     *  @param evt The user-entered action event.
     */
    private void searchURLsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchURLsButtonMouseReleased
        // Get ignored words
        String ignored;
        if (ignoreWordsBox.isSelected()) {
            ignored = igWin.getIgnoredWords();
        } else {
            ignored = "";
        }
        String problem = probStateTextArea.getText();
        if (!isInputValid()) {
            JOptionPane.showMessageDialog(rootPane, "The URL list is empty or "
                    + "the Problem statement is empty", "ERROR", 0);
            return;
        }
        // Change cursor to waiting.
        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        // Generating cache is the slowest part.
        search.cache.generateCache();
        search = new Search(search.cache, problem, ignored);
        resultModel = new DefaultTableModel(null, resultHeaders);
        listOfResults.setModel(resultModel);

        //Update URL Table
        updateURLTable();

        // Display results
        search.search();
        search.getResults();
        this.updateResultsTable();
        this.jTabbedPane1.setSelectedIndex(2);

        // Return cursor to normal
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_searchURLsButtonMouseReleased
    /**
     * Occurs when editIgWords is pressed; this function displays the window
     * containing the words to be ignored (there are some words in that window
     * by default).
     * @param evt Event invoked by user.
     */
    private void editIgWordsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editIgWordsMouseReleased
        igWin.setVisible(true);
    }//GEN-LAST:event_editIgWordsMouseReleased

    /**
     * This function switches from URL tab to Searching tab.
     * @param evt Event invoked by user.
     */
    private void enterParagraphMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterParagraphMouseReleased
        this.jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_enterParagraphMouseReleased

    private void newSearchMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newSearchMenuItemMouseReleased
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you "
                + "want to create a "
                + "new search? This will clear the paragraph and the results,"
                + " and reset the ignored words to their default values.",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            this.igWin = new IgnoreWordsWindow();
            search = new Search(search.cache, "", igWin.getIgnoredWords());
            this.probStateTextArea.setText("");
            resultModel = new DefaultTableModel(null,
                    resultHeaders);
            this.listOfResults.setModel(resultModel);
        }
    }//GEN-LAST:event_newSearchMenuItemMouseReleased

    /**
     * Occurs when import cache is pressed.
     * @param evt Event invoked by user.
     */
    private void jMenuItem2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseReleased
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Cache files, .cache", "cache");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            try {
                search.cache = FileOps.loadCache(f);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File does not Exist",
                        "NOTICE", JOptionPane.WARNING_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Unable to read file. "
                        + "Please make sure it is a valid file and that "
                        + "you have read access to it.",
                        "NOTICE", JOptionPane.WARNING_MESSAGE);
            } catch (InvalidFileException ex) {
                JOptionPane.showMessageDialog(this, "The given file is not a "
                        + "valid cache file.", "NOTICE",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        updateURLTable();
    }//GEN-LAST:event_jMenuItem2MouseReleased

    /**
     * Occurs when exportCache is pressed.
     * @param evt Event invoked by user.
     */
    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        // Initialize JFile chooser.
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Cache files, .cache", "cache");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showSaveDialog(this);

        // If a file is selected, save to it
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // Get path. JFileChooser is bugged and doesn't return extension.
            String path = fileChooser.getSelectedFile().toString();
            if (!path.endsWith(".cache")) {
                path += ".cache";
            }
            File f = new File(path);

            // Save to file.
            try {
                FileOps.saveCache(search.cache, f);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Unable to read file. "
                        + "Please make sure you have read access to the "
                        + "selected file.", "NOTICE",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItem1MouseReleased

    /**
     * Hides the selected rows.
     * @param evt The event that triggered this action.
     */
    private void hideSelectedButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideSelectedButtonMouseReleased
        int rowNums = listOfResults.getSelectedRows().length;
        for (int i = 0; i < rowNums; i++) {
            resultModel.removeRow(listOfResults.getSelectedRow());
        }
    }//GEN-LAST:event_hideSelectedButtonMouseReleased

    /**
     * Displays the hidden rows.
     * @param evt The event that triggered this action.
     */
    private void showHiddenButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHiddenButtonMouseReleased
        updateResultsTable();
    }//GEN-LAST:event_showHiddenButtonMouseReleased

    /**
     * This function asks the user if he wants to save his search or not and
     * acts according to the user's reply and finally exits the program.
     * @param evt Event invoked by user.
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int response = JOptionPane.showConfirmDialog(null, "Would you like "
                + "to save your search?", "Save your search?",
                JOptionPane.YES_NO_CANCEL_OPTION);
        switch (response) {
            case JOptionPane.YES_OPTION:
                try {
                    search = new Search(search.cache,
                            probStateTextArea.getText(),
                            this.igWin.getIgnoredWords(),
                            search.getResults());
                    FileOps.saveSearch(search, new File(
                            FileOps.CURRENT_DIRECTORY
                            + "data.search"));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ""
                            + "Unable to write to current "
                            + "location.", "Error", JOptionPane.OK_OPTION);
                }

                System.exit(0);
            case JOptionPane.NO_OPTION:
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                File save = new File(FileOps.CURRENT_DIRECTORY
                        + "data.search");
                save.delete();
                System.exit(0);
            default:
            // Do nothing otherwise.
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * This function basically loads the last saved search(complete search i.e.
     * problem statement, result and list of URLs) from a file and also catches
     * exception if the file is invalid.
     * @param evt Event invoked by user.
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            search = FileOps.loadSearch(new File(FileOps.CURRENT_DIRECTORY
                    + "data.search"));
            updateURLTable();
            updateResultsTable();
            probStateTextArea.setText(search.getProblemStatement());
            igWin = new IgnoreWordsWindow(search.getIgnoredWordsString());
        } catch (IOException ex) {
            // Do nothing if an error occurs.
        } catch (InvalidFileException ex) {
            // Do nothing if an error occurs.
        }
    }//GEN-LAST:event_formWindowOpened

    private void exitOptionMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitOptionMenuItemMouseReleased
        this.formWindowClosing(null);
}//GEN-LAST:event_exitOptionMenuItemMouseReleased

    /**
     * The program entry point.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel URLTab;
    private javax.swing.JButton addURLButton;
    private javax.swing.JButton deleteFromList;
    private javax.swing.JButton editIgWords;
    private javax.swing.JButton enterParagraph;
    private javax.swing.JMenuItem exitOptionMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton hideSelectedButton;
    private javax.swing.JCheckBox ignoreWordsBox;
    private javax.swing.JButton importSearchButton;
    private javax.swing.JButton importURLsButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable listOfResults;
    private javax.swing.JTable listOfURLs;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newSearchMenuItem;
    private javax.swing.JMenuItem openHelpMenuItem;
    private javax.swing.JTextArea probStateTextArea;
    private javax.swing.JPanel resultTab;
    private javax.swing.JLabel searchInfoLabel;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchTab;
    private javax.swing.JButton searchURLsButton;
    private javax.swing.JButton selectAllButton;
    private javax.swing.JButton showHiddenButton;
    private javax.swing.JTextField urlTextField;
    // End of variables declaration//GEN-END:variables

    /**
     * Adds the given URL to cache and to the URLs table only it is not
     * already in cache.
     * @param url The URL to add.
     */
    private void addURL(final URL url) {
        if (!search.cache.add(url)) {
            JOptionPane.showMessageDialog(URLTab, url.toString()
                    + " has already been queued.");
        } else {
            int cacheStatus = search.cache.isCached(url);
            String status = "";
            if (cacheStatus == Cache.CACHED) {
                status = "Cached";
            } else if (cacheStatus == Cache.PENDING) {
                status = "Pending";
            } else {
                status = "Not Cached";
            }
            urlModel.addRow(new Object[]{url, status});
        }
    }

    /**
     * Updates the URL table with the URLs in cache.
     */
    private void updateURLTable() {
        urlModel = new DefaultTableModel(null,
                urlHeader);
        for (URL url : search.cache.getCachedURLs()) {
            urlModel.addRow(new Object[]{url, "Cached"});
        }
        for (URL url : search.cache.getPendingURLs()) {
            urlModel.addRow(new Object[]{url, "Pending"});
        }
        for (URL url : search.cache.getInvalidURLs()) {
            urlModel.addRow(new Object[]{url, "Error"});
        }
        listOfURLs.setModel(urlModel);
    }
}

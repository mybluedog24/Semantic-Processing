/*
 * The window on which ignored words are entered.
 */
package semanticprocessing;

/**
 * The Ignore Words window to show when prompted for.
 * @author Moody
 */
public class IgnoreWordsWindow extends javax.swing.JFrame {

    /** The string that contains the current ignored words. */
    private String wordsToIgnore;
    /** The default list of ignored words. */
    private final String defaultIgnoredWords =
            "a able about above abroad according accordingly across actually"
            + "adj after afterwards again against ago ahead ain't all allow "
            + "allows almost alone along alongside already also although "
            + "always am amid amidst among amongst an and another any anybody "
            + "anyhow anyone anything anyway anyways anywhere apart appear "
            + "appreciate appropriate are aren't around as a's aside ask "
            + "asking associated at available away awfully back backward "
            + "backwards be became because become becomes becoming been "
            + "before beforehand begin behind being believe below beside "
            + "besides best better between beyond both brief but by came "
            + "can cannot cant can't caption cause causes certain certainly "
            + "changes clearly c'mon co co. com come comes completely "
            + "concerning consequently consider considering contain "
            + "containing contains corresponding could couldn't course "
            + "c's currently dare daren't decrease decreasingly definitely "
            + "described despite did didn't different directly do does "
            + "doesn't doing done don't down downwards during each eg "
            + "eight eighty either else elsewhere end ending enough entirely "
            + "especially et etc even ever evermore every everybody everyone "
            + "everything everywhere ex exactly example except "
            + "fairly far farther few fewer fifth first firstly five followed "
            + "following follows for forever former formerly forth forward "
            + "found four from further furthermore get gets getting given "
            + "gives go goes going gone got gotten greetings had hadn't half "
            + "happens hardly has hasn't have haven't having he he'd he'll "
            + "hello help hence her here hereafter hereby herein here's "
            + "hereupon hers herself he's hi him himself his hither hopefully "
            + "how howbeit however hundred i i'd ie if ignored i'll i'm "
            + "immediate in inasmuch inc increase increasingly indeed "
            + "indicate indicated indicates inner inside insofar instead "
            + "into inward is isn't it it'd it'll its it's itself i've just "
            + " keep keeps kept know known knows last lastly lately later "
            + "latter latterly least less lest let let's like liked likely "
            + "likewise little look looking looks low lower ltd made main "
            + "mainly make makes many may maybe mayn't me mean meantime "
            + "meanwhile merely might mightn't mine minus miss more moreover "
            + "most mostly mr mrs ms much must mustn't my myself name namely "
            + "nd near nearly necessary need needn't needs neither never "
            + "never neverless nevertheless new next nine ninety no nobody "
            + "non none nonetheless noone no-one nor normally not nothing "
            + "notwithstanding novel now nowhere obviously of off often oh "
            + "ok okay old on once one ones one's only onto opposite or "
            + "other others otherwise ought oughtn't our ours ourselves "
            + "out outside over overall own particular particularly past "
            + "per perfectly perhaps placed please plus possible presumably "
            + "probably provided provides que quick quickly quite qv rather "
            + "rd re really reasonably recent recently regarding regardless "
            + "regards relatively respectively right round said same saw say "
            + "saying says second secondly see seeing seem seemed seeming "
            + "seems seen self selves sensible sent serious seriously seven "
            + "several shall shan't she she'd she'll she's should shouldn't "
            + "since six so some somebody someday somehow someone something "
            + "sometime sometimes somewhat somewhere soon sorry specified "
            + "specify specifying still sub such sup sure surely "
            + "take taken taking tell tends th than thank thanks thanx that "
            + "that'll thats that's that've the their theirs them themselves "
            + "then thence there thereafter thereby there'd therefore therein "
            + "there'll there're theres there's thereupon there've these they "
            + "they'd they'll they're they've thing things think third thirty "
            + "this thorough thoroughly those though three thrice through "
            + "throughout thru thus thusly till to together too took toward "
            + "towards tried tries truly try trying t's twice two un under "
            + "underneath undoing unfortunately unless unlike unlikely until "
            + "unto up upon upwards us use used useful uses using usually "
            + "utterly value various versus very via viz vs want wants was "
            + "wasn't way we we'd welcome well we'll went were we're weren't "
            + "we've what whatever what'll what's what've when whence whenever "
            + "where whereafter whereas whereby wherein where's whereupon "
            + "wherever whether which whichever while whilst whither who "
            + "who'd whoever whole wholly who'll whom whomever who's whose "
            + "why will willing wish with within without wonder wondered "
            + "wondering won't worst would wouldn't yes yet you you'd you'll "
            + "your you're yours yourself yourselves you've zero";

    /** Creates new form IgnoreWordsWindow. */
    public IgnoreWordsWindow() {
        initComponents();
        wordsToIgnore = defaultIgnoredWords;
        ignoredWordsTA.setText(this.defaultIgnoredWords);
    }

    /**
     * A constructor to create an instance of this GUI, with the given ignored
     * words.
     * @param igWords the ignored words to start with.
     */
    public IgnoreWordsWindow(final String igWords) {
        initComponents();
        wordsToIgnore = igWords;
        ignoredWordsTA.setText(igWords);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ignoredWordsTA = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ignoredWordsTA.setColumns(20);
        ignoredWordsTA.setRows(5);
        jScrollPane1.setViewportView(ignoredWordsTA);

        jLabel1.setText("These words will not be included in the search");

        cancelButton.setText("Cancel");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelButtonMouseReleased(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                saveButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseReleased
        wordsToIgnore = ignoredWordsTA.getText();
        this.dispose();
    }//GEN-LAST:event_saveButtonMouseReleased

    private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
        ignoredWordsTA.setText(wordsToIgnore);
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseReleased

    /**
     * The main function.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new IgnoreWordsWindow().setVisible(true);
            }
        });
    }
    //GENERATED VARIABLE DECLARATION
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextArea ignoredWordsTA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
    //END OF GENERATED VARIABLE DECLARATION

    /**
     * Returns a String of the ignored words entered by the user.
     * @return An String of ignored words as indicated by user.
     */
    public final String getIgnoredWords() {
        if (this.wordsToIgnore == null) {
            return "";
        }
        return wordsToIgnore;
    }
}

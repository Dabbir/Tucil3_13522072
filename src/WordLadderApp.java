/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.util.List;

import algorithms.AStar;
import algorithms.Algorithm;
import algorithms.GreedyBFS;
import algorithms.UCS;
import dictionary.Dictionary;
import nodes.Nodes;
import nodes.Nodes.Node;
import error.Error;

public class WordLadderApp extends javax.swing.JFrame {
  public WordLadderApp() {
    initComponents();
  }

  private void initComponents() {

    panelRoot = new javax.swing.JPanel();
    panelInput = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    titleLabel = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    startLabel = new javax.swing.JLabel();
    startInput = new javax.swing.JTextField();
    endInput = new javax.swing.JTextField();
    algorithmLabel = new javax.swing.JLabel();
    algorithmsComboBox = new javax.swing.JComboBox<>();
    dictionaryComboBox = new javax.swing.JComboBox<>();
    solveButton = new javax.swing.JButton();
    endLabel = new javax.swing.JLabel();
    dictionaryLabel = new javax.swing.JLabel();
    panelResult = new javax.swing.JPanel();
    resultLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    resultTextArea = new javax.swing.JTextArea();
    timeLabel = new javax.swing.JLabel();
    pathLabel = new javax.swing.JLabel();
    nodeLabel = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    panelRoot.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    panelRoot.setLayout(new java.awt.BorderLayout());

    panelInput.setBackground(new java.awt.Color(21, 25, 28));
    panelInput.setPreferredSize(new java.awt.Dimension(500, 100));

    jPanel1.setBackground(new java.awt.Color(21, 25, 28));
    jPanel1.setPreferredSize(new java.awt.Dimension(500, 181));

    titleLabel.setFont(new java.awt.Font("Algerian", 3, 48));
    titleLabel.setForeground(new java.awt.Color(255, 255, 255));
    titleLabel.setText("WORD LADDER");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(titleLabel)
                .addContainerGap(88, Short.MAX_VALUE)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(26, 26, 26)));

    panelInput.add(jPanel1);

    jPanel2.setBackground(new java.awt.Color(21, 25, 28));
    jPanel2.setPreferredSize(new java.awt.Dimension(500, 400));

    startLabel.setForeground(new java.awt.Color(255, 255, 255));
    startLabel.setText("Start Word");

    algorithmLabel.setForeground(new java.awt.Color(255, 255, 255));
    algorithmLabel.setText("Algorithm");

    algorithmsComboBox
        .setModel(
            new javax.swing.DefaultComboBoxModel<>(new String[] { "Uniform Cost Search", "Greedy Best-First Search",
                "A* Search" }));
    algorithmsComboBox.setToolTipText("");

    dictionaryComboBox
        .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "dictionary.txt", "dictionary2.txt" }));

    solveButton.setBackground(new java.awt.Color(34, 40, 44));
    solveButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
    solveButton.setForeground(new java.awt.Color(255, 255, 255));
    solveButton.setText("Solve");
    solveButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        solveWordLadder();
      }
    });

    endLabel.setForeground(new java.awt.Color(255, 255, 255));
    endLabel.setText("End Word");

    dictionaryLabel.setForeground(new java.awt.Color(255, 255, 255));
    dictionaryLabel.setText("Dictionary");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(solveButton, javax.swing.GroupLayout.Alignment.TRAILING,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endInput, javax.swing.GroupLayout.PREFERRED_SIZE, 319,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startInput, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(startLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(algorithmLabel, javax.swing.GroupLayout.Alignment.LEADING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(algorithmsComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 155,
                                Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dictionaryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dictionaryLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(endLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE))
                .addContainerGap(98, Short.MAX_VALUE)));

    jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { startInput, startLabel });

    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(startLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(endLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algorithmLabel)
                    .addComponent(dictionaryLabel))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algorithmsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dictionaryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(solveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE)));

    panelInput.add(jPanel2);

    panelRoot.add(panelInput, java.awt.BorderLayout.WEST);

    panelResult.setBackground(new java.awt.Color(34, 40, 44));

    resultLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18));
    resultLabel.setForeground(new java.awt.Color(255, 255, 255));
    resultLabel.setText("Result");

    resultTextArea.setBackground(new java.awt.Color(44, 52, 58));
    resultTextArea.setColumns(20);
    resultTextArea.setRows(5);
    jScrollPane1.setViewportView(resultTextArea);

    timeLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 16));
    timeLabel.setForeground(new java.awt.Color(255, 255, 255));
    timeLabel.setText("Time: ");

    pathLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 16));
    pathLabel.setForeground(new java.awt.Color(255, 255, 255));
    pathLabel.setText("Path Found:");

    nodeLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 16));
    nodeLabel.setForeground(new java.awt.Color(255, 255, 255));
    nodeLabel.setText("Nodes Explored:");

    javax.swing.GroupLayout panelResultLayout = new javax.swing.GroupLayout(panelResult);
    panelResult.setLayout(panelResultLayout);
    panelResultLayout.setHorizontalGroup(
        panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResultLayout.createSequentialGroup()
                        .addComponent(pathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(nodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226,
                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap()));
    panelResultLayout.setVerticalGroup(
        panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE)));

    panelRoot.add(panelResult, java.awt.BorderLayout.CENTER);

    getContentPane().add(panelRoot, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>

  private void solveWordLadder() {
    String startWord = startInput.getText().trim();
    String endWord = endInput.getText().trim();
    String selectedAlgorithm = (String) algorithmsComboBox.getSelectedItem();
    String selectedDictionary = (String) dictionaryComboBox.getSelectedItem();

    // validation
    if (startWord.isEmpty() || endWord.isEmpty()) {
      Error.showErrorPopup("Input cannot be empty!");
      return;
    }

    if (startWord.length() != endWord.length()) {
      Error.showErrorPopup("Start word and end word must have the same length!");
      return;
    }

    // Panggil metode untuk mencari solusi Word Ladder berdasarkan algoritma dan
    // dictionary yang dipilih
    long startTime = System.currentTimeMillis();
    List<String> ladder = findWordLadder(startWord.toUpperCase(), endWord.toUpperCase(), selectedAlgorithm,
        selectedDictionary);
    long endTime = System.currentTimeMillis();

    // Tampilkan hasil di resultTextArea
    // Menghapus isi sebelumnya
    resultTextArea.setText("");
    resultTextArea.setFont(new java.awt.Font("Segoe UI Black", 0, 18));
    resultTextArea.setForeground(new java.awt.Color(255, 255, 255));
    if (ladder != null) {
      for (String word : ladder) {
        resultTextArea.append(word + "\n");
      }
      pathLabel.setText("Paths Found: " + (ladder.size() - 1));
      timeLabel.setText("Time: " + (endTime - startTime) + "ms");
      nodeLabel.setText("Nodes Explored: " + Algorithm.nodesExplored);
    } else {
      resultTextArea.append("No solution found or word not in dictionary.");
      pathLabel.setText("Path found: 0 steps");
      timeLabel.setText("Time taken: N/A");
      nodeLabel.setText("Nodes Explored: " + Algorithm.nodesExplored);
    }
    Algorithm.nodesExplored = 0;
  }

  private List<String> findWordLadder(String startWord, String endWord, String selectedAlgorithm,
      String selectedDictionary) {
    // Implementasi algoritma Word Ladder berdasarkan algoritma dan dictionary yang
    // dipilih di sini
    // Return null jika tidak ada solusi ditemukan
    if (selectedAlgorithm.equals("Uniform Cost Search")) {
      // Panggil algoritma Uniform Cost Search
      UCS ucs = new UCS("src/dictionary/" + selectedDictionary);
      Nodes nodes = new Nodes(startWord);
      Node start = nodes.getRoot();
      Dictionary dictionary = new Dictionary("src/dictionary/" + selectedDictionary, startWord);
      nodes = new Nodes(endWord);
      Node target = nodes.getRoot();
      List<String> ladder = ucs.findPath(start, target, dictionary);
      return ladder;
    } else if (selectedAlgorithm.equals("Greedy Best-First Search")) {
      // Panggil algoritma Greedy Best-First Search
      GreedyBFS greedyBFS = new GreedyBFS("src/dictionary/" + selectedDictionary);
      Nodes nodes = new Nodes(startWord);
      Node start = nodes.getRoot();
      Dictionary dictionary = new Dictionary("src/dictionary/" + selectedDictionary, startWord);
      nodes = new Nodes(endWord);
      Node target = nodes.getRoot();
      List<String> ladder = greedyBFS.findPath(start, target, dictionary);
      return ladder;
    } else if (selectedAlgorithm.equals("A* Search")) {
      // Panggil algoritma A* Search
      AStar aStar = new AStar("src/dictionary/" + selectedDictionary);
      Nodes nodes = new Nodes(startWord);
      Node start = nodes.getRoot();
      Dictionary dictionary = new Dictionary("src/dictionary/" + selectedDictionary, startWord);
      nodes = new Nodes(endWord);
      Node target = nodes.getRoot();
      List<String> ladder = aStar.findPath(start, target, dictionary);
      return ladder;
    }
    return null;
  }

  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the default
     * look and feel.
     * For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(WordLadderApp.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(WordLadderApp.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(WordLadderApp.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(WordLadderApp.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new WordLadderApp().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton solveButton;
  private javax.swing.JComboBox<String> algorithmsComboBox;
  private javax.swing.JComboBox<String> dictionaryComboBox;
  private javax.swing.JLabel titleLabel;
  private javax.swing.JLabel startLabel;
  private javax.swing.JLabel endLabel;
  private javax.swing.JLabel algorithmLabel;
  private javax.swing.JLabel dictionaryLabel;
  private javax.swing.JLabel resultLabel;
  private javax.swing.JLabel timeLabel;
  private javax.swing.JLabel pathLabel;
  private javax.swing.JLabel nodeLabel;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea resultTextArea;
  private javax.swing.JTextField startInput;
  private javax.swing.JTextField endInput;
  private javax.swing.JPanel panelInput;
  private javax.swing.JPanel panelResult;
  private javax.swing.JPanel panelRoot;
  // End of variables declaration//GEN-END:variables
}

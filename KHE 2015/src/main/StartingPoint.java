package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StartingPoint implements Runnable {

private static final long serialVersionUID = 1L;
	
	//displaying the output of the tools
	public static BufferedReader reader;
	public static JTextArea display;
	public static Tools theTools = new Tools();
	public static JScrollPane toolPane = new JScrollPane(theTools.area);
	
	//the tools
		public static String[] tools = {"Tools", "----------", "SysinternalsSuite/PsInfo.exe", "SysinternalsSuite/PsGetsid.exe", "SysinternalsSuite/pslist.exe",
			"SysinternalsSuite/PsLoggedon.exe", "SysinternalsSuite/psloglist.exe", "SysinternalsSuite/PsService.exe", "SysinternalsSuite/Listdlls.exe", "SysinternalsSuite/logonsessions.exe",
			"SysinternalsSuite/diskext.exe", "SysinternalsSuite/handle.exe", "SysinternalsSuite/ntfsinfo.exe", "SysinternalsSuite/efsdump.exe", "----------", "PythonScripts/hashFinder.py", 
			"----------", "Perl/test2.pl"};
	
	//main stuff
	public static JPanel mainPanel = new JPanel();
	public static CardLayout mainLayout = new CardLayout();
	public static JPanel northPanel = new JPanel();
	
	//help
	public static BorderLayout helpLayoutMain = new BorderLayout();
	public static GridLayout helpLayoutCenter = new GridLayout(10, 1, 0, 0);
	public static JPanel helpPanel = new JPanel();
	public static JPanel helpCenterPanel = new JPanel();
	public static JButton helpButton = new JButton("Help");
	public static JButton helpBackButton = new JButton("Back");
	public static JLabel help1 = new JLabel("Help");
	public static JLabel help2 = new JLabel("PsInfo - ");
	public static JLabel help3 = new JLabel("");
	
	//home panel stuff
	public static BorderLayout homeLayout = new BorderLayout();
	public static JPanel homePanel = new JPanel();
	//stuff to run the tools
	public static JButton runButton = new JButton("Run");
	public static JComboBox<String> box = new JComboBox<String>(tools);
	public static JList<String> toolsList = new JList<String>(box.getModel());
	
	//hash finder stuff
	public static JPanel hashPanel = new JPanel();
	public static JLabel hashLabel1 = new JLabel("hashFinder");
	public static JLabel hashLabel2 = new JLabel("Enter the location to the file:");
	public static JTextField hashField = new JTextField();
	public static JButton hashButton = new JButton("Find");
	public static GridLayout hashLayout = new GridLayout(15, 1, 0, 0);
	
	//options panels
	public static GridLayout  optionsLayout = new GridLayout(15, 1, 0, 0);
	//ntfsinfo
	public static JPanel ntfsPanel = new JPanel();
	public static JLabel ntfsLabel1 = new JLabel("ntfsinfo");
	public static JLabel ntfsLabel2 = new JLabel("Enter the drive letter:");
	public static JTextField ntfsField = new JTextField();
	public static JButton ntfsButton = new JButton("Run");
	//efsdump
	public static JPanel efsPanel = new JPanel();
	public static String[] efsOptions = {"Options", "----------", "-s", "-q"};
	public static JLabel efsLabel1 = new JLabel("efsdump");
	public static JLabel efsLabel2 = new JLabel("Enter an option:");
	public static JLabel efsLabel3 = new JLabel("-s Recurse subdirectories");
	public static JLabel efsLabel4 = new JLabel("-q Don't print errors (Quiet)");
	public static JComboBox<String> efsBox = new JComboBox<String>(efsOptions);
	public static JList<String> efsOpList = new JList<String>(efsBox.getModel());
	public static JButton efsButton = new JButton("Run");
	
	private StartingPoint(JTextArea display, PipedOutputStream pOutputStream) {
        this.display = display;

        try {
            PipedInputStream pInputStream = new PipedInputStream(pOutputStream);
            reader = new BufferedReader(new InputStreamReader(pInputStream));
        } catch(IOException e) {}
    }

	public static void rdirectOut(JTextArea display) {
        PipedOutputStream pOutputStream = new PipedOutputStream();
        System.setOut(new PrintStream(pOutputStream, true));

        StartingPoint start = new StartingPoint(display, pOutputStream);
        new Thread(start).start();
    }

	public static void directOut(JTextArea display){
        StartingPoint.rdirectOut(display);
    }

	public static void main(String[] args) {
        JFrame frame = new JFrame("Sysinternals Suite GUI");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.add(mainPanel);
        
        mainPanel.setLayout(mainLayout);
        mainPanel.add(homePanel, "1");
        mainPanel.add(hashPanel, "2");
        mainPanel.add(ntfsPanel, "3");
        mainPanel.add(efsPanel, "4");
        mainPanel.add(helpPanel, "5");
        mainLayout.show(mainPanel, "1");
        
        homePanel.setLayout(homeLayout);
        homePanel.add(northPanel, BorderLayout.NORTH);
        homePanel.add(toolPane, BorderLayout.CENTER);
        homePanel.add(runButton, BorderLayout.SOUTH);

        northPanel.add(box);
        northPanel.add(helpButton);
        
        helpPanel.setLayout(helpLayoutMain);
        helpPanel.add(help1, BorderLayout.NORTH);
        helpPanel.add(helpCenterPanel, BorderLayout.CENTER);
        helpPanel.add(helpBackButton, BorderLayout.SOUTH);
        helpCenterPanel.setLayout(helpLayoutCenter);
        helpCenterPanel.add(help2);
        
        hashPanel.setLayout(hashLayout);
        hashPanel.add(hashLabel1);
        hashPanel.add(hashLabel2);
        hashPanel.add(hashField);
        hashPanel.add(hashButton);
        
        ntfsPanel.setLayout(optionsLayout);
        ntfsPanel.add(ntfsLabel1);
        ntfsPanel.add(ntfsLabel2);
        ntfsPanel.add(ntfsField);
        ntfsPanel.add(ntfsButton);
        
        efsPanel.setLayout(optionsLayout);
        efsPanel.add(efsLabel1);
        efsPanel.add(efsLabel2);
        efsPanel.add(efsLabel3);
        efsPanel.add(efsLabel4);
        efsPanel.add(efsBox);
        efsPanel.add(efsButton);
   
        runTool();
        runHelp();
        runNtfs();
        runEfs();
        runHelp();
    }
	
	public static void runTool() {
		runButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String select = (String)box.getSelectedItem();
				if(select == "SysinternalsSuite/PsInfo.exe") {
					theTools.psInfo();
				} else if(select == "SysinternalsSuite/PsGetsid.exe") {
					theTools.psGetsid();
				} else if(select == "SysinternalsSuite/pslist.exe") {
					theTools.pslist();
				} else if(select == "SysinternalsSuite/PsLoggedon.exe") {
					theTools.PsLoggedon();
				} else if(select == "SysinternalsSuite/psloglist.exe") {
					theTools.psloglist();
				} else if(select == "SysinternalsSuite/PsService.exe") {
					theTools.PsService();
				} else if(select == "SysinternalsSuite/Listdlls.exe") {
					theTools.listdlls();
				} else if(select == "SysinternalsSuite/logonsessions.exe") {
					theTools.logonsessions();
				} else if(select == "SysinternalsSuite/diskext.exe") {
					theTools.diskext();
				} else if(select == "SysinternalsSuite/handle.exe") {
					theTools.handle();
				} else if(select == "SysinternalsSuite/ntfsinfo.exe") {
					mainLayout.show(mainPanel, "3");
				} else if(select == "SysinternalsSuite/efsdump.exe") {
					mainLayout.show(mainPanel, "4");
				} else if(select == "Perl/test2.pl") {
					theTools.runPerl();
				} else if(select == "PythonScripts/hashFinder.py") {
					mainLayout.show(mainPanel, "2");
				}
			}
		});
	}
	
	public static void findHash() {
		hashButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainLayout.show(mainPanel, "1");
				StartingPoint.directOut(theTools.area);
				String findHash = hashField.getText();
				final int i = 0;
				
					try {
						ProcessBuilder pb = new ProcessBuilder("python", "PythonScripts/hashFinder.py", findHash);
						Process p = pb.start();
						BufferedReader mainReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
						
						String output = null;
				
						while((output = mainReader.readLine()) != null) {
							System.out.println(output);
						}	
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("YSomething went wrong.");
						e1.printStackTrace();
					}
			}
		});
	}
	
	public static void runNtfs() {
		ntfsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainLayout.show(mainPanel, "1");
				StartingPoint.directOut(theTools.area);
				String ntfsInfo = ntfsField.getText();
				final int i = 0;
				
					try {
						ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/ntfsinfo.exe", ntfsInfo);
						Process p = pb.start();
						BufferedReader mainReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
						
						String output = null;
				
						while((output = mainReader.readLine()) != null) {
							System.out.println(output);
						}	
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("Something went wrong.");
						e1.printStackTrace();
					}
			}
		});
	}
	
	public static void runEfs() {
		efsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String efsSelect = (String)efsBox.getSelectedItem();
				if(efsSelect == "-s") {
					mainLayout.show(mainPanel, "1");
					StartingPoint.directOut(theTools.area);
					final int i = 0;
					
						try {
							ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/efsdump.exe", "-s");
							pb.directory(new File("C:\\"));
							Process p = pb.start();
							BufferedReader mainReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
							
							String output = null;
							
							while((output = mainReader.readLine()) != null) {
								System.out.println(output);
							}	
							mainReader.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							System.out.println("Something went wrong.");
							e1.printStackTrace();
						}
				} else if(efsSelect == "-q") {
					mainLayout.show(mainPanel, "1");
					StartingPoint.directOut(theTools.area);
					final int i = 0;
					
						try {
							ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/efsdump.exe", "-q");
							pb.directory(new File("C:\\"));
							Process p = pb.start();
							BufferedReader mainReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
							
							String output = null;
							
							while((output = mainReader.readLine()) != null) {
								System.out.println(output);
							}	
							mainReader.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							System.out.println("Something went wrong.");
							e1.printStackTrace();
						}
				}
			}
		});
	}
	
	public void run() {
        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                display.append( line + "\n" );
                display.setCaretPosition(display.getDocument().getLength());
            }

            System.err.println("Somethings wrong");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }
	
	public static void runHelp() {
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainLayout.show(mainPanel, "5");
			}
		});
		
		helpBackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainLayout.show(mainPanel, "1");
			}
		});
	}
}

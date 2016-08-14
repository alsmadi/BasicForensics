package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

public class Tools {

	public static JTextArea area = new JTextArea();

	public static void psInfo() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/PsInfo.exe");
				pb.directory(new File("C:\\"));
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
	
	public static void psGetsid() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/PsGetsid.exe");
				pb.directory(new File("C:\\"));
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
	
	public static void pslist() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/pslist.exe");
				pb.directory(new File("C:\\"));
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
	
	public static void PsLoggedon() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/PsLoggedon.exe");
				pb.directory(new File("C:\\"));
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
	
	public static void psloglist() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/psloglist.exe");
				pb.directory(new File("C:\\"));
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
	
	public static void PsService() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/PsService.exe");
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
	
	public static void listdlls() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/Listdlls.exe");
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
	
	public static void logonsessions() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/logonsessions.exe");
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
	
	public static void diskext() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/diskext.exe");
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
	
	public static void handle() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("SysinternalsSuite/handle.exe");
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
	
	public static void runPerl() {
		StartingPoint.directOut(area);
		final int i = 0;
		
			try {
				ProcessBuilder pb = new ProcessBuilder("perl", "Perl/test2.pl");
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
}

package spoonProject;


	import spoon.Launcher;
	import spoon.compiler.Environment;

	import java.io.*;
	import java.nio.file.FileSystems;
	import java.util.*;

	public class TraceInjectionApp {
	    private Scanner sc;

	    private StringBuilder menu;

	    public TraceInjectionApp() {
	        this.sc = new Scanner(System.in);
	        this.menu = new StringBuilder();
	        this.fillMenu();
	    }

	    private void fillMenu() {
	        this.menu.append("i : start logging intrumentalisation injection.\n");
	        this.menu.append("q : Quit.\n");
	    }

	    private void displayMenu() {
	        System.out.println("==============================  MENU  ==============================");
	        System.out.println(menu.toString());
	        System.out.println("====================================================================\n\n");
	    }

	    void run() {
	        boolean quit = false;
	        while (!quit) {
	            this.displayMenu();
	            System.err.print("choice : ");
	            String choice = this.sc.nextLine().trim();
	            switch (choice) {
	                case "i":
	                    this.transformMavenProject();
	                    break;
	               
	                case "q":
	                    quit = true;
	                    break;
	                default:
	                    System.err.println("Invalid option !");
	                    break;
	            }
	        }

	    }

	    private void transformMavenProject() {
	        String projectPath = "C:"+
	        		 FileSystems.getDefault().getSeparator()+
		                "Users"+
		                FileSystems.getDefault().getSeparator()+
		                "Mon Ordi"+
		                FileSystems.getDefault().getSeparator()+
		                "Downloads"+
		                FileSystems.getDefault().getSeparator()+
		                "tp3 (1)"+
	                FileSystems.getDefault().getSeparator()+
	                "tp3"+
	                FileSystems.getDefault().getSeparator()+
	                "src"+
	                FileSystems.getDefault().getSeparator()+
	                "main"+
	                FileSystems.getDefault().getSeparator()+
	                "java"+
	                FileSystems.getDefault().getSeparator()+
	                "com"+
	                FileSystems.getDefault().getSeparator()+
	                "example"+
	                FileSystems.getDefault().getSeparator()+
	                "tp3"+
	                FileSystems.getDefault().getSeparator();
	                

	        Launcher launcher = new Launcher();
	        launcher.addInputResource(projectPath);

	        Environment environment = launcher.getEnvironment();
	        environment.setNoClasspath(true);
	        environment.setComplianceLevel(11);
	        environment.setCommentEnabled(true);
	        environment.setAutoImports(true);

	        launcher.addProcessor(new Processor());
	        launcher.addProcessor(new MethodProcessor());

	        System.err.println("Start of transformation ...");
	        launcher.run();
	        System.err.println("... End of transformation.");
	    }

	    public static void main(String[] args) {
	        TraceInjectionApp app = new TraceInjectionApp();
	        app.run();
	    }
	}


	
	


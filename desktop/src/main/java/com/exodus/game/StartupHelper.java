package com.exodus.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Handles macOS specific startup requirements for LWJGL3.
 * On macOS, the JVM must be started with -XstartOnFirstThread argument.
 */
public class StartupHelper {
    public static boolean startNewJvmIfRequired() {
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            // Check if we're already running with -XstartOnFirstThread
            if (!Thread.currentThread().getName().equals("main")) {
                System.out.println("Starting new JVM with -XstartOnFirstThread");
                String javaHome = System.getProperty("java.home");
                String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
                String classpath = System.getProperty("java.class.path");
                String mainClass = System.getenv("JAVA_MAIN_CLASS_" + ProcessHandle.current().pid());
                
                ArrayList<String> command = new ArrayList<>();
                command.add(javaBin);
                command.add("-XstartOnFirstThread");
                command.add("-cp");
                command.add(classpath);
                command.add(mainClass);
                
                ProcessBuilder processBuilder = new ProcessBuilder(command);
                processBuilder.redirectErrorStream(true);
                try {
                    Process process = processBuilder.start();
                    BufferedReader processOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = processOutput.readLine()) != null) {
                        System.out.println(line);
                    }
                    process.waitFor();
                    System.exit(process.exitValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }
}

/*
 * Copyright 2020 damios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package biz.dvlop.exodus.launchers

import java.awt.GraphicsEnvironment
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.lang.management.ManagementFactory
import java.util.*

/**
 * Fixes HiDPI scaling for LWJGL3 on macOS and Windows.
 *
 * Simply add the following to your LWJGL3 application's main method:
 * ```
 * if (StartupHelper.startNewJvmIfRequired()) return; // This handles macOS support and helps on Windows.
 * ```
 *
 * **macOS:**
 * Starts a new JVM if the application was started on macOS without the
 * `-XstartOnFirstThread` argument.
 * This happens if the application is double-clicked in the Finder or
 * started without this argument on the command line.
 *
 * **Windows:**
 * Adds `-Dsun.java2d.dpiaware=true` for Windows VMs to avoid blurry windows
 * on HiDPI displays. This is equivalent to adding
 * ```
 * <awareness>system</awareness>
 * ```
 * to your Windows application manifest file.
 *
 * @author damios
 * @see <a href="https://github.com/crykn/guacamole/blob/master/gdx-desktop/src/main/java/de/damios/guacamole/gdx/StartupHelper.java">Original source</a>
 */
object StartupHelper {
    private const val JVM_RESTARTED_ARG = "jvmIsRestarted"

    /**
     * Starts a new JVM if required, passing the [JVM_RESTARTED_ARG] argument.
     * This happens when the application is started on macOS without the
     * `-XstartOnFirstThread` argument.
     *
     * @return whether a new JVM was started and thus no code should be executed
     */
    fun startNewJvmIfRequired(): Boolean {
        // Check for an already present argument
        val args = ManagementFactory.getRuntimeMXBean().inputArguments
        if (args.contains("-D$JVM_RESTARTED_ARG=true")) {
            // JVM was already restarted, continue with the execution
            return false
        }

        // If we're on the first run, start a new JVM if necessary
        if (System.getProperty("os.name").lowercase(Locale.ROOT).contains("mac")) {
            // macOS: check for XstartOnFirstThread
            if (!args.contains("-XstartOnFirstThread")) {
                // Restart with XstartOnFirstThread
                try {
                    restartJvmWithXstartOnFirstThread()
                    return true
                } catch (e: Throwable) {
                    e.printStackTrace()
                    System.err.println("Failed to restart JVM with -XstartOnFirstThread")
                }
            }
        } else if (System.getProperty("os.name").lowercase(Locale.ROOT).contains("windows")) {
            // Windows: add DPI awareness
            if (!args.contains("-Dsun.java2d.dpiaware=true") && !GraphicsEnvironment.isHeadless()) {
                System.setProperty("sun.java2d.dpiaware", "true")
            }
        }
        return false
    }

    /**
     * Restarts the current JVM with the -XstartOnFirstThread argument.
     * Also adds the [JVM_RESTARTED_ARG] to avoid infinite restarts.
     */
    private fun restartJvmWithXstartOnFirstThread() {
        val javaHome = System.getProperty("java.home")
        val javaBin = javaHome + File.separator + "bin" + File.separator + "java"

        // Get current JVM arguments
        val jvmArgs = ManagementFactory.getRuntimeMXBean().inputArguments
        val filteredArgs = jvmArgs.filter { !it.contains("agentlib") }

        // Build the command to start a new JVM
        val classpath = System.getProperty("java.class.path")
        val className = getMainClassName()
        val command = mutableListOf<String>()

        command.add(javaBin)
        command.add("-XstartOnFirstThread")
        command.add("-D$JVM_RESTARTED_ARG=true")
        command.addAll(filteredArgs)
        command.add("-cp")
        command.add(classpath)
        command.add(className)

        // Add the application arguments
        val appArgs = getApplicationArguments()
        if (appArgs.isNotEmpty()) {
            command.addAll(appArgs)
        }

        // Start the new JVM
        val processBuilder = ProcessBuilder(command)
        val process = processBuilder.start()

        // Redirect the process output to the console
        inheritIO(process.inputStream, System.out)
        inheritIO(process.errorStream, System.err)

        // Wait for the process to exit and use its exit code
        System.exit(process.waitFor())
    }

    /**
     * Gets the main class name by analyzing the stack trace.
     */
    private fun getMainClassName(): String {
        val stackTrace = Thread.currentThread().stackTrace
        val mainClassName = stackTrace.last().className

        // For Kotlin top-level functions, the class name ends with "Kt"
        return if (mainClassName.endsWith("Kt")) {
            // For Kotlin, we need to use the file name
            val fileName = mainClassName.substringBeforeLast("Kt")
            "$fileName"
        } else {
            mainClassName
        }
    }

    /**
     * Gets the application arguments that were passed to the main method.
     */
    private fun getApplicationArguments(): List<String> {
        // This is a simplified implementation
        // In a real application, you would need to capture the args from the main method
        return emptyList()
    }

    /**
     * Redirects the input stream to the output stream.
     */
    private fun inheritIO(input: java.io.InputStream, output: java.io.PrintStream) {
        Thread {
            val reader = BufferedReader(InputStreamReader(input))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                output.println(line)
            }
        }.start()
    }
}

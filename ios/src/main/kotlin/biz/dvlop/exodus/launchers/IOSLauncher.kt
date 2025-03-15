@file:JvmName("IOSLauncher")

package biz.dvlop.exodus.launchers

import org.robovm.apple.foundation.NSAutoreleasePool
import org.robovm.apple.uikit.UIApplication

import com.badlogic.gdx.backends.iosrobovm.IOSApplication
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration
import biz.dvlop.exodus.ExodusGame

/**
 * Launches the iOS (RoboVM) application with MetalANGLE backend for better performance.
 * MetalANGLE translates OpenGL calls to Metal, which is Apple's preferred graphics API.
 * This provides better performance and future-proofing as Apple has deprecated OpenGL.
 */
class IOSLauncher : IOSApplication.Delegate() {
    override fun createApplication(): IOSApplication {
        return IOSApplication(ExodusGame(), IOSApplicationConfiguration().apply {
            // Configure your application here.
            // Higher performance settings for iOS with MetalANGLE
            useAccelerometer = true
            useCompass = false

            // MetalANGLE configuration
            useGL30 = true // Enable OpenGL ES 3.0
            preferredFramesPerSecond = 60 // Can be set higher for Metal (e.g., 120 for ProMotion displays)
        })
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val pool = NSAutoreleasePool()
            val principalClass: Class<UIApplication>? = null
            val delegateClass = IOSLauncher::class.java
            UIApplication.main(args, principalClass, delegateClass)
            pool.close()
        }
    }
}

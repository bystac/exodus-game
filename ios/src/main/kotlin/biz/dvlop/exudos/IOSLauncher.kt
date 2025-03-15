@file:JvmName("IOSLauncher")

package biz.dvlop.exudos

import org.robovm.apple.foundation.NSAutoreleasePool
import org.robovm.apple.uikit.UIApplication

import com.badlogic.gdx.backends.iosrobovm.IOSApplication
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration
import biz.dvlop.exudos.Main

/** Launches the iOS (RoboVM) application with MetalANGLE backend for better performance. */
class IOSLauncher : IOSApplication.Delegate() {
    override fun createApplication(): IOSApplication {
        return IOSApplication(Main(), IOSApplicationConfiguration().apply {
            // Configure your application here.
            // Higher performance settings for iOS
            useAccelerometer = true
            useCompass = false

            // Use Metal-based rendering for better performance
            useGL30 = true // Enable OpenGL ES 3.0
            preferredFramesPerSecond = 60 // Can be set higher for Metal
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

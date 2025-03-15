# Exodus Game - libGDX with Kotlin Setup

This is a high-performance libGDX project using Kotlin, primarily targeting iOS with the MetalANGLE backend, and also supporting Android and desktop platforms.

## Project Structure

```
exodus-game/
├── android/               # Android module
│   ├── AndroidManifest.xml
│   ├── build.gradle
│   ├── res/
│   └── src/
├── core/                  # Core module (shared code)
│   ├── build.gradle
│   └── src/
├── desktop/               # Desktop module
│   ├── build.gradle
│   └── src/
├── ios/                   # iOS module with MetalANGLE
│   ├── build.gradle
│   ├── Info.plist.xml
│   └── src/
├── assets/                # Game assets (shared)
│   ├── audio/
│   ├── fonts/
│   ├── images/
│   ├── maps/
│   └── ui/
├── build.gradle           # Main build script
└── settings.gradle        # Project settings
```

## Key Features

- **Kotlin Language**: Modern, concise, and null-safe code
- **MetalANGLE for iOS**: Uses Metal instead of OpenGL for better performance on iOS
- **KTX Libraries**: Kotlin extensions for more idiomatic code
- **Cross-Platform**: Single codebase targeting iOS, Android, and desktop
- **Performance Optimized**: Configuration focused on achieving high performance

## Build and Run

### Prerequisites

- JDK 17 or newer
- Android SDK (for Android builds)
- Xcode and macOS (for iOS builds)
- Gradle (included wrapper)

### Desktop

```bash
./gradlew desktop:run
```

### Android

```bash
./gradlew android:installDebug android:run
```

### iOS

For iOS development, you need:
- macOS
- Xcode installed
- An Apple Developer account (for device deployment)

```bash
./gradlew ios:launchIPhoneSimulator
# or for device
./gradlew ios:launchIOSDevice
```

## Performance Optimization

This project is configured for high performance:

- **iOS**: Uses MetalANGLE backend instead of the standard RoboVM backend to leverage Metal instead of OpenGL
- **Android**: Configured to use OpenGL ES 3.0 where available
- **Desktop**: Uses LWJGL3 with optimal settings for modern hardware

## Extendability

The project is structured to be easily extendable:

- Add new screens by extending `KtxScreen`
- Cross-platform code goes in the `core` module
- Platform-specific optimizations can be added in respective modules
- Asset management is centralized in the `assets` directory

## Profiling and Debugging

For performance profiling:

- **iOS**: Use Xcode Instruments
- **Android**: Use Android Studio's profiler
- **Desktop**: Use VisualVM or Java Mission Control

## Credits

- [libGDX](https://libgdx.com/) - Game development framework
- [KTX](https://github.com/libktx/ktx) - Kotlin extensions for libGDX
- [MetalANGLE](https://github.com/kakashidinho/metalangle) - OpenGL to Metal translation layer

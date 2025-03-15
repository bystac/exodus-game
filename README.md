# Exodus - 40 years in the desert

Historical Adventure RPG

## Table of Contents

- [Technologies Used](#Technologies-Used)
- [Prerequisites](#Prerequisites)
- [Build and Run](#Build-and-Run)
- [Authors](#Authors)
- [Contributing](#Contributing)
- [License](#License)

### Technologies Used

- Kotlin
- libGDX
- MetalANGLE (iOS)
- KTX Libraries
- Gradle
- OpenGL ES 3.0
- LWJGL3 (Desktop)

### Prerequisites

- JDK 17 or newer
- Android SDK (for Android builds)
- Xcode and macOS (for iOS builds)
- Gradle (included wrapper)

### Build and Run

#### Desktop
```bash
./gradlew desktop:run
```

#### Android
```bash
./gradlew android:installDebug android:run
```

#### iOS
Requires macOS with Xcode installed and an Apple Developer account for device deployment.

```bash
# For Simulator
./gradlew ios:launchIPhoneSimulator

# For Device
./gradlew ios:launchIOSDevice
```

### Performance Features

- **iOS**: Uses MetalANGLE backend for optimal Metal-based rendering
- **Android**: OpenGL ES 3.0 support for enhanced graphics
- **Desktop**: LWJGL3 with optimized settings
- **Cross-Platform**: Single codebase targeting all platforms
- **KTX Extensions**: Idiomatic Kotlin code for better performance


[Up](#Table-of-Contents)

## 👤 Authors

- Lead Game Designer - Shachar Iphraimov
- Tech Team - Core Development (5 members)
  - Main loop (core gameplay mechanics)
  - Mod Engine/Dialogs (narrative engine, branching choices, allowing community-driven content, graphics?)
  - Script engine (quest logic, NPC behaviors)
  - UI/Styling (UX, animations, UI responsiveness)
  - Monetization (in-app purchases, ads, premium content)
- Creative Team - Art & Storytelling (6 members)
  - Lead Writer – Story, Lore, Dialogs
  - Writers squad - English speaking Yeshiva boys
  - Game Designer – Gameplay Mechanics, Level Design
  - UI/UX Designer – Interfaces, Menus, Styling
  - Environment/3D Artist OR 2D Illustrator (for world-building)
  - Animator/VFX Artist (for smooth animations and effects)
  - Sound & Music - outsoruced?
- Media & Marketing Team – Growth & Engagement (6 members)
  - Video Editor – Trailers & Social Media
  - Social Media Manager – Twitter, TikTok, Instagram
  - Graphic Designer – Marketing Creatives (Ads, Banners, Posters)
  - Copywriter & Content Strategist – Blogs, Newsletters, SEO
  - User Acquisition Specialist – Paid Ads (MMP, Singular, Appsflyer, Facebook, Google, TikTok, etc.)
  - Community Manager – Discord, Forums, Reddit, Twitch & Influencers
  - Affiliate Manager – Partnerships & Performance Marketing
- Operations Team – Business & Finance
  - Finance, HR, Admin, Legal Counsel

## 🤝 Contributing

Contributions, issues and feature requests are welcome! as logn as you agreed to license terms.

1. Fork it (https://github.com/bystac/exodus-game/fork)
2. Create your feature branch (git checkout -b my-new-feature)
3. Commit your changes (git commit -am 'Add some feature')
4. Push to the branch (git push origin my-new-feature)
5. Create a new Pull Request

## Show your support

If you enjoyed this project, a ⭐️ is always welcome.

## 📝 License

All rights reserved, Do not use in commercial projects and Do not steal content.
We intend once finished publish the games and start tolling revenue.

# Exodus Game Modding System

This directory contains all mods for the Exodus game, including the core game content and user-created modifications.

## Structure

```
mods/
  core/             # Core game content
    mod.yaml        # Mod metadata and configuration
    data/          # Game data organized by type
      characters/
      events/
      ...
  example_mod/      # Example mod showing structure
    mod.yaml
    data/
      ...
  your_mod/         # Your custom mod
    mod.yaml
    data/
      ...
```

## Creating a Mod

1. Create a new directory in `mods/`
2. Create a `mod.yaml` with required metadata:
   ```yaml
   mod_info:
     id: "your_mod_id"
     name: "Your Mod Name"
     version: "1.0.0"
     author: "Your Name"
     description: "Mod description"
     dependencies: ["core"]
     load_order: 100
   ```
3. Add content following the core structure

## Content Types

### Game Content
- **Characters**: NPCs, tribes, leaders
- **Locations**: Maps, camps, landmarks
- **Events**: Story events, random encounters
- **Items**: Resources, artifacts, equipment
- **Quests**: Mission chains, objectives
- **Traits**: Character attributes
- **Dialogs**: Conversations, choices

### Assets
- **Cutscenes**: Story sequences
- **UI**: Interface modifications
- **Audio**: Music, sound effects
- **Art**: Visual assets
- **Localization**: Translations

## Modding Rules

### File Format
- Use YAML for data files
- UTF-8 encoding for Hebrew support
- Follow core schemas for each content type

### Content Merging
- **extend**: Add new content (traits, events)
- **merge**: Combine with existing (mechanics)
- **override**: Replace entirely (UI themes)

### Best Practices
1. Test compatibility with core content
2. Document changes and requirements
3. Use descriptive IDs and names
4. Follow established schemas
5. Include proper translations

## Example Mod

See `example_mod/` for a complete example including:
- Mod configuration
- New traits and events
- UI customization
- Cutscene creation
- Localization

## Technical Details

### Load Order
1. Core mod (0)
2. Framework mods (1-99)
3. Content mods (100-999)
4. Overrides (1000+)

### Version Control
- Use semantic versioning
- List dependencies
- Specify compatibility range

### Asset Management
- Place assets in appropriate directories
- Use relative paths in definitions
- Follow naming conventions

## Debugging

To debug mod loading:
1. Check mod.yaml syntax
2. Verify dependencies
3. Confirm file paths
4. Review load order
5. Check error logs

## Support

For modding support:
- Read documentation in `/docs`
- Check example mod
- Join modding community
- Report issues on GitHub

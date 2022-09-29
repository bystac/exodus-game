import config from './config';

import BootScene from './scenes/boot';
import PreloaderScene from './scenes/preloader';
// import UserScene from './Scenes/UserScene';
// import TitleScene from './Scenes/TitleScene';
// import GameScene from './Scenes/GameScene';
// import OptionsScene from './Scenes/OptionsScene';
// import GameOverScene from './Scenes/GameOverScene';
// import VictoryScene from './Scenes/VictoryScene';
// import CreditsScene from './Scenes/CreditsScene';
import State from './state';

export default class Game extends Phaser.Game {

    constructor() {
        const gameConfig = {
            type : Phaser.AUTO,
            scale: {
                mode      : Phaser.Scale.FIT,
                parent    : 'exodus-game',
                autoCenter: Phaser.Scale.CENTER_BOTH,
                width     : 1024,
                height    : 712,
            },
            physics: {
                default: 'arcade',
                arcade : {
                    gravity: { y: 300 },
                    debug  : true,
                },
            },
        };

        super(gameConfig);

        const state = new State();
        this.globals = { state, bgMusic: null };

        this.scene.add('Boot', BootScene);
        this.scene.add('Preloader', PreloaderScene);
        // this.scene.add('Menu', MenuScene);
        // this.scene.add('CharacterSelection', UserScene);
        // this.scene.add('Title', TitleScene);
        // this.scene.add('Options', OptionsScene);
        // this.scene.add('Credits', CreditsScene);
        // this.scene.add('Game', GameScene);
        // this.scene.add('GameOver', GameOverScene);
        // this.scene.add('Victory', VictoryScene);
        console.log('before boot scene');
        this.scene.start('Boot');
    }
}

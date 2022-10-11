/* eslint-disable no-undef */
import 'phaser';

export default {
    type: Phaser.AUTO,
    parent: 'phaser-game',
    width: 800,
    height: 600,
    pixelArt: false,
    physics: {
        default: 'arcade',
        arcade: {
            gravity: { y: 0 },
            debug: false,
        },
    },
    dom: {
        createContainer: true,
    },
};

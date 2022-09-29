/* eslint-disable no-undef */
import 'phaser';

export default class BootScene extends Phaser.Scene {
    constructor() {
        super('Boot');
    }

    preload() {
        // Load images that we'll show in Preloader for the game
        this.load.image('crossing-sea', 'assets/art/The_Crossing_fo_The_Red_Sea.jpg');
        //this.load.image('background', 'assets/images/basicBack.png');
    }

    create() {
        // TODO in delay of 3s
        this.scene.start('Preloader');
    }
}

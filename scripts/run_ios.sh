#!/bin/bash

# Build and run iOS app
./gradlew ios:launchIPhoneSimulator

# ./gradlew :ios:launchIPhoneSimulator for iPhone simulator
# ./gradlew :ios:launchIPadSimulator for iPad simulator
# ./gradlew :ios:launchIOSDevice for a connected device
# ./gradlew :ios:createIPA to create an IPA file for distribution
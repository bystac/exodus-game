#!/bin/bash

# Run all tests
./gradlew test

# Print test results
echo "Test Results:"
find . -name "TEST-*.xml" -exec cat {} \;

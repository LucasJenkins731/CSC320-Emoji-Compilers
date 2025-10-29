#!/bin/bash

echo "=== Testing Emoticon Compiler Code Generation ==="
echo

# Test 1: Check if parsing works
echo "1. Testing parsing with antlr4-parse:"
echo "   Command: antlr4-parse Emoticon.g4 program -tree Examples/GoodExample3.calc"
echo "   Result:"
antlr4-parse Emoticon.g4 program -tree Examples/GoodExample3.calc 2>&1 | head -5
echo

# Test 2: Check grammar rules
echo "2. Checking grammar structure:"
echo "   Looking for code generation methods in grammar..."
grep -n "emit\|System.out\|generatePrint\|saveToFile" Emoticon.g4 | head -5
echo

# Test 3: Check what gets generated
echo "3. Testing if any output files are created:"
echo "   Before test:"
ls -la *.java | wc -l
echo "   Running a test that might generate code..."
# This would need a proper test runner

echo
echo "=== Recommendations ==="
echo "To properly test code generation, you need:"
echo "1. Download antlr-4.13.2-complete.jar"
echo "2. Compile your grammar with proper classpath"
echo "3. Create a test program that calls your parser with code generation enabled"
echo "4. Check if CalcitProgram.java gets generated"
echo "5. Try to compile and run the generated Java code"
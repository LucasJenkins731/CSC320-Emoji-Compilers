EMOTICON

by: Pierce Conway, Lucas Jenkins, and Connor Ryan


*Assuming antlr4 plugin, antlr4 tools, and the complete Jar are installed.

Run these commands in this order into your console

antlr4 Emoticon*.g4

javac -cp [jar file path] *.java

Now you're all set! 

antlr4-parse.exe Emoticon.g4 program -gui [Example file path]

This line creates a gui of the grammar. 

Alternatively if the gui does not load run this line instead

antlr4-parse.exe Emoticon.g4 program -tree [Example file path]
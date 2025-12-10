EMOTICON

by: Pierce Conway, Lucas Jenkins, and Connor Ryan


*Assuming antlr4 plugin, antlr4 tools, and the complete Jar are installed.

Run these commands in this order into your console

antlr4 Emoticon*.g4

javac -cp [jar file path] *.java

Now you're all set! 

To run a file into antlr and see all of its debug statements type this into the console

java -cp .;[jar file path] org.antlr.v4.gui.TestRig Emoticon program -gui [Example file path]

This line creates a gui of the grammar. 

Alternatively if the gui does not load run this line instead

java -cp .;[jar file path] org.antlr.v4.gui.TestRig Emoticon program -tree [Example file path]

this will display similar contents to the gui into the terminal 

Emoticon Cheat Sheet:
https://quinnipiacuniversity-my.sharepoint.com/:w:/g/personal/lgjenkins_quinnipiac_edu/EQX40YidXydMp9gg33d_NaYBfDYWCMoBeLag5HEhVlo5rA?e=BcfYGb

Commands to run code generation:
antlr4 Emoticon.g4

javac -cp “/filepath/antlr-4.13.2-complete.jar:." *.java

for windows: javac -cp “\filepath\antlr-4.13.2-complete.jar;." *.java

java -cp “/filepath/antlr-4.13.2-complete.jar:." TestDriver Examples/GoodExample3.calc

for windows: java -cp “\filepath\antlr-4.13.2-complete.jar;." TestDriver Examples/GoodExample3.calc
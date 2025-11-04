// Generated from Emoticon.g4 by ANTLR 4.13.2
 import java.util.*; import java.io.*; import org.antlr.v4.runtime.*; import org.antlr.v4.runtime.tree.*; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class EmoticonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, KW_READ=4, KW_PRINT=5, KW_IF=6, KW_ELSE=7, KW_ELSE_IF=8, 
		KW_FOR=9, KW_WHILE=10, KW_FUNCTION=11, KW_ARRAY=12, LBRACE=13, RBRACE=14, 
		KW_INT=15, KW_STRING=16, KW_CHAR=17, IDENT=18, ADD=19, SUBTRACT=20, MULTIPLY=21, 
		DIVIDE=22, INT=23, FLOAT=24, CHAR=25, STRING=26, WS=27, LPAREN=28, RPAREN=29, 
		COMMENT=30, COMMENT_BLOCK=31, COMPARISON=32, ASSIGNMENT=33;
	public static final int
		RULE_program = 0, RULE_s = 1, RULE_blockStatement = 2, RULE_as = 3, RULE_ps = 4, 
		RULE_expr = 5, RULE_term = 6, RULE_factor = 7, RULE_ifstmt = 8, RULE_elsestmt = 9, 
		RULE_forstmt = 10, RULE_whilestmt = 11, RULE_functionstmt = 12, RULE_functioncall = 13, 
		RULE_arraystmt = 14, RULE_operators = 15, RULE_comp = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "s", "blockStatement", "as", "ps", "expr", "term", "factor", 
			"ifstmt", "elsestmt", "forstmt", "whilestmt", "functionstmt", "functioncall", 
			"arraystmt", "operators", "comp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'['", "']'", "'-0-0-'", "':P'", "':)'", "':('", "':|'", 
			"'>:('", "'D:<'", "'=^._.^='", "'(o_o)'", "'><(((,^>'", "'<^,)))><'", 
			"'int'", "'string'", "'char'", null, "':+)'", "':-)'", "':*)'", "':/)'", 
			null, null, null, null, null, "'('", "')'", null, null, "':==)'", "':=)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", 
			"KW_FOR", "KW_WHILE", "KW_FUNCTION", "KW_ARRAY", "LBRACE", "RBRACE", 
			"KW_INT", "KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", "MULTIPLY", 
			"DIVIDE", "INT", "FLOAT", "CHAR", "STRING", "WS", "LPAREN", "RPAREN", 
			"COMMENT", "COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Emoticon.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	  enum Type {
	    INT, FLOAT, STRING, CHAR, UNKNOWN
	  }

	  class ExprResult {
	    Type type;
	    float numericalValue;
	    String stringValue;
	    boolean hasKnownValue;
	    String code;

	    ExprResult(){
	      hasKnownValue = false;
	    }

	  }

	  class Identifier {
	    String id;
	    Object value;
	    Type type;
	    boolean hasKnown;
	    boolean hasBeenUsed;
	  }

	  class SymbolTable {
	    Map<String, Identifier> table = new HashMap<>();
	  }
	  
	  class FunctionDef {
	    String name;
	    String paramName;
	    ParserRuleContext body;
	  }
	  
	  SymbolTable mainTable = new SymbolTable();
	  Stack<SymbolTable> symbolStack = new Stack<>();
	  Map<String, FunctionDef> functions = new HashMap<>();
	  
	  // Diagnostics
	  List<String> diagnostics = new ArrayList<>();

	  // for KW_READ in assignment
	  Scanner readInput = new Scanner(System.in);
	  
	  // Error tracking
	  boolean hasErrors = false;
	  
	  boolean definingFunction = false;
	  int functionDefDepth = 0;

	  void error(Token t, String msg) {
	    diagnostics.add("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + msg);
	    hasErrors = true;
	  }

	  int printDiagnostics() {    
	    if (!diagnostics.isEmpty()) {
	      for (String d : diagnostics) {
	        System.err.println(d);
	      }
	    }    
	    checkUnusedVariables();
	    return diagnostics.size();
	  }
	  
	  void checkUnusedVariables() {
	    boolean foundUnused = false;
	    
	    // Check main table
	    for (Map.Entry<String, Identifier> entry : mainTable.table.entrySet()) {
	      if (!entry.getValue().hasBeenUsed) {
	        if (!foundUnused) {
	          foundUnused = true;
	        }
	        System.err.println(entry.getKey() + " declared but never used");
	      }
	    }
	  }

	  Type typeCheck(String text) {
	    Type varType = Type.UNKNOWN;
	    if (text.matches("[+-]?(0|[1-9][0-9]*)")) {
	      varType = Type.INT;
	    } else if (text.matches("[+-]?(\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?")){
	      varType = Type.FLOAT;
	    } else if (text.matches("'(\\\\.|[^\\\\'])'")){
	      varType = Type.CHAR;
	    } else if (text.matches("(['\"']).*?(['\"])")) {
	      varType = Type.STRING;
	    }
	    return varType;
	  }

	  Identifier lookupVariable(String name) {
	    for (int i = symbolStack.size() - 1; i >= 0; i--) {
	      SymbolTable table = symbolStack.get(i);
	      if (table.table.containsKey(name)) {
	        return table.table.get(name);
	      }
	    }
	    
	    if (mainTable.table.containsKey(name)) {
	      return mainTable.table.get(name);
	    }
	    
	    return null;
	  }

	  // Add variable to the current scope
	  void addVariable(Identifier id) {
	    if (symbolStack.isEmpty()) {
	      mainTable.table.put(id.id, id);
	    } else {
	      SymbolTable currentScope = symbolStack.peek();
	      currentScope.table.put(id.id, id);
	    }
	  }

	  // Check if variable exists in current scope
	  boolean existsInCurrentScope(String name) {
	    if (symbolStack.isEmpty()) {
	      return mainTable.table.containsKey(name);
	    } else {
	      return symbolStack.peek().table.containsKey(name);
	    }
	  }

	  /** Code generation material */
	  StringBuilder sb = new StringBuilder(); // Stores the generated program!

	  void emit(String s) { sb.append(s); }   // Short-hand for adding to the program

	  // Emit the preamble material for our program
	  void openProgram() {
	    emit("import java.util.*;\n");
	    emit("public class EmoticonProgramTests {\n");
	    emit("  public static void main(String[] args) throws Exception {\n");
	    emit("    Scanner in = new Scanner(System.in);\n");
	  }

	  // Emit the postamble material for our program
	  void closeProgram() {
	    emit("  }\n");
	    emit("}\n");
	  }

	  // Declare LHS if first-time assignment; otherwise plain assignment.
	  void generateAssign(boolean declare, String name, String rhsJavaCode) {
	    emit("    " + (declare ? "double " : " ") + name + " = " + rhsJavaCode + ";\n");
	  }

	  // Write the generated Java to file.
	  void writeFile() {
	    try (PrintWriter pw = new PrintWriter("EmoticonProgramTests.java", "UTF-8")) {
	      pw.print(sb.toString());
	    } catch (Exception e) {
	      System.err.println("error: failed to write EmoticonProgramTests.java: " + e.getMessage());
	    }
	  }

	public EmoticonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(EmoticonParser.EOF, 0); }
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 openProgram(); 
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 394542688L) != 0)) {
				{
				{
				setState(35);
				s();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(EOF);

			      int numErrors = printDiagnostics();
			      if (numErrors == 0) {
			        // Successful, so write out the generated code
			        closeProgram();
			        writeFile();
			      } else {
			        System.err.println(numErrors + " errors detected. Code not generated.");
			        System.exit(1);  // Error code
			      }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SContext extends ParserRuleContext {
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public AsContext as() {
			return getRuleContext(AsContext.class,0);
		}
		public PsContext ps() {
			return getRuleContext(PsContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArraystmtContext arraystmt() {
			return getRuleContext(ArraystmtContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public ForstmtContext forstmt() {
			return getRuleContext(ForstmtContext.class,0);
		}
		public WhilestmtContext whilestmt() {
			return getRuleContext(WhilestmtContext.class,0);
		}
		public FunctionstmtContext functionstmt() {
			return getRuleContext(FunctionstmtContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitS(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(44);
				functioncall();
				}
				break;
			case 2:
				{
				setState(45);
				as();
				}
				break;
			case 3:
				{
				setState(46);
				ps();
				}
				break;
			case 4:
				{
				setState(47);
				expr();
				}
				break;
			case 5:
				{
				setState(48);
				arraystmt();
				}
				break;
			case 6:
				{
				setState(49);
				blockStatement();
				}
				break;
			case 7:
				{
				setState(50);
				ifstmt();
				}
				break;
			case 8:
				{
				setState(51);
				forstmt();
				}
				break;
			case 9:
				{
				setState(52);
				whilestmt();
				}
				break;
			case 10:
				{
				setState(53);
				functionstmt();
				}
				break;
			}

			    // No-op - child rules handle their own code emission
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public String code = "";
		public TerminalNode LBRACE() { return getToken(EmoticonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(EmoticonParser.RBRACE, 0); }
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitBlockStatement(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(LBRACE);
			  
			    if (definingFunction) {
			      functionDefDepth++;
			    }
			  
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 394542688L) != 0)) {
				{
				{
				setState(60);
				s();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(RBRACE);
			 
			    if (definingFunction) {
			      functionDefDepth--;
			    }
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsContext extends ParserRuleContext {
		public Token IDENT;
		public ExprContext expr;
		public Token INT;
		public Token STRING;
		public Token CHAR;
		public Token FLOAT;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(EmoticonParser.ASSIGNMENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
		public TerminalNode STRING() { return getToken(EmoticonParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(EmoticonParser.CHAR, 0); }
		public TerminalNode FLOAT() { return getToken(EmoticonParser.FLOAT, 0); }
		public TerminalNode KW_READ() { return getToken(EmoticonParser.KW_READ, 0); }
		public AsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitAs(this);
		}
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			((AsContext)_localctx).IDENT = match(IDENT);
			setState(70);
			match(ASSIGNMENT);
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(71);
				((AsContext)_localctx).expr = expr();

				        String id = ((AsContext)_localctx).IDENT.getText();
				        Identifier var = lookupVariable(id);
				        Identifier newId = new Identifier();
				        newId.id = id;
				        if(((AsContext)_localctx).expr.result.type == Type.INT || ((AsContext)_localctx).expr.result.type == Type.FLOAT){
				          newId.value = ((AsContext)_localctx).expr.result.numericalValue;
				        } else {
				          newId.value = ((AsContext)_localctx).expr.result.stringValue;
				        }
				        newId.type = ((AsContext)_localctx).expr.result.type;
				        System.out.println(id + " = " + String.valueOf(newId.value) + " (" + "Type = " + newId.type + ")");
				        newId.hasKnown = ((AsContext)_localctx).expr.result.hasKnownValue;
				        newId.hasBeenUsed = false;
				        addVariable(newId);
				        
				        // Generate Java code for assignment
				        boolean isNewVariable = (var == null);
				        generateAssign(isNewVariable, id, ((AsContext)_localctx).expr.result.code);
				      
				}
				break;
			case 2:
				{
				setState(74);
				((AsContext)_localctx).INT = match(INT);

				        Identifier newId = new Identifier();
				        newId.id = ((AsContext)_localctx).IDENT.getText();
				        newId.value = ((AsContext)_localctx).INT.getText();
				        newId.type = Type.INT;
				        addVariable(newId);
				        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
				        
				        // Generate Java code for assignment
				        generateAssign(true, newId.id, ((AsContext)_localctx).INT.getText());
				      
				}
				break;
			case 3:
				{
				setState(76);
				((AsContext)_localctx).STRING = match(STRING);

				        Identifier newId = new Identifier();
				        newId.id = ((AsContext)_localctx).IDENT.getText();
				        newId.value = ((AsContext)_localctx).STRING.getText();
				        newId.type = Type.STRING;
				        addVariable(newId);
				        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
				        
				        // Generate Java code for assignment
				        emit("    String " + newId.id + " = " + ((AsContext)_localctx).STRING.getText() + ";\n");
				      
				}
				break;
			case 4:
				{
				setState(78);
				((AsContext)_localctx).CHAR = match(CHAR);

				        Identifier newId = new Identifier();
				        newId.id = ((AsContext)_localctx).IDENT.getText();
				        newId.value = ((AsContext)_localctx).CHAR.getText();
				        newId.type = Type.CHAR;
				        addVariable(newId);
				        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
				        
				        // Generate Java code for assignment
				        emit("    char " + newId.id + " = " + ((AsContext)_localctx).CHAR.getText() + ";\n");
				      
				}
				break;
			case 5:
				{
				setState(80);
				((AsContext)_localctx).FLOAT = match(FLOAT);

				        Identifier newId = new Identifier();
				        newId.id = ((AsContext)_localctx).IDENT.getText();
				        newId.value = ((AsContext)_localctx).FLOAT.getText();
				        newId.type = Type.FLOAT;
				        addVariable(newId);
				        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
				        
				        // Generate Java code for assignment
				        generateAssign(true, newId.id, ((AsContext)_localctx).FLOAT.getText());
				      
				}
				break;
			case 6:
				{
				setState(82);
				match(KW_READ);

				        String input = readInput.nextLine();
				        Identifier newId = new Identifier();
				        newId.id = ((AsContext)_localctx).IDENT.getText();
				        newId.value = input;
				        newId.type = typeCheck(input);
				        addVariable(newId);
				        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
				      
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PsContext extends ParserRuleContext {
		public ExprContext expr;
		public TerminalNode KW_PRINT() { return getToken(EmoticonParser.KW_PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public PsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterPs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitPs(this);
		}
	}

	public final PsContext ps() throws RecognitionException {
		PsContext _localctx = new PsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(KW_PRINT);
			setState(87);
			match(LPAREN);
			setState(88);
			((PsContext)_localctx).expr = expr();
			setState(89);
			match(RPAREN);

			      if(((PsContext)_localctx).expr.result.hasKnownValue){
			        if(((PsContext)_localctx).expr.result.type == Type.INT || ((PsContext)_localctx).expr.result.type == Type.FLOAT){
			          System.out.println(((PsContext)_localctx).expr.result.numericalValue);
			        } else {
			          System.out.println(((PsContext)_localctx).expr.result.stringValue);
			        }
			      }
			      
			      // Generate Java code for print statement
			      emit("    System.out.println(" + ((PsContext)_localctx).expr.result.code + ");\n");
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprResult result;
		public TermContext a;
		public Token op;
		public TermContext b;
		public Token COMPARISON;
		public TermContext c;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COMPARISON() { return getTokens(EmoticonParser.COMPARISON); }
		public TerminalNode COMPARISON(int i) {
			return getToken(EmoticonParser.COMPARISON, i);
		}
		public List<TerminalNode> ADD() { return getTokens(EmoticonParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(EmoticonParser.ADD, i);
		}
		public List<TerminalNode> SUBTRACT() { return getTokens(EmoticonParser.SUBTRACT); }
		public TerminalNode SUBTRACT(int i) {
			return getToken(EmoticonParser.SUBTRACT, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);

		    ((ExprContext)_localctx).result =  new ExprResult();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((ExprContext)_localctx).a = term();

			      ((ExprContext)_localctx).result =  ((ExprContext)_localctx).a.result;
			    
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4296540160L) != 0)) {
				{
				setState(102);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ADD:
				case SUBTRACT:
					{
					{
					setState(94);
					((ExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUBTRACT) ) {
						((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(95);
					((ExprContext)_localctx).b = term();

					        ExprResult resultB = ((ExprContext)_localctx).b.result;
					        if((_localctx.result.type == Type.INT || _localctx.result.type == Type.FLOAT)){
					          if(resultB.type == Type.INT || resultB.type == Type.FLOAT){
					            if(((ExprContext)_localctx).op.getText().equals(":+)")){
					              _localctx.result.numericalValue += resultB.numericalValue;
					              _localctx.result.code = _localctx.result.code + " + " + resultB.code;
					            } else {
					              _localctx.result.numericalValue -= resultB.numericalValue;
					              _localctx.result.code = _localctx.result.code + " - " + resultB.code;
					            }
					            if(_localctx.result.type == Type.FLOAT || resultB.type == Type.FLOAT){
					              _localctx.result.type = Type.FLOAT;
					            }
					          } else {
					            error(((ExprContext)_localctx).op, "cannot do arithmetic on non-numerical types");
					            _localctx.result.hasKnownValue = false;
					          }
					        } else if(_localctx.result.type == Type.STRING || _localctx.result.type == Type.CHAR){
					          if(((ExprContext)_localctx).op.getText().equals(":+)")){
					            _localctx.result.stringValue = _localctx.result.stringValue + resultB.stringValue;
					            _localctx.result.code = _localctx.result.code + " + " + resultB.code;
					          } else {
					            error(((ExprContext)_localctx).op, "cannot subtract strings");
					            _localctx.result.hasKnownValue = false;
					          }
					        } else {
					          error(((ExprContext)_localctx).op, "unknown type");
					          _localctx.result.hasKnownValue = false;
					        }
					      
					}
					}
					break;
				case COMPARISON:
					{
					{
					setState(98);
					((ExprContext)_localctx).COMPARISON = match(COMPARISON);
					setState(99);
					((ExprContext)_localctx).c = term();

					        ExprResult resultC = ((ExprContext)_localctx).c.result;
					        if((_localctx.result.type == Type.INT || _localctx.result.type == Type.FLOAT) &&
					           (resultC.type == Type.INT || resultC.type == Type.FLOAT)) {
					          _localctx.result.code = _localctx.result.code + " == " + resultC.code;
					        } else {
					          error(((ExprContext)_localctx).COMPARISON, "can only compare numerical types");
					          _localctx.result.hasKnownValue = false;
					        }
					      
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public ExprResult result;
		public FactorContext a;
		public Token op;
		public FactorContext b;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(EmoticonParser.MULTIPLY); }
		public TerminalNode MULTIPLY(int i) {
			return getToken(EmoticonParser.MULTIPLY, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(EmoticonParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(EmoticonParser.DIVIDE, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);

		    ((TermContext)_localctx).result =  new ExprResult();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			((TermContext)_localctx).a = factor();

			      ((TermContext)_localctx).result =  ((TermContext)_localctx).a.result;
			    
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY || _la==DIVIDE) {
				{
				{
				setState(109);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(110);
				((TermContext)_localctx).b = factor();

				        ExprResult resultB = ((TermContext)_localctx).b.result;
				        if(_localctx.result.type == Type.INT || _localctx.result.type == Type.FLOAT){
				          if(resultB.type == Type.INT || resultB.type == Type.FLOAT){
				            if(resultB.numericalValue == 0 && ((TermContext)_localctx).op.getText().equals(":/)")){
				              error(((TermContext)_localctx).op, "division by zero");
				              _localctx.result.hasKnownValue = false;
				              _localctx.result.code = "Error";
				            } else if(((TermContext)_localctx).op.getText().equals(":*)")){
				              _localctx.result.numericalValue *= resultB.numericalValue;
				            } else {
				              _localctx.result.numericalValue /= resultB.numericalValue;
				            }
				            _localctx.result.code = ""+_localctx.result.numericalValue;
				            if(_localctx.result.type == Type.FLOAT || resultB.type == Type.FLOAT){
				              _localctx.result.type = Type.FLOAT;
				            } else {
				              _localctx.result.type = Type.INT;
				            }
				          } else {
				            error(((TermContext)_localctx).op, "cannot do arithmetic on non-numeric types");
				            _localctx.result.hasKnownValue = false;
				            _localctx.result.code = "(" + _localctx.result.code + ((TermContext)_localctx).op.getText() + resultB.code + ")";
				          }
				        } else {
				          error(((TermContext)_localctx).op, "cannot do arithmetic on non-numeric types");
				          _localctx.result.hasKnownValue = false;
				          _localctx.result.code = "(" + _localctx.result.code + ((TermContext)_localctx).op.getText() + resultB.code + ")";
				        }
				      
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public ExprResult result;
		public Token INT;
		public Token FLOAT;
		public Token CHAR;
		public Token STRING;
		public Token IDENT;
		public ExprContext expr;
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(EmoticonParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(EmoticonParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(EmoticonParser.STRING, 0); }
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_factor);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				((FactorContext)_localctx).INT = match(INT);

				      ((FactorContext)_localctx).result =  new ExprResult();
				      _localctx.result.type = Type.INT;
				      _localctx.result.numericalValue = Integer.parseInt(((FactorContext)_localctx).INT.getText());
				      _localctx.result.hasKnownValue = true;
				      _localctx.result.code = ""+_localctx.result.numericalValue;
				    
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				((FactorContext)_localctx).FLOAT = match(FLOAT);

				      ((FactorContext)_localctx).result =  new ExprResult();
				      _localctx.result.type = Type.FLOAT;
				      _localctx.result.numericalValue = Float.parseFloat(((FactorContext)_localctx).FLOAT.getText());
				      _localctx.result.hasKnownValue = true;
				      _localctx.result.code = ""+_localctx.result.numericalValue;
				    
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				((FactorContext)_localctx).CHAR = match(CHAR);

				      ((FactorContext)_localctx).result =  new ExprResult();
				      _localctx.result.type = Type.CHAR;
				      _localctx.result.stringValue = String.valueOf(((FactorContext)_localctx).CHAR.getText().charAt(0));
				      _localctx.result.hasKnownValue = true;
				      _localctx.result.code = ""+_localctx.result.stringValue;
				    
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				((FactorContext)_localctx).STRING = match(STRING);

				      ((FactorContext)_localctx).result =  new ExprResult();
				      _localctx.result.type = Type.STRING;
				      _localctx.result.stringValue = ((FactorContext)_localctx).STRING.getText();
				      _localctx.result.hasKnownValue = true;
				      _localctx.result.code = ""+_localctx.result.stringValue;
				    
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				((FactorContext)_localctx).IDENT = match(IDENT);

				      String id = ((FactorContext)_localctx).IDENT.getText();
				      Identifier var = lookupVariable(id);
				      ((FactorContext)_localctx).result =  new ExprResult();

				      if(var == null){
				        error(((FactorContext)_localctx).IDENT, "variable is not yet defined");
				      } else {
				        var.hasBeenUsed = true;
				        _localctx.result.type = var.type;
				        _localctx.result.hasKnownValue = var.hasKnown;
				        if(var.type == Type.INT || var.type == Type.FLOAT){
				          if(var.value instanceof Integer){
				            _localctx.result.numericalValue = (Integer)var.value;
				          } else if(var.value instanceof Float){
				            _localctx.result.numericalValue = (Float)var.value;
				          } else if(var.value instanceof String){
				            try {
				              _localctx.result.numericalValue = Float.parseFloat((String)var.value);
				            } catch(NumberFormatException e) {
				              _localctx.result.numericalValue = 0;
				            }
				          }
				        } else {
				          _localctx.result.stringValue = (String)var.value;
				        }
				      }
				      _localctx.result.code = id;
				    
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				match(LPAREN);
				setState(129);
				((FactorContext)_localctx).expr = expr();
				setState(130);
				match(RPAREN);

				      ((FactorContext)_localctx).result =  ((FactorContext)_localctx).expr.result;
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfstmtContext extends ParserRuleContext {
		public ExprContext cond;
		public BlockStatementContext ifBody;
		public BlockStatementContext elseBody;
		public TerminalNode KW_IF() { return getToken(EmoticonParser.KW_IF, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(EmoticonParser.KW_ELSE, 0); }
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitIfstmt(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(KW_IF);
			setState(136);
			match(LPAREN);
			setState(137);
			((IfstmtContext)_localctx).cond = expr();
			setState(138);
			match(RPAREN);

			    if (!definingFunction) {
			      emit("    if (" + ((IfstmtContext)_localctx).cond.result.code + ") {\n");
			    }
			  
			setState(140);
			((IfstmtContext)_localctx).ifBody = blockStatement();
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(141);
				match(KW_ELSE);

				      if (!definingFunction) {
				        emit("    } else {\n");
				      }
				    
				setState(143);
				((IfstmtContext)_localctx).elseBody = blockStatement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElsestmtContext extends ParserRuleContext {
		public ExprContext expr;
		public TerminalNode KW_ELSE_IF() { return getToken(EmoticonParser.KW_ELSE_IF, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public ElsestmtContext elsestmt() {
			return getRuleContext(ElsestmtContext.class,0);
		}
		public TerminalNode KW_ELSE() { return getToken(EmoticonParser.KW_ELSE, 0); }
		public ElsestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterElsestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitElsestmt(this);
		}
	}

	public final ElsestmtContext elsestmt() throws RecognitionException {
		ElsestmtContext _localctx = new ElsestmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elsestmt);
		try {
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ELSE_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(KW_ELSE_IF);

				    if (!definingFunction) {
				      SymbolTable elseIfScope = new SymbolTable();
				      symbolStack.push(elseIfScope);
				      emit("    else if (");  // Fixed: moved inside the if block and corrected to "else if"
				    }
				  
				setState(148);
				match(LPAREN);
				setState(149);
				((ElsestmtContext)_localctx).expr = expr();

				    if (!definingFunction) {
				      emit(((ElsestmtContext)_localctx).expr.result.code + ") {\n");
				    }
				  
				setState(151);
				match(RPAREN);
				setState(152);
				s();

				    if (!definingFunction) {
				      emit("    }\n");
				      symbolStack.pop();
				    }
				  
				setState(155);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(154);
					elsestmt();
					}
					break;
				}
				}
				break;
			case KW_ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(KW_ELSE);

				    if (!definingFunction) {
				      SymbolTable elseScope = new SymbolTable();
				      symbolStack.push(elseScope);
				      emit("    else {\n");
				    }
				  
				setState(159);
				s();

				    if (!definingFunction) {
				      emit("    }\n");
				      symbolStack.pop();
				    }
				  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForstmtContext extends ParserRuleContext {
		public TerminalNode KW_FOR() { return getToken(EmoticonParser.KW_FOR, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public List<AsContext> as() {
			return getRuleContexts(AsContext.class);
		}
		public AsContext as(int i) {
			return getRuleContext(AsContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public ForstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterForstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitForstmt(this);
		}
	}

	public final ForstmtContext forstmt() throws RecognitionException {
		ForstmtContext _localctx = new ForstmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(KW_FOR);
			setState(165);
			match(LPAREN);

			    if (!definingFunction) {
			      SymbolTable forScope = new SymbolTable();
			      symbolStack.push(forScope);
			    }
			  
			setState(167);
			as();
			setState(168);
			match(T__0);
			setState(169);
			expr();
			setState(170);
			match(T__0);
			setState(171);
			as();
			setState(172);
			match(RPAREN);
			setState(173);
			s();

			    if (!definingFunction) {
			      symbolStack.pop();
			    }
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhilestmtContext extends ParserRuleContext {
		public TerminalNode KW_WHILE() { return getToken(EmoticonParser.KW_WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public WhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterWhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitWhilestmt(this);
		}
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(KW_WHILE);

			    if (!definingFunction) {
			      SymbolTable whileScope = new SymbolTable();
			      symbolStack.push(whileScope);
			    }
			  
			setState(178);
			match(LPAREN);
			setState(179);
			expr();
			setState(180);
			match(RPAREN);
			setState(181);
			s();

			    if (!definingFunction) {
			      symbolStack.pop();
			    }
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionstmtContext extends ParserRuleContext {
		public Token name;
		public Token param;
		public SContext body;
		public TerminalNode KW_FUNCTION() { return getToken(EmoticonParser.KW_FUNCTION, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public List<TerminalNode> IDENT() { return getTokens(EmoticonParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(EmoticonParser.IDENT, i);
		}
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public FunctionstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterFunctionstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitFunctionstmt(this);
		}
	}

	public final FunctionstmtContext functionstmt() throws RecognitionException {
		FunctionstmtContext _localctx = new FunctionstmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionstmt);
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(KW_FUNCTION);
				setState(185);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(186);
				match(LPAREN);
				setState(187);
				((FunctionstmtContext)_localctx).param = match(IDENT);
				setState(188);
				match(RPAREN);

				    definingFunction = true;
				    functionDefDepth = 0;
				    FunctionDef func = new FunctionDef();
				    func.name = ((FunctionstmtContext)_localctx).name.getText();
				    func.paramName = ((FunctionstmtContext)_localctx).param.getText();
				    functions.put(func.name, func);
				    System.out.println("Defining function '" + func.name + "' with parameter '" + func.paramName + "'");
				  
				setState(190);
				((FunctionstmtContext)_localctx).body = s();

				    definingFunction = false;
				    functionDefDepth = 0;
				    FunctionDef funcDef = functions.get(((FunctionstmtContext)_localctx).name.getText());
				    funcDef.body = ((FunctionstmtContext)_localctx).body;
				    System.out.println("Function '" + funcDef.name + "' defined");
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(KW_FUNCTION);
				setState(194);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(195);
				match(LPAREN);
				setState(196);
				match(RPAREN);

				    definingFunction = true;
				    functionDefDepth = 0;
				    FunctionDef func2 = new FunctionDef();
				    func2.name = ((FunctionstmtContext)_localctx).name.getText();
				    func2.paramName = null;
				    functions.put(func2.name, func2);
				    System.out.println("Defining function '" + func2.name + "'");
				  
				setState(198);
				((FunctionstmtContext)_localctx).body = s();

				    definingFunction = false;
				    functionDefDepth = 0;
				    FunctionDef funcDef2 = functions.get(((FunctionstmtContext)_localctx).name.getText());
				    funcDef2.body = ((FunctionstmtContext)_localctx).body;
				    System.out.println("Function '" + funcDef2.name + "' defined");
				  
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctioncallContext extends ParserRuleContext {
		public Token IDENT;
		public ExprContext arg;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterFunctioncall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitFunctioncall(this);
		}
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functioncall);
		try {
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(204);
				match(LPAREN);
				setState(205);
				((FunctioncallContext)_localctx).arg = expr();
				setState(206);
				match(RPAREN);

				    String funcName = ((FunctioncallContext)_localctx).IDENT.getText();
				    if (!functions.containsKey(funcName)) {
				      error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' not defined");
				    } else {
				      FunctionDef func = functions.get(funcName);
				      if(((FunctioncallContext)_localctx).arg.result.type == Type.INT || ((FunctioncallContext)_localctx).arg.result.type == Type.FLOAT){
				        System.out.println("Calling function '" + funcName + "' with argument " + ((FunctioncallContext)_localctx).arg.result.numericalValue);
				      } else {
				        System.out.println("Calling function '" + funcName + "' with argument " + ((FunctioncallContext)_localctx).arg.result.stringValue);
				      }
				    }
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(210);
				match(LPAREN);
				setState(211);
				match(RPAREN);

				    String funcName = ((FunctioncallContext)_localctx).IDENT.getText();
				    if (!functions.containsKey(funcName)) {
				      error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' not defined");
				    } else {
				      FunctionDef func = functions.get(funcName);
				      if (func.paramName != null) {
				        error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' expects a parameter");
				      } else {
				        System.out.println("Calling function '" + funcName + "'");
				      }
				    }
				  
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArraystmtContext extends ParserRuleContext {
		public TerminalNode KW_ARRAY() { return getToken(EmoticonParser.KW_ARRAY, 0); }
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(EmoticonParser.ASSIGNMENT, 0); }
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
		public SContext s() {
			return getRuleContext(SContext.class,0);
		}
		public ArraystmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraystmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterArraystmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitArraystmt(this);
		}
	}

	public final ArraystmtContext arraystmt() throws RecognitionException {
		ArraystmtContext _localctx = new ArraystmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arraystmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(KW_ARRAY);
			setState(216);
			match(IDENT);
			setState(217);
			match(ASSIGNMENT);
			setState(218);
			match(T__1);
			setState(219);
			match(INT);
			setState(220);
			match(T__2);
			setState(221);
			s();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorsContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(EmoticonParser.ADD, 0); }
		public TerminalNode SUBTRACT() { return getToken(EmoticonParser.SUBTRACT, 0); }
		public TerminalNode MULTIPLY() { return getToken(EmoticonParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(EmoticonParser.DIVIDE, 0); }
		public OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitOperators(this);
		}
	}

	public final OperatorsContext operators() throws RecognitionException {
		OperatorsContext _localctx = new OperatorsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompContext extends ParserRuleContext {
		public TerminalNode COMPARISON() { return getToken(EmoticonParser.COMPARISON, 0); }
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitComp(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(COMPARISON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u00e4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0005\u0000%\b\u0000"+
		"\n\u0000\f\u0000(\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00017\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002>\b\u0002"+
		"\n\u0002\f\u0002A\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003U\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005g\b\u0005\n\u0005\f\u0005j\t\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006r\b\u0006\n\u0006\f\u0006u\t\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u0086\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0091\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u009c"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a3\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00ca\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00d6"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0000\u0000\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0003\u0001\u0000"+
		"\u0013\u0014\u0001\u0000\u0015\u0016\u0001\u0000\u0013\u0016\u00ef\u0000"+
		"\"\u0001\u0000\u0000\u0000\u00026\u0001\u0000\u0000\u0000\u0004:\u0001"+
		"\u0000\u0000\u0000\u0006E\u0001\u0000\u0000\u0000\bV\u0001\u0000\u0000"+
		"\u0000\n\\\u0001\u0000\u0000\u0000\fk\u0001\u0000\u0000\u0000\u000e\u0085"+
		"\u0001\u0000\u0000\u0000\u0010\u0087\u0001\u0000\u0000\u0000\u0012\u00a2"+
		"\u0001\u0000\u0000\u0000\u0014\u00a4\u0001\u0000\u0000\u0000\u0016\u00b0"+
		"\u0001\u0000\u0000\u0000\u0018\u00c9\u0001\u0000\u0000\u0000\u001a\u00d5"+
		"\u0001\u0000\u0000\u0000\u001c\u00d7\u0001\u0000\u0000\u0000\u001e\u00df"+
		"\u0001\u0000\u0000\u0000 \u00e1\u0001\u0000\u0000\u0000\"&\u0006\u0000"+
		"\uffff\uffff\u0000#%\u0003\u0002\u0001\u0000$#\u0001\u0000\u0000\u0000"+
		"%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000"+
		"\u0000\')\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)*\u0005\u0000"+
		"\u0000\u0001*+\u0006\u0000\uffff\uffff\u0000+\u0001\u0001\u0000\u0000"+
		"\u0000,7\u0003\u001a\r\u0000-7\u0003\u0006\u0003\u0000.7\u0003\b\u0004"+
		"\u0000/7\u0003\n\u0005\u000007\u0003\u001c\u000e\u000017\u0003\u0004\u0002"+
		"\u000027\u0003\u0010\b\u000037\u0003\u0014\n\u000047\u0003\u0016\u000b"+
		"\u000057\u0003\u0018\f\u00006,\u0001\u0000\u0000\u00006-\u0001\u0000\u0000"+
		"\u00006.\u0001\u0000\u0000\u00006/\u0001\u0000\u0000\u000060\u0001\u0000"+
		"\u0000\u000061\u0001\u0000\u0000\u000062\u0001\u0000\u0000\u000063\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u0000"+
		"78\u0001\u0000\u0000\u000089\u0006\u0001\uffff\uffff\u00009\u0003\u0001"+
		"\u0000\u0000\u0000:;\u0005\r\u0000\u0000;?\u0006\u0002\uffff\uffff\u0000"+
		"<>\u0003\u0002\u0001\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000"+
		"\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005\u000e\u0000\u0000CD\u0006"+
		"\u0002\uffff\uffff\u0000D\u0005\u0001\u0000\u0000\u0000EF\u0005\u0012"+
		"\u0000\u0000FT\u0005!\u0000\u0000GH\u0003\n\u0005\u0000HI\u0006\u0003"+
		"\uffff\uffff\u0000IU\u0001\u0000\u0000\u0000JK\u0005\u0017\u0000\u0000"+
		"KU\u0006\u0003\uffff\uffff\u0000LM\u0005\u001a\u0000\u0000MU\u0006\u0003"+
		"\uffff\uffff\u0000NO\u0005\u0019\u0000\u0000OU\u0006\u0003\uffff\uffff"+
		"\u0000PQ\u0005\u0018\u0000\u0000QU\u0006\u0003\uffff\uffff\u0000RS\u0005"+
		"\u0004\u0000\u0000SU\u0006\u0003\uffff\uffff\u0000TG\u0001\u0000\u0000"+
		"\u0000TJ\u0001\u0000\u0000\u0000TL\u0001\u0000\u0000\u0000TN\u0001\u0000"+
		"\u0000\u0000TP\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000U\u0007"+
		"\u0001\u0000\u0000\u0000VW\u0005\u0005\u0000\u0000WX\u0005\u001c\u0000"+
		"\u0000XY\u0003\n\u0005\u0000YZ\u0005\u001d\u0000\u0000Z[\u0006\u0004\uffff"+
		"\uffff\u0000[\t\u0001\u0000\u0000\u0000\\]\u0003\f\u0006\u0000]h\u0006"+
		"\u0005\uffff\uffff\u0000^_\u0007\u0000\u0000\u0000_`\u0003\f\u0006\u0000"+
		"`a\u0006\u0005\uffff\uffff\u0000ag\u0001\u0000\u0000\u0000bc\u0005 \u0000"+
		"\u0000cd\u0003\f\u0006\u0000de\u0006\u0005\uffff\uffff\u0000eg\u0001\u0000"+
		"\u0000\u0000f^\u0001\u0000\u0000\u0000fb\u0001\u0000\u0000\u0000gj\u0001"+
		"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000"+
		"i\u000b\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0003\u000e"+
		"\u0007\u0000ls\u0006\u0006\uffff\uffff\u0000mn\u0007\u0001\u0000\u0000"+
		"no\u0003\u000e\u0007\u0000op\u0006\u0006\uffff\uffff\u0000pr\u0001\u0000"+
		"\u0000\u0000qm\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\r\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000vw\u0005\u0017\u0000\u0000w\u0086\u0006\u0007"+
		"\uffff\uffff\u0000xy\u0005\u0018\u0000\u0000y\u0086\u0006\u0007\uffff"+
		"\uffff\u0000z{\u0005\u0019\u0000\u0000{\u0086\u0006\u0007\uffff\uffff"+
		"\u0000|}\u0005\u001a\u0000\u0000}\u0086\u0006\u0007\uffff\uffff\u0000"+
		"~\u007f\u0005\u0012\u0000\u0000\u007f\u0086\u0006\u0007\uffff\uffff\u0000"+
		"\u0080\u0081\u0005\u001c\u0000\u0000\u0081\u0082\u0003\n\u0005\u0000\u0082"+
		"\u0083\u0005\u001d\u0000\u0000\u0083\u0084\u0006\u0007\uffff\uffff\u0000"+
		"\u0084\u0086\u0001\u0000\u0000\u0000\u0085v\u0001\u0000\u0000\u0000\u0085"+
		"x\u0001\u0000\u0000\u0000\u0085z\u0001\u0000\u0000\u0000\u0085|\u0001"+
		"\u0000\u0000\u0000\u0085~\u0001\u0000\u0000\u0000\u0085\u0080\u0001\u0000"+
		"\u0000\u0000\u0086\u000f\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0006"+
		"\u0000\u0000\u0088\u0089\u0005\u001c\u0000\u0000\u0089\u008a\u0003\n\u0005"+
		"\u0000\u008a\u008b\u0005\u001d\u0000\u0000\u008b\u008c\u0006\b\uffff\uffff"+
		"\u0000\u008c\u0090\u0003\u0004\u0002\u0000\u008d\u008e\u0005\u0007\u0000"+
		"\u0000\u008e\u008f\u0006\b\uffff\uffff\u0000\u008f\u0091\u0003\u0004\u0002"+
		"\u0000\u0090\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u0011\u0001\u0000\u0000\u0000\u0092\u0093\u0005\b\u0000\u0000"+
		"\u0093\u0094\u0006\t\uffff\uffff\u0000\u0094\u0095\u0005\u001c\u0000\u0000"+
		"\u0095\u0096\u0003\n\u0005\u0000\u0096\u0097\u0006\t\uffff\uffff\u0000"+
		"\u0097\u0098\u0005\u001d\u0000\u0000\u0098\u0099\u0003\u0002\u0001\u0000"+
		"\u0099\u009b\u0006\t\uffff\uffff\u0000\u009a\u009c\u0003\u0012\t\u0000"+
		"\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"+
		"\u009c\u00a3\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u0007\u0000\u0000"+
		"\u009e\u009f\u0006\t\uffff\uffff\u0000\u009f\u00a0\u0003\u0002\u0001\u0000"+
		"\u00a0\u00a1\u0006\t\uffff\uffff\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a2\u0092\u0001\u0000\u0000\u0000\u00a2\u009d\u0001\u0000\u0000\u0000"+
		"\u00a3\u0013\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\t\u0000\u0000\u00a5"+
		"\u00a6\u0005\u001c\u0000\u0000\u00a6\u00a7\u0006\n\uffff\uffff\u0000\u00a7"+
		"\u00a8\u0003\u0006\u0003\u0000\u00a8\u00a9\u0005\u0001\u0000\u0000\u00a9"+
		"\u00aa\u0003\n\u0005\u0000\u00aa\u00ab\u0005\u0001\u0000\u0000\u00ab\u00ac"+
		"\u0003\u0006\u0003\u0000\u00ac\u00ad\u0005\u001d\u0000\u0000\u00ad\u00ae"+
		"\u0003\u0002\u0001\u0000\u00ae\u00af\u0006\n\uffff\uffff\u0000\u00af\u0015"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\n\u0000\u0000\u00b1\u00b2\u0006"+
		"\u000b\uffff\uffff\u0000\u00b2\u00b3\u0005\u001c\u0000\u0000\u00b3\u00b4"+
		"\u0003\n\u0005\u0000\u00b4\u00b5\u0005\u001d\u0000\u0000\u00b5\u00b6\u0003"+
		"\u0002\u0001\u0000\u00b6\u00b7\u0006\u000b\uffff\uffff\u0000\u00b7\u0017"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u000b\u0000\u0000\u00b9\u00ba"+
		"\u0005\u0012\u0000\u0000\u00ba\u00bb\u0005\u001c\u0000\u0000\u00bb\u00bc"+
		"\u0005\u0012\u0000\u0000\u00bc\u00bd\u0005\u001d\u0000\u0000\u00bd\u00be"+
		"\u0006\f\uffff\uffff\u0000\u00be\u00bf\u0003\u0002\u0001\u0000\u00bf\u00c0"+
		"\u0006\f\uffff\uffff\u0000\u00c0\u00ca\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0005\u000b\u0000\u0000\u00c2\u00c3\u0005\u0012\u0000\u0000\u00c3\u00c4"+
		"\u0005\u001c\u0000\u0000\u00c4\u00c5\u0005\u001d\u0000\u0000\u00c5\u00c6"+
		"\u0006\f\uffff\uffff\u0000\u00c6\u00c7\u0003\u0002\u0001\u0000\u00c7\u00c8"+
		"\u0006\f\uffff\uffff\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000\u00c9\u00b8"+
		"\u0001\u0000\u0000\u0000\u00c9\u00c1\u0001\u0000\u0000\u0000\u00ca\u0019"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u0012\u0000\u0000\u00cc\u00cd"+
		"\u0005\u001c\u0000\u0000\u00cd\u00ce\u0003\n\u0005\u0000\u00ce\u00cf\u0005"+
		"\u001d\u0000\u0000\u00cf\u00d0\u0006\r\uffff\uffff\u0000\u00d0\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d2\u0005\u0012\u0000\u0000\u00d2\u00d3\u0005"+
		"\u001c\u0000\u0000\u00d3\u00d4\u0005\u001d\u0000\u0000\u00d4\u00d6\u0006"+
		"\r\uffff\uffff\u0000\u00d5\u00cb\u0001\u0000\u0000\u0000\u00d5\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d6\u001b\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005"+
		"\f\u0000\u0000\u00d8\u00d9\u0005\u0012\u0000\u0000\u00d9\u00da\u0005!"+
		"\u0000\u0000\u00da\u00db\u0005\u0002\u0000\u0000\u00db\u00dc\u0005\u0017"+
		"\u0000\u0000\u00dc\u00dd\u0005\u0003\u0000\u0000\u00dd\u00de\u0003\u0002"+
		"\u0001\u0000\u00de\u001d\u0001\u0000\u0000\u0000\u00df\u00e0\u0007\u0002"+
		"\u0000\u0000\u00e0\u001f\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005 \u0000"+
		"\u0000\u00e2!\u0001\u0000\u0000\u0000\r&6?Tfhs\u0085\u0090\u009b\u00a2"+
		"\u00c9\u00d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
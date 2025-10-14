// Generated from c:/Users/pieco/Desktop/Emoticon language/Emoticon.g4 by ANTLR 4.13.1
 import java.util.*; import org.antlr.v4.runtime.*; import org.antlr.v4.runtime.tree.*; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EmoticonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, KW_READ=4, KW_PRINT=5, KW_IF=6, KW_ELSE=7, KW_ELSE_IF=8, 
		KW_FOR=9, KW_WHILE=10, KW_FUNCTION=11, KW_ARRAY=12, LBRACE=13, RBRACE=14, 
		KW_INT=15, KW_STRING=16, KW_CHAR=17, IDENT=18, ADD=19, SUBTRACT=20, MULTIPLY=21, 
		DIVIDE=22, INT=23, CHAR=24, STRING=25, WS=26, LPAREN=27, RPAREN=28, COMMENT=29, 
		COMMENT_BLOCK=30, COMPARISON=31, ASSIGNMENT=32;
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
			null, null, null, null, "'('", "')'", null, null, "':==)'", "':=)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", 
			"KW_FOR", "KW_WHILE", "KW_FUNCTION", "KW_ARRAY", "LBRACE", "RBRACE", 
			"KW_INT", "KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", "MULTIPLY", 
			"DIVIDE", "INT", "CHAR", "STRING", "WS", "LPAREN", "RPAREN", "COMMENT", 
			"COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT"
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
	    INT, STRING, CHAR, UNKNOWN
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
	    String paramName; // null if no parameter
	    ParserRuleContext body; // Store the parse tree of the function body
	  }
	  
	  SymbolTable mainTable = new SymbolTable();
	  Stack<SymbolTable> symbolStack = new Stack<>();
	  Map<String, FunctionDef> functions = new HashMap<>();
	  
	  // Diagnostics
	  List<String> diagnostics = new ArrayList<>();
	  
	  // LHS tracking
	  String pendingLHS = null;
	  boolean lhsExistedBefore = false;
	  
	  // Error tracking
	  boolean hasErrors = false;
	  
	  // Track if we're currently defining a function (to skip execution during definition)
	  boolean definingFunction = false;
	  int functionDefDepth = 0; // Track nesting depth during function definition
	    
	  void error(Token t, String msg) {
	    diagnostics.add("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + msg);
	    hasErrors = true;
	  }

	  void printDiagnostics() {    
	    if (!diagnostics.isEmpty()) {
	      for (String d : diagnostics) {
	        System.err.println("Error: " + d);
	      }
	    }    
	    checkUnusedVariables();
	  }
	  
	  void checkUnusedVariables() {
	    boolean foundUnused = false;
	    
	    // Check main table
	    for (Map.Entry<String, Identifier> entry : mainTable.table.entrySet()) {
	      if (!entry.getValue().hasBeenUsed) {
	        if (!foundUnused) {
	          System.err.println("\nUnused variables:");
	          foundUnused = true;
	        }
	        System.err.println("Variable '" + entry.getKey() + "' declared but never used");
	      }
	    }
	  }

	  Type typeCheck(String text) {
	    Type varType = Type.UNKNOWN;
	    if (text.matches("[+-]?(0|[1-9][0-9]*)")) {
	      varType = Type.INT;
	    } else if (text.matches("'(\\\\.|[^\\\\'])'")){
	      varType = Type.CHAR;
	    } else if (text.matches("(['\"']).*?(['\"])")) {
	      varType = Type.STRING;
	    }
	    return varType;
	  }

	  // Lookup a variable by searching through the scope stack (innermost first)
	  Identifier lookupVariable(String name) {
	    // Search from top of stack (innermost scope) down
	    for (int i = symbolStack.size() - 1; i >= 0; i--) {
	      SymbolTable table = symbolStack.get(i);
	      if (table.table.containsKey(name)) {
	        return table.table.get(name);
	      }
	    }
	    
	    // Finally check the main/global table
	    if (mainTable.table.containsKey(name)) {
	      return mainTable.table.get(name);
	    }
	    
	    return null; // Variable not found in any scope
	  }

	  // Add a variable to the current scope (top of stack, or main if stack is empty)
	  void addVariable(Identifier id) {
	    if (symbolStack.isEmpty()) {
	      mainTable.table.put(id.id, id);
	    } else {
	      SymbolTable currentScope = symbolStack.peek();
	      currentScope.table.put(id.id, id);
	    }
	  }

	  // Check if variable exists in current scope only
	  boolean existsInCurrentScope(String name) {
	    if (symbolStack.isEmpty()) {
	      return mainTable.table.containsKey(name);
	    } else {
	      return symbolStack.peek().table.containsKey(name);
	    }
	  }
	  
	  // Execute a function body by re-visiting the parse tree
	  void executeStatement(ParserRuleContext ctx) {
	    if (ctx == null) {
	      return;
	    }
	    
	    // Check what type of statement this is and execute it
	    if (ctx instanceof EmoticonParser.AsContext) {
	      executeAssignment((EmoticonParser.AsContext) ctx);
	    } else if (ctx instanceof EmoticonParser.PsContext) {
	      executePrint((EmoticonParser.PsContext) ctx);
	    } else if (ctx instanceof EmoticonParser.BlockStatementContext) {
	      executeBlock((EmoticonParser.BlockStatementContext) ctx);
	    } else if (ctx instanceof EmoticonParser.IfstmtContext) {
	      executeIf((EmoticonParser.IfstmtContext) ctx);
	    } else if (ctx instanceof EmoticonParser.SContext) {
	      // It's a general statement context, figure out which type
	      EmoticonParser.SContext sCtx = (EmoticonParser.SContext) ctx;
	      if (sCtx.as() != null) {
	        executeAssignment(sCtx.as());
	      } else if (sCtx.ps() != null) {
	        executePrint(sCtx.ps());
	      } else if (sCtx.blockStatement() != null) {
	        executeBlock(sCtx.blockStatement());
	      } else if (sCtx.ifstmt() != null) {
	        executeIf(sCtx.ifstmt());
	      }
	    }
	  }
	  
	  void executeAssignment(EmoticonParser.AsContext ctx) {
	    String varName = ctx.IDENT().getText();
	    
	    // Check if it's expr or READ
	    if (ctx.expr() != null) {
	      Integer value = evaluateExpr(ctx.expr());
	      
	      Identifier newId = new Identifier();
	      newId.id = varName;
	      newId.value = value;
	      newId.type = typeCheck(String.valueOf(value));
	      newId.hasKnown = (value != null);
	      newId.hasBeenUsed = false;
	      
	      addVariable(newId);
	      System.out.println("DEBUG: Assign " + varName + " = " + value);
	    } else if (ctx.KW_READ() != null) {
	      Identifier newId = new Identifier();
	      newId.id = varName;
	      newId.value = 0;
	      newId.type = Type.INT;
	      newId.hasKnown = false;
	      newId.hasBeenUsed = false;
	      addVariable(newId);
	    }
	  }
	  
	  void executePrint(EmoticonParser.PsContext ctx) {
	    Integer value = evaluateExpr(ctx.expr());
	    if (value != null) {
	      System.out.println("DEBUG: Print value = " + value);
	    }
	  }
	  
	  void executeBlock(EmoticonParser.BlockStatementContext ctx) {
	    SymbolTable blockScope = new SymbolTable();
	    symbolStack.push(blockScope);
	    
	    for (EmoticonParser.SContext stmt : ctx.s()) {
	      executeStatement(stmt);
	    }
	    
	    symbolStack.pop();
	  }
	  
	  void executeIf(EmoticonParser.IfstmtContext ctx) {
	    SymbolTable ifScope = new SymbolTable();
	    symbolStack.push(ifScope);
	    
	    executeStatement(ctx.s());
	    
	    symbolStack.pop();
	  }
	  
	  Integer evaluateExpr(EmoticonParser.ExprContext ctx) {
	    if (ctx == null) return null;
	    
	    // Get the first term
	    Integer value = evaluateTerm(ctx.term(0));
	    if (value == null) return null;
	    
	    // Process additional terms with operators
	    for (int i = 1; i < ctx.term().size(); i++) {
	      Integer nextValue = evaluateTerm(ctx.term(i));
	      if (nextValue == null) return null;
	      
	      String op = ctx.getChild(i * 2 - 1).getText(); // Get operator
	      if (op.equals(":+)")) {
	        value = value + nextValue;
	      } else if (op.equals(":-)")) {
	        value = value - nextValue;
	      }
	    }
	    
	    return value;
	  }
	  
	  Integer evaluateTerm(EmoticonParser.TermContext ctx) {
	    if (ctx == null) return null;
	    
	    // Get the first factor
	    Integer value = evaluateFactor(ctx.factor(0));
	    if (value == null) return null;
	    
	    // Process additional factors with operators
	    for (int i = 1; i < ctx.factor().size(); i++) {
	      Integer nextValue = evaluateFactor(ctx.factor(i));
	      if (nextValue == null) return null;
	      
	      String op = ctx.getChild(i * 2 - 1).getText(); // Get operator
	      if (op.equals(":*)")) {
	        value = value * nextValue;
	      } else if (op.equals(":/)")) {
	        if (nextValue == 0) {
	          return null; // Division by zero
	        }
	        value = value / nextValue;
	      }
	    }
	    
	    return value;
	  }
	  
	  Integer evaluateFactor(EmoticonParser.FactorContext ctx) {
	    if (ctx == null) return null;
	    
	    // Check if it's an INT literal
	    if (ctx.INT() != null) {
	      return Integer.parseInt(ctx.INT().getText());
	    }
	    
	    // Check if it's an IDENT (variable)
	    if (ctx.IDENT() != null) {
	      String varName = ctx.IDENT().getText();
	      Identifier id = lookupVariable(varName);
	      if (id != null && id.value instanceof Integer) {
	        id.hasBeenUsed = true;
	        return (Integer) id.value;
	      }
	      return null;
	    }
	    
	    // Check if it's a parenthesized expression
	    if (ctx.expr() != null) {
	      return evaluateExpr(ctx.expr());
	    }
	    
	    return null;
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			    SymbolTable globalSymbolTable = new SymbolTable();
			  
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				s();
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 142884448L) != 0) );
			setState(40);
			match(EOF);

			    printDiagnostics();
			  
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
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_s);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				functioncall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				as();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				ps();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(47);
				arraystmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(48);
				blockStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(49);
				ifstmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(50);
				forstmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(51);
				whilestmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(52);
				functionstmt();
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
	public static class BlockStatementContext extends ParserRuleContext {
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
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(LBRACE);
			  
			    if (!definingFunction) {
			      SymbolTable currentSymbolTable = new SymbolTable();
			      symbolStack.push(currentSymbolTable);
			    } else {
			      functionDefDepth++;
			    }
			  
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 142884448L) != 0)) {
				{
				{
				setState(57);
				s();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			match(RBRACE);
			 
			    if (!definingFunction) {
			      symbolStack.pop();
			    } else {
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
		public Token STRING;
		public Token CHAR;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(EmoticonParser.ASSIGNMENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode KW_READ() { return getToken(EmoticonParser.KW_READ, 0); }
		public TerminalNode STRING() { return getToken(EmoticonParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(EmoticonParser.CHAR, 0); }
		public AsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as; }
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((AsContext)_localctx).IDENT = match(IDENT);
			setState(67);
			match(ASSIGNMENT);
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case INT:
			case LPAREN:
				{
				setState(68);
				((AsContext)_localctx).expr = expr();

				        if (!definingFunction) {
				        pendingLHS = ((AsContext)_localctx).IDENT.getText();
				        // Check if it exists in ANY scope
				        Identifier existing = lookupVariable(pendingLHS);
				        lhsExistedBefore = (existing != null);
				      }
				      if (!definingFunction) {
				              Identifier newId = new Identifier();
				              newId.id = pendingLHS;
				              newId.value = ((AsContext)_localctx).expr.value;
				              //TYPE CHECK HERE
				              newId.type = typeCheck(String.valueOf(newId.value));
				              System.out.println("DEBUG: Assign " + pendingLHS + " = " + String.valueOf(newId.value));
				               System.out.println("DEBUG: Type = " + newId.type);
				              newId.hasKnown = ((AsContext)_localctx).expr.hasKnownValue;
				              newId.hasBeenUsed = false;
				              
				              // Add to CURRENT scope
				              addVariable(newId);
				              
				              pendingLHS = null;
				            }
				      
				}
				break;
			case KW_READ:
				{
				setState(71);
				match(KW_READ);

				        Identifier newId = new Identifier();
				        newId.id = ((AsContext)_localctx).IDENT.getText();
				        newId.value = 0;
				        newId.type = Type.INT;
				        addVariable(newId);
				        System.out.println("DEBUG: Print type = " + newId.value);
				        System.out.println("DEBUG: Print type = " + newId.type);
				      
				}
				break;
			case STRING:
				{
				setState(73);
				((AsContext)_localctx).STRING = match(STRING);

				        Identifier newId = new Identifier();
				        newId.id = ((AsContext)_localctx).IDENT.getText();
				        newId.value = ((AsContext)_localctx).STRING.getText();
				        newId.type = Type.STRING;
				        addVariable(newId);
				        System.out.println("DEBUG: Print type = " + newId.value);
				        System.out.println("DEBUG: Print type = " + newId.type);
				      
				}
				break;
			case CHAR:
				{
				setState(75);
				((AsContext)_localctx).CHAR = match(CHAR);

				        Identifier newId = new Identifier();
				        newId.id = ((AsContext)_localctx).IDENT.getText();
				        newId.value = ((AsContext)_localctx).CHAR.getText();
				        newId.type = Type.CHAR;
				        addVariable(newId);
				        System.out.println("DEBUG: Print type = " + newId.value);
				        System.out.println("DEBUG: Print type = " + newId.type);
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	}

	public final PsContext ps() throws RecognitionException {
		PsContext _localctx = new PsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(KW_PRINT);
			setState(80);
			match(LPAREN);
			setState(81);
			((PsContext)_localctx).expr = expr();
			setState(82);
			match(RPAREN);

			      if (!definingFunction) {
			        if (((PsContext)_localctx).expr.hasKnownValue) {
			          System.out.println("DEBUG: Print value = " + ((PsContext)_localctx).expr.value);
			        }
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
	public static class ExprContext extends ParserRuleContext {
		public boolean hasKnownValue;
		public Integer value;
		public TermContext a;
		public Token op;
		public TermContext b;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			((ExprContext)_localctx).a = term();

			      if (((ExprContext)_localctx).a.hasKnownValue) {
			        ((ExprContext)_localctx).hasKnownValue =  true;
			        ((ExprContext)_localctx).value =  ((ExprContext)_localctx).a.value;
			      } else {
			        ((ExprContext)_localctx).hasKnownValue =  false;
			      } 
			    
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUBTRACT) {
				{
				{
				setState(87);
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
				setState(88);
				((ExprContext)_localctx).b = term();

				      if (_localctx.hasKnownValue && ((ExprContext)_localctx).b.hasKnownValue) {
				        if (((ExprContext)_localctx).op.getText().equals(":+)")) {
				          ((ExprContext)_localctx).value =  _localctx.value + ((ExprContext)_localctx).b.value;
				        } else {
				          ((ExprContext)_localctx).value =  _localctx.value - ((ExprContext)_localctx).b.value;
				        }
				      } else {
				        ((ExprContext)_localctx).hasKnownValue =  false;
				      }
				    
				}
				}
				setState(95);
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
		public boolean hasKnownValue;
		public Integer value;
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
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((TermContext)_localctx).a = factor();

			      if (((TermContext)_localctx).a.hasKnownValue) {
			        ((TermContext)_localctx).hasKnownValue =  true;
			        ((TermContext)_localctx).value =  ((TermContext)_localctx).a.value;
			      } else {
			        ((TermContext)_localctx).hasKnownValue =  false;
			      }
			    
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY || _la==DIVIDE) {
				{
				{
				setState(98);
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
				setState(99);
				((TermContext)_localctx).b = factor();

				      if (((TermContext)_localctx).b.hasKnownValue && ((TermContext)_localctx).op.getText().equals(":/)") && ((TermContext)_localctx).b.value == 0) {
				        if (!definingFunction) {
				          error(((TermContext)_localctx).op, "division by zero");
				        }
				        ((TermContext)_localctx).hasKnownValue =  false;
				      } else if (_localctx.hasKnownValue && ((TermContext)_localctx).b.hasKnownValue) {
				        if (((TermContext)_localctx).op.getText().equals(":*)")) {
				          ((TermContext)_localctx).value =  _localctx.value * ((TermContext)_localctx).b.value;
				        } else {
				          ((TermContext)_localctx).value =  _localctx.value / ((TermContext)_localctx).b.value;
				        }
				      } else {
				        ((TermContext)_localctx).hasKnownValue =  false;
				      }
				    
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
	public static class FactorContext extends ParserRuleContext {
		public boolean hasKnownValue;
		public Integer value;
		public Token INT;
		public Token IDENT;
		public ExprContext expr;
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
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
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_factor);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				((FactorContext)_localctx).INT = match(INT);
				 
				        ((FactorContext)_localctx).hasKnownValue =  true; 
				        ((FactorContext)_localctx).value =  Integer.parseInt(((FactorContext)_localctx).INT.getText());
				      
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				((FactorContext)_localctx).IDENT = match(IDENT);

				        String id = ((FactorContext)_localctx).IDENT.getText();
				        
				        if (definingFunction) {
				          // During function definition, just validate syntax
				          ((FactorContext)_localctx).hasKnownValue =  false;
				          ((FactorContext)_localctx).value =  0;
				        } else {
				          // Use lookupVariable instead of mainTable.table.get
				          Identifier currentId = lookupVariable(id);
				          
				          if (currentId == null) {
				            if (pendingLHS != null && !lhsExistedBefore && id.equals(pendingLHS)) {
				              error(((FactorContext)_localctx).IDENT, "self-reference on first assignment of '" + pendingLHS + "'");
				            } else {
				              error(((FactorContext)_localctx).IDENT, "use of variable '" + id + "' before assignment");
				            }
				            ((FactorContext)_localctx).hasKnownValue =  false;
				            ((FactorContext)_localctx).value =  0;
				          } else if(currentId.type != Type.INT){
				            error(((FactorContext)_localctx).IDENT, id + " is not of type int");
				            ((FactorContext)_localctx).hasKnownValue =  false;
				            ((FactorContext)_localctx).value =  0;
				          } else {
				            currentId.hasBeenUsed = true;
				            ((FactorContext)_localctx).hasKnownValue =  currentId.hasKnown;
				            Object val = currentId.value;
				            if (val instanceof Integer) {
				                ((FactorContext)_localctx).value =  (Integer) val;
				            } else if (val instanceof String) {
				                ((FactorContext)_localctx).value =  Integer.parseInt((String) val);
				            } else {
				                error(((FactorContext)_localctx).IDENT, "Unsupported type for arithmetic: " + val.getClass().getSimpleName());
				                ((FactorContext)_localctx).hasKnownValue =  false;
				                ((FactorContext)_localctx).value =  0;
				            }
				          }
				        }
				      
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(LPAREN);
				setState(112);
				((FactorContext)_localctx).expr = expr();
				setState(113);
				match(RPAREN);
				 
				        if (((FactorContext)_localctx).expr.hasKnownValue) {
				          ((FactorContext)_localctx).hasKnownValue =  true;
				          ((FactorContext)_localctx).value =  ((FactorContext)_localctx).expr.value;
				        } else {
				          ((FactorContext)_localctx).hasKnownValue =  false;
				          ((FactorContext)_localctx).value =  0;
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
	public static class IfstmtContext extends ParserRuleContext {
		public TerminalNode KW_IF() { return getToken(EmoticonParser.KW_IF, 0); }
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
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(KW_IF);

			    if (!definingFunction) {
			      SymbolTable ifScope = new SymbolTable();
			      symbolStack.push(ifScope);
			    }
			  
			setState(120);
			match(LPAREN);
			setState(121);
			expr();
			setState(122);
			match(RPAREN);
			setState(123);
			s();

			    if (!definingFunction) {
			      symbolStack.pop();
			    }
			  
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(125);
				elsestmt();
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
	}

	public final ElsestmtContext elsestmt() throws RecognitionException {
		ElsestmtContext _localctx = new ElsestmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elsestmt);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ELSE_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(KW_ELSE_IF);

				    if (!definingFunction) {
				      SymbolTable elseIfScope = new SymbolTable();
				      symbolStack.push(elseIfScope);
				    }
				  
				setState(130);
				match(LPAREN);
				setState(131);
				expr();
				setState(132);
				match(RPAREN);
				setState(133);
				s();

				    if (!definingFunction) {
				      symbolStack.pop();
				    }
				  
				setState(136);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(135);
					elsestmt();
					}
					break;
				}
				}
				break;
			case KW_ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(KW_ELSE);

				    if (!definingFunction) {
				      SymbolTable elseScope = new SymbolTable();
				      symbolStack.push(elseScope);
				    }
				  
				setState(140);
				s();

				    if (!definingFunction) {
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
	}

	public final ForstmtContext forstmt() throws RecognitionException {
		ForstmtContext _localctx = new ForstmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(KW_FOR);
			setState(146);
			match(LPAREN);

			    if (!definingFunction) {
			      SymbolTable forScope = new SymbolTable();
			      symbolStack.push(forScope);
			    }
			  
			setState(148);
			as();
			setState(149);
			match(T__0);
			setState(150);
			expr();
			setState(151);
			match(T__0);
			setState(152);
			as();
			setState(153);
			match(RPAREN);
			setState(154);
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
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(KW_WHILE);

			    if (!definingFunction) {
			      SymbolTable whileScope = new SymbolTable();
			      symbolStack.push(whileScope);
			    }
			  
			setState(159);
			match(LPAREN);
			setState(160);
			expr();
			setState(161);
			match(RPAREN);
			setState(162);
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
	}

	public final FunctionstmtContext functionstmt() throws RecognitionException {
		FunctionstmtContext _localctx = new FunctionstmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionstmt);
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(KW_FUNCTION);
				setState(166);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(167);
				match(LPAREN);
				setState(168);
				((FunctionstmtContext)_localctx).param = match(IDENT);
				setState(169);
				match(RPAREN);

				    definingFunction = true;
				    functionDefDepth = 0;
				    FunctionDef func = new FunctionDef();
				    func.name = ((FunctionstmtContext)_localctx).name.getText();
				    func.paramName = ((FunctionstmtContext)_localctx).param.getText();
				    functions.put(func.name, func);
				    System.out.println("DEBUG: Defining function '" + func.name + "' with parameter '" + func.paramName + "'");
				  
				setState(171);
				((FunctionstmtContext)_localctx).body = s();

				    definingFunction = false;
				    functionDefDepth = 0;
				    FunctionDef funcDef = functions.get(((FunctionstmtContext)_localctx).name.getText());
				    funcDef.body = ((FunctionstmtContext)_localctx).body;
				    System.out.println("DEBUG: Function '" + funcDef.name + "' definition complete");
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(KW_FUNCTION);
				setState(175);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(176);
				match(LPAREN);
				setState(177);
				match(RPAREN);

				    definingFunction = true;
				    functionDefDepth = 0;
				    FunctionDef func2 = new FunctionDef();
				    func2.name = ((FunctionstmtContext)_localctx).name.getText();
				    func2.paramName = null;
				    functions.put(func2.name, func2);
				    System.out.println("DEBUG: Defining function '" + func2.name + "' with no parameters");
				  
				setState(179);
				((FunctionstmtContext)_localctx).body = s();

				    definingFunction = false;
				    functionDefDepth = 0;
				    FunctionDef funcDef2 = functions.get(((FunctionstmtContext)_localctx).name.getText());
				    funcDef2.body = ((FunctionstmtContext)_localctx).body;
				    System.out.println("DEBUG: Function '" + funcDef2.name + "' definition complete");
				  
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
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functioncall);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(185);
				match(LPAREN);
				setState(186);
				((FunctioncallContext)_localctx).arg = expr();
				setState(187);
				match(RPAREN);

				    String funcName = ((FunctioncallContext)_localctx).IDENT.getText();
				    if (!functions.containsKey(funcName)) {
				      error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' not defined");
				    } else {
				      FunctionDef func = functions.get(funcName);
				      System.out.println("DEBUG: Calling function '" + funcName + "' with argument " + ((FunctioncallContext)_localctx).arg.value);
				      
				      // Create new scope for function call
				      SymbolTable funcScope = new SymbolTable();
				      symbolStack.push(funcScope);
				      
				      // Add parameter with argument value if function has parameter
				      if (func.paramName != null) {
				        Identifier paramId = new Identifier();
				        paramId.id = func.paramName;
				        paramId.value = ((FunctioncallContext)_localctx).arg.value;
				        paramId.type = Type.INT;
				        paramId.hasKnown = ((FunctioncallContext)_localctx).arg.hasKnownValue;
				        paramId.hasBeenUsed = false;
				        addVariable(paramId);
				        System.out.println("DEBUG: Set parameter '" + func.paramName + "' = " + ((FunctioncallContext)_localctx).arg.value);
				      }
				      
				      // Execute function body
				      if (func.body != null) {
				        executeStatement(func.body);
				      }
				      
				      // Pop function scope after execution
				      symbolStack.pop();
				      System.out.println("DEBUG: Function '" + funcName + "' execution complete");
				    }
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(191);
				match(LPAREN);
				setState(192);
				match(RPAREN);

				    String funcName = ((FunctioncallContext)_localctx).IDENT.getText();
				    if (!functions.containsKey(funcName)) {
				      error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' not defined");
				    } else {
				      FunctionDef func = functions.get(funcName);
				      if (func.paramName != null) {
				        error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' expects a parameter");
				      } else {
				        System.out.println("DEBUG: Calling function '" + funcName + "'");
				        
				        // Create new scope for function call
				        SymbolTable funcScope = new SymbolTable();
				        symbolStack.push(funcScope);
				        
				        // Execute function body
				        if (func.body != null) {
				          executeStatement(func.body);
				        }
				        
				        // Pop function scope after execution
				        symbolStack.pop();
				        System.out.println("DEBUG: Function '" + funcName + "' execution complete");
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
	}

	public final ArraystmtContext arraystmt() throws RecognitionException {
		ArraystmtContext _localctx = new ArraystmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arraystmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(KW_ARRAY);
			setState(197);
			match(IDENT);
			setState(198);
			match(ASSIGNMENT);
			setState(199);
			match(T__1);
			setState(200);
			match(INT);
			setState(201);
			match(T__2);
			setState(202);
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
	}

	public final OperatorsContext operators() throws RecognitionException {
		OperatorsContext _localctx = new OperatorsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
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
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
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
		"\u0004\u0001 \u00d1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0004\u0000%\b\u0000"+
		"\u000b\u0000\f\u0000&\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00016\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002;\b\u0002\n\u0002\f\u0002>\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003N\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\\\b\u0005"+
		"\n\u0005\f\u0005_\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006g\b\u0006\n\u0006\f\u0006j\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007u\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u007f\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0089"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0090\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00b7\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c3"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0000\u0000\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0003\u0001\u0000"+
		"\u0013\u0014\u0001\u0000\u0015\u0016\u0001\u0000\u0013\u0016\u00d6\u0000"+
		"\"\u0001\u0000\u0000\u0000\u00025\u0001\u0000\u0000\u0000\u00047\u0001"+
		"\u0000\u0000\u0000\u0006B\u0001\u0000\u0000\u0000\bO\u0001\u0000\u0000"+
		"\u0000\nU\u0001\u0000\u0000\u0000\f`\u0001\u0000\u0000\u0000\u000et\u0001"+
		"\u0000\u0000\u0000\u0010v\u0001\u0000\u0000\u0000\u0012\u008f\u0001\u0000"+
		"\u0000\u0000\u0014\u0091\u0001\u0000\u0000\u0000\u0016\u009d\u0001\u0000"+
		"\u0000\u0000\u0018\u00b6\u0001\u0000\u0000\u0000\u001a\u00c2\u0001\u0000"+
		"\u0000\u0000\u001c\u00c4\u0001\u0000\u0000\u0000\u001e\u00cc\u0001\u0000"+
		"\u0000\u0000 \u00ce\u0001\u0000\u0000\u0000\"$\u0006\u0000\uffff\uffff"+
		"\u0000#%\u0003\u0002\u0001\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000"+
		"\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001"+
		"\u0000\u0000\u0000()\u0005\u0000\u0000\u0001)*\u0006\u0000\uffff\uffff"+
		"\u0000*\u0001\u0001\u0000\u0000\u0000+6\u0003\u001a\r\u0000,6\u0003\u0006"+
		"\u0003\u0000-6\u0003\b\u0004\u0000.6\u0003\n\u0005\u0000/6\u0003\u001c"+
		"\u000e\u000006\u0003\u0004\u0002\u000016\u0003\u0010\b\u000026\u0003\u0014"+
		"\n\u000036\u0003\u0016\u000b\u000046\u0003\u0018\f\u00005+\u0001\u0000"+
		"\u0000\u00005,\u0001\u0000\u0000\u00005-\u0001\u0000\u0000\u00005.\u0001"+
		"\u0000\u0000\u00005/\u0001\u0000\u0000\u000050\u0001\u0000\u0000\u0000"+
		"51\u0001\u0000\u0000\u000052\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000054\u0001\u0000\u0000\u00006\u0003\u0001\u0000\u0000\u000078\u0005"+
		"\r\u0000\u00008<\u0006\u0002\uffff\uffff\u00009;\u0003\u0002\u0001\u0000"+
		":9\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000?@\u0005\u000e\u0000\u0000@A\u0006\u0002\uffff\uffff\u0000"+
		"A\u0005\u0001\u0000\u0000\u0000BC\u0005\u0012\u0000\u0000CM\u0005 \u0000"+
		"\u0000DE\u0003\n\u0005\u0000EF\u0006\u0003\uffff\uffff\u0000FN\u0001\u0000"+
		"\u0000\u0000GH\u0005\u0004\u0000\u0000HN\u0006\u0003\uffff\uffff\u0000"+
		"IJ\u0005\u0019\u0000\u0000JN\u0006\u0003\uffff\uffff\u0000KL\u0005\u0018"+
		"\u0000\u0000LN\u0006\u0003\uffff\uffff\u0000MD\u0001\u0000\u0000\u0000"+
		"MG\u0001\u0000\u0000\u0000MI\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000"+
		"\u0000N\u0007\u0001\u0000\u0000\u0000OP\u0005\u0005\u0000\u0000PQ\u0005"+
		"\u001b\u0000\u0000QR\u0003\n\u0005\u0000RS\u0005\u001c\u0000\u0000ST\u0006"+
		"\u0004\uffff\uffff\u0000T\t\u0001\u0000\u0000\u0000UV\u0003\f\u0006\u0000"+
		"V]\u0006\u0005\uffff\uffff\u0000WX\u0007\u0000\u0000\u0000XY\u0003\f\u0006"+
		"\u0000YZ\u0006\u0005\uffff\uffff\u0000Z\\\u0001\u0000\u0000\u0000[W\u0001"+
		"\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000"+
		"]^\u0001\u0000\u0000\u0000^\u000b\u0001\u0000\u0000\u0000_]\u0001\u0000"+
		"\u0000\u0000`a\u0003\u000e\u0007\u0000ah\u0006\u0006\uffff\uffff\u0000"+
		"bc\u0007\u0001\u0000\u0000cd\u0003\u000e\u0007\u0000de\u0006\u0006\uffff"+
		"\uffff\u0000eg\u0001\u0000\u0000\u0000fb\u0001\u0000\u0000\u0000gj\u0001"+
		"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000"+
		"i\r\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0005\u0017\u0000"+
		"\u0000lu\u0006\u0007\uffff\uffff\u0000mn\u0005\u0012\u0000\u0000nu\u0006"+
		"\u0007\uffff\uffff\u0000op\u0005\u001b\u0000\u0000pq\u0003\n\u0005\u0000"+
		"qr\u0005\u001c\u0000\u0000rs\u0006\u0007\uffff\uffff\u0000su\u0001\u0000"+
		"\u0000\u0000tk\u0001\u0000\u0000\u0000tm\u0001\u0000\u0000\u0000to\u0001"+
		"\u0000\u0000\u0000u\u000f\u0001\u0000\u0000\u0000vw\u0005\u0006\u0000"+
		"\u0000wx\u0006\b\uffff\uffff\u0000xy\u0005\u001b\u0000\u0000yz\u0003\n"+
		"\u0005\u0000z{\u0005\u001c\u0000\u0000{|\u0003\u0002\u0001\u0000|~\u0006"+
		"\b\uffff\uffff\u0000}\u007f\u0003\u0012\t\u0000~}\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f\u0011\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0005\b\u0000\u0000\u0081\u0082\u0006\t\uffff\uffff\u0000\u0082"+
		"\u0083\u0005\u001b\u0000\u0000\u0083\u0084\u0003\n\u0005\u0000\u0084\u0085"+
		"\u0005\u001c\u0000\u0000\u0085\u0086\u0003\u0002\u0001\u0000\u0086\u0088"+
		"\u0006\t\uffff\uffff\u0000\u0087\u0089\u0003\u0012\t\u0000\u0088\u0087"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0090"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0007\u0000\u0000\u008b\u008c"+
		"\u0006\t\uffff\uffff\u0000\u008c\u008d\u0003\u0002\u0001\u0000\u008d\u008e"+
		"\u0006\t\uffff\uffff\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u0080"+
		"\u0001\u0000\u0000\u0000\u008f\u008a\u0001\u0000\u0000\u0000\u0090\u0013"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0005\t\u0000\u0000\u0092\u0093\u0005"+
		"\u001b\u0000\u0000\u0093\u0094\u0006\n\uffff\uffff\u0000\u0094\u0095\u0003"+
		"\u0006\u0003\u0000\u0095\u0096\u0005\u0001\u0000\u0000\u0096\u0097\u0003"+
		"\n\u0005\u0000\u0097\u0098\u0005\u0001\u0000\u0000\u0098\u0099\u0003\u0006"+
		"\u0003\u0000\u0099\u009a\u0005\u001c\u0000\u0000\u009a\u009b\u0003\u0002"+
		"\u0001\u0000\u009b\u009c\u0006\n\uffff\uffff\u0000\u009c\u0015\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0005\n\u0000\u0000\u009e\u009f\u0006\u000b\uffff"+
		"\uffff\u0000\u009f\u00a0\u0005\u001b\u0000\u0000\u00a0\u00a1\u0003\n\u0005"+
		"\u0000\u00a1\u00a2\u0005\u001c\u0000\u0000\u00a2\u00a3\u0003\u0002\u0001"+
		"\u0000\u00a3\u00a4\u0006\u000b\uffff\uffff\u0000\u00a4\u0017\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0005\u000b\u0000\u0000\u00a6\u00a7\u0005\u0012"+
		"\u0000\u0000\u00a7\u00a8\u0005\u001b\u0000\u0000\u00a8\u00a9\u0005\u0012"+
		"\u0000\u0000\u00a9\u00aa\u0005\u001c\u0000\u0000\u00aa\u00ab\u0006\f\uffff"+
		"\uffff\u0000\u00ab\u00ac\u0003\u0002\u0001\u0000\u00ac\u00ad\u0006\f\uffff"+
		"\uffff\u0000\u00ad\u00b7\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u000b"+
		"\u0000\u0000\u00af\u00b0\u0005\u0012\u0000\u0000\u00b0\u00b1\u0005\u001b"+
		"\u0000\u0000\u00b1\u00b2\u0005\u001c\u0000\u0000\u00b2\u00b3\u0006\f\uffff"+
		"\uffff\u0000\u00b3\u00b4\u0003\u0002\u0001\u0000\u00b4\u00b5\u0006\f\uffff"+
		"\uffff\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00a5\u0001\u0000"+
		"\u0000\u0000\u00b6\u00ae\u0001\u0000\u0000\u0000\u00b7\u0019\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0005\u0012\u0000\u0000\u00b9\u00ba\u0005\u001b"+
		"\u0000\u0000\u00ba\u00bb\u0003\n\u0005\u0000\u00bb\u00bc\u0005\u001c\u0000"+
		"\u0000\u00bc\u00bd\u0006\r\uffff\uffff\u0000\u00bd\u00c3\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0005\u0012\u0000\u0000\u00bf\u00c0\u0005\u001b\u0000"+
		"\u0000\u00c0\u00c1\u0005\u001c\u0000\u0000\u00c1\u00c3\u0006\r\uffff\uffff"+
		"\u0000\u00c2\u00b8\u0001\u0000\u0000\u0000\u00c2\u00be\u0001\u0000\u0000"+
		"\u0000\u00c3\u001b\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\f\u0000\u0000"+
		"\u00c5\u00c6\u0005\u0012\u0000\u0000\u00c6\u00c7\u0005 \u0000\u0000\u00c7"+
		"\u00c8\u0005\u0002\u0000\u0000\u00c8\u00c9\u0005\u0017\u0000\u0000\u00c9"+
		"\u00ca\u0005\u0003\u0000\u0000\u00ca\u00cb\u0003\u0002\u0001\u0000\u00cb"+
		"\u001d\u0001\u0000\u0000\u0000\u00cc\u00cd\u0007\u0002\u0000\u0000\u00cd"+
		"\u001f\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\u001f\u0000\u0000\u00cf"+
		"!\u0001\u0000\u0000\u0000\f&5<M]ht~\u0088\u008f\u00b6\u00c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
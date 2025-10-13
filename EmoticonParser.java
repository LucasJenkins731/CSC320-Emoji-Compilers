// Generated from Emoticon.g4 by ANTLR 4.13.2
 import java.util.*; 
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
		DIVIDE=22, INT=23, CHAR=24, STRING=25, WS=26, LPAREN=27, RPAREN=28, COMMENT=29, 
		COMMENT_BLOCK=30, COMPARISON=31, ASSIGNMENT=32;
	public static final int
		RULE_program = 0, RULE_s = 1, RULE_blockStatement = 2, RULE_as = 3, RULE_ps = 4, 
		RULE_expr = 5, RULE_term = 6, RULE_factor = 7, RULE_ifstmt = 8, RULE_elsestmt = 9, 
		RULE_forstmt = 10, RULE_whilestmt = 11, RULE_functionstmt = 12, RULE_arraystmt = 13, 
		RULE_stringstmt = 14, RULE_operators = 15, RULE_comp = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "s", "blockStatement", "as", "ps", "expr", "term", "factor", 
			"ifstmt", "elsestmt", "forstmt", "whilestmt", "functionstmt", "arraystmt", 
			"stringstmt", "operators", "comp"
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
	    INT, STRING, CHAR
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
	  
	  SymbolTable mainTable = new SymbolTable();
	  Stack<SymbolTable> symbolStack = new Stack<>();
	  
	  // Diagnostics
	  List<String> diagnostics = new ArrayList<>();
	  
	  // LHS tracking
	  String pendingLHS = null;
	  boolean lhsExistedBefore = false;
	  
	  // Error tracking
	  boolean hasErrors = false;
	    
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
	      // Check for redeclaration in global scope
	      if (mainTable.table.containsKey(id.id)) {
	        // Variable already exists - this is a reassignment, not an error
	        // Just update the existing entry
	        mainTable.table.put(id.id, id);
	      } else {
	        mainTable.table.put(id.id, id);
	      }
	    } else {
	      SymbolTable currentScope = symbolStack.peek();
	      // Check for redeclaration in current scope
	      if (currentScope.table.containsKey(id.id)) {
	        // Variable already declared in this scope - allow reassignment
	        currentScope.table.put(id.id, id);
	      } else {
	        currentScope.table.put(id.id, id);
	      }
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
		public StringstmtContext stringstmt() {
			return getRuleContext(StringstmtContext.class,0);
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
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				as();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				ps();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				arraystmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(47);
				stringstmt();
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
			setState(55);
			match(LBRACE);
			  
			    SymbolTable currentSymbolTable = new SymbolTable();
			    System.out.println("Debug: Pushing new symbol table for block");
			    symbolStack.push(currentSymbolTable); 
			  
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
			 
			    symbolStack.pop();
			    System.out.println("Debug: Popping symbol table for block");
			  
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
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(EmoticonParser.ASSIGNMENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
			setState(66);
			((AsContext)_localctx).IDENT = match(IDENT);

			      pendingLHS = ((AsContext)_localctx).IDENT.getText();
			      // Check if it exists in ANY scope
			      Identifier existing = lookupVariable(pendingLHS);
			      lhsExistedBefore = (existing != null);
			    
			setState(68);
			match(ASSIGNMENT);
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case INT:
			case LPAREN:
				{
				setState(69);
				((AsContext)_localctx).expr = expr();

				            Identifier newId = new Identifier();
				            newId.id = pendingLHS;
				            newId.value = ((AsContext)_localctx).expr.value;
				            newId.type = Type.INT; // Since expr returns float, treat as INT
				            newId.hasKnown = ((AsContext)_localctx).expr.hasKnownValue;
				            newId.hasBeenUsed = false;
				            
				            // Type checking: if variable existed before, check type compatibility
				            if (lhsExistedBefore) {
				              Identifier oldId = lookupVariable(pendingLHS);
				              if (oldId != null && oldId.type != Type.INT && !existsInCurrentScope(pendingLHS)) {
				                error(((AsContext)_localctx).IDENT, "type mismatch: '" + pendingLHS + "' was previously " + oldId.type + ", now assigning INT");
				              }
				            }
				            
				            // Add to CURRENT scope
				            addVariable(newId);
				            
				            pendingLHS = null;
				          
				}
				break;
			case KW_READ:
				{
				setState(72);
				match(KW_READ);

				            Identifier newId = new Identifier();
				            newId.id = pendingLHS;
				            newId.value = 0;
				            newId.type = Type.INT;
				            newId.hasKnown = false;
				            newId.hasBeenUsed = false;
				            
				            addVariable(newId);
				            
				            pendingLHS = null;
				          
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
			setState(76);
			match(KW_PRINT);
			setState(77);
			match(LPAREN);
			setState(78);
			((PsContext)_localctx).expr = expr();
			setState(79);
			match(RPAREN);

			      if (((PsContext)_localctx).expr.hasKnownValue) {
			        System.out.println("Debug: Print value = " + ((PsContext)_localctx).expr.value);
			      } else {
			        System.out.println("Debug: Print unknown value");
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
		public float value;
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			((ExprContext)_localctx).a = term();

			      if (((ExprContext)_localctx).a.hasKnownValue) {
			        ((ExprContext)_localctx).hasKnownValue =  true;
			        ((ExprContext)_localctx).value =  ((ExprContext)_localctx).a.value;
			      } else {
			        ((ExprContext)_localctx).hasKnownValue =  false;
			      } 
			    
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUBTRACT) {
				{
				{
				setState(84);
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
				setState(85);
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
				setState(92);
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
		public float value;
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			((TermContext)_localctx).a = factor();

			      if (((TermContext)_localctx).a.hasKnownValue) {
			        ((TermContext)_localctx).hasKnownValue =  true;
			        ((TermContext)_localctx).value =  ((TermContext)_localctx).a.value;
			      } else {
			        ((TermContext)_localctx).hasKnownValue =  false;
			      }
			    
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY || _la==DIVIDE) {
				{
				{
				setState(95);
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
				setState(96);
				((TermContext)_localctx).b = factor();

				      if (((TermContext)_localctx).b.hasKnownValue && ((TermContext)_localctx).op.getText().equals(":/)") && ((TermContext)_localctx).b.value == 0) {
				        error(((TermContext)_localctx).op, "division by zero");
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
				setState(103);
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
		public float value;
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
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				((FactorContext)_localctx).INT = match(INT);
				 
				        ((FactorContext)_localctx).hasKnownValue =  true; 
				        ((FactorContext)_localctx).value =  Integer.parseInt(((FactorContext)_localctx).INT.getText());
				      
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				((FactorContext)_localctx).IDENT = match(IDENT);

				        String id = ((FactorContext)_localctx).IDENT.getText();
				        
				        // Use lookupVariable instead of mainTable.table.get
				        Identifier currentId = lookupVariable(id);
				        
				        if (currentId == null) {
				          if (pendingLHS != null && !lhsExistedBefore && id.equals(pendingLHS)) {
				            error(((FactorContext)_localctx).IDENT, "self-reference on first assignment of '" + pendingLHS + "'");
				          } else {
				            error(((FactorContext)_localctx).IDENT, "use of variable '" + id + "' before assignment");
				          }
				          ((FactorContext)_localctx).hasKnownValue =  false;
				          ((FactorContext)_localctx).value =  0; // Default value to prevent crashes
				        } else {
				          // Type checking for integer context
				          if (currentId.type != Type.INT) {
				            error(((FactorContext)_localctx).IDENT, "'" + id + "' is not of type int (is " + currentId.type + ")");
				            ((FactorContext)_localctx).hasKnownValue =  false;
				            ((FactorContext)_localctx).value =  0;
				          } else {
				            currentId.hasBeenUsed = true;
				            ((FactorContext)_localctx).hasKnownValue =  currentId.hasKnown;
				            if (currentId.value instanceof Number) {
				              ((FactorContext)_localctx).value =  ((Number)currentId.value).floatValue();
				            } else {
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
				setState(108);
				match(LPAREN);
				setState(109);
				((FactorContext)_localctx).expr = expr();
				setState(110);
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
			setState(115);
			match(KW_IF);

			    SymbolTable ifScope = new SymbolTable();
			    System.out.println("Debug: Pushing new symbol table for if");
			    symbolStack.push(ifScope);
			  
			setState(117);
			match(LPAREN);
			setState(118);
			expr();
			setState(119);
			match(RPAREN);
			setState(120);
			s();

			    symbolStack.pop();
			    System.out.println("Debug: Popping symbol table for if");
			  
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(122);
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
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ELSE_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(KW_ELSE_IF);

				    SymbolTable elseIfScope = new SymbolTable();
				    System.out.println("Debug: Pushing new symbol table for else-if");
				    symbolStack.push(elseIfScope);
				  
				setState(127);
				match(LPAREN);
				setState(128);
				expr();
				setState(129);
				match(RPAREN);
				setState(130);
				s();

				    symbolStack.pop();
				    System.out.println("Debug: Popping symbol table for else-if");
				  
				setState(133);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(132);
					elsestmt();
					}
					break;
				}
				}
				break;
			case KW_ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(KW_ELSE);

				    SymbolTable elseScope = new SymbolTable();
				    System.out.println("Debug: Pushing new symbol table for else");
				    symbolStack.push(elseScope);
				  
				setState(137);
				s();

				    symbolStack.pop();
				    System.out.println("Debug: Popping symbol table for else");
				  
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
			setState(142);
			match(KW_FOR);
			setState(143);
			match(LPAREN);

			    SymbolTable forScope = new SymbolTable();
			    System.out.println("Debug: Pushing new symbol table for for-loop");
			    symbolStack.push(forScope);
			  
			setState(145);
			as();
			setState(146);
			match(T__0);
			setState(147);
			expr();
			setState(148);
			match(T__0);
			setState(149);
			as();
			setState(150);
			match(RPAREN);
			setState(151);
			s();

			    symbolStack.pop();
			    System.out.println("Debug: Popping symbol table for for-loop");
			  
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
			setState(154);
			match(KW_WHILE);

			    SymbolTable whileScope = new SymbolTable();
			    System.out.println("Debug: Pushing new symbol table for while-loop");
			    symbolStack.push(whileScope);
			  
			setState(156);
			match(LPAREN);
			setState(157);
			expr();
			setState(158);
			match(RPAREN);
			setState(159);
			s();

			    symbolStack.pop();
			    System.out.println("Debug: Popping symbol table for while-loop");
			  
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
		public Token param;
		public TerminalNode KW_FUNCTION() { return getToken(EmoticonParser.KW_FUNCTION, 0); }
		public List<TerminalNode> IDENT() { return getTokens(EmoticonParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(EmoticonParser.IDENT, i);
		}
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
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
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(KW_FUNCTION);
				setState(163);
				match(IDENT);
				setState(164);
				match(LPAREN);
				setState(165);
				((FunctionstmtContext)_localctx).param = match(IDENT);
				setState(166);
				match(RPAREN);

				    SymbolTable funcScope = new SymbolTable();
				    System.out.println("Debug: Pushing new symbol table for function");
				    symbolStack.push(funcScope);
				    
				    // Add parameter to function scope
				    Identifier paramId = new Identifier();
				    paramId.id = ((FunctionstmtContext)_localctx).param.getText();
				    paramId.value = 0;
				    paramId.type = Type.INT;
				    paramId.hasKnown = false;
				    paramId.hasBeenUsed = false;
				    addVariable(paramId);
				  
				setState(168);
				s();

				    symbolStack.pop();
				    System.out.println("Debug: Popping symbol table for function");
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(KW_FUNCTION);
				setState(172);
				match(IDENT);
				setState(173);
				match(LPAREN);
				setState(174);
				match(RPAREN);

				    SymbolTable funcScope = new SymbolTable();
				    System.out.println("Debug: Pushing new symbol table for function (no params)");
				    symbolStack.push(funcScope);
				  
				setState(176);
				s();

				    symbolStack.pop();
				    System.out.println("Debug: Popping symbol table for function (no params)");
				  
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
		enterRule(_localctx, 26, RULE_arraystmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(KW_ARRAY);
			setState(182);
			match(IDENT);
			setState(183);
			match(ASSIGNMENT);
			setState(184);
			match(T__1);
			setState(185);
			match(INT);
			setState(186);
			match(T__2);
			setState(187);
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
	public static class StringstmtContext extends ParserRuleContext {
		public Token IDENT;
		public Token STRING;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(EmoticonParser.ASSIGNMENT, 0); }
		public TerminalNode STRING() { return getToken(EmoticonParser.STRING, 0); }
		public StringstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterStringstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitStringstmt(this);
		}
	}

	public final StringstmtContext stringstmt() throws RecognitionException {
		StringstmtContext _localctx = new StringstmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stringstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			((StringstmtContext)_localctx).IDENT = match(IDENT);
			setState(190);
			match(ASSIGNMENT);
			setState(191);
			((StringstmtContext)_localctx).STRING = match(STRING);

			    String varName = ((StringstmtContext)_localctx).IDENT.getText();
			    Identifier strId = new Identifier();
			    strId.id = varName;
			    strId.value = ((StringstmtContext)_localctx).STRING.getText();
			    strId.type = Type.STRING;
			    strId.hasKnown = true;
			    strId.hasBeenUsed = false;
			    
			    addVariable(strId);
			  
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
			setState(194);
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
			setState(196);
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
		"\u0004\u0001 \u00c7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"K\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005Y\b\u0005\n\u0005\f\u0005\\\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"d\b\u0006\n\u0006\f\u0006g\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007r\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\b|\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0003\t\u0086\b\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u008d\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00b4\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0000\u0011\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \u0000\u0003\u0001\u0000\u0013\u0014\u0001\u0000\u0015\u0016\u0001"+
		"\u0000\u0013\u0016\u00c9\u0000\"\u0001\u0000\u0000\u0000\u00025\u0001"+
		"\u0000\u0000\u0000\u00047\u0001\u0000\u0000\u0000\u0006B\u0001\u0000\u0000"+
		"\u0000\bL\u0001\u0000\u0000\u0000\nR\u0001\u0000\u0000\u0000\f]\u0001"+
		"\u0000\u0000\u0000\u000eq\u0001\u0000\u0000\u0000\u0010s\u0001\u0000\u0000"+
		"\u0000\u0012\u008c\u0001\u0000\u0000\u0000\u0014\u008e\u0001\u0000\u0000"+
		"\u0000\u0016\u009a\u0001\u0000\u0000\u0000\u0018\u00b3\u0001\u0000\u0000"+
		"\u0000\u001a\u00b5\u0001\u0000\u0000\u0000\u001c\u00bd\u0001\u0000\u0000"+
		"\u0000\u001e\u00c2\u0001\u0000\u0000\u0000 \u00c4\u0001\u0000\u0000\u0000"+
		"\"$\u0006\u0000\uffff\uffff\u0000#%\u0003\u0002\u0001\u0000$#\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0005\u0000\u0000\u0001"+
		")*\u0006\u0000\uffff\uffff\u0000*\u0001\u0001\u0000\u0000\u0000+6\u0003"+
		"\u0006\u0003\u0000,6\u0003\b\u0004\u0000-6\u0003\n\u0005\u0000.6\u0003"+
		"\u001a\r\u0000/6\u0003\u001c\u000e\u000006\u0003\u0004\u0002\u000016\u0003"+
		"\u0010\b\u000026\u0003\u0014\n\u000036\u0003\u0016\u000b\u000046\u0003"+
		"\u0018\f\u00005+\u0001\u0000\u0000\u00005,\u0001\u0000\u0000\u00005-\u0001"+
		"\u0000\u0000\u00005.\u0001\u0000\u0000\u00005/\u0001\u0000\u0000\u0000"+
		"50\u0001\u0000\u0000\u000051\u0001\u0000\u0000\u000052\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u00006\u0003\u0001"+
		"\u0000\u0000\u000078\u0005\r\u0000\u00008<\u0006\u0002\uffff\uffff\u0000"+
		"9;\u0003\u0002\u0001\u0000:9\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000"+
		"\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000?@\u0005\u000e\u0000\u0000@A\u0006"+
		"\u0002\uffff\uffff\u0000A\u0005\u0001\u0000\u0000\u0000BC\u0005\u0012"+
		"\u0000\u0000CD\u0006\u0003\uffff\uffff\u0000DJ\u0005 \u0000\u0000EF\u0003"+
		"\n\u0005\u0000FG\u0006\u0003\uffff\uffff\u0000GK\u0001\u0000\u0000\u0000"+
		"HI\u0005\u0004\u0000\u0000IK\u0006\u0003\uffff\uffff\u0000JE\u0001\u0000"+
		"\u0000\u0000JH\u0001\u0000\u0000\u0000K\u0007\u0001\u0000\u0000\u0000"+
		"LM\u0005\u0005\u0000\u0000MN\u0005\u001b\u0000\u0000NO\u0003\n\u0005\u0000"+
		"OP\u0005\u001c\u0000\u0000PQ\u0006\u0004\uffff\uffff\u0000Q\t\u0001\u0000"+
		"\u0000\u0000RS\u0003\f\u0006\u0000SZ\u0006\u0005\uffff\uffff\u0000TU\u0007"+
		"\u0000\u0000\u0000UV\u0003\f\u0006\u0000VW\u0006\u0005\uffff\uffff\u0000"+
		"WY\u0001\u0000\u0000\u0000XT\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u000b\u0001"+
		"\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]^\u0003\u000e\u0007\u0000"+
		"^e\u0006\u0006\uffff\uffff\u0000_`\u0007\u0001\u0000\u0000`a\u0003\u000e"+
		"\u0007\u0000ab\u0006\u0006\uffff\uffff\u0000bd\u0001\u0000\u0000\u0000"+
		"c_\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000"+
		"\u0000ef\u0001\u0000\u0000\u0000f\r\u0001\u0000\u0000\u0000ge\u0001\u0000"+
		"\u0000\u0000hi\u0005\u0017\u0000\u0000ir\u0006\u0007\uffff\uffff\u0000"+
		"jk\u0005\u0012\u0000\u0000kr\u0006\u0007\uffff\uffff\u0000lm\u0005\u001b"+
		"\u0000\u0000mn\u0003\n\u0005\u0000no\u0005\u001c\u0000\u0000op\u0006\u0007"+
		"\uffff\uffff\u0000pr\u0001\u0000\u0000\u0000qh\u0001\u0000\u0000\u0000"+
		"qj\u0001\u0000\u0000\u0000ql\u0001\u0000\u0000\u0000r\u000f\u0001\u0000"+
		"\u0000\u0000st\u0005\u0006\u0000\u0000tu\u0006\b\uffff\uffff\u0000uv\u0005"+
		"\u001b\u0000\u0000vw\u0003\n\u0005\u0000wx\u0005\u001c\u0000\u0000xy\u0003"+
		"\u0002\u0001\u0000y{\u0006\b\uffff\uffff\u0000z|\u0003\u0012\t\u0000{"+
		"z\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|\u0011\u0001\u0000"+
		"\u0000\u0000}~\u0005\b\u0000\u0000~\u007f\u0006\t\uffff\uffff\u0000\u007f"+
		"\u0080\u0005\u001b\u0000\u0000\u0080\u0081\u0003\n\u0005\u0000\u0081\u0082"+
		"\u0005\u001c\u0000\u0000\u0082\u0083\u0003\u0002\u0001\u0000\u0083\u0085"+
		"\u0006\t\uffff\uffff\u0000\u0084\u0086\u0003\u0012\t\u0000\u0085\u0084"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u008d"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0007\u0000\u0000\u0088\u0089"+
		"\u0006\t\uffff\uffff\u0000\u0089\u008a\u0003\u0002\u0001\u0000\u008a\u008b"+
		"\u0006\t\uffff\uffff\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c}"+
		"\u0001\u0000\u0000\u0000\u008c\u0087\u0001\u0000\u0000\u0000\u008d\u0013"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0005\t\u0000\u0000\u008f\u0090\u0005"+
		"\u001b\u0000\u0000\u0090\u0091\u0006\n\uffff\uffff\u0000\u0091\u0092\u0003"+
		"\u0006\u0003\u0000\u0092\u0093\u0005\u0001\u0000\u0000\u0093\u0094\u0003"+
		"\n\u0005\u0000\u0094\u0095\u0005\u0001\u0000\u0000\u0095\u0096\u0003\u0006"+
		"\u0003\u0000\u0096\u0097\u0005\u001c\u0000\u0000\u0097\u0098\u0003\u0002"+
		"\u0001\u0000\u0098\u0099\u0006\n\uffff\uffff\u0000\u0099\u0015\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0005\n\u0000\u0000\u009b\u009c\u0006\u000b\uffff"+
		"\uffff\u0000\u009c\u009d\u0005\u001b\u0000\u0000\u009d\u009e\u0003\n\u0005"+
		"\u0000\u009e\u009f\u0005\u001c\u0000\u0000\u009f\u00a0\u0003\u0002\u0001"+
		"\u0000\u00a0\u00a1\u0006\u000b\uffff\uffff\u0000\u00a1\u0017\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005\u000b\u0000\u0000\u00a3\u00a4\u0005\u0012"+
		"\u0000\u0000\u00a4\u00a5\u0005\u001b\u0000\u0000\u00a5\u00a6\u0005\u0012"+
		"\u0000\u0000\u00a6\u00a7\u0005\u001c\u0000\u0000\u00a7\u00a8\u0006\f\uffff"+
		"\uffff\u0000\u00a8\u00a9\u0003\u0002\u0001\u0000\u00a9\u00aa\u0006\f\uffff"+
		"\uffff\u0000\u00aa\u00b4\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u000b"+
		"\u0000\u0000\u00ac\u00ad\u0005\u0012\u0000\u0000\u00ad\u00ae\u0005\u001b"+
		"\u0000\u0000\u00ae\u00af\u0005\u001c\u0000\u0000\u00af\u00b0\u0006\f\uffff"+
		"\uffff\u0000\u00b0\u00b1\u0003\u0002\u0001\u0000\u00b1\u00b2\u0006\f\uffff"+
		"\uffff\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3\u00a2\u0001\u0000"+
		"\u0000\u0000\u00b3\u00ab\u0001\u0000\u0000\u0000\u00b4\u0019\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0005\f\u0000\u0000\u00b6\u00b7\u0005\u0012\u0000"+
		"\u0000\u00b7\u00b8\u0005 \u0000\u0000\u00b8\u00b9\u0005\u0002\u0000\u0000"+
		"\u00b9\u00ba\u0005\u0017\u0000\u0000\u00ba\u00bb\u0005\u0003\u0000\u0000"+
		"\u00bb\u00bc\u0003\u0002\u0001\u0000\u00bc\u001b\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0005\u0012\u0000\u0000\u00be\u00bf\u0005 \u0000\u0000\u00bf"+
		"\u00c0\u0005\u0019\u0000\u0000\u00c0\u00c1\u0006\u000e\uffff\uffff\u0000"+
		"\u00c1\u001d\u0001\u0000\u0000\u0000\u00c2\u00c3\u0007\u0002\u0000\u0000"+
		"\u00c3\u001f\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u001f\u0000\u0000"+
		"\u00c5!\u0001\u0000\u0000\u0000\u000b&5<JZeq{\u0085\u008c\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
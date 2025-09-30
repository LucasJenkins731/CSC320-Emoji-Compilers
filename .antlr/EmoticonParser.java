// Generated from /Users/connorryan/Desktop/CSC320-Emoji-Compilers/Emoticon.g4 by ANTLR 4.13.1
 import java.util.*; 
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
		KW_FOR=9, KW_WHILE=10, KW_FUNCTION=11, KW_ARRAY=12, IDENT=13, ADD=14, 
		SUBTRACT=15, MULTIPLY=16, DIVIDE=17, INT=18, STRING=19, WS=20, LPAREN=21, 
		RPAREN=22, COMMENT=23, COMMENT_BLOCK=24, COMPARISON=25, ASSIGNMENT=26, 
		LBRACE=27, RBRACE=28;
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
			"'>:('", "'D:<'", "'=^._.^='", "'(o_o)'", null, "':+)'", "':-)'", "':*)'", 
			"':/)'", null, null, null, "'('", "')'", null, null, "':==)'", "':=)'", 
			"'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", 
			"KW_FOR", "KW_WHILE", "KW_FUNCTION", "KW_ARRAY", "IDENT", "ADD", "SUBTRACT", 
			"MULTIPLY", "DIVIDE", "INT", "STRING", "WS", "LPAREN", "RPAREN", "COMMENT", 
			"COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT", "LBRACE", "RBRACE"
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



	  class Identifier {
	    String id;
	    float value;
	    boolean hasKnown;
	    boolean hasBeenUsed;
	  }

	  class SymbolTable {
	    Map<String, Identifier> table = new HashMap<>();
	  }
	    // for the variables that are assigned (self explanatory)
	    set<string> assigned = new hashTable<>();

	    //used?
	    set<string> used = new hashTable<>();
	    // diagnostics
	    set<string> diagnostics = new hashTable<>();
	    // lhs stuff
	    String pendingLHS = null;
	    // error stuff
	    boolean lhsExistedBefore = false;
	    
	    void error(Token t, String msg) {
	        diagnostics.add("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + msg);
	    }

	    void printDiagnostics() {
	      // After parsing the whole file: report unused variables and print errors.
	      for (String v : assigned) {
	        if (!used.contains(v)) {
	          System.err.println("warning: variable '" + v + "' assigned but never used");
	        }
	      }
	      for (String d : diagnostics) {
	        System.err.println("error: " + d);
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				s();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2375648L) != 0) );
			setState(39);
			match(EOF);
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
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_s);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				as();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				ps();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				arraystmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				stringstmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				blockStatement();
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
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public ElsestmtContext elsestmt() {
			return getRuleContext(ElsestmtContext.class,0);
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
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStatement);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				ifstmt();
				}
				break;
			case KW_ELSE:
			case KW_ELSE_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				elsestmt();
				}
				break;
			case KW_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				forstmt();
				}
				break;
			case KW_WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				whilestmt();
				}
				break;
			case KW_FUNCTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(53);
				functionstmt();
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
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			((AsContext)_localctx).IDENT = match(IDENT);

			      // We're entering an assignment: record LHS and whether it existed before.
			      pendingLHS = ((AsContext)_localctx).IDENT.getText();
			      lhsExistedBefore = mainTable.table.containsKey(pendingLHS);
			    
			setState(58);
			match(ASSIGNMENT);
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case INT:
			case LPAREN:
				{
				setState(59);
				((AsContext)_localctx).expr = expr();

				            // Successful RHS parse: consider variable now assigned.
				            assigned.add(pendingLHS);
				            Identifier newId = new Identifier();
				            newId.id = pendingLHS;
				            newId.value = ((AsContext)_localctx).expr.value;
				            newId.hasKnown = ((AsContext)_localctx).expr.hasKnownValue;
				            newId.hasBeenUsed = false;
				            mainTable.table.put(newId.id, newId);

				            // Clear LHS context.
				            pendingLHS = null;
				          
				}
				break;
			case KW_READ:
				{
				setState(62);
				match(KW_READ);

				            // Successful RHS parse: consider variable now assigned.
				            assigned.add(pendingLHS);
				            Identifier newId = new Identifier();
				            newId.id = pendingLHS;
				            newId.value = 0;
				            newId.hasKnown = false;
				            newId.hasBeenUsed = false;
				            mainTable.table.put(newId.id, newId);

				            // Clear LHS context.
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
		public Token KW_PRINT;
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
			setState(66);
			((PsContext)_localctx).KW_PRINT = match(KW_PRINT);
			setState(67);
			match(LPAREN);
			setState(68);
			((PsContext)_localctx).expr = expr();
			setState(69);
			match(RPAREN);

			      if (((PsContext)_localctx).expr.hasKnownValue) {
			        // Let us print it out (for debugging purposes really)
			        System.out.println("DEBUG: Line " + ((PsContext)_localctx).KW_PRINT.getLine() + ": Printing known value: " + ((PsContext)_localctx).expr.value);
			      } else {
			        System.out.println("DEBUG: Line " + ((PsContext)_localctx).KW_PRINT.getLine() + ": Can't print this value. Need to evaluate further.");
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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			((ExprContext)_localctx).a = term();

			      if (((ExprContext)_localctx).a.hasKnownValue) {
			        ((ExprContext)_localctx).hasKnownValue =  true;
			        ((ExprContext)_localctx).value =  ((ExprContext)_localctx).a.value;
			      } else {
			        ((ExprContext)_localctx).hasKnownValue =  false;
			      } 
			    
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUBTRACT) {
				{
				{
				setState(74);
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
				setState(75);
				((ExprContext)_localctx).b = term();

				      if (_localctx.hasKnownValue && ((ExprContext)_localctx).b.hasKnownValue) {
				        if (((ExprContext)_localctx).op.getText().equals(ADD)) {
				          ((ExprContext)_localctx).value =  _localctx.value + ((ExprContext)_localctx).b.value;
				        } else {
				          ((ExprContext)_localctx).value =  _localctx.value - ((ExprContext)_localctx).b.value;
				        }
				      } else {
				        ((ExprContext)_localctx).hasKnownValue =  false;
				      }
				    
				}
				}
				setState(82);
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
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			((TermContext)_localctx).a = factor();

			      if (((TermContext)_localctx).a.hasKnownValue) {
			        ((TermContext)_localctx).hasKnownValue =  true;
			        ((TermContext)_localctx).value =  ((TermContext)_localctx).a.value;
			      } else ((TermContext)_localctx).hasKnownValue =  false;
			    
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY || _la==DIVIDE) {
				{
				{
				setState(85);
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
				setState(86);
				((TermContext)_localctx).b = factor();

				        // First check for division by zero when b has value 0 (and /).
				        if (((TermContext)_localctx).b.hasKnownValue && ((TermContext)_localctx).op.getText().equals(DIVIDE) && ((TermContext)_localctx).b.value == 0) {
				          error(((TermContext)_localctx).op, "division by zero");
				          ((TermContext)_localctx).hasKnownValue =  false;  // Error anyway so stopping there
				        } else if (_localctx.hasKnownValue && ((TermContext)_localctx).b.hasKnownValue) {
				          if (((TermContext)_localctx).op.getText().equals(MULTIPLY)) {
				            ((TermContext)_localctx).value =  _localctx.value * ((TermContext)_localctx).b.value;
				          } else {
				            ((TermContext)_localctx).value =  _localctx.value / ((TermContext)_localctx).b.value;
				          }
				        } else {
				          ((TermContext)_localctx).hasKnownValue =  false;
				        }
				      
				}
				}
				setState(93);
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
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_factor);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				((FactorContext)_localctx).INT = match(INT);
				 ((FactorContext)_localctx).hasKnownValue =  true; ((FactorContext)_localctx).value =  Integer.parseInt(((FactorContext)_localctx).INT.getText()); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				((FactorContext)_localctx).IDENT = match(IDENT);

				        String id = ((FactorContext)_localctx).IDENT.getText();
				        used.add(id);

				        Identifier currentId = mainTable.table.get(id);
				        if (currentId == null) {
				          // Variable used before declaration error
				          if (pendingLHS != null && !lhsExistedBefore && id.equals(pendingLHS)) {
				            error(((FactorContext)_localctx).IDENT, "self-reference on first assignment of '" + pendingLHS + "'");
				          } else {
				            error(((FactorContext)_localctx).IDENT, "use of variable '" + id + "' before assignment");
				          }
				          ((FactorContext)_localctx).hasKnownValue =  false;
				        } else {
				          currentId.hasBeenUsed = true;
				          ((FactorContext)_localctx).hasKnownValue =  currentId.hasKnown;
				          ((FactorContext)_localctx).value =  currentId.value;
				        }
				      
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				match(LPAREN);
				setState(99);
				((FactorContext)_localctx).expr = expr();
				setState(100);
				match(RPAREN);
				 
				        if (((FactorContext)_localctx).expr.hasKnownValue) {
				          ((FactorContext)_localctx).hasKnownValue =  true;
				          ((FactorContext)_localctx).value =  ((FactorContext)_localctx).expr.value;
				        } else {
				          ((FactorContext)_localctx).hasKnownValue =  false;
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
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(KW_IF);
				setState(106);
				match(LPAREN);
				setState(107);
				expr();
				setState(108);
				match(RPAREN);
				setState(109);
				s();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(KW_IF);
				setState(112);
				match(LPAREN);
				setState(113);
				expr();
				setState(114);
				match(RPAREN);
				setState(115);
				elsestmt();
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
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ELSE_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(KW_ELSE_IF);
				setState(120);
				match(LPAREN);
				setState(121);
				expr();
				setState(122);
				match(RPAREN);
				setState(123);
				s();
				setState(124);
				elsestmt();
				}
				break;
			case KW_ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(KW_ELSE);
				setState(127);
				s();
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
			setState(130);
			match(KW_FOR);
			setState(131);
			match(LPAREN);
			setState(132);
			as();
			setState(133);
			match(T__0);
			setState(134);
			expr();
			setState(135);
			match(T__0);
			setState(136);
			as();
			setState(137);
			match(RPAREN);
			setState(138);
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
			setState(140);
			match(KW_WHILE);
			setState(141);
			match(LPAREN);
			setState(142);
			expr();
			setState(143);
			match(RPAREN);
			setState(144);
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
	public static class FunctionstmtContext extends ParserRuleContext {
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
	}

	public final FunctionstmtContext functionstmt() throws RecognitionException {
		FunctionstmtContext _localctx = new FunctionstmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionstmt);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(KW_FUNCTION);
				setState(147);
				match(IDENT);
				setState(148);
				match(LPAREN);
				setState(149);
				match(IDENT);
				setState(150);
				match(RPAREN);
				setState(151);
				s();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(KW_FUNCTION);
				setState(153);
				match(IDENT);
				setState(154);
				match(LPAREN);
				setState(155);
				match(RPAREN);
				setState(156);
				s();
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
		enterRule(_localctx, 26, RULE_arraystmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(KW_ARRAY);
			setState(160);
			match(IDENT);
			setState(161);
			match(ASSIGNMENT);
			setState(162);
			match(T__1);
			setState(163);
			match(INT);
			setState(164);
			match(T__2);
			setState(165);
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
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(EmoticonParser.ASSIGNMENT, 0); }
		public TerminalNode STRING() { return getToken(EmoticonParser.STRING, 0); }
		public StringstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringstmt; }
	}

	public final StringstmtContext stringstmt() throws RecognitionException {
		StringstmtContext _localctx = new StringstmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stringstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(IDENT);
			setState(168);
			match(ASSIGNMENT);
			setState(169);
			match(STRING);
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
			setState(171);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) ) {
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
			setState(173);
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
		"\u0004\u0001\u001c\u00b0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0004\u0000$\b\u0000\u000b"+
		"\u0000\f\u0000%\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00027\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003A\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005O\b"+
		"\u0005\n\u0005\f\u0005R\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006Z\b\u0006\n\u0006\f\u0006]\t"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007h\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bv\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0081\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u009e\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0000\u0011\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \u0000\u0003\u0001\u0000\u000e\u000f\u0001\u0000\u0010\u0011\u0001"+
		"\u0000\u000e\u0011\u00b0\u0000#\u0001\u0000\u0000\u0000\u0002/\u0001\u0000"+
		"\u0000\u0000\u00046\u0001\u0000\u0000\u0000\u00068\u0001\u0000\u0000\u0000"+
		"\bB\u0001\u0000\u0000\u0000\nH\u0001\u0000\u0000\u0000\fS\u0001\u0000"+
		"\u0000\u0000\u000eg\u0001\u0000\u0000\u0000\u0010u\u0001\u0000\u0000\u0000"+
		"\u0012\u0080\u0001\u0000\u0000\u0000\u0014\u0082\u0001\u0000\u0000\u0000"+
		"\u0016\u008c\u0001\u0000\u0000\u0000\u0018\u009d\u0001\u0000\u0000\u0000"+
		"\u001a\u009f\u0001\u0000\u0000\u0000\u001c\u00a7\u0001\u0000\u0000\u0000"+
		"\u001e\u00ab\u0001\u0000\u0000\u0000 \u00ad\u0001\u0000\u0000\u0000\""+
		"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000"+
		"\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\'(\u0005\u0000\u0000\u0001(\u0001\u0001\u0000\u0000\u0000"+
		")0\u0003\u0006\u0003\u0000*0\u0003\b\u0004\u0000+0\u0003\n\u0005\u0000"+
		",0\u0003\u001a\r\u0000-0\u0003\u001c\u000e\u0000.0\u0003\u0004\u0002\u0000"+
		"/)\u0001\u0000\u0000\u0000/*\u0001\u0000\u0000\u0000/+\u0001\u0000\u0000"+
		"\u0000/,\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/.\u0001\u0000"+
		"\u0000\u00000\u0003\u0001\u0000\u0000\u000017\u0003\u0010\b\u000027\u0003"+
		"\u0012\t\u000037\u0003\u0014\n\u000047\u0003\u0016\u000b\u000057\u0003"+
		"\u0018\f\u000061\u0001\u0000\u0000\u000062\u0001\u0000\u0000\u000063\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u0000"+
		"7\u0005\u0001\u0000\u0000\u000089\u0005\r\u0000\u00009:\u0006\u0003\uffff"+
		"\uffff\u0000:@\u0005\u001a\u0000\u0000;<\u0003\n\u0005\u0000<=\u0006\u0003"+
		"\uffff\uffff\u0000=A\u0001\u0000\u0000\u0000>?\u0005\u0004\u0000\u0000"+
		"?A\u0006\u0003\uffff\uffff\u0000@;\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000A\u0007\u0001\u0000\u0000\u0000BC\u0005\u0005\u0000\u0000"+
		"CD\u0005\u0015\u0000\u0000DE\u0003\n\u0005\u0000EF\u0005\u0016\u0000\u0000"+
		"FG\u0006\u0004\uffff\uffff\u0000G\t\u0001\u0000\u0000\u0000HI\u0003\f"+
		"\u0006\u0000IP\u0006\u0005\uffff\uffff\u0000JK\u0007\u0000\u0000\u0000"+
		"KL\u0003\f\u0006\u0000LM\u0006\u0005\uffff\uffff\u0000MO\u0001\u0000\u0000"+
		"\u0000NJ\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000"+
		"\u0000\u0000PQ\u0001\u0000\u0000\u0000Q\u000b\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000ST\u0003\u000e\u0007\u0000T[\u0006\u0006\uffff"+
		"\uffff\u0000UV\u0007\u0001\u0000\u0000VW\u0003\u000e\u0007\u0000WX\u0006"+
		"\u0006\uffff\uffff\u0000XZ\u0001\u0000\u0000\u0000YU\u0001\u0000\u0000"+
		"\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000"+
		"\u0000\u0000\\\r\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005"+
		"\u0012\u0000\u0000_h\u0006\u0007\uffff\uffff\u0000`a\u0005\r\u0000\u0000"+
		"ah\u0006\u0007\uffff\uffff\u0000bc\u0005\u0015\u0000\u0000cd\u0003\n\u0005"+
		"\u0000de\u0005\u0016\u0000\u0000ef\u0006\u0007\uffff\uffff\u0000fh\u0001"+
		"\u0000\u0000\u0000g^\u0001\u0000\u0000\u0000g`\u0001\u0000\u0000\u0000"+
		"gb\u0001\u0000\u0000\u0000h\u000f\u0001\u0000\u0000\u0000ij\u0005\u0006"+
		"\u0000\u0000jk\u0005\u0015\u0000\u0000kl\u0003\n\u0005\u0000lm\u0005\u0016"+
		"\u0000\u0000mn\u0003\u0002\u0001\u0000nv\u0001\u0000\u0000\u0000op\u0005"+
		"\u0006\u0000\u0000pq\u0005\u0015\u0000\u0000qr\u0003\n\u0005\u0000rs\u0005"+
		"\u0016\u0000\u0000st\u0003\u0012\t\u0000tv\u0001\u0000\u0000\u0000ui\u0001"+
		"\u0000\u0000\u0000uo\u0001\u0000\u0000\u0000v\u0011\u0001\u0000\u0000"+
		"\u0000wx\u0005\b\u0000\u0000xy\u0005\u0015\u0000\u0000yz\u0003\n\u0005"+
		"\u0000z{\u0005\u0016\u0000\u0000{|\u0003\u0002\u0001\u0000|}\u0003\u0012"+
		"\t\u0000}\u0081\u0001\u0000\u0000\u0000~\u007f\u0005\u0007\u0000\u0000"+
		"\u007f\u0081\u0003\u0002\u0001\u0000\u0080w\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0081\u0013\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005\t\u0000\u0000\u0083\u0084\u0005\u0015\u0000\u0000\u0084\u0085\u0003"+
		"\u0006\u0003\u0000\u0085\u0086\u0005\u0001\u0000\u0000\u0086\u0087\u0003"+
		"\n\u0005\u0000\u0087\u0088\u0005\u0001\u0000\u0000\u0088\u0089\u0003\u0006"+
		"\u0003\u0000\u0089\u008a\u0005\u0016\u0000\u0000\u008a\u008b\u0003\u0002"+
		"\u0001\u0000\u008b\u0015\u0001\u0000\u0000\u0000\u008c\u008d\u0005\n\u0000"+
		"\u0000\u008d\u008e\u0005\u0015\u0000\u0000\u008e\u008f\u0003\n\u0005\u0000"+
		"\u008f\u0090\u0005\u0016\u0000\u0000\u0090\u0091\u0003\u0002\u0001\u0000"+
		"\u0091\u0017\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u000b\u0000\u0000"+
		"\u0093\u0094\u0005\r\u0000\u0000\u0094\u0095\u0005\u0015\u0000\u0000\u0095"+
		"\u0096\u0005\r\u0000\u0000\u0096\u0097\u0005\u0016\u0000\u0000\u0097\u009e"+
		"\u0003\u0002\u0001\u0000\u0098\u0099\u0005\u000b\u0000\u0000\u0099\u009a"+
		"\u0005\r\u0000\u0000\u009a\u009b\u0005\u0015\u0000\u0000\u009b\u009c\u0005"+
		"\u0016\u0000\u0000\u009c\u009e\u0003\u0002\u0001\u0000\u009d\u0092\u0001"+
		"\u0000\u0000\u0000\u009d\u0098\u0001\u0000\u0000\u0000\u009e\u0019\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0005\f\u0000\u0000\u00a0\u00a1\u0005\r"+
		"\u0000\u0000\u00a1\u00a2\u0005\u001a\u0000\u0000\u00a2\u00a3\u0005\u0002"+
		"\u0000\u0000\u00a3\u00a4\u0005\u0012\u0000\u0000\u00a4\u00a5\u0005\u0003"+
		"\u0000\u0000\u00a5\u00a6\u0003\u0002\u0001\u0000\u00a6\u001b\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0005\r\u0000\u0000\u00a8\u00a9\u0005\u001a\u0000"+
		"\u0000\u00a9\u00aa\u0005\u0013\u0000\u0000\u00aa\u001d\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0007\u0002\u0000\u0000\u00ac\u001f\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0005\u0019\u0000\u0000\u00ae!\u0001\u0000\u0000\u0000"+
		"\n%/6@P[gu\u0080\u009d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
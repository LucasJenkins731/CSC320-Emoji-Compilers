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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, KW_READ=9, 
		KW_PRINT=10, KW_IF=11, KW_ELSE=12, KW_ELSE_IF=13, KW_FOR=14, KW_WHILE=15, 
		KW_FUNCTION=16, KW_ARRAY=17, IDENT=18, ADD=19, SUBTRACT=20, MULTIPLY=21, 
		DIVIDE=22, INT=23, STRING=24, WS=25, LPAREN=26, RPAREN=27, COMMENT=28, 
		COMMENT_BLOCK=29, COMPARISON=30, ASSIGNMENT=31, LBRACE=32, RBRACE=33;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_assignStatement = 2, RULE_printStatement = 3, 
		RULE_expr = 4, RULE_term = 5, RULE_factor = 6, RULE_s = 7, RULE_as = 8, 
		RULE_ps = 9, RULE_ifstmt = 10, RULE_elsestmt = 11, RULE_forstmt = 12, 
		RULE_whilestmt = 13, RULE_functionstmt = 14, RULE_arraystmt = 15, RULE_stringstmt = 16, 
		RULE_comp = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "assignStatement", "printStatement", "expr", 
			"term", "factor", "s", "as", "ps", "ifstmt", "elsestmt", "forstmt", "whilestmt", 
			"functionstmt", "arraystmt", "stringstmt", "comp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+'", "'-'", "'*'", "'/'", "';'", "'['", "']'", "'-0-0-'", 
			"':P'", "':)'", "':('", "':|'", "'>:('", "'D:<'", "'=^._.^='", "'(o_o)'", 
			null, "':+)'", "':-)'", "':*)'", "':/)'", null, null, null, "'('", "')'", 
			null, null, "':==)'", "':=)'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "KW_READ", "KW_PRINT", 
			"KW_IF", "KW_ELSE", "KW_ELSE_IF", "KW_FOR", "KW_WHILE", "KW_FUNCTION", 
			"KW_ARRAY", "IDENT", "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "INT", 
			"STRING", "WS", "LPAREN", "RPAREN", "COMMENT", "COMMENT_BLOCK", "COMPARISON", 
			"ASSIGNMENT", "LBRACE", "RBRACE"
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_PRINT || _la==IDENT) {
				{
				{
				setState(36);
				statement();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
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
	public static class StatementContext extends ParserRuleContext {
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				assignStatement();
				}
				break;
			case KW_PRINT:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				printStatement();
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
	public static class AssignStatementContext extends ParserRuleContext {
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode KW_READ() { return getToken(EmoticonParser.KW_READ, 0); }
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitAssignStatement(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			((AssignStatementContext)_localctx).IDENT = match(IDENT);

			      // We're entering an assignment: record LHS and whether it existed before.
			      pendingLHS = ((AssignStatementContext)_localctx).IDENT.getText();
			      lhsExistedBefore = assigned.contains(pendingLHS);
			    
			setState(51);
			match(T__0);
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case INT:
			case LPAREN:
				{
				setState(52);
				expr();
				}
				break;
			case KW_READ:
				{
				setState(53);
				match(KW_READ);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			      // Successful RHS parse: consider variable now assigned.
			      assigned.add(pendingLHS);
			      // Clear LHS context.
			      pendingLHS = null;
			    
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
	public static class PrintStatementContext extends ParserRuleContext {
		public Token KW_PRINT;
		public ExprContext expr;
		public TerminalNode KW_PRINT() { return getToken(EmoticonParser.KW_PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitPrintStatement(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			((PrintStatementContext)_localctx).KW_PRINT = match(KW_PRINT);
			setState(59);
			match(LPAREN);
			setState(60);
			((PrintStatementContext)_localctx).expr = expr();
			setState(61);
			match(RPAREN);

			      if (((PrintStatementContext)_localctx).expr.hasKnownValue) {
			        // Let us print it out (for debugging purposes really)
			        System.out.println("DEBUG: Line " + ((PrintStatementContext)_localctx).KW_PRINT.getLine() + ": Printing known value: " + ((PrintStatementContext)_localctx).expr.value);
			      } else {
			        System.out.println("DEBUG: Line " + ((PrintStatementContext)_localctx).KW_PRINT.getLine() + ": Can't print this value. Need to evaluate further.");
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
		enterRule(_localctx, 8, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			((ExprContext)_localctx).a = term();

			      if (((ExprContext)_localctx).a.hasKnownValue) {
			        ((ExprContext)_localctx).hasKnownValue =  true;
			        ((ExprContext)_localctx).value =  ((ExprContext)_localctx).a.value;
			      } else {
			        ((ExprContext)_localctx).hasKnownValue =  false;
			      } 
			    
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__2) {
				{
				{
				setState(66);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(67);
				((ExprContext)_localctx).b = term();

				      if (_localctx.hasKnownValue && ((ExprContext)_localctx).b.hasKnownValue) {
				        if (((ExprContext)_localctx).op.getText().equals("+")) {
				          ((ExprContext)_localctx).value =  _localctx.value + ((ExprContext)_localctx).b.value;
				        } else {
				          ((ExprContext)_localctx).value =  _localctx.value - ((ExprContext)_localctx).b.value;
				        }
				      } else {
				        ((ExprContext)_localctx).hasKnownValue =  false;
				      }
				    
				}
				}
				setState(74);
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
		enterRule(_localctx, 10, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			((TermContext)_localctx).a = factor();

			      if (((TermContext)_localctx).a.hasKnownValue) {
			        ((TermContext)_localctx).hasKnownValue =  true;
			        ((TermContext)_localctx).value =  ((TermContext)_localctx).a.value;
			      } else ((TermContext)_localctx).hasKnownValue =  false;
			    
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__4) {
				{
				{
				setState(77);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(78);
				((TermContext)_localctx).b = factor();

				        // First check for division by zero when b has value 0 (and /).
				        if (((TermContext)_localctx).b.hasKnownValue && ((TermContext)_localctx).op.getText().equals("/") && ((TermContext)_localctx).b.value == 0) {
				          error(((TermContext)_localctx).op, "division by zero");
				          ((TermContext)_localctx).hasKnownValue =  false;  // Error anyway so stopping there
				        } else if (_localctx.hasKnownValue && ((TermContext)_localctx).b.hasKnownValue) {
				          if (((TermContext)_localctx).op.getText().equals("*")) {
				            ((TermContext)_localctx).value =  _localctx.value * ((TermContext)_localctx).b.value;
				          } else {
				            ((TermContext)_localctx).value =  _localctx.value / ((TermContext)_localctx).b.value;
				          }
				        } else {
				          ((TermContext)_localctx).hasKnownValue =  false;
				        }
				      
				}
				}
				setState(85);
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
		enterRule(_localctx, 12, RULE_factor);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				((FactorContext)_localctx).INT = match(INT);
				 ((FactorContext)_localctx).hasKnownValue =  true; ((FactorContext)_localctx).value =  Integer.parseInt(((FactorContext)_localctx).INT.getText()); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				((FactorContext)_localctx).IDENT = match(IDENT);

				        String id = ((FactorContext)_localctx).IDENT.getText();
				        used.add(id);
				        // If we're in the middle of first assignment to IDENT (self-reference):
				        if (pendingLHS != null && !lhsExistedBefore && id.equals(pendingLHS)) {
				          error(((FactorContext)_localctx).IDENT, "self-reference on first assignment of '" + pendingLHS + "'");
				        } else if (!assigned.contains(id)) {
				          // General use-before-assign.
				          error(((FactorContext)_localctx).IDENT, "use of variable '" + id + "' before assignment");
				        }
				        ((FactorContext)_localctx).hasKnownValue =  false;  // For now...
				      
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(LPAREN);
				setState(91);
				((FactorContext)_localctx).expr = expr();
				setState(92);
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
		public ArraystmtContext arraystmt() {
			return getRuleContext(ArraystmtContext.class,0);
		}
		public StringstmtContext stringstmt() {
			return getRuleContext(StringstmtContext.class,0);
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
		enterRule(_localctx, 14, RULE_s);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				as();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				ps();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				ifstmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				elsestmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(102);
				forstmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(103);
				whilestmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(104);
				functionstmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(105);
				arraystmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(106);
				stringstmt();
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
	public static class AsContext extends ParserRuleContext {
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
		enterRule(_localctx, 16, RULE_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(IDENT);
			setState(110);
			match(ASSIGNMENT);
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case INT:
			case LPAREN:
				{
				setState(111);
				expr();
				}
				break;
			case KW_READ:
				{
				setState(112);
				match(KW_READ);
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
		enterRule(_localctx, 18, RULE_ps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(KW_PRINT);
			setState(116);
			match(LPAREN);
			setState(117);
			expr();
			setState(118);
			match(RPAREN);
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
		enterRule(_localctx, 20, RULE_ifstmt);
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(KW_IF);
				setState(121);
				match(LPAREN);
				setState(122);
				expr();
				setState(123);
				match(RPAREN);
				setState(124);
				s();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(KW_IF);
				setState(127);
				match(LPAREN);
				setState(128);
				expr();
				setState(129);
				match(RPAREN);
				setState(130);
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
		enterRule(_localctx, 22, RULE_elsestmt);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ELSE_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(KW_ELSE_IF);
				setState(135);
				match(LPAREN);
				setState(136);
				expr();
				setState(137);
				match(RPAREN);
				setState(138);
				s();
				setState(139);
				elsestmt();
				}
				break;
			case KW_ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(KW_ELSE);
				setState(142);
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
		enterRule(_localctx, 24, RULE_forstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(KW_FOR);
			setState(146);
			match(LPAREN);
			setState(147);
			as();
			setState(148);
			match(T__5);
			setState(149);
			expr();
			setState(150);
			match(T__5);
			setState(151);
			as();
			setState(152);
			match(RPAREN);
			setState(153);
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
		enterRule(_localctx, 26, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(KW_WHILE);
			setState(156);
			match(LPAREN);
			setState(157);
			expr();
			setState(158);
			match(RPAREN);
			setState(159);
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
		enterRule(_localctx, 28, RULE_functionstmt);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(KW_FUNCTION);
				setState(162);
				match(IDENT);
				setState(163);
				match(LPAREN);
				setState(164);
				match(IDENT);
				setState(165);
				match(RPAREN);
				setState(166);
				s();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(KW_FUNCTION);
				setState(168);
				match(IDENT);
				setState(169);
				match(LPAREN);
				setState(170);
				match(RPAREN);
				setState(171);
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
		enterRule(_localctx, 30, RULE_arraystmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(KW_ARRAY);
			setState(175);
			match(IDENT);
			setState(176);
			match(ASSIGNMENT);
			setState(177);
			match(T__6);
			setState(178);
			match(INT);
			setState(179);
			match(T__7);
			setState(180);
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
		enterRule(_localctx, 32, RULE_stringstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(IDENT);
			setState(183);
			match(ASSIGNMENT);
			setState(184);
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
		enterRule(_localctx, 34, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
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
		"\u0004\u0001!\u00bd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0005\u0000"+
		"&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00027\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004G\b\u0004\n\u0004\f\u0004J\t\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"R\b\u0005\n\u0005\f\u0005U\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006`\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007l\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\br\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0085"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0090\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ad\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0002"+
		"\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0005\u00be\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000\u0000"+
		"\u0006:\u0001\u0000\u0000\u0000\b@\u0001\u0000\u0000\u0000\nK\u0001\u0000"+
		"\u0000\u0000\f_\u0001\u0000\u0000\u0000\u000ek\u0001\u0000\u0000\u0000"+
		"\u0010m\u0001\u0000\u0000\u0000\u0012s\u0001\u0000\u0000\u0000\u0014\u0084"+
		"\u0001\u0000\u0000\u0000\u0016\u008f\u0001\u0000\u0000\u0000\u0018\u0091"+
		"\u0001\u0000\u0000\u0000\u001a\u009b\u0001\u0000\u0000\u0000\u001c\u00ac"+
		"\u0001\u0000\u0000\u0000\u001e\u00ae\u0001\u0000\u0000\u0000 \u00b6\u0001"+
		"\u0000\u0000\u0000\"\u00ba\u0001\u0000\u0000\u0000$&\u0003\u0002\u0001"+
		"\u0000%$\u0001\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000"+
		"\u0000\u0000\'(\u0001\u0000\u0000\u0000(*\u0001\u0000\u0000\u0000)\'\u0001"+
		"\u0000\u0000\u0000*+\u0005\u0000\u0000\u0001+,\u0006\u0000\uffff\uffff"+
		"\u0000,\u0001\u0001\u0000\u0000\u0000-0\u0003\u0004\u0002\u0000.0\u0003"+
		"\u0006\u0003\u0000/-\u0001\u0000\u0000\u0000/.\u0001\u0000\u0000\u0000"+
		"0\u0003\u0001\u0000\u0000\u000012\u0005\u0012\u0000\u000023\u0006\u0002"+
		"\uffff\uffff\u000036\u0005\u0001\u0000\u000047\u0003\b\u0004\u000057\u0005"+
		"\t\u0000\u000064\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u000078\u0001"+
		"\u0000\u0000\u000089\u0006\u0002\uffff\uffff\u00009\u0005\u0001\u0000"+
		"\u0000\u0000:;\u0005\n\u0000\u0000;<\u0005\u001a\u0000\u0000<=\u0003\b"+
		"\u0004\u0000=>\u0005\u001b\u0000\u0000>?\u0006\u0003\uffff\uffff\u0000"+
		"?\u0007\u0001\u0000\u0000\u0000@A\u0003\n\u0005\u0000AH\u0006\u0004\uffff"+
		"\uffff\u0000BC\u0007\u0000\u0000\u0000CD\u0003\n\u0005\u0000DE\u0006\u0004"+
		"\uffff\uffff\u0000EG\u0001\u0000\u0000\u0000FB\u0001\u0000\u0000\u0000"+
		"GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000I\t\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0003\f"+
		"\u0006\u0000LS\u0006\u0005\uffff\uffff\u0000MN\u0007\u0001\u0000\u0000"+
		"NO\u0003\f\u0006\u0000OP\u0006\u0005\uffff\uffff\u0000PR\u0001\u0000\u0000"+
		"\u0000QM\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000T\u000b\u0001\u0000\u0000\u0000"+
		"US\u0001\u0000\u0000\u0000VW\u0005\u0017\u0000\u0000W`\u0006\u0006\uffff"+
		"\uffff\u0000XY\u0005\u0012\u0000\u0000Y`\u0006\u0006\uffff\uffff\u0000"+
		"Z[\u0005\u001a\u0000\u0000[\\\u0003\b\u0004\u0000\\]\u0005\u001b\u0000"+
		"\u0000]^\u0006\u0006\uffff\uffff\u0000^`\u0001\u0000\u0000\u0000_V\u0001"+
		"\u0000\u0000\u0000_X\u0001\u0000\u0000\u0000_Z\u0001\u0000\u0000\u0000"+
		"`\r\u0001\u0000\u0000\u0000al\u0003\u0010\b\u0000bl\u0003\u0012\t\u0000"+
		"cl\u0003\b\u0004\u0000dl\u0003\u0014\n\u0000el\u0003\u0016\u000b\u0000"+
		"fl\u0003\u0018\f\u0000gl\u0003\u001a\r\u0000hl\u0003\u001c\u000e\u0000"+
		"il\u0003\u001e\u000f\u0000jl\u0003 \u0010\u0000ka\u0001\u0000\u0000\u0000"+
		"kb\u0001\u0000\u0000\u0000kc\u0001\u0000\u0000\u0000kd\u0001\u0000\u0000"+
		"\u0000ke\u0001\u0000\u0000\u0000kf\u0001\u0000\u0000\u0000kg\u0001\u0000"+
		"\u0000\u0000kh\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kj\u0001"+
		"\u0000\u0000\u0000l\u000f\u0001\u0000\u0000\u0000mn\u0005\u0012\u0000"+
		"\u0000nq\u0005\u001f\u0000\u0000or\u0003\b\u0004\u0000pr\u0005\t\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000r\u0011\u0001"+
		"\u0000\u0000\u0000st\u0005\n\u0000\u0000tu\u0005\u001a\u0000\u0000uv\u0003"+
		"\b\u0004\u0000vw\u0005\u001b\u0000\u0000w\u0013\u0001\u0000\u0000\u0000"+
		"xy\u0005\u000b\u0000\u0000yz\u0005\u001a\u0000\u0000z{\u0003\b\u0004\u0000"+
		"{|\u0005\u001b\u0000\u0000|}\u0003\u000e\u0007\u0000}\u0085\u0001\u0000"+
		"\u0000\u0000~\u007f\u0005\u000b\u0000\u0000\u007f\u0080\u0005\u001a\u0000"+
		"\u0000\u0080\u0081\u0003\b\u0004\u0000\u0081\u0082\u0005\u001b\u0000\u0000"+
		"\u0082\u0083\u0003\u0016\u000b\u0000\u0083\u0085\u0001\u0000\u0000\u0000"+
		"\u0084x\u0001\u0000\u0000\u0000\u0084~\u0001\u0000\u0000\u0000\u0085\u0015"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0005\r\u0000\u0000\u0087\u0088\u0005"+
		"\u001a\u0000\u0000\u0088\u0089\u0003\b\u0004\u0000\u0089\u008a\u0005\u001b"+
		"\u0000\u0000\u008a\u008b\u0003\u000e\u0007\u0000\u008b\u008c\u0003\u0016"+
		"\u000b\u0000\u008c\u0090\u0001\u0000\u0000\u0000\u008d\u008e\u0005\f\u0000"+
		"\u0000\u008e\u0090\u0003\u000e\u0007\u0000\u008f\u0086\u0001\u0000\u0000"+
		"\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0017\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0005\u000e\u0000\u0000\u0092\u0093\u0005\u001a\u0000"+
		"\u0000\u0093\u0094\u0003\u0010\b\u0000\u0094\u0095\u0005\u0006\u0000\u0000"+
		"\u0095\u0096\u0003\b\u0004\u0000\u0096\u0097\u0005\u0006\u0000\u0000\u0097"+
		"\u0098\u0003\u0010\b\u0000\u0098\u0099\u0005\u001b\u0000\u0000\u0099\u009a"+
		"\u0003\u000e\u0007\u0000\u009a\u0019\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0005\u000f\u0000\u0000\u009c\u009d\u0005\u001a\u0000\u0000\u009d\u009e"+
		"\u0003\b\u0004\u0000\u009e\u009f\u0005\u001b\u0000\u0000\u009f\u00a0\u0003"+
		"\u000e\u0007\u0000\u00a0\u001b\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005"+
		"\u0010\u0000\u0000\u00a2\u00a3\u0005\u0012\u0000\u0000\u00a3\u00a4\u0005"+
		"\u001a\u0000\u0000\u00a4\u00a5\u0005\u0012\u0000\u0000\u00a5\u00a6\u0005"+
		"\u001b\u0000\u0000\u00a6\u00ad\u0003\u000e\u0007\u0000\u00a7\u00a8\u0005"+
		"\u0010\u0000\u0000\u00a8\u00a9\u0005\u0012\u0000\u0000\u00a9\u00aa\u0005"+
		"\u001a\u0000\u0000\u00aa\u00ab\u0005\u001b\u0000\u0000\u00ab\u00ad\u0003"+
		"\u000e\u0007\u0000\u00ac\u00a1\u0001\u0000\u0000\u0000\u00ac\u00a7\u0001"+
		"\u0000\u0000\u0000\u00ad\u001d\u0001\u0000\u0000\u0000\u00ae\u00af\u0005"+
		"\u0011\u0000\u0000\u00af\u00b0\u0005\u0012\u0000\u0000\u00b0\u00b1\u0005"+
		"\u001f\u0000\u0000\u00b1\u00b2\u0005\u0007\u0000\u0000\u00b2\u00b3\u0005"+
		"\u0017\u0000\u0000\u00b3\u00b4\u0005\b\u0000\u0000\u00b4\u00b5\u0003\u000e"+
		"\u0007\u0000\u00b5\u001f\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0012"+
		"\u0000\u0000\u00b7\u00b8\u0005\u001f\u0000\u0000\u00b8\u00b9\u0005\u0018"+
		"\u0000\u0000\u00b9!\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u001e\u0000"+
		"\u0000\u00bb#\u0001\u0000\u0000\u0000\u000b\'/6HS_kq\u0084\u008f\u00ac";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
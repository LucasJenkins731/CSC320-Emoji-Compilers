// Generated from c:/Users/pieco/Desktop/Emoticon language/Emoticon.g4 by ANTLR 4.13.1
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
		RULE_program = 0, RULE_s = 1, RULE_as = 2, RULE_ps = 3, RULE_ifstmt = 4, 
		RULE_elsestmt = 5, RULE_forstmt = 6, RULE_whilestmt = 7, RULE_functionstmt = 8, 
		RULE_arraystmt = 9, RULE_stringstmt = 10, RULE_op = 11, RULE_comp = 12, 
		RULE_expr = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "s", "as", "ps", "ifstmt", "elsestmt", "forstmt", "whilestmt", 
			"functionstmt", "arraystmt", "stringstmt", "op", "comp", "expr"
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
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				s();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2375648L) != 0) );
			setState(33);
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
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_s);
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				as();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				ps();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				expr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				ifstmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
				elsestmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(40);
				forstmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(41);
				whilestmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(42);
				functionstmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(43);
				arraystmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(44);
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
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(IDENT);
			setState(48);
			match(ASSIGNMENT);
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case INT:
			case LPAREN:
				{
				setState(49);
				expr(0);
				}
				break;
			case KW_READ:
				{
				setState(50);
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
	}

	public final PsContext ps() throws RecognitionException {
		PsContext _localctx = new PsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ps);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(KW_PRINT);
			setState(54);
			match(LPAREN);
			setState(55);
			expr(0);
			setState(56);
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
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifstmt);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(KW_IF);
				setState(59);
				match(LPAREN);
				setState(60);
				expr(0);
				setState(61);
				match(RPAREN);
				setState(62);
				s();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(KW_IF);
				setState(65);
				match(LPAREN);
				setState(66);
				expr(0);
				setState(67);
				match(RPAREN);
				setState(68);
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
		enterRule(_localctx, 10, RULE_elsestmt);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ELSE_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(KW_ELSE_IF);
				setState(73);
				match(LPAREN);
				setState(74);
				expr(0);
				setState(75);
				match(RPAREN);
				setState(76);
				s();
				setState(77);
				elsestmt();
				}
				break;
			case KW_ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(KW_ELSE);
				setState(80);
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
		public AsContext as() {
			return getRuleContext(AsContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		enterRule(_localctx, 12, RULE_forstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(KW_FOR);
			setState(84);
			match(LPAREN);
			setState(85);
			as();
			setState(86);
			match(T__0);
			setState(87);
			expr(0);
			setState(88);
			match(T__0);
			setState(89);
			expr(0);
			setState(90);
			match(RPAREN);
			setState(91);
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
		enterRule(_localctx, 14, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(KW_WHILE);
			setState(94);
			match(LPAREN);
			setState(95);
			expr(0);
			setState(96);
			match(RPAREN);
			setState(97);
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
		enterRule(_localctx, 16, RULE_functionstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(KW_FUNCTION);
			setState(100);
			match(IDENT);
			setState(101);
			match(LPAREN);
			setState(102);
			match(IDENT);
			setState(103);
			match(RPAREN);
			setState(104);
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
		enterRule(_localctx, 18, RULE_arraystmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(KW_ARRAY);
			setState(107);
			match(IDENT);
			setState(108);
			match(ASSIGNMENT);
			setState(109);
			match(T__1);
			setState(110);
			match(INT);
			setState(111);
			match(T__2);
			setState(112);
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
		enterRule(_localctx, 20, RULE_stringstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(IDENT);
			setState(115);
			match(ASSIGNMENT);
			setState(116);
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
	public static class OpContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(EmoticonParser.ADD, 0); }
		public TerminalNode SUBTRACT() { return getToken(EmoticonParser.SUBTRACT, 0); }
		public TerminalNode MULTIPLY() { return getToken(EmoticonParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(EmoticonParser.DIVIDE, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
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
		enterRule(_localctx, 24, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(123);
				match(INT);
				}
				break;
			case IDENT:
				{
				setState(124);
				match(IDENT);
				}
				break;
			case LPAREN:
				{
				setState(125);
				match(LPAREN);
				setState(126);
				expr(0);
				setState(127);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(139);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(132);
						op();
						setState(133);
						expr(3);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(136);
						comp();
						setState(137);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u0091\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0004\u0000\u001e\b\u0000"+
		"\u000b\u0000\f\u0000\u001f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001.\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00024\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004G\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005R\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0082"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u008c\b\r\n\r\f\r\u008f\t\r\u0001\r\u0000\u0001\u001a\u000e\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0001"+
		"\u0001\u0000\u000e\u0011\u0093\u0000\u001d\u0001\u0000\u0000\u0000\u0002"+
		"-\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u00065\u0001"+
		"\u0000\u0000\u0000\bF\u0001\u0000\u0000\u0000\nQ\u0001\u0000\u0000\u0000"+
		"\fS\u0001\u0000\u0000\u0000\u000e]\u0001\u0000\u0000\u0000\u0010c\u0001"+
		"\u0000\u0000\u0000\u0012j\u0001\u0000\u0000\u0000\u0014r\u0001\u0000\u0000"+
		"\u0000\u0016v\u0001\u0000\u0000\u0000\u0018x\u0001\u0000\u0000\u0000\u001a"+
		"\u0081\u0001\u0000\u0000\u0000\u001c\u001e\u0003\u0002\u0001\u0000\u001d"+
		"\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f"+
		"\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 !\u0001"+
		"\u0000\u0000\u0000!\"\u0005\u0000\u0000\u0001\"\u0001\u0001\u0000\u0000"+
		"\u0000#.\u0003\u0004\u0002\u0000$.\u0003\u0006\u0003\u0000%.\u0003\u001a"+
		"\r\u0000&.\u0003\b\u0004\u0000\'.\u0003\n\u0005\u0000(.\u0003\f\u0006"+
		"\u0000).\u0003\u000e\u0007\u0000*.\u0003\u0010\b\u0000+.\u0003\u0012\t"+
		"\u0000,.\u0003\u0014\n\u0000-#\u0001\u0000\u0000\u0000-$\u0001\u0000\u0000"+
		"\u0000-%\u0001\u0000\u0000\u0000-&\u0001\u0000\u0000\u0000-\'\u0001\u0000"+
		"\u0000\u0000-(\u0001\u0000\u0000\u0000-)\u0001\u0000\u0000\u0000-*\u0001"+
		"\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-,\u0001\u0000\u0000\u0000"+
		".\u0003\u0001\u0000\u0000\u0000/0\u0005\r\u0000\u000003\u0005\u001a\u0000"+
		"\u000014\u0003\u001a\r\u000024\u0005\u0004\u0000\u000031\u0001\u0000\u0000"+
		"\u000032\u0001\u0000\u0000\u00004\u0005\u0001\u0000\u0000\u000056\u0005"+
		"\u0005\u0000\u000067\u0005\u0015\u0000\u000078\u0003\u001a\r\u000089\u0005"+
		"\u0016\u0000\u00009\u0007\u0001\u0000\u0000\u0000:;\u0005\u0006\u0000"+
		"\u0000;<\u0005\u0015\u0000\u0000<=\u0003\u001a\r\u0000=>\u0005\u0016\u0000"+
		"\u0000>?\u0003\u0002\u0001\u0000?G\u0001\u0000\u0000\u0000@A\u0005\u0006"+
		"\u0000\u0000AB\u0005\u0015\u0000\u0000BC\u0003\u001a\r\u0000CD\u0005\u0016"+
		"\u0000\u0000DE\u0003\n\u0005\u0000EG\u0001\u0000\u0000\u0000F:\u0001\u0000"+
		"\u0000\u0000F@\u0001\u0000\u0000\u0000G\t\u0001\u0000\u0000\u0000HI\u0005"+
		"\b\u0000\u0000IJ\u0005\u0015\u0000\u0000JK\u0003\u001a\r\u0000KL\u0005"+
		"\u0016\u0000\u0000LM\u0003\u0002\u0001\u0000MN\u0003\n\u0005\u0000NR\u0001"+
		"\u0000\u0000\u0000OP\u0005\u0007\u0000\u0000PR\u0003\u0002\u0001\u0000"+
		"QH\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000R\u000b\u0001\u0000"+
		"\u0000\u0000ST\u0005\t\u0000\u0000TU\u0005\u0015\u0000\u0000UV\u0003\u0004"+
		"\u0002\u0000VW\u0005\u0001\u0000\u0000WX\u0003\u001a\r\u0000XY\u0005\u0001"+
		"\u0000\u0000YZ\u0003\u001a\r\u0000Z[\u0005\u0016\u0000\u0000[\\\u0003"+
		"\u0002\u0001\u0000\\\r\u0001\u0000\u0000\u0000]^\u0005\n\u0000\u0000^"+
		"_\u0005\u0015\u0000\u0000_`\u0003\u001a\r\u0000`a\u0005\u0016\u0000\u0000"+
		"ab\u0003\u0002\u0001\u0000b\u000f\u0001\u0000\u0000\u0000cd\u0005\u000b"+
		"\u0000\u0000de\u0005\r\u0000\u0000ef\u0005\u0015\u0000\u0000fg\u0005\r"+
		"\u0000\u0000gh\u0005\u0016\u0000\u0000hi\u0003\u0002\u0001\u0000i\u0011"+
		"\u0001\u0000\u0000\u0000jk\u0005\f\u0000\u0000kl\u0005\r\u0000\u0000l"+
		"m\u0005\u001a\u0000\u0000mn\u0005\u0002\u0000\u0000no\u0005\u0012\u0000"+
		"\u0000op\u0005\u0003\u0000\u0000pq\u0003\u0002\u0001\u0000q\u0013\u0001"+
		"\u0000\u0000\u0000rs\u0005\r\u0000\u0000st\u0005\u001a\u0000\u0000tu\u0005"+
		"\u0013\u0000\u0000u\u0015\u0001\u0000\u0000\u0000vw\u0007\u0000\u0000"+
		"\u0000w\u0017\u0001\u0000\u0000\u0000xy\u0005\u0019\u0000\u0000y\u0019"+
		"\u0001\u0000\u0000\u0000z{\u0006\r\uffff\uffff\u0000{\u0082\u0005\u0012"+
		"\u0000\u0000|\u0082\u0005\r\u0000\u0000}~\u0005\u0015\u0000\u0000~\u007f"+
		"\u0003\u001a\r\u0000\u007f\u0080\u0005\u0016\u0000\u0000\u0080\u0082\u0001"+
		"\u0000\u0000\u0000\u0081z\u0001\u0000\u0000\u0000\u0081|\u0001\u0000\u0000"+
		"\u0000\u0081}\u0001\u0000\u0000\u0000\u0082\u008d\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\n\u0002\u0000\u0000\u0084\u0085\u0003\u0016\u000b\u0000\u0085"+
		"\u0086\u0003\u001a\r\u0003\u0086\u008c\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\n\u0001\u0000\u0000\u0088\u0089\u0003\u0018\f\u0000\u0089\u008a\u0003"+
		"\u001a\r\u0002\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u0083\u0001\u0000"+
		"\u0000\u0000\u008b\u0087\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u001b\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\b\u001f-3FQ\u0081\u008b\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
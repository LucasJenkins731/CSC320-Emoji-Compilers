// Generated from Emoticon.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EmoticonParser}.
 */
public interface EmoticonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(EmoticonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(EmoticonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(EmoticonParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(EmoticonParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#as}.
	 * @param ctx the parse tree
	 */
	void enterAs(EmoticonParser.AsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#as}.
	 * @param ctx the parse tree
	 */
	void exitAs(EmoticonParser.AsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#ps}.
	 * @param ctx the parse tree
	 */
	void enterPs(EmoticonParser.PsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#ps}.
	 * @param ctx the parse tree
	 */
	void exitPs(EmoticonParser.PsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(EmoticonParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(EmoticonParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(EmoticonParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(EmoticonParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(EmoticonParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(EmoticonParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EmoticonParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EmoticonParser.ExprContext ctx);
}
// Generated from Emoticon.g4 by ANTLR 4.13.2
 import java.util.*; import java.io.*; import org.antlr.v4.runtime.*; import org.antlr.v4.runtime.tree.*; 
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
	 * Enter a parse tree produced by {@link EmoticonParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(EmoticonParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(EmoticonParser.BlockStatementContext ctx);
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
	 * Enter a parse tree produced by {@link EmoticonParser#rhs}.
	 * @param ctx the parse tree
	 */
	void enterRhs(EmoticonParser.RhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#rhs}.
	 * @param ctx the parse tree
	 */
	void exitRhs(EmoticonParser.RhsContext ctx);
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
	 * Enter a parse tree produced by {@link EmoticonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EmoticonParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EmoticonParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(EmoticonParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(EmoticonParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(EmoticonParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(EmoticonParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#operators}.
	 * @param ctx the parse tree
	 */
	void enterOperators(EmoticonParser.OperatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#operators}.
	 * @param ctx the parse tree
	 */
	void exitOperators(EmoticonParser.OperatorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#conditionals}.
	 * @param ctx the parse tree
	 */
	void enterConditionals(EmoticonParser.ConditionalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#conditionals}.
	 * @param ctx the parse tree
	 */
	void exitConditionals(EmoticonParser.ConditionalsContext ctx);
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
}
// Generated from c:/Users/pieco/Desktop/Emoticon language/Emoticon.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link EmoticonParser#functioncallstmt}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncallstmt(EmoticonParser.FunctioncallstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#functioncallstmt}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncallstmt(EmoticonParser.FunctioncallstmtContext ctx);
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
	 * Enter a parse tree produced by {@link EmoticonParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(EmoticonParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(EmoticonParser.ConditionContext ctx);
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
	 * Enter a parse tree produced by {@link EmoticonParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(EmoticonParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(EmoticonParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#elsestmt}.
	 * @param ctx the parse tree
	 */
	void enterElsestmt(EmoticonParser.ElsestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#elsestmt}.
	 * @param ctx the parse tree
	 */
	void exitElsestmt(EmoticonParser.ElsestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#forstmt}.
	 * @param ctx the parse tree
	 */
	void enterForstmt(EmoticonParser.ForstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#forstmt}.
	 * @param ctx the parse tree
	 */
	void exitForstmt(EmoticonParser.ForstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(EmoticonParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(EmoticonParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#returnstmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnstmt(EmoticonParser.ReturnstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#returnstmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnstmt(EmoticonParser.ReturnstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#functionstmt}.
	 * @param ctx the parse tree
	 */
	void enterFunctionstmt(EmoticonParser.FunctionstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#functionstmt}.
	 * @param ctx the parse tree
	 */
	void exitFunctionstmt(EmoticonParser.FunctionstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(EmoticonParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(EmoticonParser.FunctioncallContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#arraystmt}.
	 * @param ctx the parse tree
	 */
	void enterArraystmt(EmoticonParser.ArraystmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#arraystmt}.
	 * @param ctx the parse tree
	 */
	void exitArraystmt(EmoticonParser.ArraystmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(EmoticonParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(EmoticonParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(EmoticonParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(EmoticonParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link EmoticonParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(EmoticonParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link EmoticonParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(EmoticonParser.ArrayAccessContext ctx);
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
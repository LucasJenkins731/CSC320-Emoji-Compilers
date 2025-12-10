// Generated from Emoticon.g4 by ANTLR 4.13.2
 import java.util.*; import java.io.*; import org.antlr.v4.runtime.*; import org.antlr.v4.runtime.tree.*; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EmoticonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EmoticonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(EmoticonParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(EmoticonParser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(EmoticonParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#as}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs(EmoticonParser.AsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhs(EmoticonParser.RhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#ps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPs(EmoticonParser.PsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(EmoticonParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(EmoticonParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(EmoticonParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperators(EmoticonParser.OperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#conditionals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionals(EmoticonParser.ConditionalsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EmoticonParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(EmoticonParser.CompContext ctx);
}
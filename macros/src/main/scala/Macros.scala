import language.experimental.macros
import scala.reflect.macros.Context

object Macros {
  def overloadedMacro(code: _): _ = macro overloadedMacroImpl
  def overloadedMacroImpl(c: Context)(code: c.Tree): c.Tree = code

  object overloadedMacro {
    def apply(arg: Any)(code: _): _ = macro overloadedMacroImpl
    def overloadedMacroImpl(c: Context)(arg: c.Expr[Any])(code: c.Tree): c.Tree = code
  }
}

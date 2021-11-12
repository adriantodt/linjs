@file:OptIn(ExperimentalJsExport::class)

import com.github.adriantodt.lin.ast.node.Node
import com.github.adriantodt.lin.compiler.NodeCompiler
import com.github.adriantodt.lin.validator.NodeValidator

@JsExport
class ParsedSnippet internal constructor(private val node: Node) {
    fun validate(): ValidationReport {
        return ValidationReport(node.accept(NodeValidator))
    }

    fun compile(): TimedResult<CompiledSnippet> {
        return measureTimedRunCatching { NodeCompiler.compile(node).jsWrapped }
    }
}

internal inline val Node.jsWrapped get() = ParsedSnippet(this)

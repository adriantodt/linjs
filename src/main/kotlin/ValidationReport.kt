@file:OptIn(ExperimentalJsExport::class)

import com.github.adriantodt.lin.ast.node.InvalidNode

@JsExport
class ValidationReport internal constructor(private val node: InvalidNode?) {
    val isValid get() = node == null

    override fun toString(): String {
        if (node != null) {
            return buildString {
                nodeToString(node)
            }
        }
        return "No errors found. :)"
    }

    private fun StringBuilder.nodeToString(node: InvalidNode, indent: String = "") {
        for (error in node.errors) {
            append(indent).appendLine(error)
        }

        val subIndent = "$indent  "
        for (child in node.children.filterIsInstance<InvalidNode>()) {
            nodeToString(child, subIndent)
        }
    }
}

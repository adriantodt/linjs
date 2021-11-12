@file:OptIn(ExperimentalJsExport::class)

import com.github.adriantodt.lin.bytecode.CompiledSource
import com.github.adriantodt.lin.vm.LinVirtualMachine

@JsExport
class CompiledSnippet internal constructor(private val source: CompiledSource) {
    fun toBytes(): ByteArray {
        return source.toBytes().toByteArray()
    }

    fun toHex(): String {
        return source.toBytes().hex()
    }

    fun toBase64(): String {
        return source.toBytes().base64()
    }

    fun run(): ExecutionReport {
        val rt = LinJsRuntime()
        val vm = LinVirtualMachine(rt.scope, source)

        return ExecutionReport(measureTimedRunCatching { vm.run().jsWrapped }, rt.console)
    }
}

internal inline val CompiledSource.jsWrapped get() = CompiledSnippet(this)

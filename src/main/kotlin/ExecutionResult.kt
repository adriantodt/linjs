@file:OptIn(ExperimentalJsExport::class)

import com.github.adriantodt.lin.vm.LinResult

@JsExport
class ExecutionResult internal constructor(private val wrapped: LinResult) {
    val isSuccess get() = wrapped is LinResult.Returned

    val isFailure get() = wrapped is LinResult.Thrown

    fun getOrNull() = wrapped.getOrNull().toString()

    fun getOrThrow() = wrapped.getOrThrow().toString()

    fun thrownOrNull() = wrapped.thrownOrNull().toString()
}

internal inline val LinResult.jsWrapped get() = ExecutionResult(this)

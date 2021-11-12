import com.github.adriantodt.lin.bytecode.CompiledSource
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalJsExport::class, ExperimentalTime::class)
@JsExport
class ExecutionReport internal constructor(val result: TimedResult<ExecutionResult>, log: StringBuilder) {
    val consoleLines = log.lines().toTypedArray()
}

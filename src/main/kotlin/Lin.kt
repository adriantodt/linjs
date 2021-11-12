@file:OptIn(ExperimentalJsExport::class)

import com.github.adriantodt.lin.Lin
import com.github.adriantodt.tartar.api.lexer.Source
import kotlin.time.ExperimentalTime

@JsExport
@Suppress("unused")
object Lin {
    fun parse(source: String, name: String = "snippet.lin"): TimedResult<ParsedSnippet> {
        return measureTimedRunCatching { Lin.parser.parse(Source(source, name)).jsWrapped }
    }
}

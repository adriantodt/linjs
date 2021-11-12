@file:OptIn(ExperimentalTime::class, ExperimentalJsExport::class)

import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue
import kotlin.time.Duration as KDuration

@JsExport
class TimedResult<T> internal constructor(private val wrapped: TimedValue<Result<T>>) {
    val duration get() = wrapped.duration.jsWrapped

    val isSuccess get() = wrapped.value.isSuccess

    val isFailure get() = wrapped.value.isFailure

    @Suppress("NON_EXPORTABLE_TYPE")
    fun getOrNull() = wrapped.value.getOrNull()

    fun exceptionOrNull() = wrapped.value.exceptionOrNull()
}

@JsExport
class Duration internal constructor(private val wrapped: KDuration) {
    override fun toString() = wrapped.toString()
}

internal inline val <T> TimedValue<Result<T>>.jsWrapped get() = TimedResult(this)

internal inline fun <T> measureTimedRunCatching(block: () -> T): TimedResult<T> {
    return measureTimedValue { runCatching(block) }.jsWrapped
}

internal inline val KDuration.jsWrapped get() = Duration(this)



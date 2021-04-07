package util

import kotlinx.css.LinearDimension
import kotlinx.css.TagSelector
import kotlin.reflect.KProperty

/**
 * Workaround for https://github.com/JetBrains/kotlin-wrappers/pull/376
 *
 * Manually add [TagSelectorFactory] to allow for missing [li] tag.
 */
private object TagSelectorFactory {
    operator fun getValue(
        thisRef: Nothing?,
        property: KProperty<*>
    ): TagSelector =
        TagSelector(property.name)
}

/**
 * Export [li] tag
 */
val li by TagSelectorFactory


/**
 * Create the media query for min width.
 *
 * @param width — Linear dimension only allowing web safe sizing.
 */
fun mediaOnlyScreenMinWidth(width: LinearDimension) = "only screen and (min-width: ${width})"

/**
 * Create the media query for max width.
 *
 * @param width — Linear dimension only allowing web safe sizing.
 */
fun mediaOnlyScreenMaxWidth(width: LinearDimension) = "only screen and (max-width: ${width})"

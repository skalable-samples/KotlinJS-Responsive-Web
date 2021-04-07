package nav.components

import nav.NavigationBarStyles
import react.RBuilder
import react.RProps
import react.child
import react.dom.span
import react.functionalComponent
import styled.css
import styled.styledA

/**
 * Wrapper for the navBarLogo.
 * Applying the Style to the site Logo.
 */
val navBarLogo = functionalComponent<RProps> {
    styledA(href = "#") {
        css {
            +NavigationBarStyles.logo
        }
        +"Pets "
        span { +"Home" }
    }

}

fun RBuilder.navBarLogo() = child(navBarLogo) {}
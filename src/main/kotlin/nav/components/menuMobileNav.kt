package nav.components

import kotlinx.html.js.onClickFunction
import nav.NavigationBarStyles
import org.w3c.dom.events.Event
import react.RBuilder
import react.RProps
import react.child
import react.functionalComponent
import styled.css
import styled.styledImg

/**
 * MobileNavProps props provides a callback to the parent to show the drawer
 * when the menu button is clicked
 *
 * @see onMenuOpenClick — a callback to alert the parent update the drawer state.
*/
external interface MobileNavProps : RProps {
    var onMenuOpenClick: (Event) -> Unit
}

/**
 * This component manages the menu icon when the drawer is closed.
 */
var menuMobileNav = functionalComponent<MobileNavProps> { props ->
    styledImg(src = "images/menu.svg") {
        css {
            +NavigationBarStyles.mobileMenu
        }
        attrs {
            onClickFunction = props.onMenuOpenClick
        }
    }
}

fun RBuilder.menuMobileNav(handler: MobileNavProps.() -> Unit) = child(menuMobileNav) {
    attrs(handler)
}

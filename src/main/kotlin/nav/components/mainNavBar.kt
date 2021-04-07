package nav.components

import kotlinx.css.Display
import kotlinx.css.display
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RProps
import react.child
import react.functionalComponent
import styled.css
import styled.styledImg
import styled.styledNav

/**
 * Main props providing functionality for showing and hiding the drawer
 * when the site has reached the lower limit of the media query.
 *
 * @see drawer — the current status of the drawer, open or closed.
 * @see onMenuClosedClick — a callback to alert the parent update the drawer state.
 */
external interface MainNavBarProps : RProps {
    var drawer: Boolean
    var onMenuClosedClick: (Event) -> Unit

}

/**
 * mainNavBar has inline CSS to show or hide the drawer depending on
 * the status of [MainNavBarProps.drawer]
 */
var mainNavBar = functionalComponent<MainNavBarProps> { props ->
    styledNav {
        css {
            display = if (props.drawer) Display.block
            else Display.none
        }
        /* Exit for menu on mobile */
        styledImg(src = "images/exit.svg") {
            attrs {
                onClickFunction = props.onMenuClosedClick
            }
        }
        /* Main menu list */
        mainMenuList()
    }
}

fun RBuilder.mainNavBar(handler: MainNavBarProps.() -> Unit) = child(mainNavBar) {
    attrs(handler)
}
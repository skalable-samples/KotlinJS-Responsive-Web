package nav

import nav.components.mainNavBar
import nav.components.menuMobileNav
import nav.components.navBarLogo
import react.*
import styled.*

/**
 * Our main navigation component.
 *
 * Here we abstract subcomponents into separate standalone
 * components to provide clarity and self managing capability.
 *
 */
private val navigationBar = functionalComponent<RProps> {
    var drawerOpen by useState { false }

    styledDiv {
        css {
            +NavigationBarStyles.navbar
        }
        styledDiv {
            css {
                +NavigationBarStyles.container
            }
            /* Logo for nav */
            navBarLogo()
            /* Menu for mobile nav */
            menuMobileNav {
                onMenuOpenClick = {
                    drawerOpen = !drawerOpen
                }
            }
            /* Main nav bar */
            mainNavBar {
                drawer = drawerOpen
                onMenuClosedClick = {
                    drawerOpen = !drawerOpen
                }
            }
        }
    }
}

fun RBuilder.navigationBar() = child(navigationBar) {}
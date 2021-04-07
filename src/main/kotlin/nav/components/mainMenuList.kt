package nav.components

import nav.NavigationBarStyles
import react.RBuilder
import react.RProps
import react.child
import react.functionalComponent
import styled.css
import styled.styledA
import styled.styledLi
import styled.styledUl

/**
 * Our main menu list.
 *
 * @sample mainMenuList is hardcoded for the sample.
 */
var mainMenuList = functionalComponent<RProps> {
    styledUl {
        css {
            +NavigationBarStyles.primaryNav
        }
        styledLi {
            styledA(href = "#") {
                +"Hamsters"
            }
        }
        styledLi {
            styledA(href = "#") {
                +"Dogs"
            }
        }
        styledLi {
            styledA(href = "#") {
                +"Cats"
            }
        }
    }
}

fun RBuilder.mainMenuList() = child(mainMenuList) {}
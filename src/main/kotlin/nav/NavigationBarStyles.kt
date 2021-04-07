package nav

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import styled.StyleSheet
import util.li
import util.mediaOnlyScreenMinWidth

object NavigationBarStyles : StyleSheet("nav.NavigationBarStyles") {

    /**
     * We can create styles that apply extra
     * handling such as [navMobile] and [navDesktop]
     * alongside extra CSS code.
     */
    val navbar by css {
        backgroundColor = Color.white
        padding(1.em)

        +navMobile
        +navDesktop

        a {
            color = Color.black
        }

        ul {
            listStyleType = ListStyleType.none
            margin(0.px)
            padding(0.px)
        }
    }

    private val navMobile by css {
        nav {
            img {
                display = Display.block
            }

            position = Position.fixed
            zIndex = 999
            width = 40.pct
            right = 0.px
            top = 0.px

            backgroundColor = Color.blanchedAlmond
            height = 100.vh
            padding(1.em)

            li {
                a {
                    color = Color.blueViolet
                    textDecoration = TextDecoration.none
                    display = Display.block
                    padding(.5.em)
                    fontSize = 1.3.em
                    textAlign = TextAlign.right

                    hover {
                        fontWeight = FontWeight.bold
                    }
                }
            }
        }
    }

    private val navDesktop by css {
        media(mediaOnlyScreenMinWidth(768.px)) {
            nav {
                display = Display.flex
                justifyContent = JustifyContent.spaceBetween
                backgroundColor = Color.transparent
                position = Position.unset
                height = LinearDimension.auto
                width = 100.pct
                padding(0.px)

                img {
                    display = Display.none
                }

                ul {
                    display = Display.flex
                }

                a {
                    color = Color.black
                    fontSize = 1.em
                    padding(
                        vertical = 0.1.em,
                        horizontal = 1.em
                    )
                }
            }
        }
    }

    val primaryNav by css {
        marginTop = 5.em

        media(mediaOnlyScreenMinWidth(768.px)) {
            margin(0.px)
        }
    }

    /**
     * Styles should be responsive within their own
     * CSS block and named clearly to state where they apply
     * themselves.
     */
    val mobileMenu by css {
        display = Display.block

        media(mediaOnlyScreenMinWidth(768.px)) {
            display = Display.none
            margin(0.px, LinearDimension.auto)
            color = Color.blueViolet
        }
    }

    val logo by css {
        textDecoration = TextDecoration.none
        fontWeight = FontWeight.bold
        alignSelf = Align.center
        color = Color.black
        fontSize = 1.2.em

        span {
            color = Color.violet
        }
    }

    /**
     * By grouping sub-styles we can alleviate
     * some of the confusion that comes with debugging
     * the CSS of responsive website.
     */
    val container by css {
        +containerMobile
        +containerDesktop
        +containerDesktopMax
    }

    /**
     * When creating separate styles for different cases
     * try to group them as close as possible to each other to
     * avoid confusion in the future.
     */
    private val containerMobile by css {
        display = Display.flex
        justifyContent = JustifyContent.spaceBetween
    }

    private val containerDesktop by css {
        media(mediaOnlyScreenMinWidth(768.px)) {
            display = Display.grid
            gridTemplateColumns = GridTemplateColumns(180.px, LinearDimension.auto)
            justifyContent = JustifyContent.spaceBetween
        }
    }

    private val containerDesktopMax by css {
        media(mediaOnlyScreenMinWidth(1080.px)) {
            width = 1080.px
            margin(0.px, LinearDimension.auto)
        }
    }

}
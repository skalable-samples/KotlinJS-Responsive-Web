import kotlinx.browser.document
import kotlinx.browser.window
import nav.navigationBar
import react.dom.render

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            navigationBar()
        }
    }
}

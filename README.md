![image](https://storage.googleapis.com/skalable.appspot.com/logo.png)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE.txt)
[![Kotlin JS IR supported](https://img.shields.io/badge/Kotlin%2FJS-IR%20supported-yellow)](https://kotl.in/jsirsupported)

At sKalable we are Kotlin driven, so we are in a mission to make KotlinJS websites mainstream. We are advocates of clean code and strive for the best quality in everything we build! 

How many times have you visited a site that is not mobile responsive and thus renders terribly on your device? From my experience, I would say too many times! 

_Let's explore how we can make our KotlinJS site responsive, so we can delight our users_ 🙂😛

#Making your KotlinJS Website Mobile-Friendly

![](https://storage.googleapis.com/skalable.appspot.com/KotlinJS%20Mobile%20Responsive%20Website%20/KotlinJS%20Media.png)

###What is mobile responsiveness? 

When a website is responsive, its layout and content automatically adapt to fit and render correctly on the device its being run on. Basically, if the screen gets smaller, then the content and layout rearranges accordingly, ensuring the visuals and functionality are not compromised.

###Why is it so important?

 Google's recommendation is to adopt a [responsive development](https://developers.google.com/search/mobile-sites/mobile-seo/responsive-design) for our websites. The benefits of doing this are many:

- It provides the best quality and user experience as a non-mobile friendly website is very hard to view on devices.

- A good website will have better SEO, perform better in rankings and make your brand distill quality!

_Users find non-mobile friendly websites frustrating and will certainly abandon your site if it is hard to navigate._


###How are we going to achieve this?

We are going to adopt a 'mobile first' approach by using `Meta Tags` and `Media Queries`!

Let's get started by building a quick website with a _Navigation Bar_ that changes the layout into a convenient _Navigation Drawer_ depending on the device's dimensions.

#Meta Viewport Tag

The `ViewPort` tag is basically needed to signal browsers that the site adapts to all devices. It provides them with instructions on how to scale and adjust the dimensions to match the screen's size.

The first thing we need to do is to add the [Meta Viewport Tag](https://developers.google.com/search/mobile-sites/mobile-seo/responsive-design) below in your `index.html` file.

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

#Media Queries

[Media Queries](https://www.w3schools.com/cssref/css3_pr_mediaquery.asp) are used to style websites for different sized screens (phones, tablets, desktop). Essentially, by using Media Queries, we can target a specific screen size or pixel range and make changes to the CSS ONLY when the particular screen size that we have set is hit. 

So, how do we use them? The syntax of Media Queries for mobile responsiveness looks like this in KotlinJS: 

```kotlin
/*Specify the minimum screen width that you want to target in pixels*/
media("only screen and (min-width: 768px)") {
    /*Add the CSS changes you want to display here*/
}
```
To clarify, the code above will only execute on screens that are 768px or larger. 

```kotlin
/*Specify the maximum screen width that you want to target in pixels*/
media("only screen and (max-width: 768px)") {
   /*Add the CSS changes you want to display here*/ 
}
```
We will adapt our CSS for screen sizes 768px or lower.

### Safety in Functions

As we begin to add more and more queries it becomes more and more hardcoded. A misspelling can cause all sorts of havoc in these cases.

Using utility functions to generate these can save us from all types of headaches.

```kotlin
fun mediaOnlyScreenMinWidth(width: LinearDimension) = "only screen and (min-width: ${width})"

fun mediaOnlyScreenMaxWidth(width: LinearDimension) = "only screen and (max-width: ${width})"
```

Using these functions we can create responsive sizes that will match across our codebase.

Applying the utility functions our code now feels less hardcoded

```kotlin
/*Specify the minimum screen width that you want to target in pixels*/
media(mediaOnlyScreenMinWidth(768.px)) {
    /*Add the CSS changes you want to display here*/
}
```

As you can see above, we use the`(mediaOnlyScreenMaxWidth())` or the `(mediaOnlyScreenMinWidth())` to specify when the changes to the CSS should happen. 

Let's explore the code above in more detail with specific examples from our website. 

### Media in Action

Our top navigation bar includes a logo and three Call to action (CTA) buttons. When the Webpage is rendered on Desktop, we want the navbar to display fully. If the screen size drops below the desired limit, the margin should be removed. To achieve this we use the following code: 

```kotlin
  val primaryNav by css {
        marginTop = 5.em

        media(mediaOnlyScreenMinWidth(768.px)) {
            margin(0.px)
        }
    }
```

Rendering on smaller devices, such as phones and tablets, the navbar should be replaced with a drawer navigation containing the CTAs.

````kotlin
val mobileMenu by css {
        display = Display.block

        media(mediaOnlyScreenMinWidth(768.px)) {
            display = Display.none
            margin(0.px, LinearDimension.auto)
            color = Color.blueViolet
        }
    }
````

![](https://storage.googleapis.com/skalable.appspot.com/KotlinJS%20Mobile%20Responsive%20Website%20/mobile-responsiveness.gif)

#Conclusion 

Using media tags in KotlinJS is quite simple. It is definitely worth addressing mobile responsiveness when developing your KotlinJS website.  Making it render correctly on a desktop is not enough, especially  factoring in that mobile traffic has overtaken desktop and now accounts for the majority of website traffic.

You can check out the sample project here.

Feel free to leave any questions or comments below. We would love hear your thoughts.

@sKalable we are a Full Stack Kotlin-centric agency that create code to ensure it is consistently Maintainable, Flexible and of course,  ***sKalable***. 😎

[Twitter](https://twitter.com/skalable_dev)

[Dev.to](https://dev.to/skalabledev)

[LinkedIn](https://www.linkedin.com/company/skalable-dev/)

for the latest updates and strategies in Kotlin, Multiplatform and much more, catering for your business or personal needs.
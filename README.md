Nibiru Mobile is a framework for developing portable mobile applications created at Oxen.

You can use it in order to create portable HTML-based (GWT) application and/or native Android applications reusing most of the code.

It provides:
 * A common API for components typically used on mobile development.
 * Implementations of these APIs for GWT and Android.
 * Generic modules providing common functionality (currently, only a security module is included).

It was built with the same philosophy used in [Nibiru Framework](https://github.com/lbrasseur/nibiru): creating a common API and structure for typical projects. But it is a completely different framework.

The components are based on JSR330 dependency injection, but implementations are based on many technologies, such as:

 * Android: [Guice](http://code.google.com/p/google-guice/), [RoboGuice](http://code.google.com/p/roboguice/), [OrmLite](http://ormlite.com/).
 * GWT: [GIN](http://code.google.com/p/google-gin/), [Apache Cordova](http://incubator.apache.org/cordova/) [PhoneGap](http://phonegap.com/)), [persistence.js](http://persistencejs.org/), [MGWT](http://www.m-gwt.com/).
 * iOS: [RoboVM](http://robovm.com/).

just to name the main ones.

Please check the reference documentation:
 * http://nibirumobile.googlecode.com/git/main/docs/Nibiru_Mobile_Reference_en.pdf (English)

Look at the [GettingStarted Getting Started] section for a quick start. Also check the [brainstorming] section for ideas about the future of the framework.

Believe it or not, there are [people using](https://github.com/lbrasseur/nibirumobile/wiki/WhoIsUsingThis) this framework!

The API is still unstable. Wer'e working on many improvements, as you can see on the [releases page](https://github.com/lbrasseur/nibirumobile/wiki/Releases).

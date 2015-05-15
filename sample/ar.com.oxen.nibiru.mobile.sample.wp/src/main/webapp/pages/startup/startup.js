(function () {
    "use strict";

    WinJS.UI.Pages.define("/pages/startup/startup.html", {
        ready: function (element, options) {
            new ar.com.oxen.nibiru.mobile.sample.wp.app.Launcher().launch();
        }
    });
})();

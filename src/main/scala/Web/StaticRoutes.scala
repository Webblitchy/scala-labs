package Web

/**
  * Assembles the routes dealing with static files.
  */
class StaticRoutes()(implicit val log: cask.Logger) extends cask.Routes:
    // DONE - Part 3 Step 1: Make the resources files (`.js` and `.css`) available to the browser.
    //      Do not forget to link to them from your HTML.
    @cask.staticResources("/static")
    def staticResourceRoutes() = "."

    initialize()
end StaticRoutes

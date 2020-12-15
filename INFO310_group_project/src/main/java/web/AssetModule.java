package web;

import org.jooby.Jooby;
import org.jooby.Results;

/**
 * This class is similar to the AssetModule class from INFO202 S2 2019
 * I'd be lying if I said I fully understood what this class is doing, however I'm
 * pretty sure that it is setting up the directories for the web server or something.

 * @author Leon Hoogenraad
 */

public class AssetModule extends Jooby {
    public AssetModule() {
	assets("/*.html");
	assets("/css/*.css");
	assets("/js/*.js");
	assets("/images/*.png");
	assets("/images/*.jpg");
        assets("/images/*.jpeg");
	//Here we're setting index.html as our home page
	assets("/", "welcomepage.html");
	//This prevents a 404 error due to browsers requesting favicons.
	get("/favicon.ico", () -> Results.noContent());
    }
}

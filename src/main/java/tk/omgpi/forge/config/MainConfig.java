package tk.omgpi.forge.config;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import tk.omgpi.forge.OMGPI;

import java.io.File;

public class MainConfig extends Configuration {

    public ConfigCategory cfg;
    public ConfigCategory sql;

    public MainConfig() {
        super(new File(OMGPI.dir, "main.cfg"));
        sql = getCategory("sql");
        cfg = getCategory("OMGPI");
        if(!sql.containsKey("host")) sql.put("host", new Property("host", "localhost", Property.Type.STRING));
        if(!sql.containsKey("port")) sql.put("port", new Property("port", "3306", Property.Type.STRING));
        if(!sql.containsKey("database")) sql.put("database", new Property("database", "mc260", Property.Type.STRING));
        if(!sql.containsKey("username")) sql.put("username", new Property("username", "mc260", Property.Type.STRING));
        if(!sql.containsKey("password")) sql.put("password", new Property("password", "password", Property.Type.STRING));

    }
}

package me.xcmc.flylimit;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class FlyLimit extends JavaPlugin {

    public static File configfile;

    public static FileConfiguration config;
    public static FlyLimit main;

    public static String oplimit;
    public static String title;
    public static String sub_title;

    @Override
    public void onEnable() {
        main = this;
        title = getConfig().getString("title").replace("&","§");
        sub_title = getConfig().getString("sub_title").replace("&","§");
        oplimit = getConfig().getString("oplimit").replace("&","§");
        //介绍
        getLogger().info("[飞行管控] - 插件名称: FlyLimit");
        getLogger().info("[飞行管控] - 插件作者: 星辰吖丶");
        getLogger().info("[飞行管控] - 联系方式: 1022767672");
        //注册命令
        Objects.requireNonNull(getCommand("flylimit")).setExecutor(new Command());
        //注册监听器
        getServer().getPluginManager().registerEvents(new Event(), this);

        Loadconfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("[飞行管控] - 插件名称: FlyLimit");
        getLogger().info("[飞行管控] - 插件作者: 星辰吖丶");
        getLogger().info("[飞行管控] - 联系方式: 1022767672");
    }
    public void Loadconfig(){
        configfile = new File(getDataFolder(),"config.yml");
        if (!configfile.exists()){
            saveResource("config.yml",false);
        }
        config = YamlConfiguration.loadConfiguration(configfile);
        System.out.println("[yhfarm] config.yml配置文件加载完毕！");

    }
}
